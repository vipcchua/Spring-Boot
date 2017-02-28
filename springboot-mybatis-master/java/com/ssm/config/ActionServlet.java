package com.ssm.config;


/*
 * ****************<--*---Code information---*-->**************
 * 	
 *		Author: Cchua
 *		GitHub: https://github.com/vipcchua
 *		Blog  : weibo.com/vipcchua
 * 
 * 
 * ************************************************************/



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //保证正确读取Post提交来的中文
        request.setCharacterEncoding("UTF-8");
        //保证正确输出中文
        response.setContentType("text/html;charset=UTF-8");
        //获取uri,并截取action动作
        String uri=request.getRequestURI();
        String action=uri.substring(uri.lastIndexOf("/")+1,
                uri.lastIndexOf("."));
        //获取session
        //HttpSession session=request.getSession();
        //System.out.println(session.getId());
        //设定session超时时间为10秒
        //session.setMaxInactiveInterval(10);
        //判断动作是否为登录
        if(action.equals("login")){
            String name=request.getParameter("uname");
            String pwd=request.getParameter("pwd");
            String number=request.getParameter("vcode");
            HttpSession session=request.getSession();
            //要求大小写一致
            String code = (String)session.getAttribute("code").toString();
            if(number.equals(code)&&name.equals("111")&&pwd.equals("111")){
                //绑定数据
                session.setAttribute("uname", name);
                //重定向到首页
                //response.sendRedirect("index.jsp");
                //使用URL重写的方法，改写原本的访问地址
                response.sendRedirect(
                        response.encodeRedirectURL("index.html"));
            }else{
                //登录失败
                request.setAttribute("msg", "用户名或密码错误");
                request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
            }
        }else if(action.equals("logout")){
            HttpSession session=request.getSession();
            //session失效
            session.invalidate();
            response.sendRedirect("login.html");
        }

        PrintWriter out = response.getWriter();
        out.close();
    }

}
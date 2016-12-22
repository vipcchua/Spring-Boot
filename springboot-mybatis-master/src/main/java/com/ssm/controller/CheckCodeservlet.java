package com.ssm.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeservlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 获取请求参数：CHECK_CODE_PARAM_NAME

        String checkCodeFromForm = request
                .getParameter("CHECK_CODE_PARAM_CODE");

        // 获取session的CHECK_CODE_KEY
        String checkCodeFromSession = (String) request.getSession()
                .getAttribute("CHECK_CODE_KEY");
        System.out.println("用户提交的---" + checkCodeFromForm);
        System.out.println("session中的---" + checkCodeFromSession);
        // 验证
        if (checkCodeFromForm != null
                & checkCodeFromForm.equals(checkCodeFromSession)) {
            // 合法 ，处理请求
            System.out.println("处理请求....");
        } else {
            // 不合法,返回页面，提示验证码错误
            request.getSession().setAttribute("message", "验证码错误");
            response.sendRedirect(request.getContextPath()
                    + "/checkCode/index.jsp");
        }
    }
}
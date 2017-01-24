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
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssm.currency.RSAUtil;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    /**
     * 生成公私钥，公钥发到jsp
     * 
     * @param request
     */
    public void makeKV(HttpServletRequest request) {
        try {
            KeyPair kp = RSAUtil.generateKeyPair();
            RSAPublicKey rsap = (RSAPublicKey) kp.getPublic();
            String module = rsap.getModulus().toString(16);
            String empoent = rsap.getPublicExponent().toString(16);

            // 私钥存入session
            HttpSession hs = request.getSession();
            hs.setAttribute("privKey", kp.getPrivate());

            System.out.println("module:" + module);
            System.out.println("empoent:" + empoent);
            request.setAttribute("m", module);
            request.setAttribute("e", empoent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get 请求页面，只初始化公私钥
        makeKV(request);

        request.getRequestDispatcher("/login").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // post 提交登录参数
        try {

            // 送session中获取私钥
            HttpSession hs = request.getSession();
            RSAPrivateKey privKey = (RSAPrivateKey) hs.getAttribute("privKey");

            // 解密
            String pwd = request.getParameter("pwd");
            byte[] en_result = new BigInteger(pwd, 16).toByteArray();
            byte[] de_result = RSAUtil.decrypt(privKey, en_result);

            StringBuffer sb = new StringBuffer();
            sb.append(new String(de_result));
            pwd = sb.reverse().toString();

            // 因为前台js已经把密码生成md5，所以此处解密后只是活动md5
            // 需注意几点，如果前台js加密的内容有中文，解密会有异常，需把中文用别的方式encode
            System.out.println("密码的pwd(md5):" + pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        makeKV(request);

        request.getRequestDispatcher("/login").forward(request, response);
    }

}

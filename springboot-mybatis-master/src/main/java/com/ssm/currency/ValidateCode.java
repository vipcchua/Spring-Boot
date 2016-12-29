package com.ssm.currency;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCode extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //0.创建空白图片
        BufferedImage image=new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
        //1.获取图片画笔
        Graphics g = image.getGraphics();
        Random r=new Random();
        //2.设置画笔颜色(Random类中的nextInt(n)返回一个大于等于0，小于n的随机数)
        g.setColor(new Color(r.nextInt(255),r.nextInt(255), r.nextInt(255)));
        //3.绘制矩形的背景
        g.fillRect(0, 0, 100, 30);
        //4.调用自定义的方法，获取长度为5的字母数字组合的字符串
        String number=getNumber(5);
        HttpSession session=request.getSession();
        session.setAttribute("code", number);
        g.setColor(new Color(0,0,0));
        g.setFont(new Font(null,Font.BOLD,24));
        //5.设置颜色字体后，绘制字符串（x/y,最左边字符所处的位置）
        g.drawString(number, 8, 24);
        //6.绘制8条干扰线(alpha表示透明度)
        for(int i=0;i<8;i++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255), r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
        }
        response.setContentType("image/jpeg");
        OutputStream ops = response.getOutputStream();
        ImageIO.write(image, "jpeg", ops);
        ops.close();
    }
    //自定义方法，获取长度为5的字母数字组合的字符串
    private String getNumber(int size){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String number="";
        Random r=new Random();
        for(int i=0;i<size;i++){
            number+=str.charAt(r.nextInt(str.length()));
        }
        return number;
    }

}
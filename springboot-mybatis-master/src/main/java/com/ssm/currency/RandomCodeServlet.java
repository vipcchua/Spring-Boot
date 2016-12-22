package com.ssm.currency;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomCodeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int randomNumber = 5;
		// 图片宽度
		int width = 100;
		// 图片高度
		int height = 35;
		// 创建随机码
		char[] ranlist = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
				.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random randomer = new Random();
		for (int i = 0; i < randomNumber; i++) {
			sb.append(ranlist[randomer.nextInt(ranlist.length)]);
		}
		// 保存到session中
		HttpSession session = req.getSession();
		session.setAttribute("RANDOM_IN_SESSION", sb.toString());

		// 画画
		// 创建一个图片对象
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		// 得到图片对象对应的绘画缓存,绘画都在Graphics对象上
		Graphics g = image.getGraphics();

		// 绘制背景
		g.setColor(Color.WHITE);
		// 填充矩形
		g.fillRect(0, 0, width, height);
		// 绘制边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		// 绘制文字
		g.setColor(Color.GRAY);
		g.setFont(new Font("宋体", Font.ITALIC, 24));
		g.drawString(sb.toString(), 13, height - 9);

		//绘制干扰点
		for (int i = 0; i < 300; i++) {
			g.fillRect(randomer.nextInt(width - 1),
					randomer.nextInt(height - 1), 1, 1);
		}
		// 关闭绘画资源
		g.dispose();

		//清除图片缓存：IE7  firefox验证码没有反应问题
		//设定网页的到期时间，一旦过期则必须到服务器上重新调用
		resp.setDateHeader("Expires",-1);
		//Cache-Control指定请求和响应遵循的缓存机制   no-cache指示请求或响应消息不能缓存
		resp.setHeader("Cache-Control","no-cache");
		//是用于设定禁止浏览器从本地机的缓存中调阅页面内容，设定后一旦离开网页就无法从Cache中再调出
		resp.setHeader("Pragma","no-cache");
		
		// 输出
		ImageIO.write(image, "JPG", resp.getOutputStream());
	}

}
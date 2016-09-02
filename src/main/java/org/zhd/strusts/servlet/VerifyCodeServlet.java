package org.zhd.strusts.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zhd.strusts.util.GenVerifyCodeUtil;

public class VerifyCodeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GenVerifyCodeUtil util = new GenVerifyCodeUtil(120, 40, 4, "Times New Roman");
		
		BufferedImage image = util.genVerifyCodeImage();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("randVerifyCode", util.randVerifyCode.toLowerCase());
        session.setAttribute("expireVerifyCode", (long)(System.currentTimeMillis()/1000)+GenVerifyCodeUtil.VerifyCode_ExpireSeconds);
		
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
		try {
			ServletOutputStream out = response.getOutputStream();
	        ImageIO.write(image, "JPEG", out);
	        out.flush();
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

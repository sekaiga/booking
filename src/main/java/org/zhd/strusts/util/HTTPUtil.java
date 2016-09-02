package org.zhd.strusts.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HTTPUtil {
	public static void sendResponse(HttpServletResponse response,String str){
		 response.setContentType("text/json; charset=utf-8");
		 PrintWriter out;
		 try {
			out = response.getWriter();
			out.write(str.toString());
			out.flush();
			out.close();
		 } catch (IOException e) {
			e.printStackTrace();
		 }		 
	}
}

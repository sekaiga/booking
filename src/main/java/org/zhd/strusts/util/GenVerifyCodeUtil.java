package org.zhd.strusts.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class GenVerifyCodeUtil {

	private int imgWidth = 120;
	private int imgHeight = 40;
    private int codeCount = 4;
    private String fontStyle = "Times New Roman";
 
    private int x = 0;
    private int fontHeight;
    private int codeY;
 
    public String randVerifyCode = "";
    
    public static final long VerifyCode_ExpireSeconds = 60;
    
    public GenVerifyCodeUtil() {
    	super();
		init();
    }
    
    public GenVerifyCodeUtil(int imgWidth, int imgHeight, int codeCount, String fontStyle) {
		super();
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.codeCount = codeCount;
		this.fontStyle = fontStyle;
		init();
	}

    public GenVerifyCodeUtil(HttpServlet servlet) throws ServletException {
        // read params from web.xml
        String strWidth = servlet.getInitParameter("imgWidth");
        String strHeight = servlet.getInitParameter("imgHeight");
        String strCodeCount = servlet.getInitParameter("codeCount");
        String strFontStyle = servlet.getInitParameter("fontStyle");
        if (strFontStyle != null && !strFontStyle.isEmpty()) fontStyle = strFontStyle;
 
        try {
            if (strWidth != null && strWidth.length() != 0) {
                imgWidth = Integer.parseInt(strWidth);
            }
            if (strHeight != null && strHeight.length() != 0) {
                imgHeight = Integer.parseInt(strHeight);
            }
            if (strCodeCount != null && strCodeCount.length() != 0) {
                codeCount = Integer.parseInt(strCodeCount);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
		init();
    }
    
    private void init() {
        x = imgWidth / (codeCount + 1);
        fontHeight = imgHeight - 2;
        codeY = imgHeight - 12;
    }

    public BufferedImage genVerifyCodeImage() {
    	System.setProperty("java.awt.headless","true");
    	
        BufferedImage image = new BufferedImage(imgWidth, imgHeight,
                BufferedImage.TYPE_INT_RGB);
 
        Graphics2D g = image.createGraphics();
 
        Random random = new Random();
 
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, imgWidth, imgHeight);
 
        g.setFont(new Font(fontStyle, Font.PLAIN + Font.ITALIC, fontHeight));
 
        g.setColor(new Color(55, 55, 12));
        g.drawRect(0, 0, imgWidth - 1, imgHeight - 1);
 
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 160; i++) {
            int x = random.nextInt(imgWidth);
            int y = random.nextInt(imgHeight);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
 
        String sRand = "";
        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < codeCount; i++) {
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            int wordType = random.nextInt(3);
            char retWord = 0;
            switch (wordType) {
            case 0:
                retWord = this.getSingleNumberChar();
                break;
            case 1:
                retWord = this.getLowerOrUpperChar(0);
                break;
            case 2:
                retWord = this.getLowerOrUpperChar(1);
                break;
            }
            sRand += String.valueOf(retWord);
            g.setColor(new Color(red, green, blue));
            g.drawString(String.valueOf(retWord), (i) * x, codeY);
 
        }
        g.dispose();
        randVerifyCode = sRand;
        
        return image;
    }
    
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
 
    private char getSingleNumberChar() {
        Random random = new Random();
        int numberResult = random.nextInt(10);
        int ret = numberResult + 48;
        return (char) ret;
    }
 
    private char getLowerOrUpperChar(int upper) {
        Random random = new Random();
        int numberResult = random.nextInt(26);
        int ret = 0;
        if (upper == 0) {// 小写
            ret = numberResult + 97;
        } else if (upper == 1) {// 大写
            ret = numberResult + 65;
        }
        return (char) ret;
    }

	public String getRandVerifyCode() {
		return randVerifyCode;
	}
}

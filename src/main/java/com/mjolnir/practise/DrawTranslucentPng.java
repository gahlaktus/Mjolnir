package com.mjolnir.practise;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static java.lang.Math.random;

/**
 * @author huangzhibo
 * @date 2018/8/13
 */
public class DrawTranslucentPng {

    public static BufferedImage drawTranslucentStringPic(int width, int height, Integer fontHeight){


        try {
            BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D gd = buffImg.createGraphics();
            //设置透明  start
            buffImg = gd.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
            gd=buffImg.createGraphics();
            //设置透明  end
            gd.setFont(new Font("微软雅黑", Font.PLAIN, fontHeight)); //设置字体
            //gd.setColor(Color.ORANGE); //设置颜色
            //gd.drawRect(0, 0, width - 1, height - 1); //画边框
//            gd.drawString(drawStr, width/2-fontHeight*drawStr.length()/2,fontHeight); //输出文字（中文横向居中）
            //验证码，由2个一位数的加减两种运算法构成
            Random random = new Random();
            int num1 = (int) (random() * 100) + 1;
            int num2 = (int) (random() * 10) + 1;
            int funNo = random.nextInt(2);
            String funMethod = "";
            int result = 0;
            switch (funNo) {
                case 0:
                    funMethod = "+";
                    result = num1 + num2;
                    break;
                case 1:
                    funMethod = "-";
                    result = (num1 - num2) > 0 ? (num1 - num2) : (num2 - num1);
                    break;
                default:
                    break;
            }

            String calc = Objects.equals(funMethod, "-") ? ((num1 - num2) > 0 ? (num1 + funMethod + num2 + "=?") : (num2 + funMethod + num1 + "=?")) : (num1 + funMethod + num2 + "=?");
            gd.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

            FontRenderContext context = gd.getFontRenderContext();
            Rectangle2D bounds = (new Font("微软雅黑", Font.PLAIN, fontHeight)).getStringBounds(calc, context);
            double x = (width - bounds.getWidth()) / 2;
            double y = (height - bounds.getHeight()) / 2;
            double ascent = -bounds.getY();
            double baseY = y + ascent;

            gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            gd.drawString(calc, (int) x, (int) baseY);

            gd.dispose();
            return buffImg;
        } catch (Exception e){
            return null;
        }

    }

    public static void main(String[] args)
    {
        BufferedImage imgMap = drawTranslucentStringPic(400, 80, 36);
        File imgFile=new File("/Users/huangzhibo/Canola/Mjolnir/static/test.png");
        try
        {
            ImageIO.write(imgMap, "PNG", imgFile);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        BufferedImage imgMap1 = drawTranslucentStringPic(200, 60, 36);
        File imgFile1=new File("/Users/huangzhibo/Canola/Mjolnir/static/test1.png");
        try
        {
            ImageIO.write(imgMap1, "PNG", imgFile1);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        BufferedImage imgMap2 = drawTranslucentStringPic(84, 30, 16);
        File imgFile2=new File("/Users/huangzhibo/Canola/Mjolnir/static/test2.png");
        try
        {
            ImageIO.write(imgMap2, "PNG", imgFile2);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("生成完成");
    }
}

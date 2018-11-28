package com.mjolnir.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 1. URL管理
 * 2. 网页下载器
 * 3. 爬虫调度器
 * 4. 网页解析器
 * 5. 数据处理器
 * @author huangzhibo
 * @date 18/01/2018
 */
public class Reptile {

    public static void main(String[] args) {

        String url1 = "";

        InputStream is = null;

        BufferedReader br = null;

        StringBuffer html = new StringBuffer();

        String temp = "";

        try {

            URL url2 = new URL(url1);

            is = url2.openStream();

            br = new BufferedReader(new InputStreamReader(is));

            while ((temp = br.readLine()) != null){
                html.append(temp);
            }

            if (is != null){
                is.close();
                is = null;
            }

            Document doc = Jsoup.parse(html.toString());
            Elements elements = doc.getElementsByClass("XX");
            for (Element element : elements){
                System.out.println(element.text());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

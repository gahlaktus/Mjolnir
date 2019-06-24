package com.stark.utils;

import java.io.*;

/**
 * @author huangzhibo
 * @date 2019/6/21
 */
public class ReadTxtUtils {

    public static void readFile(String pathName) {
        try (FileReader reader = new FileReader(pathName);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String content, String targetPath) {
        try {
            File writeName = new File(targetPath);
            if (writeName.exists() || writeName.createNewFile()) {
                try (FileWriter writer = new FileWriter(writeName);
                     BufferedWriter out = new BufferedWriter(writer)
                ) {
                    // \r\n即为换行
                    out.write(content);
                    out.write("\r\n");
                    // 把缓存区内容压入文件
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile1(String pathName) {
        try (FileReader reader = new FileReader(pathName);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] strArr = line.split("\\s+");
                if (strArr[0] != null && strArr[0].length() == 4) {
                    //System.out.println("[bankId] - " + strArr[0] + " - [银行名称] - " + strArr[1]);

                    StringBuilder sb = new StringBuilder("INSERT INTO `ph_data_dictionary` (`type`, `name`, `value`, `sort`, `desc`, `create_time`, `update_time`, `delete_flag`) VALUES ('");
                    sb.append("120',")
                            .append("'").append(strArr[1]).append("',")
                            .append("'").append(strArr[0]).append("',")
                            .append("null").append(",")
                            .append("'bankId与银行名称映射关系',")
                            .append("now()").append(",")
                            .append("now()").append(",")
                            .append("'0'").append(")").append(";");

                    System.out.println(sb.toString());

                    String targetPath = "/Users/huangzhibo/Canola/Mjolnir/src/main/java/com/stark/utils/sql0621.txt";
                    writeFile(sb.toString(), targetPath);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteFile(String pathName, String targetPath) {
        try (FileReader reader = new FileReader(pathName);
             BufferedReader br = new BufferedReader(reader);
             FileWriter writer = new FileWriter(targetPath);
             BufferedWriter out = new BufferedWriter(writer)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] strArr = line.split("\\s+");
                if (strArr[0] != null && strArr[0].length() == 4) {
                    StringBuilder sb = new StringBuilder("INSERT INTO `ph_data_dictionary` (`type`, `name`, `value`, `sort`, `desc`, `create_time`, `update_time`, `delete_flag`) VALUES ('");
                    sb.append("120',")
                            .append("'").append(strArr[0]).append("',")
                            .append("'").append(strArr[1]).append("',")
                            .append("null").append(",")
                            .append("'bankId与银行名称映射关系',")
                            .append("now()").append(",")
                            .append("now()").append(",")
                            .append("'0'").append(")").append(";");
                    String sqlStr = sb.toString();
                    System.out.println(sqlStr);

                    // \r\n即为换行
                    out.write(sqlStr);
                    out.write("\r\n");
                }
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pathName = "/Users/huangzhibo/Canola/Mjolnir/src/main/java/com/stark/utils/bankIdDic0621.txt";
        String targetPath = "/Users/huangzhibo/Canola/Mjolnir/src/main/java/com/stark/utils/sql0621.txt";
        readAndWriteFile(pathName, targetPath);
    }

}

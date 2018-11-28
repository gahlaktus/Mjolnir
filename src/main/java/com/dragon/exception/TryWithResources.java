package main.java.com.exception;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author huangzhibo
 * @date 20/06/2017
 */
public class TryWithResources {

    /**
     * The try-with-resources Statement
     * try-with-resources 语句会确保在try语句结束时关闭所有资源。
     * 实现了java.lang.AutoCloseable或java.io.Closeable的对象都可以做为资源。
     *
     * @param path
     * @return
     * @throws IOException
     */
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
    }

    public static void writeToFileZipFileContents(String zipfileName, String outputFileName) throws java.io.IOException {

        Charset charset = StandardCharsets.US_ASCII;
        Path outputFilePath = Paths.get(outputFileName);

        try (ZipFile zf = new ZipFile(zipfileName);
             BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset)) {

            // Open zip file and create output file with
            // try-with-resources statement

            for (Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {

                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

    public static void viewTable(Connection connection) throws SQLException {
        String query = "SELECT COF_NAME, SUP_ID, PRICE, SALES, TOTAL FROM COFFEES";

        try (Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                String coffeeName = rs.getString("COF_NAME");
                int supplierId = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");

                System.out.println(coffeeName+", "+supplierId+", "+price+", "+sales+", "+total);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

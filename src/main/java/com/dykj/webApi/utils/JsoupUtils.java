package com.dykj.webApi.utils;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.Map;

/**
 * jsoup相关操作工具类
 * @author DELL
 */
@Slf4j
public class JsoupUtils {

    /**
     * 根据请求地址返回json格式的响应结果
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String jsonStr(String url) throws IOException {

        String body = null;
        try {
            Connection.Response res = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(10000).ignoreContentType(true).execute();
            body = res.body();
        } catch (HttpStatusException e) {
            dataException(url);
        }

        return body;
    }

    /**
     * 根据请求地址返回json格式的响应结果
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String jsonStr(String url, String json) throws IOException {

        String body = null;
        try {
            Connection.Response res = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(500000).requestBody(json).method(Connection.Method.POST).ignoreContentType(true).execute();
            body = res.body();
        } catch (HttpStatusException e) {
            e.printStackTrace();
            dataException(url);
        }

        return body;
    }

    /**
     * 根据请求地址返回json格式的响应结果,带token
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String jsonStr(String url, String json,String token) throws IOException {

        String body = null;
        try {
            Connection.Response res = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Authorization",token)
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(500000).requestBody(json).method(Connection.Method.POST).ignoreContentType(true).execute();
            body = res.body();
        } catch (HttpStatusException e) {
            e.printStackTrace();
            dataException(url);
        }

        return body;
    }

    public static String jsonStr(String url, Map map) throws IOException {

        String body = null;
        try {
            Connection.Response res = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(10000).data(map).method(Connection.Method.POST).ignoreContentType(true).execute();
            body = res.body();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        }

        return body;
    }


    public static String upFile(String url, MultipartFile file) throws IOException {
        String body = null;
        try {
            InputStream inputStream = new FileInputStream(transferToFile(file));
            Connection.Response res = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    //.header("Content-Type", "multipart/form-data")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(10000)
                    .data("file", "file", inputStream)
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute();

            body = res.body();
        } catch (HttpStatusException e) {
            e.printStackTrace();
            dataException(url);
        }
        return body;
    }

    public static File transferToFile(MultipartFile multipartFile) {
        //选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            //获取文件后缀
            String prefix = originalFilename.substring(originalFilename.lastIndexOf("."));
            file = File.createTempFile(originalFilename, prefix);
            multipartFile.transferTo(file);
            //删除
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static InputStream mulToInput(MultipartFile file) throws IOException {
        byte[] byteArr = file.getBytes();
        InputStream inputStream = new ByteArrayInputStream(byteArr);
        return inputStream;
    }

    public static void dataException(String url) throws IOException {
        Connection conn = Jsoup.connect(url);
        Connection.Request req = conn.request();
        HttpURLConnection con = (HttpURLConnection) (req.proxy() == null ? req.url().openConnection() : req.url().openConnection(req.proxy()));

        int status = con.getResponseCode();

        log.debug("状态码：" + status);
    }
}

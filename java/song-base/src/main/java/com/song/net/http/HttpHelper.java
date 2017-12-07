package com.song.net.http;import com.song.io.FileHelper;import com.song.lang.StringHelper;import java.io.IOException;import java.nio.file.Files;import java.nio.file.Path;import java.nio.file.Paths;/** * Created by song on 2017/9/22. */public class HttpHelper {    public static final String DEFAULTCONTENTTYPE = "application/octet-stream";    /**     * 获取useragent     * @param isMobile     * @return     */    public static String getUserAgent(boolean isMobile) {        if (isMobile) {            return "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";        }        return "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36";    }    public static String getUserAgent() {        return getUserAgent(false);    }    /**     * 下载远程文件到本地目录     *     * @param url          下载的url地址     * @param saveFilePath 下载的文件路径（包含文件名）     */    public static void download(String url, String saveFilePath) throws IOException {        HttpConnection connection = new HttpConnection(url);        FileHelper.write(connection.getBytes(), saveFilePath);    }    /**     * 下载远程文件到本地目录     * @param url     * @param savePath     * @param saveName     * @throws IOException     */    public static void download(String url, String savePath, String saveName) throws IOException {        HttpConnection connection = new HttpConnection(url);        FileHelper.write(connection.getBytes(), savePath, saveName);    }    /**     * 根据文件路径获取文件的ContentType     * @param filePath     * @return     */    public static String getContentType(String filePath) {        Path path = Paths.get(filePath);        String contentType = null;        try {            contentType= Files.probeContentType(path);        } catch (IOException e) {            e.printStackTrace();        }        if (StringHelper.isEmpty(contentType)) {            contentType= DEFAULTCONTENTTYPE;        }        return contentType;    }}
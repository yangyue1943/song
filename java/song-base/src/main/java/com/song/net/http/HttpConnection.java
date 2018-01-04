package com.song.net.http;import com.song.io.StreamHelper;import com.song.lang.ByteHelper;import com.song.lang.StringHelper;import com.song.util.MapHelper;import java.io.DataOutputStream;import java.io.IOException;import java.net.HttpURLConnection;import java.net.URL;import java.util.HashMap;/** * description:     HttpConnection * author:          song * createDate:      2017/9/25 */public class HttpConnection {    protected HashMap<String, String> params = new HashMap<String, String>();    private String url;    private String contentType = "application/x-www-form-urlencoded";    private String userAgent = HttpHelper.getUserAgent();    public HttpConnection(String url) {        this.url = url;    }    public void setUrl(String url) {        this.url = url;    }    public void setContentType(String contentType) {        this.contentType = contentType;    }    public void setUserAgent(String userAgent) {        this.userAgent = userAgent;    }    public HttpConnection addParamter(String key, String value) {        params.put(key, value);        return this;    }    public HttpConnection addParamter(String key, Boolean value) {        params.put(key, value.toString());        return this;    }    public HttpConnection addParamter(String key, Number value) {        params.put(key, value.toString());        return this;    }    protected byte[] getBytes(String method) throws IOException {        URL u = new URL(url);        HttpURLConnection connection = null;        try {            connection = (HttpURLConnection) u.openConnection();            connection.setDoInput(true);            if (!StringHelper.isEmpty(method)) {                connection.setRequestMethod(method);            }            connection.setUseCaches(false);            if (!StringHelper.isEmpty(contentType)) {                connection.setRequestProperty("Content-type", contentType);            }            connection.setRequestProperty("Connection", "Keep-Alive");            connection.setRequestProperty("User-Agent", userAgent);            connection.setConnectTimeout(30000);            connection.setReadTimeout(30000);            connection.connect();            write(connection);            //判断是否链接成功            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {                //读取响应流                return StreamHelper.getBytes(connection.getInputStream());            } else {                return null;            }        } finally {            if (connection != null) {                connection.disconnect();                connection = null;            }        }    }    protected void write(HttpURLConnection connection) throws IOException {        //设置请求参数        if (params.size() > 0) {            connection.setDoOutput(true);            byte[] bytes = StringHelper.getBytes(MapHelper.toUrlParamter(params));            StreamHelper.write(connection.getOutputStream(), bytes);        }    }    public byte[] getBytes() throws IOException {        return getBytes(null);    }    public byte[] doGet() throws IOException {        return getBytes("GET");    }    public String doGet(String charset) throws IOException {        return ByteHelper.toString(doGet(), charset);    }    public byte[] doPost() throws IOException {        return getBytes("POST");    }    public String doPost(String charset) throws IOException {        return ByteHelper.toString(doPost(), charset);    }}
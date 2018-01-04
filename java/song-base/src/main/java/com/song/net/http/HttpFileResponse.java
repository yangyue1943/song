package com.song.net.http;import com.song.lang.StringHelper;import com.song.net.UrlHelper;import javax.servlet.http.HttpServletResponse;import java.io.File;import java.io.IOException;/** * description: * author:          song * createDate:      2017/9/27 */public class HttpFileResponse extends HttpResponse {    public HttpFileResponse(HttpServletResponse response) {        super(response);    }    protected void setAttachment(String fileName, long fileSize) {        response.reset();        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);        if (fileSize > 0) {            response.addHeader("Content-Length", fileSize + "");        }        response.setContentType(HttpHelper.DEFAULTCONTENTTYPE);    }    protected void setAttachment(String fileName) {        setAttachment(fileName, 0);    }    /**     * 将本地文件写入到输出流     *     * @param filePath     * @param downloadFileName     * @throws IOException     */    public void localFile(String filePath, String downloadFileName) throws IOException {        File file = new File(filePath);        this.setAttachment(downloadFileName, file.length());        this.writeFile(filePath);    }    /**     * 将本地文件写入到输出流     *     * @param filePath     * @throws IOException     */    public void localFile(String filePath) throws IOException {        File file = new File(filePath);        this.setAttachment(file.getName(), file.length());        this.writeFile(filePath);    }    /**     * 下载远程文件并写入到输出流     *     * @param url     * @param downloadFileName     * @throws IOException     */    public void remoteFile(String url, String downloadFileName) throws IOException {        HttpConnection connection = new HttpConnection(url);        byte[] bytes = connection.getBytes();        if (StringHelper.isEmpty(downloadFileName)) {            downloadFileName = UrlHelper.getFileName(url);        }        this.setAttachment(downloadFileName, bytes.length);        this.write(bytes);    }    /**     * 下载远程文件并写入到输出流     *     * @param url     * @throws IOException     */    public void remoteFile(String url) throws IOException {        remoteFile(url, null);    }    /**     * 将字符串内容写入输出流     *     * @param content     * @param downloadFileName     * @throws IOException     */    public void contentFile(String content, String downloadFileName) throws IOException {        byte[] bytes = StringHelper.getBytes(content);        this.setAttachment(downloadFileName, bytes.length);        this.write(bytes);    }}
package com.song.io;import com.song.lang.ByteHelper;import com.song.lang.StringHelper;import com.song.util.UUIDHelper;import java.io.*;/** * description:     FileHelper * author:          song * createDate:      2017/9/27 */public class FileHelper {    /**     * 保存文件     *     * @param bytes        内容     * @param saveFilePath 保存的文件目录     * @throws IOException     */    public static void write(byte[] bytes, String saveFilePath) throws IOException {        if (!ByteHelper.isEmpty(bytes)) {            mkdirsParent(saveFilePath);            OutputStream stream = new FileOutputStream(saveFilePath);            StreamHelper.write(stream, bytes);        }    }    /**     * 保存文件     *     * @param bytes    内容     * @param savePath 保存的文件目录     * @param saveName 保存的文件名     * @throws IOException     */    public static void write(byte[] bytes, String savePath, String saveName) throws IOException {        String saveFileName = PathHelper.combine(savePath, saveName);        write(bytes, saveFileName);    }    /**     * 保存文件     *     * @param s     * @param saveFilePath 保存的文件路径     * @throws IOException     */    public static void write(String s, String saveFilePath) throws IOException {        write(StringHelper.getBytes(s), saveFilePath);    }    /**     * 保存文件     *     * @param s     * @param savePath 保存文件目录     * @param saveName 保存的文件名     * @throws IOException     */    public static void write(String s, String savePath, String saveName) throws IOException {        write(StringHelper.getBytes(s), savePath, saveName);    }    /**     * 创建目录（只接受文件夹路径，不接受文件路径）     *     * @param filePath 文件路径     */    public static void mkdirs(String filePath) {        File file = new File(filePath);        file.mkdirs();    }    /**     * 创建目录（接受文件路径）     *     * @param filePath     */    public static void mkdirsParent(String filePath) {        File file = new File(filePath);        file.getParentFile().mkdirs();    }    /**     * 根据文件HashCode动态创建目录     *     * @param rootFilePath     * @param fileName     * @return     */    public static String getHashFilePath(String rootFilePath, String fileName) {        int hashcode = fileName.hashCode();        int dir1 = hashcode & 0xf;        int dir2 = (hashcode & 0xf0) >> 4;        //构造新的保存目录        String dir = PathHelper.combine(rootFilePath, dir1 + "", dir2 + "");        mkdirs(dir);        return dir;    }    /**     * 如果文件不存在则创建一个新的空文件     *     * @param filePath 文件路径     * @return 创建是否成功     * @throws IOException     */    public static boolean createNewFile(String filePath) throws IOException {        File file = new File(filePath);        return createNewFile(file);    }    /**     * 如果文件不存在则创建一个新的空文件     *     * @param file 文件对象     * @return 创建是否成功     * @throws IOException     */    public static boolean createNewFile(File file) throws IOException {        if (file.exists()) {            return true;        }        return file.createNewFile();    }    /**     * 删除文件     *     * @param filePath 文件路径     * @return     */    public static boolean delete(String filePath) {        File file = new File(filePath);        return delete(file);    }    /**     * 删除文件     *     * @param file 文件对象     * @return     */    public static boolean delete(File file) {        if (file.exists()) {            return file.delete();        }        return true;    }    /**     * 读取文件为byte[]     *     * @param filePath 文件路径     * @return     * @throws IOException     */    public static byte[] getBytes(String filePath) throws IOException {        FileInputStream stream = new FileInputStream(filePath);        return StreamHelper.getBytes(stream);    }    /**     * 读取文件为String     *     * @param filePath 文件路径     * @return     * @throws IOException     */    public static String getString(String filePath) throws IOException {        return ByteHelper.toString(getBytes(filePath));    }    /**     * 获取新文件名     *     * @param fileName     * @return     */    public static String getNewFileName(String fileName) {        String name = UUIDHelper.next();        return name + getExtension(fileName);    }    /**     * 获取文件后缀名（带分隔符）     *     * @param fileName     * @return     */    public static String getExtension(String fileName) {        return fileName.substring(fileName.lastIndexOf("."));    }    /**     * 获取文件后缀名（不带分隔符）     *     * @param fileName     * @return     */    public static String getExtensionName(String fileName) {        return fileName.substring(fileName.lastIndexOf(".") + 1);    }    /**     * 检测文件是否存在     *     * @param filePath     * @return     */    public static boolean exists(String filePath) {        File file = new File(filePath);        return file.exists();    }    /**     * 获取文件路径的文件夹地址     *     * @param filePath     * @return     */    public static String getPath(String filePath) {        File file = new File(filePath);        if (file.isFile()) {            return file.getPath();        }        return filePath;    }    /**     * 根据文件路径获取文件名     *     * @param filePath     * @return     */    public static String getFileName(String filePath) {        return filePath.substring(filePath.lastIndexOf(File.separator) + 1);    }}
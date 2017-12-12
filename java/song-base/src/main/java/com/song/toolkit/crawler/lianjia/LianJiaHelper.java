package com.song.toolkit.crawler.lianjia;import com.song.lang.StringHelper;import java.lang.reflect.Array;/** * description: * author:          song * createDate:      2017/12/12 */public class LianJiaHelper {    /**     * 解析单价     *     * @param content     * @return     */    public static String parseUnitPrice(String content) {        if (!StringHelper.isEmpty(content)) {            return StringHelper.replaceAll(content, "", "元/平米", "单价");        }        return null;    }    /**     * 解析房子基本信息     *     * @param content     * @return     */    public static String[] parseHouseInfo(String content) {        if (!StringHelper.isEmpty(content)) {            return content.split("\\|");        }        return null;    }    /**     * 解析地铁信息     *     * @param content     * @return     */    public static String[] parseSubway(String content) {        if (!StringHelper.isEmpty(content) && content.contains("号线")) {            String[] result = new String[3];            content = content.replace("距离", "");            result[0] = content.substring(0, content.indexOf("号"));            content = StringHelper.trimStart(content, result[0] + "号线");            result[1] = content.substring(0, content.lastIndexOf("站"));            content = StringHelper.trimStart(content, result[1] + "站");            result[2] = content.replace("米", "");            return result;        }        return null;    }    /**     * 解析楼层和建造信息     *     * @param content     * @return     */    public static String[] parseBuildInfo(String content) {        if (!StringHelper.isEmpty(content)) {            String[] result = new String[4];            result[0] = content.substring(0, content.indexOf("("));            content = StringHelper.trimStart(content, result[0] + "(共");            result[1] = content.substring(0, content.indexOf("层"));            content = StringHelper.trimStart(content, result[1] + "层)");            int yearIndex = content.indexOf("年");            result[2] = yearIndex > -1 ? content.substring(0, yearIndex) : null;            content = StringHelper.trimStart(content, content.substring(0, content.indexOf("-") + 1));            result[3] = content.trim();            return result;        }        return null;    }    /**     * 解析看房人数和发布信息     *     * @param content     * @return     */    public static String[] parseFollowInfo(String content) {        if (!StringHelper.isEmpty(content)) {            String[] result = content.split("/");            result[0] = result[0].trim().replace("人关注", "");            result[1] = result[1].trim().replace("共", "").replace("次带看", "");            result[2] = result[2].trim().replace("以前发布", "");            return result;        }        return null;    }    public static void main(String[] args) {        String s = "距离1号线友谊路站737米";        String[] result = parseSubway(s);        System.out.println(result[0] + "-" + result[1] + "-" + result[2]);        String s1 = "低楼层(共33层)2010年建塔楼  -  湘江世纪城";        String[] result1 = parseBuildInfo(s1);        System.out.println(result1[0] + "-" + result1[1] + "-" + result1[2] + "-" + result1[3]);        String s2 = "14人关注 / 共3次带看 / 6个月以前发布";        String[] result2 = parseFollowInfo(s2);        System.out.println(result2[0] + "-" + result2[1] + "-" + result2[2]);    }}
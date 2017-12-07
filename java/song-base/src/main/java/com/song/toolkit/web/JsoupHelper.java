package com.song.toolkit.web;import com.song.lang.StringHelper;import org.jsoup.nodes.Element;import org.jsoup.select.Elements;/** * description: * author:          song * createDate:      2017/10/17 */public class JsoupHelper {    public static boolean isEmpty(Elements elements) {        if(elements==null || elements.size()==0){            return true;        }        return false;    }    public static String text(Element element) {        if(element!=null){            return element.text();        }        return StringHelper.getEmpty();    }    public static String attr(Element element, String attrKey) {        if(element==null){            return StringHelper.getEmpty();        }        return element.attr(attrKey);    }}
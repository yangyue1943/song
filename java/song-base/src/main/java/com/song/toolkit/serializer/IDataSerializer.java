package com.song.toolkit.serializer;import java.util.List;/** * description: * author:          song * createDate:      2017/10/19 */public interface IDataSerializer {    String toString(Object object);    <T> T parseObject(String s, Class<T> tClass);    <T> List<T> parseArray(String s, Class<T> tClass);}
package com.song.cache;/** * description: * author:          song * createDate:      2017/10/21 */public interface ICache {    void set(String key, Object value, long expireTime);    void set(String key, Object value);    Object get(String key);    void remove(String key);    void clear();    boolean contains(String key);}
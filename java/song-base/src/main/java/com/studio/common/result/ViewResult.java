package com.studio.common.result;import com.song.net.http.HttpResult;/** * description:     Ajax通用返回类 * author:          song * createDate:      2018/1/8 */public class ViewResult extends HttpResult {    private Object data;    public Object getData() {        return data;    }    public void setData(Object data) {        this.data = data;    }}
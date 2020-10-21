package com.foxc.movie.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class JsonVO extends JSONObject implements Serializable {

    public void setCode(Integer code){
        this.put("code", code);
    }

    public void setMsg(String msg){
        this.put("msg", msg);
    }

    public int getCode(){
        return this.getInteger("code");
    }

    public String getMsg(){
        return this.getString("msg");
    }
}

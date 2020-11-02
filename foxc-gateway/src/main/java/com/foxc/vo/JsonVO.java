package com.foxc.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class JsonVO extends JSONObject implements Serializable {

    public JsonVO(Boolean isSuccess, Integer code, String msg){
        this.put("isSuccess",isSuccess);
        this.put("code",code);
        this.put("msg",msg);
    }

    public JsonVO(){}

    public JsonVO setSuccess(){
        this.put("isSuccess",true);
        this.put("code", 200);
        this.put("msg","ok");
        return this;
    }

    public JsonVO setFail(String msg){
        this.put("isSuccess",false);
        this.put("code", 500);
        this.put("msg",msg);
        return this;
    }

    public JsonVO setFail(Integer code ,String msg){
        this.put("isSuccess",false);
        this.put("code",code);
        this.put("msg",msg);
        return this;
    }

    public Boolean isSuccess(){
        Boolean isSuccess = false;
        if(this.containsKey("isSuccess")){
            if(this.get("isSuccess") instanceof Boolean){
                isSuccess = this.getBoolean("isSuccess");
            } else {
                isSuccess = "Y".equalsIgnoreCase(this.getString("isSuccess")) ? true : false;
            }
        }
        return isSuccess;
    }

    public void setCode(Integer code){
        this.put("code",code);
    }

    public int getCode(){
        return this.getIntValue("code");
    }

    public void setMsg(String msg){
        this.put("msg",msg);
    }

    public String getMsg(){
        return this.getString("msg");
    }
}

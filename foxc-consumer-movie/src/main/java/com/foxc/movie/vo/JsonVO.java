package com.foxc.movie.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class JsonVO extends HashMap implements Serializable {

    public void setCode(Integer code){
        this.put("code", code);
    }

    public void setMsg(String msg){
        this.put("msg", msg);
    }
}

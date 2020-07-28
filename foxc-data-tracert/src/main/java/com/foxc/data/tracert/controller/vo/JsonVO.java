package com.foxc.data.tracert.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class JsonVO extends HashMap implements Serializable {

    public Integer code;

    public String msg;
}

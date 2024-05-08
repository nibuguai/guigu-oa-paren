package com.wq.common.result;

import com.wq.common.util.ObjectToMapConverter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 王骞
 * @Date 2023/6/28 20:39
 * @Version 1.0
 */
@Slf4j
@Data
public class Result {
    //返回码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private Object data;
    public Result() {

    }
    public Result(Integer code, String message) {
        this.code=code;
        this.message= message;
    }

    // 返回数据
    public Result data(Object data) {
        if (this.data == null) {
            this.data=new Object();
        }
        this.setData(data);
        return this;
    }
    public  Result data(String key,Object data) {
       this.setData(key,data);
        return this;
    }

    private void setData(String key,Object value) {
        Map<String, Object> map =new HashMap<>();
        if (data!=null){  map= ObjectToMapConverter.convert(this.data);}

        map.put(key, value);
        this.data=(Object) map;
    }
    public  Result result(Map<String,Object> body, Integer code, String message) {
        this.setData(body);
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    public   Result result(Map body, ResultCodeEnum resultCodeEnum) {
        data(body);
        this.setCode(resultCodeEnum.getCode());
        this.setMessage(resultCodeEnum.getMessage());
        return this;
    }
    public   Result resultEnum(ResultCodeEnum resultCodeEnum) {

        this.setCode(resultCodeEnum.getCode());
        this.setMessage(resultCodeEnum.getMessage());
        return this;
    }
    public   Result ok() {
        return this.ok(null);
    }

    /**
     * 操作成功
     *
     * @param data baseCategory1List
     * @param
     * @return
     */
    public Result ok(Map data) {
        return result(data, ResultCodeEnum.SUCCESS);
    }

    public Result fail() {
        return this.fail(null);
    }

    /**
     * 操作失败
     *
     * @param data
     * @param
     * @return
     */
    public Result fail(Map data) {
        return result(data, ResultCodeEnum.FAIL);
    }

    public Result message(String msg) {
        this.setMessage(msg);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }
}

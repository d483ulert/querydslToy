package com.dev.toy.common;

import lombok.Data;
import java.util.List;

@Data
public class ResultDto<T>{

    private long result_code;
    private String result_msg;
    private T result_data;


    public ResultDto(long result_code, String result_msg){
        setResult_code(result_code);
        setResult_msg(result_msg);
    }

    public ResultDto(long result_code, T result_data){
        setResult_code(result_code);
        setResult_data(result_data);
    }

    public ResultDto(long result_code, String result_msg, T result_data){
        setResult_code(result_code);
        setResult_msg(result_msg);
        setResult_data(result_data);
    }

    //Todo
    public void setErrorNone(){}
    public void setErrorCode(){}

}

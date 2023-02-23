package com.dev.toy.common;

import lombok.Data;
import java.util.List;

@Data
public class ResultListDto<T>{

    private long result_code;

    private String result_msg;
    private List<T> result_data;


    public ResultListDto(long result_code, String result_msg){
        setResult_code(result_code);
        setResult_msg(result_msg);
    }


    public ResultListDto(long result_code, String result_msg, List<T> result_data){
        setResult_code(result_code);
        setResult_msg(result_msg);
    }


    //Todo
    public void setErrorNone(){}
    public void setErrorCode(){}
}

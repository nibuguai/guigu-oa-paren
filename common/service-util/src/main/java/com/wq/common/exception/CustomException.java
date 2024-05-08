package com.wq.common.exception;

import com.wq.common.result.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 王骞
 * @Date 2023/8/11 15:20
 * @Version 1.0
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {
    private int errorCode;
    private String errorMessage;
    public static CustomException error(String message) {
        CustomException customException = new CustomException();
        customException.setErrorCode(ResultCodeEnum.FAIL.getCode());
        customException.setErrorMessage("异常");
        customException.setErrorMessage(message);
        return customException;
    }


}

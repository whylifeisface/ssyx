package org.example.ssyx.common.exception;

import lombok.Data;
import org.example.ssyx.common.result.ResultCodeEnum;
//import org.example.common.result.ResultCodeEnum;

@Data
public class SsymException extends RuntimeException{

    private Integer code;

    public SsymException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public SsymException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}

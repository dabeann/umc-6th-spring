package spring.umc6th.apiPayload.exception.handler;

import spring.umc6th.apiPayload.code.BaseErrorCode;
import spring.umc6th.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
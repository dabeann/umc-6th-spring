package spring.umc6th.base.exception.handler;

import spring.umc6th.base.Code;
import spring.umc6th.base.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(Code errorCode){
        super(errorCode);
    }
}

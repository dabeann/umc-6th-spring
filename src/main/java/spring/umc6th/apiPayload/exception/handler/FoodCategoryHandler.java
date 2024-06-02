package spring.umc6th.apiPayload.exception.handler;

import spring.umc6th.apiPayload.code.BaseErrorCode;
import spring.umc6th.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

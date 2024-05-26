package spring.umc6th.service.temp_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.umc6th.base.Code;
import spring.umc6th.base.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(Code.TEMP_EXCEPTION);
    }
}

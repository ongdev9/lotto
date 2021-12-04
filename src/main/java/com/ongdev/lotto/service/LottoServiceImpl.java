package com.ongdev.lotto.service;

import com.ongdev.lotto.common.ApiResponseMessage;
import com.ongdev.lotto.mapper.LottoMapper;
import com.ongdev.lotto.model.Lotto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LottoServiceImpl implements LottoService {

    private final LottoMapper lottoMapper;

    public LottoServiceImpl(LottoMapper lottoMapper) {
        this.lottoMapper = lottoMapper;
    }

    @Override
    public ResponseEntity selectLottoNumberOne(String no) throws Exception{

        return setResponseEntity(lottoMapper.selectLottoNumberOne(no));

    }

    @Override
    public ResponseEntity selectCurrentLottoNumber() throws Exception {

        return setResponseEntity(lottoMapper.selectCurrentLottoNumber());
    }


    private ResponseEntity setResponseEntity(Lotto lotto){
        if(lotto == null){
            return new ResponseEntity(new ApiResponseMessage(HttpStatus.NOT_FOUND,"").getResult(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(new ApiResponseMessage(HttpStatus.OK,lotto).getResult(), HttpStatus.OK);
    }
}

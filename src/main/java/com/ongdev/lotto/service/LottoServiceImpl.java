package com.ongdev.lotto.service;

import com.ongdev.lotto.common.ApiResponseMessage;
import com.ongdev.lotto.common.CommonUtil;
import com.ongdev.lotto.mapper.LottoMapper;
import com.ongdev.lotto.model.Lotto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

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

    @Override
    public ResponseEntity getRandomLottoNumber() throws Exception {

        return new ResponseEntity(new ApiResponseMessage(HttpStatus.OK, CommonUtil.sortSet(new HashSet<Integer>())).getResult(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getNumberToLottoNumber(String getNumber) throws Exception {

        //들어온 값 개수 확인 6개 이상 보낼시 return
        long count = getNumber.chars()
                .filter(c -> c == ',')
                .count();

        /* 파라미터 값 확인*/
        if(getNumber == null || count > 5){
            return new ResponseEntity(new ApiResponseMessage(HttpStatus.BAD_REQUEST,"").getResult(), HttpStatus.BAD_REQUEST);
        }

        //들어온 숫자값이 1~45인지 확인해야함
        Integer[] arr = Stream.of(getNumber.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));



        return new ResponseEntity(new ApiResponseMessage(HttpStatus.OK, CommonUtil.sortSet(set)).getResult(), HttpStatus.OK);
    }


    private ResponseEntity setResponseEntity(Lotto lotto){
        if(lotto == null){
            return new ResponseEntity(new ApiResponseMessage(HttpStatus.NOT_FOUND,"").getResult(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(new ApiResponseMessage(HttpStatus.OK,lotto).getResult(), HttpStatus.OK);
    }
}

package com.ongdev.lotto.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface LottoService {

    /* 원하는 회차 로또 번호 */
    ResponseEntity selectLottoNumberOne(String no) throws Exception;

    /* 최신 로또 번호 */
    ResponseEntity selectCurrentLottoNumber() throws Exception;

    /* 랜덤 로또 번호 생성*/
    ResponseEntity getRandomLottoNumber() throws Exception;

    /* 원하는 숫자 포함 랜덤 로또 번호 생성 */
    ResponseEntity getNumberToLottoNumber(String getNumber) throws Exception;
}

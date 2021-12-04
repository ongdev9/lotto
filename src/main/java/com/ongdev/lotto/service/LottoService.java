package com.ongdev.lotto.service;

import org.springframework.http.ResponseEntity;

public interface LottoService {

    /* 원하는 회차 로또 번호 */
    ResponseEntity selectLottoNumberOne(String no) throws Exception;

    /* 최신 로또 번호 */
    ResponseEntity selectCurrentLottoNumber() throws Exception;
}

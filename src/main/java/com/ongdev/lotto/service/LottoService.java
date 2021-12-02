package com.ongdev.lotto.service;

import com.ongdev.lotto.model.Lotto;

public interface LottoService {

    /* 원하는 회차 로또 번호 */
    Lotto selectLottoNumberOne(String no);

}

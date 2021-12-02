package com.ongdev.lotto.service;

import com.ongdev.lotto.mapper.LottoMapper;
import com.ongdev.lotto.model.Lotto;
import org.springframework.stereotype.Service;

@Service
public class LottoServiceImpl implements LottoService {

    private LottoMapper lottoMapper;

    public LottoServiceImpl(LottoMapper lottoMapper) {
        this.lottoMapper = lottoMapper;
    }

    @Override
    public Lotto selectLottoNumberOne(String no) {
        return lottoMapper.selectLottoNumberOne(no);
    }
}

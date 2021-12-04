package com.ongdev.lotto.mapper;

import com.ongdev.lotto.model.Lotto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LottoMapper {

    /* 원하는 회차 로또 번호 */
    Lotto selectLottoNumberOne(String no) throws Exception;

    /* 최신 로또 번호 */
    @Select("SELECT drw_no, drw_no_1, drw_no_2, drw_no_3, drw_no_4, drw_no_5, drw_no_6, bonus_no, drw_no_date FROM lotto ORDER BY drw_no DESC LIMIT 1")
    Lotto selectCurrentLottoNumber() throws Exception;

}

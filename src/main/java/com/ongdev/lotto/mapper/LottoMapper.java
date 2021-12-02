package com.ongdev.lotto.mapper;

import com.ongdev.lotto.model.Lotto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LottoMapper {

    /* 원하는 회차 로또 번호 */
    //Lotto selectLottoNumberOne(String no);


    @Select("SELECT drw_no, drw_no_1, drw_no_2, drw_no_3, drw_no_4, drw_no_5, bonus_no FROM lotto WHERE lo_no = ${no}")
    Lotto selectLottoNumberOne(@Param("no")String no);
}

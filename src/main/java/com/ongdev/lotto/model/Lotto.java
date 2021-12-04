package com.ongdev.lotto.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("lottoVO")
@Data
public class Lotto {

    private String drwNo;
    private String drwNo1;
    private String drwNo2;
    private String drwNo3;
    private String drwNo4;
    private String drwNo5;
    private String drwNo6;
    private String bonusNo;
    private String drwNoDate;

}

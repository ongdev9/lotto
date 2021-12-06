package com.ongdev.lotto.mapper;

import com.ongdev.lotto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Param {

    @NotEmpty(groups = {ValidationGroups.group1.class})
    private String getNumber;
}

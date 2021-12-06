package com.ongdev.lotto.controller;


import com.ongdev.lotto.mapper.Param;
import com.ongdev.lotto.service.LottoService;
import com.ongdev.lotto.validation.ValidationGroups;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/v1")
@RestController
public class LottoController {

    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @RequestMapping(value = "/{no}")
    public ResponseEntity getLottoNumber(@PathVariable String no) throws Exception{
        return new ResponseEntity(lottoService.selectLottoNumberOne(no), HttpStatus.OK);
    }

    @RequestMapping(value = "")
    public ResponseEntity getCurrentLottoNumberOne() throws Exception{
        return new ResponseEntity(lottoService.selectCurrentLottoNumber(), HttpStatus.OK);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public ResponseEntity getRandomLottoNumber() throws Exception{
        return new ResponseEntity(lottoService.getRandomLottoNumber(), HttpStatus.OK);
    }

    @RequestMapping(value = "/random", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getNumberToLottoNumber(@RequestBody @Validated(ValidationGroups.group1.class) Param param, BindingResult bindingResult) throws Exception{
        
        // 유효성 체크
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity(lottoService.getNumberToLottoNumber(param.getGetNumber()), HttpStatus.OK);
    }
}

package com.ongdev.lotto.controller;


import com.ongdev.lotto.service.LottoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class LottoController {


    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @RequestMapping(value = "/{no}")
    public ResponseEntity getLottoNumberOne(@PathVariable("no")String no) {
        return new ResponseEntity(lottoService.selectLottoNumberOne(no), HttpStatus.OK);
    }
}

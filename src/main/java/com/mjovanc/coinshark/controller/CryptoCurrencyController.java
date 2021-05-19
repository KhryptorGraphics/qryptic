package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.CryptoCurrency;
import com.mjovanc.coinshark.repository.CryptoCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cryptocurrency")
public class CryptoCurrencyController {

    @Autowired
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    @PostMapping("add")
    public String addCryptoCurrency(@RequestBody CryptoCurrency cryptoCurrency) {
        cryptoCurrencyRepository.save(cryptoCurrency);
        return "A new crypto currency has been added to the repo!";
    }

    @GetMapping("list")
    public Iterable<CryptoCurrency> getCryptoCurrencies() {
        return this.cryptoCurrencyRepository.findAll();
    }

    @GetMapping("{id}")
    public CryptoCurrency getCryptoCurrencyByName(@PathVariable String id) {
        return this.cryptoCurrencyRepository.findCryptoCurrencyById(id);
    }
}

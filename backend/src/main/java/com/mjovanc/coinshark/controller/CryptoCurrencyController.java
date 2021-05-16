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
    public String addCryptoCurrency(
            @RequestParam String name, @RequestParam String ticker, @RequestParam String websiteURL,
            @RequestParam String repositoryURL, @RequestParam String whitepaperURL
    ) {
        CryptoCurrency cc = new CryptoCurrency();
        cc.setName(name);
        cc.setTicker(ticker);
        cc.setWebsiteURL(websiteURL);
        cc.setRepositoryURL(repositoryURL);
        cc.setWhitepaperURL(whitepaperURL);
        cryptoCurrencyRepository.save(cc);
        return "A new crypto currency has been added to the repo!";
    }

    @GetMapping("list")
    public Iterable<CryptoCurrency> getCryptoCurrencies() {
        return this.cryptoCurrencyRepository.findAll();
    }

    @GetMapping("{id}")
    public CryptoCurrency getCryptoCurrencyById(@PathVariable Integer id) {
        return this.cryptoCurrencyRepository.findCryptoCurrencyById(id);
    }
 }

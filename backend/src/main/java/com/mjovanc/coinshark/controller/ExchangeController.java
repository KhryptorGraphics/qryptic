package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.Exchange;
import com.mjovanc.coinshark.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("exchange")
public class ExchangeController {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @PostMapping("add")
    public String addExchange(
            @RequestParam String name, @RequestParam String description, @RequestParam String websiteURL
    ) {
        Exchange exchange = new Exchange();
        exchange.setName(name);
        exchange.setDescription(description);
        exchange.setWebsiteURL(websiteURL);
        exchangeRepository.save(exchange);
        return "A new crypto exchange has been added to the repo!";
    }

    @GetMapping("list")
    public Iterable<Exchange> getExchanges() {
        return this.exchangeRepository.findAll();
    }

    @GetMapping("{id}")
    public Exchange getExchangeById(@PathVariable Integer id) {
        return this.exchangeRepository.findExchangeById(id);
    }
 }

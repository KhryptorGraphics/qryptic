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
    public String addExchange(@RequestBody Exchange exchange) {
        exchangeRepository.save(exchange);
        return "A new crypto exchange has been added to the repo!";
    }

    @GetMapping("list")
    public Iterable<Exchange> getExchanges() {
        return this.exchangeRepository.findAll();
    }

    @GetMapping("{id}")
    public Exchange getExchangeByName(@PathVariable String id) {
        return this.exchangeRepository.findExchangeById(id);
    }
 }

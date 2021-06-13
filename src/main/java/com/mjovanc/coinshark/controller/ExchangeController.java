package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.Exchange;
import com.mjovanc.coinshark.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("exchange")
public class ExchangeController {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @GetMapping("list")
    public ResponseEntity<Map<String, Object>> getExchanges(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size
    ) {
        try {
            List<Exchange> exchanges;
            Pageable paging = PageRequest.of(page, size);

            Page<Exchange> pageTuts;
            if (name == null)
                pageTuts = this.exchangeRepository.findAll(paging);
            else
                pageTuts = this.exchangeRepository.findByNameContainingIgnoreCase(name, paging);

            exchanges = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("exchanges", exchanges);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public Exchange getExchangeById(@PathVariable String id) {
        return this.exchangeRepository.findExchangeById(id);
    }
 }

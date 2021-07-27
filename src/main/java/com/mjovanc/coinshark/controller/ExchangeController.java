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
@CrossOrigin(origins="*")
@RequestMapping("api/v1/exchanges")
public class ExchangeController {
    @Autowired
    private ExchangeRepository exchangeRepository;

    @PostMapping
    public ResponseEntity<Exchange> addExchange(@RequestBody Exchange exchange) {
        Exchange returnExchange = exchangeRepository.save(exchange);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnExchange, status);
    }

    @GetMapping
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
                pageTuts = exchangeRepository.findAll(paging);
            else
                pageTuts = exchangeRepository.findByNameContainingIgnoreCase(name, paging);

            exchanges = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("exchanges", exchanges);
            response.put("current_page", pageTuts.getNumber());
            response.put("total_items", pageTuts.getTotalElements());
            response.put("total_pages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Exchange> getExchangeById(@PathVariable Long id) {
        Exchange exchange = new Exchange();
        HttpStatus status;

        if (exchangeRepository.existsById(id)) {
            status = HttpStatus.OK;
            exchange = exchangeRepository.findExchangeById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(exchange, status);
    }
 }

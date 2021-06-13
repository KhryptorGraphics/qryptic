package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.CryptoCurrency;
import com.mjovanc.coinshark.repository.CryptoCurrencyRepository;
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
@RequestMapping("cryptocurrency")
public class CryptoCurrencyController {

    @Autowired
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    @GetMapping("list")
    public ResponseEntity<Map<String, Object>> getCryptoCurrencies(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size
    ) {
        try {
            List<CryptoCurrency> cryptocurrencies;
            Pageable paging = PageRequest.of(page, size);

            Page<CryptoCurrency> pageTuts;
            if (name == null)
                pageTuts = this.cryptoCurrencyRepository.findAll(paging);
            else
                pageTuts = this.cryptoCurrencyRepository.findByNameContainingIgnoreCase(name, paging);

            cryptocurrencies = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("cryptocurrencies", cryptocurrencies);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public CryptoCurrency getCryptoCurrencyById(@PathVariable String id) {
        return this.cryptoCurrencyRepository.findCryptoCurrencyById(id);
    }
}

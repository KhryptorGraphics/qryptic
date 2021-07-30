package com.mjovanc.qryptic.controller;

import com.mjovanc.qryptic.model.Exchange;
import com.mjovanc.qryptic.repository.ExchangeRepository;
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

/**
 * Represents a Exchange Controller.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("v1/exchanges")
public class ExchangeController {
    @Autowired
    private ExchangeRepository exchangeRepository;

    /**
     * Add an Exchange.
     *
     * @param exchange : Exchange
     * @return ResponseEntity<Exchange>
     */
    @PostMapping
    public ResponseEntity<Exchange> addExchange(@RequestBody Exchange exchange) {
        Exchange returnExchange = exchangeRepository.save(exchange);
        return new ResponseEntity<>(returnExchange, HttpStatus.CREATED);
    }

    /**
     * Update an Exchange.
     *
     * @param exchange : Exchange
     * @return ResponseEntity<Exchange>
     */
    @PutMapping
    public ResponseEntity<Exchange> updateExchange(@RequestBody Exchange exchange) {
        Exchange returnExchange = exchangeRepository.save(exchange);
        return new ResponseEntity<>(returnExchange, HttpStatus.OK);
    }

    /**
     * Get all Exchanges.
     *
     * @param name : String
     * @param page : int
     * @param size : int
     * @return ResponseEntity<Map<String, Object>>
     */
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

    /**
     * Get an Exchange by id.
     *
     * @param id : Long
     * @return ResponseEntity<Exchange>
     */
    @GetMapping("{id}")
    public ResponseEntity<Exchange> getExchange(@PathVariable Long id) {
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

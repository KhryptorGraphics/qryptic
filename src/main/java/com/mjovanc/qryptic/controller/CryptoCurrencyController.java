package com.mjovanc.qryptic.controller;

import com.mjovanc.qryptic.model.CryptoCurrency;
import com.mjovanc.qryptic.repository.CryptoCurrencyRepository;
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
 * Represents a Crypto Currency Controller.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("v1/cryptocurrencies")
public class CryptoCurrencyController {
    @Autowired
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    /**
     * Add a Crypto Currency.
     *
     * @param cryptoCurrency : CryptoCurrency
     * @return ResponseEntity<CryptoCurrency>
     */
    @PostMapping
    public ResponseEntity<CryptoCurrency> addCryptoCurrency(@RequestBody CryptoCurrency cryptoCurrency) {
        CryptoCurrency returnCryptoCurrency = cryptoCurrencyRepository.save(cryptoCurrency);
        return new ResponseEntity<>(returnCryptoCurrency, HttpStatus.CREATED);
    }

    /**
     * Update a Crypto Currency.
     *
     * @param cryptoCurrency : CryptoCurrency
     * @return ResponseEntity<CryptoCurrency>
     */
    @PutMapping
    public ResponseEntity<CryptoCurrency> updateCryptoCurrency(@RequestBody CryptoCurrency cryptoCurrency) {
        CryptoCurrency returnCryptoCurrency = cryptoCurrencyRepository.save(cryptoCurrency);
        return new ResponseEntity<>(returnCryptoCurrency, HttpStatus.OK);
    }

    /**
     * Get all Crypto Currencies.
     *
     * @param name : String
     * @param page : int
     * @param size : int
     * @return ResponseEntity<Map<String, Object>>
     */
    @GetMapping
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
                pageTuts = cryptoCurrencyRepository.findAll(paging);
            else
                pageTuts = cryptoCurrencyRepository.findByNameContainingIgnoreCase(name, paging);

            cryptocurrencies = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("cryptocurrencies", cryptocurrencies);
            response.put("current_page", pageTuts.getNumber());
            response.put("total_items", pageTuts.getTotalElements());
            response.put("total_pages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get a Crypto Currency by id.
     *
     * @param id : Long
     * @return ResponseEntity<CryptoCurrency>
     */
    @GetMapping("{id}")
    public ResponseEntity<CryptoCurrency> getCryptoCurrency(@PathVariable Long id) {
        CryptoCurrency cryptoCurrency = new CryptoCurrency();
        HttpStatus status;

        if (cryptoCurrencyRepository.existsById(id)) {
            status = HttpStatus.OK;
            cryptoCurrency = cryptoCurrencyRepository.findCryptoCurrencyById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(cryptoCurrency, status);
    }
}

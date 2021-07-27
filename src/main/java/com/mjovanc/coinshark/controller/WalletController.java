package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.Wallet;
import com.mjovanc.coinshark.repository.WalletRepository;
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
@RequestMapping("api/v1/wallets")
public class WalletController {
    @Autowired
    private WalletRepository walletRepository;

    @PostMapping
    public ResponseEntity<Wallet> addWallet(@RequestBody Wallet wallet) {
        Wallet returnWallet = walletRepository.save(wallet);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnWallet, status);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getWallets(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size
    ) {
        try {
            List<Wallet> wallets;
            Pageable paging = PageRequest.of(page, size);

            Page<Wallet> pageTuts;
            if (name == null)
                pageTuts = walletRepository.findAll(paging);
            else
                pageTuts = walletRepository.findByNameContainingIgnoreCase(name, paging);

            wallets = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("wallets", wallets);
            response.put("current_page", pageTuts.getNumber());
            response.put("total_items", pageTuts.getTotalElements());
            response.put("total_pages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable Long id) {
        Wallet wallet = new Wallet();
        HttpStatus status;

        if (walletRepository.existsById(id)) {
            status = HttpStatus.OK;
            wallet = walletRepository.findWalletById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(wallet, status);
    }
 }

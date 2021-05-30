package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.Exchange;
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
@RequestMapping("wallet")
public class WalletController {

    @Autowired
    private WalletRepository walletRepository;

    @PostMapping("add")
    public String addWallet(@RequestBody Wallet wallet) {
        this.walletRepository.save(wallet);
        return "A new crypto wallet has been added to the repo!";
    }

    @GetMapping("list")
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
                pageTuts = this.walletRepository.findAll(paging);
            else
                pageTuts = this.walletRepository.findByNameContainingIgnoreCase(name, paging);

            wallets = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("wallets", wallets);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{name}")
    public Wallet getWalletById(@PathVariable String id) {
        return this.walletRepository.findWalletById(id);
    }
 }

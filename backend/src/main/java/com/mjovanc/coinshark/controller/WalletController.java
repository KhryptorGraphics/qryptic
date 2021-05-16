package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.Wallet;
import com.mjovanc.coinshark.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wallet")
public class WalletController {

    @Autowired
    private WalletRepository walletRepository;

    @PostMapping("add")
    public String addWallet(
            @RequestParam String name, @RequestParam String description, @RequestParam String websiteURL
    ) {
        Wallet wallet = new Wallet();
        wallet.setName(name);
        wallet.setDescription(description);
        wallet.setWebsiteURL(websiteURL);
        this.walletRepository.save(wallet);
        return "A new crypto wallet has been added to the repo!";
    }

    @GetMapping("list")
    public Iterable<Wallet> getWallets() {
        return this.walletRepository.findAll();
    }

    @GetMapping("{id}")
    public Wallet getWalletById(@PathVariable Integer id) {
        return this.walletRepository.findWalletById(id);
    }
 }

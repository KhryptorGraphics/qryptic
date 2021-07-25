package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.WalletPlatform;
import com.mjovanc.coinshark.repository.WalletPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet-platforms")
public class WalletPlatformController {
    @Autowired
    private WalletPlatformRepository walletPlatformRepository;

    @PostMapping
    public String addWalletStorage(@RequestBody WalletPlatform walletPlatform) {
        walletPlatformRepository.save(walletPlatform);
        return "A new crypto wallet platform has been added to the repo!";
    }

    @GetMapping
    public Iterable<WalletPlatform> getAllWalletStorages() {
        return walletPlatformRepository.findAll();
    }

    @GetMapping("{id}")
    public WalletPlatform getWalletStorageById(@PathVariable String id) {
        return walletPlatformRepository.findWalletStorageById(id);
    }
}

package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.WalletStorage;
import com.mjovanc.coinshark.repository.WalletStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet-storages")
public class WalletStorageController {
    @Autowired
    private WalletStorageRepository walletStorageRepository;

    @PostMapping
    public String addWalletStorage(@RequestBody WalletStorage walletStorage) {
        walletStorageRepository.save(walletStorage);
        return "A new crypto wallet storage has been added to the repo!";
    }

    @GetMapping
    public Iterable<WalletStorage> getAllWalletStorages() {
        return walletStorageRepository.findAll();
    }

    @GetMapping("{id}")
    public WalletStorage getWalletStorageById(@PathVariable String id) {
        return walletStorageRepository.findWalletStorageById(id);
    }
}

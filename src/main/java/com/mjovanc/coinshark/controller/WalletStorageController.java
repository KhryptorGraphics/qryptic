package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.WalletStorage;
import com.mjovanc.coinshark.repository.WalletStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/wallet-storages")
public class WalletStorageController {
    @Autowired
    private WalletStorageRepository walletStorageRepository;

    @PostMapping
    public ResponseEntity<WalletStorage> addWalletStorage(@RequestBody WalletStorage walletStorage) {
        WalletStorage returnWalletStorage = walletStorageRepository.save(walletStorage);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnWalletStorage, status);
    }

    @GetMapping
    public Iterable<WalletStorage> getAllWalletStorages() {
        return walletStorageRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<WalletStorage> getWalletStorageById(@PathVariable Long id) {
        WalletStorage walletStorage = new WalletStorage();
        HttpStatus status;

        if (walletStorageRepository.existsById(id)) {
            status = HttpStatus.OK;
            walletStorage = walletStorageRepository.findById(id).get();
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(walletStorage, status);
    }
}

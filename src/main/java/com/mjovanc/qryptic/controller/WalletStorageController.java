package com.mjovanc.qryptic.controller;

import com.mjovanc.qryptic.model.WalletStorage;
import com.mjovanc.qryptic.repository.WalletStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Represents a Wallet Storage Controller.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/wallet-storages")
public class WalletStorageController {
    @Autowired
    private WalletStorageRepository walletStorageRepository;

    /**
     * Add a Wallet Storage.
     *
     * @param walletStorage : WalletStorage
     * @return ResponseEntity<WalletStorage>
     */
    @PostMapping
    public ResponseEntity<WalletStorage> addWalletStorage(@RequestBody WalletStorage walletStorage) {
        WalletStorage returnWalletStorage = walletStorageRepository.save(walletStorage);
        return new ResponseEntity<>(returnWalletStorage, HttpStatus.CREATED);
    }

    /**
     * Get all Wallet Storages.
     *
     * @return ResponseEntity<List<WalletStorage>>
     */
    @GetMapping
    public ResponseEntity<List<WalletStorage>> getWalletStorages() {
        List<WalletStorage> walletStorages = walletStorageRepository.findAll();
        return new ResponseEntity<>(walletStorages, HttpStatus.OK);
    }

    /**
     * Get a Wallet Storage by id.
     *
     * @param id : Long
     * @return ResponseEntity<WalletStorage>
     */
    @GetMapping("{id}")
    public ResponseEntity<WalletStorage> getWalletStorage(@PathVariable Long id) {
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

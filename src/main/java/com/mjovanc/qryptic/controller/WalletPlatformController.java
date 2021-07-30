package com.mjovanc.qryptic.controller;

import com.mjovanc.qryptic.model.WalletPlatform;
import com.mjovanc.qryptic.repository.WalletPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Represents a Wallet Platform Controller.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("v1/wallet-platforms")
public class WalletPlatformController {
    @Autowired
    private WalletPlatformRepository walletPlatformRepository;

    /**
     * Add a Wallet Platform.
     *
     * @param walletPlatform : WalletPlatform
     * @return ResponseEntity<WalletPlatform>
     */
    @PostMapping
    public ResponseEntity<WalletPlatform> addWalletPlatform(@RequestBody WalletPlatform walletPlatform) {
        WalletPlatform returnWalletPlatform = walletPlatformRepository.save(walletPlatform);
        return new ResponseEntity<>(returnWalletPlatform, HttpStatus.CREATED);
    }

    /**
     * Update a Wallet Platform.
     *
     * @param walletPlatform : WalletPlatform
     * @return ResponseEntity<WalletPlatform>
     */
    @PutMapping
    public ResponseEntity<WalletPlatform> updateWalletPlatform(@RequestBody WalletPlatform walletPlatform) {
        WalletPlatform returnWalletPlatform = walletPlatformRepository.save(walletPlatform);
        return new ResponseEntity<>(returnWalletPlatform, HttpStatus.OK);
    }

    /**
     * Get all Wallet Platforms.
     *
     * @return ResponseEntity<List<WalletPlatform>>
     */
    @GetMapping
    public ResponseEntity<List<WalletPlatform>> getWalletPlatforms() {
        List<WalletPlatform> walletPlatforms = walletPlatformRepository.findAll();
        return new ResponseEntity<>(walletPlatforms, HttpStatus.OK);
    }

    /**
     * Gets a Wallet Platform by id.
     *
     * @param id : Long
     * @return ResponseEntity<WalletPlatform>
     */
    @GetMapping("{id}")
    public ResponseEntity<WalletPlatform> getWalletPlatform(@PathVariable Long id) {
        WalletPlatform walletPlatform = new WalletPlatform();
        HttpStatus status;

        if (walletPlatformRepository.existsById(id)) {
            status = HttpStatus.OK;
            walletPlatform = walletPlatformRepository.findById(id).get();
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(walletPlatform, status);
    }
}

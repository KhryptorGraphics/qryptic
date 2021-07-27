package com.mjovanc.coinshark.controller;

import com.mjovanc.coinshark.model.WalletPlatform;
import com.mjovanc.coinshark.repository.WalletPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/wallet-platforms")
public class WalletPlatformController {
    @Autowired
    private WalletPlatformRepository walletPlatformRepository;

    @PostMapping
    public ResponseEntity<WalletPlatform> addWalletStorage(@RequestBody WalletPlatform walletPlatform) {
        WalletPlatform returnWalletPlatform = walletPlatformRepository.save(walletPlatform);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnWalletPlatform, status);
    }

    @GetMapping
    public ResponseEntity<List<WalletPlatform>> getAllWalletPlatforms() {
        List<WalletPlatform> walletPlatforms = walletPlatformRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(walletPlatforms, status);
    }

    @GetMapping("{id}")
    public ResponseEntity<WalletPlatform> getWalletPlatformById(@PathVariable Long id) {
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

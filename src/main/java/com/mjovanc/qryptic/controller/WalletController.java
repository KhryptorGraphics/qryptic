package com.mjovanc.qryptic.controller;

import com.mjovanc.qryptic.model.Wallet;
import com.mjovanc.qryptic.repository.WalletRepository;
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
 * Represents a Wallet Controller.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/wallets")
public class WalletController {
    @Autowired
    private WalletRepository walletRepository;

    /**
     * Add a Wallet.
     *
     * @param wallet : Wallet
     * @return ResponseEntity<Wallet>
     */
    @PostMapping
    public ResponseEntity<Wallet> addWallet(@RequestBody Wallet wallet) {
        Wallet returnWallet = walletRepository.save(wallet);
        return new ResponseEntity<>(returnWallet, HttpStatus.CREATED);
    }

    /**
     * Get all Wallets.
     *
     * @param name : String
     * @param page : int
     * @param size : int
     * @return ResponseEntity<Map<String, Object>>
     */
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

    /**
     * Gets a Wallet by id.
     *
     * @param id : Long
     * @return ResponseEntity<Wallet>
     */
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

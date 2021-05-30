package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, String> {
    Wallet findWalletById(String id);
    Page<Wallet> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

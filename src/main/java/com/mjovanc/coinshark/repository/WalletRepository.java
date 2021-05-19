package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, String> {
    Wallet findWalletById(String id);
}

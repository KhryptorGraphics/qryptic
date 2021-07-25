package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.WalletStorage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletStorageRepository extends MongoRepository<WalletStorage, String> {
    WalletStorage findWalletStorageById(String id);
}

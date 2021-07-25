package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.WalletPlatform;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletPlatformRepository extends MongoRepository<WalletPlatform, String> {
    WalletPlatform findWalletStorageById(String id);
}

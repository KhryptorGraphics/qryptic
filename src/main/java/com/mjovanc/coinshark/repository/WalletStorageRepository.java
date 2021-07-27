package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.WalletStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletStorageRepository extends JpaRepository<WalletStorage, Long> {
}

package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.WalletPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletPlatformRepository extends JpaRepository<WalletPlatform, Long> {
}

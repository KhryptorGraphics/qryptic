package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {
    Wallet findWalletById(Integer id);
}

package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.CryptoCurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CryptoCurrencyRepository extends MongoRepository<CryptoCurrency, String> {
    CryptoCurrency findCryptoCurrencyById(String id);
    Page<CryptoCurrency> findByNameContainingIgnoreCase(String name, Pageable pageable);}

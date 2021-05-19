package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.CryptoCurrency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CryptoCurrencyRepository extends MongoRepository<CryptoCurrency, String> {
    CryptoCurrency findCryptoCurrencyById(String id);
}

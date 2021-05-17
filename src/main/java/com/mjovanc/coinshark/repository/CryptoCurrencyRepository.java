package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.CryptoCurrency;
import org.springframework.data.repository.CrudRepository;

public interface CryptoCurrencyRepository extends CrudRepository<CryptoCurrency, Integer> {
    CryptoCurrency findCryptoCurrencyById(Integer id);
}

package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.Exchange;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRepository extends CrudRepository<Exchange, Integer> {
    Exchange findExchangeById(Integer id);
}

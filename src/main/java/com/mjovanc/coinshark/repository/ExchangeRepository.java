package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.Exchange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExchangeRepository extends MongoRepository<Exchange, String> {
    Exchange findExchangeById(String id);
    Page<Exchange> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

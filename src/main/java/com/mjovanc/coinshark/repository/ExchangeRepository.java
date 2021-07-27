package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.Exchange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    Exchange findExchangeById(Long id);
    Page<Exchange> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

package com.mjovanc.coinshark.repository;

import com.mjovanc.coinshark.model.CryptoCurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {
    CryptoCurrency findCryptoCurrencyById(Long id);
    Page<CryptoCurrency> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

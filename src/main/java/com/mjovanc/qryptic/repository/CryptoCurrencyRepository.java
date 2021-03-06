package com.mjovanc.qryptic.repository;

import com.mjovanc.qryptic.model.CryptoCurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CryptoCurrency Jpa Repository.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {
    CryptoCurrency findCryptoCurrencyById(Long id);
    Page<CryptoCurrency> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

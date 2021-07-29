package com.mjovanc.qryptic.repository;

import com.mjovanc.qryptic.model.Exchange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ExchangeRepository Jpa Repository.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    Exchange findExchangeById(Long id);
    Page<Exchange> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

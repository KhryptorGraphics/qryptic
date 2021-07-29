package com.mjovanc.qryptic.repository;

import com.mjovanc.qryptic.model.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Wallet Jpa Repository.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findWalletById(Long id);
    Page<Wallet> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

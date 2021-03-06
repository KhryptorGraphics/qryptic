package com.mjovanc.qryptic.repository;

import com.mjovanc.qryptic.model.WalletStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * WalletStorage Jpa Repository.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@Repository
public interface WalletStorageRepository extends JpaRepository<WalletStorage, Long> {
}

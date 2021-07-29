package com.mjovanc.qryptic.repository;

import com.mjovanc.qryptic.model.WalletPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * WalletPlatform Jpa Repository.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@Repository
public interface WalletPlatformRepository extends JpaRepository<WalletPlatform, Long> {
}

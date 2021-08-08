package com.mjovanc.qryptic.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a Wallet Platform entity.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToMany(mappedBy="walletPlatforms")
    List<Wallet> wallets;

    @JsonGetter("wallets")
    public List<String> getAllWallets() {
        if(wallets != null) {
            return wallets.stream()
                    .map(wallet -> {
                        return "/api/v1/wallets/" + wallet.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }
}

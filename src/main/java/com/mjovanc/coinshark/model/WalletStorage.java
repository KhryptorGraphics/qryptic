package com.mjovanc.coinshark.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class WalletStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "walletStorages")
    public List<Wallet> wallets;

    @JsonGetter("wallets")
    public List<String> wallets() {
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
}

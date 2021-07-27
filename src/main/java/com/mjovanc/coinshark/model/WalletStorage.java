package com.mjovanc.coinshark.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;

@Entity
public class WalletStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    Wallet wallet;

    @JsonGetter("wallet")
    public String wallet() {
        if (wallet != null)
            return "/api/v1/wallets/" + wallet.getId();
        else
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

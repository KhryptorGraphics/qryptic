package com.mjovanc.coinshark.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

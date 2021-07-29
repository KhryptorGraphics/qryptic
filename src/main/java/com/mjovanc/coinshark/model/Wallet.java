package com.mjovanc.coinshark.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @JsonProperty("website_url")
    @Column(name="website_url")
    private String websiteURL;

    //TODO: add validator so it's not possible to enter blank, null or empty data to fields below
    @JsonProperty("wallet_type")
    @Column(name="wallet_type")
    private String walletType;

    @ManyToMany
    @JsonProperty("wallet_platforms")
    @JoinTable(
            name = "wallet_wallet_platform",
            joinColumns = {@JoinColumn(name = "wallet_id")},
            inverseJoinColumns = {@JoinColumn(name = "wallet_platform_id")}
    )
    public List<WalletPlatform> walletPlatforms;

    @ManyToMany
    @JsonProperty("wallet_storages")
    @JoinTable(
            name = "wallet_wallet_storage",
            joinColumns = {@JoinColumn(name = "wallet_id")},
            inverseJoinColumns = {@JoinColumn(name = "wallet_storage_id")}
    )
    public List<WalletStorage> walletStorages;

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

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }
}
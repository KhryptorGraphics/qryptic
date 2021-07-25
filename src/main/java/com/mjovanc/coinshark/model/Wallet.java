package com.mjovanc.coinshark.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;

    @JsonProperty("website_url")
    private String websiteURL;

    @JsonProperty("wallet_type")
    private String walletType;

    @JsonProperty("wallet_storage")
    @ManyToOne
    @JoinColumn
    private WalletStorage walletStorage;

    @JsonProperty("wallet_platform")
    @ManyToOne
    @JoinColumn
    private WalletPlatform walletPlatform;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public WalletStorage getWalletStorage() {
        return walletStorage;
    }

    public void setWalletStorage(WalletStorage walletStorage) {
        this.walletStorage = walletStorage;
    }

    public WalletPlatform getWalletPlatform() {
        return walletPlatform;
    }

    public void setWalletPlatform(WalletPlatform walletPlatform) {
        this.walletPlatform = walletPlatform;
    }
}
package com.mjovanc.coinshark.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;

    @JsonProperty("website_url")
    private String websiteURL;

    //TODO: add validator so it's not possible to enter blank, null or empty data to fields below
    @JsonProperty("wallet_type")
    private String walletType;

    @JsonProperty("wallet_storages")
    @OneToMany(targetEntity=WalletStorage.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<String> walletStorages;

    @JsonProperty("wallet_platforms")
    @OneToMany(targetEntity=WalletPlatform.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<String> walletPlatforms;

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

    public Set<String> getWalletStorages() {
        return walletStorages;
    }

    public void setWalletStorages(Set<String> walletStorage) {
        this.walletStorages = walletStorage;
    }

    public Set<String> getWalletPlatforms() {
        return walletPlatforms;
    }

    public void setWalletPlatforms(Set<String> walletPlatform) {
        this.walletPlatforms = walletPlatform;
    }
}
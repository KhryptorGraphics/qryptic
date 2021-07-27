package com.mjovanc.coinshark.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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

    @OneToMany
    @JsonProperty("wallet_platforms")
    @JoinColumn(name = "walletPlatform_id")
    List<WalletPlatform> walletPlatforms;

    @OneToMany
    @JsonProperty("wallet_storage")
    @JoinColumn(name = "walletStorage_id")
    List<WalletStorage> walletStorages;

    @JsonGetter("wallet_platforms")
    public List<String> walletPlatforms() {
        if (walletPlatforms != null) {
            return walletPlatforms.stream()
                    .map(walletPlatform -> {
                        return "/api/v1/wallet-platforms/" + walletPlatform.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }

    @JsonGetter("wallet_storages")
    public List<String> walletStorages() {
        if (walletStorages != null) {
            return walletStorages.stream()
                    .map(walletStorage -> {
                        return "/api/v1/wallet-storages/" + walletStorage.getId();
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
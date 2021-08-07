package com.mjovanc.qryptic.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a Wallet entity.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
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
    @JoinTable(
            name = "wallet_wallet_platform",
            joinColumns = {@JoinColumn(name = "wallet_id")},
            inverseJoinColumns = {@JoinColumn(name = "wallet_platform_id")}
    )
    public List<WalletPlatform> walletPlatforms;

    @ManyToMany
    @JoinTable(
            name = "wallet_wallet_storage",
            joinColumns = {@JoinColumn(name = "wallet_id")},
            inverseJoinColumns = {@JoinColumn(name = "wallet_storage_id")}
    )
    public List<WalletStorage> walletStorages;

    @JsonGetter("walletPlatforms")
    public List<String> getAllWalletPlatforms() {
        if(walletPlatforms != null) {
            return walletPlatforms.stream()
                    .map(wp -> {
                        return "/api/v1/wallet-platforms/" + wp.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }

    @JsonGetter("walletStorages")
    public List<String> getAllWalletStorages() {
        if(walletStorages != null) {
            return walletStorages.stream()
                    .map(ws -> {
                        return "/api/v1/wallet-storages/" + ws.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }

    @ManyToMany(mappedBy="cryptoCurrencyWallets")
    List<CryptoCurrency> cryptocurrencies;

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

    public List<WalletPlatform> getWalletPlatforms() {
        return walletPlatforms;
    }

    public void setWalletPlatforms(List<WalletPlatform> walletPlatforms) {
        this.walletPlatforms = walletPlatforms;
    }

    public List<WalletStorage> getWalletStorages() {
        return walletStorages;
    }

    public void setWalletStorages(List<WalletStorage> walletStorages) {
        this.walletStorages = walletStorages;
    }

    public List<CryptoCurrency> getCryptocurrencies() {
        return cryptocurrencies;
    }

    public void setCryptocurrencies(List<CryptoCurrency> cryptocurrencies) {
        this.cryptocurrencies = cryptocurrencies;
    }
}
package com.mjovanc.qryptic.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a Crypto Currency entity.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@Entity
public class CryptoCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ticker;

    @JsonProperty("website_url")
    @Column(name="website_url")
    private String websiteURL;

    @JsonProperty("repository_url")
    @Column(name="repository_url")
    private String repositoryURL;

    @JsonProperty("twitter_username")
    @Column(name="twitter_username")
    private String twitterUsername;

    @JsonProperty("reddit_url")
    @Column(name="reddit_url")
    private String redditURL;

    @ManyToMany
    @JoinTable(
            name = "cryptocurrency_wallet",
            joinColumns = {@JoinColumn(name = "cryptocurrency_id")},
            inverseJoinColumns = {@JoinColumn(name = "wallet_id")}
    )
    public List<Wallet> wallets;

    @ManyToMany
    @JoinTable(
            name = "cryptocurrency_exchange",
            joinColumns = {@JoinColumn(name = "cryptocurrency_id")},
            inverseJoinColumns = {@JoinColumn(name = "exchange_id")}
    )
    public List<Exchange> exchanges;

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

    @JsonGetter("exchanges")
    public List<String> getAllExchanges() {
        if(exchanges != null) {
            return exchanges.stream()
                    .map(exchange -> {
                        return "/api/v1/exchanges/" + exchange.getId();
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

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getRepositoryURL() {
        return repositoryURL;
    }

    public void setRepositoryURL(String repositoryURL) {
        this.repositoryURL = repositoryURL;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getRedditURL() {
        return redditURL;
    }

    public void setRedditURL(String redditURL) {
        this.redditURL = redditURL;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setCryptoCurrencyWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public List<Exchange> getExchanges() {
        return exchanges;
    }

    public void setExchanges(List<Exchange> exchanges) {
        this.exchanges = exchanges;
    }
}
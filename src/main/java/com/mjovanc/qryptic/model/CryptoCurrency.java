package com.mjovanc.qryptic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

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

    public void setTwitterURL(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getRedditURL() {
        return redditURL;
    }

    public void setRedditURL(String redditURL) {
        this.redditURL = redditURL;
    }
}
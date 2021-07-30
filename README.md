# Qryptic API 
 
 <!--- ![alt text](qryptic-logo.png "Qryptic") -->

## About
Qryptic is an open API to retrieve data about crypto currencies, crypto wallets and crypto exchanges. 

## Technologies

The API is built using:

- OpenJDK 16
- Spring Boot 2.5.2
- PostgreSQL

## How to use

### 1. Request a list of cryptocurrencies:

`curl https://api.qryptic.org/v1/cryptocurrenies`

Response:

```JSON
{
    "totalItems": 1,
    "totalPages": 1,
    "currentPage": 0,
    "cryptocurrencies":[
        {"id": "60ae25f4637ef62dc0f4ab63", "name": "01coin", "ticker": "ZOC", "website_url": "https://01coin.io/", "repository_url": "https://github.com/zocteam/zeroonecoin", "twitter_username": "01CoinTeam", "reddit_url": "https://www.reddit.com/r/01coin/"}
    ]
}
```

### 2. Request a cryptocurrency by ID:

`curl https://api.qryptic.org/v1/cryptocurrencies/60a4fd4afa56747b745f5447`

Response:

```JSON
{
    "id": "60ae25f4637ef62dc0f4ab63",
    "name": "01coin",
    "ticker": "ZOC",
    "website_url": "https://01coin.io/",
    "repository_url": "https://github.com/zocteam/zeroonecoin",
    "twitter_username": "01CoinTeam",
    "reddit_url": "https://www.reddit.com/r/01coin/"
}
```

## Contribute

If you would like to contribute to this project there is two ways:

- Send a pull request
- Donate to our BTC/ETH address to keep the servers running

### Pull request

### Donate

BTC: bc1ql97dlhhexma7agkk7gmg76t7ljycuqc9xgr4vl

ETH: 0x03A049028B673Cc5EF676695f442eC5614877335

## License

The license is MIT.

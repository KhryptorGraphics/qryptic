![alt text](coinshark-logo.png "CoinShark")

## About
CoinShark is an open API to retrieve data about crypto currencies, crypto wallets and crypto exchanges. 

## Technologies

The API is built using:

- OpenJDK 11
- Spring Boot 2.4.2
- MongoDB

## How to use

Request a list of cryptocurrencies:

`curl https://coinshark.mjovanc.com/api/v1/cryptocurrencies/list`

Response:

```JSON
[
    {
        "id": "60a4fd4afa56747b745f5447",
        "name": "Bitcoin",
        "ticker": "BTC",
        "website_url": "https://bitcoin.org",
        "repository_url": "https://github.com/bitcoin/bitcoin",
        "hashing_algorithm": "SHA-256",
        "blockchain_urls": [
          "https://github.com/mjovanc/coinshark"
        ],
        "twitter_username": "mjovanc",
        "reddit_url": "reddit"
    }
]
```

Request a cryptocurrency by ID:

`curl https://coinshark.mjovanc.com/api/v1/cryptocurrencies/60a4fd4afa56747b745f5447`

Response:

```JSON
[
]
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

# CoinShark

## About
CoinShark is an open API to retrieve data about crypto currencies, crypto wallets and crypto exchanges. 

## Technologies

The API is built using:

- OpenJDK 11
- Spring Boot 2.4.2

For additonal information regarding libraries, see file requirements.txt.

## How to use

Request a list of cryptocurrencies:

`curl https://api.coinshark.finance/cryptocurrencies/list`

Response:

```
[
    {
        "id": 1,
        "name": "Bitcoin",
        "ticker": "BTC",
        "websiteURL": "https://bitcoin.org",
        "repositoryURL": "https://github.com/bitcoin/bitcoin",
        "whitepaperURL": "https://bitcoin.org/bitcoin.pdf"
    }
]
```

Request a cryptocurrency by ID:

`curl https://api.coinshark.finance/cryptocurrencies/1`

Response:

```
[
    {
        "id": 1,
        "name": "Bitcoin",
        "ticker": "BTC",
        "websiteURL": "https://bitcoin.org",
        "repositoryURL": "https://github.com/bitcoin/bitcoin",
        "whitepaperURL": "https://bitcoin.org/bitcoin.pdf"
    }
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

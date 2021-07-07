![alt text](coinshark-logo.png "CoinShark")

## About
CoinShark is an open API to retrieve data about crypto currencies, crypto wallets and crypto exchanges. 

## Technologies

The API is built using:

- OpenJDK 11
- Spring Boot 2.4.2
- MongoDB

## How to use

### 1. Request a list of cryptocurrencies:

`curl https://coinshark.mjovanc.com/api/v1/cryptocurrencies/list`

Response:

```JSON
{
    "totalItems": 571,
    "totalPages": 23,
    "currentPage": 0,
    "cryptocurrencies":[
        {"id": "60ae25f4637ef62dc0f4ab63", "name": "01coin", "ticker": "ZOC", "website_url": "https://01coin.io/",…},
        {"id": "60ae25f4637ef62dc0f4ab64", "name": "0.5X Long Algorand Token", "ticker": "ALGOHALF",…},
        {"id": "60ae25f5637ef62dc0f4ab65", "name": "0.5X Long Altcoin Index Token", "ticker": "ALTHALF",…},
        {"id": "60ae25f5637ef62dc0f4ab66", "name": "0.5X Long Balancer Token", "ticker": "BALHALF",…},
        {"id": "60ae25f5637ef62dc0f4ab67", "name": "0.5X Long Bitcoin Cash Token", "ticker": "BCHHALF",…},
        {"id": "60ae25f6637ef62dc0f4ab68", "name": "0.5X Long Bitcoin SV Token", "ticker": "BSVHALF",…},
        {"id": "60ae25f6637ef62dc0f4ab69", "name": "0.5X Long Bitcoin Token", "ticker": "HALF",…},
        {"id": "60ae25f7637ef62dc0f4ab6a", "name": "0.5X Long Cardano Token", "ticker": "ADAHALF",…},
        {"id": "60ae25f8637ef62dc0f4ab6b", "name": "0.5X Long Chainlink Token", "ticker": "LINKHALF",…},
        {"id": "60ae25f9637ef62dc0f4ab6c", "name": "0.5X Long Cosmos Token", "ticker": "ATOMHALF",…},
        {"id": "60ae2602637ef62dc0f4ab6d", "name": "0.5X Long DeFi Index Token", "ticker": "DEFIHALF",…},
        {"id": "60ae2602637ef62dc0f4ab6e", "name": "0.5X Long Dogecoin Token", "ticker": "DOGEHALF",…},
        {"id": "60ae2603637ef62dc0f4ab6f", "name": "0.5X Long Dragon Index Token", "ticker": "DRGNHALF",…},
        {"id": "60ae2604637ef62dc0f4ab70", "name": "0.5X Long Exchange Token Index Token", "ticker": "EXCHHALF",…},
        {"id": "60ae2605637ef62dc0f4ab71", "name": "0.5X Long EOS Token", "ticker": "EOSHALF",…},
        {"id": "60ae2607637ef62dc0f4ab72", "name": "0.5X Long Ethereum Classic Token", "ticker": "ETCHALF",…},
        {"id": "60ae2609637ef62dc0f4ab73", "name": "0.5X Long Ethereum Token", "ticker": "ETHHALF",…},
        {"id": "60ae260a637ef62dc0f4ab74", "name": "0.5X Long Kyber Network Token", "ticker": "KNCHALF",…},
        {"id": "60ae260a637ef62dc0f4ab75", "name": "0.5X Long Matic Token", "ticker": "MATICHALF",…},
        {"id": "60ae260b637ef62dc0f4ab76", "name": "0.5X Long Midcap Index Token", "ticker": "MIDHALF",…},
        {"id": "60ae260b637ef62dc0f4ab77", "name": "0.5X Long OKB Token", "ticker": "OKBHALF",…},
        {"id": "60ae260c637ef62dc0f4ab78", "name": "0.5X Long PAX Gold Token", "ticker": "PAXGHALF",…},
        {"id": "60ae260c637ef62dc0f4ab79", "name": "0.5X Long Privacy Index Token", "ticker": "PRIVHALF",…},
        {"id": "60ae260d637ef62dc0f4ab7a", "name": "0.5X Long Shitcoin Index Token", "ticker": "HALFSHIT",…},
        {"id": "60ae260d637ef62dc0f4ab7b", "name": "0.5X Long Swipe Token", "ticker": "SXPHALF",…}
    ]
}
```

### 2. Request a list of cryptocurrencies and order by page number and amount of items per page :

`curl https://coinshark.mjovanc.com/api/v1/cryptocurrencies/list?page=0&size=10`

Response:

```JSON
{
    "totalItems": 1,
    "totalPages": 1,
    "currentPage": 0,
    "cryptocurrencies":[
        {"id": "60ae274a637ef62dc0f4ac5d", "name": "Platinum", "ticker": "PLAT", "website_url": "https://dashplatinum.org",…}
    ]
}
```

### 3. Request a cryptocurrency by ID:

`curl https://coinshark.mjovanc.com/api/v1/cryptocurrencies/60a4fd4afa56747b745f5447`

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

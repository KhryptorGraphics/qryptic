# Qryptic API 
 
![alt text](qryptic-logo.png "Qryptic")

## About
Qryptic is an open API to retrieve data about crypto currencies, crypto wallets and crypto exchanges. 

## Technologies

The API is built using:

- OpenJDK 16
- Spring Boot 2.5.2
- PostgreSQL

## Database Schema

The Database Schema below is the implementation of the API. It might not be totally accurate of how 
the implementation actually is, but will however be for the first initial release.

![Database Schema](database-schema.png "Database Schema")

## How to use

### 1. Request a list of Exchanges:

`curl -X 'GET' 'http://api.qryptic.org/v1/exchanges?page=0&size=25' -H 'accept: */*'`

Response:

```JSON
{
  "exchanges": [
    {
      "id": 1,
      "name": "Binance",
      "description": "Binance is a cryptocurrency exchange that provides a platform for trading various cryptocurrencies.",
      "cryptocurrencies": [],
      "website_url": "https://www.binance.com"
    },
    {
      "id": 2,
      "name": "Kraken",
      "description": "Kraken is a United States-based cryptocurrency exchange and bank, founded in 2011.",
      "cryptocurrencies": [],
      "website_url": "https://www.kraken.com"
    }
  ],
  "total_pages": 1,
  "total_items": 2,
  "current_page": 0
}
```

## Contribute

If you would like to contribute to this project there is two ways:

- Send a pull request
- Donate to our BTC/ETH address to keep the servers running

### Pull request

We appreciate all contributions whether it be small changes such as documentation of source code to major improvement of code. The easiest way is to make a fork and then make a pull request into our develop branch. To make the PR go through make sure to include this information:

```
What does this PR do?

Why are these changes required?

This PR has been tested using (e.g. Unit Tests, Manual Testing):

Extra details?
```

### Donate

BTC: bc1ql97dlhhexma7agkk7gmg76t7ljycuqc9xgr4vl

ETH: 0x03A049028B673Cc5EF676695f442eC5614877335

## License

The license is MIT.

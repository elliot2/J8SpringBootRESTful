# ANZ Wholesale Engineering Sample Project (Backend Development)

The sample application being requested by the candidate to build the backend REST APIs
needed to support a web application to that allows a user to view accounts and
subsequently view transactions on any of the accounts they hold.

## Acceptance Critera

Required functionality:
- View account list
- View account transactions

## Assumptions

As UI is out of scope, I have decided to return purely JSON responses to restful get requests.
As the account number format appears differently in the UI format, I have chosen String for this field.  The dashes and
formatters may or may not be of a designated format, so I left it to unrestricted String.

## Technical notes
Using Spring Boot, jpa, service layer, reactive, flux/mono and j8 streams.
No attempt was made to provide back pressure through the JPA repositories.  You will see these streams are constructed
by iterables.  With more time, I would ensure back pressure on the repositories.. and use swagger for the API definitions.

## Run
``
gradlew bootrun
``

## API Usage

Access the local url :

### Account List
http://localhost:8080/accountList

This will produce a JSON response :
```javascript
[{"accountNumber":"585309209","accountName":"SGSavings726","accountType":"Savings","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"SGD","openingAvailableBalance":84327.51},
{"accountNumber":"791066619","accountName":"AUSavings933","accountType":"Savings","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"AUD","openingAvailableBalance":88005.93},
{"accountNumber":"321143048","accountName":"AUCurrent433","accountType":"Current","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"AUD","openingAvailableBalance":38010.62},
{"accountNumber":"347546123","accountName":"SGCurrent166","accountType":"Current","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"SGD","openingAvailableBalance":50664.65},
{"accountNumber":"680456441","accountName":"AUCurrent374","accountType":"Current","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"AUD","openingAvailableBalance":41327.28},
{"accountNumber":"136151648","accountName":"AUCurrent938","accountType":"Savings","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"AUD","openingAvailableBalance":48928.79},
{"accountNumber":"453489511","accountName":"SGSavings842","accountType":"Savings","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"SGD","openingAvailableBalance":72117.53},
{"accountNumber":"334651897","accountName":"AUSavings253","accountType":"Savings","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"AUD","openingAvailableBalance":88005.93},
{"accountNumber":"793445614","accountName":"AUCurrent754","accountType":"Current","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"AUD","openingAvailableBalance":20588.16},
{"accountNumber":"768456461","accountName":"SGCurrent294","accountType":"Current","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"SGD","openingAvailableBalance":5906.55},
{"accountNumber":"847498496","accountName":"AUCurrent591","accountType":"Current","balanceDate":"2018-11-08T00:00:00.000+0000","currencyCode":"AUD","openingAvailableBalance":925613.68}]
```

### Transactions List
http://localhost:8080/transactions/{accountNumber}

Example
http://localhost:8080/transactions/768456461

This will produce a JSON response :
```javascript
[{"transactionId":37,"accountNumber":"768456461","accountName":"SGCurrent294","valueDate":"2012-01-12T00:00:00.000+0000","currencyCode":"SGD","debitAmount":0.00,"creditAmount":57791.02,"debitCredit":"Credit","transactionNarrative":"Some credit"},
{"transactionId":38,"accountNumber":"768456461","accountName":"SGCurrent294","valueDate":"2012-01-12T00:00:00.000+0000","currencyCode":"SGD","debitAmount":0.00,"creditAmount":63170.05,"debitCredit":"Credit","transactionNarrative":"Some credit 2"},
{"transactionId":39,"accountNumber":"768456461","accountName":"SGCurrent294","valueDate":"2012-01-12T00:00:00.000+0000","currencyCode":"SGD","debitAmount":45752.45,"creditAmount":0.00,"debitCredit":"Debit","transactionNarrative":"Some debit"},
{"transactionId":40,"accountNumber":"768456461","accountName":"SGCurrent294","valueDate":"2012-01-12T00:00:00.000+0000","currencyCode":"SGD","debitAmount":15115.66,"creditAmount":0.00,"debitCredit":"Debit","transactionNarrative":"Some debit 2"}]


```


## Build

``
gradlew build
``

## Test
``
gradlew test
``


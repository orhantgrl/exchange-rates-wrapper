
<h3 align="center">Exchange Rates Wrapper</h3>
<p align="center">
    Unofficial API wrapper of exchangeratesapi.io for Java made with Retrofit 2.0 also you can use on Android 
</p>

<div align="center">
	
[![](https://jitpack.io/v/orhantgrl/exchange-rates-wrapper.svg)](https://jitpack.io/#orhantgrl/exchange-rates-wrapper)
[![Build Status](https://travis-ci.org/orhantgrl/exchange-rates-wrapper.svg?branch=master)](https://travis-ci.org/orhantgrl/exchange-rates-wrapper)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ab7b1c431cc34aa78ce287a61c040e57)](https://www.codacy.com/manual/orhantgrl/exchange-rates-wrapper?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=orhantgrl/exchange-rates-wrapper&amp;utm_campaign=Badge_Grade)

</div>

<br>

Add to your project build.gradle
```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Add to your app module build.gradle
```gradle
dependencies {
        implementation 'com.github.orhantgrl:exchange-rates-wrapper:v1.0'
}
```
Also remember to add the INTERNET permission in your Manifest:
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```
The wrapper currently supports the following endpoints of Exchange Rates API:
- Latest Exchanges <https://api.exchangeratesapi.io/latest?base=USD>
- Historical Exchanges <https://api.exchangeratesapi.io/history?start_at=2018-09-01&end_at=2018-09-06&base=USD>

## EXRApiClient setup
You don't need a any API key or etc. just initialize client class like this:
```java
private EXRApiClient exrApiClient = new EXRApiClient();
```
You can configure it if user want to use default locale:
```java
String locale = exrApiClient.setSupportedBaseFromLocale(Locale.getDefault());
```
## Latest Exchanges
Returns the most current results based on the base currency sent:
```java
EXRApiClient exrApiClient = new EXRApiClient();
        exrApiClient.setSupportedBaseFromLocale(Locale.getDefault());
        exrApiClient.getExchange("USD", new EXRApiRequestListener<Exchange>() {
            @Override
            public void onResponse(EXRApiResponse<Exchange> response) {
                Exchange exchange = response.body();
                //Do something...
            }

            @Override
            public void onFailure(Throwable throwable) {
                //Do something...
            }
        });
```
## Historical Exchanges
Returns results based on time interval and currency sent:
```java
        EXRApiClient exrApiClient = new EXRApiClient();
        exrApiClient.getHistoricalExchange("2010-10-09", "2019-10-09", "USD", new EXRApiRequestListener<HistoricalExchange>() {
            @Override
            public void onResponse(EXRApiResponse<HistoricalExchange> response) {
                //Do something...
            }

            @Override
            public void onFailure(Throwable t) {
                //Do something...
            }
        });
```

## License

    Copyright 2019 Orhan Tugrul

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

<a href="https://patreon.com/orhantgrl"><img src="https://img.shields.io/endpoint?style=for-the-badge&url=https%3A%2F%2Fshieldsio-patreon.herokuapp.com%2Forhantgrl"> </a>

package com.theloocale.exchangeratesapiwrapper;

import com.theloocale.exchangeratesapiwrapper.api.EXRApiClient;
import com.theloocale.exchangeratesapiwrapper.api.EXRApiResponse;
import com.theloocale.exchangeratesapiwrapper.enums.EXRSupportedBases;
import com.theloocale.exchangeratesapiwrapper.listeners.EXRApiRequestListener;
import com.theloocale.exchangeratesapiwrapper.models.Exchange;
import com.theloocale.exchangeratesapiwrapper.models.HistoricalExchange;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangeTest {
    private Exchange exchange;
    private HistoricalExchange historicalExchange;
    private final EXRApiClient apiClient = new EXRApiClient();
    private boolean isResponse = false;

    public Callable<Boolean> fetchExchange() {
        isResponse = false;
        apiClient.getExchange("USD", new EXRApiRequestListener<Exchange>() {
            @Override
            public void onResponse(EXRApiResponse<Exchange> response) {
                exchange = response.body();
                isResponse = true;
            }

            @Override
            public void onFailure(Throwable t) {
                catchException(t);
            }
        });

        return () -> isResponse;
    }

    public Callable<Boolean> fetchHistoricalExchange() {
        isResponse = false;
        apiClient.getHistoricalExchange("EUR", "2018-10-09", "2019-10-09",
                new EXRApiRequestListener<HistoricalExchange>() {

                    @Override
                    public void onResponse(EXRApiResponse<HistoricalExchange> response) {
                        historicalExchange = response.body();
                        isResponse = true;
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        catchException(t);
                    }
                });

        return () -> isResponse;
    }

    @Before
    public void setUp() {
        await().until(fetchExchange());
        await().until(fetchHistoricalExchange());
    }

    private void catchException(Throwable t) {
        Charset utf8 = StandardCharsets.UTF_8;
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("exchange.log"), utf8))) {
            writer.write(t.getMessage() + "\n");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Test
    public void testExchangeBase() {
        assertEquals(EXRSupportedBases.USD.getBase(), exchange.getBase());
    }

    @Test
    public void testHistoricalExchangeBase() {
        assertEquals(EXRSupportedBases.EUR.getBase(), historicalExchange.getBase());
    }

    @Test
    public void testExchangeDate() {
        assertEquals(
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                exchange.getDate()
        );
    }

    @Test
    public void testHistoricalExchangeDates() {
        final String[] dates = { /*startAt*/ "2018-10-09", /*endAt*/ "2019-10-09"};
        assertArrayEquals(dates, new String[]{historicalExchange.getStartAt(), historicalExchange.getEndAt()});
    }

    @Test
    public void testExchangeRateSize() {
        assertEquals(EXRSupportedBases.values().length, exchange.getRates().getAllCurrencyValues().size());
    }
}

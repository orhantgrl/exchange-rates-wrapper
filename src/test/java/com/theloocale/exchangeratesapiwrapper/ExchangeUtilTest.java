package com.theloocale.exchangeratesapiwrapper;

import com.theloocale.exchangeratesapiwrapper.api.EXRApiClient;
import com.theloocale.exchangeratesapiwrapper.api.EXRApiResponse;
import com.theloocale.exchangeratesapiwrapper.listeners.EXRApiRequestListener;
import com.theloocale.exchangeratesapiwrapper.models.Exchange;
import com.theloocale.exchangeratesapiwrapper.models.HistoricalExchange;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangeUtilTest {
    private Exchange exchange;
    private HistoricalExchange historicalExchange;
    private EXRApiClient apiClient = new EXRApiClient();
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
        await().atMost(5, TimeUnit.SECONDS).until(fetchExchange());
        await().atMost(5, TimeUnit.SECONDS).until(fetchHistoricalExchange());
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
        final String base = "USD";
        assertEquals(base, exchange.getBase());
    }

    @Test
    public void testHistoricalExchangeBase() {
        final String base = "EUR";
        assertEquals(base, historicalExchange.getBase());
    }

    @Test
    public void testExchangeDate() {
        final String today = "2020-03-13";
        assertEquals(today, exchange.getDate());
    }

    @Test
    public void testHistoricalExchangeDates() {
        final String[] dates = { /*StartAt*/ "2018-10-09", /*EndAt*/ "2019-10-09"};
        assertArrayEquals(dates, new String[]{historicalExchange.getStartAt(), historicalExchange.getEndAt()});
    }

    @Test
    public void testExchangeRateSize() {
        final int rateSize = 33;
        assertEquals(rateSize, exchange.getRates().getAllCurrencyValues().size());
    }
}

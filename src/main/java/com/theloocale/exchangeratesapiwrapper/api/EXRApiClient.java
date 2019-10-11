package com.theloocale.exchangeratesapiwrapper.api;

import com.theloocale.exchangeratesapiwrapper.enums.EXRSupportedBases;
import com.theloocale.exchangeratesapiwrapper.listeners.EXRApiRequestListener;
import com.theloocale.exchangeratesapiwrapper.models.Exchange;
import com.theloocale.exchangeratesapiwrapper.models.HistoricalExchange;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.theloocale.exchangeratesapiwrapper.utils.EXRApiUtils;

import java.util.Currency;
import java.util.Locale;

/**
 * @author orhantgrl
 * created on 10/10/19.
 */
public class EXRApiClient {
    private static final String BASE_URL = "https://api.exchangeratesapi.io/";
    private EXRApiInterface eXRApiInterface;

    /**
     * Main ApiClient Constructor
     */
    public EXRApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        eXRApiInterface = retrofit.create(EXRApiInterface.class);
    }

    /**
     * @param locale use current locale for currency base.
     */
    public String setSupportedBaseFromLocale(Locale locale) {
        EXRSupportedBases eXRSupportedBases = EXRSupportedBases.EUR;
        for (String supportedCurrencyBases : EXRApiUtils.getSupportedBases()) {
            if (Currency.getInstance(locale).getCurrencyCode().equals(supportedCurrencyBases)) {
                eXRSupportedBases = EXRSupportedBases.valueOf(supportedCurrencyBases);
            }
        }
        return eXRSupportedBases.getBase();
    }

    /**
     * @param eXRApiRequestListener the ApiRequestListener of the request result.
     * @param base the user selection exchange base
     */
    public void getExchange(final String base, final EXRApiRequestListener<Exchange> eXRApiRequestListener) {
        Call<Exchange> exchangeCall = eXRApiInterface.getExchanges(base);
        exchangeCall.enqueue(new Callback<Exchange>() {
            public void onResponse(Call<Exchange> call, Response<Exchange> response) {
                eXRApiRequestListener.onResponse(new EXRApiResponse<Exchange>(response.body()));
            }

            public void onFailure(Call<Exchange> call, Throwable throwable) {
                eXRApiRequestListener.onFailure(throwable);
            }
        });
    }


    /**
     * @param eXRApiRequestListener the ApiRequestListener of the request result.
     * @param startAt api search history start time
     * @param endAt api search history end time
     * @param base the user selection exchange base
     */
    public void getHistoricalExchange(final String startAt, final String endAt, final String base, final EXRApiRequestListener<HistoricalExchange> eXRApiRequestListener) {
        Call<HistoricalExchange> historicalExchangeCall = eXRApiInterface.getHistoricalExchanges(startAt, endAt, base);
        historicalExchangeCall.enqueue(new Callback<HistoricalExchange>() {
            public void onResponse(Call<HistoricalExchange> call, Response<HistoricalExchange> response) {
                eXRApiRequestListener.onResponse(new EXRApiResponse<HistoricalExchange>(response.body()));
            }

            public void onFailure(Call<HistoricalExchange> call, Throwable throwable) {
                eXRApiRequestListener.onFailure(throwable);
            }
        });
    }
}

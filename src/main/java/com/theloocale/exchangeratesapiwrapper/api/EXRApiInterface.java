package com.theloocale.exchangeratesapiwrapper.api;

import com.theloocale.exchangeratesapiwrapper.models.Exchange;
import com.theloocale.exchangeratesapiwrapper.models.HistoricalExchange;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author orhantgrl
 * created on 10/10/19.
 */
public interface EXRApiInterface {
    @GET("latest")
    Call<Exchange> getExchanges(
            @Query("base") String base
    );

    @GET("history")
    Call<HistoricalExchange> getHistoricalExchanges(
            @Query("start_at") String startAt,
            @Query("end_at") String endAt,
            @Query("base") String base
    );
}

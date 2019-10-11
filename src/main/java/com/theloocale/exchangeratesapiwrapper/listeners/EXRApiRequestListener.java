package com.theloocale.exchangeratesapiwrapper.listeners;

import com.theloocale.exchangeratesapiwrapper.api.EXRApiResponse;

/**
 * @author orhantgrl
 * created on 10/11/19.
 */
public interface EXRApiRequestListener<T> {
    void onResponse(EXRApiResponse<T> response);
    void onFailure(Throwable t);
}

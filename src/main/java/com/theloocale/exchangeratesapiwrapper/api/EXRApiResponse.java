package com.theloocale.exchangeratesapiwrapper.api;

/**
 * @author orhantgrl
 * created on 10/11/19.
 */
public class EXRApiResponse<T> {
    private final T body;

    EXRApiResponse(T body) {
        this.body = body;
    }

    public T body() {
        return body;
    }
}

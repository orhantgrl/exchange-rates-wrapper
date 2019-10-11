package com.theloocale.exchangeratesapiwrapper.enums;

/**
 * @author orhantgrl
 * created on 10/10/19.
 */
public enum EXRSupportedBases {
    CAD("CAD"),
    HKD("HKD"),
    ISK("ISK"),
    PHP("PHP"),
    DKK("DKK"),
    HUF("HUF"),
    CZK("CZK"),
    AUD("AUD"),
    RON("RON"),
    SEK("SEK"),
    IDR("IDR"),
    INR("INR"),
    BRL("BRL"),
    RUB("RUB"),
    HRK("HRK"),
    JPY("JPY"),
    THB("THB"),
    CHF("CHF"),
    SGD("SGD"),
    PLN("PLN"),
    BGN("BGN"),
    TRY("TRY"),
    CNY("CNY"),
    NOK("NOK"),
    NZD("NZD"),
    ZAR("ZAR"),
    USD("USD"),
    MXN("MXN"),
    ILS("ILS"),
    GBP("GBP"),
    KRW("KRW"),
    MYR("MYR"),
    EUR("EUR");

    private String base;

    EXRSupportedBases(String base) {
        this.base = base;
    }

    public String getBase() {
        return base;
    }
}

package com.theloocale.exchangeratesapiwrapper.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author orhantgrl
 * created on 10/10/19.
 */
public class Rates {
    @SerializedName("CAD")
    @Expose
    private Float cAD;
    @SerializedName("HKD")
    @Expose
    private Float hKD;
    @SerializedName("ISK")
    @Expose
    private Float iSK;
    @SerializedName("PHP")
    @Expose
    private Float pHP;
    @SerializedName("DKK")
    @Expose
    private Float dKK;
    @SerializedName("HUF")
    @Expose
    private Float hUF;
    @SerializedName("CZK")
    @Expose
    private Float cZK;
    @SerializedName("AUD")
    @Expose
    private Float aUD;
    @SerializedName("RON")
    @Expose
    private Float rON;
    @SerializedName("SEK")
    @Expose
    private Float sEK;
    @SerializedName("IDR")
    @Expose
    private Float iDR;
    @SerializedName("INR")
    @Expose
    private Float iNR;
    @SerializedName("BRL")
    @Expose
    private Float bRL;
    @SerializedName("RUB")
    @Expose
    private Float rUB;
    @SerializedName("HRK")
    @Expose
    private Float hRK;
    @SerializedName("JPY")
    @Expose
    private Float jPY;
    @SerializedName("THB")
    @Expose
    private Float tHB;
    @SerializedName("CHF")
    @Expose
    private Float cHF;
    @SerializedName("SGD")
    @Expose
    private Float sGD;
    @SerializedName("PLN")
    @Expose
    private Float pLN;
    @SerializedName("BGN")
    @Expose
    private Float bGN;
    @SerializedName("TRY")
    @Expose
    private Float tRY;
    @SerializedName("CNY")
    @Expose
    private Float cNY;
    @SerializedName("NOK")
    @Expose
    private Float nOK;
    @SerializedName("NZD")
    @Expose
    private Float nZD;
    @SerializedName("ZAR")
    @Expose
    private Float zAR;
    @SerializedName("USD")
    @Expose
    private Float uSD;
    @SerializedName("MXN")
    @Expose
    private Float mXN;
    @SerializedName("ILS")
    @Expose
    private Float iLS;
    @SerializedName("GBP")
    @Expose
    private Float gBP;
    @SerializedName("KRW")
    @Expose
    private Float kRW;
    @SerializedName("MYR")
    @Expose
    private Float mYR;
    @SerializedName("EUR")
    @Expose
    private Float eUR;

    public Rates(Float cAD, Float hKD, Float iSK, Float pHP, Float dKK, Float hUF, Float cZK, Float aUD, Float rON, Float sEK, Float iDR,
                 Float iNR, Float bRL, Float rUB, Float hRK, Float jPY, Float tHB, Float cHF, Float sGD, Float pLN, Float bGN, Float tRY,
                 Float cNY, Float nOK, Float nZD, Float zAR, Float uSD, Float mXN, Float iLS, Float gBP, Float kRW, Float mYR, Float eUR) {
        this.cAD = cAD;
        this.hKD = hKD;
        this.iSK = iSK;
        this.pHP = pHP;
        this.dKK = dKK;
        this.hUF = hUF;
        this.cZK = cZK;
        this.aUD = aUD;
        this.rON = rON;
        this.sEK = sEK;
        this.iDR = iDR;
        this.iNR = iNR;
        this.bRL = bRL;
        this.rUB = rUB;
        this.hRK = hRK;
        this.jPY = jPY;
        this.tHB = tHB;
        this.cHF = cHF;
        this.sGD = sGD;
        this.pLN = pLN;
        this.bGN = bGN;
        this.tRY = tRY;
        this.cNY = cNY;
        this.nOK = nOK;
        this.nZD = nZD;
        this.zAR = zAR;
        this.uSD = uSD;
        this.mXN = mXN;
        this.iLS = iLS;
        this.gBP = gBP;
        this.kRW = kRW;
        this.mYR = mYR;
        this.eUR = eUR;
    }

    public Float getcAD() {
        return cAD;
    }

    public Float gethKD() {
        return hKD;
    }

    public Float getiSK() {
        return iSK;
    }

    public Float getpHP() {
        return pHP;
    }

    public Float getdKK() {
        return dKK;
    }

    public Float gethUF() {
        return hUF;
    }

    public Float getcZK() {
        return cZK;
    }

    public Float getaUD() {
        return aUD;
    }

    public Float getrON() {
        return rON;
    }

    public Float getsEK() {
        return sEK;
    }

    public Float getiDR() {
        return iDR;
    }

    public Float getiNR() {
        return iNR;
    }

    public Float getbRL() {
        return bRL;
    }

    public Float getrUB() {
        return rUB;
    }

    public Float gethRK() {
        return hRK;
    }

    public Float getjPY() {
        return jPY;
    }

    public Float gettHB() {
        return tHB;
    }

    public Float getcHF() {
        return cHF;
    }

    public Float getsGD() {
        return sGD;
    }

    public Float getpLN() {
        return pLN;
    }

    public Float getbGN() {
        return bGN;
    }

    public Float gettRY() {
        return tRY;
    }

    public Float getcNY() {
        return cNY;
    }

    public Float getnOK() {
        return nOK;
    }

    public Float getnZD() {
        return nZD;
    }

    public Float getzAR() {
        return zAR;
    }

    public Float getuSD() {
        return uSD;
    }

    public Float getmXN() {
        return mXN;
    }

    public Float getiLS() {
        return iLS;
    }

    public Float getgBP() {
        return gBP;
    }

    public Float getkRW() {
        return kRW;
    }

    public Float getmYR() {
        return mYR;
    }

    public Float geteUR() {
        return eUR;
    }
}

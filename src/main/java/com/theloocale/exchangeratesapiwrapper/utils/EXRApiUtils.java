package com.theloocale.exchangeratesapiwrapper.utils;

import com.theloocale.exchangeratesapiwrapper.enums.EXRSupportedBases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author orhantgrl
 * created on 10/11/19.
 */
public class EXRApiUtils {

    public static List<String> getSupportedBases() {
        List<String> mTempList = new ArrayList<String>();
        for(EXRSupportedBases mEXRSupportedBases : EXRSupportedBases.values()){
            mTempList.add(mEXRSupportedBases.getBase());
        }
        return mTempList;
    }
}

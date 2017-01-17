package com.example.martian.quakereport;

import java.util.StringTokenizer;

/**
 * Created by martian on 16/1/17.
 */

public class Earthquake {
    private String mPlace ,mDate,mMagnitude;

    public Earthquake(String defaultMagnitude,String defaultPlace,String defaultDate){
        mMagnitude=defaultMagnitude;

        mPlace=defaultPlace;
        mDate=defaultDate;
    }

    public String getmMagnitude(){
        return mMagnitude;
    }

    public String getmPlace(){
        return mPlace;
    }

    public String getmDate(){
        return mDate;
    }
}


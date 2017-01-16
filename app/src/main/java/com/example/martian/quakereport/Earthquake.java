package com.example.martian.quakereport;

import java.util.StringTokenizer;

/**
 * Created by martian on 16/1/17.
 */

public class Earthquake {
    private String mPlace ,mDate,mMagnitude;

    public Earthquake(String defaultMagnitude,String defaultDate,String defaultPlace){
        mMagnitude=defaultMagnitude;
        mDate=defaultDate;
        mPlace=defaultPlace;
    }

    public String getmMagnitude(){
        return mMagnitude;
    }

    public String getmDate(){
        return mDate;
    }

    public String getmPlace(){
        return mPlace;
    }
}


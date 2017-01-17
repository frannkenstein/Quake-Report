package com.example.martian.quakereport;

import java.util.StringTokenizer;

/**
 * Created by martian on 16/1/17.
 */

public class Earthquake {
    private String mPlace,murl;
    private long mtime;
    private double mMagnitude;

    public Earthquake(Double defaultMagnitude, String defaultPlace, long timeInMilliseconds,String defaulturl){

        mMagnitude=defaultMagnitude;
        mPlace=defaultPlace;
        mtime=timeInMilliseconds;
        murl=defaulturl;
    }

    public double getmMagnitude(){

        return mMagnitude;
    }

    public String getmPlace(){

        return mPlace;
    }

    public long getTimeInMilliseconds() {
        return mtime;
    }

    public String getMurl(){

        return murl;
    }

}


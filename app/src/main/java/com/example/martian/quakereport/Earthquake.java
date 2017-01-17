package com.example.martian.quakereport;

import java.util.StringTokenizer;

/**
 * Created by martian on 16/1/17.
 */

public class Earthquake {
    private String mPlace;
    private long mtime;
    private double mMagnitude;

    public Earthquake(double defaultMagnitude, String defaultPlace, long timeInMilliseconds){
        mMagnitude=defaultMagnitude;

        mPlace=defaultPlace;
        mtime=timeInMilliseconds;
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

}


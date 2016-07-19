package com.timer.rorschak.dogather.Beans;

import android.media.Image;

/**
 * Eventholder.java - this is the bean to hold the value of individual event in
 * dogather app. will be instantiatied with three param of image, text and desc of the event
 * @author  Rorschak1
 * @version 1.0
 */
public class EventHolder {

    private String mEventText;
    private String mEventDesc;

    //constructor to instatiate the class
    public EventHolder(String eventtext,String eventdesc) {

        mEventText=eventtext;
        mEventDesc=eventdesc;
    }

    //getters and setter for event


    public String getmEventText() {
        return mEventText;
    }

    public void setmEventText(String mEventText) {
        this.mEventText = mEventText;
    }

    public String getmEventDesc() {
        return mEventDesc;
    }

    public void setmEventDesc(String mEventDesc) {
        this.mEventDesc = mEventDesc;
    }
}

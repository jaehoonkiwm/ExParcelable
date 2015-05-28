package com.iot.exparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by iao on 15. 5. 21.
 */
public class SimpleData implements Parcelable {
    private String msg;

    public SimpleData(String msg) {
        this.msg = msg;
    }

    public SimpleData(Parcel src) {
        this.msg = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public SimpleData createFromParcel(Parcel source) {
            return new SimpleData(source);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

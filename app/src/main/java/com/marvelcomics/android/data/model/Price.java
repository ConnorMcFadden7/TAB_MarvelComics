package com.marvelcomics.android.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class Price implements Serializable, Parcelable {

  private static final long serialVersionUID = -7877821088849856344L;

  private String type;
  private double price;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.type);
    dest.writeDouble(this.price);
  }

  public Price() {
    //
  }

  protected Price(Parcel in) {
    this.type = in.readString();
    this.price = in.readDouble();
  }

  public static final Creator<Price> CREATOR = new Creator<Price>() {
    public Price createFromParcel(Parcel source) {
      return new Price(source);
    }

    public Price[] newArray(int size) {
      return new Price[size];
    }
  };
}

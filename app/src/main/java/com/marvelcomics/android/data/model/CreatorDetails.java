package com.marvelcomics.android.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class CreatorDetails implements Serializable, Parcelable {

  private static final long serialVersionUID = -4877824088849856344L;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.name);
  }

  public CreatorDetails() {
    //
  }

  protected CreatorDetails(Parcel in) {
    this.name = in.readString();
  }

  public static final Creator<CreatorDetails> CREATOR = new Creator<CreatorDetails>() {
    public CreatorDetails createFromParcel(Parcel source) {
      return new CreatorDetails(source);
    }

    public CreatorDetails[] newArray(int size) {
      return new CreatorDetails[size];
    }
  };
}

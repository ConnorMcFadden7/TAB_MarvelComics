package com.marvelcomics.android.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class Creators implements Serializable, Parcelable {

  private static final long serialVersionUID = 4877824088849856344L;

  private List<CreatorDetails> items;

  public List<CreatorDetails> getItems() {
    return items;
  }

  public void setCreatorDetails(List<CreatorDetails> items) {
    this.items = items;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(this.items);
  }

  public Creators() {
    //
  }

  protected Creators(Parcel in) {
    this.items = in.createTypedArrayList(CreatorDetails.CREATOR);
  }

  public static final Creator<Creators> CREATOR = new Creator<Creators>() {
    public Creators createFromParcel(Parcel source) {
      return new Creators(source);
    }

    public Creators[] newArray(int size) {
      return new Creators[size];
    }
  };
}

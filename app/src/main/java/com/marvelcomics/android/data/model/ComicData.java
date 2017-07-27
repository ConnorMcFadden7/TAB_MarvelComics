package com.marvelcomics.android.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicData implements Serializable, Parcelable {

  private static final long serialVersionUID = -8139428165816691731L;

  private int offset;
  private int limit;
  private int total;
  private int count;
  private List<Comic> results;

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public List<Comic> getResults() {
    return results;
  }

  public void setResults(List<Comic> results) {
    this.results = results;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.offset);
    dest.writeInt(this.limit);
    dest.writeInt(this.total);
    dest.writeInt(this.count);
    dest.writeTypedList(this.results);
  }

  protected ComicData(Parcel in) {
    this.offset = in.readInt();
    this.limit = in.readInt();
    this.total = in.readInt();
    this.count = in.readInt();
    this.results = in.createTypedArrayList(Comic.CREATOR);
  }

  public static final Creator<ComicData> CREATOR = new Creator<ComicData>() {
    public ComicData createFromParcel(Parcel source) {
      return new ComicData(source);
    }

    public ComicData[] newArray(int size) {
      return new ComicData[size];
    }
  };
}

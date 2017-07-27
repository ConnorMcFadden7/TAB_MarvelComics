package com.marvelcomics.android.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class Comic implements Serializable, Parcelable {

  private static final long serialVersionUID = -7877824088849856344L;

  private int id;
  private String title;
  private ComicThumbnail thumbnail;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ComicThumbnail getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(ComicThumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.id);
    dest.writeValue(this.title);
    dest.writeParcelable(this.thumbnail, flags);
  }

  protected Comic(Parcel in) {
    this.id = in.readInt();
    this.title = in.readString();
    this.thumbnail = in.readParcelable(ComicThumbnail.class.getClassLoader());
  }

  public static final Creator<Comic> CREATOR = new Creator<Comic>() {
    public Comic createFromParcel(Parcel source) {
      return new Comic(source);
    }

    public Comic[] newArray(int size) {
      return new Comic[size];
    }
  };
}

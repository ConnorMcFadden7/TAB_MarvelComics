package com.marvelcomics.android.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class Comic implements Serializable, Parcelable {

  private static final long serialVersionUID = -7877824088849856344L;

  private int id;
  private String title;
  private String description;
  private int pageCount;
  private List<Price> prices;
  private Creators creators;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public List<Price> getPrices() {
    return prices;
  }

  public void setPrices(List<Price> prices) {
    this.prices = prices;
  }

  public Creators getCreators() {
    return creators;
  }

  public void setCreators(Creators creators) {
    this.creators = creators;
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
    dest.writeInt(this.id);
    dest.writeString(this.title);
    dest.writeString(this.description);
    dest.writeInt(this.pageCount);
    dest.writeTypedList(this.prices);
    dest.writeParcelable(this.creators, flags);
    dest.writeParcelable(this.thumbnail, flags);
  }

  public Comic() {
    //
  }

  protected Comic(Parcel in) {
    this.id = in.readInt();
    this.title = in.readString();
    this.description = in.readString();
    this.prices = in.createTypedArrayList(Price.CREATOR);
    this.creators = in.readParcelable(Creators.class.getClassLoader());
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

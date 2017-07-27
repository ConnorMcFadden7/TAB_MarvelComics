package com.marvelcomics.android.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicThumbnail implements Serializable, Parcelable {

  private static final long serialVersionUID = -4881650873560299551L;

  private String path;
  private String extension;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.path);
    dest.writeString(this.extension);
  }

  protected ComicThumbnail(Parcel in) {
    this.path = in.readString();
    this.extension = in.readString();
  }

  public static final Creator<ComicThumbnail> CREATOR = new Creator<ComicThumbnail>() {
    public ComicThumbnail createFromParcel(Parcel source) {
      return new ComicThumbnail(source);
    }

    public ComicThumbnail[] newArray(int size) {
      return new ComicThumbnail[size];
    }
  };
}

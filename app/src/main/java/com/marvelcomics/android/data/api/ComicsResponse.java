package com.marvelcomics.android.data.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.marvelcomics.android.data.model.ComicData;
import java.io.Serializable;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicsResponse implements Serializable, Parcelable {

  private static final long serialVersionUID = 3345809042578205811L;

  private int code;
  private String status;
  private String copyright;
  private String attributionText;
  private String attributionHTML;
  private String etag;
  private ComicData data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public String getAttributionText() {
    return attributionText;
  }

  public void setAttributionText(String attributionText) {
    this.attributionText = attributionText;
  }

  public String getAttributionHTML() {
    return attributionHTML;
  }

  public void setAttributionHTML(String attributionHTML) {
    this.attributionHTML = attributionHTML;
  }

  public String getEtag() {
    return etag;
  }

  public void setEtag(String etag) {
    this.etag = etag;
  }

  public ComicData getData() {
    return data;
  }

  public void setData(ComicData data) {
    this.data = data;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.code);
    dest.writeString(this.status);
    dest.writeString(this.copyright);
    dest.writeString(this.attributionText);
    dest.writeString(this.attributionHTML);
    dest.writeString(this.etag);
    dest.writeParcelable(this.data, flags);
  }

  public ComicsResponse() {
    //
  }

  protected ComicsResponse(Parcel in) {
    this.code = in.readInt();
    this.status = in.readString();
    this.copyright = in.readString();
    this.attributionText = in.readString();
    this.attributionHTML = in.readString();
    this.etag = in.readString();
    this.data = in.readParcelable(ComicData.class.getClassLoader());
  }

  public static final Creator<ComicsResponse> CREATOR = new Creator<ComicsResponse>() {
    public ComicsResponse createFromParcel(Parcel source) {
      return new ComicsResponse(source);
    }

    public ComicsResponse[] newArray(int size) {
      return new ComicsResponse[size];
    }
  };
}

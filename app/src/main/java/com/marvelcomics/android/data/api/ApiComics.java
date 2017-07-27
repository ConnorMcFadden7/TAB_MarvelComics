package com.marvelcomics.android.data.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public interface ApiComics {
//http://gateway.marvel.com/v1/public/comics
  @GET("v1/public/comics?apikey=54306733de0f5cd1418aa05a85fa062a") Observable<Object> getComics();
}

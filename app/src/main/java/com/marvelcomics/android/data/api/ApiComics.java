package com.marvelcomics.android.data.api;

import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public interface ApiComics {

  @GET("v1/public/comics?ts=2&apikey=54306733de0f5cd1418aa05a85fa062a&hash=429a61f7f2f58f70f7d35cc5034a95dc&limit=100")
  Observable<ComicsResponse> getComics(@QueryMap Map<String, Object> params);
}

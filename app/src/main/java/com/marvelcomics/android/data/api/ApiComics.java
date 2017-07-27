package com.marvelcomics.android.data.api;

import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public interface ApiComics {

  @GET("v1/public/comics") Observable<ComicsResponse> getComics(
      @QueryMap Map<String, Object> params);
}

package com.marvelcomics.android.domain.repository;

import com.marvelcomics.android.data.api.ApiComics;
import com.marvelcomics.android.data.api.ComicsResponse;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicsRepository {

  private final ApiComics apiComics;

  @Inject public ComicsRepository(ApiComics apiComics) {
    this.apiComics = apiComics;
  }

  public Observable<ComicsResponse> getComics(Map<String, Object> params) {
    return apiComics.getComics(params)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}

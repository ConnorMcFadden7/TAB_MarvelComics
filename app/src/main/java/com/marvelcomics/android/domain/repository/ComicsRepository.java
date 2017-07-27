package com.marvelcomics.android.domain.repository;

import com.marvelcomics.android.data.api.ApiComics;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicsRepository {

  private final ApiComics apiComics;

  @Inject ComicsRepository(ApiComics apiComics) {
    this.apiComics = apiComics;
  }

  public Observable<Object> getComics() {
    return apiComics.getComics()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}

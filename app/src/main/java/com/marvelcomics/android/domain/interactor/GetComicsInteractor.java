package com.marvelcomics.android.domain.interactor;

import android.util.Log;
import com.marvelcomics.android.data.api.ApiConfig;
import com.marvelcomics.android.data.api.ComicsResponse;
import com.marvelcomics.android.domain.repository.ComicsRepository;
import com.marvelcomics.android.util.Md5Utils;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class GetComicsInteractor {

  private static final int COMICS_REQ_LIMIT = 100;

  private final ComicsRepository comicsRepository;

  @Inject GetComicsInteractor(ComicsRepository comicsRepository) {
    this.comicsRepository = comicsRepository;
  }

  public void getComics() {
    comicsRepository.getComics(configureParams()).subscribe(new Consumer<ComicsResponse>() {
      @Override public void accept(@NonNull ComicsResponse comicsResponse) throws Exception {
        Log.e("GetComitsInt", "count: " + comicsResponse.getData().getResults().size());
      }
    }, new Consumer<Throwable>() {
      @Override public void accept(@NonNull Throwable throwable) throws Exception {

      }
    });
  }

  private Map<String, Object> configureParams() {
    Map<String, Object> params = new HashMap<>();
    //params.put("ts", 5);
    //   params.put("apikey", ApiConfig.PUBLIC_KEY);
    // params.put("hash", Md5Utils.toMd5(
    //     String.valueOf(5) + ApiConfig.PRIVATE_KEY + ApiConfig.PUBLIC_KEY));

    Log.e("GetComics",
        "String.valueOf(System.currentTimeMillis()) + ApiConfig.PRIVATE_KEY + ApiConfig.PUBLIC_KEY: "
            + String.valueOf(5)
            + ApiConfig.PRIVATE_KEY
            + ApiConfig.PUBLIC_KEY);
    Log.e("GetComics",
        "md5: " + Md5Utils.toMd5(String.valueOf(5) + ApiConfig.PRIVATE_KEY + ApiConfig.PUBLIC_KEY));
    //  params.put("limit", COMICS_REQ_LIMIT);
    return params;
  }
}

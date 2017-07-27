package com.marvelcomics.android.domain.interactor;

import com.marvelcomics.android.data.api.ApiConfig;
import com.marvelcomics.android.data.api.ComicsResponse;
import com.marvelcomics.android.data.model.ErrorType;
import com.marvelcomics.android.domain.DataListener;
import com.marvelcomics.android.domain.repository.ComicsRepository;
import com.marvelcomics.android.presentation.mapper.MainModelMapper;
import com.marvelcomics.android.presentation.presenter.model.MainModel;
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
  private final MainModelMapper mainModelMapper;

  @Inject GetComicsInteractor(ComicsRepository comicsRepository, MainModelMapper mainModelMapper) {
    this.comicsRepository = comicsRepository;
    this.mainModelMapper = mainModelMapper;
  }

  public void getComics(final DataListener<MainModel> dataListener) {
    comicsRepository.getComics(configureParams()).subscribe(new Consumer<ComicsResponse>() {
      @Override public void accept(@NonNull ComicsResponse comicsResponse) throws Exception {
        dataListener.onData(mainModelMapper.map(comicsResponse.getData().getResults()));
        dataListener.onSuccess();
      }
    }, new Consumer<Throwable>() {
      @Override public void accept(@NonNull Throwable throwable) throws Exception {
        dataListener.onError("", ErrorType.GENERIC);
      }
    });
  }

  private Map<String, Object> configureParams() {
    Map<String, Object> params = new HashMap<>();
    params.put("ts", System.currentTimeMillis());
    params.put("apikey", ApiConfig.PUBLIC_KEY);
    String hash = Md5Utils.toMd5(
        String.valueOf(System.currentTimeMillis()) + ApiConfig.PRIVATE_KEY + ApiConfig.PUBLIC_KEY);
    params.put("hash", hash);
    params.put("limit", COMICS_REQ_LIMIT);
    return params;
  }
}

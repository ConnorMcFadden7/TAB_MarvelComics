package com.marvelcomics.android.domain.interactor;

import android.util.Log;
import com.marvelcomics.android.domain.repository.ComicsRepository;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class GetComicsInteractor {

  private final ComicsRepository comicsRepository;

  @Inject GetComicsInteractor(ComicsRepository comicsRepository) {
    this.comicsRepository = comicsRepository;
  }

  public void getComics() {
    comicsRepository.getComics().subscribe(new Consumer<Object>() {
      @Override public void accept(@NonNull Object o) throws Exception {
        //
        Log.e("GetComicsInteractor", "accept");
      }
    }, new Consumer<Throwable>() {
      @Override public void accept(@NonNull Throwable throwable) throws Exception {
        //

        Log.e("GetComicsInteractor", "throwable: " +throwable.getLocalizedMessage());

      }
    });
  }
}

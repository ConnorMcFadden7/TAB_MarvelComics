package com.marvelcomics.android.presentation.presenter;

import com.marvelcomics.android.data.model.ErrorType;
import com.marvelcomics.android.domain.DataListener;
import com.marvelcomics.android.domain.interactor.GetComicsInteractor;
import com.marvelcomics.android.presentation.presenter.model.MainModel;
import com.marvelcomics.android.presentation.presenter.view.MainView;
import com.marvelcomics.android.util.NetworkUtil;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class MainPresenter {

  private final GetComicsInteractor getComicsInteractor;
  private final NetworkUtil networkUtil;
  private MainView view;

  @Inject MainPresenter(GetComicsInteractor getComicsInteractor, NetworkUtil networkUtil) {
    this.getComicsInteractor = getComicsInteractor;
    this.networkUtil = networkUtil;
  }

  public void present(MainView view) {
    this.view = view;
    bindView();
  }

  private void bindView() {
    getComics();
  }

  private void getComics() {
    if (networkUtil.isConnected()) {
      getComicsInteractor.getComics(new DataListener<MainModel>() {
        @Override public void onData(MainModel type) {

        }

        @Override public void onSuccess() {

        }

        @Override public void onError(String message, ErrorType errorType) {
          //todo show some error
        }
      });
    } else {
      //view show
    }
  }
}

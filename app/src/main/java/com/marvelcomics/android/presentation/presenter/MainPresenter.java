package com.marvelcomics.android.presentation.presenter;

import com.marvelcomics.android.domain.interactor.GetComicsInteractor;
import com.marvelcomics.android.presentation.presenter.view.MainView;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class MainPresenter {

  private final GetComicsInteractor getComicsInteractor;
  private MainView view;

  @Inject MainPresenter(GetComicsInteractor getComicsInteractor) {
    this.getComicsInteractor = getComicsInteractor;
  }

  public void present(MainView view) {
    this.view = view;
    bindView();
  }

  private void bindView() {
    getComics();
  }

  private void getComics() {
    getComicsInteractor.getComics();
  }
}

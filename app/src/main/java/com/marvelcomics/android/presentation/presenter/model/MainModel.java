package com.marvelcomics.android.presentation.presenter.model;

import com.marvelcomics.android.data.model.Comic;
import java.util.List;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class MainModel {

  final List<Comic> comics;

  public MainModel(List<Comic> comics) {
    this.comics = comics;
  }

  public List<Comic> getComics() {
    return comics;
  }
}

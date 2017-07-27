package com.marvelcomics.android.presentation.mapper;

import com.marvelcomics.android.data.model.Comic;
import com.marvelcomics.android.presentation.presenter.model.MainModel;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class MainModelMapper {

  @Inject MainModelMapper() {

  }

  public MainModel map(List<Comic> comics) {
    return new MainModel(comics);
  }
}

package com.marvelcomics.android.presentation.presenter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import butterknife.ButterKnife;
import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@AutoFactory public class MainView {

  public MainView(@NonNull View parent, @Provided Context context) {
    ButterKnife.bind(this, parent);
  }
}

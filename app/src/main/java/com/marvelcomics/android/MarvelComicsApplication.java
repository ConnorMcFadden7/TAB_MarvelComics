package com.marvelcomics.android;

import android.app.Application;
import com.marvelcomics.android.dagger.component.ApplicationComponent;
import com.marvelcomics.android.dagger.component.DaggerApplicationComponent;
import com.marvelcomics.android.dagger.module.ApplicationModule;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class MarvelComicsApplication extends Application {

  private ApplicationComponent mApplicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    initComponent();
    mApplicationComponent.inject(this);
  }

  protected void initComponent() {
    if (mApplicationComponent == null) {
      mApplicationComponent = DaggerApplicationComponent.builder()
          .applicationModule(new ApplicationModule(this))
          .build();
    }
  }

  public ApplicationComponent getApplicationComponent() {
    return mApplicationComponent;
  }
}

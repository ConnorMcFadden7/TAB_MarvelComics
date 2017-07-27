package com.marvelcomics.android.dagger.module;

import android.content.Context;
import com.marvelcomics.android.MarvelComicsApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@Module public class ApplicationModule {

  private final MarvelComicsApplication application;

  public ApplicationModule(MarvelComicsApplication application) {
    this.application = application;
  }

  @Provides Context provideContext() {
    return application.getApplicationContext();
  }
}


package com.marvelcomics.android.dagger.module;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import com.marvelcomics.android.dagger.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@Module public class ActivityModule {

  private final AppCompatActivity activity;

  public ActivityModule(AppCompatActivity activity) {
    this.activity = activity;
  }

  @Provides @ActivityScope public Activity provideActivity() {
    return activity;
  }
}

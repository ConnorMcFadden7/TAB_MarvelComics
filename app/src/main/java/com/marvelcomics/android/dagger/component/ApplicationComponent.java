package com.marvelcomics.android.dagger.component;

import com.marvelcomics.android.MarvelComicsApplication;
import com.marvelcomics.android.dagger.module.ActivityModule;
import com.marvelcomics.android.dagger.module.ApiModule;
import com.marvelcomics.android.dagger.module.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by connormcfadden on 27/07/2017.
 */
@Singleton @Component(modules = { ApplicationModule.class, ApiModule.class })
public interface ApplicationComponent {

  ActivityComponent from(ActivityModule activityModule);

  void inject(MarvelComicsApplication application);
}

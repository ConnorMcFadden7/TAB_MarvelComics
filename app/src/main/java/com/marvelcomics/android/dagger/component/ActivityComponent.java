package com.marvelcomics.android.dagger.component;

import android.app.Activity;
import com.marvelcomics.android.MainActivity;
import com.marvelcomics.android.dagger.module.ActivityModule;
import com.marvelcomics.android.dagger.scope.ActivityScope;
import com.marvelcomics.android.presentation.view.activity.BaseActivity;
import dagger.Subcomponent;

/**
 * Created by connormcfadden on 27/07/2017.
 */
@ActivityScope @Subcomponent(modules = ActivityModule.class) public interface ActivityComponent {

  Activity activity();

  void inject(MainActivity activity);

  void inject(BaseActivity activity);
}

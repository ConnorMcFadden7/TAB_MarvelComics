package com.marvelcomics.android.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.marvelcomics.android.MarvelComicsApplication;
import com.marvelcomics.android.dagger.component.ActivityComponent;
import com.marvelcomics.android.dagger.component.ApplicationComponent;
import com.marvelcomics.android.dagger.module.ActivityModule;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

  private ActivityComponent mActivityComponent;
  private Unbinder unbinder = Unbinder.EMPTY;
  private boolean mDestroyed = false;
  private boolean mIsResumed = false;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    mActivityComponent = getApplicationComponent().from(new ActivityModule(this));
    injectActivity(mActivityComponent);
    mIsResumed = true;
  }

  @Override public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    unbinder = ButterKnife.bind(this);
  }

  @Override protected void onResume() {
    mIsResumed = true;
    super.onResume();
  }

  @Override protected void onDestroy() {
    mIsResumed = false;
    mDestroyed = true;
    unbinder.unbind();
    super.onDestroy();
  }

  protected void injectActivity(ActivityComponent activityComponent) {
    mActivityComponent.inject(this);
  }

  protected boolean isActivityDestroyed() {
    return mDestroyed;
  }

  public boolean isSafe() {
    return !isActivityDestroyed() && !isFinishing();
  }

  public boolean canCommitFragmentTransaction() {
    return isSafe() && !getSupportFragmentManager().isDestroyed() && mIsResumed;
  }

  public ActivityComponent getActivityComponent() {
    return mActivityComponent;
  }

  private ApplicationComponent getApplicationComponent() {
    return ((MarvelComicsApplication) getApplication()).getApplicationComponent();
  }
}


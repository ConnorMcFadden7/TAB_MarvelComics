package com.marvelcomics.android.presentation.view.activity;

import android.os.Bundle;
import com.marvelcomics.android.R;
import com.marvelcomics.android.dagger.component.ActivityComponent;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override protected void injectActivity(ActivityComponent activityComponent) {
    activityComponent.inject(this);
  }
}

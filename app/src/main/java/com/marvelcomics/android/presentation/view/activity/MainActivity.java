package com.marvelcomics.android.presentation.view.activity;

import android.os.Bundle;
import android.view.View;
import butterknife.BindView;
import com.marvelcomics.android.R;
import com.marvelcomics.android.dagger.component.ActivityComponent;
import com.marvelcomics.android.presentation.presenter.MainPresenter;
import com.marvelcomics.android.presentation.presenter.view.MainViewFactory;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @BindView(R.id.container_main) View mParent;

  @Inject MainPresenter mMainPresenter;
  @Inject MainViewFactory mMainViewFactory;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    presentMain();
  }

  @Override protected void injectActivity(ActivityComponent activityComponent) {
    activityComponent.inject(this);
  }

  private void presentMain() {
    mMainPresenter.present(mMainViewFactory.create(mParent));
  }
}

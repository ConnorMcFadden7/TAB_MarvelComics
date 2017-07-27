package com.marvelcomics.android.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import butterknife.BindView;
import com.marvelcomics.android.R;
import com.marvelcomics.android.dagger.component.ActivityComponent;
import com.marvelcomics.android.data.model.CreatorDetails;
import com.marvelcomics.android.presentation.presenter.ComicPresenter;
import com.marvelcomics.android.presentation.presenter.view.ComicViewFactory;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicActivity extends BaseActivity {

  public static final String EXTRA_COMIC_TITLE = "extra_comic_title";
  public static final String EXTRA_COMIC_DESCRIPTION = "extra_comic_description";
  public static final String EXTRA_COMIC_PAGE_COUNT = "extra_comic_page_count";
  public static final String EXTRA_COMIC_PRICE = "extra_comic_page_price";
  public static final String EXTRA_COMIC_AUTHORS = "extra_comic_page_authors";

  @BindView(R.id.container_comic) View mParent;

  @Inject ComicPresenter mComicPresenter;
  @Inject ComicViewFactory mComicViewFactory;

  private String mComicTitle;
  private String mDescription;
  private int mPageCount;
  private double mPrice;
  private List<CreatorDetails> mCreators;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_comic);
    Intent intent = getIntent();
    if (intent != null) {
      mComicTitle = intent.getStringExtra(EXTRA_COMIC_TITLE);
      mDescription = intent.getStringExtra(EXTRA_COMIC_DESCRIPTION);
      mPageCount = intent.getIntExtra(EXTRA_COMIC_PAGE_COUNT, 0);
      mPrice = intent.getDoubleExtra(EXTRA_COMIC_PRICE, 0.0);
      mCreators = intent.getParcelableArrayListExtra(EXTRA_COMIC_AUTHORS);
    }
    presentComicScreen();
    initActionBar();
  }

  @Override protected void injectActivity(ActivityComponent activityComponent) {
    activityComponent.inject(this);
  }

  private void presentComicScreen() {
    mComicPresenter.present(mComicViewFactory.create(mParent), mComicTitle, mDescription,
        mPageCount, mPrice, mCreators);
  }

  private void initActionBar() {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(mComicTitle);
    }
  }
}

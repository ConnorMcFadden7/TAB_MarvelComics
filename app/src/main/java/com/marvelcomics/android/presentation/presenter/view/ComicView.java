package com.marvelcomics.android.presentation.presenter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import com.marvelcomics.android.R;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@AutoFactory public class ComicView {

  @BindView(R.id.tv_title) TextView tvTitle;
  @BindView(R.id.tv_description) TextView tvDescription;
  @BindView(R.id.tv_pagecount) TextView tvPageCount;
  @BindView(R.id.tv_price) TextView tvPrice;
  @BindView(R.id.tv_authors) TextView tvAuthors;

  public ComicView(@NonNull View parent, @Provided Context context) {
    ButterKnife.bind(this, parent);
  }

  public void setTitle(String title) {
    tvTitle.setText(title);
  }

  public void setDescription(String description) {
    tvDescription.setText(description);
  }

  public void setPageCount(String pageCount) {
    tvPageCount.setText(pageCount);
  }

  public void setPrice(String price) {
    tvPrice.setText(price);
  }

  public void setAuthors(String authors) {
    tvAuthors.setText(authors);
  }
}

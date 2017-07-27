package com.marvelcomics.android.presentation.presenter;

import android.text.TextUtils;
import com.marvelcomics.android.data.model.CreatorDetails;
import com.marvelcomics.android.presentation.presenter.view.ComicView;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicPresenter {

  private ComicView view;
  private String comicTitle;
  private String description;
  private int pageCount;
  private double price;
  private List<CreatorDetails> creators;

  @Inject ComicPresenter() {
    //
  }

  public void present(ComicView view, String comicTitle, String description, int pageCount,
      double price, List<CreatorDetails> creators) {
    this.view = view;
    this.comicTitle = comicTitle;
    this.description = description;
    this.pageCount = pageCount;
    this.price = price;
    this.creators = creators;
    bindView();
  }

  private void bindView() {
    if (!TextUtils.isEmpty(comicTitle)) {
      view.setTitle(comicTitle);
    }

    if (!TextUtils.isEmpty(description)) {
      view.setDescription(description);
    }

    view.setPageCount(String.valueOf(pageCount));
    view.setPrice(String.valueOf(price));

    StringBuilder listString = new StringBuilder();
    if (creators != null && !creators.isEmpty()) {
      for (CreatorDetails creatorDetails : creators) {
        if (!TextUtils.isEmpty(creatorDetails.getName())) {
          listString.append(creatorDetails.getName() + ", ");
          view.setAuthors(listString.toString());
        }
      }
    }
  }
}

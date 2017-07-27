package com.marvelcomics.android.presentation.presenter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import com.marvelcomics.android.R;
import com.marvelcomics.android.presentation.view.adapter.ComicAdapter;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@AutoFactory public class MainView {

  @BindView(R.id.rv_comics) RecyclerView rvComics;
  @BindView(R.id.pb_loader) ProgressBar pbLoader;

  private final Context context;

  public MainView(@NonNull View parent, @Provided Context context) {
    ButterKnife.bind(this, parent);
    this.context = context;
  }

  public void setComicAdapter(ComicAdapter comicAdapter) {
    rvComics.setAdapter(comicAdapter);
    rvComics.setLayoutManager(new LinearLayoutManager(context));
    comicAdapter.notifyDataSetChanged();
  }

  public void showLoading(boolean shouldShow) {
    pbLoader.setVisibility(shouldShow ? View.VISIBLE : View.GONE);
  }
}

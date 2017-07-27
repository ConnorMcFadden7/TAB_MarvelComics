package com.marvelcomics.android.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.marvelcomics.android.R;
import com.marvelcomics.android.data.model.Comic;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private List<Comic> mComics;

  @Inject ComicAdapter() {
    //
  }

  public void setData(List<Comic> comics) {
    mComics = comics;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ComicViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false));
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ComicViewHolder comicViewHolder = (ComicViewHolder) holder;
    comicViewHolder.bind(mComics.get(position));
  }

  @Override public int getItemCount() {
    return mComics.size();
  }
}

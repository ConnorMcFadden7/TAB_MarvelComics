package com.marvelcomics.android.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.marvelcomics.android.R;
import com.marvelcomics.android.data.model.Comic;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.tv_comic_title) TextView tvComicTitle;
  @BindView(R.id.sdv_comic_thumbnail) SimpleDraweeView sdvComicThumbnail;

  public ComicViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void bind(Comic comic) {
    tvComicTitle.setText(comic.getTitle());
    sdvComicThumbnail.setImageURI(comic.getThumbnail().getFullImagePath());
  }
}

package com.marvelcomics.android.presentation.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.marvelcomics.android.R;
import com.marvelcomics.android.data.model.Comic;
import com.marvelcomics.android.presentation.view.activity.ComicActivity;
import java.util.ArrayList;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class ComicViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.tv_comic_title) TextView tvComicTitle;
  @BindView(R.id.sdv_comic_thumbnail) SimpleDraweeView sdvComicThumbnail;

  private final Context context;
  private Comic comic;

  public ComicViewHolder(View itemView, Context context) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    this.context = context;
  }

  @OnClick(R.id.container_item_comic) public void onItemClick() {
    Intent intent = new Intent(context, ComicActivity.class);
    intent.putExtra(ComicActivity.EXTRA_COMIC_TITLE, comic.getTitle());
    intent.putExtra(ComicActivity.EXTRA_COMIC_DESCRIPTION, comic.getDescription());
    intent.putExtra(ComicActivity.EXTRA_COMIC_PAGE_COUNT, comic.getPageCount());
    intent.putExtra(ComicActivity.EXTRA_COMIC_PRICE, comic.getPrices().get(0).getPrice());
    intent.putParcelableArrayListExtra(ComicActivity.EXTRA_COMIC_AUTHORS,
        (ArrayList) comic.getCreators().getItems());
    context.startActivity(intent);
  }

  public void bind(Comic comic) {
    this.comic = comic;
    tvComicTitle.setText(comic.getTitle());
    sdvComicThumbnail.setImageURI(comic.getThumbnail().getFullImagePath());
  }
}

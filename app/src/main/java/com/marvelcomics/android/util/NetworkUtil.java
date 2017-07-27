package com.marvelcomics.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import javax.inject.Inject;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class NetworkUtil {

  private final Context context;

  @Inject NetworkUtil(Context context) {
    this.context = context;
  }

  public boolean isConnected() {
    ConnectivityManager mManager =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo current = mManager.getActiveNetworkInfo();
    return current != null && current.isConnectedOrConnecting();
  }
}

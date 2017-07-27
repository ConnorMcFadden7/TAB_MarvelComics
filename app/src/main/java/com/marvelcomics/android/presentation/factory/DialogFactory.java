package com.marvelcomics.android.presentation.factory;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import com.marvelcomics.android.R;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class DialogFactory {

  public static void showNoInternetDialog(final Activity activity) {
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
      }
    });
    builder.setPositiveButton(R.string.errors_no_internet_connection_cta,
        new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialogInterface, int i) {
            Intent settingsIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
            settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(settingsIntent);
          }
        });
    builder.setTitle(R.string.errors_no_internet_connection_title);
    builder.setMessage(R.string.errors_no_internet_connection_message);
    builder.show();
  }
}

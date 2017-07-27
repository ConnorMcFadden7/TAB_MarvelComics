package com.marvelcomics.android.domain;

import com.marvelcomics.android.data.model.ErrorType;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public interface DataListener<T> {

  DataListener NULL = new DataListener() {
    @Override public void onData(Object type) {
      //
    }

    @Override public void onSuccess() {
      //
    }

    @Override public void onError(String message, ErrorType errorType) {
      //
    }
  };

  /**
   * Called when the api request has been successful and returns us some data.
   */
  void onData(T type);

  /**
   * Called when the api request has been successful.
   */
  void onSuccess();

  /**
   * Called when the database/api request has encountered an error with an already formatted error
   * message.
   */
  void onError(String message, ErrorType errorType);
}

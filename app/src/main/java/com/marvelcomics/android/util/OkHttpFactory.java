package com.marvelcomics.android.util;

import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class OkHttpFactory {

  public static final int CONNECT_TIMEOUT = 15;
  public static final int READ_TIMEOUT = 15;
  public static final int WRITE_TIMEOUT = 15;

  @Inject OkHttpFactory() {
  }

  public OkHttpClient.Builder createHttpClientBuilder() {
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    final OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(logging);

    return builder;
  }

  public OkHttpClient createHttpClient() {
    return createHttpClientBuilder().build();
  }
}

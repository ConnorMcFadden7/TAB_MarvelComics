package com.marvelcomics.android.dagger.module;

import com.marvelcomics.android.dagger.named.ApiClient;
import com.marvelcomics.android.dagger.named.Shared;
import com.marvelcomics.android.dagger.named.Unique;
import com.marvelcomics.android.util.OkHttpFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@Module public class NetworkModule {

  @Provides @Singleton @Shared OkHttpClient provideSharedOkHttpClient(OkHttpFactory okHttpFactory) {
    return okHttpFactory.createHttpClient();
  }

  @Provides @Unique OkHttpClient provideNewOkHttpClient(OkHttpFactory okHttpFactory) {
    return okHttpFactory.createHttpClient();
  }

  @Provides @ApiClient OkHttpClient provideRestAdapterBuilder(OkHttpFactory okHttpFactory) {
    return okHttpFactory.createHttpClientBuilder().followRedirects(false).build();
  }
}

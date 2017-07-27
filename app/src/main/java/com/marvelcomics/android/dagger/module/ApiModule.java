package com.marvelcomics.android.dagger.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marvelcomics.android.dagger.named.ApiClient;
import com.marvelcomics.android.data.api.ApiComics;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@Module(includes = NetworkModule.class) public class ApiModule {

  @Provides Retrofit.Builder provideRestAdapterBuilderVersionOnePointOne(
      @ApiClient OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
    return new Retrofit.Builder().baseUrl("http://gateway.marvel.com/")
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient);
  }

  @Provides @Singleton Retrofit provideRetrofit(Retrofit.Builder retrofitBuilder) {
    return retrofitBuilder.build();
  }

  @Provides Gson provideGson() {
    return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setDateFormat("EEE, dd MMM yyyy HH:mm:ss z")
        .create();
  }

  @Provides GsonConverterFactory provideGsonConverter(Gson gson) {
    return GsonConverterFactory.create(gson);
  }

  @Provides ApiComics provideComicsApi(Retrofit retrofit) {
    return retrofit.create(ApiComics.class);
  }
}

package com.marvelcomics.android.dagger.named;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@Qualifier @Documented @Retention(RetentionPolicy.RUNTIME) public @interface ApiClient {
}

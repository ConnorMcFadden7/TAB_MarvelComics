package com.marvelcomics.android.domain.repository;

import com.marvelcomics.android.data.api.ApiComics;
import com.marvelcomics.android.data.api.ComicsResponse;
import com.marvelcomics.android.factory.TestDataFactory;
import com.marvelcomics.android.rules.RxSchedulersOverrideRule;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by connormcfadden on 27/07/2017.
 */

@RunWith(MockitoJUnitRunner.class) public class ComicsRepositoryTest {

  @Mock ApiComics mApiComics;
  ComicsRepository mComicsRepository;

  @Rule public final RxSchedulersOverrideRule mOverrideSchedulersRule =
      new RxSchedulersOverrideRule();

  @Before public void setUp() {
    mComicsRepository = new ComicsRepository(mApiComics);
  }

  @Test public void test_getComics() {
    ComicsResponse comicsResponse = TestDataFactory.createComicsResponse();

    when(mApiComics.getComics(null)).thenReturn(Observable.just(comicsResponse));

    TestObserver<ComicsResponse> testObserver = mComicsRepository.getComics(null).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertNoErrors();
    testObserver.assertValue(comicsResponse);
  }
}

package com.marvelcomics.android.rules;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class RxSchedulersOverrideRule implements TestRule {

  @Override public Statement apply(final Statement base, Description description) {
    return new Statement() {
      @Override public void evaluate() throws Throwable {
        RxAndroidPlugins.reset();
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
            new Function<Callable<Scheduler>, Scheduler>() {
              @Override public Scheduler apply(@NonNull Callable<Scheduler> schedulerCallable)
                  throws Exception {
                return Schedulers.trampoline();
              }
            });
        base.evaluate();

        RxAndroidPlugins.reset();
        RxJavaPlugins.reset();
      }
    };
  }
}

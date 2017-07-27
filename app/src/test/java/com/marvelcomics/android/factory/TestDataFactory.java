package com.marvelcomics.android.factory;

import com.marvelcomics.android.data.api.ComicsResponse;
import com.marvelcomics.android.data.model.Comic;
import com.marvelcomics.android.data.model.ComicData;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class TestDataFactory {

  public static ComicsResponse createComicsResponse() {
    ComicsResponse comicsResponse = new ComicsResponse();
    comicsResponse.setData(createComicData());
    return comicsResponse;
  }

  public static ComicData createComicData() {
    ComicData comicData = new ComicData();
    comicData.setResults(createComics());
    return comicData;
  }

  public static List<Comic> createComics() {
    List<Comic> comics = new ArrayList<>();
    comics.add(createComic("Spiderman vs Batman"));
    comics.add(createComic("The Avengers"));
    comics.add(createComic("Beerman"));
    return comics;
  }

  public static Comic createComic(String title) {
    Comic comic = new Comic();
    comic.setTitle(title);
    return comic;
  }
}

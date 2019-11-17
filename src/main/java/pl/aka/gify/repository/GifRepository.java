package pl.aka.gify.repository;

import pl.aka.gify.model.Gif;

import java.util.List;

public interface GifRepository {

    List<Gif> findAll();
    Gif findByName(String name);
    List<Gif> findFavorite();
    List<Gif> findByCategoryId(Integer id);
}

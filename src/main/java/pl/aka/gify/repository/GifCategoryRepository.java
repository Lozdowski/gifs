package pl.aka.gify.repository;

import pl.aka.gify.model.Category;

import java.util.List;

public interface GifCategoryRepository {

    List<Category> findAll();


    Category finById(Integer id);
}

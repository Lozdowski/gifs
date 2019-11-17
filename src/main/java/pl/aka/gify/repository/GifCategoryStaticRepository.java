package pl.aka.gify.repository;

import pl.aka.gify.model.Category;

import java.util.ArrayList;
import java.util.List;

public class GifCategoryStaticRepository implements GifCategoryRepository {

    private static List<Category> categories = new ArrayList<>();

    static{
        categories.add(new Category(1,"funny"));
        categories.add(new Category(2,"blow"));
        categories.add(new Category(3,"r-b"));
    }


    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Category finById(Integer id) {
        for (Category category : categories) {
            if(category.getId()==id){
                return category;
            }
        }
        return null;
    }
}

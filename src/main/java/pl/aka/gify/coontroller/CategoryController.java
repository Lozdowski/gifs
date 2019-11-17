package pl.aka.gify.coontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.aka.gify.repository.GifCategoryRepository;
import pl.aka.gify.repository.GifCategoryStaticRepository;
import pl.aka.gify.repository.GifRepository;
import pl.aka.gify.repository.GifStaticRepository;

@Controller
public class CategoryController {

    private GifCategoryRepository gifCategoryRepository = new GifCategoryStaticRepository();
    private GifRepository gifRepository = new GifStaticRepository();


    @GetMapping("/categories")
    public String getAllCategories(ModelMap map){
        map.put("categories",gifCategoryRepository.findAll());
        return "categories";
    }
    @GetMapping("/category/{id}")
    public String show(@PathVariable Integer id, ModelMap map){
        map.put("category",gifCategoryRepository.finById(id));
        map.put("gifs",gifRepository.findByCategoryId(id));
        return "category";
    }

}

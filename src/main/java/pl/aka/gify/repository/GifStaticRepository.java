package pl.aka.gify.repository;

import pl.aka.gify.model.Gif;
import pl.aka.gify.model.Category;
import sun.net.www.content.image.gif;

import java.util.ArrayList;
import java.util.List;

public class GifStaticRepository implements GifRepository {

    private static List<Gif> gifs = new ArrayList<>();

    static{
        GifCategoryRepository categoryRepository = new GifCategoryStaticRepository();
        List<Category> categories = categoryRepository.findAll();
        gifs.add(new Gif(2, "ben-and-mike",false,categoryRepository.finById(1)));
        gifs.add(new Gif(3,"book-dominos",true,categoryRepository.finById(2)));
        gifs.add(new Gif(4,"compiler-bot",false,categoryRepository.finById(3)));
        gifs.add(new Gif(5,"cowboy -coder",true,categoryRepository.finById(3)));
        gifs.add(new Gif(6,"infinite-andrew",false,categoryRepository.finById(1)));

    }
    @Override
    public List<Gif> findAll() {
        return gifs;
    }

    @Override
    public Gif findByName(String name) {
        for(Gif gif : gifs){
            if(gif.getName().equals(name)){
                return gif;
            }
        }
        return null;
    }

    @Override
    public List<Gif> findFavorite() {
        List<Gif> fav = new ArrayList<>();
        for(Gif g : gifs){
            if(g.isFavorite()){
                fav.add(g);
            }
        }
        return fav;
    }

    @Override
    public List<Gif> findByCategoryId(Integer id) {
        List<Gif> gifyy = new ArrayList<>();
        for (Gif gif : gifs) {
            if(gif.getCategory().getId()==id){
                gifyy.add(gif);
            }
        }
        return gifyy;
    }
}

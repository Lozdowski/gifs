package pl.aka.gify.coontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.aka.gify.repository.GifCategoryRepository;
import pl.aka.gify.repository.GifCategoryStaticRepository;
import pl.aka.gify.repository.GifRepository;
import pl.aka.gify.repository.GifStaticRepository;

import java.util.Arrays;

@Controller
public class GifController {

    GifRepository gifRepository = new GifStaticRepository();

    @GetMapping("/")
    public String home(@RequestParam(required = false) String q, ModelMap map){
        if(q != null){
           map.put("gifs",Arrays.asList(gifRepository.findByName(q)));
        }
        else map.put("gifs",gifRepository.findAll());
        return "home";

    }
    @GetMapping("/gif/{name}")
    public String show(@PathVariable String name,ModelMap map){
        map.put("gif",gifRepository.findByName(name));
                return "gif-details";

    }
    @GetMapping("/favorites")
    public String getFavorite(ModelMap map){
        map.put("gifs",gifRepository.findFavorite());
        return "favorites";
    }
    }


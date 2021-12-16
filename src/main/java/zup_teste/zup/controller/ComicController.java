package zup_teste.zup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import zup_teste.zup.model.Author;
import zup_teste.zup.model.Comic;
import zup_teste.zup.proxy.ComicForm;
import zup_teste.zup.proxy.ComicResponse;
import zup_teste.zup.proxy.MarvelFeign;
import zup_teste.zup.proxy.ResultsResponse;
import zup_teste.zup.repository.AuthorRepository;
import zup_teste.zup.repository.ComicRepository;
import zup_teste.zup.repository.UserRepository;

@RestController

public class ComicController {
    @Value("${marvel.md5}")
    private String md5;

    @Value("${marvel.apikey}")
    private String apikey;

    @Value("${marvel.ts}")
    private Integer timestamp;

    @Autowired
    MarvelFeign feign;

    @Autowired
    ComicRepository comicRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/comic/add")
    //public Comic insertComic(@PathVariable Integer comicId, @PathVariable String cpf) {
    public Comic insertComic(@RequestBody ComicForm comicForm) {

        ComicResponse c = feign.getComic(comicForm.getComicId(), timestamp, apikey, md5);
        // DataResponse d= c.getData();
        // List<ResultsResponse> l = d.getResults();
        ResultsResponse r = c.getData().getResults().get(0);
        // List<Prices> lp = r.getPrices();
        // Prices p = r.getPrices().get(0);
        // Creator cr = r.getCreators();
        List<Author> l = r.getCreators().getItems();
        for (Author a : l) 
            authorRepository.save(a);
        Comic comic = new Comic(comicForm.getComicId(), r.getTitle(), r.getPrices().get(0).getPrice(), r.getIsbn(), r.getDescription(), l, userRepository.getById(comicForm.getCpf()));
        //comic.setAutores(l);
        return comicRepository.save(comic);

    }


    @GetMapping("/comic/{comicId}")
    public Comic getComicById(@PathVariable Integer comicId) {
        if(comicRepository.findById(comicId).isPresent())
                return comicRepository.findById(comicId).get();
            else return  null;
    }
    
            

}

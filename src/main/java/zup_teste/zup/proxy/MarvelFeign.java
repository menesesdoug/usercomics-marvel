package zup_teste.zup.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "marvelAPI", url = "http://gateway.marvel.com/v1/")
public interface MarvelFeign {
    
    @RequestMapping(method = RequestMethod.GET, value = "public/comics?ts={timestamp}&apikey={apikey}&hash={md5}")
    String auth(@PathVariable (name= "timestamp") String timestamp, 
                @PathVariable (name= "apikey") String apikey,
                @PathVariable (name= "md5") String md5);

    @RequestMapping(method = RequestMethod.GET, value = "public/comics/{comicId}?ts={timestamp}&apikey={apikey}&hash={md5}")
    ComicResponse getComic(@PathVariable (name= "comicId") Integer comicId,
                    @PathVariable (name= "timestamp") Integer timestamp, 
                    @PathVariable (name= "apikey") String apikey,
                    @PathVariable (name= "md5") String md5);
                
}

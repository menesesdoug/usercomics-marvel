package zup_teste.zup.model;

import java.util.List;

public class UserDTOComics {
    private List<Comic> comics;

    public UserDTOComics() {
    }

    public UserDTOComics(List<Comic> comics) {
        this.comics = comics;
    }

    public List<Comic> getComics() {
        return this.comics;
    }

    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }
    
}

package zup_teste.zup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;
    
    @JsonIgnore
    @ManyToMany(mappedBy="autores")
    private List<Comic> comics;

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public Author(String name, List<Comic> comics) {
        this.name = name;
        this.comics = comics;
    }

    public List<Comic> getComics() {
        return this.comics;
    }

    public void setComic(List<Comic> comics) {
        this.comics = comics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
 
}

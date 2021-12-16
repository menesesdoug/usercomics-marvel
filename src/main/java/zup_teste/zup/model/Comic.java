package zup_teste.zup.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="comic")
//@SecondaryTable(name = "autoria", pkJoinColumns = {@PrimaryKeyJoinColumn(name= "id")})
public class Comic {
    @Id
    @NotNull(message = "ID é obrigatório")
    @Column(unique = true, nullable = false)
    private Integer id;

    @NotBlank(message = "Título é obrigatório")
    @Column(nullable = false, length = 100)
    private String title;
    
    @NotNull(message = "Preço é obrigatório")
    @Column(nullable = false)
    private float preco;

    @NotNull(message = "ISBN é obrigatório")
    @Column(unique = true, nullable = false, length = 30)
    private String isbn;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String description;
    
    @Column
    private boolean desconto;


    @ManyToMany
    @JoinTable(name= "comic_has_authors", joinColumns = @JoinColumn(name="comic_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    @Column(nullable = false)
    private List<Author> autores;

    @ManyToMany
    @JoinTable(name= "user_has_comics", joinColumns = @JoinColumn(name="comic_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
    @JsonIgnore
    private List<User> users;


    public Comic() {
    }


    public Comic(Integer id, String title, float preco, String isbn, String description, List<Author> autores, User u) {
        this.id = id;
        this.title = title;
        this.preco = preco;
        this.isbn = isbn;
        this.description = description;
        this.desconto = false;
        this.autores = autores;
        if(this.users == null){
            this.users = new ArrayList<>();
        }   
        this.users.add(u);
        
    }

    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDesconto() {
        return this.desconto;
    }

    public boolean getDesconto() {
        return this.desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    } 

    public List<Author> getAutores() {
        return this.autores;
    }

    public void setAutores(List<Author> autores) {
        this.autores = autores;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}

package zup_teste.zup.proxy;

import java.util.List;

public class ResultsResponse {
    private Integer id;
    private String title;
    private String isbn;
    private String description;
    private List<Prices> prices;
    private Creator creators;


    public ResultsResponse(Integer id, String title, String isbn, String description, List<Prices> prices, Creator creators) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.prices = prices;
        this.creators = creators;
    }

    
    public List<Prices> getPrices() {
        return prices;
    }



    public Creator getCreators() {
        return creators;
    }



    public void setCreators(Creator creators) {
        this.creators = creators;
    }



    public void setPrices(List<Prices> prices) {
        this.prices = prices;
    }



    public ResultsResponse() {
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}

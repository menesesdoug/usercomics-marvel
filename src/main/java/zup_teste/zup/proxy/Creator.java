package zup_teste.zup.proxy;

import java.util.List;

import zup_teste.zup.model.Author;

public class Creator {
   
    private List<Author> items;

    public Creator() {
    }

    public Creator(List<Author> items) {
        this.items = items;
    }

    public List<Author> getItems() {
        return this.items;
    }

    public void setItems(List<Author> items) {
        this.items = items;
    }

    
    
}

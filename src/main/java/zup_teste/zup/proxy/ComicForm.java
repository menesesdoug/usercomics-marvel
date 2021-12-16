package zup_teste.zup.proxy;

public class ComicForm {
    private String cpf;
    private Integer comicId;

    public ComicForm() {
    }

    public ComicForm(String cpf, Integer comicId) {
        this.cpf = cpf;
        this.comicId = comicId;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getComicId() {
        return this.comicId;
    }

    public void setComicId(Integer comicId) {
        this.comicId = comicId;
    }
}

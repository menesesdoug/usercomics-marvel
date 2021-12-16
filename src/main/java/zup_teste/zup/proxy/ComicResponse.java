package zup_teste.zup.proxy;

public class ComicResponse {
    
    private DataResponse data;

    public ComicResponse() {
    }

    public ComicResponse(DataResponse data) {
        this.data = data;
    }

    public DataResponse getData() {
        return data;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }

    
}

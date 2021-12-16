package zup_teste.zup.proxy;

import java.util.List;

public class DataResponse {

    private List<ResultsResponse> results;
    
    public DataResponse() {
    }


    public DataResponse(List<ResultsResponse> results) {
        this.results = results;
    }

    public List<ResultsResponse> getResults() {
        return this.results;
    }

    public void setResults(List<ResultsResponse> results) {
        this.results = results;
    }

   

   
}

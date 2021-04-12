package tn.esprit.spring.entity;

import java.util.ArrayList;
import java.util.List;

public class Bean {
    private int status;
    private String message;
    private List<Result> results;

    public Bean() {
        results = new ArrayList<>();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
    public void setResult(String url) {
        this.results.add(new Result(url));
    }

    class Result {
        private String url;

        public Result(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}

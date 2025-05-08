package br.com.fernandes.controller.response;

import java.util.List;

public class ApiResponse<T> {

    private T data;
    private String path;
    private List<String> error;

    public ApiResponse(T data, String path, List<String> error) {
        this.data = data;
        this.path = path;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

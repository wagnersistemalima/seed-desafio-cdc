package com.sistemalima.casadocodigodeveficiente.adapters.controller.entity;

import java.io.Serializable;

public class DefaultResponse<T> implements Serializable {

    private T data;

    public DefaultResponse() {
    }

    public DefaultResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

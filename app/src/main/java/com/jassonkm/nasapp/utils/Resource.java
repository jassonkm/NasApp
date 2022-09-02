package com.jassonkm.nasapp.utils;

import androidx.annotation.Nullable;
import retrofit2.Response;

public class Resource<T> {

    public static <T> Resource<T> error(Throwable error) {
        if (error == null) throw new NullPointerException("error == null");
        return new Resource<>(null, error);
    }

    public static <T> Resource<T> response(Response<T> response) {
        if (response == null) throw new NullPointerException("response == null");
        return new Resource<>(response, null);
    }

    private final @Nullable Response<T> response;
    private final @Nullable Throwable error;

    private Resource(@Nullable Response<T> response, @Nullable Throwable error) {
        this.response = response;
        this.error = error;
    }

    public @Nullable Response<T> response() {
        return response;
    }

    public @Nullable
    Throwable error() {
        return error;
    }

    public boolean isError() {
        return error != null;
    }
}

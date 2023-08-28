package com.c4ccup.laugh.controller.bean.res;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * APIの
 * @param <T>
 */
public class ApiResource<T> {

    public ApiResource(T data, Messages message) {
        if (data instanceof Messages) {
            this.data = null;
            this.message = (Messages)data;
        } else {
            this.data = data;
            this.message = message;
        }
    }

    public ApiResource(T data) { this(data, null); }
    public ApiResource() { this(null, null); }

    /** メッセージクラス */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Messages message;
    /** レスポンスデータ */
    private T data;

    /**
     *  メッセージクラスを取得します。
     * @return message
     */
    public List<String> getMessage() {
        return message == null ? null : message.getMessages();
    }

    /**
     * レスポンスデータを取得します。
     * @return data
     */
    public T getData() {
        return data;
    }
}

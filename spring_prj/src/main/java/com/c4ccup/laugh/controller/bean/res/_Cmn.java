package com.c4ccup.laugh.controller.bean.res;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class _Cmn {

    /** メッセージ */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> messages = new ArrayList<>();

    /**
     * メッセージを設定します。
     * @param メッセージ
     */
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    /**
     * メッセージを取得します。
     * @return
     */
    public List<String> getMessages()
    {
        return messages;
    }
}

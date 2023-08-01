package com.c4ccup.laugh.controller;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.c4ccup.laugh.controller.bean.res._Messages;

public class _CmnController {

    @Autowired
    MessageSource msgSrc;

    /**
     * 固定メッセージの取得
     * @param code
     * @return
     */
    public String getMessage(String code) {
        return this.getMsg(code, null);
    }

    /**
     * メッセージの取得
     * @param code
     * @param msgs
     * @return
     */
    public String getMessage(String code, String... msgs) {
        return this.getMsg(code, msgs);
    }

    /**
     * メッセージをマッピングする
     * @param code messages.properties のkey
     * @param msgs messages.properties の可変部分
     * @return
     */
    private String getMsg(String code, String[] msgs) {
        return msgSrc.getMessage(code, msgs, Locale.JAPAN);
    }

    /**
     * メッセージの返却
     * @param msgs
     * @return
     */
    public _Messages getReturnMsg(List<String> msgs) {
        _Messages messages = new _Messages();
        messages.setMessages(msgs);
        return messages;
    }

    /**
     * メッセージの返却
     * @param msg
     * @return
     */
    public _Messages getReturnMsg(String msg) {
        return this.getReturnMsg(Collections.singletonList(msg));
    }
}

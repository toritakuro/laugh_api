package com.c4ccup.laugh.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

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

    public Map<String ,List<String>> getReturnMsg(List<String> msgs) {
        Map<String ,List<String>> msg = new HashMap<>();
        msg.put("messages", msgs);
        return msg;
    }

    public Map<String ,List<String>> getReturnMsg(String msg) {
        return this.getReturnMsg(Collections.singletonList(msg));
    }
}

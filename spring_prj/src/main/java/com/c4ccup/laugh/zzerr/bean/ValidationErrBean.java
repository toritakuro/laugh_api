package com.c4ccup.laugh.zzerr.bean;

import java.util.Map;

public class ValidationErrBean {

    public ValidationErrBean(Map<String, String> errMsg) {
        this.errMsg = errMsg;
    }

    /** エラーメッセージ key:field(ない場合、空文字) val:message */
    private Map<String, String> errMsg;

    /**
     * エラーメッセージを取得する
     * @return エラーメッセージ
     */
    public Map<String,String> getErrMsg() {
        return errMsg;
    }
}

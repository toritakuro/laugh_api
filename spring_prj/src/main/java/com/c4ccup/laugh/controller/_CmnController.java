package com.c4ccup.laugh.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.c4ccup.laugh.controller.bean.res.Messages;
import com.c4ccup.laugh.util.MessageUtil;

/**
 * 共通コントーラークラス
 * 各コントローラーに必要な共通処理を実装する
 *
 */
public class _CmnController {

    @Autowired
    MessageUtil msgUtil;

    /**
     * 固定メッセージの取得
     * @param code
     * @return
     */
    public String getMessage(String code) {
        return msgUtil.getMessage(code);
    }

    /**
     * メッセージの取得
     * @param code
     * @param msgs
     * @return
     */
    public String getMessage(String code, String... msgs) {
        return msgUtil.getMessage(code, msgs);
    }

    /**
     * メッセージの返却
     * @param msgs
     * @return
     */
    public Messages getReturnMsg(List<String> msgs) {
        return msgUtil.getReturnMsg(msgs);
    }

    /**
     * メッセージの返却
     * @param msg
     * @return
     */
    public Messages getReturnMsg(String msg) {
        return msgUtil.getReturnMsg(Collections.singletonList(msg));
    }

}

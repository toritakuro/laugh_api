package com.c4ccup.laugh.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 共通メソッドUtilクラス
 *
 */
@Component
public class Util {

    /**
     * 文字列配列をint型のリストに変換
     * 
     * @param strs
     * @return
     */
    public List<Integer> chgToInt(String[] strs) {
        List<Integer> intList = new ArrayList<>();
        if (strs != null) {
            for (String str : strs) {
                intList.add(Integer.parseInt(str));
            }
        }
        return intList;
    }
}

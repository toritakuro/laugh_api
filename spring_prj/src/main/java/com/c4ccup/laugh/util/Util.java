package com.c4ccup.laugh.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 共通メソッドUtilクラス
 *
 */
public class Util {

    /**
     * 文字列配列をint型のリストに変換
     *
     * @param strs
     * @return
     */
    public static List<Integer> chgToInt(String[] strs) {
        List<Integer> intList = new ArrayList<>();
        if (strs != null) {
            for (String str : strs) {
                intList.add(Integer.parseInt(str));
            }
        }
        return intList;
    }

    /**
     *
     * @param strs
     * @return
     */
    public static List<String> toStrList(String[] strs) {
        List<String> intList = new ArrayList<>();
        for (String str : strs) {
            intList.add(str);
        }
        return intList;
    }
}

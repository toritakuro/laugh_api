package com.c4ccup.laugh.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 共通メソッドUtilクラス
 *
 */
public class Util {

    /** 日付フォーマット 年月日 */
    public static final String DATE_FORMAT = "yyyy-MM-dd HH";
    /** 日時フォーマット(yyyy-MM-dd) */
    public static DateTimeFormatter formatDateF = DateTimeFormatter.ofPattern(DATE_FORMAT);

    /**
     * 文字列配列をint型のリストに変換
     *
     * @param strs
     * @return
     */
    public static List<Integer> chgToInt(String[] strs) {
        // スプリット、
        List<Integer> intList = new ArrayList<>();
        if (strs != null) {
            for (String str : strs) {
                intList.add(Integer.parseInt(str));
            }
        }
        return intList;
    }

    /**
     * toIntList　Arrays.asList(user.getComedyStyleNames().split(","));
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

    /**
     * LocalDateTimeからInteger(yyyyMMddHH)に変換
     * @return Integer型の日時(変換対象がnullの場合、null)
     */
    public static Integer getFormatLocalDateTimeToInt(LocalDateTime dateTime) {
       Integer intDate = null;
       if (dateTime != null) {
           String yyyyMMddHH = dateTime.format(formatDateF);
           String[] date = yyyyMMddHH.split("[-: ]", 0);
           if (date.length == 4) {
               StringBuilder tmpDate = new StringBuilder();
               tmpDate.append(date[0]).append(date[1]).append(date[2]).append(date[3]);
               intDate = Integer.parseInt(tmpDate.toString());
           }
       }
       return intDate;
    }
}

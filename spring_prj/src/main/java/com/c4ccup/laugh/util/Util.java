package com.c4ccup.laugh.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.c4ccup.laugh.util.AppConst.DateFormatEnum;
import com.c4ccup.laugh.util.AppConst.MimeTypeEnum;

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
     * 文字列をInteger型のリストに変換
     *
     * @param str
     * @return intList
     */
    public static List<Integer> toIntList(String str) {
      List<Integer> intList = new ArrayList<>();
      if (str != null) {
          intList = Arrays.asList(str.split(","))
                  .stream()
                  .map(Integer::valueOf)
                  .collect(Collectors.toList());
      }
      return intList;
    }

    /**
     * 文字列をString型のリストに変換
     *
     * @param strs
     * @return strList
     */
    public static List<String> toStrList(String str) {
        List<String> strList = new ArrayList<>();
        if (str != null) {
            strList = Arrays.asList(str.split(","));
        }
        return strList;
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

    /**
     * enumで指定した日付の形式に変換
     * @param date
     * @param format
     * @return
     */
    public static String formatLocalDateTime(LocalDateTime date, DateFormatEnum format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format.getFormat());
        return date.format(dtf);
    }

    /**
     * enumで指定した日付の形式に変換
     * @param date
     * @param format
     * @return
     */
    public static String formatLocalDateTime(LocalDate date, DateFormatEnum format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format.getFormat());
        return date.format(dtf);
    }

    /**
     * enumで指定した日付の形式に変換
     * @param date
     * @param format
     * @return
     */
    public static LocalDate toLocalDate(String date, DateFormatEnum format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format.getFormat()));
    }

    /**
     * 改行をbrに変換する
     * @param str
     * @return
     */
    public static String changeRCtoBR(String str) {
        if (str == null) return "";
        return str.replaceAll("\r\n|\n", "<br>");
    }


    /**
     * S3へのアップロードに必要な情報を返却
     * 0:base64, 1:mimeType, 2:拡張子(.pngなど)
     * @param base64
     * @return
     */
    public static String[] toAwsUploadFileInfo(String _base64) {
        String[] splitBase64 = _base64.split(",");
        String dataUriSchema = splitBase64[0];
        String mimeType = dataUriSchema.split(";")[0].split(":")[1];
        String base64 = splitBase64[1];
        String extention = MimeTypeEnum.getExtention(mimeType);
        return new String[] {base64, mimeType, extention};
    }

}

package com.c4ccup.laugh.util;

/**
 * app 定義クラス
 *
 */
public class AppConst {

    /** 大喜利一覧お題表示数 */
    public static final int oogiri_theme_disp_num = 50;
    /** 大喜利一覧回答表示数 */
    public static final int oogiri_answer_disp_num = 3;

    /** ユーザータイプ */
    public enum UserEnum {
        /** 1:作家 */
        COMPOSER(1, "作家"),
        /** 2:芸人 */
        COMEDIAN(2, "芸人"),
        ;

        private int id;
        private String name;

        UserEnum(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() { return id; }
        public String getName() { return name; }
    }

    /** 特殊スキル */
    public enum specialSkillEnum {
        /** 1:動画編集　*/
        VIDEO_EDITTING(1, "動画編集"),
        /** 2:イラスト　*/
        DESIGN(2, "イラスト"),
        /** 3:音源作成　*/
        SOUND_PRODUCTION(3, "音源制作"),
        /** 4:その他　*/
        OTHERS(4, "その他");

        private int id;
        private String name;

        specialSkillEnum(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }
    }

    /** 日付フォーマット */
    public enum DateFormatEnum {
        /** yyyy-MM-dd */
        HYPHEN_YMD("yyyy-MM-dd"),
        /** yyyy/MM/dd */
        SLASH_YMD("yyyy/MM/dd"),
        /** HH:mm */
        TIME("HH:mm"),
        ;

        private String format;

        DateFormatEnum(String format) {
            this.format = format;
        }

        public String getFormat() { return format; }
    }
}
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

    /** MimeType-拡張子 */
    public enum MimeTypeEnum {
        JPG("image/jpeg", ".jpg"),
        PNG("image/png", ".png"),
        ;
        private String mimeType;
        private String extention;

        MimeTypeEnum(String mimeType, String extention) {
            this.mimeType = mimeType;
            this.extention = extention;
        }

        public String getMimetype() { return this.mimeType; }
        public String getExtention() { return this.extention; }

        public static String getExtention(String mineType) {
            for (MimeTypeEnum mte : MimeTypeEnum.values()) {
                if (mte.getMimetype().equals(mineType)) {
                    return mte.getExtention();
                }
            }
            return null;
        }
    }

    /** ユーザータイプ */
    public enum UserEnum {
        /** 1:芸人 */
        COMEDIAN(1, "芸人"),
        /** 2:作家 */
        COMPOSER(2, "作家"),
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

    /** 料金体系 */
    public enum FeeEnum {
        /** 1:時給 */
        TIME(1, "時給"),
        /** 2:成果物 */
        PRODUCT(2, "成果物"),
        ;

        private int id;
        private String name;

        FeeEnum(int id, String name) {
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
        DESIGN(2, "イラスト制作"),
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

    /** お知らせ種別 */
    public enum NoticeType {
        LAUGH(1),
        MESSAGE(2),
        MATCH(3)
        ;

        private int type;

        private NoticeType(int type) {
           this.type = type;
        }

        public int getType() { return this.type; }
    }

    /** 日付フォーマット */
    public enum DateFormatEnum {
        /** yyyy-MM-dd */
        HYPHEN_YMD("yyyy-MM-dd"),
        /** yyyy-MM */
        HYPHEN_YM("yyyy-MM"),
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
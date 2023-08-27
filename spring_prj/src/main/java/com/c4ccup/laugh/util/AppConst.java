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
        COMPOSER(1, "作家"), COMEDIAN(2, "芸人"),;

        private int id;
        private String name;

        UserEnum(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /** 特殊スキル */
    public enum specialSkillEnum {
        VIDEO_EDITTING(1, "動画編集"), DESIGN(2, "イラスト"), SOUND_PRODUCTION(3, "音源制作"), OTHERS(4, "その他"),;

        private int id;
        private String name;

        specialSkillEnum(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
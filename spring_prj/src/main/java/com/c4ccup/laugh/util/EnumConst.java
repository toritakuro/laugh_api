package com.c4ccup.laugh.util;

/**
 * Enum定義クラス
 */
public class EnumConst {

    /** マッチングステータスEnum */
    public enum MatchStatus {
        /** 未マッチ */PRE_MATCH(0, "未マッチ"),
        /** マッチ */MATCH(10, "Laugh"),
        /** SuperLaugh */SUPER_LAUGHT(11, "SuperLaugh"),
        /** 解除 */CANCEL(99, "解除"),
        ;
        private int k;
        private String v;
        private MatchStatus(int k, String v) {
            this.k = k;
            this.v = v;
        }
        public int getStatus() { return this.k; }
        public String getStatusStr() { return this.v; }
        public static String getValByKey(int key) {
            String val = "";
            for (MatchStatus status : MatchStatus.values()) {
                if (status.getStatus() == key) {
                    val = status.getStatusStr();
                }
            }
            return val;
        }
    }

}

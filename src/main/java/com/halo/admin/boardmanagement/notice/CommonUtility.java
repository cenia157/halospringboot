package com.halo.admin.boardmanagement.notice;

public class CommonUtility {

    public static String escapeHtml(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.replaceAll("&", "&amp;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;")
                    .replaceAll("'", "&#x27;");
    }

}

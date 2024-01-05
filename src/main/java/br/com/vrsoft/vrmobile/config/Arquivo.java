package br.com.vrsoft.vrmobile.config;

import java.util.regex.Pattern;

public class Arquivo {
    private static final String JAR_LOCATION = System.getProperty("java.class.path");

    public static String getVRDirectory() throws Exception {
        if (Pattern.compile("^[A-za-z][\\:]|^[\\/]{1}").matcher(JAR_LOCATION).find()) {
            return getRoot() + "vr";
        } else {
            return getHome() + "/.vr";
        }
    }

    private static String getRoot() throws Exception {
        if (System.getProperties().getProperty("file.separator").equals("\\")) {
            return "c:/";
        } else {
            return "/";
        }
    }

    private static String getHome() {
        return System.getProperty("user.home");
    }
}

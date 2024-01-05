package br.com.vrsoft.vrmobile.config;

import java.io.File;
import java.io.FileInputStream;

public class Properties {
    private java.util.Properties propertie = null;

    public Properties(String path) throws Exception {
        FileInputStream input = new FileInputStream(new File(path));

        propertie = new java.util.Properties();
        propertie.load(input);

        input.close();
    }

    private String getPropertie(String key) {
        String value = propertie.getProperty(key);

        if (value == null) {
            return "";
        } else {
            return value.trim();
        }
    }

    public String getString(String key) {
        return getPropertie(key);
    }

    public int getInt(String key) {
        String value = getPropertie(key);

        if (value.equals("")) {
            return 0;
        } else {
            return Integer.parseInt(getPropertie(key));
        }
    }

    public long getLong(String key) {
        String value = getPropertie(key);

        if (value.equals("")) {
            return 0;
        } else {
            return Long.parseLong(getPropertie(key));
        }
    }

    public boolean getBoolean(String key) {
        String value = getPropertie(key);

        if (value.equals("")) {
            return false;
        } else {
            return Boolean.parseBoolean(getPropertie(key));
        }
    }

    public static String replaceBarras(String i_content) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            String home = System.getProperty("user.home");
            if (osName.contains("windows")) {
                i_content = i_content.replaceAll("((C:)([\\\\]+|\\/+)vr)",
                        home.replace("\\", "\\\\\\\\") + "\\\\\\\\.vr");
            } else {
                i_content = i_content.replaceAll("(([\\\\]+|\\/+)vr)", home + "/.vr");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return i_content;
    }
}
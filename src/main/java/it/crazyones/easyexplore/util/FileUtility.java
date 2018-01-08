package it.crazyones.easyexplore.util;

/**
 * Created by bilal90 on 10/27/2017.
 */
public class FileUtility {
    public static String getFileExtension(String name) {
        ValidationUtil.validatePropertyNotNullOrEmpty(name, "file name");
        int dotIndex = name.lastIndexOf('.');
        return (dotIndex == -1) ? "" : name.substring(dotIndex + 1);
    }
}

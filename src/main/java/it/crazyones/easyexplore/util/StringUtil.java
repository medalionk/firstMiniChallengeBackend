package it.crazyones.easyexplore.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Created by bilal90 on 9/14/2017.
 */
public final class StringUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);

    private StringUtil() {
    }

    public static boolean isNullOrEmpty(String property){
        return property == null || property.trim().isEmpty();
    }

    public static LocalTime parseLocalTime(String timeStr){
        if(timeStr == null) return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
        if(timeStr.length() > 5) formatter = DateTimeFormatter.ofPattern("H:mm:ss");
        else formatter = DateTimeFormatter.ofPattern("H:mm");

        try{
            return LocalTime.parse(timeStr, formatter);
        }catch (DateTimeParseException ex){
            LOGGER.error("Error parsing local time: {}", ex.getMessage());
            return null;
        }
    }

    public static LocalDate parseDate(String dateStr){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
            return LocalDate.parse(dateStr, formatter);
        }catch (Exception ex){
            LOGGER.error("Error parsing {}. Exception: '{}'", dateStr, ex.getMessage());
            return null;
        }
    }

    public static LocalTime parseTime(String timeStr){
        try {
            return LocalTime.parse(timeStr, DateTimeFormatter.ISO_DATE_TIME);
        }catch (Exception ex){
            LOGGER.error("Error parsing {}. Exception: '{}'", timeStr, ex.getMessage());
            return null;
        }
    }

    public static LocalDate parseMonthYear(String dateStr){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            Date date = dateFormat.parse(dateStr);
            return new java.sql.Date(date.getTime()).toLocalDate();
        }catch (Exception ex){
            LOGGER.error("Error parsing {}. Exception: '{}'", dateStr, ex.getMessage());
            return null;
        }
    }

    public static LocalDate parseYear(String dateStr){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy");
            Date date = dateFormat.parse(dateStr);
            return new java.sql.Date(date.getTime()).toLocalDate();
        }catch (Exception ex){
            LOGGER.error("Error parsing {}. Exception: '{}'", dateStr, ex.getMessage());
            return null;
        }
    }

    public static String createMacHashWithKey (String arg, String secretKey)
    {
        String sha512 = StringUtil.hash512String(arg + secretKey);
        if(sha512 != null) return sha512.toUpperCase();

        return null;
    }

    public static String hash512String(String arg){
        String generatedHash = null;

        byte[] argBytes = stringToBytes(arg);
        if(argBytes == null) return null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(argBytes);
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            LOGGER.error(String.format("Error hashing %s, exception: %s ", arg, e.getMessage()));
        }

        return generatedHash;
    }

    public static byte[] stringToBytes(String arg){
        byte[] bytes = null;
        try {
            bytes = arg.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(String.format("Error getting %s bytes, exception: %s ", arg, e.getMessage()));
        }

        return bytes;
    }

    public static String stringToHex(String arg) {
        byte[] argBytes = stringToBytes(arg);
        if(argBytes == null) return null;

        return String.format("%040x", new BigInteger(1, argBytes));
    }

    public static String removeNonNumeric(final String input){
        return input.replaceAll("[^.,0-9]", "");
    }

    public static String getFirstXCharsInStr(final String str, int count){
        if(str == null || str.trim().isEmpty()) return null;

        if (str.length() > count) return str.substring(0, count).trim();
        else return str;
    }

    public static BigDecimal strToBigDecimal(final String value){
        if(value == null || value.trim().isEmpty()) return null;

        try {
            return new BigDecimal(removeNonNumeric(value).replace(',', '.'));
        }catch (Exception ex){
            LOGGER.error("Error parsing string value {}", value);
            return null;
        }
    }

    public static String toTitleCase(final String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }
}

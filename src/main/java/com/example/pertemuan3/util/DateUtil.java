package com.example.pertemuan3.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String format(LocalDate date) {
        return date != null ? date.format(FORMATTER) : null;
    }

    public static LocalDate parse(String dateStr) {
        return dateStr != null ? LocalDate.parse(dateStr, FORMATTER) : null;
    }
}

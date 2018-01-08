package it.crazyones.easyexplore.util;


import it.crazyones.easyexplore.application.exceptions.ConfigurationException;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by bilal90 on 9/7/2017.
 */
public final class ValidationUtil {
    private ValidationUtil() {
    }

    public static <T> void validateConfigPropertyNotNull(T property, String name)
            throws ConfigurationException {
        if (property == null)
        {
            throw new ConfigurationException(
                    String.format("Configurable property '%s' cannot be null.", name));
        }
    }

    public static <T> void validatePropertyNotNull(T t, String name) throws IllegalArgumentException{
        if (t == null) throw new IllegalArgumentException(String.format("Parameter '%s' cannot be null", name));
    }

    public static <T> void ValidateEntity(T entity)
    {
        validatePropertyNotNull(entity, "entity");
    }

    public static void ValidateIdentity(String id)
    {
        validatePropertyNotNullOrEmpty(id, "Id");
    }

    public static <E> void validateListNotNullOrEmpty(List<E> property, String name) throws IllegalArgumentException{
        validatePropertyNotNull(property, name);
        if (property.isEmpty())
            throw new IllegalArgumentException(String.format("Parameter '%s' cannot be empty", name));
    }

    public static void validatePropertyNotNullOrEmpty(String property, String name) throws IllegalArgumentException{
        validatePropertyNotNull(property, name);
        if (property.trim().isEmpty())
            throw new IllegalArgumentException(String.format("Parameter '%s' cannot be empty", name));
    }

    public static void validateDateIsNowOrFuture(LocalDate date) throws IllegalArgumentException{
        if (LocalDate.now().isAfter(date)) throw new IllegalArgumentException("Date cannot be in the past");
    }
}

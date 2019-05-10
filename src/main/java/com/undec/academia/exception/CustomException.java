package com.undec.academia.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CustomException extends RuntimeException {

    public CustomException(String servicio, String... searchParamsMap) {
        super(CustomException.generateMessage(servicio, toMap(String.class, String.class, searchParamsMap)));
    }

    private static String generateMessage(String servicio, Map<String, String> searchParams) {
        return "El procedimiento " + servicio
                + " retorna con un error "
                + searchParams;
    }

    private static <K, V> Map<K, V> toMap(
            Class<K> keyType, Class<V> valueType, Object... entries) {
        if (entries.length % 2 == 1) {
            throw new IllegalArgumentException("Invalid entries");
        }
        return IntStream.range(0, entries.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
    }

}
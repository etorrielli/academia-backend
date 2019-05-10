package com.undec.academia.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ServiceCallException extends RuntimeException {

    public ServiceCallException(String servicio, String... searchParamsMap) {
        super(ServiceCallException.generateMessage(searchParamsMap[0]));
    }

    private static String generateMessage(String message) {
        return message;
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


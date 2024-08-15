package com.jeswin8801.ghibli_lib.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class UtilFunctions {
    public String convertToRegex(String name) {
        name = name.strip().trim().toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(name);
        int length = stringBuilder.length();
        for (int i = 0; i < length; i++) {
            char currentChar = stringBuilder.charAt(i);
            if (i == 0 || stringBuilder.charAt(i - 1) == ' ') {
                stringBuilder.deleteCharAt(i);
                stringBuilder.insert(
                        i,
                        String.format("[%s%s]", currentChar, Character.toUpperCase(currentChar))
                );
                length += 3;
            } else if ((currentChar == 's' || currentChar == 'S') && (i == length - 1 || stringBuilder.charAt(i + 1) == ' ')) {
                stringBuilder.insert(i, "'?");
                length += 2;
                i += 2;
            }
        }
        stringBuilder.insert(0, ".*");
        stringBuilder.append(".*");

        return stringBuilder.toString();
    }

    public String prettyPrintObject(Object object) {
        try {
            return new ObjectMapper()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Encountered the following error when converting to json", e);
        }
        return String.valueOf(object);
    }
}

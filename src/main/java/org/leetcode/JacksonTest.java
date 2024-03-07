package org.leetcode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.util.Iterator;

public class JacksonTest {
    @Data
    @AllArgsConstructor
    static public class Girl {
        private String age;

        private String boyfriend;

        private String birthday;

    }

    public static void main(String args[]) throws IOException {
        Girl girl = new Girl("A", "B", "C");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(girl));

        Iterator<String> iter = jsonNode.fieldNames();

        while (iter.hasNext()) {
            String fieldName = iter.next();
            System.out.println(fieldName);
            System.out.println(jsonNode.get(fieldName).asText());
        }
    }
}

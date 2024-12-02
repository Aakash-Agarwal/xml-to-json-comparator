package com.learning.research.xmltojsoncomparator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;

@Service
public class ComparatorService {
    private final ObjectMapper objectMapper;

    public ComparatorService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public boolean compareJson(JsonNode jsonNode1, JsonNode jsonNode2) {
        if (jsonNode1.equals(jsonNode2)) {
            return true;
        }

        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode1.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            JsonNode jsonNode2Field = jsonNode2.get(field.getKey());

            if (jsonNode2Field == null || !compareJson(field.getValue(), jsonNode2Field)) {
                return false;
            }
        }
        return true;
    }
}

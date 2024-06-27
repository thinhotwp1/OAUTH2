package org.example.oauth2;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class JsonStructurePrinter {

    public static void main(String[] args) {
        // Đặt đường dẫn tới file JSON trực tiếp trong mã
        String filePath = "D:\\ThinhLD\\GDV\\xmltojson.json";
        File jsonFile = new File(filePath);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(jsonFile);
            printStructure(rootNode, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printStructure(JsonNode node, int indent) {
        String indentStr = " ".repeat(indent);

        if (node.isObject()) {
            Iterator<Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Entry<String, JsonNode> field = fields.next();
                System.out.println(indentStr + field.getKey() + ":");
                printStructure(field.getValue(), indent + 4);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                System.out.println(indentStr + "[" + i + "]:");
                printStructure(node.get(i), indent + 4);
            }
        } else {
            System.out.println(indentStr + node.asText());
        }
    }
}

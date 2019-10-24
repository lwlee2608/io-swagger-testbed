package com.lwlee;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.Schema;

public class App {
    public static void main( String[] args ) {
        String inputSpec = "./api.yaml";
        OpenAPI openApi = new ParserRunner().parse(inputSpec);
        Paths paths = openApi.getPaths();
        for (String resourcePath : paths.keySet()) {
            PathItem path = paths.get(resourcePath);
            Operation operation = path.getGet();
            operation.getParameters().forEach(parameter -> {
                Schema schema = parameter.getSchema();
                if (schema != null) {
                    System.out.println("schema of " + parameter.getName() + " is " + parameter.getSchema());
                } else {
                    Content content = parameter.getContent();
                    if (content != null) {
                        System.out.println("schema of " + parameter.getName() + " is " +
                                content.get("application/json").getSchema());
                    }
                }
            });
        }
    }
}

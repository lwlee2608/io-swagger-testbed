package com.lwlee;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.junit.Assert;
import org.junit.Test;

public class ParserRunnerTest {
    private ParserRunner parserRunner;

    @Test
    public void test01() {
        String inputSpec = "./api.yaml";
        OpenAPI openApi = new ParserRunner().parse(inputSpec);
        Paths paths = openApi.getPaths();
        for (String resourcePath : paths.keySet()) {
            PathItem path = paths.get(resourcePath);
            Operation operation = path.getGet();
            operation.getParameters().forEach(parameter -> {
                System.out.println("schema of " + parameter.getName() + " is " + parameter.getSchema());
                Assert.assertNotNull(parameter.getSchema());
            });
        }
    }
}
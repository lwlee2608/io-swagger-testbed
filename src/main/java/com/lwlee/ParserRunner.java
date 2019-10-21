package com.lwlee;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.AuthorizationValue;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

import java.util.ArrayList;
import java.util.List;

public class ParserRunner {

    public OpenAPI parse(String inputSpec) {

        final List<AuthorizationValue> authorizationValues = new ArrayList<>();
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        SwaggerParseResult result = new OpenAPIParser().readLocation(inputSpec, authorizationValues, options);

        return result.getOpenAPI();
    }
}

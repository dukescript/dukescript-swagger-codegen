package com.dukescript.swagger.codegen;

/*-
 * #%L
 * dukescript-swagger-codegen - a library from the "DukeScript" project.
 * %%
 * Copyright (C) 2018 Dukehoff GmbH
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import io.swagger.codegen.*;
import io.swagger.models.properties.Property;

import java.io.File;

public class DukescriptswaggercodegenGenerator extends DefaultCodegen implements CodegenConfig {

    protected String sourceFolder = "src";
    protected String apiVersion = "1.0.0";

    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    public String getName() {
        return "DukeScriptSwaggerCodegen";
    }

    public String getHelp() {
        return "Generates a DukeScript @Model client library.";
    }

    public DukescriptswaggercodegenGenerator() {
        super();
        outputFolder = "generated-code/DukeScriptSwaggerCodegen";
        modelTemplateFiles.put(
                "model.mustache",
                "VMD.java");
//        apiTemplateFiles.put(
//                "api.mustache",
//                ".java");
        templateDir = "DukeScriptSwaggerCodegen";
        apiPackage = "io.swagger.client.api";
        modelPackage = "io.swagger.client.model";
        additionalProperties.put("apiVersion", apiVersion);
        typeMapping.put("string", "String");
        typeMapping.put("integer", "int");
        typeMapping.put("long", "long");
        typeMapping.put("short", "short");
        typeMapping.put("short", "short");
        typeMapping.put("Boolean", "boolean");
        typeMapping.put("boolean", "boolean");
        typeMapping.put("Date", "long");
        typeMapping.put("DateTime", "long");
    }

    @Override
    public String escapeReservedWord(String name) {
        return "_" + name;  // add an underscore to the name
    }

    public String modelFileFolder() {
        return outputFolder + "/" + sourceFolder + "/" + modelPackage().replace('.', File.separatorChar);
    }

    @Override
    public String apiFileFolder() {
        return outputFolder + "/" + sourceFolder + "/" + apiPackage().replace('.', File.separatorChar);
    }

    @Override
    public String getSwaggerType(Property p) {
        String swaggerType = super.getSwaggerType(p);
        String type = null;
        if (typeMapping.containsKey(swaggerType)) {
            type = typeMapping.get(swaggerType);
            if (languageSpecificPrimitives.contains(type)) {
                return type;
            }
        } else {
            type = swaggerType;
        }
        return type;
    }

}

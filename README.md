# DukeScript Swagger Codegenerator

With this project you can generate model classes from [OpenAPI-based API Descriptions](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md).
The Generator is a custom module for the [Swagger Codegenerator](https://github.com/swagger-api/swagger-codegen).

You can use it from commandline or with the
 [swagger-codegen-maven-plugin](https://github.com/swagger-api/swagger-codegen/tree/master/modules/swagger-codegen-maven-plugin).

Here's an example config:

    <plugin>
        <groupId>io.swagger</groupId>
        <artifactId>swagger-codegen-maven-plugin</artifactId>
        <version>2.3.1</version>
        <executions>
            <execution>
                <goals>
                    <goal>generate</goal>
                </goals>
                <configuration>
                    <inputSpec>${project.basedir}/src/main/resources/petstore.json</inputSpec>
                    <language>com.dukescript.swagger.codegen.DukescriptswaggercodegenGenerator</language>
                    <output>${project.build.directory}/generated-sources</output>
                    <apiPackage>${default.package}.handler</apiPackage>
                    <modelPackage>${default.package}.model</modelPackage>
                    <invokerPackage>${default.package}.handler</invokerPackage> 
                </configuration>
            </execution>
        </executions>
        <dependencies>
            <dependency>
                <groupId>com.dukescript.swagger</groupId>
                <artifactId>swagger-codegen-client</artifactId>
                <version>1.0-SNAPSHOT</version>
            </dependency>
        </dependencies>
    </plugin>


This project also contains a demo project from which the above config is copied.


## Release Info:

Current Development Version: 1.0-SNAPSHOT

Next Steps: Use the operations to generate a working API with @OnReceive Annotation.

Initial Commit: The codegenerator can generate the Models used in the Petstore.json

## Releases:

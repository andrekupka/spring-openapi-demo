# spring-openapi-demo

Demo application for testing server side code generation with openapi (using the `org.openapitools:openapi-generator-maven-plugin`).

## Generate code

Initially api code and models have to be generated using the following command.

```
mvn clean generate-sources
```

We use `org.codehaus.mojo:build-helper-maven-plugin` to add the generated sources as build sources.
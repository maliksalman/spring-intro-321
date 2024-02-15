# Heroes Sample SpringBoot App


## Install JDK 21

Will need to install GraalVM version or just the plain JDK 21 if not interested in native images

## Create project

Goto start.spring.io and then do the following
- Pick Project: Maven
- Pick Language: Java
- Pick Version: Boot 3.2.2
- Pick Jar
- Pick Java 21
- Add dependencies
    - web
    - jdbc
    - native
    - h2
    - lombok

## Unzip the project
Unzip and run `mvnw clean package` to ensure the project compiles

## Import into your IDE
IntelliJ or VS Code will both work. Lets also cleanup some stuff that will slow us down in this demo.

- Cleanup the `src/test/java`
- Remove the testing depdendencies
- Set the version of app to `1.0`

## Lets add some code

We will create a simple API to create/list/lookup super-heroes. The API will be backed with a Database 

## Talk about virtual threads

Turn on virtual threads

## Run the app

### Through the IDE

Using the play button from the main class

### Bundle as self-executing JAR

```
./mvnw clean package
java -jar target/spring-intro-1.0.jar
```

### Using Maven

```
./mvnw clean spring-boot:run
```

### Bundle as docker image

This method uses Cloud Native buildpacks to build the boot application and generates a docker image

```
./mvnw clean spring-boot:build-image -Dspring-boot.build-image.imageName=spring/intro:1.0
```

... then run it

```
docker run --rm -it -p 8080:8080 spring/intro:1.0
```

### Bundle as self-executing native binary

First make GraalVM the default JDK and then invoke ...

```
./mvnw -Pnative native:compile
```

... and then run the executable

```
target/spring-intro
```

### Bundle as self-executing native binary inside a docker image

For this to work, there is no need to have GraalVM, just a regular JDK. The native compilation happens inside a buildpack

```
./mvnw -Pnative spring-boot:build-image -Dspring-boot.build-image.imageName=spring/intro-native:1.0
```

... then run it

```
docker run --rm -it -p 8080:8080 spring/intro-native:1.0
```

## Stats

| Native / JVM | Docker | Compile Time (s) | Startup Time (s) | Memory Usage (MB) |
| --------- | --------- | --------- | ---------- | --------- |
| JVM | No | 2.5 | 2 | 250 |
| JVM | Yes | 8 | 2 | 290 |
| Native | No | 127 | 0.08 | 140 |
| Native | Yes | 129 | 0.11 | 136 |

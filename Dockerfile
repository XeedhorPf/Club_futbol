FROM openjdk:21
COPY "target/Taller_Club_futbol-1.jar" "app.jar"
EXPOSE "8091"
ENTRYPOINT [ "java", "-jar", "app.jar" ]

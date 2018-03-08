# description
* register to eureka server
* consume HELLO-SERVICE from eureka server
* client load balanced with ribbon
* integrate circuit breaker hystrix

## package
* `./mvnw -s .mvn/settings.xml package`
* `./mvnw -s .mvn/settings.xml package -Dmaven.test.skip=true`
* `java -jar target/springcloud_hello-0.0.1-SNAPSHOT.jar --server.port=8081`
* `java -jar target/springcloud_hello-0.0.1-SNAPSHOT.jar --server.port=8082`

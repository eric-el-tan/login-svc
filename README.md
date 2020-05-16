# login-svc

This is the backend of the android project

# development history

##
```
> sudo docker rm -f login-svc
> mvn clean package -Dmaven.test.skip=true
```
## [docker](https://dzone.com/articles/deploying-spring-boot-on-docker)

> eric@coding /v/l/g/a/login-svc> ./deploy.sh
```
login-svc
docker container removed.
Sending build context to Docker daemon  45.42MB
Step 1/4 : FROM java:8
 ---> d23bdf5b1b1b
Step 2/4 : EXPOSE 8080
 ---> Using cache
 ---> d58c24d826a6
Step 3/4 : ADD /target/login-svc-0.1.jar login-svc-0.1.jar
 ---> Using cache
 ---> 77609eee6d74
Step 4/4 : ENTRYPOINT ["java","-jar","login-svc-0.1.jar"]
 ---> Using cache
 ---> b503c84799d2
Successfully built b503c84799d2
Successfully tagged android/login-svc:latest
docker image built.
8df168efc46860fab62db82d82d794633cdf2248ea89575afdbfaed61b00b737
docker container executed.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2020-05-07 03:13:15.072  INFO 1 --- [           main] com.eric.user.ServiceApplication      : Starting ServiceApplication v0.1 on 8df168efc468 with PID 1 (/login-svc-0.1.jar started by root in /)
2020-05-07 03:13:15.080  INFO 1 --- [           main] com.eric.user.ServiceApplication      : No active profile set, falling back to default profiles: default
2020-05-07 03:13:16.885  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2020-05-07 03:13:16.923  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 22ms. Found 0 JPA repository interfaces.
2020-05-07 03:13:18.140  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-05-07 03:13:18.160  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-05-07 03:13:18.161  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.33]
2020-05-07 03:13:18.266  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-05-07 03:13:18.266  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 3079 ms
2020-05-07 03:13:18.523  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-05-07 03:13:19.040  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-05-07 03:13:19.134  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
        name: default
        ...]
2020-05-07 03:13:19.282  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.2.3.Final}
2020-05-07 03:13:19.285  INFO 1 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2020-05-07 03:13:19.289  INFO 1 --- [           main] org.hibernate.cfg.Environment            : HHH000021: Bytecode provider name : javassist
2020-05-07 03:13:19.369  INFO 1 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.1.Final}
2020-05-07 03:13:19.703  INFO 1 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2020-05-07 03:13:20.261  INFO 1 --- [           main] o.h.t.schema.internal.SchemaCreatorImpl  : HHH000476: Executing import script 'org.hibernate.tool.schema.internal.exec.ScriptSourceInputNonExistentImpl@3c73951'
2020-05-07 03:13:20.267  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2020-05-07 03:13:20.686  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2020-05-07 03:13:20.971  INFO 1 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [springfox.documentation.swagger2.web.Swagger2Controller#getDocumentation(String, HttpServletRequest)]
2020-05-07 03:13:21.205  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-05-07 03:13:21.720  INFO 1 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2020-05-07 03:13:21.758  INFO 1 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
2020-05-07 03:13:21.806  INFO 1 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2020-05-07 03:13:22.027  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-05-07 03:13:22.033  INFO 1 --- [           main] com.eric.user.ServiceApplication      : Started ServiceApplication in 7.676 seconds (JVM running for 8.687)
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    12  100    12    0     0     29      0 --:--:-- --:--:-- --:--:--    29
Hello World3
docker health checked.
```


Run under local environment
```
http://localhost:8080/swagger-ui.html
http://localhost:8080/login/hello
```

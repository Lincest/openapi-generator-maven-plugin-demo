# openapi-generator-maven-plugin demo

> A java [openapi-generator-maven-plugin](https://github.com/OpenAPITools/openapi-generator/tree/dbee2c5a8393142dfb4c70ecf54d1571faf1df52/modules/openapi-generator-maven-plugin) demo

blog: [openapi-generator入门及快速实践](https://blog.roccoshi.top/2022/java/openapi-generator%E7%9A%84%E4%BD%BF%E7%94%A8/)

## server

with springboot

### main configuration

example: https://github.com/OpenAPITools/openapi-generator/blob/dbee2c5a8393142dfb4c70ecf54d1571faf1df52/modules/openapi-generator-maven-plugin/examples/spring.xml

```xml
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <!-- RELEASE_VERSION -->
    <version>${openapi-generator-version}</version>
    <!-- /RELEASE_VERSION -->
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <inputSpec>${project.basedir}/src/main/resources/api.yaml</inputSpec>
                <generatorName>spring</generatorName>
                <apiPackage>com.roccoshi.demo.api</apiPackage>
                <modelPackage>com.roccoshi.demo.model</modelPackage>
                <supportingFilesToGenerate>ApiUtil.java</supportingFilesToGenerate>
                <skipValidateSpec>false</skipValidateSpec>
                <configOptions>
                    <delegatePattern>true</delegatePattern>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```

## client

example: https://github.com/OpenAPITools/openapi-generator/blob/dbee2c5a8393142dfb4c70ecf54d1571faf1df52/modules/openapi-generator-maven-plugin/examples/java-client.xml

### main configuration

```xml
 <plugin>
     <groupId>org.openapitools</groupId>
     <artifactId>openapi-generator-maven-plugin</artifactId>
     <version>${openapi-generator-version}</version>
     <executions>
         <execution>
             <goals>
                 <goal>generate</goal>
             </goals>
             <configuration>
                 <inputSpec>${project.basedir}/src/main/resources/api.yaml</inputSpec>
                 <generatorName>java</generatorName>
                 <configurationFile>${project.basedir}/openapi-generator-config.json</configurationFile>
                 <generateApiTests>false</generateApiTests>
                 <generateModelTests>false</generateModelTests>
                 <skipIfSpecIsUnchanged>true</skipIfSpecIsUnchanged>
             </configuration>
         </execution>
     </executions>
</plugin>
```

with feign client as client, for more clients, you can run: 

```java
java -jar openapi-generator-cli-<version>.jar config-help -g java
```

to check the key "`library`": 

![image-20220722015801309](https://youpai.roccoshi.top/img/202207220209545.png)

## demo

client send request as below: 

```java
public class main {
    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.getFeignBuilder().requestInterceptor(new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header("Content-type","application/json");
            }
        });
        client.setBasePath("http://localhost:23456/api");
        UserApi api = client.buildClient(UserApi.class);
        User u = new User();
        u.setUserName("Mike");
        u.setUserNumber("12345677");
        u.setId(1L);
        Response resp = api.saveUser(u);
        System.out.println(resp.toString());
    }
}
```

the server implements UserApiDelegate: 

```java
@Service
public class UserApiImpl implements UserApiDelegate {
    @Override
    public ResponseEntity<Response> saveUser(User user) {
        Response res = new Response();
        res.setCode("200");
        res.setMessage("received message: " + user.toString());
        res.setData(user);
        res.setSuccess(true);
        return ResponseEntity.ok().body(res);
    }
}
```

got: 

![image-20220722015840129](https://youpai.roccoshi.top/img/202207220209525.png)




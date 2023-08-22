### Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
```pom
        <dependency>
            <groupId>in.hocg.boot</groupId>
            <artifactId>mybatis-plus-spring-boot-starter</artifactId>
            <version>1.0.57</version>
        </dependency>
```


### Knife4j文档请求异常
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>3.0.3</version>
        </dependency>

[swagger2地址](http://localhost:8201/doc.html#/home)

### JDBC Connection [HikariProxyConnection@435665205 wrapping com.mysql.cj.jdbc.ConnectionImpl@68a1f5fb] will not be managed by Spring
 `启动类上面加上    ** @EnableTransactionManagement **
 `


### Application started with classpath: unknown


### Public Key Retrieval is not allowed
 `&allowPublicKeyRetrieval=true`



### 表结果为空
 **sql**

 SELECT id,role_name,remark,create_time,update_time,is_deleted FROM role WHERE is_deleted IS NULL

但是 is_delete 本就不为null 其类型是tinyint

    @TableLogic(value = "0", delval = "1")
   逻辑删除 前面是默认值   后面是删除后的值
神坑

@TableLogic 这样写 每次查询会带  is null

导致上面的问题出现了

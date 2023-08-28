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


 `No MyBatis mapper was found in 
'[org.example.sys.mapper]' package
 `
 

### spring boot项目不报错但是启动不了
spring-web 依赖 更换为spring boot -start-web


### There is already 'regionController' bean method


@requestMapping 中有重复s
## nacos 如何启动
** -----

cd D:\nacos-server-2.2.2\nacos\bin
startup.cmd -m standalone。  -> startup.cmd   先启动navicat 随便查询一点什么 


** ------------------

[地址](http://localhost:8848/nacos/)


### Exception: org.springframework.beans.factory.BeanCreationException. Message: Error creating bean with name 'distroFilterRegistration'

配置修改过 直接startup.cmd  


#### Field skuImagesService in org.example.product.service.imp.SkuInfoServiceImp required a single bean, but 2 were found:Field skuImagesService in org.example.product.service.imp.SkuInfoServiceImp required a single bean, but 2 were found:
啊  这也错?  //
把 spring-web 依赖变成 spring-boot-start-web


### docker 一直starting 

查看cpu是否开启虚化

查看windows 功能是否开启 htype-v


###  Docker failed to initialize
delete C:\Users\Administrator\AppData\Roaming\Docker 


http://localhost:9200
http://localhost:5601


### elasticsearch exit 78
sysctl -w vm.max_map_count=262144
sysctl ‐p --使其生效

docker exec -it -u root d63c9d948753ab141d753b0424dacc942965e4c263c5a24561ccd385815b59ac /bin/bash

sysctl -a |grep vm.max_map_count

docker run -d --name es -p 9200:9200 -p 9300:9300 -e ES_JAVA_OPTS="-Xms512m -Xmx512m" 0a61551b302003765c449a9530f5d07713b04182c8f8f3dccd35870303935add


### centos 查看ip 
**ip address**  
**查看防火墙状态** systemctl status firewalld.service
**关闭防火墙** systemctl stop firewalld.service

### winscp 连接成功
跟新winscp

yum 添加aliyun源

### Is the docker daemon running 
service docker start

### docker 配置elasticsearch kibana

docker run --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node"
-e ES_JAVA_OPTS="-Xms128m -XMx512m" -v /home/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml
-v /home/data:/usr/share/elasticsearch/data -v /home/plugins:/usr/share/elasticsearch/plugins

## Docker移除容器命令列表

docker rm [OPTIONS] CONTAINER [CONTAINER...]
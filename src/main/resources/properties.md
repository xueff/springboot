# 
```properties
#开启环境
spring.profiles.active = base
```

# 项目访问路径
```properties
server.port=8081
server.servlet.context-path=/lanhu
server.tomcat.uri-encoding=UTF-8
```



# 日志

在当前磁盘的根路径下创建spring文件夹和里面的log文件夹；使用 spring.log 作为默认文件

```properties
#连接：
logging.path=lanhu-log
#日志：
logging.level.org.springframework.data.mongodb.core = DEBUG

```



## 日志输出&格式

```properties
#控制台输出的日志的格式
logging.pattern.console=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} - %msg%n

#文件中日志输出的格式
logging.pattern.file=%d{yyyy-MM-dd} === [%thread] === %-5level === %logger{50} ==== %msg%n

```







# 数据库

## JPA

```properties
#命名规则-"_"
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
#显示sql
spring.jpa.show-sql=true
```

# Mongo



```properties
#连接：
spring.data.mongodb.uri=mongodb://user:123456@192.168.2.213:27017/user
#日志：
logging.level.org.springframework.data.mongodb.core = DEBUG

```



## Redis

```properties
spring.redis.database=8
spring.redis.host=192.168.0.14
spring.redis.port=6379
spring.redis.password=123456
#空闲
spring.redis.jedis.pool.min-idle=8
spring.redis.jedis.pool.man-idle=50
#最大阻塞时间（-1无限制）
spring.redis.jedis.pool.man-wait=-1
#最大连接
spring.redis.jedis.pool.man-active=100
#spring.redis.timeout=100000
```


# 스프링부트 JPA, MYSQL, Security 인스타그램

![blog]("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fz3SQu%2FbtqGYoy2XrS%2FTh5JBTp4OgBasu5q12bKN1%2Fimg.png")

### MYSQL 한글 설정(my.ina)

1. MYSQL 한글 설정

```ini
[client]
default-character-set=utf8

[mysql]
default-character-set=utf8

[mysqld]
collation-server = utf8_unicode_ci
init-connect='SET NAMES utf8'
init_connect='SET collation_connection = utf8_general_ci'
character-set-server=utf8
```

2. MYSQL 데이터베이스 및 사용자 생성

```sql
create user 'insta'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON 별.별 TO 'insta'@'%';
create database insta;
use insta;
```

### application.yml 파일 설정

```yml
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: UTF-8
      enabled: true
      force: true

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/insta?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true
    username: insta
    password: bitc5600

  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: create
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      use-new-id-generator-mappings: false
    show-sql: true

  servlet:
    multipart:
      enabled: true
      max-file-size: 2MB

  security:
    user:
      name: cos
      password: 1234

cos: secret:겟인데어

file:
  path: C:/src/instaclone/insta/src/main/resources/upload/
```

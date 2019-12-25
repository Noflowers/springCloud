Spring Cloud框架
eurka:服务发现 注册服务
[
    启动管理配置文件：
    java -jar eurka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
    java -jar eurka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
]
demoproducer:服务消费端（消费生产者发起的服务请求）
demo-consumer:服务生产者（发起服务请求端）
demo-feign:使用feign调用eureka端的服务测试项目
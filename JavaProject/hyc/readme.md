### hyc-shop
#### V1.0.0
> 从头开始构建一套商城系统


启动相关docker镜像命令
```
流控
docker run --name sentinel -d -p 8858:8858 -d bladex/sentinel-dashboard:latest
rabbitmq
docker run -d --name rabbitmqLocal --publish 5671:5671 --publish 5672:5672 --publish 4369:4369 --publish 25672:25672 --publish 15671:15671 --publish 15672:15672 rabbitmq:management
zk
docker run --privileged=true -d --name zookeeper --publish 2181:2181  -d zookeeper:latest
```
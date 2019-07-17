### hyc-shop
#### V1.0.0
> 从头开始构建一套商城系统


启动相关docker镜像命令
```
sentinel
docker run --name sentinel -d -p 8858:8858 -d bladex/sentinel-dashboard:latest
```
```
rabbitmq
docker run -d --name rabbitmqLocal --publish 5671:5671 --publish 5672:5672 --publish 4369:4369 --publish 25672:25672 --publish 15671:15671 --publish 15672:15672 rabbitmq:management
```
```
zk
docker run --privileged=true -d --name zookeeper --publish 2181:2181  -d zookeeper:latest
```

```
prometheus
docker run -d --name=prometheus -p 9090:9090 -v /Users/icsoc/huangtaoBlog/HuangTaoBlog/JavaProject/hyc/hyc-common/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
```
```
grafana
docker run -d --name=grafana -p 3000:3000 grafana/grafana
```
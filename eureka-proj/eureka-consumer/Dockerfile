# 基于哪个镜像
FROM java:8
# 将本地文件夹挂载到当前容器
VOLUME /tmp
# 拷贝文件到容器，eureka-consumer.jar这里是maven打包后的名字
ADD ./target/eureka-consumer.jar consumer.jar
RUN bash -c 'touch /consumer.jar'
# 配置容器启动后执行的命令
ENTRYPOINT  ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/consumer.jar"]
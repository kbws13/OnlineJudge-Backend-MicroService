# 基础镜像
FROM openjdk:8-jdk

# 指定工作目录
WORKDIR /app

# 将 jar 包添加到工作目录
ADD target/oj-backend-user-service-0.0.1-SNAPSHOT.jar .

# 暴露端口
EXPOSE 8102

# 启动命令
ENTRYPOINT ["java","-Xms512m","-Xmx1024m","-jar","/app/oj-backend-user-service-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]

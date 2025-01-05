# 使用 Java 22 官方运行时镜像
FROM amazoncorretto:22

# 设置工作目录
WORKDIR /app

# 复制配置文件和 JAR 文件到容器
COPY config.yml /app/config.yml
COPY /home/runner/work/coinCalculator-backend/coinCalculator-backend/target/CoinCalculator-1.0-SNAPSHOT-shaded.jar /app/CoinCalculator-1.0-SNAPSHOT-shaded.jar

# 暴露端口 8080
EXPOSE 8080

# 启动 Dropwizard 服务
CMD ["java", "-jar", "/app/CoinCalculator-1.0-SNAPSHOT-shaded.jar", "server", "/app/config.yml"]

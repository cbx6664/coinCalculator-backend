package com.cbx.coinservice.application;

import com.cbx.coinservice.health.CoinHealthCheck;
import com.cbx.coinservice.resources.CoinResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * ClassName: CoinServiceApplication
 * Package: com.cbx.coinservice
 * Description:
 *
 * @Author CBX
 * @Create 4/1/25 18:05
 * @Version 1.0
 */
public class CoinServiceApplication extends Application<CoinServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting application...");
        for (String arg : args) {
            System.out.println("Argument: " + arg);
        }
        new CoinServiceApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CoinServiceConfiguration> bootstrap) {
        // 初始化逻辑可添加（例如命令行工具）
    }

    @Override
    public void run(CoinServiceConfiguration configuration, Environment environment) {
        System.out.println("Configuration loaded: " + configuration);

        // 注册资源类
        final CoinResource resource = new CoinResource();
        environment.jersey().register(resource);

        // 注册健康检查
        final CoinHealthCheck healthCheck = new CoinHealthCheck();
        environment.healthChecks().register("coinService", healthCheck);

        // 配置 CORS
        configureCors(environment);
    }

    private void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors = environment.servlets()
                .addFilter("CORS", CrossOriginFilter.class);

        // 配置 CORS 参数
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*"); // 允许所有域
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // 应用到所有请求
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}

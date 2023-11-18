package xyz.kbws.ojbackendjudgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import xyz.kbws.ojbackendjudgeservice.rabbitmq.InitRabbitMq;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("xyz.kbws")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"xyz.kbws.ojbackendserviceclient.service"})
public class OjBackendJudgeServiceApplication {

	public static void main(String[] args) {
		// 初始化消息队列
		InitRabbitMq.doInit();
		SpringApplication.run(OjBackendJudgeServiceApplication.class, args);
	}

}

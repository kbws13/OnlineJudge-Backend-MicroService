# 在线判题系统后端微服务版本

# 介绍

基于 Vue3 + Spring Boot + Spring Cloud 微服务 + Docker 的 编程在线判题系统

在系统前台，管理员可以创建、管理题目；用户可以自由搜索题目、阅读题目、编写并提交代码

在系统后端，根据管理员预设题目测试用例在 **代码沙箱** 中对代码进行编译、运行、判断输出是否正确。其中代码沙箱可以作为独立服务，提供给其他开发者使用。

# 技术选项

## 前端

- Vue 3
- Vue-Cli 脚手架
- Vuex 状态管理
- Arco Design 组件库
- 前端工程化：ESLint + Prettier + TypeScript
- MarkDown 富文本编辑器
- Monaco Editor 代码编辑器
- OpenAPI 前端代码生成

## 后端

- Java Spring Cloud + Spring Cloud Alibaba 微服务
    - Nacos 注册中心
    - OpenFeign 客户端调用
    - GateWay 网关
    - 聚合接口文档
- Java 进程管理
- Java 安全管理器
- Docker 代码沙箱实现
- MySQL 数据库
- Redis 分布式 Session
- RabbitMQ 消息队列
- 多种设计模式
    - 策略模式
    - 工厂模式
    - 代理模式
    - 模板方法模式
- JVM 相关知识

## 教程

[Online Judge 在线判题系统](https://kbws.xyz/docs/oj-index)

# SmartStore 齐物——智能家务系统

## 简介
本仓库是**齐物——智能家务系统**的后端部分，专为Android前端提供必要的API接口。**齐物APP**是一款创新的家务管理应用程序，旨在通过智能化的方式简化家庭日常事务的管理。它不仅提供了一个直观的用户界面，还通过高效的后端服务保证了数据处理的速度和安全性。

后端系统采用**Spring Boot**框架进行开发，利用其强大的功能和灵活性来构建一个稳定、可扩展的服务平台。我们的技术栈包括但不限于Spring Data JPA、MyBatis、Lombok、Spring Data Redis等，这些技术的结合使得后端服务能够高效地处理大量的并发请求，同时保持代码的简洁和可维护性。

我们的API设计遵循RESTful原则，确保了与Android前端的无缝对接。通过这些API，齐物APP能够执行各种家务管理任务，如任务分配、进度跟踪和资源优化等。我们的目标是通过技术创新，让家务管理变得更加轻松和愉快。

此外，我们重视用户反馈和市场动态，不断对后端服务进行优化和升级，以满足用户不断变化的需求。我们相信，通过持续的努力和创新，齐物APP将成为家庭管理领域的佼佼者，为用户带来前所未有的便利。

## 技术栈
* Spring Boot：用于简化Spring应用的创建和开发过程。
* Java 17：作为项目的编程语言版本。
* Spring Web：用于构建Web应用程序，包括RESTful应用程序。
* Spring Data JPA：简化了基于JPA的数据访问层的实现。
* MyBatis：提供了另一种数据库交互方式，是一个半ORM（对象关系映射）框架。
* Lombok：一个Java库，用于自动化生成getter、setter、equals、hashCode和toString等方法。
* Spring Data Redis：用于访问和管理Redis数据。
* Spring Boot Actuator：提供生产级服务的监控和管理功能。
* MySQL Connector/J：用于连接MySQL数据库的JDBC驱动。
* Aliyun SDK for OSS：阿里云对象存储服务（OSS）的SDK。


## 项目文件结构

- `/src`：包含所有源代码文件。
  - `/main`：
    - `/java`：存放Java源代码文件。
      -`/canglangpoxiao`
        -`/smart_store_back`
          -`/config`：  包含项目的配置类，用于定义和管理应用程序的配置信息。
          -`/controller`： 存放控制器类，负责处理用户请求和返回响应。
          -`/entity`： 包含实体（或模型）类，代表数据库中的表，并用于映射数据。
          -`/mapper`： 用于MyBatis的映射器接口，定义了数据库操作的方法。
          -`/repository`： 存放Spring Data JPA的仓库接口，用于简化数据库访问。
    - `/resources`：包含所有非代码资源，如配置文件和静态资源。
      -`/mapper`：包含对应的SQL查询语句。
  - `/test`：包含测试代码和资源。
- `/target`：存放Maven构建生成的文件。
- `pom.xml`：Maven项目对象模型文件，定义了项目的构建、依赖和配置信息。
- `README.md`：项目说明文件，提供项目概述、安装指南、使用说明等。


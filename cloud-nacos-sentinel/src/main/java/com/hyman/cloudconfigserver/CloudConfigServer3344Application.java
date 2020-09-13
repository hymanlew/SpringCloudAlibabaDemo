package com.hyman.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 分布式系统面临的配置问题：
 * 微服务意味着要将单体应用中的业务拆分成一个个子服务，每个服务的粒度相对较小，因此系统中会出现大量的服务。由于每个服务都需要必
 * 要的配置信息才能运行，所以一套集中的，动态的配置管理设施是必不可少的。我们每个微服务自己带着一个 application.yml，上百个配
 * 置文件的管理就很复杂了，SpringCloud 提供了 ConfigServer 来解决这个问题。
 *
 * SpringCloud Config 为微服务架构中的微服务提供集中化的外部配置支持，配置服务器为各个不同微服务应用的所有环境提供了一个中心化
 * 的外部配置。它也分为服务端和客户端。由于 config server 和 config client 都实现了对 spring environment 和 propertySource
 * 抽象的映射，因此 cloud config 非常适合 spring 应用程序，当然也可以与任何其他语言编写的应用程序配合使用。因为它使用的是 REST API。
 *
 * 服务端也称为分布式配置中心，是一个独立的微服务应用，是一个可横向扩展，集中式的配置服务器。用来连接配置服务器并为客户端提供获
 * 取配置信息，加密/解密信息等访问接口。也用于集中管理应用程序各个环境下的配置。默认采用 git 来存储配
 * 置信息（也可使用 SVN，本地文件系统或 vault 存储配置），这样有助于对环境配置进行版本管理，并且可以通过 git 客户端工具来方便的
 * 管理和访问配置内容。
 *
 * 客户端则是通过指定的配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息，执行相关操作。
 *
 * 作用（为什么要统一管理配置）：
 * 1，集中管理配置文件。
 * 2，不同环境不同配置，动态化的配置更新，分环境部署（例如 dev/test/prod/release）。
 * 3，运行期间动态调整配置，不再需要在每个服务部署的机器上编写配置文件，服务会向配置中心统一拉取配置自己的信息。
 * 4，自动刷新。当配置发生变动时，服务不需要重启即可感知配置的变化并应用新的配置，即动态刷新。
 * 5，将配置信息以 REST 接口的形式暴露。
 *
 * 当然 ConfigServer 并不是唯一的配置，也可以使用其他组件进行分布式配置管理，如 zookeeper，consul，百度的 disconf（比较成熟），
 * 阿里的 diamond，携程的 apollo。
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigServer3344Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigServer3344Application.class, args);
	}

}

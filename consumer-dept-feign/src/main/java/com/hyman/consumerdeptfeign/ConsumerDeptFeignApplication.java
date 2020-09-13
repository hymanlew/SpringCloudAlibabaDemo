package com.hyman.consumerdeptfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 一，JAX-WS（Java API for XML-Based Web Services）：
 * 其含义是，一个远程调用可以转换为一个基于XML的协议例如SOAP，在使用JAX-WS过程中，开发者不需要编写任何生成和处理SOAP消息的代码。
 * JAX-WS 的运行时实现会将这些API的调用转换成为对应的SOAP消息。
 * 在服务器端，用户只需要通过Java语言定义远程调用所需要实现的接口 SEI（service endpoint interface），并提供相关的实现，通过调
 * 用 JAX-WS 的服务发布接口就可以将其发布为 WebService 接口。
 * 在客户端，用户可以通过 JAX-WS 的 API 创建一个代理（用本地对象来替代远程的服务）来实现对于远程服务器端的调用。
 * 当然 JAX-WS 也提供了一组针对底层消息进行操作的API调用，你可以通过 Dispatch 直接使用SOAP消息或XML消息发送请求或者使用 Provider
 * 处理SOAP或XML消息。
 * 通过web service所提供的互操作环境，我们可以用 JAX-WS 轻松实现 JAVA 平台与其他编程环境（.net等）的互操作。
 *
 * JAX-WS 与 JAX-RPC之间的关系：
 * Sun最开始的web services的实现是JAX-RPC 1.1(JSR 101)。这个实现是基于Java的RPC，并不完全支持schema规范，同时没有对 Binding
 * 和 Parsing 定义标准的实现。
 * JAX-WS 2.0 (JSR 224)是Sun新的web services协议栈，是一个完全基于标准的实现。在binding层，使用的是 Java Architecture for XML
 * Binding (JAXB, JSR 222)，在 parsing层，使用的是the Streaming API for XML (StAX, JSR 173)，同时它还完全支持schema规范。
 *
 * 二，JAX-RS（Java API for RESTful Web Services）：
 * JAX-RS 提供了一些标注将一个资源类，一个POJO Java类，封装为Web资源。标注包括：
 * @Path，标注资源类或者方法的相对路径。
 * @GET，@PUT，@POST，@DELETE，标注方法是HTTP请求的类型。
 * @Produces，标注返回的MIME媒体类型
 * @Consumes，标注可接受请求的MIME媒体类型
 * @PathParam，@QueryParam，@HeaderParam，@CookieParam，@MatrixParam，@FormParam，分别标注方法的参数来自于HTTP请求的不同
 * 位置。例如 Path 来自于URL的路径，Query 来自于URL的查询参数，Header 来自于HTTP请求的头信息，Cookie 来自于HTTP请求的Cookie。
 *
 * 基于JAX-RS实现的框架有 Jersey，RESTEasy等。这两个框架创建的应用可以很方便地部署到Servlet 容器中，比如Tomcat，JBoss等。并且
 * RESTEasy是由JBoss公司开发的，所以将用RESTEasy框架实现的应用部署到JBoss服务器上，可以实现很多额外的功能。
 *
 * 三，JAX-WS 与 JAX-RS两者是不同风格的SOA架构。
 *
 *
 * Feign：是一个声明式的 web service REST 客户端。使用时只需要创建一个接口再加上一个注解（EnableFeignClients）即可。同时也支
 * 持 JAX-RS 标准的注解和可插拔式的编码器和解码器。
 * springCloud 对 Feign 进行了封装，使其支持了 spring MVC 标准注解和 HttpMessageConverters，可以与 Eureka 和 Ribbon 组合使
 * 用以支持负载均衡。
 *
 * Ribbon 主要是面向微服务的调用，因为在消费端要指定声明一个提供者的微服务名称。而 java 是面向接口（例如 DAO 层的面向对象）的
 * 编程。
 *
 * 所以 springCloud 提供了两种方式来进行微服务的调用：
 * 1，是通过微服务的名称 + RestTemplate，来获得调用地址（Ribbon）。
 * 2，是通过接口 + 注解，获得调用服务并调用服务中的方法（Feign）。
 *
 * Feign 旨在使编写 java http 客户端变得更容易。之前使用 Ribbon + RestTemplate 时，利用 template 对 http 请求的封装处理，形
 * 成了一套模版化的调用方法。但在实际开发中由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服
 * 务自行封装一些客户端类来包装这些依赖服务的调用。所以 Feign 在此基础上做了进一步封装，由他来帮助我们定义和实现依赖服务接口的
 * 定义。在 Feign 实现下，我们只需创建一个接口并使用注解的方式来配置它即可完成对服务提供方的接口绑定，简化了使用 SpringCloud
 * Ribbon 时，自动封装服务调用客户端的开发量。
 *
 * Feign 集成了 Ribbon，前者利用后者维护了提供者微服务的服务列表信息，并且通过轮询实现了客户端的负载均衡。而两者不同的是，通过
 * Feign 只需要定义服务绑定接口且以声明式的方法，优雅而简单的实现了服务调用。
 *
 * Feign 自动集成了 Hystrix 服务，所以可以直接使用它。
 */

@SpringBootApplication(scanBasePackages = "com.hyman.cloudapi.service")
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.hyman.consumerdeptfeign"})
public class ConsumerDeptFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDeptFeignApplication.class, args);
	}

}

package com.hyman.nacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**

 服务发现组件的功能（包含服务注册，发现，注册中心）：
 服务注册表，是一个记录当前可用服务实例的网络信息的数据库，是服务发现机制的核心。是包含服务实例的网络地址的数据库。服务注册表需要高可用而且随时更新。
 服务注册和注销，该组件提供了查询 API 和管理 API，前者可以获取可用的服务实例，后者实现注册和注销（即服务注册注销）。服务实例必须在注册表中注册和注销。
 健康检查，心跳机制。

 服务实例的网络位置都是动态分配的。由于扩展、失败和升级，服务实例会经常动态改变，因此客户端代码需要使用更加复杂的服务发现机制。服务发现有两种方式：
 1，客户端发现（Eureka，zk），该模式下客户端决定相应服务实例的网络位置，并且对请求实现负载均衡。客户端查询服务注册表（它包含了所有的可用服务实例），然后使用负载均衡算法从中选择一个实例，并发出请求。服务实例的网络位置在启动
 时被记录到服务注册表，等实例终止时被删除。服务实例的注册信息通常使用心跳机制来定期刷新。
 客户端发现模式优缺点兼有。该模式相对直接，除了服务注册外，其它部分无需变动。且由于客户端知晓可用的服务实例，能针对特定应用实现智能负载均衡，比如使用哈希一致性。这种模式的缺点就是客户端与服务注册绑定，要针对服务端用到的每个
 编程语言和框架，实现客户端的服务发现逻辑。
 2，服务端发现（Consul + nginx），客户端通过负载均衡器向某个服务提出请求，负载均衡器查询服务注册表，并将请求转发到可用的服务实例。如同客户端发现，服务实例在服务注册表中注册或注销。
 AWS Elastic Load Balancer（ELB）是服务端发现路由的例子，ELB 通常均衡来自互联网的外部流量，也可用来负载均衡 VPC（Virtual private cloud）的内部流量。客户端使用 DNS 通过 ELB 发出请求（HTTP 或 TCP），ELB 在已注册的 EC2 实例或
 ECS 容器之间负载均衡。这里并没有单独的服务注册表，相反 EC2 实例和 ECS 容器注册在 ELB。HTTP 服务器与 NGINX 这样的负载均衡起也能用作服务端的发现均衡器。在更复杂的实现中，需要使用 HTTP API 或 DNS 来动态配置 NGINX Plus。
 服务端发现最大的优点是客户端无需关注发现的细节，只需要简单地向负载均衡器发送请求，这减少了编程语言框架需要完成的发现逻辑。并且某些部署环境免费提供这一功能（nginx）。但缺点是，除非负载均衡器由部署环境提供，否则会成为一个需
 要配置和管理的高可用系统组件。

 服务注册的方式：
 1，自注册，服务实例自己在服务注册表中注册和注销。另外如果需要的话，一个服务实例也要发送心跳来保证注册信息不会过时（例如 Eureka）。该模式优点是相对简单，无需其它系统组件。缺点是把服务实例和服务注册表耦合，必须在每个编程语言
 和框架内实现注册代码。
 2，第三方注册，是采用管理服务实例注册的其它系统组件，将服务与服务注册表解耦合。即服务实例不需要向服务注册表注册；而是由被称为服务注册器的另一个系统模块会处理。服务注册器会通过查询部署环境或订阅事件的方式来跟踪运行实例的更改。
 一旦侦测到有新的可用服务实例，会向注册表注册此服务。服务管理器也负责注销终止的服务实例。
 其优点是服务与服务注册表解耦合，无需为每个编程语言和框架实现服务注册逻辑；服务实例是通过一个专有服务以中心化的方式进行管理。它的不足之处在于，除非该服务内置于部署环境，否则需要配置和管理一个高可用的系统组件。
 Registrator 是一个开源的服务注册项目，它能够自动注册和注销被部署为 Docker 容器的服务实例。Registrator 支持包括 etcd 和 Consul 在内的多种服务注册表。
 *
 *
 * 传统的关系型数据库的 ACID 原则：原子性，一致性，独立性（隔离性），持久性。
 * 非关系型或分布式数据库的 CAP 原则：强一致性，高可用性，分区容错性。
 * Eureka 遵守 AP 原则，zookepeer 遵守 CP 原则。作为服务注册中心，前者比后者的优势是：
 *
 * CAP 理论指出，一个分布式系统不可能同时满足这三个要素。但又由于 P（分区容错性）在分布式系统中是必须要保证的，因此 eureka 保证
 * 的是高可用性，而 zookepeer 是保证强一致性。
 *
 * zookeeper 保证 CP：
 * 当向注册中心查询服务列表时，我们可容忍注册中心返回的是几分钟以前的注册信息，但不能接受服务直接 down 掉不可用。就是说服务注册
 * 功能对可用性的要求高于一致性。但 zk 会出现这样一种情况，当 master 主节点因为网络故障与其他节点失去联系时，剩余节点会重新进行
 * leader 选举。问题在于选举 leader 的时间太长（30~120s），且选举期间整个 zk 集群都是不可用的，这就导致在此期间注册服务瘫痪。在
 * 云部署的环境下，因网络问题使得集群失去 master 节点是较大概率发生的事，虽然服务能够最终恢复，但是漫长的选举时间导致的注册长期
 * 不可用是不能容忍的。
 *
 * eureka 保证 AP：
 * 由于 zk 的缺点因此 eureka 在设计时就优先保证可用性。它的各个节点都是平等的，几个节点挂掉不会影响正常节点的工作，剩余的节点依
 * 然可以提供注册和查询服务。而 eureka 的客户端在向某个 eureka 注册时若发现连接失败，则会自动切换至其他节点。只要有一台 eureka
 * 还在，就能保证注册服务可用（即保证可用性），只不过查询到的信息可能不是最新的（不保证强一致性）。除此之外 eureka 还有一种自我
 * 保护机制，如果在 15 分钟内超过 85% 的节点都没有正常的心跳，那么 eureka 就认为客户端与注册中心出现了网络故障。此时会出现以下
 * 几种情况：
 * 1，eureka 不再从注册列表中移除因为长时间没收到心跳而应该过期的服务。
 * 2，eureka 仍然能够接受新服务的注册和查询请求，但暂时不会被同步到其它节点上（即只是保证当前节点依然可用）。
 * 3，当网络稳定时，当前实例新的注册信息会被同步到其它节点中。
 * 因此 eureka 可以很好的应对因网络故障导致部分节点失去联系的情况，而不会像 zk 那样使整个注册服务瘫痪。
 *
 * Nacos 保证 AP 或 CP：
 * 即 Nacos 可以切换到 AP 或 CP 模式，而不是同时支持 CAP。一般来说，如果不需要存储服务级别的信息且服务实例是通过 nacos-client
 * 注册，并能够保持心跳上报，那么就可以选择 AP 模式。当前主流的 spring-cloud、dubbo 都适用于 AP 模式，此模式为了服务的可用性而
 * 减弱了一致性，因此 AP 模式下只支持注册临时实例。
 * 如果需要在服务级别编辑或存储配置信息，那么 CP 是必须，k8s 服务和 DNS 服务则适用于 CP 模式。此模式下支持注册持久化实例，此时
 * 是以 Raft 协议为集群运行模式，该模式下注册实例之前必须先注册服务，如果服务不存在，则会返回错误。
 *
 *
 虽然数据管理的去中心化（服务拆分，业务拆分）可以让数据管理更加细致化， 通过采用更合适的技术可让数据存储和性能达到最优（例如增加
 中台）。但是由于数据存储于不同的数据库实例中后， 数据一致性也成为微服务架构中亟待解决的问题之一。
 分布式事务本身的实现难度就非常大， 所以在微服务架构中， 我们更强调在各服务之间进行 “无事务” 的调用（RPC 远程或是 http 服务间查
 询调用）。而对于数据一致性， 只要求数据在最后的处理状态是一致的即可（服务间统一调用中台上的数据）。若在过程中发现错误， 通过补
 偿机制来进行处理（例如调用失败，可以采用数据表映射的方式，即冗余表数据），使得错误数据能够达到最终的一致性。

 RPC服务和HTTP服务的区别：
 1、最本质区别：RPC服务基于TCP/IP协议（其调用协议通常包含传输协议和编码协议）；HTTP服务主要是基于HTTP协议；
 2、由于HTTP协议（应用层协议）是位于TCP协议（传输层协议）之上的，相比之下，RPC效率更高；
 3、虽然RPC效率更高，但HTTP服务开发迭代会更快；
 4、RPC服务主要是针对大型企业的，而HTTP服务主要是针对小企业的；

 为什么要使用自定义 tcp 协议的 rpc 做后端进程通信：
 1，首先要搞清楚 http 使用的 tcp 协议，和自定义的 tcp 协议在报文上的区别。即 http 相较于自定义 tcp 的报文协议，一是增加的开销在
 于连接的建立与断开。但 http协议是支持连接池复用的，也就是建立一定数量的连接不断开，并不会频繁的创建和销毁连接。二是 http 也可以
 使用 protobuf 这种二进制编码协议对内容进行编码，因此二者最大的区别还是在传输协议上。

 通用定义的 http1.1 协议的 tcp 报文包含太多废信息，一个POST协议的格式大致如下：
 HTTP/1.0 200 OK
 Content-Type: text/plain
 Content-Length: 137582
 Expires: Thu, 05 Dec 1997 16:00:00 GMT
 Last-Modified: Wed, 5 August 1996 15:55:28 GMTServer: Apache 0.84  Hello World

 即使 body 消息体中的编码协议也使用二进制的编码协议，那么 header头的键值对报文元数据也还是使用了文本编码，非常占字节数。如上面报
 文中有效字节数仅仅占约 30%，也就是70%的时间用于传输元数据废编码。当然实际情况下报文内容可能会比这个长，即报头所占的比例是非常大
 的。而假如我们使用自定义的 tcp 协议，并设置报文的信息尽可能地缩小，那就会极大地精简了传输内容。这也就是为什么后端进程间通常会采
 用自定义 tcp 协议的 rpc 来进行通信的原因。

 http好比普通话，rpc好比团伙内部黑话。讲普通话，好处就是谁都听得懂，谁都会讲。讲黑话，好处是可以更精简、更加保密、更加可定制，坏
 处就是要求“说”黑话的那一方（client端）也要懂，而且一旦大家都说一种黑话了，换黑话就困难了。
 */

/**
 * Nacos 架构图：
 * provider app，服务提供者。
 * consumer app，服务消费者。
 * name server，通过 VIP（Vritual IP）或者 DNS 的方式实现 nacos 高可用集群的服务路由。
 * nacos console，nacos 控制台。
 *
 * nacos server，nacos 服务提供者，其包含的 OpenAPI 是功能访问入口，config service（配置服务），naming service（名字服务）是
 * nacos 提供的服务模块。consistency protocol 是一致性协议，用来实现 nacos 集群节点的数据同步，使用的是 Raft 算法。
 *
 * 整体来看，服务提供者通过 VIP 访问 nacos server 高可用集群，基于 OpenAPI 完成服务的注册和查询。nacos server 本身可支持主备
 * 模式，所以底层会采用数据一致性算法来完成从节点的数据同步。服务消费者也是如此，基于 OpenAPI 从 nacos server 中查询服务列表。
 *
 * Nacos 注册中心功能原理：
 * 服务实例在启动时注册到服务注册表，并在关闭时注销。服务消费者查询服务注册表，获得可用实例。服务注册中心需要调用服务实例的健康
 * 检查 API 来验证它是否能够正常处理请求。并且当 nacos server 检测到 provider 异常时，会基于 UDP 协议推送服务更新信息（json）
 * 到 consumer。使用 UDP 协议是因为服务端不关注返回结果，允许客户端没收到信息。
 *
 * Spring Cloud 将其规范化的定义都抽象到了 SpringCloud-Common 包中，即是统一的标准化流程（定义了接口），如服务注册流程，发现流
 * 程。其实现及自动装配信息，都包含在了 SpringCloud-Common 包下 META-INF/spring.factories 文件中。而 dubbo 集成 nacos 时，服
 * 务注册依托的是 Dubbo 中的自动装配机制。是在 spring-cloud-alibaba-dubbo 下 META-INF/spring.factories 文件中。所以不需要单
 * 独创建配置一个 Nacos 模块项目。
 *
 * Nacos 服务监听有两种方式：
 * 1，客户端调用 /nacos/v1/ns/instance/list 定时轮询。
 * 2，基于 DatagramSocket 的 UDP 协议，实现服务端的主动推送。
 */
@SpringBootApplication
public class CloudNacos7001Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudNacos7001Application.class, args);
	}

}
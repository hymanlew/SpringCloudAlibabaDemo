package com.hyman.cloudapi.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @RequiredArgsConstructor， 将标记为 @NoNull 的属性生成一个构造器。如果运行中标记为@NoNull的属性为null,会抛出空指针异常。
 *
 * @Data， 直接修饰 POJO 对象， getter所有的变量，setter所有不为final的变量。
 *      如果你不需要默认的生成方式，直接填写你需要的 annotation 就可以了。默认生成的所有的 annotation 都是 public的。
 *      如果需要不同权限修饰符可以使用 AccessLevel.NONE 选项。当然@Data 也可以使用 staticConstructor 选项生成一个静态方法。
 *      即 @Data = @Setter+@Getter+@EqualsAndHashCode+@NoArgsConstructor。
 *
 * @Value， 与 @Data相对应，其主要区别是如果变量不加 @NonFinal，@Value会将所有变量弄成 final的。当然如果是final的话，就没有set方法了。
 *
 * @Builder， 自动构造添加 Builder 模式的结构。通过内部类 Builder() 进行构建对象（而可以不用 new 创建对象了）。
 *
 * @Synchronized， 标注在方法上，声明该方法为同步方法。
 *
 * @SneakyThrows，@Cleanup， 前者标注在方法上，后者标注在方法体中的流对象前面。其作用是自动调用 close方法关闭方法中的流资源。
 *
 * @Log4j， 注解在类上；为类提供一个 属性名为log 的 log4j 日志对象。
 * @Cleanup， 可以关闭流。
 * @NonNull， 如果给参数加个这个注解 参数为null会抛出空指针异常。
 *
 * @Accessors， 注解用来配置lombok如何产生和显示getters和setters的方法（具体可百度）。它可以注解在类和属性上，如果是用在属性上，
 *      则对这个属性的类的 @Accessors 注解就会被忽略。
 *
 * 还有其他常用的注解方法（如 tostring，hashcode，equal，等等）
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)

// 在微服务中，每个实体类都要可序列化，这个很重要（因为 ORM 映射存储文件时必须是可序列化的）
public class Department implements Serializable{

    private int id;
    private String name;
    private String dbSource;    // 数据库名称，因为微服务架构中每个服务都可以有自己的数据库

}

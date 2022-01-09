package com.hyman.common.swagger;

import io.swagger.models.Swagger;
import io.swagger.models.Tag;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.service.Documentation;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2MapperImpl;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * description: 对swagger-->ServiceModelToSwagger2Mapper进行装饰增强，防止页面显示乱序，让其按照tag标签进行排序 <br>
 * date: 2020/6/23 11:27 <br>
 * author: hyman <br>
 */
@Component
@Primary
public class ServiceModelToSwagger2MapperImplDecoration extends ServiceModelToSwagger2MapperImpl {

    /**
     * @description 包装类,排序<br>
     * @Param: [form]
     * @Return: io.swagger.models.Swagger
     * @Date: 2020/6/23 12:55
     */
    @Override
    public Swagger mapDocumentation(Documentation from) {

        Swagger swagger = super.mapDocumentation(from);
        if(null == swagger){
            return swagger;
        }

        if(null == swagger.getTags() || swagger.getTags().size() <= 0){
            return swagger;
        }
        swagger.setTags(swagger.getTags()
                .stream().sorted(Comparator.comparing(Tag::getName))
                .collect(Collectors.toList()));
        return swagger;
    }
}

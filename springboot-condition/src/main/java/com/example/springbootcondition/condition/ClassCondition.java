package com.example.springbootcondition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class ClassCondition implements Condition {
    /**
     * @param context  上下文对象,用于获取环境,IOC容器,ClassLoader对象
     * @param metadata 注解元对象,可以用于获取注解定义的属性值
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

/*        //1.导入jedis坐标
        boolean flag = true;
        try {
            Class<?> cls = Class.forName("redis.clients.jedis.Client");
        } catch (ClassNotFoundException e) {
            flag = false;
        }

        return flag;*/

        //2.导入指定坐标,通过注解属性值value指定坐标后创建Bean
        //获取注解属性值 value
        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        System.out.println(map);
        String[] values = (String[]) map.get("value");
        boolean flag = true;
        try {
            for (String className : values) {
                Class<?> cls = Class.forName(className);
                System.out.println(className);
            }
        } catch (ClassNotFoundException e) {
            flag = false;
        }

        return flag;
    }
}

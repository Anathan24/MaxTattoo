package com.maxtattoo.utils.logger;

//import ch.qos.logback.classic.pattern.TargetLengthBasedClassNameAbbreviator;
import com.maxtattoo.command.GenericCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ConditionalOnProperty(name = "LOG_LEVEL", havingValue = "INFO")
public class CommandLog implements BeanPostProcessor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //private final TargetLengthBasedClassNameAbbreviator abbreviator = new TargetLengthBasedClassNameAbbreviator(60);

    @PostConstruct
    void init(){
        logger.info("CommandLong activated");
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        if(bean instanceof GenericCommand){
            List<Object> args = Arrays.stream(bean.getClass().getDeclaredFields())
                    .filter(field -> Arrays.stream(field.getAnnotations())
                        .noneMatch(Autowired.class::isInstance))
                    .map(field -> {
                        ReflectionUtils.makeAccessible(field);
                        Object value = ReflectionUtils.getField(field, bean);
                        boolean isByteArray = value instanceof byte[];
                        return isByteArray ? "byte[] skipped" : value;
                    }).collect(Collectors.toList());
            String name = bean.getClass().getName();
//            String abbreviated = abbreviator.abbreviate(name);
             logger.info("Create command [{}] with constructor: {}.",null /*abbreviated*/, args);
        }
        return bean;
    }
}

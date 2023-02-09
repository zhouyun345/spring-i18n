package cn.zy.i18n.config;

import cn.zy.i18n.config.JacksonConfig.MyLocalDateTimeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.time.LocalDateTime;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class ObjectMapperPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof ObjectMapper) {
      SimpleModule simpleModule = new SimpleModule();
      simpleModule.addSerializer(LocalDateTime.class,
          new MyLocalDateTimeSerializer());
      ((ObjectMapper) bean).registerModule(simpleModule);
    }
    return bean;
  }
}

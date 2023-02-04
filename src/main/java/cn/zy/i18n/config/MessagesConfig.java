package cn.zy.i18n.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessagesConfig {

  @Bean
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
    messageBundle.setBasenames(
        new String[]{"classpath:messages/messages", "classpath:messages/errors"});
    messageBundle.setDefaultEncoding("UTF-8");
    messageBundle.setCacheSeconds(10);
    messageBundle.setUseCodeAsDefaultMessage(true);
    return messageBundle;
  }
}

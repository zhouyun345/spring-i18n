package cn.zy.i18n;

import cn.zy.i18n.utils.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class I18nApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(I18nApplication.class,
        args);
    SpringContextUtils.setApplicationContext(applicationContext);
  }

}

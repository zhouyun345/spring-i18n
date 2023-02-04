package cn.zy.i18n.utils;

import org.springframework.context.ApplicationContext;

/**
 * SpringContextUtils.
 */
public final class SpringContextUtils {

  /**
   * applicationContext.
   */
  private static ApplicationContext applicationContext;

  private SpringContextUtils() {

  }

  /**
   * getApplicationContext.
   *
   * @return
   */
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  /**
   * setApplicationContext.
   *
   * @param applicationContext applicationContext
   */
  public static void setApplicationContext(ApplicationContext applicationContext) {
    SpringContextUtils.applicationContext = applicationContext;
  }

  /**
   * 返回指定bean的实例.
   *
   * @param beanName beanName
   * @return
   */
  public static Object getBean(String beanName) {
    if (applicationContext.containsBean(beanName)) {
      return applicationContext.getBean(beanName);
    } else {
      return null;
    }
  }
}

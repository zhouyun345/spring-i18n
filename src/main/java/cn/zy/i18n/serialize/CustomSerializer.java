package cn.zy.i18n.serialize;

import cn.zy.i18n.utils.SpringContextUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class CustomSerializer extends JsonSerializer<Object> implements ContextualSerializer {

  private MessageSource messageSource;

  private String localeKey;

  public CustomSerializer() {
  }

  public CustomSerializer(String localeKey, MessageSource messageSource) {
    this.localeKey = localeKey;
    this.messageSource = messageSource;
  }

  @Override
  public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {
    String message = "";
    if (value instanceof String) {
      message = messageSource.getMessage(localeKey + value,
          null, LocaleContextHolder.getLocale());
    }
    gen.writeString(message);
  }

  @Override
  public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
      throws JsonMappingException {
    CustomSerial annotation = property.getAnnotation(CustomSerial.class);
    Object messageSource = SpringContextUtils.getBean("messageSource");
    return new CustomSerializer(annotation.localeKey(), (MessageSource) messageSource);
  }
}

package cn.zy.i18n.serialize;

import cn.zy.i18n.enums.IBaseEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.ReflectionUtils;

public class IBaseEnumSerializer extends JsonSerializer<IBaseEnum> {

  @Override
  public void serialize(IBaseEnum value, JsonGenerator gen,
      SerializerProvider serializers) throws IOException {
    String method =
        "getDesc" + StringUtils.capitalize(LocaleContextHolder.getLocale().getLanguage());
    Method getMethod = ReflectionUtils.findMethod(value.getClass(), method);
    String message = (String) ReflectionUtils.invokeMethod(getMethod, value);
    gen.writeString(message);
  }
}

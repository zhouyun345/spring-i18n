package cn.zy.i18n.config;

import cn.zy.i18n.enums.IBaseEnum;
import cn.zy.i18n.serialize.IBaseEnumSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer mapperBuilderCustomizer() {
    return jacksonObjectMapperBuilder -> {
      IBaseEnumSerializer iBaseEnumSerializer = new IBaseEnumSerializer();
      jacksonObjectMapperBuilder.serializerByType(IBaseEnum.class, iBaseEnumSerializer);
      jacksonObjectMapperBuilder.serializerByType(LocalDateTime.class,
          new MyLocalDateTimeSerializer());
    };
  }


  public static class MyLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    public MyLocalDateTimeSerializer() {
    }

    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator,
        SerializerProvider serializers) throws IOException {
      jsonGenerator.writeNumber(String.valueOf(
          localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond()));
    }
  }
}

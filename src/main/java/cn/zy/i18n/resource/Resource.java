package cn.zy.i18n.resource;

import cn.zy.i18n.enums.TypeEnum;
import cn.zy.i18n.serialize.CustomSerial;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Activity.
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Resource implements Serializable {

  private static final long serialVersionUID = 3839362892294769115L;

  @JsonProperty("Id")
  private Integer id;

  @JsonProperty("LeadId")
  private String name;

  @CustomSerial(localeKey = "activity.status.")
  private String statusName;

  private TypeEnum type;

  private LocalDateTime createTime;
}

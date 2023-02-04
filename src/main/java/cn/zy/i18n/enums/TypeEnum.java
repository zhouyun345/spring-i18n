package cn.zy.i18n.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum TypeEnum implements IBaseEnum {
  RETAIL("Retail", "零售车"),
  DEMO("DEMO", "展厅车");

  @JsonValue
  private final String descEn;

  private final String descZh;

  TypeEnum(String descEn, String descZh) {
    this.descEn = descEn;
    this.descZh = descZh;
  }
}

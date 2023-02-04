package cn.zy.i18n.controller;

import cn.zy.i18n.resource.Resource;
import cn.zy.i18n.enums.TypeEnum;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class TestController {

  @GetMapping("test")
  public Resource test() {
    Resource resource = new Resource();
    resource.setId(1);
    resource.setType(TypeEnum.RETAIL);
    resource.setStatusName("已完成");
    resource.setCreateTime(LocalDateTime.now());
    return resource;
  }
}

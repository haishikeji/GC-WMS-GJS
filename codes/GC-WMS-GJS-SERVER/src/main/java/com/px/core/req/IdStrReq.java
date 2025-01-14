package com.px.core.req;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * -字符 串id请求bean
 */
@Data
public class IdStrReq {

  @NotBlank(message = "主键id不能为空")
  private String id;

}

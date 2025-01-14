package com.px.sys.req;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

/**
 * -用户修改请求bean
 */
@Getter
@Setter
public class UserUpdateReq extends UserAddReq implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * -主键id -10
   */
  @NotNull(message = "主键id不能为空")
  @Range(min = 1)
  private Integer id;

}


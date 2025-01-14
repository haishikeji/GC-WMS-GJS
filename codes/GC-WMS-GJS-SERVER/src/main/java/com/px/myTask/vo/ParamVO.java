package com.px.myTask.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Task查询响应bean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * -参数名称
   */
  private String paramName;
  /**
   * -参数类型
   */
  private String beanName;

}

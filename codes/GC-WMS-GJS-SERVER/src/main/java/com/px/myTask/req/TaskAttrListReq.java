package com.px.myTask.req;

import java.io.Serializable;
import com.px.core.req.PageReq;
import lombok.Getter;
import lombok.Setter;

/**
 * -列表查询请求bean
 */
@Getter
@Setter
public class TaskAttrListReq extends PageReq implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * -任务id -10
   */
  private Integer taskId;
  /**
   * -参数名称 -50
   */
  private String paramName;
  /**
   * -参数值 -50
   */
  private String paramValue;
  /**
   * -参数bean -50
   */
  private String beanName;
  /**
   * -参数排序 -3
   */
  private Integer sorted;

}

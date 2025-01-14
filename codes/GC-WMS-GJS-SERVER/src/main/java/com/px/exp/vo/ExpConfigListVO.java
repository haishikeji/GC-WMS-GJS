package com.px.exp.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * -通用导出表格配置主表列表响应bean
 */
@Data
public class ExpConfigListVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * -id
   */
  private Integer id;
  /**
   * -状态 1启用 2禁用
   */
  private Integer status;
  /**
   * -名称
   */
  private String name;
  /**
   * -导出标识
   */
  private String tag;
  /**
   * -导出文件名
   */
  private String fileName;
  /**
   * -导出主表名
   */
  private String tableName;
  /**
   * -排序标识
   */
  private String orderTag;
  /**
   * -备注
   */
  private String remark;

}

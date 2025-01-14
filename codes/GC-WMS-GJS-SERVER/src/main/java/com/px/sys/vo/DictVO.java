package com.px.sys.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Dict实体类
 */
@Data
public class DictVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * -主键id
   */
  private Integer id;

  /**
   * -层级
   */
  private Integer levels;

  /**
   * -排序
   */
  private Integer sorted;

  /**
   * -父id
   */
  private Integer pid;

  /**
   * -名称
   */
  private String name;

  /**
   * -字典标识/英文数字
   */
  private String tag;

  /**
   * -字典值
   */
  private String val;

  private Integer deptId;

  private List<DictVO> children;

}

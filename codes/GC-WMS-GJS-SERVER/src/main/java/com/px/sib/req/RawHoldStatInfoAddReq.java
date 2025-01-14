package com.px.sib.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * -原材料物料留存信息表添加请求bean
 */
@Data
public class RawHoldStatInfoAddReq implements Serializable {
	
	private static final long serialVersionUID = 1L;

  /**
   * -统计月度 yyyy-mm
   * -10
   */
  @NotBlank(message = "统计月度 yyyy-mm不能为空")
  @Length(max = 10, message="统计月度 yyyy-mm长度不正确")
  private String monthlyStat;
  /**
   * -起始日期
   * -19
   */
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date monthStart;
  /**
   * -月度结束日期
   * -19
   */
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date monthEnd;
  /**
   * -大类别ID
   * -10
   */
  @NotNull(message = "大类别ID不能为空")
  private Integer categoryId;
  /**
   * -类别名称
   * -10
   */
  @NotBlank(message = "类别名称不能为空")
  @Length(max = 10, message="类别名称长度不正确")
  private String category;
  /**
   * -unit
   * -10
   */
  @NotBlank(message = "unit不能为空")
  @Length(max = 10, message="unit长度不正确")
  private String unit;
  /**
   * -perWeight
   * -22
   */
  @NotNull(message = "perWeight不能为空")
  private Double perWeight;
  /**
   * -spec
   * -30
   */
  @NotBlank(message = "spec不能为空")
  @Length(max = 30, message="spec长度不正确")
  private String spec;
  /**
   * -qty
   * -10
   */
  @NotNull(message = "qty不能为空")
  private Integer qty;
  /**
   * -matId
   * -10
   */
  @NotNull(message = "matId不能为空")
  private Integer matId;
  /**
   * -mat
   * -30
   */
  @NotBlank(message = "mat不能为空")
  @Length(max = 30, message="mat长度不正确")
  private String mat;
  /**
   * -创建时间
   * -19
   */
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date created;

}

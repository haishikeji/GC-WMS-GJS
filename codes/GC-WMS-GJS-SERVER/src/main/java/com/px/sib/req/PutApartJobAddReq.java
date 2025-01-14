package com.px.sib.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * -拨出作业表添加请求bean
 */
@Data
public class PutApartJobAddReq implements Serializable {
	
	private static final long serialVersionUID = 1L;

  /**
   * -wareId
   * -10
   */
  @NotNull(message = "wareId不能为空")
  private Integer wareId;
  /**
   * -子仓库名称
   * -10
   */
//  @NotBlank(message = "子仓库名称不能为空")
//  @Length(max = 10, message="子仓库名称长度不正确")
  private String ware;
  /**
   * -票号
   * -20
   */
  @NotBlank(message = "票号不能为空")
  @Length(max = 20, message="票号长度不正确")
  private String tiketNo;
  /**
   * -出库类型（返废、存档、样币）
   * -10
   */
  @NotNull(message = "出库类型（返废、存档、样币）不能为空")
  private Integer apartType;
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
//  @NotBlank(message = "mat不能为空")
//  @Length(max = 30, message="mat长度不正确")
  private String mat;
  /**
   * -产成品物料ID
   * -10
   */
//  @NotNull(message = "产成品物料ID不能为空")
  private Integer prdMatId;
  /**
   * -产成品物料名称
   * -30
   */
//  @NotBlank(message = "产成品物料名称不能为空")
//  @Length(max = 30, message="产成品物料名称长度不正确")
  private String prdMat;
  /**
   * -物料规格
   * -30
   */
//  @NotBlank(message = "物料规格不能为空")
//  @Length(max = 30, message="物料规格长度不正确")
  private String spec;
  /**
   * -单枚单位
   * -10
   */
//  @NotBlank(message = "单枚单位不能为空")
//  @Length(max = 10, message="单枚单位长度不正确")
  private String unit;
  /**
   * -单枚重量
   * -22
   */
//  @NotNull(message = "单枚重量不能为空")
  private Double perWeight;
  /**
   * -出库件数
   * -10
   */
  @NotNull(message = "出库件数不能为空")
  private Integer qty;
  /**
   * -出库重量(单枚重量*领入件数)
   * -22
   */
  @NotNull(message = "出库重量(单枚重量*领入件数)不能为空")
  private Double totalWeight;
  /**
   * -创建时间
   * -19
   */
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date created;
  /**
   * -库管1
   * -10
   */
//  @NotBlank(message = "库管1不能为空")
//  @Length(max = 10, message="库管1长度不正确")
  private String creator01;
  /**
   * -库管2
   * -10
   */
//  @NotBlank(message = "库管2不能为空")
//  @Length(max = 10, message="库管2长度不正确")
  private String creator02;
  /**
   * -库管1编号
   * -10
   */
//  @NotBlank(message = "库管1编号不能为空")
//  @Length(max = 10, message="库管1编号长度不正确")
  private Integer creator01Id;
  /**
   * -库管2编号
   * -10
   */
//  @NotBlank(message = "库管2编号不能为空")
//  @Length(max = 10, message="库管2编号长度不正确")
  private Integer creator02Id;

}

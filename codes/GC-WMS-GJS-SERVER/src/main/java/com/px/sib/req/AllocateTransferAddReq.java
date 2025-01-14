package com.px.sib.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * -调拨出库表添加请求bean
 */
@Data
public class AllocateTransferAddReq implements Serializable {
	
	private static final long serialVersionUID = 1L;

  /**
   * -调出子仓库ID
   * -10
   */
  @NotNull(message = "调出子仓库ID不能为空")
  private Integer wareFromId;
  /**
   * -wareFrom
   * -10
   */
//  @NotBlank(message = "wareFrom不能为空")
//  @Length(max = 10, message="wareFrom长度不正确")
  private String wareFrom;
  /**
   * -拨入子仓库ID
   * -10
   */
  @NotNull(message = "拨入子仓库ID不能为空")
  private Integer wareToId;
  /**
   * -拨入子仓库名称
   * -10
   */
//  @NotBlank(message = "拨入子仓库名称不能为空")
//  @Length(max = 10, message="拨入子仓库名称长度不正确")
  private String wareTo;
  /**
   * -物料大类别ID
   * -10
   */
//  @NotNull(message = "物料大类别ID不能为空")
  private Integer categoryId;
  /**
   * -物料大类别
   * -10
   */
//  @NotBlank(message = "物料大类别不能为空")
//  @Length(max = 10, message="物料大类别长度不正确")
  private String category;
  /**
   * -原材料物料ID
   * -10
   */
  @NotNull(message = "原材料物料ID不能为空")
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
   * -unit
   * -10
   */
//  @NotBlank(message = "unit不能为空")
//  @Length(max = 10, message="unit长度不正确")
  private String unit;
  /**
   * -perWeight
   * -22
   */
//  @NotNull(message = "perWeight不能为空")
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
   * -备注
   * -80
   */
//  @NotBlank(message = "备注不能为空")
  @Length(max = 80, message="备注长度不正确")
  private String remark;
  /**
   * -负责人
   * -10
   */
  @NotBlank(message = "负责人不能为空")
  @Length(max = 10, message="负责人长度不正确")
  private String principal;
  /**
   * -负责人编号
   * -10
   */
  @NotNull(message = "负责人编号不能为空")
  private Integer principalId;
  /**
   * -创建时间
   * -19
   */
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date created;
  /**
   * -库管员1
   * -10
   */
//  @NotBlank(message = "库管员1不能为空")
//  @Length(max = 10, message="库管员1长度不正确")
  private String creator01;
  /**
   * -库管员2
   * -10
   */
//  @NotBlank(message = "库管员2不能为空")
//  @Length(max = 10, message="库管员2长度不正确")
  private String creator02;
  /**
   * -库管员1编号
   * -10
   */
//  @NotNull(message = "库管员1编号不能为空")
//  @Length(max = 10, message="库管员1编号长度不正确")
  private Integer creator01Id;
  /**
   * -库管员2编号
   * -10
   */
//  @NotNull(message = "库管员2编号不能为空")
//  @Length(max = 10, message="库管员2编号长度不正确")
  private Integer creator02Id;

}

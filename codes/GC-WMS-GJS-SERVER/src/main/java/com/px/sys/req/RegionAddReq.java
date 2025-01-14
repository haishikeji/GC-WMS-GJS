package com.px.sys.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import lombok.Data;

/**
 * -省市区添加请求bean
 */
@Data
public class RegionAddReq implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * -地区等级 1省 2市 3区 -3
   */
  @NotNull(message = "地区等级 1省 2市 3区不能为空")
  private Integer levels;

  /**
   * -上级编号 -10
   */
  @NotNull(message = "上级编号不能为空")
  private Integer pcode;
  /**
   * -地区名称 -20
   */
  @NotBlank(message = "地区名称不能为空")
  @Length(max = 20, message = "地区名称长度不正确")
  private String name;
  /**
   * -经度 -10
   */
  private Double longitude;
  /**
   * -纬度 -10
   */
  private Double latitude;

}

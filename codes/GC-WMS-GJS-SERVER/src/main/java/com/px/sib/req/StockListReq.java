package com.px.sib.req;

import java.io.Serializable;
import com.px.core.req.PageReq;
import lombok.Getter;
import lombok.Setter;

/**
 * -子库实时库存主表列表查询请求bean
 */
@Getter
@Setter
public class StockListReq extends PageReq implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
  /**
   * -子仓库ID
   * -10
   */
  private Integer wareId;
  /**
   * -子仓库名称
   * -10
   */
  private String ware;
  /**
   * -类别ID
   * -10
   */
  private Integer categoryId;
  /**
   * -类别名称
   * -10
   */
  private String category;
  /**
   * -原料物料ID
   * -10
   */
  private Integer matId;
  /**
   * -原料物料名称
   * -30
   */
  private String mat;
  /**
   * -prdMatId
   * -10
   */
  private Integer prdMatId;
  /**
   * -prdMat
   * -30
   */
  private String prdMat;
  /**
   * -单枚单位
   * -10
   */
  private String unit;
  /**
   * -perWeight
   * -22
   */
  private Double perWeight;
  /**
   * -spec
   * -30
   */
  private String spec;
  /**
   * -库存件数
   * -10
   */
  private Integer qty;
  /**
   * -库存总重量
   * -22
   */
  private Double totalWeight;
  /**
   * -成色ID
   * -10
   */
  private Integer purityId;
  /**
   * -成色（999，9999）
   * -10
   */
  private String purity;

}

package com.px.sib.vo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * -子库出库单表列表响应bean
 */
@Data
public class SubwareOutListVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

  /**
   * -自增主键
   */
  private Integer id;
  /**
   * -仓库ID
   */
  private Integer wareId;
  /**
   * -子仓库出库名称
   */
  private String ware;
  /**
   * -物料大类别ID
   */
  private Integer categoryId;
  /**
   * -物料大类别名称
   */
  private String category;
  /**
   * -原材料物料ID
   */
  private Integer matId;
  /**
   * -物料名称
   */
  private String mat;
  /**
   * -物料规格
   */
  private String spec;
  /**
   * -单枚单位
   */
  private String unit;
  /**
   * -单枚重量
   */
	private Double perWeight;
  /**
   * -出库件数
   */
  private Integer qty;
  /**
   * -出库重量(单枚重量*领入件数)
   */
	private Double totalWeight;
  /**
   * -是否需要出库样币 1:需要 2:不需要
   */
  private Integer isNeedProofCoin;
  /**
   * -样币ID
   */
  private Integer proofCoinId;
  /**
   * -样币名称
   */
  private String proofCoin;
  /**
   * -样币总数量
   */
  private Integer proofCoinQty;
  /**
   * -下道仓库ID
   */
  private Integer nextWareId;
  /**
   * -下道仓库名称
   */
  private String nextWare;
  /**
   * -创建时间
   */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date created;
  /**
   * -库管1
   */
  private String creator01;
  /**
   * -库管2
   */
  private String creator02;
  /**
   * -出库人1
   */
  private String outor01;
  /**
   * -出库人2
   */
  private String outor02;
  /**
   * -产成品物料ID
   */
  private Integer prdMatId;
  /**
   * -产成品物料
   */
  private String prdMat;
  /**
   * -库管1ID
   */
  private Integer creator01Id;
  /**
   * -库管2ID
   */
  private Integer creator02Id;
  /**
   * -出库人1ID
   */
  private Integer outor01Id;
  /**
   * -出库人2ID
   */
  private Integer outor02Id;
  /**
   * -交接凭证号（选填字段：判断当前库物料的ware_id为待腐蚀，且物料为银，则页面显示该输入框）
   */
  private String voucherNo;
  /**
   * -样币总重量
   */
	private Double proofCoinWeight;
  /**
   * -出库类型默认1:普通原料出库 2：普通产品出库 3:划拨出库 4.拨出出库 5.产成品出库
   */
  private Integer outType;
  /**
   * -入库状态：1未入库 2:已入库
   */
  private Integer status;
  /**
   * -备注
   */
  private String remark;
  
  private String creator00;
  
  public String getCreator00() {
	  return this.creator01 + "," + this.creator02;
  }

  private String outor00;
  
  public String getOutor00() {
	  return this.outor01 + "," + this.outor02;
  }
  
}

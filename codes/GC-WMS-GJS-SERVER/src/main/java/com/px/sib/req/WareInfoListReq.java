package com.px.sib.req;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import com.px.core.req.PageReq;
import lombok.Getter;
import lombok.Setter;

/**
 * -仓库信息表，包含子库定义与工序属性列表查询请求bean
 */
@Getter
@Setter
public class WareInfoListReq extends PageReq implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
  /**
   * -子库名称，类似于仓位
   * -10
   */
  private String ware;
  /**
   * -排序
   * -10
   */
  private Integer sort;
  /**
   * -大库ID，子库归属于某大库
   * -10
   */
  private Integer bigWareId;
  /**
   * -大库
   * -10
   */
  private String bigWare;
  /**
   * -工序名称:每个子库对应一个后续工序,工序为属性字段
   * -10
   */
  private String procedure;
  /**
   * -状态 1:启用2:停用
   * -10
   */
  private Integer status;
  /**
   * -创建者
   * -10
   */
  private String creator;
  /**
   * -创建时间
   * -19
   */
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date created;

}

package com.px.exp.service;

import com.px.core.service.BaseService;
import com.px.exp.model.*;
import com.px.exp.vo.*;

import java.util.List;

/**
 * -通用导出表格查询条件表Service
 */
public interface ExpWhereService extends BaseService<ExpWhere, ExpWhereExample> {

  /**
   * - 根据查询条件查询带分页集合
   *
   * @param id 主表id
   * @return {@link ExpColumnListVO}
   */
  List<ExpWhereListVO> listByBaseId(Integer id);

}

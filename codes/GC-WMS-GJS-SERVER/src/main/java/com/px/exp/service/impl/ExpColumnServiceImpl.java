package com.px.exp.service.impl;

import com.px.core.service.impl.BaseServiceImpl;
import com.px.exp.dao.ExpColumnDao;
import com.px.exp.model.*;
import com.px.exp.service.ExpColumnService;
import com.px.exp.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * -通用导出表格配置主表ServiceImpl
 */
@Service
public class ExpColumnServiceImpl extends
    BaseServiceImpl<ExpColumnDao, ExpColumn, ExpColumnExample> implements ExpColumnService {

  /**
   * - 根据查询条件查询带分页集合
   *
   * @param id 主表id
   * @return {@link ExpColumnListVO}
   */
  @Override
  public List<ExpColumnListVO> listByBaseId(Integer id) {
    ExpColumnExample example = new ExpColumnExample();
    ExpColumnExample.Criteria cr = example.createCriteria();
    cr.andBaseIdEqualTo(id);
    example.setOrderByClause("id asc");
    List<ExpColumnListVO> resp = this.dao.selectVOByExample(example);
    return resp;
  }

}

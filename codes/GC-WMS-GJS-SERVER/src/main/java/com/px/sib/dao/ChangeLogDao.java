package com.px.sib.dao;

import com.px.sib.mapper.ChangeLogMapper;
import com.px.sib.model.*;
import com.px.sib.vo.ChangeLogListVO;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * -修改记录Dao
 */
@Component
public interface ChangeLogDao extends ChangeLogMapper {
	
	List<ChangeLogListVO> selectVOByExample(ChangeLogExample example);
	
}

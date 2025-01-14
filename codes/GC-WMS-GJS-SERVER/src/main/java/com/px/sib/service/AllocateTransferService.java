package com.px.sib.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.px.core.service.BaseService;
import com.px.sib.model.*;
import com.px.sib.req.*;
import com.px.sib.vo.*;

/**
 * -调拨出库表Service
 */
public interface AllocateTransferService extends BaseService<AllocateTransfer, AllocateTransferExample> {
	/**
	 * - 根据查询条件查询带分页集合
	 * @param req {@link AllocateTransferListReq}
	 * @return {@link AllocateTransferListVO}
	 */
	PageInfo<AllocateTransferListVO> list(AllocateTransferListReq req);

	/**
	 * 增加划拨入库单据，划拨只处理一种物料
	 * 当 产成品物料 划拨 为 原材料物料时，需要根据产成品物料-->获取原材料物料
	 * 1.增加划拨出库记录
	 * 2.将调出仓库，增加子库出库记录
	 * 3.将拨入仓库，增加子库入库记录
	 * 4.将实时库存变更
	 * @param req
	 */
	public void addAllocateTransfer(AllocateTransfer req);

	List<AllocateTransferListVO> exp(AllocateTransferListReq req);
}

package com.px.sib.controller;

import com.github.pagehelper.PageInfo;
import com.px.config.CustomConfig;
import com.px.core.annotation.CurrentUser;
import com.px.core.aop.annotation.AuthRole;
import com.px.core.aop.annotation.Operation;
import com.px.core.req.IdReq;
import com.px.core.util.DateUtils;
import com.px.core.util.ExcelExportUtil;
import com.px.core.vo.CacheUserVO;
import com.px.sib.model.WarehouseEntry;
import com.px.sib.req.WarehouseEntryAddReq;
import com.px.sib.req.RollBackReq;
import com.px.sib.req.WarehouseEntryListReq;
import com.px.sib.req.WarehouseEntryUpdateReq;
import com.px.sib.service.WarehouseEntryService;
import com.px.sib.vo.WarehouseEntryListVO;
import com.px.sib.vo.WarehouseEntryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Date;

import javax.validation.Valid;

/**
 * -入库单表Controller
 */
@RestController
@RequestMapping(value = "/warehouseEntry")
public class WarehouseEntryController {
	
  @Autowired
  private WarehouseEntryService warehouseEntryService;

  /*** -入库单表根据id查询详情
   * @param req {@link IdReq}
   * @return data {@link WarehouseEntryVO}
   */
  @PostMapping("/get")
  public Object get(@RequestBody @Valid IdReq req){
    WarehouseEntryVO data = null;
    WarehouseEntry model = this.warehouseEntryService.getModel(req.getId());
    data = new WarehouseEntryVO();
    BeanUtils.copyProperties(model, data);
    return data;
  }
    
	/**
	 * -入库单表根据条件查询带分页列表
	 * @param req {@link WarehouseEntryListReq}
	 * @return data {@link WarehouseEntryListVO}
	 */
	@PostMapping("/list")
	public Object list(@RequestBody WarehouseEntryListReq req) {
		PageInfo<WarehouseEntryListVO> data = this.warehouseEntryService.list(req);
		return data;
	}

  /**
   * -入库单表列表项
   * @return data> {@link OptVO}
   */
// @GetMapping("/opt")
// public Object opt(){
// List<OptVO> data = this.warehouseEntryService.opt();
//   return data;
// }

  /**
   * -入库单表新增
   * @param req {@link WarehouseEntryAddReq}
   * @return
   */
  @Operation(value = "新增入库单表")
  @PostMapping("/add")
  @AuthRole(path="warehouseEntry", value="add")
  public Object add(@RequestBody WarehouseEntryAddReq req, @CurrentUser CacheUserVO user) {
//      CheckAuth.assertReadOnly(user);
      WarehouseEntry model = new WarehouseEntry();
      BeanUtils.copyProperties(req, model);
      model.setCreator01(user.getRealName());
      model.setCreator01Id(user.getId());
      model.setCreator02(user.getUser2().getRealName());
      model.setCreator02Id(user.getUser2().getId());
      warehouseEntryService.addEntry(model);
      return true;
  }
    
  /**
   * -入库单表修改
   * @param req {@link WarehouseEntryUpdateReq}
   * @return
   */
  @Operation(value = "修改入库单表")
  @PostMapping("/update")
  @AuthRole(path="warehouseEntry", value="update")
  public Object update(@RequestBody @Valid WarehouseEntryUpdateReq req, @CurrentUser CacheUserVO user) {
      this.warehouseEntryService.update(req, user);
      return null;
  }

    /**
     * -回滚入库单表
     * @param req
     * @param user
     * @return
     */
    @Operation(value = "回滚入库单表")
    @PostMapping("/rollback")
    @AuthRole(path="warehouseEntry", value="rollback")
    public Object cancel(@RequestBody @Valid RollBackReq req, @CurrentUser CacheUserVO user) {
        this.warehouseEntryService.rollback(req, user);
        return null;
    }


    
  /**
   * -入库单表修改状态
   * @param req {@link IdReq}
   * @return data 修改后的状态
   */
//  @Operation(value = "修改入库单表状态")
//  @PostMapping("/status")
//  public Object status(@RequestBody @Valid IdReq req, @CurrentUser CacheUserVO user){
//    WarehouseEntry model = this.warehouseEntryService.getModel(req.getId());
//    if(model.getStatus() != null && model.getStatus().intValue() == Constants.STATUS_FORBIDDEN) {
//      model.setStatus(Constants.STATUS_USABLE);
//    } else {
//      model.setStatus(Constants.STATUS_FORBIDDEN);
//    }
//    this.warehouseEntryService.updateSelective(model);
//    return model.getStatus();
//  }

  /**
   * -入库单表删除
   * @param req {@link IdReq}
   * @return
   */
  @Operation(value = "删除入库单表")
  @PostMapping("/delete")
  @AuthRole(path="warehouseEntry", value="delete")
  public Object delete(@RequestBody @Valid IdReq req, @CurrentUser CacheUserVO user){
//    WarehouseEntry model = this.warehouseEntryService.getModel(req.getId());
//    model.setDelFlag(Constants.STATUS_FORBIDDEN);
//    this.warehouseEntryService.updateSelective(model);
    this.warehouseEntryService.deleteModel(req.getId());
    return "";
  }
    
  private static String[] codes = {"ware", "mat", "spec", "unit", "perWeight", "qty", "totalWeight", "creator00", "entranceDate", "voucherNo"};
  private static String[] names = {"对应仓库", "物料名称", "规格", "单枚单位", "单枚重量", "领入件数", "领入重量", "库管", "入库日期", "交接凭证号"};

  @Autowired
  private CustomConfig customConfig;

  /**
   * -入库单表导出
   * @param req {@link IdsListReq IdReq}
   * @return 文件url
   */
  @PostMapping("/exp")
  public Object exp(@RequestBody WarehouseEntryListReq req){
	  List<WarehouseEntryListVO> list = this.warehouseEntryService.listExp(req);
	  ExcelExportUtil<WarehouseEntryListVO> excelExport = new ExcelExportUtil<>();
	  String date = DateUtils.toString(new Date(), DateUtils.YYMMDD);
	  String name = date + "贵金属领料入库记录.xlsx";
	  String resp = excelExport.exportData(names, codes, list, name, customConfig.getAttaPath(), customConfig.getAttaUrl());
      return resp;
  }
    
  /**
   * -入库单表导入
   * @return
   */
//  @PostMapping("/imp")
//  public Object imp(@RequestParam(required=true) MultipartFile file, @CurrentUser CacheUserVO user){
//      Workbook workbook = ExcelUtil.readExcel(file);
//      List<WarehouseEntryAddReq> list = ExcelImport.convertToList(WarehouseEntryAddReq.class, workbook, codes, names, 1, 1);
//      this.validData(list);
//      this.warehouseEntry.batchAdd(list, user);
//      return "";
//  }
    
  /**
   * -验证数据长度,非空
   * @param list {@link WarehouseEntryAddReq}
   */
//	private void validData(List<WarehouseEntryAddReq> list) {
//		if(list != null && list.size() > 0) {
//			for (int i = 0; i < list.size(); i++) {
//				ValidatorUtils.validateEntity(i, list.get(i));
//			}
//		}
//	}

}

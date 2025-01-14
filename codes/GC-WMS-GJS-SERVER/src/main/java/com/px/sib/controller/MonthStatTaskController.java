package com.px.sib.controller;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.px.config.CustomConfig;

import java.io.File;
import java.util.List;
import javax.validation.Valid;

import com.px.core.aop.annotation.AuthRole;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import com.px.core.aop.annotation.Operation;
import com.px.core.annotation.CurrentUser;
import com.px.core.req.*;
import com.px.core.vo.*;

import com.px.sib.model.*;
import com.px.sib.service.MonthStatTaskService;
import com.px.sib.vo.*;
import com.px.sib.req.*;

/**
 * -将月度报表先创建任务，启动任务，将文件生成到指定目录Controller
 */
@RestController
@RequestMapping(value = "/monthStatTask")
public class MonthStatTaskController {
	
  @Autowired
  private MonthStatTaskService monthStatTaskService;

  /**
   * -将月度报表先创建任务，启动任务，将文件生成到指定目录根据条件查询带分页列表
   * @param req {@link MonthStatTaskListReq}
   * @return data {@link MonthStatTaskVO}
   */
  @PostMapping("/list")
  public Object list(@RequestBody MonthStatTaskListReq req) {
    PageInfo<MonthStatTaskListVO> data = this.monthStatTaskService.list(req);
    return data;
  }

  /** -将月度报表先创建任务，启动任务，将文件生成到指定目录根据id查询详情
   * @param req {@link IdReq}
   * @return data {@link MonthStatTaskVO}
   */
  @PostMapping("/get")
  public Object get(@RequestBody @Valid IdReq req){
    MonthStatTaskVO data = null;
    MonthStatTask model = this.monthStatTaskService.getModel(req.getId());
    data = new MonthStatTaskVO();
    BeanUtils.copyProperties(model, data);
    return data;
  }

  /**
   * -将月度报表先创建任务，启动任务，将文件生成到指定目录新增
   * @param req {@link MonthStatTaskAddReq}
   * @return
   */
  @Operation(value = "新增将月度报表先创建任务，启动任务，将文件生成到指定目录")
  @PostMapping("/add")
  @AuthRole(path="monthStatTask", value="add")
  public Object add(@RequestBody @Valid MonthStatTaskAddReq req, @CurrentUser CacheUserVO user){
    this.monthStatTaskService.add(req, user);
    return "";
  }

  @Operation(value = "更新月度报表任务数据")
  @PostMapping("/update")
  @AuthRole(path="monthStatTask", value="update")
  public Object update(@RequestBody @Valid IdReq req, @CurrentUser CacheUserVO user){
    this.monthStatTaskService.update(req.getId(), user);
    return "";
  }

  @Autowired
  private CustomConfig customConfig;

  /**
   * -将月度报表先创建任务，启动任务，将文件生成到指定目录删除
   * @param req {@link IdReq}
   * @return
   */
  @Operation(value = "删除将月度报表先创建任务，启动任务，将文件生成到指定目录")
  @PostMapping("/delete")
  @AuthRole(path="monthStatTask", value="delete")
  public Object delete(@RequestBody @Valid IdReq req, @CurrentUser CacheUserVO user){
    MonthStatTask model = this.monthStatTaskService.getModel(req.getId());
    if (StringUtils.isNotBlank(model.getUrl())) {
      List<MonthFileVO> list = JSON.parseArray(model.getUrl(), MonthFileVO.class);
      for (int i = 0; i < list.size(); i++) {
        File f = new File(customConfig.getAttaPath() + list.get(i).getUrl());
        f.delete();
      }
    }
    this.monthStatTaskService.deleteModel(req.getId());
    return "";
  }
    
//  private static String[] codes = {"id", "taskType", "taskName", "monthly", "monthStart", "monthEnd", "status", "url", "created", "creator"};
//  private static String[] names = {"自增主键", "任务类型1:金饼料饼收付存月报 2:银饼料饼收付存月报3:成品废品统计月报4.生产月报", "任务名称1:金饼料饼收付存月报 2:银饼料饼收付存月报3:成品废品统计月报4.生产月报", "统计月份: 2023-01", "月度开始日期（yyyy-mm-dd）", "月度结束日期", "任务状态 1:初始创建2:运行中 3: 任务完成", "产生月度报表的excel的url", "创建时间", "创建人用户名"};
//
//  @Autowired
//  private CustomConfig customConfig;

  /**
   * -将月度报表先创建任务，启动任务，将文件生成到指定目录导出
   * @param req {@link IdsListReq IdReq}
   * @return 文件url
   */
//  @PostMapping("/exp")
//  public Object exp(@RequestBody IdsListReq req){
//  MonthStatTaskExample example = new MonthStatTaskExample();
//  List<MonthStatTask> list = this.monthStatTaskService.list(example);
//  ExcelExportUtil<MonthStatTask> excelExport = new ExcelExportUtil<>();
//  String resp = excelExport.exportData(names, codes, list, "将月度报表先创建任务，启动任务，将文件生成到指定目录.xlsx", customConfig.getAttaPath(), customConfig.getAttaUrl());
//      return resp;
//  }
    
  /**
   * -将月度报表先创建任务，启动任务，将文件生成到指定目录导入
   * @return
   */
//  @PostMapping("/imp")
//  public Object imp(@RequestParam(required=true) MultipartFile file, @CurrentUser CacheUserVO user){
//      Workbook workbook = ExcelUtil.readExcel(file);
//      List<MonthStatTaskAddReq> list = ExcelImport.convertToList(MonthStatTaskAddReq.class, workbook, codes, names, 1, 1);
//      this.validData(list);
//      this.monthStatTask.batchAdd(list, user);
//      return "";
//  }
    
  /**
   * -验证数据长度,非空
   * @param list {@link MonthStatTaskAddReq}
   */
//	private void validData(List<MonthStatTaskAddReq> list) {
//		if(null != list && list.size() > 0) {
//			for (int i = 0; i < list.size(); i++) {
//				ValidatorUtils.validateEntity(i, list.get(i));
//			}
//		}
//	}

  /**
   * -获取上一月报最后日期+一天
   * @param req {@link IdReq}
   * @return
   */
  @PostMapping("/getLastDate")
  public Object getLastDate(@RequestBody @Valid LastDateReq req){
    String data = this.monthStatTaskService.getLastDate(req.getMonthly());
    return data;
  }

}

package com.px.sys.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.px.core.aop.annotation.Operation;
import com.px.core.constants.Constants;
import com.px.core.annotation.CurrentUser;
import com.px.core.req.*;
import com.px.core.vo.*;

import com.px.sys.model.*;
import com.px.sys.service.MenuService;
import com.px.sys.vo.*;
import com.px.sys.req.*;

/**
 * -菜单Controller
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;

  /**
   * -菜单详情
   *
   * @param req {@link IdReq}
   * @return MenuVO {@link MenuVO}
   */
  @PostMapping("/get")
  public Object get(@RequestBody @Valid IdReq req) {
    MenuVO data = null;
    Menu model = this.menuService.getModel(req.getId());
    data = new MenuVO();
    BeanUtils.copyProperties(model, data);
    return data;
  }

  /**
   * -菜单带分页列表
   *
   * @return PageInfo<MenuListVO> {@link MenuListReq}
   */
  @GetMapping(value = "/listTree")
  public Object list() {
    List<MenuListVO> data = this.menuService.listTree();
    return data;
  }

  /**
   * -菜单新增
   *
   * @param req {@link MenuAddReq}
   * @return
   */
  @Operation(value = "新增菜单")
  @PostMapping("/add")
  public Object add(@RequestBody @Valid MenuAddReq req, @CurrentUser CacheUserVO user) {
    Menu model = new Menu();
    BeanUtils.copyProperties(req, model);
    model.setStatus(Constants.STATUS_USABLE);
    model.setCreateTime(new Date());
    model.setCreateBy(user.getRealName());
    if (model.getHideBreadcrumb() == null) {
      model.setHideBreadcrumb(false);
    }
    if (model.getHideMenu() == null) {
      model.setHideMenu(false);
    }
    if (model.getPid() == null) {
      model.setPid(0);
    }
    this.menuService.addModel(model);
    return "";
  }

  /**
   * -菜单修改
   *
   * @param req {@link MenuUpdateReq}
   * @return
   */
  @Operation(value = "修改菜单")
  @PostMapping("/update")
  public Object update(@RequestBody @Valid MenuUpdateReq req, @CurrentUser CacheUserVO user) {
    Menu model = this.menuService.getModel(req.getId());
    BeanUtils.copyProperties(req, model);
    this.menuService.updateSelective(model);
    return "";
  }

  /**
   * -菜单修改状态
   *
   * @param req {@link StatusReq}
   * @return 修改后的状态
   */
  @Operation(value = "修改菜单状态")
  @PostMapping("/status")
  public Object status(@RequestBody @Valid IdReq req, @CurrentUser CacheUserVO user) {
    Menu model = this.menuService.getModel(req.getId());
    if (model.getStatus() != null && model.getStatus().intValue() == Constants.STATUS_FORBIDDEN) {
      model.setStatus(Constants.STATUS_USABLE);
    } else {
      model.setStatus(Constants.STATUS_FORBIDDEN);
    }
    this.menuService.updateSelective(model);
    return model.getStatus();
  }

  /**
   * -菜单下拉选项树,用于配置角色菜单
   *
   * @return {@link OptVO}
   */
  @GetMapping("/opt")
  public Object listOpt() {
    List<OptVO> data = this.menuService.listOpt();
    return data;
  }

}

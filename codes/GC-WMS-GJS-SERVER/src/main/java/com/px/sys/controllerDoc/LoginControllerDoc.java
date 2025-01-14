package com.px.sys.controllerDoc;

/**
 * -接口文档
 */
public class LoginControllerDoc {

  /**
   * @api {POST} /login 1.登录
   * @apiGroup 01.登录登出
   * @apiParam {String} username 用户名
   * @apiParam {String} password 密码（明文）
   * @apiParam {String} year 年度 yyyy
   * @apiParamExample 请求体示例 { "username":"admin", "password":"123456", "year":"2021" }
   * @apiSuccess {String} username  用户名
   * @apiSuccess {String} realName  真实姓名
   * @apiSuccess {String} token 访问令牌
   * @apiSuccess {String} username  用户名
   * @apiSuccess {Object[]} menus  菜单集合
   * @apiSuccess {Integer} menus.id  菜单id
   * @apiSuccess {Integer} menus.pid  菜单父id
   * @apiSuccess {String} menus.name  菜单名称
   * @apiSuccess {String} menus.path  路径
   * @apiSuccess {String} menus.menuName  菜单名称
   * @apiSuccess {String} menus.component  路由
   * @apiSuccess {String} menus.parentMenu  父级菜单
   * @apiSuccess {String} menus.redirect  跳转
   * @apiSuccess {Integer} menus.type 类型 1目录 2菜单 3按钮
   * @apiSuccess {Object[]} menus.meta  菜单meta
   * @apiSuccess {Boolean} menus.meta.hideBreadcrumb  面包屑是否隐藏
   * @apiSuccess {Boolean} menus.meta.hideMenu  菜单是否隐藏
   * @apiSuccess {String} menus.meta.title 标题
   * @apiSuccess {String} menus.meta.icon  菜单图标
   * @apiSuccess {Object[]} menus.children  菜单子集
   * @apiSuccessExample 响应结果示例
   * <p>
   * { "code" : 0, "msg" : "操作成功", "retObj" : { "menus" : [ { "children" : [ { "children" : [ ],
   * "component" : "workplace", "id" : 6, "menuName" : "", "meta" : { "hideBreadcrumb" : false,
   * "hideMenu" : false, "icon" : "sys", "title" : "1" }, "name" : "513", "parentMenu" : "", "path"
   * : "12", "pid" : 1, "redirect" : "sys", "type" : 0 }, { "children" : [ ], "component" :
   * "analysis", "id" : 2, "menuName" : "", "meta" : { "hideBreadcrumb" : false, "hideMenu" : false,
   * "icon" : "sys", "title" : "1" }, "name" : "菜单管理", "parentMenu" : "", "path" : "12", "pid" : 1,
   * "redirect" : "sys", "type" : 0 } ], "component" : "dashboard", "id" : 1, "menuName" : "",
   * "meta" : { "hideBreadcrumb" : false, "hideMenu" : false, "icon" : "sys", "title" : "1" },
   * "name" : "系统管理", "parentMenu" : "", "path" : "12", "pid" : 0, "redirect" : "sys", "type" : 0 }
   * ], "realName" : "111", "token" : "TGT3O2QLPZ5WX22F2GMOMXZNI1I6U0", "username" : "111" },
   * "success" : true }
   */
  public void login() {
  }

  /**
   * @api {GET} /logout 2.登出
   * @apiGroup 01.登录登出
   * @apiHeader {String} token 安全令牌
   * @apiHeaderExample {json} Header-Example: { "token": "TGT3Q39JL0L6GJL32RLP8GLXY3TPR0" }
   */
  public void logout() {
  }

  /**
   * @api {GET} /menusTree 3.当前用户获取菜单，用于菜单展示，与登录中返回的菜单树相同，单列出的接口
   * @apiGroup 01.登录登出
   * @apiHeader {String} token 安全令牌
   * @apiHeaderExample {json} Header-Example: { "token": "TGT3Q39JL0L6GJL32RLP8GLXY3TPR0" }
   * @apiSuccess {Integer} id  菜单id
   * @apiSuccess {Integer} pid  菜单父id
   * @apiSuccess {String} name  菜单名称
   * @apiSuccess {String} path  路径
   * @apiSuccess {String} menuName  菜单名称
   * @apiSuccess {String} component  路由
   * @apiSuccess {String} parentMenu  父级菜单
   * @apiSuccess {String} redirect  跳转
   * @apiSuccess {Integer} type 类型 1目录 2菜单 3按钮
   * @apiSuccess {Object[]} meta  菜单meta
   * @apiSuccess {Boolean} meta.hideBreadcrumb  面包屑是否隐藏
   * @apiSuccess {Boolean} meta.hideMenu  菜单是否隐藏
   * @apiSuccess {String} meta.title 标题
   * @apiSuccess {String} meta.icon  菜单图标
   * @apiSuccessExample 响应结果示例 { "code" : 0, "msg" : "操作成功", "retObj" : [ { "children" : [ {
   * "children" : [ ], "component" : "workplace", "id" : 6, "menuName" : "", "meta" : {
   * "hideBreadcrumb" : false, "hideMenu" : false, "icon" : "sys", "title" : "1" }, "name" : "513",
   * "parentMenu" : "", "path" : "12", "pid" : 1, "redirect" : "sys", "type" : 0 }, { "children" : [
   * ], "component" : "analysis", "id" : 2, "menuName" : "", "meta" : { "hideBreadcrumb" : false,
   * "hideMenu" : false, "icon" : "sys", "title" : "1" }, "name" : "菜单管理", "parentMenu" : "", "path"
   * : "12", "pid" : 1, "redirect" : "sys", "type" : 0 } ], "component" : "dashboard", "id" : 1,
   * "menuName" : "", "meta" : { "hideBreadcrumb" : false, "hideMenu" : false, "icon" : "sys",
   * "title" : "1" }, "name" : "系统管理", "parentMenu" : "", "path" : "12", "pid" : 0, "redirect" :
   * "sys", "type" : 0 } ], "success" : true }
   */
  public void menusTree() {
  }

}

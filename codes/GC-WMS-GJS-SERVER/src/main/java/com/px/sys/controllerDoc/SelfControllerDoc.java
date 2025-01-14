package com.px.sys.controllerDoc;

/**
 * -接口文档
 */
public class SelfControllerDoc {

  /**
   * @api {POST} /self/add 01.修改密码
   * @apiGroup 02.个人信息管理
   * @apiHeader {String} token 安全令牌
   * @apiHeaderExample {json} Header-Example: { "token": "TGT3Q39JL0L6GJL32RLP8GLXY3TPR0" }
   * @apiParam {String}  newPassword  新密码(明文)
   * @apiParam {String}  oldPassword  原密码(明文)
   * @apiParamExample 请求体示例 { "newPassword":"12345678", "oldPassword":"_abc000113_" }
   */
  public void updatePwd() {
  }

  /**
   * @api {GET} /self/get 02.获取个人信息
   * @apiGroup 02.个人信息管理
   * @apiHeader {String} token 安全令牌
   * @apiHeaderExample {json} Header-Example: { "token": "TGT3Q39JL0L6GJL32RLP8GLXY3TPR0" }
   * @apiSuccess {Integer}  id  id
   * @apiSuccess {Integer}  status  状态 1可用 2禁用
   * @apiSuccess {String}  createBy  创建人
   * @apiSuccess {String}  createTime  创建时间  yyyy-MM-dd HH:mm:ss
   * @apiSuccess {String}  username  用户名
   * @apiSuccess {String}  realName  真实姓名
   * @apiSuccess {Integer}  sex 	性别 1男 2女 3未知
   * @apiSuccess {Integer}  orgId 机构id
   * @apiSuccess {Integer}  deptId 部门id
   * @apiSuccess {String}  mobile  手机号
   * @apiSuccess {String}  telephone  电话
   * @apiSuccess {String}  birthday  生日  yyyy-MM-dd
   * @apiSuccess {String}  email  邮箱
   * @apiSuccess {String}  workNo  工号
   * @apiSuccess {String}  duty  职务
   * @apiSuccess {String}  avatar  头像
   * @apiSuccess {String}  remark  备注
   * @apiSuccessExample 响应结果示例 { "code" : 0, "msg" : "操作成功", "retObj" : { "avatar" : "", "birthday"
   * : "", "createBy" : "111", "createTime" : "2022-01-07 10:55:17", "deptId" : 0, "duty" : "",
   * "email" : "", "id" : 19, "mobile" : "", "orgId" : 0, "realName" : "李四", "remark" : "", "sex" :
   * 0, "status" : 1, "telephone" : "", "type" : 1, "updateBy" : "111", "updateTime" : "2022-01-07
   * 10:55:17", "username" : "lisi", "workNo" : "002" }, "success" : true }
   */
  public void get() {
  }

  /**
   * @api {POST} /user/update 03.修改个人信息
   * @apiGroup 02.个人信息管理
   * @apiHeader {String} token 安全令牌
   * @apiHeaderExample {json} Header-Example: { "token": "TGT3Q39JL0L6GJL32RLP8GLXY3TPR0" }
   * @apiParam {String}  realName  真实姓名
   * @apiParam {Integer}  [sex] 	性别 1男 2女 3未知
   * @apiParam {String}  [mobile]  手机号
   * @apiParam {String}  [telephone]  电话
   * @apiParam {String}  [birthday]  生日  yyyy-MM-dd
   * @apiParam {String}  [email]  邮箱
   * @apiParam {String}  [duty]  职务
   * @apiParam {String}  [avatar]  头像
   * @apiParam {String}  [remark]  备注
   * @apiParamExample 请求体示例 { "username":"sys4", "realName":"系统管理员", "mobile": "13056897841" }
   */
  public void update() {
  }

}

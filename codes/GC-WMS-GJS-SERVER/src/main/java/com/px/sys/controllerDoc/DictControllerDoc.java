package com.px.sys.controllerDoc;

/**
 * -接口文档
 */
public class DictControllerDoc {

  /**
   * @api {POST} /dict/get 01.获取字典详情
   * @apiGroup 01.数据字典
   * @apiParam {Integer} id 主键
   * @apiSuccess {Integer}  id  id
   * @apiSuccess {Integer}  status  状态 1可用 2禁用
   * @apiSuccess {Integer}  levels  层级
   * @apiSuccess {Integer}  sorted  排序
   * @apiSuccess {Integer}  pid  父id
   * @apiSuccess {String}  tag  标识
   * @apiSuccess {String}  val  值
   * @apiSuccess {String}  name  名称
   * @apiSuccessExample 响应结果示例 { "code" : 0, "msg" : "操作成功", "retObj" : { "id" : 78, "levels" : 2,
   * "name" : "字典测试", "pid" : 3, "sorted" : 0, "status" : 1, "tag" : "cost", "val" : "30" },
   * "success" : true }
   */
  public void get() {
  }

  /**
   * @api {GET} /dict/list 02.字典树形列表
   * @apiGroup 01.数据字典
   * @apiName 带分页列表
   * @apiSuccess {Integer}  id  id
   * @apiSuccess {Integer}  status  状态 1可用 2禁用
   * @apiSuccess {Integer}  levels  层级
   * @apiSuccess {Integer}  sorted  排序
   * @apiSuccess {Integer}  pid  父id
   * @apiSuccess {String}  tag  标识
   * @apiSuccess {String}  val  值
   * @apiSuccess {String}  name  名称
   */
  public void list() {
  }

  /**
   * @api {POST} /dict/add 03.新增字典
   * @apiGroup 01.数据字典
   * @apiParam {Integer}  [sorted]  排序
   * @apiParam {Integer}  [pid]  父id
   * @apiParam {String}  [tag]  标识
   * @apiParam {String}  [val] 值
   * @apiParam {String}  name  名称
   */
  public void add() {
  }

  /**
   * @api {POST} /dict/update 04.修改字典
   * @apiGroup 01.数据字典
   * @apiParam {Integer}  id  id
   * @apiParam {Integer}  [sorted]  排序
   * @apiParam {Integer}  [pid]  父id
   * @apiParam {String}  [tag]  标识
   * @apiParam {String}  [val] 值
   * @apiParam {String}  name  名称
   */
  public void update() {
  }

  /**
   * @api {POST} /dict/status 05.修改字典状态
   * @apiGroup 01.数据字典
   * @apiParam {Integer} id 主键
   * @apiSuccess {Integer} retObj 修改后的状态
   */
  public void status() {
  }

  /**
   * @api {GET} /dict/listOpt/{tag} 06.根据标识获取普通一层字典
   * @apiGroup 01.数据字典
   * @apiParam {String} tag 字典标识
   * @apiSuccess {Integer}  id  字典id
   * @apiSuccess {String}  name  字典名称
   * @apiSuccess {String}  val  字典值
   */
  public void listOpt() {
  }

  /**
   * @api {GET} /dict/listOptTree/{tag} 07.根据标识获取树型字典
   * @apiGroup 01.数据字典
   * @apiParam {String} tag 字典标识
   * @apiSuccess {Integer}  id  字典id
   * @apiSuccess {String}  name  字典名称
   * @apiSuccess {String}  val  字典值
   * @apiSuccess {Object[]}  children  子集
   */
  public void listOptTree() {
  }

  /**
   * @api {GET} /dict/listJoin/{tag}/{id} 08.根据标识获取级联下拉选项
   * @apiGroup 01.数据字典
   * @apiParam {String} tag 字典标识 (经费类别时传"cost"; 项目性质传:"quale")
   * @apiParam {Integer} [id] 字典标识 id为null获取一级数据 (经费类别默认默认传 20  项目性质默认传 ：31)
   * @apiSuccess {Integer}  id  字典id
   * @apiSuccess {String}  name  字典名称
   * @apiSuccess {String}  val  字典值
   */
  public void listJoin() {
  }

}

package com.px.log.controllerDoc;

/**
 * -接口文档
 */
public class OperateLogControllerDoc {

  /**
   * @api {POST} /operateLog/list 01.操作日志带分页列表
   * @apiGroup 99.操作日志
   * @apiHeader {String} token 安全令牌
   * @apiHeaderExample {json} Header-Example: { "token": "TGT3Q39JL0L6GJL32RLP8GLXY3TPR0" }
   * @apiParam {Integer}  page  页码
   * @apiParam {Integer}  rows  条数
   * @apiParam {String}  startDate  开始日期  yyyy-MM-dd
   * @apiParam {String}  endDate  结束日期  yyyy-MM-dd
   * @apiParamExample 请求体示例 { "page": 1, "Integer": 10, "startDate": "2022-01-01", "endDate":
   * "2022-01-31" }
   * @apiSuccess {Integer}  id  id
   * @apiSuccess {Integer}  status  操作状态 1成功 2失败
   * @apiSuccess {Integer}  type  请求方式(1普通方式 2ajax
   * @apiSuccess {String}  way  请求方式(post,get等)
   * @apiSuccess {Integer}  userId  用户id
   * @apiSuccess {String}  realName  用户姓名
   * @apiSuccess {String}  ip  请求ip
   * @apiSuccess {String}  name  请求操作名
   * @apiSuccess {String}  startTime  请求开始时间  yyyy-MM-dd HH:mm:ss
   * @apiSuccess {String}  returnTime  请求结束时间  yyyy-MM-dd HH:mm:ss
   * @apiSuccess {String}  url  请求地址
   * @apiSuccess {String}  className  请求执行的类名:方法名
   * @apiSuccess {String}  param  请求参数json
   * @apiSuccess {String}  errMsg  错误信息
   * @apiSuccessExample 响应结果示例 { "code" : 0, "msg" : "操作成功", "retObj" : { "endRow" : 1, "firstPage"
   * : 1, "hasNextPage" : true, "hasPreviousPage" : false, "isFirstPage" : true, "isLastPage" :
   * false, "lastPage" : 8, "list" : [ { "className" : "ProjectCostController:statisticsByCostType",
   * "errMsg" : "", "id" : 462, "ip" : "192.168.16.126", "name" : "根据经费类别统计经费", "param" :
   * "{\"deptId\":10,\"id\":5,\"orgId\":10,\"realName\":\"111\",\"roleIds\":null,\"token\":\"TGTGYDXD8HIAAJW2O8DZYOEJ0CC600\",\"username\":\"admin\",\"year\":\"2021\"}",
   * "realName" : "", "returnTime" : "2022-01-10 14:36:19", "startTime" : "2022-01-10 14:36:19",
   * "status" : 1, "type" : 1, "url" : "/projectCost/statisticsByCostType", "userId" : 0, "way" :
   * "POST" } ], "navigateFirstPage" : 1, "navigateLastPage" : 8, "navigatePages" : 8,
   * "navigatepageNums" : [ 1, 2, 3, 4, 5, 6, 7, 8 ], "nextPage" : 2, "pageNum" : 1, "pageSize" : 1,
   * "pages" : 377, "prePage" : 0, "size" : 1, "startRow" : 1, "total" : 377 }, "success" : true }
   */
  public void list() {
  }

}

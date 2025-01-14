package com.px.sys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeamExample {

  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public TeamExample() {
      oredCriteria = new ArrayList<Criteria>();
  }

  public void setOrderByClause(String orderByClause) {
      this.orderByClause = orderByClause;
  }

  public String getOrderByClause() {
      return orderByClause;
  }

  public void setDistinct(boolean distinct) {
      this.distinct = distinct;
  }

  public boolean isDistinct() {
      return distinct;
  }

  public List<Criteria> getOredCriteria() {
      return oredCriteria;
  }

  public void or(Criteria criteria) {
      oredCriteria.add(criteria);
  }

  public Criteria or() {
      Criteria criteria = createCriteriaInternal();
      oredCriteria.add(criteria);
      return criteria;
  }

  public Criteria createCriteria() {
      Criteria criteria = createCriteriaInternal();
      if (oredCriteria.size() == 0) {
          oredCriteria.add(criteria);
      }
      return criteria;
  }

  protected Criteria createCriteriaInternal() {
      Criteria criteria = new Criteria();
      return criteria;
  }

  public void clear() {
      oredCriteria.clear();
      orderByClause = null;
      distinct = false;
  }

  protected abstract static class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
        return criteria;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }

      protected void addCriterionForJDBCDate(String condition, Date value, String property) {
          if (value == null) {
              throw new RuntimeException("Value for " + property + " cannot be null");
          }
          addCriterion(condition, new java.sql.Date(value.getTime()), property);
      }

      protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
          if (values == null || values.size() == 0) {
              throw new RuntimeException("Value list for " + property + " cannot be null or empty");
          }
          List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
          Iterator<Date> iter = values.iterator();
          while (iter.hasNext()) {
              dateList.add(new java.sql.Date(iter.next().getTime()));
          }
          addCriterion(condition, dateList, property);
      }

      protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
          if (value1 == null || value2 == null) {
              throw new RuntimeException("Between values for " + property + " cannot be null");
          }
          addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
      }
        
    /**
     * -班组ID是null
     */
		public Criteria andIdIsNull() {
        addCriterion("id is null");
        return (Criteria) this;
    }
    /**
    * -班组ID不是null
    */
    public Criteria andIdIsNotNull() {
        addCriterion("id is not null");
        return (Criteria) this;
    }
    /**
    * -班组ID等于
    */
    public Criteria andIdEqualTo(Integer value) {
        addCriterion("id =", value, "id");
        return (Criteria) this;
    }
    /**
    * -班组ID不等于
    */
    public Criteria andIdNotEqualTo(Integer value) {
        addCriterion("id <>", value, "id");
        return (Criteria) this;
    }
    /**
    * -班组ID大于
    */
    public Criteria andIdGreaterThan(Integer value) {
        addCriterion("id >", value, "id");
        return (Criteria) this;
    }
    /**
    * -班组ID大于等于
    */
    public Criteria andIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("id >=", value, "id");
        return (Criteria) this;
    }
    /**
    * -班组ID小于
    */
    public Criteria andIdLessThan(Integer value) {
        addCriterion("id <", value, "id");
        return (Criteria) this;
    }
    /**
    * -班组ID小于等于
    */
    public Criteria andIdLessThanOrEqualTo(Integer value) {
        addCriterion("id <=", value, "id");
        return (Criteria) this;
    }
    /**
    * -班组ID在集合中
    */
    public Criteria andIdIn(List<Integer> values) {
        addCriterion("id in", values, "id");
        return (Criteria) this;
    }
    /**
     * -班组ID不在集合中
    */
    public Criteria andIdNotIn(List<Integer> values) {
        addCriterion("id not in", values, "id");
        return (Criteria) this;
    }
    /**
    * -班组ID在区间
    */
    public Criteria andIdBetween(Integer value1, Integer value2) {
        addCriterion("id between", value1, value2, "id");
        return (Criteria) this;
    }
    /**
    * -班组ID不在区间
    */
    public Criteria andIdNotBetween(Integer value1, Integer value2) {
        addCriterion("id not between", value1, value2, "id");
        return (Criteria) this;
    }
    /**
     * -班组名称是null
     */
		public Criteria andTeamIsNull() {
        addCriterion("team is null");
        return (Criteria) this;
    }
    /**
    * -班组名称不是null
    */
    public Criteria andTeamIsNotNull() {
        addCriterion("team is not null");
        return (Criteria) this;
    }
    /**
    * -班组名称等于
    */
    public Criteria andTeamEqualTo(String value) {
        addCriterion("team =", value, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称不等于
    */
    public Criteria andTeamNotEqualTo(String value) {
        addCriterion("team <>", value, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称大于
    */
    public Criteria andTeamGreaterThan(String value) {
        addCriterion("team >", value, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称大于等于
    */
    public Criteria andTeamGreaterThanOrEqualTo(String value) {
        addCriterion("team >=", value, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称小于
    */
    public Criteria andTeamLessThan(String value) {
        addCriterion("team <", value, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称小于等于
    */
    public Criteria andTeamLessThanOrEqualTo(String value) {
        addCriterion("team <=", value, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称符合
     */
    public Criteria andTeamLike(String value) {
        addCriterion("team like", value, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称不符合
    */
    public Criteria andTeamNotLike(String value) {
        addCriterion("team not like", value, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称在集合中
    */
    public Criteria andTeamIn(List<String> values) {
        addCriterion("team in", values, "team");
        return (Criteria) this;
    }
    /**
     * -班组名称不在集合中
    */
    public Criteria andTeamNotIn(List<String> values) {
        addCriterion("team not in", values, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称在区间
    */
    public Criteria andTeamBetween(String value1, String value2) {
        addCriterion("team between", value1, value2, "team");
        return (Criteria) this;
    }
    /**
    * -班组名称不在区间
    */
    public Criteria andTeamNotBetween(String value1, String value2) {
        addCriterion("team not between", value1, value2, "team");
        return (Criteria) this;
    }
    /**
     * -排序是null
     */
		public Criteria andSortIsNull() {
        addCriterion("sort is null");
        return (Criteria) this;
    }
    /**
    * -排序不是null
    */
    public Criteria andSortIsNotNull() {
        addCriterion("sort is not null");
        return (Criteria) this;
    }
    /**
    * -排序等于
    */
    public Criteria andSortEqualTo(Integer value) {
        addCriterion("sort =", value, "sort");
        return (Criteria) this;
    }
    /**
    * -排序不等于
    */
    public Criteria andSortNotEqualTo(Integer value) {
        addCriterion("sort <>", value, "sort");
        return (Criteria) this;
    }
    /**
    * -排序大于
    */
    public Criteria andSortGreaterThan(Integer value) {
        addCriterion("sort >", value, "sort");
        return (Criteria) this;
    }
    /**
    * -排序大于等于
    */
    public Criteria andSortGreaterThanOrEqualTo(Integer value) {
        addCriterion("sort >=", value, "sort");
        return (Criteria) this;
    }
    /**
    * -排序小于
    */
    public Criteria andSortLessThan(Integer value) {
        addCriterion("sort <", value, "sort");
        return (Criteria) this;
    }
    /**
    * -排序小于等于
    */
    public Criteria andSortLessThanOrEqualTo(Integer value) {
        addCriterion("sort <=", value, "sort");
        return (Criteria) this;
    }
    /**
    * -排序在集合中
    */
    public Criteria andSortIn(List<Integer> values) {
        addCriterion("sort in", values, "sort");
        return (Criteria) this;
    }
    /**
     * -排序不在集合中
    */
    public Criteria andSortNotIn(List<Integer> values) {
        addCriterion("sort not in", values, "sort");
        return (Criteria) this;
    }
    /**
    * -排序在区间
    */
    public Criteria andSortBetween(Integer value1, Integer value2) {
        addCriterion("sort between", value1, value2, "sort");
        return (Criteria) this;
    }
    /**
    * -排序不在区间
    */
    public Criteria andSortNotBetween(Integer value1, Integer value2) {
        addCriterion("sort not between", value1, value2, "sort");
        return (Criteria) this;
    }
    /**
     * -deptId是null
     */
		public Criteria andDeptIdIsNull() {
        addCriterion("dept_id is null");
        return (Criteria) this;
    }
    /**
    * -deptId不是null
    */
    public Criteria andDeptIdIsNotNull() {
        addCriterion("dept_id is not null");
        return (Criteria) this;
    }
    /**
    * -deptId等于
    */
    public Criteria andDeptIdEqualTo(Integer value) {
        addCriterion("dept_id =", value, "deptId");
        return (Criteria) this;
    }
    /**
    * -deptId不等于
    */
    public Criteria andDeptIdNotEqualTo(Integer value) {
        addCriterion("dept_id <>", value, "deptId");
        return (Criteria) this;
    }
    /**
    * -deptId大于
    */
    public Criteria andDeptIdGreaterThan(Integer value) {
        addCriterion("dept_id >", value, "deptId");
        return (Criteria) this;
    }
    /**
    * -deptId大于等于
    */
    public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("dept_id >=", value, "deptId");
        return (Criteria) this;
    }
    /**
    * -deptId小于
    */
    public Criteria andDeptIdLessThan(Integer value) {
        addCriterion("dept_id <", value, "deptId");
        return (Criteria) this;
    }
    /**
    * -deptId小于等于
    */
    public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
        addCriterion("dept_id <=", value, "deptId");
        return (Criteria) this;
    }
    /**
    * -deptId在集合中
    */
    public Criteria andDeptIdIn(List<Integer> values) {
        addCriterion("dept_id in", values, "deptId");
        return (Criteria) this;
    }
    /**
     * -deptId不在集合中
    */
    public Criteria andDeptIdNotIn(List<Integer> values) {
        addCriterion("dept_id not in", values, "deptId");
        return (Criteria) this;
    }
    /**
    * -deptId在区间
    */
    public Criteria andDeptIdBetween(Integer value1, Integer value2) {
        addCriterion("dept_id between", value1, value2, "deptId");
        return (Criteria) this;
    }
    /**
    * -deptId不在区间
    */
    public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
        addCriterion("dept_id not between", value1, value2, "deptId");
        return (Criteria) this;
    }
    /**
     * -归属部门是null
     */
		public Criteria andDeptIsNull() {
        addCriterion("dept is null");
        return (Criteria) this;
    }
    /**
    * -归属部门不是null
    */
    public Criteria andDeptIsNotNull() {
        addCriterion("dept is not null");
        return (Criteria) this;
    }
    /**
    * -归属部门等于
    */
    public Criteria andDeptEqualTo(String value) {
        addCriterion("dept =", value, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门不等于
    */
    public Criteria andDeptNotEqualTo(String value) {
        addCriterion("dept <>", value, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门大于
    */
    public Criteria andDeptGreaterThan(String value) {
        addCriterion("dept >", value, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门大于等于
    */
    public Criteria andDeptGreaterThanOrEqualTo(String value) {
        addCriterion("dept >=", value, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门小于
    */
    public Criteria andDeptLessThan(String value) {
        addCriterion("dept <", value, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门小于等于
    */
    public Criteria andDeptLessThanOrEqualTo(String value) {
        addCriterion("dept <=", value, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门符合
     */
    public Criteria andDeptLike(String value) {
        addCriterion("dept like", value, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门不符合
    */
    public Criteria andDeptNotLike(String value) {
        addCriterion("dept not like", value, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门在集合中
    */
    public Criteria andDeptIn(List<String> values) {
        addCriterion("dept in", values, "dept");
        return (Criteria) this;
    }
    /**
     * -归属部门不在集合中
    */
    public Criteria andDeptNotIn(List<String> values) {
        addCriterion("dept not in", values, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门在区间
    */
    public Criteria andDeptBetween(String value1, String value2) {
        addCriterion("dept between", value1, value2, "dept");
        return (Criteria) this;
    }
    /**
    * -归属部门不在区间
    */
    public Criteria andDeptNotBetween(String value1, String value2) {
        addCriterion("dept not between", value1, value2, "dept");
        return (Criteria) this;
    }
    /**
     * -状态 1:启用 2停用是null
     */
		public Criteria andStatusIsNull() {
        addCriterion("status is null");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用不是null
    */
    public Criteria andStatusIsNotNull() {
        addCriterion("status is not null");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用等于
    */
    public Criteria andStatusEqualTo(Integer value) {
        addCriterion("status =", value, "status");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用不等于
    */
    public Criteria andStatusNotEqualTo(Integer value) {
        addCriterion("status <>", value, "status");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用大于
    */
    public Criteria andStatusGreaterThan(Integer value) {
        addCriterion("status >", value, "status");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用大于等于
    */
    public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
        addCriterion("status >=", value, "status");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用小于
    */
    public Criteria andStatusLessThan(Integer value) {
        addCriterion("status <", value, "status");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用小于等于
    */
    public Criteria andStatusLessThanOrEqualTo(Integer value) {
        addCriterion("status <=", value, "status");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用在集合中
    */
    public Criteria andStatusIn(List<Integer> values) {
        addCriterion("status in", values, "status");
        return (Criteria) this;
    }
    /**
     * -状态 1:启用 2停用不在集合中
    */
    public Criteria andStatusNotIn(List<Integer> values) {
        addCriterion("status not in", values, "status");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用在区间
    */
    public Criteria andStatusBetween(Integer value1, Integer value2) {
        addCriterion("status between", value1, value2, "status");
        return (Criteria) this;
    }
    /**
    * -状态 1:启用 2停用不在区间
    */
    public Criteria andStatusNotBetween(Integer value1, Integer value2) {
        addCriterion("status not between", value1, value2, "status");
        return (Criteria) this;
    }
    /**
     * -创建人姓名是null
     */
		public Criteria andCreatorIsNull() {
        addCriterion("creator is null");
        return (Criteria) this;
    }
    /**
    * -创建人姓名不是null
    */
    public Criteria andCreatorIsNotNull() {
        addCriterion("creator is not null");
        return (Criteria) this;
    }
    /**
    * -创建人姓名等于
    */
    public Criteria andCreatorEqualTo(String value) {
        addCriterion("creator =", value, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名不等于
    */
    public Criteria andCreatorNotEqualTo(String value) {
        addCriterion("creator <>", value, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名大于
    */
    public Criteria andCreatorGreaterThan(String value) {
        addCriterion("creator >", value, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名大于等于
    */
    public Criteria andCreatorGreaterThanOrEqualTo(String value) {
        addCriterion("creator >=", value, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名小于
    */
    public Criteria andCreatorLessThan(String value) {
        addCriterion("creator <", value, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名小于等于
    */
    public Criteria andCreatorLessThanOrEqualTo(String value) {
        addCriterion("creator <=", value, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名符合
     */
    public Criteria andCreatorLike(String value) {
        addCriterion("creator like", value, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名不符合
    */
    public Criteria andCreatorNotLike(String value) {
        addCriterion("creator not like", value, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名在集合中
    */
    public Criteria andCreatorIn(List<String> values) {
        addCriterion("creator in", values, "creator");
        return (Criteria) this;
    }
    /**
     * -创建人姓名不在集合中
    */
    public Criteria andCreatorNotIn(List<String> values) {
        addCriterion("creator not in", values, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名在区间
    */
    public Criteria andCreatorBetween(String value1, String value2) {
        addCriterion("creator between", value1, value2, "creator");
        return (Criteria) this;
    }
    /**
    * -创建人姓名不在区间
    */
    public Criteria andCreatorNotBetween(String value1, String value2) {
        addCriterion("creator not between", value1, value2, "creator");
        return (Criteria) this;
    }
    /**
     * -创建时间是null
     */
		public Criteria andCreatedIsNull() {
        addCriterion("created is null");
        return (Criteria) this;
    }
    /**
    * -创建时间不是null
    */
    public Criteria andCreatedIsNotNull() {
        addCriterion("created is not null");
        return (Criteria) this;
    }
    /**
    * -创建时间等于
    */
    public Criteria andCreatedEqualTo(Date value) {
        addCriterion("created =", value, "created");
        return (Criteria) this;
    }
    /**
    * -创建时间不等于
    */
    public Criteria andCreatedNotEqualTo(Date value) {
        addCriterion("created <>", value, "created");
        return (Criteria) this;
    }
    /**
    * -创建时间大于
    */
    public Criteria andCreatedGreaterThan(Date value) {
        addCriterion("created >", value, "created");
        return (Criteria) this;
    }
    /**
    * -创建时间大于等于
    */
    public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
        addCriterion("created >=", value, "created");
        return (Criteria) this;
    }
    /**
    * -创建时间小于
    */
    public Criteria andCreatedLessThan(Date value) {
        addCriterion("created <", value, "created");
        return (Criteria) this;
    }
    /**
    * -创建时间小于等于
    */
    public Criteria andCreatedLessThanOrEqualTo(Date value) {
        addCriterion("created <=", value, "created");
        return (Criteria) this;
    }
    /**
    * -创建时间在集合中
    */
    public Criteria andCreatedIn(List<Date> values) {
        addCriterion("created in", values, "created");
        return (Criteria) this;
    }
    /**
     * -创建时间不在集合中
    */
    public Criteria andCreatedNotIn(List<Date> values) {
        addCriterion("created not in", values, "created");
        return (Criteria) this;
    }
    /**
    * -创建时间在区间
    */
    public Criteria andCreatedBetween(Date value1, Date value2) {
        addCriterion("created between", value1, value2, "created");
        return (Criteria) this;
    }
    /**
    * -创建时间不在区间
    */
    public Criteria andCreatedNotBetween(Date value1, Date value2) {
        addCriterion("created not between", value1, value2, "created");
        return (Criteria) this;
    }

  }

  public static class Criteria extends GeneratedCriteria {

      protected Criteria() {
          super();
      }
  }

  public static class Criterion {
    private String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    private String typeHandler;

    public String getCondition() {
        return condition;
    }

    public Object getValue() {
        return value;
    }

    public Object getSecondValue() {
        return secondValue;
    }

    public boolean isNoValue() {
        return noValue;
    }

    public boolean isSingleValue() {
        return singleValue;
    }

    public boolean isBetweenValue() {
        return betweenValue;
    }

    public boolean isListValue() {
        return listValue;
    }

    public String getTypeHandler() {
        return typeHandler;
    }

    protected Criterion(String condition) {
        super();
        this.condition = condition;
        this.typeHandler = null;
        this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler) {
        super();
        this.condition = condition;
        this.value = value;
        this.typeHandler = typeHandler;
        if (value instanceof List<?>) {
            this.listValue = true;
        } else {
            this.singleValue = true;
        }
    }

    protected Criterion(String condition, Object value) {
        this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
        super();
        this.condition = condition;
        this.value = value;
        this.secondValue = secondValue;
        this.typeHandler = typeHandler;
        this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
        this(condition, value, secondValue, null);
    }
  }

}

package com.px.sib.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AllocateTransferExample {

  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public AllocateTransferExample() {
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
     * -id是null
     */
		public Criteria andIdIsNull() {
        addCriterion("id is null");
        return (Criteria) this;
    }
    /**
    * -id不是null
    */
    public Criteria andIdIsNotNull() {
        addCriterion("id is not null");
        return (Criteria) this;
    }
    /**
    * -id等于
    */
    public Criteria andIdEqualTo(Integer value) {
        addCriterion("id =", value, "id");
        return (Criteria) this;
    }
    /**
    * -id不等于
    */
    public Criteria andIdNotEqualTo(Integer value) {
        addCriterion("id <>", value, "id");
        return (Criteria) this;
    }
    /**
    * -id大于
    */
    public Criteria andIdGreaterThan(Integer value) {
        addCriterion("id >", value, "id");
        return (Criteria) this;
    }
    /**
    * -id大于等于
    */
    public Criteria andIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("id >=", value, "id");
        return (Criteria) this;
    }
    /**
    * -id小于
    */
    public Criteria andIdLessThan(Integer value) {
        addCriterion("id <", value, "id");
        return (Criteria) this;
    }
    /**
    * -id小于等于
    */
    public Criteria andIdLessThanOrEqualTo(Integer value) {
        addCriterion("id <=", value, "id");
        return (Criteria) this;
    }
    /**
    * -id在集合中
    */
    public Criteria andIdIn(List<Integer> values) {
        addCriterion("id in", values, "id");
        return (Criteria) this;
    }
    /**
     * -id不在集合中
    */
    public Criteria andIdNotIn(List<Integer> values) {
        addCriterion("id not in", values, "id");
        return (Criteria) this;
    }
    /**
    * -id在区间
    */
    public Criteria andIdBetween(Integer value1, Integer value2) {
        addCriterion("id between", value1, value2, "id");
        return (Criteria) this;
    }
    /**
    * -id不在区间
    */
    public Criteria andIdNotBetween(Integer value1, Integer value2) {
        addCriterion("id not between", value1, value2, "id");
        return (Criteria) this;
    }
    /**
     * -调出子仓库ID是null
     */
		public Criteria andWareFromIdIsNull() {
        addCriterion("ware_from_id is null");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID不是null
    */
    public Criteria andWareFromIdIsNotNull() {
        addCriterion("ware_from_id is not null");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID等于
    */
    public Criteria andWareFromIdEqualTo(Integer value) {
        addCriterion("ware_from_id =", value, "wareFromId");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID不等于
    */
    public Criteria andWareFromIdNotEqualTo(Integer value) {
        addCriterion("ware_from_id <>", value, "wareFromId");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID大于
    */
    public Criteria andWareFromIdGreaterThan(Integer value) {
        addCriterion("ware_from_id >", value, "wareFromId");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID大于等于
    */
    public Criteria andWareFromIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("ware_from_id >=", value, "wareFromId");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID小于
    */
    public Criteria andWareFromIdLessThan(Integer value) {
        addCriterion("ware_from_id <", value, "wareFromId");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID小于等于
    */
    public Criteria andWareFromIdLessThanOrEqualTo(Integer value) {
        addCriterion("ware_from_id <=", value, "wareFromId");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID在集合中
    */
    public Criteria andWareFromIdIn(List<Integer> values) {
        addCriterion("ware_from_id in", values, "wareFromId");
        return (Criteria) this;
    }
    /**
     * -调出子仓库ID不在集合中
    */
    public Criteria andWareFromIdNotIn(List<Integer> values) {
        addCriterion("ware_from_id not in", values, "wareFromId");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID在区间
    */
    public Criteria andWareFromIdBetween(Integer value1, Integer value2) {
        addCriterion("ware_from_id between", value1, value2, "wareFromId");
        return (Criteria) this;
    }
    /**
    * -调出子仓库ID不在区间
    */
    public Criteria andWareFromIdNotBetween(Integer value1, Integer value2) {
        addCriterion("ware_from_id not between", value1, value2, "wareFromId");
        return (Criteria) this;
    }
    /**
     * -wareFrom是null
     */
		public Criteria andWareFromIsNull() {
        addCriterion("ware_from is null");
        return (Criteria) this;
    }
    /**
    * -wareFrom不是null
    */
    public Criteria andWareFromIsNotNull() {
        addCriterion("ware_from is not null");
        return (Criteria) this;
    }
    /**
    * -wareFrom等于
    */
    public Criteria andWareFromEqualTo(String value) {
        addCriterion("ware_from =", value, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom不等于
    */
    public Criteria andWareFromNotEqualTo(String value) {
        addCriterion("ware_from <>", value, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom大于
    */
    public Criteria andWareFromGreaterThan(String value) {
        addCriterion("ware_from >", value, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom大于等于
    */
    public Criteria andWareFromGreaterThanOrEqualTo(String value) {
        addCriterion("ware_from >=", value, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom小于
    */
    public Criteria andWareFromLessThan(String value) {
        addCriterion("ware_from <", value, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom小于等于
    */
    public Criteria andWareFromLessThanOrEqualTo(String value) {
        addCriterion("ware_from <=", value, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom符合
     */
    public Criteria andWareFromLike(String value) {
        addCriterion("ware_from like", value, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom不符合
    */
    public Criteria andWareFromNotLike(String value) {
        addCriterion("ware_from not like", value, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom在集合中
    */
    public Criteria andWareFromIn(List<String> values) {
        addCriterion("ware_from in", values, "wareFrom");
        return (Criteria) this;
    }
    /**
     * -wareFrom不在集合中
    */
    public Criteria andWareFromNotIn(List<String> values) {
        addCriterion("ware_from not in", values, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom在区间
    */
    public Criteria andWareFromBetween(String value1, String value2) {
        addCriterion("ware_from between", value1, value2, "wareFrom");
        return (Criteria) this;
    }
    /**
    * -wareFrom不在区间
    */
    public Criteria andWareFromNotBetween(String value1, String value2) {
        addCriterion("ware_from not between", value1, value2, "wareFrom");
        return (Criteria) this;
    }
    /**
     * -拨入子仓库ID是null
     */
		public Criteria andWareToIdIsNull() {
        addCriterion("ware_to_id is null");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID不是null
    */
    public Criteria andWareToIdIsNotNull() {
        addCriterion("ware_to_id is not null");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID等于
    */
    public Criteria andWareToIdEqualTo(Integer value) {
        addCriterion("ware_to_id =", value, "wareToId");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID不等于
    */
    public Criteria andWareToIdNotEqualTo(Integer value) {
        addCriterion("ware_to_id <>", value, "wareToId");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID大于
    */
    public Criteria andWareToIdGreaterThan(Integer value) {
        addCriterion("ware_to_id >", value, "wareToId");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID大于等于
    */
    public Criteria andWareToIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("ware_to_id >=", value, "wareToId");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID小于
    */
    public Criteria andWareToIdLessThan(Integer value) {
        addCriterion("ware_to_id <", value, "wareToId");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID小于等于
    */
    public Criteria andWareToIdLessThanOrEqualTo(Integer value) {
        addCriterion("ware_to_id <=", value, "wareToId");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID在集合中
    */
    public Criteria andWareToIdIn(List<Integer> values) {
        addCriterion("ware_to_id in", values, "wareToId");
        return (Criteria) this;
    }
    /**
     * -拨入子仓库ID不在集合中
    */
    public Criteria andWareToIdNotIn(List<Integer> values) {
        addCriterion("ware_to_id not in", values, "wareToId");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID在区间
    */
    public Criteria andWareToIdBetween(Integer value1, Integer value2) {
        addCriterion("ware_to_id between", value1, value2, "wareToId");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库ID不在区间
    */
    public Criteria andWareToIdNotBetween(Integer value1, Integer value2) {
        addCriterion("ware_to_id not between", value1, value2, "wareToId");
        return (Criteria) this;
    }
    /**
     * -拨入子仓库名称是null
     */
		public Criteria andWareToIsNull() {
        addCriterion("ware_to is null");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称不是null
    */
    public Criteria andWareToIsNotNull() {
        addCriterion("ware_to is not null");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称等于
    */
    public Criteria andWareToEqualTo(String value) {
        addCriterion("ware_to =", value, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称不等于
    */
    public Criteria andWareToNotEqualTo(String value) {
        addCriterion("ware_to <>", value, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称大于
    */
    public Criteria andWareToGreaterThan(String value) {
        addCriterion("ware_to >", value, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称大于等于
    */
    public Criteria andWareToGreaterThanOrEqualTo(String value) {
        addCriterion("ware_to >=", value, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称小于
    */
    public Criteria andWareToLessThan(String value) {
        addCriterion("ware_to <", value, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称小于等于
    */
    public Criteria andWareToLessThanOrEqualTo(String value) {
        addCriterion("ware_to <=", value, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称符合
     */
    public Criteria andWareToLike(String value) {
        addCriterion("ware_to like", value, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称不符合
    */
    public Criteria andWareToNotLike(String value) {
        addCriterion("ware_to not like", value, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称在集合中
    */
    public Criteria andWareToIn(List<String> values) {
        addCriterion("ware_to in", values, "wareTo");
        return (Criteria) this;
    }
    /**
     * -拨入子仓库名称不在集合中
    */
    public Criteria andWareToNotIn(List<String> values) {
        addCriterion("ware_to not in", values, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称在区间
    */
    public Criteria andWareToBetween(String value1, String value2) {
        addCriterion("ware_to between", value1, value2, "wareTo");
        return (Criteria) this;
    }
    /**
    * -拨入子仓库名称不在区间
    */
    public Criteria andWareToNotBetween(String value1, String value2) {
        addCriterion("ware_to not between", value1, value2, "wareTo");
        return (Criteria) this;
    }
    /**
     * -物料大类别ID是null
     */
		public Criteria andCategoryIdIsNull() {
        addCriterion("category_id is null");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID不是null
    */
    public Criteria andCategoryIdIsNotNull() {
        addCriterion("category_id is not null");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID等于
    */
    public Criteria andCategoryIdEqualTo(Integer value) {
        addCriterion("category_id =", value, "categoryId");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID不等于
    */
    public Criteria andCategoryIdNotEqualTo(Integer value) {
        addCriterion("category_id <>", value, "categoryId");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID大于
    */
    public Criteria andCategoryIdGreaterThan(Integer value) {
        addCriterion("category_id >", value, "categoryId");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID大于等于
    */
    public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("category_id >=", value, "categoryId");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID小于
    */
    public Criteria andCategoryIdLessThan(Integer value) {
        addCriterion("category_id <", value, "categoryId");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID小于等于
    */
    public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
        addCriterion("category_id <=", value, "categoryId");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID在集合中
    */
    public Criteria andCategoryIdIn(List<Integer> values) {
        addCriterion("category_id in", values, "categoryId");
        return (Criteria) this;
    }
    /**
     * -物料大类别ID不在集合中
    */
    public Criteria andCategoryIdNotIn(List<Integer> values) {
        addCriterion("category_id not in", values, "categoryId");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID在区间
    */
    public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
        addCriterion("category_id between", value1, value2, "categoryId");
        return (Criteria) this;
    }
    /**
    * -物料大类别ID不在区间
    */
    public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
        addCriterion("category_id not between", value1, value2, "categoryId");
        return (Criteria) this;
    }
    /**
     * -物料大类别是null
     */
		public Criteria andCategoryIsNull() {
        addCriterion("category is null");
        return (Criteria) this;
    }
    /**
    * -物料大类别不是null
    */
    public Criteria andCategoryIsNotNull() {
        addCriterion("category is not null");
        return (Criteria) this;
    }
    /**
    * -物料大类别等于
    */
    public Criteria andCategoryEqualTo(String value) {
        addCriterion("category =", value, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别不等于
    */
    public Criteria andCategoryNotEqualTo(String value) {
        addCriterion("category <>", value, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别大于
    */
    public Criteria andCategoryGreaterThan(String value) {
        addCriterion("category >", value, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别大于等于
    */
    public Criteria andCategoryGreaterThanOrEqualTo(String value) {
        addCriterion("category >=", value, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别小于
    */
    public Criteria andCategoryLessThan(String value) {
        addCriterion("category <", value, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别小于等于
    */
    public Criteria andCategoryLessThanOrEqualTo(String value) {
        addCriterion("category <=", value, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别符合
     */
    public Criteria andCategoryLike(String value) {
        addCriterion("category like", value, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别不符合
    */
    public Criteria andCategoryNotLike(String value) {
        addCriterion("category not like", value, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别在集合中
    */
    public Criteria andCategoryIn(List<String> values) {
        addCriterion("category in", values, "category");
        return (Criteria) this;
    }
    /**
     * -物料大类别不在集合中
    */
    public Criteria andCategoryNotIn(List<String> values) {
        addCriterion("category not in", values, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别在区间
    */
    public Criteria andCategoryBetween(String value1, String value2) {
        addCriterion("category between", value1, value2, "category");
        return (Criteria) this;
    }
    /**
    * -物料大类别不在区间
    */
    public Criteria andCategoryNotBetween(String value1, String value2) {
        addCriterion("category not between", value1, value2, "category");
        return (Criteria) this;
    }
    /**
     * -原材料物料ID是null
     */
		public Criteria andMatIdIsNull() {
        addCriterion("mat_id is null");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID不是null
    */
    public Criteria andMatIdIsNotNull() {
        addCriterion("mat_id is not null");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID等于
    */
    public Criteria andMatIdEqualTo(Integer value) {
        addCriterion("mat_id =", value, "matId");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID不等于
    */
    public Criteria andMatIdNotEqualTo(Integer value) {
        addCriterion("mat_id <>", value, "matId");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID大于
    */
    public Criteria andMatIdGreaterThan(Integer value) {
        addCriterion("mat_id >", value, "matId");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID大于等于
    */
    public Criteria andMatIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("mat_id >=", value, "matId");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID小于
    */
    public Criteria andMatIdLessThan(Integer value) {
        addCriterion("mat_id <", value, "matId");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID小于等于
    */
    public Criteria andMatIdLessThanOrEqualTo(Integer value) {
        addCriterion("mat_id <=", value, "matId");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID在集合中
    */
    public Criteria andMatIdIn(List<Integer> values) {
        addCriterion("mat_id in", values, "matId");
        return (Criteria) this;
    }
    /**
     * -原材料物料ID不在集合中
    */
    public Criteria andMatIdNotIn(List<Integer> values) {
        addCriterion("mat_id not in", values, "matId");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID在区间
    */
    public Criteria andMatIdBetween(Integer value1, Integer value2) {
        addCriterion("mat_id between", value1, value2, "matId");
        return (Criteria) this;
    }
    /**
    * -原材料物料ID不在区间
    */
    public Criteria andMatIdNotBetween(Integer value1, Integer value2) {
        addCriterion("mat_id not between", value1, value2, "matId");
        return (Criteria) this;
    }
    /**
     * -mat是null
     */
		public Criteria andMatIsNull() {
        addCriterion("mat is null");
        return (Criteria) this;
    }
    /**
    * -mat不是null
    */
    public Criteria andMatIsNotNull() {
        addCriterion("mat is not null");
        return (Criteria) this;
    }
    /**
    * -mat等于
    */
    public Criteria andMatEqualTo(String value) {
        addCriterion("mat =", value, "mat");
        return (Criteria) this;
    }
    /**
    * -mat不等于
    */
    public Criteria andMatNotEqualTo(String value) {
        addCriterion("mat <>", value, "mat");
        return (Criteria) this;
    }
    /**
    * -mat大于
    */
    public Criteria andMatGreaterThan(String value) {
        addCriterion("mat >", value, "mat");
        return (Criteria) this;
    }
    /**
    * -mat大于等于
    */
    public Criteria andMatGreaterThanOrEqualTo(String value) {
        addCriterion("mat >=", value, "mat");
        return (Criteria) this;
    }
    /**
    * -mat小于
    */
    public Criteria andMatLessThan(String value) {
        addCriterion("mat <", value, "mat");
        return (Criteria) this;
    }
    /**
    * -mat小于等于
    */
    public Criteria andMatLessThanOrEqualTo(String value) {
        addCriterion("mat <=", value, "mat");
        return (Criteria) this;
    }
    /**
    * -mat符合
     */
    public Criteria andMatLike(String value) {
        addCriterion("mat like", value, "mat");
        return (Criteria) this;
    }
    /**
    * -mat不符合
    */
    public Criteria andMatNotLike(String value) {
        addCriterion("mat not like", value, "mat");
        return (Criteria) this;
    }
    /**
    * -mat在集合中
    */
    public Criteria andMatIn(List<String> values) {
        addCriterion("mat in", values, "mat");
        return (Criteria) this;
    }
    /**
     * -mat不在集合中
    */
    public Criteria andMatNotIn(List<String> values) {
        addCriterion("mat not in", values, "mat");
        return (Criteria) this;
    }
    /**
    * -mat在区间
    */
    public Criteria andMatBetween(String value1, String value2) {
        addCriterion("mat between", value1, value2, "mat");
        return (Criteria) this;
    }
    /**
    * -mat不在区间
    */
    public Criteria andMatNotBetween(String value1, String value2) {
        addCriterion("mat not between", value1, value2, "mat");
        return (Criteria) this;
    }
    /**
     * -产成品物料ID是null
     */
		public Criteria andPrdMatIdIsNull() {
        addCriterion("prd_mat_id is null");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID不是null
    */
    public Criteria andPrdMatIdIsNotNull() {
        addCriterion("prd_mat_id is not null");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID等于
    */
    public Criteria andPrdMatIdEqualTo(Integer value) {
        addCriterion("prd_mat_id =", value, "prdMatId");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID不等于
    */
    public Criteria andPrdMatIdNotEqualTo(Integer value) {
        addCriterion("prd_mat_id <>", value, "prdMatId");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID大于
    */
    public Criteria andPrdMatIdGreaterThan(Integer value) {
        addCriterion("prd_mat_id >", value, "prdMatId");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID大于等于
    */
    public Criteria andPrdMatIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("prd_mat_id >=", value, "prdMatId");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID小于
    */
    public Criteria andPrdMatIdLessThan(Integer value) {
        addCriterion("prd_mat_id <", value, "prdMatId");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID小于等于
    */
    public Criteria andPrdMatIdLessThanOrEqualTo(Integer value) {
        addCriterion("prd_mat_id <=", value, "prdMatId");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID在集合中
    */
    public Criteria andPrdMatIdIn(List<Integer> values) {
        addCriterion("prd_mat_id in", values, "prdMatId");
        return (Criteria) this;
    }
    /**
     * -产成品物料ID不在集合中
    */
    public Criteria andPrdMatIdNotIn(List<Integer> values) {
        addCriterion("prd_mat_id not in", values, "prdMatId");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID在区间
    */
    public Criteria andPrdMatIdBetween(Integer value1, Integer value2) {
        addCriterion("prd_mat_id between", value1, value2, "prdMatId");
        return (Criteria) this;
    }
    /**
    * -产成品物料ID不在区间
    */
    public Criteria andPrdMatIdNotBetween(Integer value1, Integer value2) {
        addCriterion("prd_mat_id not between", value1, value2, "prdMatId");
        return (Criteria) this;
    }
    /**
     * -产成品物料名称是null
     */
		public Criteria andPrdMatIsNull() {
        addCriterion("prd_mat is null");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称不是null
    */
    public Criteria andPrdMatIsNotNull() {
        addCriterion("prd_mat is not null");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称等于
    */
    public Criteria andPrdMatEqualTo(String value) {
        addCriterion("prd_mat =", value, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称不等于
    */
    public Criteria andPrdMatNotEqualTo(String value) {
        addCriterion("prd_mat <>", value, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称大于
    */
    public Criteria andPrdMatGreaterThan(String value) {
        addCriterion("prd_mat >", value, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称大于等于
    */
    public Criteria andPrdMatGreaterThanOrEqualTo(String value) {
        addCriterion("prd_mat >=", value, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称小于
    */
    public Criteria andPrdMatLessThan(String value) {
        addCriterion("prd_mat <", value, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称小于等于
    */
    public Criteria andPrdMatLessThanOrEqualTo(String value) {
        addCriterion("prd_mat <=", value, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称符合
     */
    public Criteria andPrdMatLike(String value) {
        addCriterion("prd_mat like", value, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称不符合
    */
    public Criteria andPrdMatNotLike(String value) {
        addCriterion("prd_mat not like", value, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称在集合中
    */
    public Criteria andPrdMatIn(List<String> values) {
        addCriterion("prd_mat in", values, "prdMat");
        return (Criteria) this;
    }
    /**
     * -产成品物料名称不在集合中
    */
    public Criteria andPrdMatNotIn(List<String> values) {
        addCriterion("prd_mat not in", values, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称在区间
    */
    public Criteria andPrdMatBetween(String value1, String value2) {
        addCriterion("prd_mat between", value1, value2, "prdMat");
        return (Criteria) this;
    }
    /**
    * -产成品物料名称不在区间
    */
    public Criteria andPrdMatNotBetween(String value1, String value2) {
        addCriterion("prd_mat not between", value1, value2, "prdMat");
        return (Criteria) this;
    }
    /**
     * -物料规格是null
     */
		public Criteria andSpecIsNull() {
        addCriterion("spec is null");
        return (Criteria) this;
    }
    /**
    * -物料规格不是null
    */
    public Criteria andSpecIsNotNull() {
        addCriterion("spec is not null");
        return (Criteria) this;
    }
    /**
    * -物料规格等于
    */
    public Criteria andSpecEqualTo(String value) {
        addCriterion("spec =", value, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格不等于
    */
    public Criteria andSpecNotEqualTo(String value) {
        addCriterion("spec <>", value, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格大于
    */
    public Criteria andSpecGreaterThan(String value) {
        addCriterion("spec >", value, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格大于等于
    */
    public Criteria andSpecGreaterThanOrEqualTo(String value) {
        addCriterion("spec >=", value, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格小于
    */
    public Criteria andSpecLessThan(String value) {
        addCriterion("spec <", value, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格小于等于
    */
    public Criteria andSpecLessThanOrEqualTo(String value) {
        addCriterion("spec <=", value, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格符合
     */
    public Criteria andSpecLike(String value) {
        addCriterion("spec like", value, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格不符合
    */
    public Criteria andSpecNotLike(String value) {
        addCriterion("spec not like", value, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格在集合中
    */
    public Criteria andSpecIn(List<String> values) {
        addCriterion("spec in", values, "spec");
        return (Criteria) this;
    }
    /**
     * -物料规格不在集合中
    */
    public Criteria andSpecNotIn(List<String> values) {
        addCriterion("spec not in", values, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格在区间
    */
    public Criteria andSpecBetween(String value1, String value2) {
        addCriterion("spec between", value1, value2, "spec");
        return (Criteria) this;
    }
    /**
    * -物料规格不在区间
    */
    public Criteria andSpecNotBetween(String value1, String value2) {
        addCriterion("spec not between", value1, value2, "spec");
        return (Criteria) this;
    }
    /**
     * -unit是null
     */
		public Criteria andUnitIsNull() {
        addCriterion("unit is null");
        return (Criteria) this;
    }
    /**
    * -unit不是null
    */
    public Criteria andUnitIsNotNull() {
        addCriterion("unit is not null");
        return (Criteria) this;
    }
    /**
    * -unit等于
    */
    public Criteria andUnitEqualTo(String value) {
        addCriterion("unit =", value, "unit");
        return (Criteria) this;
    }
    /**
    * -unit不等于
    */
    public Criteria andUnitNotEqualTo(String value) {
        addCriterion("unit <>", value, "unit");
        return (Criteria) this;
    }
    /**
    * -unit大于
    */
    public Criteria andUnitGreaterThan(String value) {
        addCriterion("unit >", value, "unit");
        return (Criteria) this;
    }
    /**
    * -unit大于等于
    */
    public Criteria andUnitGreaterThanOrEqualTo(String value) {
        addCriterion("unit >=", value, "unit");
        return (Criteria) this;
    }
    /**
    * -unit小于
    */
    public Criteria andUnitLessThan(String value) {
        addCriterion("unit <", value, "unit");
        return (Criteria) this;
    }
    /**
    * -unit小于等于
    */
    public Criteria andUnitLessThanOrEqualTo(String value) {
        addCriterion("unit <=", value, "unit");
        return (Criteria) this;
    }
    /**
    * -unit符合
     */
    public Criteria andUnitLike(String value) {
        addCriterion("unit like", value, "unit");
        return (Criteria) this;
    }
    /**
    * -unit不符合
    */
    public Criteria andUnitNotLike(String value) {
        addCriterion("unit not like", value, "unit");
        return (Criteria) this;
    }
    /**
    * -unit在集合中
    */
    public Criteria andUnitIn(List<String> values) {
        addCriterion("unit in", values, "unit");
        return (Criteria) this;
    }
    /**
     * -unit不在集合中
    */
    public Criteria andUnitNotIn(List<String> values) {
        addCriterion("unit not in", values, "unit");
        return (Criteria) this;
    }
    /**
    * -unit在区间
    */
    public Criteria andUnitBetween(String value1, String value2) {
        addCriterion("unit between", value1, value2, "unit");
        return (Criteria) this;
    }
    /**
    * -unit不在区间
    */
    public Criteria andUnitNotBetween(String value1, String value2) {
        addCriterion("unit not between", value1, value2, "unit");
        return (Criteria) this;
    }
    /**
     * -perWeight是null
     */
		public Criteria andPerWeightIsNull() {
        addCriterion("per_weight is null");
        return (Criteria) this;
    }
    /**
    * -perWeight不是null
    */
    public Criteria andPerWeightIsNotNull() {
        addCriterion("per_weight is not null");
        return (Criteria) this;
    }
    /**
    * -perWeight等于
    */
    public Criteria andPerWeightEqualTo(Double value) {
        addCriterion("per_weight =", value, "perWeight");
        return (Criteria) this;
    }
    /**
    * -perWeight不等于
    */
    public Criteria andPerWeightNotEqualTo(Double value) {
        addCriterion("per_weight <>", value, "perWeight");
        return (Criteria) this;
    }
    /**
    * -perWeight大于
    */
    public Criteria andPerWeightGreaterThan(Double value) {
        addCriterion("per_weight >", value, "perWeight");
        return (Criteria) this;
    }
    /**
    * -perWeight大于等于
    */
    public Criteria andPerWeightGreaterThanOrEqualTo(Double value) {
        addCriterion("per_weight >=", value, "perWeight");
        return (Criteria) this;
    }
    /**
    * -perWeight小于
    */
    public Criteria andPerWeightLessThan(Double value) {
        addCriterion("per_weight <", value, "perWeight");
        return (Criteria) this;
    }
    /**
    * -perWeight小于等于
    */
    public Criteria andPerWeightLessThanOrEqualTo(Double value) {
        addCriterion("per_weight <=", value, "perWeight");
        return (Criteria) this;
    }
    /**
    * -perWeight在集合中
    */
    public Criteria andPerWeightIn(List<Double> values) {
        addCriterion("per_weight in", values, "perWeight");
        return (Criteria) this;
    }
    /**
     * -perWeight不在集合中
    */
    public Criteria andPerWeightNotIn(List<Double> values) {
        addCriterion("per_weight not in", values, "perWeight");
        return (Criteria) this;
    }
    /**
    * -perWeight在区间
    */
    public Criteria andPerWeightBetween(Double value1, Double value2) {
        addCriterion("per_weight between", value1, value2, "perWeight");
        return (Criteria) this;
    }
    /**
    * -perWeight不在区间
    */
    public Criteria andPerWeightNotBetween(Double value1, Double value2) {
        addCriterion("per_weight not between", value1, value2, "perWeight");
        return (Criteria) this;
    }
    /**
     * -出库件数是null
     */
		public Criteria andQtyIsNull() {
        addCriterion("qty is null");
        return (Criteria) this;
    }
    /**
    * -出库件数不是null
    */
    public Criteria andQtyIsNotNull() {
        addCriterion("qty is not null");
        return (Criteria) this;
    }
    /**
    * -出库件数等于
    */
    public Criteria andQtyEqualTo(Integer value) {
        addCriterion("qty =", value, "qty");
        return (Criteria) this;
    }
    /**
    * -出库件数不等于
    */
    public Criteria andQtyNotEqualTo(Integer value) {
        addCriterion("qty <>", value, "qty");
        return (Criteria) this;
    }
    /**
    * -出库件数大于
    */
    public Criteria andQtyGreaterThan(Integer value) {
        addCriterion("qty >", value, "qty");
        return (Criteria) this;
    }
    /**
    * -出库件数大于等于
    */
    public Criteria andQtyGreaterThanOrEqualTo(Integer value) {
        addCriterion("qty >=", value, "qty");
        return (Criteria) this;
    }
    /**
    * -出库件数小于
    */
    public Criteria andQtyLessThan(Integer value) {
        addCriterion("qty <", value, "qty");
        return (Criteria) this;
    }
    /**
    * -出库件数小于等于
    */
    public Criteria andQtyLessThanOrEqualTo(Integer value) {
        addCriterion("qty <=", value, "qty");
        return (Criteria) this;
    }
    /**
    * -出库件数在集合中
    */
    public Criteria andQtyIn(List<Integer> values) {
        addCriterion("qty in", values, "qty");
        return (Criteria) this;
    }
    /**
     * -出库件数不在集合中
    */
    public Criteria andQtyNotIn(List<Integer> values) {
        addCriterion("qty not in", values, "qty");
        return (Criteria) this;
    }
    /**
    * -出库件数在区间
    */
    public Criteria andQtyBetween(Integer value1, Integer value2) {
        addCriterion("qty between", value1, value2, "qty");
        return (Criteria) this;
    }
    /**
    * -出库件数不在区间
    */
    public Criteria andQtyNotBetween(Integer value1, Integer value2) {
        addCriterion("qty not between", value1, value2, "qty");
        return (Criteria) this;
    }
    /**
     * -出库重量(单枚重量*领入件数)是null
     */
		public Criteria andTotalWeightIsNull() {
        addCriterion("total_weight is null");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)不是null
    */
    public Criteria andTotalWeightIsNotNull() {
        addCriterion("total_weight is not null");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)等于
    */
    public Criteria andTotalWeightEqualTo(Double value) {
        addCriterion("total_weight =", value, "totalWeight");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)不等于
    */
    public Criteria andTotalWeightNotEqualTo(Double value) {
        addCriterion("total_weight <>", value, "totalWeight");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)大于
    */
    public Criteria andTotalWeightGreaterThan(Double value) {
        addCriterion("total_weight >", value, "totalWeight");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)大于等于
    */
    public Criteria andTotalWeightGreaterThanOrEqualTo(Double value) {
        addCriterion("total_weight >=", value, "totalWeight");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)小于
    */
    public Criteria andTotalWeightLessThan(Double value) {
        addCriterion("total_weight <", value, "totalWeight");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)小于等于
    */
    public Criteria andTotalWeightLessThanOrEqualTo(Double value) {
        addCriterion("total_weight <=", value, "totalWeight");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)在集合中
    */
    public Criteria andTotalWeightIn(List<Double> values) {
        addCriterion("total_weight in", values, "totalWeight");
        return (Criteria) this;
    }
    /**
     * -出库重量(单枚重量*领入件数)不在集合中
    */
    public Criteria andTotalWeightNotIn(List<Double> values) {
        addCriterion("total_weight not in", values, "totalWeight");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)在区间
    */
    public Criteria andTotalWeightBetween(Double value1, Double value2) {
        addCriterion("total_weight between", value1, value2, "totalWeight");
        return (Criteria) this;
    }
    /**
    * -出库重量(单枚重量*领入件数)不在区间
    */
    public Criteria andTotalWeightNotBetween(Double value1, Double value2) {
        addCriterion("total_weight not between", value1, value2, "totalWeight");
        return (Criteria) this;
    }
    /**
     * -备注是null
     */
		public Criteria andRemarkIsNull() {
        addCriterion("remark is null");
        return (Criteria) this;
    }
    /**
    * -备注不是null
    */
    public Criteria andRemarkIsNotNull() {
        addCriterion("remark is not null");
        return (Criteria) this;
    }
    /**
    * -备注等于
    */
    public Criteria andRemarkEqualTo(String value) {
        addCriterion("remark =", value, "remark");
        return (Criteria) this;
    }
    /**
    * -备注不等于
    */
    public Criteria andRemarkNotEqualTo(String value) {
        addCriterion("remark <>", value, "remark");
        return (Criteria) this;
    }
    /**
    * -备注大于
    */
    public Criteria andRemarkGreaterThan(String value) {
        addCriterion("remark >", value, "remark");
        return (Criteria) this;
    }
    /**
    * -备注大于等于
    */
    public Criteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("remark >=", value, "remark");
        return (Criteria) this;
    }
    /**
    * -备注小于
    */
    public Criteria andRemarkLessThan(String value) {
        addCriterion("remark <", value, "remark");
        return (Criteria) this;
    }
    /**
    * -备注小于等于
    */
    public Criteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("remark <=", value, "remark");
        return (Criteria) this;
    }
    /**
    * -备注符合
     */
    public Criteria andRemarkLike(String value) {
        addCriterion("remark like", value, "remark");
        return (Criteria) this;
    }
    /**
    * -备注不符合
    */
    public Criteria andRemarkNotLike(String value) {
        addCriterion("remark not like", value, "remark");
        return (Criteria) this;
    }
    /**
    * -备注在集合中
    */
    public Criteria andRemarkIn(List<String> values) {
        addCriterion("remark in", values, "remark");
        return (Criteria) this;
    }
    /**
     * -备注不在集合中
    */
    public Criteria andRemarkNotIn(List<String> values) {
        addCriterion("remark not in", values, "remark");
        return (Criteria) this;
    }
    /**
    * -备注在区间
    */
    public Criteria andRemarkBetween(String value1, String value2) {
        addCriterion("remark between", value1, value2, "remark");
        return (Criteria) this;
    }
    /**
    * -备注不在区间
    */
    public Criteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("remark not between", value1, value2, "remark");
        return (Criteria) this;
    }
    /**
     * -负责人是null
     */
		public Criteria andPrincipalIsNull() {
        addCriterion("principal is null");
        return (Criteria) this;
    }
    /**
    * -负责人不是null
    */
    public Criteria andPrincipalIsNotNull() {
        addCriterion("principal is not null");
        return (Criteria) this;
    }
    /**
    * -负责人等于
    */
    public Criteria andPrincipalEqualTo(String value) {
        addCriterion("principal =", value, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人不等于
    */
    public Criteria andPrincipalNotEqualTo(String value) {
        addCriterion("principal <>", value, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人大于
    */
    public Criteria andPrincipalGreaterThan(String value) {
        addCriterion("principal >", value, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人大于等于
    */
    public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
        addCriterion("principal >=", value, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人小于
    */
    public Criteria andPrincipalLessThan(String value) {
        addCriterion("principal <", value, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人小于等于
    */
    public Criteria andPrincipalLessThanOrEqualTo(String value) {
        addCriterion("principal <=", value, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人符合
     */
    public Criteria andPrincipalLike(String value) {
        addCriterion("principal like", value, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人不符合
    */
    public Criteria andPrincipalNotLike(String value) {
        addCriterion("principal not like", value, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人在集合中
    */
    public Criteria andPrincipalIn(List<String> values) {
        addCriterion("principal in", values, "principal");
        return (Criteria) this;
    }
    /**
     * -负责人不在集合中
    */
    public Criteria andPrincipalNotIn(List<String> values) {
        addCriterion("principal not in", values, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人在区间
    */
    public Criteria andPrincipalBetween(String value1, String value2) {
        addCriterion("principal between", value1, value2, "principal");
        return (Criteria) this;
    }
    /**
    * -负责人不在区间
    */
    public Criteria andPrincipalNotBetween(String value1, String value2) {
        addCriterion("principal not between", value1, value2, "principal");
        return (Criteria) this;
    }
    /**
     * -负责人编号是null
     */
		public Criteria andPrincipalIdIsNull() {
        addCriterion("principal_id is null");
        return (Criteria) this;
    }
    /**
    * -负责人编号不是null
    */
    public Criteria andPrincipalIdIsNotNull() {
        addCriterion("principal_id is not null");
        return (Criteria) this;
    }
    /**
    * -负责人编号等于
    */
    public Criteria andPrincipalIdEqualTo(Integer value) {
        addCriterion("principal_id =", value, "principalId");
        return (Criteria) this;
    }
    /**
    * -负责人编号不等于
    */
    public Criteria andPrincipalIdNotEqualTo(Integer value) {
        addCriterion("principal_id <>", value, "principalId");
        return (Criteria) this;
    }
    /**
    * -负责人编号大于
    */
    public Criteria andPrincipalIdGreaterThan(Integer value) {
        addCriterion("principal_id >", value, "principalId");
        return (Criteria) this;
    }
    /**
    * -负责人编号大于等于
    */
    public Criteria andPrincipalIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("principal_id >=", value, "principalId");
        return (Criteria) this;
    }
    /**
    * -负责人编号小于
    */
    public Criteria andPrincipalIdLessThan(Integer value) {
        addCriterion("principal_id <", value, "principalId");
        return (Criteria) this;
    }
    /**
    * -负责人编号小于等于
    */
    public Criteria andPrincipalIdLessThanOrEqualTo(Integer value) {
        addCriterion("principal_id <=", value, "principalId");
        return (Criteria) this;
    }
    /**
    * -负责人编号在集合中
    */
    public Criteria andPrincipalIdIn(List<Integer> values) {
        addCriterion("principal_id in", values, "principalId");
        return (Criteria) this;
    }
    /**
     * -负责人编号不在集合中
    */
    public Criteria andPrincipalIdNotIn(List<Integer> values) {
        addCriterion("principal_id not in", values, "principalId");
        return (Criteria) this;
    }
    /**
    * -负责人编号在区间
    */
    public Criteria andPrincipalIdBetween(Integer value1, Integer value2) {
        addCriterion("principal_id between", value1, value2, "principalId");
        return (Criteria) this;
    }
    /**
    * -负责人编号不在区间
    */
    public Criteria andPrincipalIdNotBetween(Integer value1, Integer value2) {
        addCriterion("principal_id not between", value1, value2, "principalId");
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
    /**
     * -库管员1是null
     */
		public Criteria andCreator01IsNull() {
        addCriterion("creator01 is null");
        return (Criteria) this;
    }
    /**
    * -库管员1不是null
    */
    public Criteria andCreator01IsNotNull() {
        addCriterion("creator01 is not null");
        return (Criteria) this;
    }
    /**
    * -库管员1等于
    */
    public Criteria andCreator01EqualTo(String value) {
        addCriterion("creator01 =", value, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1不等于
    */
    public Criteria andCreator01NotEqualTo(String value) {
        addCriterion("creator01 <>", value, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1大于
    */
    public Criteria andCreator01GreaterThan(String value) {
        addCriterion("creator01 >", value, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1大于等于
    */
    public Criteria andCreator01GreaterThanOrEqualTo(String value) {
        addCriterion("creator01 >=", value, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1小于
    */
    public Criteria andCreator01LessThan(String value) {
        addCriterion("creator01 <", value, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1小于等于
    */
    public Criteria andCreator01LessThanOrEqualTo(String value) {
        addCriterion("creator01 <=", value, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1符合
     */
    public Criteria andCreator01Like(String value) {
        addCriterion("creator01 like", value, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1不符合
    */
    public Criteria andCreator01NotLike(String value) {
        addCriterion("creator01 not like", value, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1在集合中
    */
    public Criteria andCreator01In(List<String> values) {
        addCriterion("creator01 in", values, "creator01");
        return (Criteria) this;
    }
    /**
     * -库管员1不在集合中
    */
    public Criteria andCreator01NotIn(List<String> values) {
        addCriterion("creator01 not in", values, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1在区间
    */
    public Criteria andCreator01Between(String value1, String value2) {
        addCriterion("creator01 between", value1, value2, "creator01");
        return (Criteria) this;
    }
    /**
    * -库管员1不在区间
    */
    public Criteria andCreator01NotBetween(String value1, String value2) {
        addCriterion("creator01 not between", value1, value2, "creator01");
        return (Criteria) this;
    }
    /**
     * -库管员2是null
     */
		public Criteria andCreator02IsNull() {
        addCriterion("creator02 is null");
        return (Criteria) this;
    }
    /**
    * -库管员2不是null
    */
    public Criteria andCreator02IsNotNull() {
        addCriterion("creator02 is not null");
        return (Criteria) this;
    }
    /**
    * -库管员2等于
    */
    public Criteria andCreator02EqualTo(String value) {
        addCriterion("creator02 =", value, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2不等于
    */
    public Criteria andCreator02NotEqualTo(String value) {
        addCriterion("creator02 <>", value, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2大于
    */
    public Criteria andCreator02GreaterThan(String value) {
        addCriterion("creator02 >", value, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2大于等于
    */
    public Criteria andCreator02GreaterThanOrEqualTo(String value) {
        addCriterion("creator02 >=", value, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2小于
    */
    public Criteria andCreator02LessThan(String value) {
        addCriterion("creator02 <", value, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2小于等于
    */
    public Criteria andCreator02LessThanOrEqualTo(String value) {
        addCriterion("creator02 <=", value, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2符合
     */
    public Criteria andCreator02Like(String value) {
        addCriterion("creator02 like", value, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2不符合
    */
    public Criteria andCreator02NotLike(String value) {
        addCriterion("creator02 not like", value, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2在集合中
    */
    public Criteria andCreator02In(List<String> values) {
        addCriterion("creator02 in", values, "creator02");
        return (Criteria) this;
    }
    /**
     * -库管员2不在集合中
    */
    public Criteria andCreator02NotIn(List<String> values) {
        addCriterion("creator02 not in", values, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2在区间
    */
    public Criteria andCreator02Between(String value1, String value2) {
        addCriterion("creator02 between", value1, value2, "creator02");
        return (Criteria) this;
    }
    /**
    * -库管员2不在区间
    */
    public Criteria andCreator02NotBetween(String value1, String value2) {
        addCriterion("creator02 not between", value1, value2, "creator02");
        return (Criteria) this;
    }
    /**
     * -库管员1编号是null
     */
		public Criteria andCreator01IdIsNull() {
        addCriterion("creator01_id is null");
        return (Criteria) this;
    }
    /**
    * -库管员1编号不是null
    */
    public Criteria andCreator01IdIsNotNull() {
        addCriterion("creator01_id is not null");
        return (Criteria) this;
    }
    /**
    * -库管员1编号等于
    */
    public Criteria andCreator01IdEqualTo(Integer value) {
        addCriterion("creator01_id =", value, "creator01Id");
        return (Criteria) this;
    }
    /**
    * -库管员1编号不等于
    */
    public Criteria andCreator01IdNotEqualTo(Integer value) {
        addCriterion("creator01_id <>", value, "creator01Id");
        return (Criteria) this;
    }
    /**
    * -库管员1编号大于
    */
    public Criteria andCreator01IdGreaterThan(Integer value) {
        addCriterion("creator01_id >", value, "creator01Id");
        return (Criteria) this;
    }
    /**
    * -库管员1编号大于等于
    */
    public Criteria andCreator01IdGreaterThanOrEqualTo(Integer value) {
        addCriterion("creator01_id >=", value, "creator01Id");
        return (Criteria) this;
    }
    /**
    * -库管员1编号小于
    */
    public Criteria andCreator01IdLessThan(Integer value) {
        addCriterion("creator01_id <", value, "creator01Id");
        return (Criteria) this;
    }
    /**
    * -库管员1编号小于等于
    */
    public Criteria andCreator01IdLessThanOrEqualTo(Integer value) {
        addCriterion("creator01_id <=", value, "creator01Id");
        return (Criteria) this;
    }
    /**
    * -库管员1编号在集合中
    */
    public Criteria andCreator01IdIn(List<Integer> values) {
        addCriterion("creator01_id in", values, "creator01Id");
        return (Criteria) this;
    }
    /**
     * -库管员1编号不在集合中
    */
    public Criteria andCreator01IdNotIn(List<Integer> values) {
        addCriterion("creator01_id not in", values, "creator01Id");
        return (Criteria) this;
    }
    /**
    * -库管员1编号在区间
    */
    public Criteria andCreator01IdBetween(Integer value1, Integer value2) {
        addCriterion("creator01_id between", value1, value2, "creator01Id");
        return (Criteria) this;
    }
    /**
    * -库管员1编号不在区间
    */
    public Criteria andCreator01IdNotBetween(Integer value1, Integer value2) {
        addCriterion("creator01_id not between", value1, value2, "creator01Id");
        return (Criteria) this;
    }
    /**
     * -库管员2编号是null
     */
		public Criteria andCreator02IdIsNull() {
        addCriterion("creator02_id is null");
        return (Criteria) this;
    }
    /**
    * -库管员2编号不是null
    */
    public Criteria andCreator02IdIsNotNull() {
        addCriterion("creator02_id is not null");
        return (Criteria) this;
    }
    /**
    * -库管员2编号等于
    */
    public Criteria andCreator02IdEqualTo(Integer value) {
        addCriterion("creator02_id =", value, "creator02Id");
        return (Criteria) this;
    }
    /**
    * -库管员2编号不等于
    */
    public Criteria andCreator02IdNotEqualTo(Integer value) {
        addCriterion("creator02_id <>", value, "creator02Id");
        return (Criteria) this;
    }
    /**
    * -库管员2编号大于
    */
    public Criteria andCreator02IdGreaterThan(Integer value) {
        addCriterion("creator02_id >", value, "creator02Id");
        return (Criteria) this;
    }
    /**
    * -库管员2编号大于等于
    */
    public Criteria andCreator02IdGreaterThanOrEqualTo(Integer value) {
        addCriterion("creator02_id >=", value, "creator02Id");
        return (Criteria) this;
    }
    /**
    * -库管员2编号小于
    */
    public Criteria andCreator02IdLessThan(Integer value) {
        addCriterion("creator02_id <", value, "creator02Id");
        return (Criteria) this;
    }
    /**
    * -库管员2编号小于等于
    */
    public Criteria andCreator02IdLessThanOrEqualTo(Integer value) {
        addCriterion("creator02_id <=", value, "creator02Id");
        return (Criteria) this;
    }
    /**
    * -库管员2编号在集合中
    */
    public Criteria andCreator02IdIn(List<Integer> values) {
        addCriterion("creator02_id in", values, "creator02Id");
        return (Criteria) this;
    }
    /**
     * -库管员2编号不在集合中
    */
    public Criteria andCreator02IdNotIn(List<Integer> values) {
        addCriterion("creator02_id not in", values, "creator02Id");
        return (Criteria) this;
    }
    /**
    * -库管员2编号在区间
    */
    public Criteria andCreator02IdBetween(Integer value1, Integer value2) {
        addCriterion("creator02_id between", value1, value2, "creator02Id");
        return (Criteria) this;
    }
    /**
    * -库管员2编号不在区间
    */
    public Criteria andCreator02IdNotBetween(Integer value1, Integer value2) {
        addCriterion("creator02_id not between", value1, value2, "creator02Id");
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


package com.bootx.common;

import com.fasterxml.jackson.annotation.JsonView;
import com.bootx.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 分页
 *
 * @author blackboy
 * @version 1.0
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = -2053800594583879853L;

	/**
	 * 内容
	 */
	@JsonView({BaseEntity.BaseView.class, BaseEntity.ListView.class})
	private final List<T> data = new ArrayList<>();

	/**
	 * 总记录数
	 */
	@JsonView({BaseEntity.BaseView.class, BaseEntity.ListView.class})
	private final long total;

	/**
	 * 分页信息
	 */
	private final Pageable pageable;

	/**
	 * 构造方法
	 */
	public Page() {
		this.total = 0L;
		this.pageable = new Pageable();
	}

	/**
	 * 构造方法
	 *
	 * @param data
	 *            内容
	 * @param total
	 *            总记录数
	 * @param pageable
	 *            分页信息
	 */
	public Page(List<T> data, long total, Pageable pageable) {
		this.data.addAll(data);
		this.total = total;
		this.pageable = pageable;
	}

	/**
	 * 获取页码
	 *
	 * @return 页码
	 */
	@JsonView({BaseEntity.BaseView.class, BaseEntity.ListView.class})
	public int getCurrent() {
		return pageable.getCurrent();
	}

	/**
	 * 获取每页记录数
	 *
	 * @return 每页记录数
	 */
	@JsonView({BaseEntity.BaseView.class, BaseEntity.ListView.class})
	public int getPageSize() {
		return pageable.getPageSize();
	}

	/**
	 * 获取搜索属性
	 *
	 * @return 搜索属性
	 */
	public String getSearchProperty() {
		return pageable.getSearchProperty();
	}

	/**
	 * 获取搜索值
	 *
	 * @return 搜索值
	 */
	public String getSearchValue() {
		return pageable.getSearchValue();
	}

	/**
	 * 获取排序属性
	 *
	 * @return 排序属性
	 */
	public String getOrderProperty() {
		return pageable.getOrderProperty();
	}

	/**
	 * 获取排序方向
	 *
	 * @return 排序方向
	 */
	public Order.Direction getOrderDirection() {
		return pageable.getOrderDirection();
	}

	/**
	 * 获取排序
	 *
	 * @return 排序
	 */
	public List<Order> getOrders() {
		return pageable.getOrders();
	}

	/**
	 * 获取筛选
	 *
	 * @return 筛选
	 */
	public List<Filter> getFilters() {
		return pageable.getFilters();
	}

	/**
	 * 获取总页数
	 *
	 * @return 总页数
	 */
	public int getTotalPages() {
		return (int) Math.ceil((double) getTotal() / (double) getPageSize());
	}

	/**
	 * 获取内容
	 *
	 * @return 内容
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * 获取总记录数
	 *
	 * @return 总记录数
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 获取分页信息
	 *
	 * @return 分页信息
	 */
	public Pageable getPageable() {
		return pageable;
	}

	/**
	 * 获取空分页
	 *
	 * @param pageable
	 *            分页信息
	 * @return 空分页
	 */
	public static final <T> Page<T> emptyPage(Pageable pageable) {
		return new Page<>(Collections.<T>emptyList(), 0L, pageable);
	}

	/**
	 * 重写equals方法
	 *
	 * @param obj
	 *            对象
	 * @return 是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * 重写hashCode方法
	 *
	 * @return HashCode
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}

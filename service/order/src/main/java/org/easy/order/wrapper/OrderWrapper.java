/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.easy.order.wrapper;

import lombok.AllArgsConstructor;

import org.easy.mybatisplus.support.BaseEntityWrapper;
import org.easy.tool.util.BeanUtil;
//import org.easy.system.feign.IDictClient;

import org.easy.order.entity.Order;
import org.easy.order.vo.OrderVO;

/**
 * 包装类,返回视图层所需的字段
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2020-12-31
 */
@AllArgsConstructor
public class OrderWrapper extends BaseEntityWrapper<Order, OrderVO>  {

	//private IDictClient dictClient;

	@Override
	public OrderVO entityVO(Order order) {
		OrderVO orderVO = BeanUtil.copy(order, OrderVO.class);

		/*R<String> dict = dictClient.getValue("order" , orderVO.getCategory());
		if (dict.isSuccess()) {
			String categoryName = dict.getData();
			orderVO.setCategoryName(categoryName);
		}*/

		return orderVO;
	}

}

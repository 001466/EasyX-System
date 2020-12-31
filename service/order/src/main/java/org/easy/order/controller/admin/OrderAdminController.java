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
package org.easy.order.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.easy.mybatisplus.support.Condition;
import org.easy.mybatisplus.support.Query;
import org.easy.tool.web.R;
import org.easy.tool.util.Func;
//import org.springblade.system.feign.IDictClient;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.easy.order.entity.Order;
import org.easy.order.vo.OrderVO;
import org.easy.order.wrapper.OrderWrapper;
import org.easy.order.service.IOrderService;
import java.util.List;

/**
 * 订单 控制器
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2020-12-31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order/admin")
@Api(value = "订单", tags = "订单")
public class OrderAdminController {

	private IOrderService orderService;

	//private IDictClient dictClient;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入order", position = 1)
	public R<OrderVO> detail(Order order) {
		Order detail = orderService.getOne(Condition.getQueryWrapper(order));
		OrderWrapper orderWrapper = new OrderWrapper();
		return R.success(orderWrapper.entityVO(detail));
	}

	/**
	* 列表 
	*/
	@GetMapping("/list")
	@ApiOperation(value = "列表", notes = "传入order", position = 2)
	public R<List<OrderVO>> list(Order order) {
		List<Order> list = orderService.list(Condition.getQueryWrapper(order));
		OrderWrapper orderWrapper = new OrderWrapper();
		return R.success(orderWrapper.listVO(list));
	}

	/**
	* 自定义分页 
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入order", position = 3)
	public R<IPage<OrderVO>> page(OrderVO order, Query query) {
		IPage<OrderVO> pages = orderService.selectOrderPage(Condition.getPage(query), order);
		return R.success(pages);
	}


//
//	/**
//	* 新增
//	*/
//	@PostMapping("/save")
//	@ApiOperation(value = "新增", notes = "传入order", position = 4)
//	public R save(@Valid @RequestBody Order order) {
//		return R.status(orderService.save(order));
//	}
//
//	/**
//	* 修改
//	*/
//	@PostMapping("/update")
//	@ApiOperation(value = "修改", notes = "传入order", position = 5)
//	public R update(@Valid @RequestBody Order order) {
//		return R.status(orderService.updateById(order));
//	}
//
//	/**
//	* 新增或修改
//	*/
//	@PostMapping("/submit")
//	@ApiOperation(value = "新增或修改", notes = "传入order", position = 6)
//	public R submit(@Valid @RequestBody Order order) {
//		return R.status(orderService.saveOrUpdate(order));
//	}
//
//
//	/**
//	* 删除
//	*/
//	@PostMapping("/remove")
//	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
//	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
//		return R.status(orderService.removeByIds(Func.toIntList(ids)));
//	}

	
}

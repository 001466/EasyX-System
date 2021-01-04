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
package org.easy.order.controller;

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
import org.easy.order.entity.LandingOrder;
import org.easy.order.vo.LandingOrderVO;
import org.easy.order.wrapper.LandingOrderWrapper;
import org.easy.order.service.ILandingOrderService;
import java.util.List;

/**
 * 订单 控制器
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2020-12-31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/landingorder")
@Api(value = "订单", tags = "订单")
public class LandingOrderController {

	private ILandingOrderService landingOrderService;

	//private IDictClient dictClient;

//	/**
//	* 详情
//	*/
//	@GetMapping("/detail")
//	@ApiOperation(value = "详情", notes = "传入landingOrder", position = 1)
//	public R<LandingOrderVO> detail(LandingOrder landingOrder) {
//		LandingOrder detail = landingOrderService.getOne(Condition.getQueryWrapper(landingOrder));
//		LandingOrderWrapper landingOrderWrapper = new LandingOrderWrapper();
//		return R.success(landingOrderWrapper.entityVO(detail));
//	}

//	/**
//	* 列表
//	*/
//	@GetMapping("/list")
//	@ApiOperation(value = "列表", notes = "传入landingOrder", position = 2)
//	public R<List<LandingOrderVO>> list(LandingOrder landingOrder) {
//		List<LandingOrder> list = landingOrderService.list(Condition.getQueryWrapper(landingOrder));
//		LandingOrderWrapper landingOrderWrapper = new LandingOrderWrapper();
//		return R.success(landingOrderWrapper.listVO(list));
//	}

//	/**
//	* 自定义分页
//	*/
//	@GetMapping("/page")
//	@ApiOperation(value = "分页", notes = "传入landingOrder", position = 3)
//	public R<IPage<LandingOrderVO>> page(LandingOrderVO landingOrder, Query query) {
//		IPage<LandingOrderVO> pages = landingOrderService.selectLandingOrderPage(Condition.getPage(query), landingOrder);
//		return R.success(pages);
//	}

	/**
	* 新增 
	*/
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入landingOrder", position = 4)
	public R save(@Valid @RequestBody LandingOrder landingOrder) {
		return R.status(landingOrderService.save(landingOrder));
	}

	/**
	* 修改 
	*/
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入landingOrder", position = 5)
	public R update(@Valid @RequestBody LandingOrder landingOrder) {
		return R.status(landingOrderService.updateById(landingOrder));
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入landingOrder", position = 6)
	public R submit(@Valid @RequestBody LandingOrder landingOrder) {
		return R.status(landingOrderService.saveOrUpdate(landingOrder));
	}

//
//	/**
//	* 删除
//	*/
//	@PostMapping("/remove")
//	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
//	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
//		return R.status(landingOrderService.removeByIds(Func.toIntList(ids)));
//	}

	
}

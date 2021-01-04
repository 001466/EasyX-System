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

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.easy.excel.util.ExportExcelUtil;
import org.easy.excel.util.ExportExcelWrapper;
import org.easy.mybatisplus.support.Condition;
import org.easy.mybatisplus.support.Query;
import org.easy.order.entity.LandingOrder;
import org.easy.order.service.ILandingOrderService;
import org.easy.order.vo.LandingOrderVO;
import org.easy.order.wrapper.LandingOrderWrapper;
import org.easy.tool.util.Func;
import org.easy.tool.web.R;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import org.springblade.system.feign.IDictClient;

/**
 * 订单 控制器
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2020-12-31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/landingorder/admin")
@Api(value = "订单", tags = "订单")
public class LandingOrderAdminController {

	private ILandingOrderService landingOrderService;

	//private IDictClient dictClient;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入landingOrder", position = 1)
	public R<LandingOrderVO> detail(LandingOrder landingOrder) {
		LandingOrder detail = landingOrderService.getOne(Condition.getQueryWrapper(landingOrder));
		LandingOrderWrapper landingOrderWrapper = new LandingOrderWrapper();
		return R.success(landingOrderWrapper.entityVO(detail));
	}

	/**
	* 列表
	*/
	@GetMapping("/list")
	@ApiOperation(value = "列表", notes = "传入landingOrder", position = 2)
	public R<List<LandingOrderVO>> list(LandingOrder landingOrder) {
		List<LandingOrder> list = landingOrderService.list(Condition.getQueryWrapper(landingOrder));
		LandingOrderWrapper landingOrderWrapper = new LandingOrderWrapper();
		return R.success(landingOrderWrapper.listVO(list));
	}

	/**
	* 自定义分页
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入landingOrder", position = 3)
	public R<IPage<LandingOrderVO>> page(LandingOrderVO landingOrder, Query query) {
		IPage<LandingOrderVO> pages = landingOrderService.selectLandingOrderPage(Condition.getPage(query), landingOrder);
		return R.success(pages);
	}

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


	/**
	* 删除
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(landingOrderService.removeByIds(Func.toIntList(ids)));
	}

	@RequestMapping (value="/remove/{id}",method = RequestMethod.POST)
	@ApiOperation(value = "册除", notes = "册除")
	@ApiImplicitParam(name="id",value="id",required=true,paramType="path")
	public R<Integer> del(@PathVariable("id") Long id, HttpServletRequest request) {
		landingOrderService.removeById(id);
		return R.success();
	}


	@ApiOperation(value = "导出订单", notes = "导出订单")
	@GetMapping(path = {"/export"})
	public void exp(@ModelAttribute @ApiParam(name = "ordersDTO对像", value = "ordersDTO") @Valid LandingOrder landingOrder, HttpServletRequest request, HttpServletResponse response) {
		List<LandingOrder> list=landingOrderService.list(Condition.getQueryWrapper(landingOrder));

		String[] headers = { "订单编号",    "订单类型",     "客户名称",     "联系方式",     "省份",                "城市",          "地址",               "产品名称"      ,"产品品牌",        "产品价格",      "客户留言" };
		String[] bodies =  { "id",          "type",         "customName",   "customMobile","deliverProvince",   "deliverCity",  "deliverAdderss",   "productType"   ,"productBranch", "productPrice","customContent" };

		String fileName = "excel1";
		ExportExcelWrapper<LandingOrder> util = new ExportExcelWrapper<LandingOrder>();
		util.exportExcel(fileName, fileName, headers,bodies, list, response, ExportExcelUtil.EXCEL_FILE_2003);
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

	}

	
}

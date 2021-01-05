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
package org.easy.word.controller;

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
import org.easy.word.entity.WordTyp;
import org.easy.word.vo.WordTypVO;
import org.easy.word.wrapper.WordTypWrapper;
import org.easy.word.service.IWordTypService;
import java.util.List;

/**
 * 文字标签 控制器
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2021-01-05
 */
@RestController
@AllArgsConstructor
@RequestMapping("/wordtyp")
@Api(value = "文字标签", tags = "文字标签")
public class WordTypController {

	private IWordTypService wordTypService;

	//private IDictClient dictClient;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入wordTyp", position = 1)
	public R<WordTypVO> detail(WordTyp wordTyp) {
		WordTyp detail = wordTypService.getOne(Condition.getQueryWrapper(wordTyp));
		WordTypWrapper wordTypWrapper = new WordTypWrapper();
		return R.success(wordTypWrapper.entityVO(detail));
	}

	/**
	* 列表 
	*/
	@GetMapping("/list")
	@ApiOperation(value = "列表", notes = "传入wordTyp", position = 2)
	public R<List<WordTypVO>> list(WordTyp wordTyp) {
		List<WordTyp> list = wordTypService.list(Condition.getQueryWrapper(wordTyp));
		WordTypWrapper wordTypWrapper = new WordTypWrapper();
		return R.success(wordTypWrapper.listVO(list));
	}

	/**
	* 自定义分页 
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入wordTyp", position = 3)
	public R<IPage<WordTypVO>> page(WordTypVO wordTyp, Query query) {
		IPage<WordTypVO> pages = wordTypService.selectWordTypPage(Condition.getPage(query), wordTyp);
		return R.success(pages);
	}

	/**
	* 新增 
	*/
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入wordTyp", position = 4)
	public R save(@Valid @RequestBody WordTyp wordTyp) {
		return R.status(wordTypService.save(wordTyp));
	}

	/**
	* 修改 
	*/
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入wordTyp", position = 5)
	public R update(@Valid @RequestBody WordTyp wordTyp) {
		return R.status(wordTypService.updateById(wordTyp));
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入wordTyp", position = 6)
	public R submit(@Valid @RequestBody WordTyp wordTyp) {
		return R.status(wordTypService.saveOrUpdate(wordTyp));
	}

	
	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(wordTypService.removeByIds(Func.toIntList(ids)));
	}

	
}

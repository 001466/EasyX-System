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
package org.easy.word.service.impl;

import org.easy.word.entity.WordDict;
import org.easy.word.vo.WordDictVO;
import org.easy.word.mapper.WordDictMapper;
import org.easy.word.service.IWordDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *  服务实现类
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2020-12-31
 */
@Service
public class WordDictServiceImpl extends ServiceImpl<WordDictMapper, WordDict> implements IWordDictService {

	@Override
	public IPage<WordDictVO> selectWordDictPage(IPage<WordDictVO> page, WordDictVO wordDict) {
		return page.setRecords(baseMapper.selectWordDictPage(page, wordDict));
	}

}

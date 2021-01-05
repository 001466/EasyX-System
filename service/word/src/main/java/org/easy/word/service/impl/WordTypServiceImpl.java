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

import org.easy.word.entity.WordTyp;
import org.easy.word.vo.WordTypVO;
import org.easy.word.mapper.WordTypMapper;
import org.easy.word.service.IWordTypService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *  服务实现类
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2021-01-05
 */
@Service
public class WordTypServiceImpl extends ServiceImpl<WordTypMapper, WordTyp> implements IWordTypService {

	@Override
	public IPage<WordTypVO> selectWordTypPage(IPage<WordTypVO> page, WordTypVO wordTyp) {
		return page.setRecords(baseMapper.selectWordTypPage(page, wordTyp));
	}

}

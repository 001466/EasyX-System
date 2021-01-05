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
package org.easy.word.service;

import org.easy.word.entity.WordTag;
import org.easy.word.vo.WordTagVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *  服务类
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2021-01-05
 */
public interface IWordTagService extends IService<WordTag> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param wordTag
	 * @return
	 */
	IPage<WordTagVO> selectWordTagPage(IPage<WordTagVO> page, WordTagVO wordTag);

}

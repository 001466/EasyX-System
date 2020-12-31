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
package org.easy.order.service.impl;

import org.easy.order.entity.LandingOrder;
import org.easy.order.vo.LandingOrderVO;
import org.easy.order.mapper.LandingOrderMapper;
import org.easy.order.service.ILandingOrderService;
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
public class LandingOrderServiceImpl extends ServiceImpl<LandingOrderMapper, LandingOrder> implements ILandingOrderService {

	@Override
	public IPage<LandingOrderVO> selectLandingOrderPage(IPage<LandingOrderVO> page, LandingOrderVO landingOrder) {
		return page.setRecords(baseMapper.selectLandingOrderPage(page, landingOrder));
	}

}

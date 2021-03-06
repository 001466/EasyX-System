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
package org.easy.auth.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.easy.auth.utils.TokenUtil;
import org.easy.secure.exception.UserNotFoundException;
import org.easy.tool.util.Func;
import org.easy.tool.web.R;
import org.easy.tool.web.ResultCode;
import org.easy.user.entity.User;
import org.easy.user.entity.UserInfo;
import org.easy.user.feign.IUserFeign;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * 用户信息
 *
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private IUserFeign iUserFeign;

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String account) {


		R<UserInfo> result = iUserFeign.loadUserByUsername(account);
		log.warn("loadUserByUsername:{},{}",account,result.getData());
		if(!result.isSuccess() || result.getData()==null||result.getData().getUser()==null){
			throw new UserNotFoundException(ResultCode.USER_NOT_FOUND);
		}
		UserInfo userInfo = result.getData();
		User originUser=userInfo.getUser();
		org.easy.secure.User authorizedUser=new org.easy.secure.User(TokenUtil.getClientIdFromHeader(),null,originUser.getId(),originUser.getName(),originUser.getNickName(),account,originUser.getRoleId(),Func.join(result.getData().getRoles()),originUser.getAvatar(),originUser.getType(),new HashSet<>( userInfo.getPermissions()),originUser.getPath());
		return new UserDetails(authorizedUser,account, originUser.getPassword(), originUser.getEnabled()==0?false:true, originUser.getExpired()==0?true:false, originUser.getExpired()==0?true:false, originUser.getLocked()==0?true:false,AuthorityUtils.commaSeparatedStringToAuthorityList(Func.join(result.getData().getPermissions())));

	}

}

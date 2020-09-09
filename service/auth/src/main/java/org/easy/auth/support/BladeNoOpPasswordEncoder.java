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
package org.easy.auth.support;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 无密码加密
 *
 */
public class BladeNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		String encode= rawPassword.toString();
		return encode;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if( rawPassword.toString().equals(encodedPassword)){
			return true;
		}
		return false;//throw new RuntimeException("密码不正确");
	}

	/**
	 * Get the singleton {@link BladeNoOpPasswordEncoder}.
	 */
	public static PasswordEncoder getInstance() {
		return INSTANCE;
	}

	private static final PasswordEncoder INSTANCE = new BladeNoOpPasswordEncoder();

	private BladeNoOpPasswordEncoder() {
	}

}

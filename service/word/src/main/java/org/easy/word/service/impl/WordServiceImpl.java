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

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.easy.mybatisplus.support.Condition;
import org.easy.word.dto.WordDTO;
import org.easy.word.entity.Word;
import org.easy.word.entity.WordTag;
import org.easy.word.entity.WordTyp;
import org.easy.word.service.IWordTagService;
import org.easy.word.service.IWordTypService;
import org.easy.word.vo.WordVO;
import org.easy.word.mapper.WordMapper;
import org.easy.word.service.IWordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Collection;

/**
 *  服务实现类
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2020-12-31
 */
@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements IWordService {

	@Autowired
	IWordTagService wordTagService;

	@Autowired
	IWordTypService wordTypService;

	@Override
	public IPage<WordVO> selectWordPage(IPage<WordVO> page, WordDTO word) {
		return page.setRecords(baseMapper.selectWordPage(page, word));
	}

	@Override
	public boolean saveOrUpdate(WordDTO entity){
		Word old=getById(entity.getId());
		if(old!=null){
			return updateById(entity);
		}else{
			return save(entity);
		}
	}

	public boolean save(WordDTO entity) {

		boolean ok= super.save(entity);

		updateTyp(entity);
		updateTag(entity);

		return ok;
	}

	public boolean updateById(WordDTO entity) {

		boolean ok= super.updateById(entity);

		updateTyp(entity);
		updateTag(entity);

		return ok;
	}

	public void updateTag(WordDTO entity){
		Integer wordId=entity.getId();
		WordTag wordTag=new WordTag();
		wordTag.setWordId(wordId);
		wordTagService.remove(Condition.getQueryWrapper(wordTag));

		String tag=entity.getTag();
		wordTag.setTag(tag);
		wordTagService.save(wordTag);
	}

	public void updateTyp(WordDTO entity){
		Integer wordId=entity.getId();
		WordTyp wordTyp=new WordTyp();
		wordTyp.setWordId(wordId);
		wordTypService.remove(Condition.getQueryWrapper(wordTyp));

		String typ=entity.getTyp();
		wordTyp.setTyp(typ);
		wordTypService.save(wordTyp);
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		for(Serializable wordId:idList){
			WordTag wordTag=new WordTag();
			wordTag.setWordId(Integer.decode(String.valueOf(wordId)));
			wordTagService.remove(Condition.getQueryWrapper(wordTag));
		}
		return super.removeByIds(idList);
	}

	@Override
	public boolean removeById(Serializable id) {
		WordTag wordTag=new WordTag();
		wordTag.setWordId(Integer.decode(String.valueOf(id)));
		wordTagService.remove(Condition.getQueryWrapper(wordTag));
		return super.removeById(id);
	}


}

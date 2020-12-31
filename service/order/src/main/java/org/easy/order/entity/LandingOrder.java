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
package org.easy.order.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 *
 * @author EasyX è±è¯ (240018840@qq.com)
 * @since 2020-12-31
 */
@Data
@ApiModel(value = "LandingOrder对象", description = "LandingOrder对象")
public class LandingOrder implements Serializable {

    private static final long serialVersionUID = 1L;

  @TableId(value = "id",type =IdType.AUTO)
  private Long id;
  private String type;
  private String customName;
  private String customMobile;
  private String customEmail;
  private String customWechat;
  private String customQq;
  private String customContent;
    /**
     * 0付费1免费
     */
    @ApiModelProperty(value = "0付费1免费")
    private Integer customType;
  private String customFrom;
  private String customVisitUrl;
  private String productId;
  private String productType;
  private String productBranch;
  private String productMaterial;
  private BigDecimal productPrice;
  private String deliverProvince;
  private String deliverCity;
  private String deliverCounty;
  private String deliverAdderss;
  private String deliverTime;
    /**
     * 0未发货1已发货-1已退货
     */
    @ApiModelProperty(value = "0未发货1已发货-1已退货")
    private Integer deliverStatus;
  private String deliverExpress;
  private String deliverExpressId;
  private Long createUser;
  private LocalDateTime createTime;
  private LocalDate createDate;
  private String createIp;
  private Long updateUser;
  private LocalDateTime updateTime;
  private String updateIp;
    /**
     * 0未转化1已转化
     */
    @ApiModelProperty(value = "0未转化1已转化")
    private Integer status;
  private String browserType;
  private String browserName;
  private String browserOs;
  private String rateUnit;
  private Integer rateVal;


}

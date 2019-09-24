package com.sugar.gmail.user.bean;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class UmsMemberReceiveAddress {

  @Id
  private Long id;
  private Long memberId;
  private String name;
  private String phoneNumber;
  private Long defaultStatus;
  private String postCode;
  private String province;
  private String city;
  private String region;
  private String detailAddress;
}

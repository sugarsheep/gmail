package com.sugar.gmail.user.bean;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
public class UmsMember {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long memberLevelId;
  private String username;
  private String password;
  private String nickname;
  private String phone;
  private Long status;
  private java.sql.Timestamp createTime;
  private String icon;
  private Long gender;
  private java.sql.Date birthday;
  private String city;
  private String job;
  private String personalizedSignature;
  private Long sourceType;
  private Long integration;
  private Long growth;
  private Long luckeyCount;
  private Long historyIntegration;
}

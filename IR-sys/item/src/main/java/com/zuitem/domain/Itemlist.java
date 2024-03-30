package com.zuitem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Itemlist {
  private Integer id;
  private String itemid;
  private String iname;
  private String photo;
  private double price;
  private String status;
  private String detail;
}

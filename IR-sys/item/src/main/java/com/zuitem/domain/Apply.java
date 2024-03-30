package com.zuitem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Apply {
private Integer id;
private String item_id;
private String iname;
private String photo;
private double price;
private Date apply_date;
private Integer user_id;
private String status;
private Userlist userlist;
}

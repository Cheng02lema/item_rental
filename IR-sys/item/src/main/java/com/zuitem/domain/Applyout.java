package com.zuitem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Applyout {
 private Integer id;
 private String item_id;
 private String iname;
 private String status;
 private Integer user_id;
 private List<Userlist> userlist;

}

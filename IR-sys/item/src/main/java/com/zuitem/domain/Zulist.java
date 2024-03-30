package com.zuitem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Zulist {
	private Integer zid;
	private String item_id;
	private Double price;
	private String iname;
	private Integer user_id;
	private Integer contract_id;
	private Userlist userlist;
}

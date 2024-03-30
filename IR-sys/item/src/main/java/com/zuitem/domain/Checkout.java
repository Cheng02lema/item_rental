package com.zuitem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Checkout {
	private Integer id;
	private String item_id;
	private String iname;
	private String status;
	private Integer user_id;
	private Userlist userlist;
}

package com.zuitem.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wrong {
 private Integer id;
 private String item_id;
 private String iname;
 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 private Date date;
 private String detail;
 private String name;
 private Integer user_id;
 private String status;
}

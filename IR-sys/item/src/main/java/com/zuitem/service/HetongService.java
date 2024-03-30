package com.zuitem.service;

import com.zuitem.domain.Hetong;

public interface HetongService {
    void addHetong(Hetong hetong);
    Hetong findhetong(String item_id);
    void delHetong(String item_id);
    void editHetong(Hetong hetong);

}

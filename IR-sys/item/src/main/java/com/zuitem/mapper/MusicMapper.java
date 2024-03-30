package com.zuitem.mapper;

import com.zuitem.domain.Music;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MusicMapper {
    List<Music> findAll();
}

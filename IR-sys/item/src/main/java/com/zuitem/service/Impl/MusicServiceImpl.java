package com.zuitem.service.Impl;

import com.zuitem.domain.Music;
import com.zuitem.mapper.MusicMapper;
import com.zuitem.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Override
    public List<Music> findAll() {
        return musicMapper.findAll();
    }
}

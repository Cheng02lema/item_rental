package com.zuitem.controller;

import com.zuitem.domain.util.Result;
import com.zuitem.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {
    @Autowired
    private MusicService service;

    @RequestMapping("/music")
    public Result getMusic(){
        return new Result(200,service.findAll(),"成功");
    }
}

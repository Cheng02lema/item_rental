package com.zuitem.service.Impl;

import com.zuitem.domain.Solve;
import com.zuitem.mapper.SolveMapper;
import com.zuitem.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolveServiceImpl implements SolveService {
    @Autowired
    private SolveMapper solveMapper;

    @Override
    public List<Solve> findAll(String search, String date, String date1) {
        return solveMapper.findAll(search, date, date1);
    }

    @Override
    public List<Solve> findAllByid(Integer id) {
        return solveMapper.findAllByid(id);
    }

    @Override
    public void addSolve(Solve solve) {
        solveMapper.addSolve(solve);
    }

    @Override
    public void delsolve(List<Integer> list) {
        solveMapper.delsolve(list);
    }
}

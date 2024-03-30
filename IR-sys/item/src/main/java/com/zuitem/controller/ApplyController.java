package com.zuitem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuitem.domain.*;
import com.zuitem.domain.util.Result;
import com.zuitem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class ApplyController {
    @Autowired
    private ApplyService ApplyService;
    @Autowired
    private UserlistService userlistService;
    @Autowired
    private ItemlistService itemlistService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ApplyoutService applyoutService;
    @Autowired
    private HetongService hetongService;

    @RequestMapping("/applylist")
    public PageInfo<Apply> selectAll(@RequestParam(defaultValue = "", value = "search") String search,
                                     @RequestParam(defaultValue = "1", value = "cur") int cur,
                                     @RequestParam(defaultValue = "10", value = "size") int size) {
        PageHelper.startPage(cur, size);
        List<Apply> apply = ApplyService.findAll(search);
        PageInfo<Apply> p = new PageInfo<>(apply);
        System.out.println(apply);
        return p;
    }

    /**
     * 申请看房
     *
     * @param httpSession
     * @return
     */
    @RequestMapping("/applycheckuserlist")
    public Result applycheckuserlist(HttpSession httpSession, @RequestBody Hetong hetong) {
        System.out.println(hetong);
        User user1 = (User) httpSession.getAttribute("user");
        Integer user_id = user1.getId();
        System.out.println(user1);
        System.out.println("itemid==>" + hetong.getItem_id());
        Userlist list = userlistService.findByUserid(user_id);
        System.out.println(list);
        if (list == null) {
            return new Result(201, "申请看房失败");
        } else {
            //新增合同信息
            hetongService.addHetong(hetong);
            // 申请看房
            Itemlist itemlist = itemlistService.findItem(Integer.parseInt(hetong.getItem_id()));
            itemlist.setStatus("申请中");
            itemlistService.editItem(itemlist);
            Apply apply = new Apply();
            apply.setItem_id(itemlist.getItemid());
            apply.setIname(itemlist.getIname());
            apply.setApply_date(new Date());
            apply.setPrice(hetong.getPrice());
            apply.setPhoto(itemlist.getPhoto());
            apply.setStatus("申请中");
            apply.setUser_id(user_id);
            applyService.addApply(apply);
            return new Result(200, "申请看房成功");
        }
    }

    /**
     * 拒绝租赁
     *
     * @param httpSession
     * @param itemid
     * @return
     */
    @RequestMapping("/Noapply")
    public Result Noapply(HttpSession httpSession, @RequestParam("item_id") String item_id) {
        System.out.println("item_id==>" + item_id);
        // 修改 房源 状态
        Itemlist itemlist = itemlistService.findItem(Integer.parseInt(item_id));
        itemlist.setStatus("未租赁");
        itemlistService.editItem(itemlist);
        // 删除 申请 列表
        applyService.deleteByItem_id(item_id);
        return new Result(200, "拒绝租赁成功");
    }

}

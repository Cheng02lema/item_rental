package com.zuitem.controller;

import com.zuitem.domain.*;
import com.zuitem.domain.util.Result;
import com.zuitem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HetongController {
    @Autowired
    private ItemlistService itemlistService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ZulistService zulistService;
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private HetongService hetongService;

    /**
     * 终止合同
     *
     * @return
     */
    @RequestMapping("/deletehetong")
    public Result DeleteHetong(@RequestParam("item_id") String item_id) {
        System.out.println("item_id==>" + item_id);
        //  通过 id 查找该房信息
        Zulist zulist = zulistService.findByItem_idZulist(item_id);
        if (zulist == null)
            new Result(201, "错误提交！");
        //  添加 到退租列表
        Checkout checkout = new Checkout();
        checkout.setItem_id(item_id);
        checkout.setIname(zulist.getIname());
        checkout.setStatus("已退租");
        checkout.setUser_id(zulist.getUser_id());
        checkoutService.addCheckout(checkout);
        // 修改 item表状态为 未租赁
        Itemlist itemlist = itemlistService.findItem(Integer.parseInt(item_id));
        itemlist.setStatus("未租赁");
        itemlistService.editItem(itemlist);
        // 删除 合同列表
        hetongService.delHetong(item_id);
        // 删除 租房列表
        zulistService.deleteByItem_id(item_id);
        return new Result(200, "成功");
    }

    /**
     * 同意租赁
     *
     * @param hetong
     * @return
     */
    @RequestMapping("/addhetong")
    public Result addhetong(@RequestBody Hetong hetong) {
        System.out.println(hetong);
        // 同意租赁
        Hetong findhetong = hetongService.findhetong(hetong.getItem_id());
        findhetong.setChuzu(hetong.getChuzu());
        findhetong.setChuzu_idcard(hetong.getChuzu_idcard());
        findhetong.setPrice(hetong.getPrice());
        findhetong.setPayday(hetong.getPayday());
        hetongService.editHetong(findhetong);
        //修改房屋列表状态
        Itemlist itemlist = itemlistService.findItem(Integer.parseInt(hetong.getItem_id()));
        itemlist.setStatus("已租赁");
        itemlistService.editItem(itemlist);
        //添加到租赁列表当中
        Zulist zulist = new Zulist();
        Hetong hetong1 = hetongService.findhetong(hetong.getItem_id());
        Apply apply = applyService.findByItem_id(hetong.getItem_id());
        System.out.println(apply);
        zulist.setItem_id(hetong.getItem_id());
        zulist.setUser_id(apply.getUser_id());
        zulist.setContract_id(hetong1.getId());
        zulist.setPrice(apply.getPrice());
        System.out.println(zulist);
        zulist.setIname(apply.getIname());
        zulistService.addzulist(zulist);
        //从申请列表中删除
        applyService.deleteByItem_id(hetong.getItem_id());
        return new Result(200, "成功");
    }

    @RequestMapping("/findHetong")
    public Result fidnHeong(@RequestParam("item_id") String item_id) {
        return new Result(200, hetongService.findhetong(item_id), "成功");
    }

    @RequestMapping("/edithetong")
    public Result edithetong(@RequestParam("item_id") String item_id) {
        Hetong findhetong = hetongService.findhetong(item_id);
        hetongService.editHetong(findhetong);
        return new Result(200, "成功");
    }
}

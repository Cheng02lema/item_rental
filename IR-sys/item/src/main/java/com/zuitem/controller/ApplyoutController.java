package com.zuitem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuitem.domain.*;
import com.zuitem.domain.util.Result;
import com.zuitem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplyoutController {
    @Autowired
    private ApplyoutService applyoutService;
    @Autowired
    private ItemlistService itemlistService;
    @Autowired
    private HetongService hetongService;
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private ZulistService zulistService;

    @RequestMapping("/applyout")
    public PageInfo<Applyout> selectAll(@RequestParam(defaultValue = "", value = "search") String search,
                                        @RequestParam(defaultValue = "1", value = "cur") int cur,
                                        @RequestParam(defaultValue = "10", value = "size") int size) {
        PageHelper.startPage(cur, size);
        List<Applyout> applyout = applyoutService.findAll(search);
        PageInfo<Applyout> p = new PageInfo<Applyout>(applyout);
        System.out.println(applyout);
        return p;
    }

    /**
     * 管理员同意退租申请
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/agreeapplyout")
    public Result agreeapplyout(@RequestParam("id") String id) {
        System.out.println("id==>" + id);
        // 修改 itemlist 状态 未租赁
        Applyout applyout = applyoutService.findByItem_idApplyout(id);
        Itemlist item = itemlistService.findItem(Integer.parseInt(applyout.getItem_id()));
        item.setStatus("未租赁");
        itemlistService.editItem(item);
        // 添加 已退租 列表
        Checkout checkout = new Checkout();
        checkout.setItem_id(applyout.getItem_id());
        checkout.setIname(applyout.getIname());
        checkout.setStatus("已退租");
        checkout.setUser_id(applyout.getUser_id());
        checkoutService.addCheckout(checkout);
        // 修改 退租 申请 ==> 已同意
        applyout.setStatus("已同意");
        applyoutService.updateapplyoutbyitem(applyout);
        // 删除 合同列表
        hetongService.delHetong(id);
        // 删除 已出租 列表
        zulistService.deleteByItem_id(applyout.getItem_id());
        return new Result(200, "成功^v^");
    }

    /**
     * 申请退租信息
     *

     * @param model
     * @return
     */
    @RequestMapping("/addApplyout")
    public Result insertapplyout(@RequestParam("item_id") String item_id) {
        System.out.println("addApplyout=》》》》》》》》》》》》》》》》》》》》》");
        System.out.println(item_id);
        Zulist zulist = zulistService.findByItem_idZulist(item_id);
        System.out.println(zulist);

        Applyout applyout = new Applyout();
        applyout.setItem_id(zulist.getItem_id());
        applyout.setIname(zulist.getIname());
        applyout.setStatus("申请中");
        applyout.setUser_id(zulist.getUser_id());
        System.out.println(applyout);

        applyoutService.addApplyout(applyout);
        return new Result(200, "申请成功");
    }

    /**
     * 拒绝退租

     * @return
     */
    @RequestMapping("/jujueApplyout")
    public Result jujueApplyout(@RequestParam("aoid") String aoid) {
        System.out.println("addApplyout=》》》》》》》》》》》》》》》》》》》》》");
        System.out.println(aoid);
        Applyout byItemIdApplyout = applyoutService.findByItem_idApplyout(aoid);
        byItemIdApplyout.setStatus("已拒绝");
        applyoutService.updateapplyoutbyitem(byItemIdApplyout);
        return new Result(200, "操作成功");
    }
    /**
     * 删除 退租列表
     *

     * @return
     */
    @RequestMapping("/delapplyout")
    public Result delapplyout(@RequestParam("item_id") String item_id) {
        System.out.println("item_id=》》》》》》》》》》》》》》》》》》》》》");
        System.out.println(item_id);
        // 删除 --退租列表
        applyoutService.delapplyout(item_id);
        return new Result(200, "申请成功");
    }
}

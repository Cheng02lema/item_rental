package com.zuitem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuitem.domain.Itemlist;
import com.zuitem.domain.util.Result;
import com.zuitem.service.ItemlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemlistController {
    @Autowired
    private ItemlistService itemSevice;

    /**
     * 查询所有 --并分页（插件）
     *
     * @param cur
     * @param size
     * @return
     */
    @RequestMapping("/itemlist")
    public PageInfo<Itemlist> selectAll(@RequestParam(defaultValue = "1", value = "cur") int cur, @RequestParam(defaultValue = "10", value = "size") int size,
                                        @RequestParam(defaultValue = "", value = "search") String search, @RequestParam(defaultValue = "", value = "select") String select) {
        System.out.println("search==>" + search);
        System.out.println("select==>" + select);
        PageHelper.startPage(cur, size);
        List<Itemlist> itemlist = itemSevice.selectAll(search, select);
        PageInfo<Itemlist> p = new PageInfo<>(itemlist);
        return p;
    }

    /**
     * 添加 物品
     *

     * @return
     */
    @RequestMapping("/additem")

    public Result addItem(@RequestBody Itemlist item) {
        if (itemSevice.findItem(Integer.parseInt(item.getItemid())) != null)
            return new Result(201, "添加失败");
        itemSevice.addItem(item);
        return new Result(200, "添加成功");

    }

    @RequestMapping("/edititem")

    public Result editItem(@RequestBody Itemlist item) {
        itemSevice.editItem(item);
        return new Result(200, "修改成功");
    }

    @RequestMapping("/deleteitem")
    public Result deleteItem(@RequestBody List<Integer> list) {
        System.out.println(list);
        itemSevice.deleteItem(list);
        return new Result(200, "删除成功");
    }
}

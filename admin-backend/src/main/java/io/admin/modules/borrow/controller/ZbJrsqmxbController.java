package io.admin.modules.borrow.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.admin.modules.borrow.entity.ZbJrsqmxbEntity;
import io.admin.modules.borrow.service.ZbJrsqmxbService;
import io.admin.common.utils.PageUtils;
import io.admin.common.utils.R;



/**
 * 
 *
 * @author Wangcaner
 * @email wangcaner@outlook.com
 * @date 2019-07-01 09:07:30
 */
@RestController
@RequestMapping("borrow/zbjrsqmxb")
public class ZbJrsqmxbController {
    @Autowired
    private ZbJrsqmxbService zbJrsqmxbService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("borrow:zbjrsqmxb:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = zbJrsqmxbService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("borrow:zbjrsqmxb:info")
    public R info(@PathVariable("id") Long id){
		ZbJrsqmxbEntity zbJrsqmxb = zbJrsqmxbService.selectById(id);

        return R.ok().put("zbJrsqmxb", zbJrsqmxb);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("borrow:zbjrsqmxb:save")
    public R save(@RequestBody ZbJrsqmxbEntity zbJrsqmxb){
		zbJrsqmxbService.insert(zbJrsqmxb);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("borrow:zbjrsqmxb:update")
    public R update(@RequestBody ZbJrsqmxbEntity zbJrsqmxb){
		zbJrsqmxbService.updateById(zbJrsqmxb);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("borrow:zbjrsqmxb:delete")
    public R delete(@RequestBody Long[] ids){
		zbJrsqmxbService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}

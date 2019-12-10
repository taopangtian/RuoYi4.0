package com.backstage.web.controller.owl;

import com.backstage.common.config.Global;
import com.backstage.common.core.controller.BaseController;
import com.backstage.framework.util.ShiroUtils;
import com.backstage.system.domain.SysMenu;
import com.backstage.system.domain.SysUser;
import com.backstage.system.service.ISysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设置 业务处理
 *
 * @author jack.lin
 */
@Controller
public class OwlSetupController extends BaseController {
    private String prefix = "owl/setup";

    @Autowired
    private ISysMenuService sysMenuService;

    // 设置
    @RequiresPermissions("owl:setup:view")
    @GetMapping(value = "/owl/setup")
    public String setup(Long menuId, ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        //System.out.println("设置页面   "+menuId);
        List<SysMenu> menus = sysMenuService.selectMenusById(menuId);
        //System.out.println(menus.get(1).getMenuName());
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        mmap.put("version", Global.getVersion());
        return prefix+"/setup";
    }
}

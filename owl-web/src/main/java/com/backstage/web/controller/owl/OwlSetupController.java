package com.backstage.web.controller.owl;

import com.backstage.common.config.Global;
import com.backstage.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 设置 业务处理
 *
 * @author jack.lin
 */
@Controller
public class OwlSetupController extends BaseController {
    private String prefix = "owl/setup";
    // 设置
    @RequiresPermissions("owl:setup:view")
    @GetMapping("/owl/setup")
    public String setup(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return prefix+"/setup";
    }
}

package com.backstage.web.controller.owl;

import com.backstage.common.config.Global;
import com.backstage.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 审计报警 业务处理
 *
 * @author jack.lin
 */
@Controller
public class OwlStrategyController  extends BaseController {
    private String prefix = "owl/strategy";
    // 审计报警
    @RequiresPermissions("owl:strategy:view")
    @GetMapping("/owl/strategy")
    public String strategy(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return prefix+"/strategy";
    }
}

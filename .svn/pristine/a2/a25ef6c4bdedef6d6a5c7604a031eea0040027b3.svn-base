package com.backstage.web.controller.owl;

import com.backstage.common.config.Global;
import com.backstage.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 统计分析 业务处理
 *
 * @author jack.lin
 */
@Controller
public class OwlStatisticController extends BaseController {
    private String prefix = "owl/statistics";
    // 统计分析
    @RequiresPermissions("owl:statistics:view")
    @GetMapping("/owl/statistics")
    public String statistics(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return prefix+"/statistics";
    }
}

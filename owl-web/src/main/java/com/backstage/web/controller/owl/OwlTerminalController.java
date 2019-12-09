package com.backstage.web.controller.owl;

import com.backstage.common.config.Global;
import com.backstage.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 终端管理 业务处理
 *
 * @author jack.lin
 */
@Controller
public class OwlTerminalController extends BaseController {

    private String prefix = "owl/terminal";
    // 终端管理
    @RequiresPermissions("owl:terminal:view")
    @GetMapping("/owl/terminal")
    public String statistics(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return prefix+"/terminal";
    }
}

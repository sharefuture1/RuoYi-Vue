package com.ruoyi.wh.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wh.domain.WhZyy21;
import com.ruoyi.wh.service.IWhZyy21Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * billsController
 * 
 * @author young1
 * @date 2023-08-07
 */
@RestController
@RequestMapping("/wh/zyy21")
public class WhZyy21Controller extends BaseController
{
    @Autowired
    private IWhZyy21Service whZyy21Service;

    /**
     * 查询bills列表
     */
    @PreAuthorize("@ss.hasPermi('wh:zyy21:list')")
    @GetMapping("/list")
    public TableDataInfo list(WhZyy21 whZyy21)
    {
        startPage();
        List<WhZyy21> list = whZyy21Service.selectWhZyy21List(whZyy21);
        return getDataTable(list);
    }

    /**
     * 导出bills列表
     */
    @PreAuthorize("@ss.hasPermi('wh:zyy21:export')")
    @Log(title = "bills", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WhZyy21 whZyy21)
    {
        List<WhZyy21> list = whZyy21Service.selectWhZyy21List(whZyy21);
        ExcelUtil<WhZyy21> util = new ExcelUtil<WhZyy21>(WhZyy21.class);
        util.exportExcel(response, list, "bills数据");
    }

    /**
     * 获取bills详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:zyy21:query')")
    @GetMapping(value = "/{日期}")
    public AjaxResult getInfo(@PathVariable("日期") String 日期)
    {
        return AjaxResult.success(whZyy21Service.selectWhZyy21By日期(日期));
    }

    /**
     * 新增bills
     */
    @PreAuthorize("@ss.hasPermi('wh:zyy21:add')")
    @Log(title = "bills", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WhZyy21 whZyy21)
    {
        return toAjax(whZyy21Service.insertWhZyy21(whZyy21));
    }

    /**
     * 修改bills
     */
    @PreAuthorize("@ss.hasPermi('wh:zyy21:edit')")
    @Log(title = "bills", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WhZyy21 whZyy21)
    {
        return toAjax(whZyy21Service.updateWhZyy21(whZyy21));
    }

    /**
     * 删除bills
     */
    @PreAuthorize("@ss.hasPermi('wh:zyy21:remove')")
    @Log(title = "bills", businessType = BusinessType.DELETE)
	@DeleteMapping("/{日期s}")
    public AjaxResult remove(@PathVariable String[] 日期s)
    {
        return toAjax(whZyy21Service.deleteWhZyy21By日期s(日期s));
    }
}

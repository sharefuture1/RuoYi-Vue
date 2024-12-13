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
import com.ruoyi.wh.domain.Aaprintersinfo;
import com.ruoyi.wh.service.IAaprintersinfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打印机信息查询Controller
 * 
 * @author young1
 * @date 2024-12-14
 */
@RestController
@RequestMapping("/wh/aaprintersinfo")
public class AaprintersinfoController extends BaseController
{
    @Autowired
    private IAaprintersinfoService aaprintersinfoService;

    /**
     * 查询打印机信息查询列表
     */
    @PreAuthorize("@ss.hasPermi('wh:aaprintersinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(Aaprintersinfo aaprintersinfo)
    {
        startPage();
        List<Aaprintersinfo> list = aaprintersinfoService.selectAaprintersinfoList(aaprintersinfo);
        return getDataTable(list);
    }

    /**
     * 导出打印机信息查询列表
     */
    @PreAuthorize("@ss.hasPermi('wh:aaprintersinfo:export')")
    @Log(title = "打印机信息查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Aaprintersinfo aaprintersinfo)
    {
        List<Aaprintersinfo> list = aaprintersinfoService.selectAaprintersinfoList(aaprintersinfo);
        ExcelUtil<Aaprintersinfo> util = new ExcelUtil<Aaprintersinfo>(Aaprintersinfo.class);
        util.exportExcel(response, list, "打印机信息查询数据");
    }

    /**
     * 获取打印机信息查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:aaprintersinfo:query')")
    @GetMapping(value = "/{printerid}")
    public AjaxResult getInfo(@PathVariable("printerid") Integer printerid)
    {
        return AjaxResult.success(aaprintersinfoService.selectAaprintersinfoByPrinterid(printerid));
    }

    /**
     * 新增打印机信息查询
     */
    @PreAuthorize("@ss.hasPermi('wh:aaprintersinfo:add')")
    @Log(title = "打印机信息查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Aaprintersinfo aaprintersinfo)
    {
        return toAjax(aaprintersinfoService.insertAaprintersinfo(aaprintersinfo));
    }

    /**
     * 修改打印机信息查询
     */
    @PreAuthorize("@ss.hasPermi('wh:aaprintersinfo:edit')")
    @Log(title = "打印机信息查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Aaprintersinfo aaprintersinfo)
    {
        return toAjax(aaprintersinfoService.updateAaprintersinfo(aaprintersinfo));
    }

    /**
     * 删除打印机信息查询
     */
    @PreAuthorize("@ss.hasPermi('wh:aaprintersinfo:remove')")
    @Log(title = "打印机信息查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{printerids}")
    public AjaxResult remove(@PathVariable Integer[] printerids)
    {
        return toAjax(aaprintersinfoService.deleteAaprintersinfoByPrinterids(printerids));
    }
}

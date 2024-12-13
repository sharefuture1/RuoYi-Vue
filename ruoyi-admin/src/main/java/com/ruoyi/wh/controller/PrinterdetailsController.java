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
import com.ruoyi.wh.domain.Printerdetails;
import com.ruoyi.wh.service.IPrinterdetailsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * printerdetailsController
 * 
 * @author young1
 * @date 2024-12-12
 */
@RestController
@RequestMapping("/wh/printerdetails")
public class PrinterdetailsController extends BaseController
{
    @Autowired
    private IPrinterdetailsService printerdetailsService;

    /**
     * 查询printerdetails列表
     */
    @PreAuthorize("@ss.hasPermi('wh:printerdetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(Printerdetails printerdetails)
    {
        startPage();
        List<Printerdetails> list = printerdetailsService.selectPrinterdetailsList(printerdetails);
        return getDataTable(list);
    }

    /**
     * 导出printerdetails列表
     */
    @PreAuthorize("@ss.hasPermi('wh:printerdetails:export')")
    @Log(title = "printerdetails", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Printerdetails printerdetails)
    {
        List<Printerdetails> list = printerdetailsService.selectPrinterdetailsList(printerdetails);
        ExcelUtil<Printerdetails> util = new ExcelUtil<Printerdetails>(Printerdetails.class);
        util.exportExcel(response, list, "printerdetails数据");
    }

    /**
     * 获取printerdetails详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:printerdetails:query')")
    @GetMapping(value = "/{printerid}")
    public AjaxResult getInfo(@PathVariable("printerid") Long printerid)
    {
        return AjaxResult.success(printerdetailsService.selectPrinterdetailsByPrinterid(printerid));
    }

    /**
     * 新增printerdetails
     */
    @PreAuthorize("@ss.hasPermi('wh:printerdetails:add')")
    @Log(title = "printerdetails", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Printerdetails printerdetails)
    {
        return toAjax(printerdetailsService.insertPrinterdetails(printerdetails));
    }

    /**
     * 修改printerdetails
     */
    @PreAuthorize("@ss.hasPermi('wh:printerdetails:edit')")
    @Log(title = "printerdetails", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Printerdetails printerdetails)
    {
        return toAjax(printerdetailsService.updatePrinterdetails(printerdetails));
    }

    /**
     * 删除printerdetails
     */
    @PreAuthorize("@ss.hasPermi('wh:printerdetails:remove')")
    @Log(title = "printerdetails", businessType = BusinessType.DELETE)
	@DeleteMapping("/{printerids}")
    public AjaxResult remove(@PathVariable Long[] printerids)
    {
        return toAjax(printerdetailsService.deletePrinterdetailsByPrinterids(printerids));
    }
}

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
import com.ruoyi.wh.domain.WhBills;
import com.ruoyi.wh.service.IWhBillsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * billsController
 * 
 * @author young1
 * @date 2023-05-30
 */
@RestController
@RequestMapping("/wh/bills")
public class WhBillsController extends BaseController
{
    @Autowired
    private IWhBillsService whBillsService;

    /**
     * 查询bills列表
     */
    @PreAuthorize("@ss.hasPermi('wh:bills:list')")
    @GetMapping("/list")
    public TableDataInfo list(WhBills whBills)
    {
        startPage();
        List<WhBills> list = whBillsService.selectWhBillsList(whBills);
        return getDataTable(list);
    }

    /**
     * 导出bills列表
     */
    @PreAuthorize("@ss.hasPermi('wh:bills:export')")
    @Log(title = "bills", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WhBills whBills)
    {
        List<WhBills> list = whBillsService.selectWhBillsList(whBills);
        ExcelUtil<WhBills> util = new ExcelUtil<WhBills>(WhBills.class);
        util.exportExcel(response, list, "bills数据");
    }

    /**
     * 获取bills详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:bills:query')")
    @GetMapping(value = "/{date}")
    public AjaxResult getInfo(@PathVariable("date") String date)
    {
        return AjaxResult.success(whBillsService.selectWhBillsByDate(date));
    }

    /**
     * 新增bills
     */
    @PreAuthorize("@ss.hasPermi('wh:bills:add')")
    @Log(title = "bills", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WhBills whBills)
    {
        return toAjax(whBillsService.insertWhBills(whBills));
    }

    /**
     * 修改bills
     */
    @PreAuthorize("@ss.hasPermi('wh:bills:edit')")
    @Log(title = "bills", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WhBills whBills)
    {
        return toAjax(whBillsService.updateWhBills(whBills));
    }

    /**
     * 删除bills
     */
    @PreAuthorize("@ss.hasPermi('wh:bills:remove')")
    @Log(title = "bills", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dates}")
    public AjaxResult remove(@PathVariable String[] dates)
    {
        return toAjax(whBillsService.deleteWhBillsByDates(dates));
    }
}

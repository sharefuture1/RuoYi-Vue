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
import com.ruoyi.wh.domain.Aorgasset;
import com.ruoyi.wh.service.IAorgassetService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打印机资产查询Controller
 * 
 * @author young1
 * @date 2024-12-14
 */
@RestController
@RequestMapping("/wh/aorgasset")
public class AorgassetController extends BaseController
{
    @Autowired
    private IAorgassetService aorgassetService;

    /**
     * 查询打印机资产查询列表
     */
    @PreAuthorize("@ss.hasPermi('wh:aorgasset:list')")
    @GetMapping("/list")
    public TableDataInfo list(Aorgasset aorgasset)
    {
        startPage();
        List<Aorgasset> list = aorgassetService.selectAorgassetList(aorgasset);
        return getDataTable(list);
    }

    /**
     * 导出打印机资产查询列表
     */
    @PreAuthorize("@ss.hasPermi('wh:aorgasset:export')")
    @Log(title = "打印机资产查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Aorgasset aorgasset)
    {
        List<Aorgasset> list = aorgassetService.selectAorgassetList(aorgasset);
        ExcelUtil<Aorgasset> util = new ExcelUtil<Aorgasset>(Aorgasset.class);
        util.exportExcel(response, list, "打印机资产查询数据");
    }

    /**
     * 获取打印机资产查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:aorgasset:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(aorgassetService.selectAorgassetById(id));
    }

    /**
     * 新增打印机资产查询
     */
    @PreAuthorize("@ss.hasPermi('wh:aorgasset:add')")
    @Log(title = "打印机资产查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Aorgasset aorgasset)
    {
        return toAjax(aorgassetService.insertAorgasset(aorgasset));
    }

    /**
     * 修改打印机资产查询
     */
    @PreAuthorize("@ss.hasPermi('wh:aorgasset:edit')")
    @Log(title = "打印机资产查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Aorgasset aorgasset)
    {
        return toAjax(aorgassetService.updateAorgasset(aorgasset));
    }

    /**
     * 删除打印机资产查询
     */
    @PreAuthorize("@ss.hasPermi('wh:aorgasset:remove')")
    @Log(title = "打印机资产查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(aorgassetService.deleteAorgassetByIds(ids));
    }
}

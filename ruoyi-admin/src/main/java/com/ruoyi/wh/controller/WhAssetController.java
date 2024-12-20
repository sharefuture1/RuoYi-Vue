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
import com.ruoyi.wh.domain.WhAsset;
import com.ruoyi.wh.service.IWhAssetService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author young1
 * @date 2023-05-30
 */
@RestController
@RequestMapping("/wh/asset")
public class WhAssetController extends BaseController
{
    @Autowired
    private IWhAssetService whAssetService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('wh:asset:list')")
    @GetMapping("/list")
    public TableDataInfo list(WhAsset whAsset)
    {
        startPage();
        List<WhAsset> list = whAssetService.selectWhAssetList(whAsset);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('wh:asset:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WhAsset whAsset)
    {
        List<WhAsset> list = whAssetService.selectWhAssetList(whAsset);
        ExcelUtil<WhAsset> util = new ExcelUtil<WhAsset>(WhAsset.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:asset:query')")
    @GetMapping(value = "/{assetid}")
    public AjaxResult getInfo(@PathVariable("assetid") Long assetid)
    {
        return AjaxResult.success(whAssetService.selectWhAssetByAssetid(assetid));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('wh:asset:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WhAsset whAsset)
    {
        return toAjax(whAssetService.insertWhAsset(whAsset));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('wh:asset:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WhAsset whAsset)
    {
        return toAjax(whAssetService.updateWhAsset(whAsset));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('wh:asset:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{assetids}")
    public AjaxResult remove(@PathVariable Long[] assetids)
    {
        return toAjax(whAssetService.deleteWhAssetByAssetids(assetids));
    }
}

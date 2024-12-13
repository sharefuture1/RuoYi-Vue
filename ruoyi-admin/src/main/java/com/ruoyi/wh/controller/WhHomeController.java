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
import com.ruoyi.wh.domain.WhHome;
import com.ruoyi.wh.service.IWhHomeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * homeController
 * 
 * @author young1
 * @date 2023-05-30
 */
@RestController
@RequestMapping("/wh/home")
public class WhHomeController extends BaseController
{
    @Autowired
    private IWhHomeService whHomeService;

    /**
     * 查询home列表
     */
    @PreAuthorize("@ss.hasPermi('wh:home:list')")
    @GetMapping("/list")
    public TableDataInfo list(WhHome whHome)
    {
        startPage();
        List<WhHome> list = whHomeService.selectWhHomeList(whHome);
        return getDataTable(list);
    }

    /**
     * 导出home列表
     */
    @PreAuthorize("@ss.hasPermi('wh:home:export')")
    @Log(title = "home", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WhHome whHome)
    {
        List<WhHome> list = whHomeService.selectWhHomeList(whHome);
        ExcelUtil<WhHome> util = new ExcelUtil<WhHome>(WhHome.class);
        util.exportExcel(response, list, "home数据");
    }

    /**
     * 获取home详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:home:query')")
    @GetMapping(value = "/{taskid}")
    public AjaxResult getInfo(@PathVariable("taskid") Long taskid)
    {
        return AjaxResult.success(whHomeService.selectWhHomeByTaskid(taskid));
    }

    /**
     * 新增home
     */
    @PreAuthorize("@ss.hasPermi('wh:home:add')")
    @Log(title = "home", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WhHome whHome)
    {
        return toAjax(whHomeService.insertWhHome(whHome));
    }

    /**
     * 修改home
     */
    @PreAuthorize("@ss.hasPermi('wh:home:edit')")
    @Log(title = "home", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WhHome whHome)
    {
        return toAjax(whHomeService.updateWhHome(whHome));
    }

    /**
     * 删除home
     */
    @PreAuthorize("@ss.hasPermi('wh:home:remove')")
    @Log(title = "home", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskids}")
    public AjaxResult remove(@PathVariable Long[] taskids)
    {
        return toAjax(whHomeService.deleteWhHomeByTaskids(taskids));
    }
}

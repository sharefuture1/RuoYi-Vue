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
import com.ruoyi.wh.domain.WhDaily;
import com.ruoyi.wh.service.IWhDailyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 每日任务信息Controller
 * 
 * @author young1
 * @date 2023-03-04
 */
@RestController
@RequestMapping("/wh/daily")
public class WhDailyController extends BaseController
{
    @Autowired
    private IWhDailyService whDailyService;

    /**
     * 查询每日任务信息列表
     */
    @PreAuthorize("@ss.hasPermi('wh:daily:list')")
    @GetMapping("/list")
    public TableDataInfo list(WhDaily whDaily)
    {
        startPage();
        List<WhDaily> list = whDailyService.selectWhDailyList(whDaily);
        return getDataTable(list);
    }

    /**
     * 导出每日任务信息列表
     */
    @PreAuthorize("@ss.hasPermi('wh:daily:export')")
    @Log(title = "每日任务信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WhDaily whDaily)
    {
        List<WhDaily> list = whDailyService.selectWhDailyList(whDaily);
        ExcelUtil<WhDaily> util = new ExcelUtil<WhDaily>(WhDaily.class);
        util.exportExcel(response, list, "每日任务信息数据");
    }

    /**
     * 获取每日任务信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:daily:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return AjaxResult.success(whDailyService.selectWhDailyByTaskId(taskId));
    }

    /**
     * 新增每日任务信息
     */
    @PreAuthorize("@ss.hasPermi('wh:daily:add')")
    @Log(title = "每日任务信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WhDaily whDaily)
    {
        return toAjax(whDailyService.insertWhDaily(whDaily));
    }

    /**
     * 修改每日任务信息
     */
    @PreAuthorize("@ss.hasPermi('wh:daily:edit')")
    @Log(title = "每日任务信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WhDaily whDaily)
    {
        return toAjax(whDailyService.updateWhDaily(whDaily));
    }

    /**
     * 删除每日任务信息
     */
    @PreAuthorize("@ss.hasPermi('wh:daily:remove')")
    @Log(title = "每日任务信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(whDailyService.deleteWhDailyByTaskIds(taskIds));
    }
}

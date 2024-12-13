package com.ruoyi.wh.service;

import java.util.List;
import com.ruoyi.wh.domain.WhDaily;

/**
 * 每日任务信息Service接口
 * 
 * @author young1
 * @date 2023-03-04
 */
public interface IWhDailyService 
{
    /**
     * 查询每日任务信息
     * 
     * @param taskId 每日任务信息主键
     * @return 每日任务信息
     */
    public WhDaily selectWhDailyByTaskId(Long taskId);

    /**
     * 查询每日任务信息列表
     * 
     * @param whDaily 每日任务信息
     * @return 每日任务信息集合
     */
    public List<WhDaily> selectWhDailyList(WhDaily whDaily);

    /**
     * 新增每日任务信息
     * 
     * @param whDaily 每日任务信息
     * @return 结果
     */
    public int insertWhDaily(WhDaily whDaily);

    /**
     * 修改每日任务信息
     * 
     * @param whDaily 每日任务信息
     * @return 结果
     */
    public int updateWhDaily(WhDaily whDaily);

    /**
     * 批量删除每日任务信息
     * 
     * @param taskIds 需要删除的每日任务信息主键集合
     * @return 结果
     */
    public int deleteWhDailyByTaskIds(Long[] taskIds);

    /**
     * 删除每日任务信息信息
     * 
     * @param taskId 每日任务信息主键
     * @return 结果
     */
    public int deleteWhDailyByTaskId(Long taskId);
}

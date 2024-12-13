package com.ruoyi.wh.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.WhDailyMapper;
import com.ruoyi.wh.domain.WhDaily;
import com.ruoyi.wh.service.IWhDailyService;

/**
 * 每日任务信息Service业务层处理
 * 
 * @author young1
 * @date 2023-03-04
 */
@Service
public class WhDailyServiceImpl implements IWhDailyService 
{
    @Autowired
    private WhDailyMapper whDailyMapper;

    /**
     * 查询每日任务信息
     * 
     * @param taskId 每日任务信息主键
     * @return 每日任务信息
     */
    @Override
    public WhDaily selectWhDailyByTaskId(Long taskId)
    {
        return whDailyMapper.selectWhDailyByTaskId(taskId);
    }

    /**
     * 查询每日任务信息列表
     * 
     * @param whDaily 每日任务信息
     * @return 每日任务信息
     */
    @Override
    public List<WhDaily> selectWhDailyList(WhDaily whDaily)
    {
        return whDailyMapper.selectWhDailyList(whDaily);
    }

    /**
     * 新增每日任务信息
     * 
     * @param whDaily 每日任务信息
     * @return 结果
     */
    @Override
    public int insertWhDaily(WhDaily whDaily)
    {
        whDaily.setCreateTime(DateUtils.getNowDate());
        return whDailyMapper.insertWhDaily(whDaily);
    }

    /**
     * 修改每日任务信息
     * 
     * @param whDaily 每日任务信息
     * @return 结果
     */
    @Override
    public int updateWhDaily(WhDaily whDaily)
    {
        whDaily.setUpdateTime(DateUtils.getNowDate());
        return whDailyMapper.updateWhDaily(whDaily);
    }

    /**
     * 批量删除每日任务信息
     * 
     * @param taskIds 需要删除的每日任务信息主键
     * @return 结果
     */
    @Override
    public int deleteWhDailyByTaskIds(Long[] taskIds)
    {
        return whDailyMapper.deleteWhDailyByTaskIds(taskIds);
    }

    /**
     * 删除每日任务信息信息
     * 
     * @param taskId 每日任务信息主键
     * @return 结果
     */
    @Override
    public int deleteWhDailyByTaskId(Long taskId)
    {
        return whDailyMapper.deleteWhDailyByTaskId(taskId);
    }
}

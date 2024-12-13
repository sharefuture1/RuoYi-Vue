package com.ruoyi.wh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.WhHomeMapper;
import com.ruoyi.wh.domain.WhHome;
import com.ruoyi.wh.service.IWhHomeService;

/**
 * homeService业务层处理
 * 
 * @author young1
 * @date 2023-05-30
 */
@Service
public class WhHomeServiceImpl implements IWhHomeService 
{
    @Autowired
    private WhHomeMapper whHomeMapper;

    /**
     * 查询home
     * 
     * @param taskid home主键
     * @return home
     */
    @Override
    public WhHome selectWhHomeByTaskid(Long taskid)
    {
        return whHomeMapper.selectWhHomeByTaskid(taskid);
    }

    /**
     * 查询home列表
     * 
     * @param whHome home
     * @return home
     */
    @Override
    public List<WhHome> selectWhHomeList(WhHome whHome)
    {
        return whHomeMapper.selectWhHomeList(whHome);
    }

    /**
     * 新增home
     * 
     * @param whHome home
     * @return 结果
     */
    @Override
    public int insertWhHome(WhHome whHome)
    {
        return whHomeMapper.insertWhHome(whHome);
    }

    /**
     * 修改home
     * 
     * @param whHome home
     * @return 结果
     */
    @Override
    public int updateWhHome(WhHome whHome)
    {
        return whHomeMapper.updateWhHome(whHome);
    }

    /**
     * 批量删除home
     * 
     * @param taskids 需要删除的home主键
     * @return 结果
     */
    @Override
    public int deleteWhHomeByTaskids(Long[] taskids)
    {
        return whHomeMapper.deleteWhHomeByTaskids(taskids);
    }

    /**
     * 删除home信息
     * 
     * @param taskid home主键
     * @return 结果
     */
    @Override
    public int deleteWhHomeByTaskid(Long taskid)
    {
        return whHomeMapper.deleteWhHomeByTaskid(taskid);
    }
}

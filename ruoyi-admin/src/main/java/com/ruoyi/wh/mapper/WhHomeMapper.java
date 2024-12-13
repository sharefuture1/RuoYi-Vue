package com.ruoyi.wh.mapper;

import java.util.List;
import com.ruoyi.wh.domain.WhHome;

/**
 * homeMapper接口
 * 
 * @author young1
 * @date 2023-05-30
 */
public interface WhHomeMapper 
{
    /**
     * 查询home
     * 
     * @param taskid home主键
     * @return home
     */
    public WhHome selectWhHomeByTaskid(Long taskid);

    /**
     * 查询home列表
     * 
     * @param whHome home
     * @return home集合
     */
    public List<WhHome> selectWhHomeList(WhHome whHome);

    /**
     * 新增home
     * 
     * @param whHome home
     * @return 结果
     */
    public int insertWhHome(WhHome whHome);

    /**
     * 修改home
     * 
     * @param whHome home
     * @return 结果
     */
    public int updateWhHome(WhHome whHome);

    /**
     * 删除home
     * 
     * @param taskid home主键
     * @return 结果
     */
    public int deleteWhHomeByTaskid(Long taskid);

    /**
     * 批量删除home
     * 
     * @param taskids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWhHomeByTaskids(Long[] taskids);
}

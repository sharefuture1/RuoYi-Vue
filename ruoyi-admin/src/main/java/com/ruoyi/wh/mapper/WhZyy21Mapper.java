package com.ruoyi.wh.mapper;

import java.util.List;
import com.ruoyi.wh.domain.WhZyy21;

/**
 * billsMapper接口
 * 
 * @author young1
 * @date 2023-08-07
 */
public interface WhZyy21Mapper 
{
    /**
     * 查询bills
     * 
     * @param 日期 bills主键
     * @return bills
     */
    public WhZyy21 selectWhZyy21By日期(String 日期);

    /**
     * 查询bills列表
     * 
     * @param whZyy21 bills
     * @return bills集合
     */
    public List<WhZyy21> selectWhZyy21List(WhZyy21 whZyy21);

    /**
     * 新增bills
     * 
     * @param whZyy21 bills
     * @return 结果
     */
    public int insertWhZyy21(WhZyy21 whZyy21);

    /**
     * 修改bills
     * 
     * @param whZyy21 bills
     * @return 结果
     */
    public int updateWhZyy21(WhZyy21 whZyy21);

    /**
     * 删除bills
     * 
     * @param 日期 bills主键
     * @return 结果
     */
    public int deleteWhZyy21By日期(String 日期);

    /**
     * 批量删除bills
     * 
     * @param 日期s 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWhZyy21By日期s(String[] 日期s);
}
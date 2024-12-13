package com.ruoyi.wh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.WhZyy21Mapper;
import com.ruoyi.wh.domain.WhZyy21;
import com.ruoyi.wh.service.IWhZyy21Service;

/**
 * billsService业务层处理
 * 
 * @author young1
 * @date 2023-08-07
 */
@Service
public class WhZyy21ServiceImpl implements IWhZyy21Service 
{
    @Autowired
    private WhZyy21Mapper whZyy21Mapper;

    /**
     * 查询bills
     * 
     * @param 日期 bills主键
     * @return bills
     */
    @Override
    public WhZyy21 selectWhZyy21By日期(String 日期)
    {
        return whZyy21Mapper.selectWhZyy21By日期(日期);
    }

    /**
     * 查询bills列表
     * 
     * @param whZyy21 bills
     * @return bills
     */
    @Override
    public List<WhZyy21> selectWhZyy21List(WhZyy21 whZyy21)
    {
        return whZyy21Mapper.selectWhZyy21List(whZyy21);
    }

    /**
     * 新增bills
     * 
     * @param whZyy21 bills
     * @return 结果
     */
    @Override
    public int insertWhZyy21(WhZyy21 whZyy21)
    {
        return whZyy21Mapper.insertWhZyy21(whZyy21);
    }

    /**
     * 修改bills
     * 
     * @param whZyy21 bills
     * @return 结果
     */
    @Override
    public int updateWhZyy21(WhZyy21 whZyy21)
    {
        return whZyy21Mapper.updateWhZyy21(whZyy21);
    }

    /**
     * 批量删除bills
     * 
     * @param 日期s 需要删除的bills主键
     * @return 结果
     */
    @Override
    public int deleteWhZyy21By日期s(String[] 日期s)
    {
        return whZyy21Mapper.deleteWhZyy21By日期s(日期s);
    }

    /**
     * 删除bills信息
     * 
     * @param 日期 bills主键
     * @return 结果
     */
    @Override
    public int deleteWhZyy21By日期(String 日期)
    {
        return whZyy21Mapper.deleteWhZyy21By日期(日期);
    }
}

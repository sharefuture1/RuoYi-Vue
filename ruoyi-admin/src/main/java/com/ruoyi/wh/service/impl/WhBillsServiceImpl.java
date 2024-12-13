package com.ruoyi.wh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.WhBillsMapper;
import com.ruoyi.wh.domain.WhBills;
import com.ruoyi.wh.service.IWhBillsService;

/**
 * billsService业务层处理
 * 
 * @author young1
 * @date 2023-05-30
 */
@Service
public class WhBillsServiceImpl implements IWhBillsService 
{
    @Autowired
    private WhBillsMapper whBillsMapper;

    /**
     * 查询bills
     * 
     * @param date bills主键
     * @return bills
     */
    @Override
    public WhBills selectWhBillsByDate(String date)
    {
        return whBillsMapper.selectWhBillsByDate(date);
    }

    /**
     * 查询bills列表
     * 
     * @param whBills bills
     * @return bills
     */
    @Override
    public List<WhBills> selectWhBillsList(WhBills whBills)
    {
        return whBillsMapper.selectWhBillsList(whBills);
    }

    /**
     * 新增bills
     * 
     * @param whBills bills
     * @return 结果
     */
    @Override
    public int insertWhBills(WhBills whBills)
    {
        return whBillsMapper.insertWhBills(whBills);
    }

    /**
     * 修改bills
     * 
     * @param whBills bills
     * @return 结果
     */
    @Override
    public int updateWhBills(WhBills whBills)
    {
        return whBillsMapper.updateWhBills(whBills);
    }

    /**
     * 批量删除bills
     * 
     * @param dates 需要删除的bills主键
     * @return 结果
     */
    @Override
    public int deleteWhBillsByDates(String[] dates)
    {
        return whBillsMapper.deleteWhBillsByDates(dates);
    }

    /**
     * 删除bills信息
     * 
     * @param date bills主键
     * @return 结果
     */
    @Override
    public int deleteWhBillsByDate(String date)
    {
        return whBillsMapper.deleteWhBillsByDate(date);
    }
}

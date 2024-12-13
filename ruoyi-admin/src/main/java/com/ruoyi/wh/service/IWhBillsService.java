package com.ruoyi.wh.service;

import java.util.List;
import com.ruoyi.wh.domain.WhBills;

/**
 * billsService接口
 * 
 * @author young1
 * @date 2023-05-30
 */
public interface IWhBillsService 
{
    /**
     * 查询bills
     * 
     * @param date bills主键
     * @return bills
     */
    public WhBills selectWhBillsByDate(String date);

    /**
     * 查询bills列表
     * 
     * @param whBills bills
     * @return bills集合
     */
    public List<WhBills> selectWhBillsList(WhBills whBills);

    /**
     * 新增bills
     * 
     * @param whBills bills
     * @return 结果
     */
    public int insertWhBills(WhBills whBills);

    /**
     * 修改bills
     * 
     * @param whBills bills
     * @return 结果
     */
    public int updateWhBills(WhBills whBills);

    /**
     * 批量删除bills
     * 
     * @param dates 需要删除的bills主键集合
     * @return 结果
     */
    public int deleteWhBillsByDates(String[] dates);

    /**
     * 删除bills信息
     * 
     * @param date bills主键
     * @return 结果
     */
    public int deleteWhBillsByDate(String date);
}

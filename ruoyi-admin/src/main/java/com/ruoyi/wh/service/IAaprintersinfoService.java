package com.ruoyi.wh.service;

import java.util.List;
import com.ruoyi.wh.domain.Aaprintersinfo;

/**
 * 打印机信息查询Service接口
 * 
 * @author young1
 * @date 2024-12-14
 */
public interface IAaprintersinfoService 
{
    /**
     * 查询打印机信息查询
     * 
     * @param printerid 打印机信息查询主键
     * @return 打印机信息查询
     */
    public Aaprintersinfo selectAaprintersinfoByPrinterid(Integer printerid);

    /**
     * 查询打印机信息查询列表
     * 
     * @param aaprintersinfo 打印机信息查询
     * @return 打印机信息查询集合
     */
    public List<Aaprintersinfo> selectAaprintersinfoList(Aaprintersinfo aaprintersinfo);

    /**
     * 新增打印机信息查询
     * 
     * @param aaprintersinfo 打印机信息查询
     * @return 结果
     */
    public int insertAaprintersinfo(Aaprintersinfo aaprintersinfo);

    /**
     * 修改打印机信息查询
     * 
     * @param aaprintersinfo 打印机信息查询
     * @return 结果
     */
    public int updateAaprintersinfo(Aaprintersinfo aaprintersinfo);

    /**
     * 批量删除打印机信息查询
     * 
     * @param printerids 需要删除的打印机信息查询主键集合
     * @return 结果
     */
    public int deleteAaprintersinfoByPrinterids(Integer[] printerids);

    /**
     * 删除打印机信息查询信息
     * 
     * @param printerid 打印机信息查询主键
     * @return 结果
     */
    public int deleteAaprintersinfoByPrinterid(Integer printerid);
}

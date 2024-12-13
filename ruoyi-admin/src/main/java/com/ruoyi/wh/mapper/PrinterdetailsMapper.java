package com.ruoyi.wh.mapper;

import java.util.List;
import com.ruoyi.wh.domain.Printerdetails;

/**
 * printerdetailsMapper接口
 * 
 * @author young1
 * @date 2024-12-12
 */
public interface PrinterdetailsMapper 
{
    /**
     * 查询printerdetails
     * 
     * @param printerid printerdetails主键
     * @return printerdetails
     */
    public Printerdetails selectPrinterdetailsByPrinterid(Long printerid);

    /**
     * 查询printerdetails列表
     * 
     * @param printerdetails printerdetails
     * @return printerdetails集合
     */
    public List<Printerdetails> selectPrinterdetailsList(Printerdetails printerdetails);

    /**
     * 新增printerdetails
     * 
     * @param printerdetails printerdetails
     * @return 结果
     */
    public int insertPrinterdetails(Printerdetails printerdetails);

    /**
     * 修改printerdetails
     * 
     * @param printerdetails printerdetails
     * @return 结果
     */
    public int updatePrinterdetails(Printerdetails printerdetails);

    /**
     * 删除printerdetails
     * 
     * @param printerid printerdetails主键
     * @return 结果
     */
    public int deletePrinterdetailsByPrinterid(Long printerid);

    /**
     * 批量删除printerdetails
     * 
     * @param printerids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePrinterdetailsByPrinterids(Long[] printerids);
}

package com.ruoyi.wh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.PrinterdetailsMapper;
import com.ruoyi.wh.domain.Printerdetails;
import com.ruoyi.wh.service.IPrinterdetailsService;

/**
 * printerdetailsService业务层处理
 * 
 * @author young1
 * @date 2024-12-12
 */
@Service
public class PrinterdetailsServiceImpl implements IPrinterdetailsService 
{
    @Autowired
    private PrinterdetailsMapper printerdetailsMapper;

    /**
     * 查询printerdetails
     * 
     * @param printerid printerdetails主键
     * @return printerdetails
     */
    @Override
    public Printerdetails selectPrinterdetailsByPrinterid(Long printerid)
    {
        return printerdetailsMapper.selectPrinterdetailsByPrinterid(printerid);
    }

    /**
     * 查询printerdetails列表
     * 
     * @param printerdetails printerdetails
     * @return printerdetails
     */
    @Override
    public List<Printerdetails> selectPrinterdetailsList(Printerdetails printerdetails)
    {
        return printerdetailsMapper.selectPrinterdetailsList(printerdetails);
    }

    /**
     * 新增printerdetails
     * 
     * @param printerdetails printerdetails
     * @return 结果
     */
    @Override
    public int insertPrinterdetails(Printerdetails printerdetails)
    {
        return printerdetailsMapper.insertPrinterdetails(printerdetails);
    }

    /**
     * 修改printerdetails
     * 
     * @param printerdetails printerdetails
     * @return 结果
     */
    @Override
    public int updatePrinterdetails(Printerdetails printerdetails)
    {
        return printerdetailsMapper.updatePrinterdetails(printerdetails);
    }

    /**
     * 批量删除printerdetails
     * 
     * @param printerids 需要删除的printerdetails主键
     * @return 结果
     */
    @Override
    public int deletePrinterdetailsByPrinterids(Long[] printerids)
    {
        return printerdetailsMapper.deletePrinterdetailsByPrinterids(printerids);
    }

    /**
     * 删除printerdetails信息
     * 
     * @param printerid printerdetails主键
     * @return 结果
     */
    @Override
    public int deletePrinterdetailsByPrinterid(Long printerid)
    {
        return printerdetailsMapper.deletePrinterdetailsByPrinterid(printerid);
    }
}

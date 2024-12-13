package com.ruoyi.wh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.AaprintersinfoMapper;
import com.ruoyi.wh.domain.Aaprintersinfo;
import com.ruoyi.wh.service.IAaprintersinfoService;

/**
 * 打印机信息查询Service业务层处理
 * 
 * @author young1
 * @date 2024-12-14
 */
@Service
public class AaprintersinfoServiceImpl implements IAaprintersinfoService 
{
    @Autowired
    private AaprintersinfoMapper aaprintersinfoMapper;

    /**
     * 查询打印机信息查询
     * 
     * @param printerid 打印机信息查询主键
     * @return 打印机信息查询
     */
    @Override
    public Aaprintersinfo selectAaprintersinfoByPrinterid(Integer printerid)
    {
        return aaprintersinfoMapper.selectAaprintersinfoByPrinterid(printerid);
    }

    /**
     * 查询打印机信息查询列表
     * 
     * @param aaprintersinfo 打印机信息查询
     * @return 打印机信息查询
     */
    @Override
    public List<Aaprintersinfo> selectAaprintersinfoList(Aaprintersinfo aaprintersinfo)
    {
        return aaprintersinfoMapper.selectAaprintersinfoList(aaprintersinfo);
    }

    /**
     * 新增打印机信息查询
     * 
     * @param aaprintersinfo 打印机信息查询
     * @return 结果
     */
    @Override
    public int insertAaprintersinfo(Aaprintersinfo aaprintersinfo)
    {
        return aaprintersinfoMapper.insertAaprintersinfo(aaprintersinfo);
    }

    /**
     * 修改打印机信息查询
     * 
     * @param aaprintersinfo 打印机信息查询
     * @return 结果
     */
    @Override
    public int updateAaprintersinfo(Aaprintersinfo aaprintersinfo)
    {
        return aaprintersinfoMapper.updateAaprintersinfo(aaprintersinfo);
    }

    /**
     * 批量删除打印机信息查询
     * 
     * @param printerids 需要删除的打印机信息查询主键
     * @return 结果
     */
    @Override
    public int deleteAaprintersinfoByPrinterids(Integer[] printerids)
    {
        return aaprintersinfoMapper.deleteAaprintersinfoByPrinterids(printerids);
    }

    /**
     * 删除打印机信息查询信息
     * 
     * @param printerid 打印机信息查询主键
     * @return 结果
     */
    @Override
    public int deleteAaprintersinfoByPrinterid(Integer printerid)
    {
        return aaprintersinfoMapper.deleteAaprintersinfoByPrinterid(printerid);
    }
}

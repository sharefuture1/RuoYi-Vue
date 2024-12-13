package com.ruoyi.wh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.AorgassetMapper;
import com.ruoyi.wh.domain.Aorgasset;
import com.ruoyi.wh.service.IAorgassetService;

/**
 * 打印机资产查询Service业务层处理
 * 
 * @author young1
 * @date 2024-12-14
 */
@Service
public class AorgassetServiceImpl implements IAorgassetService 
{
    @Autowired
    private AorgassetMapper aorgassetMapper;

    /**
     * 查询打印机资产查询
     * 
     * @param id 打印机资产查询主键
     * @return 打印机资产查询
     */
    @Override
    public Aorgasset selectAorgassetById(Integer id)
    {
        return aorgassetMapper.selectAorgassetById(id);
    }

    /**
     * 查询打印机资产查询列表
     * 
     * @param aorgasset 打印机资产查询
     * @return 打印机资产查询
     */
    @Override
    public List<Aorgasset> selectAorgassetList(Aorgasset aorgasset)
    {
        return aorgassetMapper.selectAorgassetList(aorgasset);
    }

    /**
     * 新增打印机资产查询
     * 
     * @param aorgasset 打印机资产查询
     * @return 结果
     */
    @Override
    public int insertAorgasset(Aorgasset aorgasset)
    {
        return aorgassetMapper.insertAorgasset(aorgasset);
    }

    /**
     * 修改打印机资产查询
     * 
     * @param aorgasset 打印机资产查询
     * @return 结果
     */
    @Override
    public int updateAorgasset(Aorgasset aorgasset)
    {
        return aorgassetMapper.updateAorgasset(aorgasset);
    }

    /**
     * 批量删除打印机资产查询
     * 
     * @param ids 需要删除的打印机资产查询主键
     * @return 结果
     */
    @Override
    public int deleteAorgassetByIds(Integer[] ids)
    {
        return aorgassetMapper.deleteAorgassetByIds(ids);
    }

    /**
     * 删除打印机资产查询信息
     * 
     * @param id 打印机资产查询主键
     * @return 结果
     */
    @Override
    public int deleteAorgassetById(Integer id)
    {
        return aorgassetMapper.deleteAorgassetById(id);
    }
}

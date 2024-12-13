package com.ruoyi.wh.mapper;

import java.util.List;
import com.ruoyi.wh.domain.Aorgasset;

/**
 * 打印机资产查询Mapper接口
 * 
 * @author young1
 * @date 2024-12-14
 */
public interface AorgassetMapper 
{
    /**
     * 查询打印机资产查询
     * 
     * @param id 打印机资产查询主键
     * @return 打印机资产查询
     */
    public Aorgasset selectAorgassetById(Integer id);

    /**
     * 查询打印机资产查询列表
     * 
     * @param aorgasset 打印机资产查询
     * @return 打印机资产查询集合
     */
    public List<Aorgasset> selectAorgassetList(Aorgasset aorgasset);

    /**
     * 新增打印机资产查询
     * 
     * @param aorgasset 打印机资产查询
     * @return 结果
     */
    public int insertAorgasset(Aorgasset aorgasset);

    /**
     * 修改打印机资产查询
     * 
     * @param aorgasset 打印机资产查询
     * @return 结果
     */
    public int updateAorgasset(Aorgasset aorgasset);

    /**
     * 删除打印机资产查询
     * 
     * @param id 打印机资产查询主键
     * @return 结果
     */
    public int deleteAorgassetById(Integer id);

    /**
     * 批量删除打印机资产查询
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAorgassetByIds(Integer[] ids);
}

package com.ruoyi.wh.mapper;

import java.util.List;
import com.ruoyi.wh.domain.WhAsset;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author young1
 * @date 2023-05-30
 */
public interface WhAssetMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param assetid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public WhAsset selectWhAssetByAssetid(Long assetid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param whAsset 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<WhAsset> selectWhAssetList(WhAsset whAsset);

    /**
     * 新增【请填写功能名称】
     * 
     * @param whAsset 【请填写功能名称】
     * @return 结果
     */
    public int insertWhAsset(WhAsset whAsset);

    /**
     * 修改【请填写功能名称】
     * 
     * @param whAsset 【请填写功能名称】
     * @return 结果
     */
    public int updateWhAsset(WhAsset whAsset);

    /**
     * 删除【请填写功能名称】
     * 
     * @param assetid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteWhAssetByAssetid(Long assetid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param assetids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWhAssetByAssetids(Long[] assetids);
}
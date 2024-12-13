package com.ruoyi.wh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.WhAssetMapper;
import com.ruoyi.wh.domain.WhAsset;
import com.ruoyi.wh.service.IWhAssetService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author young1
 * @date 2023-05-30
 */
@Service
public class WhAssetServiceImpl implements IWhAssetService 
{
    @Autowired
    private WhAssetMapper whAssetMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param assetid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public WhAsset selectWhAssetByAssetid(Long assetid)
    {
        return whAssetMapper.selectWhAssetByAssetid(assetid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param whAsset 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WhAsset> selectWhAssetList(WhAsset whAsset)
    {
        return whAssetMapper.selectWhAssetList(whAsset);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param whAsset 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertWhAsset(WhAsset whAsset)
    {
        return whAssetMapper.insertWhAsset(whAsset);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param whAsset 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateWhAsset(WhAsset whAsset)
    {
        return whAssetMapper.updateWhAsset(whAsset);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param assetids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWhAssetByAssetids(Long[] assetids)
    {
        return whAssetMapper.deleteWhAssetByAssetids(assetids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param assetid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWhAssetByAssetid(Long assetid)
    {
        return whAssetMapper.deleteWhAssetByAssetid(assetid);
    }
}

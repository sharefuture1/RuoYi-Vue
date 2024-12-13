package com.ruoyi.wh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 wh_asset
 * 
 * @author young1
 * @date 2023-05-30
 */
public class WhAsset extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资产id */
    private Long assetid;

    /** 资产位置 */
    @Excel(name = "资产位置")
    private String assetposition;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String assetname;

    /** 资产所属单位 */
    @Excel(name = "资产所属单位")
    private String assetdept;

    public void setAssetid(Long assetid) 
    {
        this.assetid = assetid;
    }

    public Long getAssetid() 
    {
        return assetid;
    }
    public void setAssetposition(String assetposition) 
    {
        this.assetposition = assetposition;
    }

    public String getAssetposition() 
    {
        return assetposition;
    }
    public void setAssetname(String assetname) 
    {
        this.assetname = assetname;
    }

    public String getAssetname() 
    {
        return assetname;
    }
    public void setAssetdept(String assetdept) 
    {
        this.assetdept = assetdept;
    }

    public String getAssetdept() 
    {
        return assetdept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("assetid", getAssetid())
            .append("assetposition", getAssetposition())
            .append("assetname", getAssetname())
            .append("assetdept", getAssetdept())
            .toString();
    }
}

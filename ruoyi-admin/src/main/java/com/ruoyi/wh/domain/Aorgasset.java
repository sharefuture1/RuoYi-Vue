package com.ruoyi.wh.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 打印机资产查询对象 aorgasset
 * 
 * @author young1
 * @date 2024-12-14
 */
public class Aorgasset extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 打印机ID */
    private Integer id;

    /** 楼层及序号 */
    @Excel(name = "楼层及序号")
    private String floorserial;

    /** 办公室名称 */
    @Excel(name = "办公室名称")
    private String officename;

    /** 打印机名称 */
    @Excel(name = "打印机名称")
    private String printermodel;

    /** 出厂日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date factorydate;

    /** 使用年限 */
    @Excel(name = "使用年限")
    private Long yearsinuse;

    /** 序列号 */
    @Excel(name = "序列号")
    private String serialno;

    /** 资产编码 */
    @Excel(name = "资产编码")
    private String assetcode;

    /** 组织名称 */
    @Excel(name = "组织名称")
    private String organizationname;

    /** 统计日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statsdate;

    /** 通用编号 */
    @Excel(name = "通用编号")
    private String universalno;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setFloorserial(String floorserial) 
    {
        this.floorserial = floorserial;
    }

    public String getFloorserial() 
    {
        return floorserial;
    }
    public void setOfficename(String officename) 
    {
        this.officename = officename;
    }

    public String getOfficename() 
    {
        return officename;
    }
    public void setPrintermodel(String printermodel) 
    {
        this.printermodel = printermodel;
    }

    public String getPrintermodel() 
    {
        return printermodel;
    }
    public void setFactorydate(Date factorydate) 
    {
        this.factorydate = factorydate;
    }

    public Date getFactorydate() 
    {
        return factorydate;
    }
    public void setYearsinuse(Long yearsinuse) 
    {
        this.yearsinuse = yearsinuse;
    }

    public Long getYearsinuse() 
    {
        return yearsinuse;
    }
    public void setSerialno(String serialno) 
    {
        this.serialno = serialno;
    }

    public String getSerialno() 
    {
        return serialno;
    }
    public void setAssetcode(String assetcode) 
    {
        this.assetcode = assetcode;
    }

    public String getAssetcode() 
    {
        return assetcode;
    }
    public void setOrganizationname(String organizationname) 
    {
        this.organizationname = organizationname;
    }

    public String getOrganizationname() 
    {
        return organizationname;
    }
    public void setStatsdate(Date statsdate) 
    {
        this.statsdate = statsdate;
    }

    public Date getStatsdate() 
    {
        return statsdate;
    }
    public void setUniversalno(String universalno) 
    {
        this.universalno = universalno;
    }

    public String getUniversalno() 
    {
        return universalno;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("floorserial", getFloorserial())
            .append("officename", getOfficename())
            .append("printermodel", getPrintermodel())
            .append("factorydate", getFactorydate())
            .append("yearsinuse", getYearsinuse())
            .append("serialno", getSerialno())
            .append("assetcode", getAssetcode())
            .append("organizationname", getOrganizationname())
            .append("statsdate", getStatsdate())
            .append("universalno", getUniversalno())
            .append("remarks", getRemarks())
            .toString();
    }
}

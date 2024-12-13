package com.ruoyi.wh.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * home对象 wh_home
 * 
 * @author young1
 * @date 2023-05-30
 */
public class WhHome extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日期
 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 任务id
 */
    private Long taskid;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String cname;

    /** 科室信息 */
    @Excel(name = "科室信息")
    private String coffice;

    /** 设备
 */
    @Excel(name = "设备")
    private String trouble;

    /** 耗材
 */
    @Excel(name = "耗材")
    private String supplies;

    /** 价格
 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 数量 */
    @Excel(name = "数量")
    private Long amount;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal total;

    /** 0未完成1已完成默认0 */
    @Excel(name = "0未完成1已完成默认0")
    private Integer isok;

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setTaskid(Long taskid) 
    {
        this.taskid = taskid;
    }

    public Long getTaskid() 
    {
        return taskid;
    }
    public void setCname(String cname) 
    {
        this.cname = cname;
    }

    public String getCname() 
    {
        return cname;
    }
    public void setCoffice(String coffice) 
    {
        this.coffice = coffice;
    }

    public String getCoffice() 
    {
        return coffice;
    }
    public void setTrouble(String trouble) 
    {
        this.trouble = trouble;
    }

    public String getTrouble() 
    {
        return trouble;
    }
    public void setSupplies(String supplies) 
    {
        this.supplies = supplies;
    }

    public String getSupplies() 
    {
        return supplies;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
    {
        return amount;
    }
    public void setTotal(BigDecimal total) 
    {
        this.total = total;
    }

    public BigDecimal getTotal() 
    {
        return total;
    }
    public void setIsok(Integer isok) 
    {
        this.isok = isok;
    }

    public Integer getIsok() 
    {
        return isok;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("date", getDate())
            .append("taskid", getTaskid())
            .append("cname", getCname())
            .append("coffice", getCoffice())
            .append("trouble", getTrouble())
            .append("supplies", getSupplies())
            .append("price", getPrice())
            .append("amount", getAmount())
            .append("total", getTotal())
            .append("remark", getRemark())
            .append("isok", getIsok())
            .toString();
    }
}

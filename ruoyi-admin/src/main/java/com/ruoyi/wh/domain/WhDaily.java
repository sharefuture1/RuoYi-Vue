package com.ruoyi.wh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 每日任务信息对象 wh_daily
 * 
 * @author young1
 * @date 2023-03-04
 */
public class WhDaily extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务id */
    private Long taskId;

    /** 客户编码 */
    @Excel(name = "客户编码")
    private String customerCode;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long customerSort;

    /** 状态（0已完成 1未完成） */
    @Excel(name = "状态", readConverterExp = "0=已完成,1=未完成")
    private String status;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setCustomerCode(String customerCode) 
    {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() 
    {
        return customerCode;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setCustomerSort(Long customerSort) 
    {
        this.customerSort = customerSort;
    }

    public Long getCustomerSort() 
    {
        return customerSort;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("customerCode", getCustomerCode())
            .append("customerName", getCustomerName())
            .append("customerSort", getCustomerSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

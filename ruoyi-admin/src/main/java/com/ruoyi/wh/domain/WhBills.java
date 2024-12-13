package com.ruoyi.wh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * bills对象 wh_bills
 * 
 * @author young1
 * @date 2023-05-30
 */
public class WhBills extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日期 */
    @Excel(name = "日期")
    private String date;

    /** 单位 */
    @Excel(name = "单位")
    private String department;

    /** 备注 */
    @Excel(name = "备注")
    private String remark1;

    /** 部门 */
    @Excel(name = "部门")
    private String office;

    /** 产品 */
    @Excel(name = "产品")
    private String product;

    /** 备注 */
    @Excel(name = "备注")
    private String remark2;

    /** 销售人 */
    @Excel(name = "销售人")
    private String salesman;

    /** 订单号 */
    @Excel(name = "订单号")
    private String saleno;

    /** 金额 */
    @Excel(name = "金额")
    private String amount;

    /** 销售日期 */
    @Excel(name = "销售日期")
    private String xzdate;

    /** 销售金额 */
    @Excel(name = "销售金额")
    private String xzamout;

    /** 总额 */
    @Excel(name = "总额")
    private String total;

    /** 交票时间 */
    @Excel(name = "交票时间")
    private String jiaoptime;

    /** 检查人 */
    @Excel(name = "检查人")
    private String checktaker;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payma;

    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setRemark1(String remark1) 
    {
        this.remark1 = remark1;
    }

    public String getRemark1() 
    {
        return remark1;
    }
    public void setOffice(String office) 
    {
        this.office = office;
    }

    public String getOffice() 
    {
        return office;
    }
    public void setProduct(String product) 
    {
        this.product = product;
    }

    public String getProduct() 
    {
        return product;
    }
    public void setRemark2(String remark2) 
    {
        this.remark2 = remark2;
    }

    public String getRemark2() 
    {
        return remark2;
    }
    public void setSalesman(String salesman) 
    {
        this.salesman = salesman;
    }

    public String getSalesman() 
    {
        return salesman;
    }
    public void setSaleno(String saleno) 
    {
        this.saleno = saleno;
    }

    public String getSaleno() 
    {
        return saleno;
    }
    public void setAmount(String amount) 
    {
        this.amount = amount;
    }

    public String getAmount() 
    {
        return amount;
    }
    public void setXzdate(String xzdate) 
    {
        this.xzdate = xzdate;
    }

    public String getXzdate() 
    {
        return xzdate;
    }
    public void setXzamout(String xzamout) 
    {
        this.xzamout = xzamout;
    }

    public String getXzamout() 
    {
        return xzamout;
    }
    public void setTotal(String total) 
    {
        this.total = total;
    }

    public String getTotal() 
    {
        return total;
    }
    public void setJiaoptime(String jiaoptime) 
    {
        this.jiaoptime = jiaoptime;
    }

    public String getJiaoptime() 
    {
        return jiaoptime;
    }
    public void setChecktaker(String checktaker) 
    {
        this.checktaker = checktaker;
    }

    public String getChecktaker() 
    {
        return checktaker;
    }
    public void setPayma(String payma) 
    {
        this.payma = payma;
    }

    public String getPayma() 
    {
        return payma;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("date", getDate())
            .append("department", getDepartment())
            .append("remark1", getRemark1())
            .append("office", getOffice())
            .append("product", getProduct())
            .append("remark2", getRemark2())
            .append("salesman", getSalesman())
            .append("saleno", getSaleno())
            .append("amount", getAmount())
            .append("xzdate", getXzdate())
            .append("xzamout", getXzamout())
            .append("total", getTotal())
            .append("jiaoptime", getJiaoptime())
            .append("checktaker", getChecktaker())
            .append("payma", getPayma())
            .toString();
    }
}

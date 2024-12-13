package com.ruoyi.wh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * bills对象 wh_zyy21
 * 
 * @author young1
 * @date 2023-08-07
 */
public class WhZyy21 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 日期;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 挂账单位;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 备注;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 购买科室;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 购买产品;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 备注1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 销售员;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 销售单号;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 销售金额;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 销帐日期;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 销帐金额;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 合计;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 交票时间;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 收票人;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 收款方式;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String f16;

    public void set日期(String 日期) 
    {
        this.日期 = 日期;
    }

    public String get日期() 
    {
        return 日期;
    }
    public void set挂账单位(String 挂账单位) 
    {
        this.挂账单位 = 挂账单位;
    }

    public String get挂账单位() 
    {
        return 挂账单位;
    }
    public void set备注(String 备注) 
    {
        this.备注 = 备注;
    }

    public String get备注() 
    {
        return 备注;
    }
    public void set购买科室(String 购买科室) 
    {
        this.购买科室 = 购买科室;
    }

    public String get购买科室() 
    {
        return 购买科室;
    }
    public void set购买产品(String 购买产品) 
    {
        this.购买产品 = 购买产品;
    }

    public String get购买产品() 
    {
        return 购买产品;
    }
    public void set备注1(String 备注1) 
    {
        this.备注1 = 备注1;
    }

    public String get备注1() 
    {
        return 备注1;
    }
    public void set销售员(String 销售员) 
    {
        this.销售员 = 销售员;
    }

    public String get销售员() 
    {
        return 销售员;
    }
    public void set销售单号(String 销售单号) 
    {
        this.销售单号 = 销售单号;
    }

    public String get销售单号() 
    {
        return 销售单号;
    }
    public void set销售金额(String 销售金额) 
    {
        this.销售金额 = 销售金额;
    }

    public String get销售金额() 
    {
        return 销售金额;
    }
    public void set销帐日期(String 销帐日期) 
    {
        this.销帐日期 = 销帐日期;
    }

    public String get销帐日期() 
    {
        return 销帐日期;
    }
    public void set销帐金额(String 销帐金额) 
    {
        this.销帐金额 = 销帐金额;
    }

    public String get销帐金额() 
    {
        return 销帐金额;
    }
    public void set合计(String 合计) 
    {
        this.合计 = 合计;
    }

    public String get合计() 
    {
        return 合计;
    }
    public void set交票时间(String 交票时间) 
    {
        this.交票时间 = 交票时间;
    }

    public String get交票时间() 
    {
        return 交票时间;
    }
    public void set收票人(String 收票人) 
    {
        this.收票人 = 收票人;
    }

    public String get收票人() 
    {
        return 收票人;
    }
    public void set收款方式(String 收款方式) 
    {
        this.收款方式 = 收款方式;
    }

    public String get收款方式() 
    {
        return 收款方式;
    }
    public void setF16(String f16) 
    {
        this.f16 = f16;
    }

    public String getF16() 
    {
        return f16;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("日期", get日期())
            .append("挂账单位", get挂账单位())
            .append("备注", get备注())
            .append("购买科室", get购买科室())
            .append("购买产品", get购买产品())
            .append("备注1", get备注1())
            .append("销售员", get销售员())
            .append("销售单号", get销售单号())
            .append("销售金额", get销售金额())
            .append("销帐日期", get销帐日期())
            .append("销帐金额", get销帐金额())
            .append("合计", get合计())
            .append("交票时间", get交票时间())
            .append("收票人", get收票人())
            .append("收款方式", get收款方式())
            .append("f16", getF16())
            .toString();
    }
}

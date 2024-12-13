package com.ruoyi.wh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 打印机信息查询对象 aaprintersinfo
 * 
 * @author young1
 * @date 2024-12-14
 */
public class Aaprintersinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 打印机ID */
    @Excel(name = "打印机ID")
    private Integer printerid;

    /** 打印机名称 */
    @Excel(name = "打印机名称")
    private String printername;

    /** 耗材类型 */
    @Excel(name = "耗材类型")
    private String consumabletype;

    /** 墨/粉盒型号 */
    @Excel(name = "墨/粉盒型号")
    private String powdercartridgemodel;

    /** 墨/粉型号 */
    @Excel(name = "墨/粉型号")
    private String powdermodel;

    /** 硒鼓型号 */
    @Excel(name = "硒鼓型号")
    private String drummodel;

    /** 预估寿命
 */
    @Excel(name = "预估寿命")
    private Long drumlife;

    /** 重置方法 */
    @Excel(name = "重置方法")

    private String resetmethod;

    /** 其他注意事项 */
    @Excel(name = "其他注意事项")
            private String additionalnotes;

    /** 驱动下载 */
    @Excel(name = "驱动下载")

    private String driverdownloadurl;

    /** 手册 */
    @Excel(name = "手册")
    private String manualdownloadurl;

    /** 图片链接 */
    @Excel(name = "图片链接")
    private String uploadimg;

    public void setPrinterid(Integer printerid) 
    {
        this.printerid = printerid;
    }

    public Integer getPrinterid() 
    {
        return printerid;
    }
    public void setPrintername(String printername) 
    {
        this.printername = printername;
    }

    public String getPrintername() 
    {
        return printername;
    }
    public void setConsumabletype(String consumabletype) 
    {
        this.consumabletype = consumabletype;
    }

    public String getConsumabletype() 
    {
        return consumabletype;
    }
    public void setPowdercartridgemodel(String powdercartridgemodel) 
    {
        this.powdercartridgemodel = powdercartridgemodel;
    }

    public String getPowdercartridgemodel() 
    {
        return powdercartridgemodel;
    }
    public void setPowdermodel(String powdermodel) 
    {
        this.powdermodel = powdermodel;
    }

    public String getPowdermodel() 
    {
        return powdermodel;
    }
    public void setDrummodel(String drummodel) 
    {
        this.drummodel = drummodel;
    }

    public String getDrummodel() 
    {
        return drummodel;
    }
    public void setDrumlife(Long drumlife) 
    {
        this.drumlife = drumlife;
    }

    public Long getDrumlife() 
    {
        return drumlife;
    }
    public void setResetmethod(String resetmethod) 
    {
        this.resetmethod = resetmethod;
    }

    public String getResetmethod() 
    {
        return resetmethod;
    }
    public void setAdditionalnotes(String additionalnotes) 
    {
        this.additionalnotes = additionalnotes;
    }

    public String getAdditionalnotes() 
    {
        return additionalnotes;
    }
    public void setDriverdownloadurl(String driverdownloadurl) 
    {
        this.driverdownloadurl = driverdownloadurl;
    }

    public String getDriverdownloadurl() 
    {
        return driverdownloadurl;
    }
    public void setManualdownloadurl(String manualdownloadurl) 
    {
        this.manualdownloadurl = manualdownloadurl;
    }

    public String getManualdownloadurl() 
    {
        return manualdownloadurl;
    }
    public void setUploadimg(String uploadimg) 
    {
        this.uploadimg = uploadimg;
    }

    public String getUploadimg() 
    {
        return uploadimg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("printerid", getPrinterid())
            .append("printername", getPrintername())
            .append("consumabletype", getConsumabletype())
            .append("powdercartridgemodel", getPowdercartridgemodel())
            .append("powdermodel", getPowdermodel())
            .append("drummodel", getDrummodel())
            .append("drumlife", getDrumlife())
            .append("resetmethod", getResetmethod())
            .append("additionalnotes", getAdditionalnotes())
            .append("driverdownloadurl", getDriverdownloadurl())
            .append("manualdownloadurl", getManualdownloadurl())
            .append("uploadimg", getUploadimg())
            .toString();
    }
}

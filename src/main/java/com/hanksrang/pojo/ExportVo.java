package com.hanksrang.pojo;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.hanksrang.anno.Excel;
import lombok.Data;
 
@Data
public class ExportVo implements Serializable {
    private static final long serialVersionUID = 1L;
 
    /** 姓名 */
    @Excel(name = "姓名", index = 1)
    private String studentName;
 
    /** 身份证号 */
    @Excel(name = "身份证号", index = 2)
    private String identityId;
 
    /** 学号 */
    @Excel(name = "学号", index = 3)
    private String studentId;
 
    /** 出生日期 */
    @Excel(name = "出生日期", index = 4)
    private String birthday;

}
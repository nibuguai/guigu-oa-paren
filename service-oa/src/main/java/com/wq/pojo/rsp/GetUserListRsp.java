package com.wq.pojo.rsp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author 王骞
 * @Date 2023/8/10 15:34
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListRsp {
    /**
     * 用户名
     */
    private String username;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 岗位名称
     */
    private String postName;
    /**
     * 创建时间
     */
    private Date createTime;
}

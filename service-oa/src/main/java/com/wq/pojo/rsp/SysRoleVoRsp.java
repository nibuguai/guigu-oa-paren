package com.wq.pojo.rsp;

import com.atguigu.model.system.SysRole;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author 王骞
 * @Date 2023/8/1 17:10
 * @Version 1.0
 */
@Slf4j
@Data
public class SysRoleVoRsp  {
    List<SysRole> sysRoles;
    Long total;
}

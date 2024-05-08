package com.wq.service;

import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wq.pojo.req.RoleQueryVoReq;
import com.wq.pojo.rsp.SysRoleVoRsp;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author 王骞
 * @since 2023-06-28
 */
public interface ISysRoleService extends IService<SysRole> {

    SysRoleVoRsp roleQuery(RoleQueryVoReq roleQueryVoReq);

    void deleteRoles(String roleCode);

    void renewalRole(SysRole sysRole);
}

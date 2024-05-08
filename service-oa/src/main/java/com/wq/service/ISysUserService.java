package com.wq.service;

import com.atguigu.model.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wq.pojo.req.GetUserListReq;
import com.wq.pojo.rsp.GetUserListVoRsp;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 王骞
 * @since 2023-08-04
 */
public interface ISysUserService extends IService<SysUser> {

    GetUserListVoRsp getUserList(GetUserListReq getUserListReq);
}

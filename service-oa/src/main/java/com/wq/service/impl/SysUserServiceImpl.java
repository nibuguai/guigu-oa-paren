package com.wq.service.impl;


import com.atguigu.model.system.SysUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.mapper.SysUserMapper;
import com.wq.pojo.req.GetUserListReq;
import com.wq.pojo.rsp.GetUserListRsp;
import com.wq.pojo.rsp.GetUserListVoRsp;
import com.wq.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 王骞
 * @since 2023-08-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public GetUserListVoRsp getUserList(GetUserListReq getUserListReq) {
        GetUserListVoRsp getUserListVoRsp = new GetUserListVoRsp();
        List<GetUserListRsp> userList = baseMapper.getUserList(getUserListReq);
        getUserListVoRsp.setGetUserList(userList);
        Integer userListCont = baseMapper.getUserListCont(getUserListReq);
        getUserListVoRsp.setTotal(userListCont);
        return getUserListVoRsp;
    }
}

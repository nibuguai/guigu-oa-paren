package com.wq.mapper;


import com.atguigu.model.system.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wq.pojo.req.GetUserListReq;
import com.wq.pojo.rsp.GetUserListRsp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 王骞
 * @since 2023-08-04
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 获取用户列表
     */
    List<GetUserListRsp> getUserList(GetUserListReq getUserListReq);

    int getUserListCont(GetUserListReq getUserListReq);
}

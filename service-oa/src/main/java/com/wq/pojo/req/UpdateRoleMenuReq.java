package com.wq.pojo.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 王骞
 * @Date 2023/8/15 16:31
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleMenuReq {
    private String roleId;
    private List<String> menuIds;
}


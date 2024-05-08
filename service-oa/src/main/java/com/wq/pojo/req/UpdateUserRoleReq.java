package com.wq.pojo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 王骞
 * @Date 2023/8/10 20:35
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRoleReq {
    private List<String> sysRoleIds;
    private String userId;
}

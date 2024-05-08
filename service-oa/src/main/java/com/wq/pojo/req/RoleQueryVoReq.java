package com.wq.pojo.req;

import com.atguigu.vo.baseVo.BasicPagination;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 王骞
 * @Date 2023/7/11 19:12
 * @Version 1.0
 */
@Slf4j
@Data
public class RoleQueryVoReq extends BasicPagination {

    private Long id;

    private String roleName;

    private String roleCode;

    private String description;
}

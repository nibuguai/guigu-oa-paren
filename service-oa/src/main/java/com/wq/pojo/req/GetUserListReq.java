package com.wq.pojo.req;

import com.atguigu.vo.baseVo.BasicPagination;
import lombok.Data;

/**
 * @Author 王骞
 * @Date 2023/8/5 19:49
 * @Version 1.0
 */
@Data
public class GetUserListReq extends BasicPagination {
    private String keyword;
    private String createdTimeStart;
    private String createdTimeEnd;
}

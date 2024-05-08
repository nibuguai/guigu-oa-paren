package com.wq.pojo.rsp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 王骞
 * @Date 2023/12/25 17:50
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListVoRsp {
    private List<GetUserListRsp> getUserList;
    private int total;
}

package com.atguigu.vo.baseVo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 王骞
 * @Date 2023/7/28 9:49
 * @Version 1.0
 */
@Slf4j
@Data
public class BasicPagination  {
    private int page; // 当前页码
    private int limit; // 每页记录数
}

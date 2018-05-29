package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServiceResponse;

/**
 * Created by huangzhigang on 18-5-28.
 */
public interface IProductService {

    ServiceResponse<PageInfo> getProductList(int pageNum,int pageSize);
}

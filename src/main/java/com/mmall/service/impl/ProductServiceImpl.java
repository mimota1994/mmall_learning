package com.mmall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mmall.common.ServiceResponse;
import com.mmall.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * Created by huangzhigang on 18-5-28.
 */
@Service("iProductService")
public class ProductServiceImpl implements IProductService{
    @Override
    public ServiceResponse<PageInfo> getProductList(int pageNum, int pageSize) {
        return null;
    }
}

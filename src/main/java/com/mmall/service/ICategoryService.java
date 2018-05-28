package com.mmall.service;

import com.mmall.common.ServiceResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created by huangzhigang on 18-5-27.
 */
public interface ICategoryService {

    ServiceResponse<Category> addCategory(String categoryName,Integer parentId);

    ServiceResponse setCategoryName(String categoryName,Integer categoryId);

    ServiceResponse<List> getCategory(int categoryId);

    List getNextLayerCategory(int categoryId);
}

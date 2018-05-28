package com.mmall.service.impl;

import com.mmall.common.ServiceResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhigang on 18-5-27.
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServiceResponse<Category> addCategory(String categoryName,Integer parentId) {
        if(parentId == null || StringUtils.isBlank(categoryName)){
            return ServiceResponse.creatByErrorMessage("parameter error in adding category");
        }
        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);

        int resultCount = categoryMapper.insert(category);
        if(resultCount >0){
            return ServiceResponse.creatBySuccessMessage("add category successfully");
        }
        return ServiceResponse.creatByErrorMessage("add category error");
    }

    @Override
    public ServiceResponse setCategoryName(String categoryName, Integer categoryId) {
        if(categoryId == null || StringUtils.isBlank(categoryName)){
            return ServiceResponse.creatByErrorMessage("parameter error in setting category name");
        }
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        category.setName(categoryName);
        int resultCount = categoryMapper.updateByPrimaryKey(category);
        if(resultCount >0){
            return ServiceResponse.creatBySuccessMessage("update category name successfully");
        }
        return ServiceResponse.creatByErrorMessage("update category error");
    }

    @Override
    public ServiceResponse<List> getCategory(int categoryId) {
        List list = categoryMapper.selectByParentId(categoryId);
        if(list.size() == 0){
            return ServiceResponse.creatByErrorMessage("we can not find the category");
        }
        return ServiceResponse.creatBySuccess(list);
    }

    @Override
    public List getNextLayerCategory(int categoryId) {
        List<Category> listTmp = categoryMapper.selectByParentId(categoryId);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<listTmp.size();i++){
            list.add(listTmp.get(i).getId());
        }
        return list;
    }
}

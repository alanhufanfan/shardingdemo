package com.jinyu.dao.mapper;

import com.jinyu.model.BaseDict;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16.
 */
public interface BaseDictMapper {
    List<BaseDict> selectDict() throws Exception;
}

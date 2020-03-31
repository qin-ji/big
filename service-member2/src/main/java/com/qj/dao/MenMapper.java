package com.qj.dao;

import com.qj.entity.Men;

public interface MenMapper {
    int insert(Men record);

    int insertSelective(Men record);
}
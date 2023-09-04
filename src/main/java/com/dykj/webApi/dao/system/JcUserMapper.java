package com.dykj.webApi.dao.system;

import com.dykj.webApi.pojo.system.JcUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DELL
 * @date 2023年8月28日15:17:01
 */
@Mapper
public interface JcUserMapper {
    /**
     * delete by primary key
     * @param userId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String userId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(JcUser record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(JcUser record);

    /**
     * select by primary key
     * @param userId primary key
     * @return object by primary key
     */
    JcUser selectByPrimaryKey(String userId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JcUser record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JcUser record);
}
package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    //查询所有资源权限
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    //添加资源权限
    @Insert("insert into permission(permissionName,url) value(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findByRoleId(String roleId) throws Exception;
    //查询资源详情
    @Select("select * from permission where id=#{id}")
    Permission findById(String id);

    //删除资源权限
    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(String id);
    @Delete("delete from permission where id=#{id}")
    void deleById(String id);
}

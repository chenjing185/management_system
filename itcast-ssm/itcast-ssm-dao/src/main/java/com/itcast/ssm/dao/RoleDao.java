package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {
    //根据用户id查询出所有的角色
    @Select("select * from role where id in( select roleId from users_role where userId=#{userId})")
    @Results({
                    @Result(id=true,column="id",property="id"),
                    @Result(column="roleName",property="roleName"),
                    @Result(column="roleDesc",property="roleDesc"),
                    @Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.itcast.ssm.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    //查询所有角色
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    //添加角色
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    //查询角色详情
    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.itcast.ssm.dao.PermissionDao.findByRoleId"))
    })
    Role findById(String roleId) throws Exception;
    //删除角色
    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(String roleId);
    @Delete("delete from role_permission where roleId=#{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId);
    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(String roleId);

    //根据roleId查询权限
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(String roleId);

    //给角色添加权限
    @Insert("insert into role_permission(roleId,permissionId)values(#{roleId},#{id})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("id") String id);
}

package com.itcast.ssm.service;

import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll(int page,int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    void deleteRoleById(String roleId) throws Exception;

    List<Permission> findOtherPermission(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] ids)throws Exception;
}

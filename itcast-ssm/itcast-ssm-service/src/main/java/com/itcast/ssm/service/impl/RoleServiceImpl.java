package com.itcast.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.ssm.dao.RoleDao;
import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    //查询所有角色
    @Override
    public List<Role> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }
    //添加角色
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }
    //查询角色详情
    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }
    //根据角色id删除角色
    @Override
    public void deleteRoleById(String roleId) throws Exception {
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        roleDao.deleteRoleById(roleId);
    }
    //根据roleId查询权限
    @Override
    public List<Permission> findOtherPermission(String roleId)throws Exception {
        return roleDao.findOtherPermission(roleId);
    }
    //给角色添加权限
    @Override
    public void addPermissionToRole(String roleId, String[] ids) throws Exception {
        for (String id:ids){
            roleDao.addPermissionToRole(roleId,id);
        }
    }
}

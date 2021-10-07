package com.itcast.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.ssm.dao.PermissionDao;
import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    //查询所有资源权限
    @Override
    public List<Permission> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    //添加资源权限
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
    //查询资源详情
    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }
    //删除资源权限
    @Override
    public void deleById(String id) throws Exception {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleById(id);
    }
}

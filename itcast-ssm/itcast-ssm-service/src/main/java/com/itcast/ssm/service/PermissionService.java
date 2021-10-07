package com.itcast.ssm.service;

import com.itcast.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll(int page,int size) throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleById(String id)throws Exception;
}

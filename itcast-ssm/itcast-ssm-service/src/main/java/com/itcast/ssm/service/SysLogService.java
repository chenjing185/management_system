package com.itcast.ssm.service;

import com.itcast.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {

    void save(SysLog sysLog)throws Exception;

    List<SysLog> findAll(int page,int size)throws Exception;
}

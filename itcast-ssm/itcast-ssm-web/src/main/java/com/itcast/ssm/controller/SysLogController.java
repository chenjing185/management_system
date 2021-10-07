package com.itcast.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.ssm.domain.SysLog;
import com.itcast.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;
    //查询所有日志
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception{
//        ModelAndView mv = new ModelAndView();
//        List<SysLog> sysLogList = sysLogService.findAll();
//        mv.addObject("sysLogs",sysLogList);
//        mv.setViewName("syslog-list");
//        return mv;
//    }
    //查询所有日志--分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-page-list");
        return mv;
    }

}

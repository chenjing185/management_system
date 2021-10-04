package com.itcast.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

      //查询全部订单--分页
      @RequestMapping("/findAll.do")
      public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception{
          ModelAndView mv = new ModelAndView();
          List<Orders> ordersList = ordersService.findAll(page,size);
          //pageInfo就是一个分页bean
          PageInfo pageInfo = new PageInfo(ordersList);
          mv.addObject("pageInfo",pageInfo);
          mv.setViewName("orders-page-list");
          return mv;
      }
      //查询订单详情
      @RequestMapping("findById.do")
      public ModelAndView findById(@RequestParam(name = "id",required = true) String ordersId) throws Exception {
          ModelAndView mv = new ModelAndView();
          Orders orders = ordersService.findById(ordersId);
          mv.addObject("orders",orders);
          mv.setViewName("orders-show");
          return mv;
      }

}

package com.jinyu.controller;

import com.jinyu.model.Customer;
import com.jinyu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by Administrator on 2017/5/11.
 */

@Controller
@RequestMapping("/customer")
public class CrmController {
    private Logger log = LoggerFactory.getLogger(CrmController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public ModelAndView index( ModelAndView mv) throws Exception {
//        customerService.getCustomerById((long)15);
        log.info("-------进入主页面接口-------");
        List<Customer> customerList= customerService.getCustomers();
        List<String> custSourceList = customerService.getCustSources();
        List<String> custIndustryTypeList = customerService.getCustIndustrys();
        mv.addObject("customerList",customerList);
//        mv.addObject("fromType",custSourceList);
//        mv.addObject("industryType",custIndustryTypeList);
        mv.setViewName("customer");
//        return "customer";
        return mv;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public Customer edit( @RequestParam("id") long id) throws Exception {
        log.info("------进入edit接口-------");
        Customer customer = customerService.getCustomerById(id);
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer);
//        return customerList;
        return customer;
        }

    @RequestMapping("/edit.do")
    public String doEdit(@RequestParam("cust_id") long cust_id,
                         @RequestParam("cust_name") String cust_name,
                         @RequestParam("cust_source") String cust_source,
                         @RequestParam("cust_industry") String cust_industry,
                         @RequestParam("cust_level") String cust_level,
                         @RequestParam("cust_linkman") String cust_linkman,
                         @RequestParam("cust_phone") String cust_phone,
                         @RequestParam("cust_mobile") String cust_mobile,
                         @RequestParam("cust_zipcode") String cust_zipcode,
                         @RequestParam("cust_address") String cust_address) throws Exception {

        log.info("-------进入edit do接口--------"+cust_name);
        Customer customer = new Customer();
        customer.setCust_id(cust_id);
        customer.setCust_name(cust_name);
        customer.setCust_source(cust_source);
        customer.setCust_industry(cust_industry);
        customer.setCust_level(cust_level);
        customer.setCust_linkman(cust_linkman);
        customer.setCust_phone(cust_phone);
        customer.setCust_mobile(cust_mobile);
        customer.setCust_zipcode(cust_zipcode);
        customer.setCust_address(cust_address);
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }

    @RequestMapping("/add")
    public String add() throws Exception {
        log.info("-------进入add接口-------");
        Customer customer = new Customer();
        customerService.addCustoer(customer);
        return "redirect:/customer/list";
    }


    @RequestMapping("/delete.do")
    public String delete(@RequestParam("id") long cust_id) throws Exception {
        log.info("-------进入delete接口-------");
        customerService.deleteCustomer(cust_id);
        return "redirect:/customer/list";

    }


}

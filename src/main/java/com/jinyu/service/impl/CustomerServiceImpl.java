package com.jinyu.service.impl;

import com.jinyu.dao.mapper.CustomerMapper;
import com.jinyu.model.Customer;
import com.jinyu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public Customer getCustomerById(long id) throws Exception {
        System.out.println(customerMapper.selectCustomerById(id));
//        return null;
        return customerMapper.selectCustomerById(id);
    }

    public List<Customer> getCustomers() throws Exception {
//        return null;
        return customerMapper.selectCustomers();
    }

    public boolean addCustoer(Customer customer) throws Exception {
        customerMapper.insertCustomer(customer);
        return true;
    }

    public boolean updateCustomer(Customer customer) throws Exception {
        customerMapper.updateCustomerById(customer);
        return true;
    }

    public boolean deleteCustomer(long cust_id) throws Exception {
        customerMapper.deleteCustomerById(cust_id);
        return true;
    }

    public List<String> getCustSources() throws Exception {
        return customerMapper.selectCustSource();
    }

    public List<String> getCustIndustrys() throws Exception {
        return customerMapper.selectCustIndustry();
    }

}

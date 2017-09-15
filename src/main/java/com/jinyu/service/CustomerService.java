package com.jinyu.service;

import com.jinyu.model.Customer;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface CustomerService {
    Customer getCustomerById(long id) throws Exception;
    List<Customer> getCustomers() throws Exception;
    boolean addCustoer(Customer customer) throws  Exception;
    boolean updateCustomer(Customer customer) throws Exception;
    boolean deleteCustomer(long cust_id) throws Exception;
    List<String> getCustSources() throws Exception;
    List<String> getCustIndustrys() throws Exception;
}

package com.jinyu.dao.mapper;

import com.jinyu.model.Customer;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface CustomerMapper {
    Customer selectCustomerById(long id) throws Exception;
    List<Customer> selectCustomers() throws Exception;
    void insertCustomer(Customer customer) throws Exception;
    void updateCustomerById(Customer customer) throws Exception;
    void deleteCustomerById(long cust_id) throws Exception;
    List<String> selectCustSource() throws Exception;
    List<String> selectCustIndustry() throws  Exception;
}

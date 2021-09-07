package customer_service;

import customer_bean.Customer;

public class CustomerList {
    private Customer[] customers;//保存客户对象的数组
    private int total = 0;//客户个数
    /*
    构造器，k数组最大值
     */
    public CustomerList(int totalCustomers){
        customers = new Customer[totalCustomers];
    }
    /*
    添加客户，成功返回true,不成功返回false
     */
    public  boolean addCustomers(Customer customer){
        if(total > customers.length){
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }
    /*
    替换对应位置客户
     */
    public  boolean replaceCustomers(int index, Customer customer){
        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = customer;
        return true;
    }
    /*
    删除指定位置上的客户
     */
    public  boolean deleteCustomers(int index){
        if(index < 0 || index >= total){
            return false;
        }
        for(int i = index;i<total-1;i++){
            customers[i] = customers[i+1];
        }
        //最后一个需要变成null
        customers[total-1] = null;
        total--;
        return true;
    }

    public  Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for(int i = 0;i<total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }
    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    public int getTotal(){
        return total;
    }


}

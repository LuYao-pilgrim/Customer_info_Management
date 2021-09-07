package customer_ui;

import customer_bean.Customer;
import customer_service.CustomerList;
import customer_util.CMutility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);
    public CustomerView(){
        Customer customer = new Customer("陆遥",'男',20,"19946254635","luyao_shoottheball@163.com");
        customerList.addCustomers(customer);
    }
    /*
    显示界面
     */
    public void enterMainMenu(){
        boolean loopFlag = true;
        while(loopFlag) {
            System.out.println("\n---------------客户信息管理软件---------------");
            System.out.println("                  1 添加客户");
            System.out.println("                  2 修改客户");
            System.out.println("                  3 删除客户");
            System.out.println("                  4 客户列表");
            System.out.println("                  5 退出\n");
            System.out.println("                  请选择（1~5)：");

            char key = CMutility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
//                    System.out.println("退出");
                    System.out.println("确认是否退出:Y/N");
                    char isExit = CMutility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
            }

        }

    }

    private void addNewCustomer(){
        System.out.println("-----添加客户-----");
        System.out.println("姓名：");
        String name = CMutility.readString(10);
        System.out.println("性别：");
        char gender = CMutility.readChar();
        System.out.println("年龄：");
        int age = CMutility.readInt();
        System.out.println("电话：");
        String phone = CMutility.readString(13);
        System.out.println("邮箱：");
        String email = CMutility.readString(30);

        Customer cuntomer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomers(cuntomer);
        if(isSuccess){
            System.out.println("-----添加完成-----");
        }else{
            System.out.println("-----已满，添加失败-----");
        }
    }

    private void modifyCustomer(){
        System.out.println("-----修改客户-----");

        Customer cust;
        int number;
        for(;;) {
            System.out.println("请选择修改客户的编号（-1退出）");
            number = CMutility.readInt();

            if(number==-1){
                return;
            }
            cust = customerList.getCustomer(number-1);
            if(cust == null){
                System.out.println("无法找到指定用户！");
            }else{
                //找到指定用户了
                break;
            }
        }
        System.out.println("姓名("+cust.getName()+"):");
        String name = CMutility.readString(10,cust.getName());
        System.out.println("性别("+cust.getGender()+"):");
        char gender = CMutility.readChar(cust.getGender());
        System.out.println("年龄("+cust.getAge()+"):");
        int age = CMutility.readInt(cust.getAge());
        System.out.println("电话("+cust.getPhone()+"):");
        String phone = CMutility.readString(13,cust.getPhone());
        System.out.println("邮箱("+cust.getEmail()+"):");
        String email = CMutility.readString(30,cust.getEmail());

        Customer newcustomer = new Customer(name,gender,age,phone,email);
        boolean isreplace = customerList.replaceCustomers(number-1, newcustomer);
        if(isreplace){
            System.out.println("-----修改完成-----");
        }else{
            System.out.println("-----修改失败-----");
        }
    }

    private void deleteCustomer(){
        System.out.println("-----删除客户-----");
        int number;
        Customer cust;
        for(;;){
            System.out.println("请输入要删除客户的编号(-1退出)");
            number = CMutility.readInt();

            if(number==-1){
                return;
            }
            cust = customerList.getCustomer(number-1);
            if(cust == null){
                System.out.println("无法找到指定用户！");
            }else{
                //找到指定用户了
                break;
            }
        }
        boolean isdelete = customerList.deleteCustomers(number-1);
        if(isdelete){
            System.out.println("-----删除完成-----");
        }else{
            System.out.println("-----删除失败-----");
        }


    }

    private void listAllCustomer(){
        System.out.println("-----客户列表-----");
        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("没有客户记录！");

        }else{
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
            Customer[] custs = customerList.getAllCustomers();

            for(int i = 0;i < custs.length;i++){
                Customer cust = custs[i];
                System.out.println((i+1)+"\t"+cust.getName()+
                        "\t"+cust.getGender()+"\t"+cust.getAge()+
                        "\t"+cust.getPhone()+"\t"+cust.getEmail());
            }
        }



        System.out.println("-----列表完成-----");

    }


    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}

package customer_util;

import java.util.Scanner;

public class CMutility {
    private static Scanner scanner = new Scanner(System.in);
    /*
    用于用户界面的选择，读取键盘输入1~5
     */
    public static char readMenuSelection(){
        char c;
        for(;;) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.println("选择错误，请重新输入:");
            } else break;
        }
        return c;
    }

    /*
    键盘读取一个字符，作为返回值
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }
    /*
    如果不输入直接回车，方法以defaultValue为返回值
     */
    public static char readChar(char defaultValue){
        String str = readKeyBoard(1,true);
        return(str.length()==0)?defaultValue:str.charAt(0);
    }
    /*
    读取一个长度不超过2位的整数
     */
    public static int readInt(){
        int n;
        for(;;){
            String str = readKeyBoard(2,false);
            try{
                n = Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;
    }

    public static int readInt(int defaultValue){
        int n;
        for(;;){
            String str = readKeyBoard(2,true);
            if(str.equals("")){
                return defaultValue;
            }

            try{
                n = Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;
    }
    /*
    读一个长度不超过limit的字符串
    直接回车就返回defaultValue
     */
    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }
    public static String readString(int limit,String defaultValue){
        String str = readKeyBoard(limit,true);
        return str.equals("")?defaultValue:str;
    }
    /*
    用于确认选择，“Y”或“N”
     */
    public static char readConfirmSelection(){
        char c;
        for(;;){
            String str = readKeyBoard(1,false).toUpperCase();
            c = str.charAt(0);
            if(c =='Y' || c == 'N'){
                break;
            }else{
                System.out.println("选择错误，请重新输入:");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean Blankreturn){
        String line = "";

        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.length()==0){
                if(Blankreturn) return line;
                else continue;
            }

            if(line.length() < 1 || line.length() > limit){
                System.out.println("输入长度（不大于"+limit+"）错误，请重新输入");
                continue;
            }
            break;
        }

        return line;
    }
}

package com.example.project_01;

import java.util.ArrayList;
import java.util.Stack;

public class Caculater {
    private String s;

    public Caculater(String s){
        this.s=s;
    }

    public String ketqua(){

        return ketqua(kiemtra(this.s));
    }


    // kiểm tra độ ưu tiên các toán tử
    public static int ktUuTien(char x){
        if ((x=='+')||(x=='-')) return 1;
        if ((x=='*')||(x=='/')) return 2;
        if ((x=='^')||(x=='!')) return 3;
        return 0;
    }


    //chuyển biển thức trung tố sang hậu tố
    public static ArrayList<String> kiemtra(String s){
        ArrayList<String> list = new ArrayList<String>();
        char[] s1=s.toCharArray();
        String temp="";
        Stack<String> stack= new Stack<>();
        for (int i=0;i<s1.length;i++){
//sử lý toán hạng
            if ((s1[i]>='0')&&(s1[i]<='9')){        //ghép các số liền kề lại thành toán hạng
                temp=temp+s1[i];
            }
            else if(s1[i]=='.'){                    //sử lý dấu thập phân
                temp=temp+s1[i];
            }
            else{

//sau 1 toán hạng là pi => có 1 toán tử * nằm ở giữa
//thêm toán hạng vào trước, sau đó thêm toán tử, rồi cuối thêm pi
                if ((i!=0)&&(s1[i]=='p')&&((s1[i-1]>='0')&&(s1[i-1]<='9'))){
                    list.add(temp);
                    temp="";

                    if ((stack.isEmpty())||(stack.peek().equals("("))){         //nếu stack rỗng hoặc là toán tử đầu tiên sau khi '('
                        stack.add("*");
                    }
                    else{
                        if (ktUuTien(stack.peek().charAt(0))>=ktUuTien('*')){     // khi stack đang có 1 toán tử ở đầu
                            list.add(stack.peek());
                            stack.pop();
                            temp=""+'*';
                            stack.add(temp);
                            temp="";
                        }
                        else {
                            temp=""+'*';
                            stack.add(temp);
                            temp="";
                        }
                    }

                }

                if ((i!=0)&&(s1[i]=='p')&&(s1[i-1]=='-')){
                    temp=temp+"p";
                    list.add(temp);
                    temp="";
                }
                else if(s1[i]=='p'){
                    temp=temp+"p";
                    list.add(temp);
                    temp="";

//sau pi là 1 toán hạng => có toán tử * nằm ở giữa
// thêm pi vào trước, sau đó mới thêm toán tử, rồi cuổi là thêm toán hạng (nằm sau pi)
                    if ((s1[i]=='p')&&(i<s1.length-1)){
                        if ((s1[i+1]>='0')&&(s1[i+1]<='9')){
                            if ((stack.isEmpty())||(stack.peek().equals("("))){         //nếu stack rỗng hoặc là toán tử đầu tiên sau khi '('
                                stack.add("*");
                            }
                            else{
                                if (ktUuTien(stack.peek().charAt(0))>=ktUuTien('*')){     // khi stack đang có 1 toán tử ở đầu
                                    list.add(stack.peek());
                                    stack.pop();
                                    temp=""+'*';
                                    stack.add(temp);
                                    temp="";
                                }
                                else {
                                    temp=""+'*';
                                    stack.add(temp);
                                    temp="";
                                }
                            }
                        }
                    }
                }


                else{


                    if(temp!=""){                       //ném toán hạng vào list
                        list.add(temp);
                        temp="";
                    }


// sử lý gặp '('
                    if (s1[i]=='('){
                        if((i>0)&&(((s1[i-1]>='0')&&(s1[i-1]<='9'))||(s1[i-1]=='p'))){                          //sử lý nếu trước '(' không có các toán tử
                            if(stack.size()==0){                                            //sử lý nếu nó là toán tử đầu tiên
                                temp=""+'*';
                                stack.push(temp);
                                temp="";
                            }

                            else if (ktUuTien(stack.peek().charAt(0))>=ktUuTien('*')){
                                list.add(stack.peek());
                                stack.pop();
                                temp=""+'*';
                                stack.add(temp);
                                temp="";
                            }
                            else {
                                temp=""+'*';
                                stack.add(temp);
                                temp="";
                            }
                        }
                        temp=""+s1[i];
                        stack.add(temp);
                        temp="";
                    }
//sử lý gặp ')'
                    else if(s1[i]==')'){
                        if (!stack.isEmpty())
                            while (!stack.peek().equals("(")){
                                temp=(String)stack.peek();
                                list.add(temp);
                                stack.pop();
                                temp="";
                            }
                        if(stack.peek().equals("(")) stack.pop();
                        // if ((!stack.isEmpty())&&(ktUuTien(stack.peek().charAt(0))>1)){        //nếu trước '(' là toán tử '*' hoặc '/' thì phải ném vào list luôn
                        //     list.add(stack.peek());
                        //     stack.pop();
                        // }

                        //sau ')' là 1 toán hạnghạng
                        if((i<s1.length-1)&&(((s1[i+1]>='0')&&(s1[i+1]<='9'))||(s1[i+1]=='p'))){
                            if ((stack.isEmpty())||(stack.peek().equals("("))){         //nếu stack rỗng hoặc là toán tử đầu tiên sau khi '('
                                stack.add("*");
                            }
                            else{
                                if (ktUuTien(stack.peek().charAt(0))>=ktUuTien('*')){     // khi stack đang có 1 toán tử ở đầu
                                    list.add(stack.peek());
                                    stack.pop();
                                    temp=""+'*';
                                    stack.add(temp);
                                    temp="";
                                }
                                else {
                                    temp=""+'*';
                                    stack.add(temp);
                                    temp="";
                                }
                            }
                        }


                    }
//sử lý khi gặp các toán tử
                    else {
                        if ((stack.isEmpty())||(stack.peek().equals("("))){         //nếu stack rỗng hoặc là toán tử đầu tiên sau khi '('

                            if ((i>0)&&(s1[i]=='-')&&(s1[i-1]=='(')){               //ngoại lệ: nếu '(' và toán tử '-' liên tục vs nhau, thì nó là dấu âm trong toán hạng
                                temp=""+'-';
                            }
                            else if((i==0)&&(s1[i]=='-')&&(s1[i+1]!='(')){                          //ngoại lệ: nếu dấu trừ là kí tự đầu tiên, nó sẽ là dấu âm của toán hạng đầu tiên
                                temp=""+'-';
                            }
                            else{                                                           //nếu stack rỗng hoặc là toán tử đầu tiên sau khi '(' sử lý đúng
                                temp=""+s1[i];
                                stack.add(temp);
                                temp="";
                            }
                        }
                        else{
                            if (ktUuTien(stack.peek().charAt(0))>=ktUuTien(s1[i])){     // khi stack đang có 1 toán tử ở đầu

                                while ((!stack.isEmpty())&&(ktUuTien(stack.peek().charAt(0))>=ktUuTien(s1[i]))){  //mỗi khi cho 1 toán tử vào stack: all trong < ngoài đưa vào
                                    list.add(stack.peek());
                                    stack.pop();
                                }
                                temp=""+s1[i];
                                stack.add(temp);
                                temp="";

                            }
                            else {
                                temp=""+s1[i];
                                stack.add(temp);
                                temp="";
                            }
                        }

                    }

                }




            }

        }
        if (temp!="") {                 //nếu cuối biểu thức ko phải là ')' ném toán hạng cuối cùng vào list
            list.add(temp);
        }
//sử lý khi xét hết biểu thức. ném các toán tử còn lại trong stack vào list
        while(!stack.isEmpty()){
            if(!stack.peek().equals("(")){          //sử lý '(' còn trong stack, khi biểu thức bị thiếu ')'
                temp=""+stack.peek();
                list.add(temp);
            }
            stack.pop();
        }

        return list;
    }


    public static String ketqua(ArrayList<String> list){
        Stack<String> stack= new Stack<>();
        double temp1,temp2;
        for (int i=0;i<list.size();i++){
            if (list.get(i).equals("!")){                   // sử lý giai thừa
                if (stack.peek().equals("p")){
                    temp2=Math.PI;
                }
                else if(stack.peek().equals("-p")){
                    temp2=-Math.PI;
                }
                else{
                    temp2=Double.parseDouble(stack.peek());
                }
                stack.pop();
                if (temp2%1!=0){
                    return "error";
                }
                temp1=1;
                for(int j=1;j<=temp2;j++){
                    temp1=temp1*j;
                }
                stack.push(String.valueOf(temp1));

            }
            else if ((list.get(i).length()>1)||(((list.get(i).charAt(0)>='0')&&(list.get(i).charAt(0)<='9'))||(list.get(i).charAt(0)=='p'))){
                stack.add(list.get(i));
            }
            else if ((stack.size()<2)&&(list.get(i).charAt(0)=='-')){           // nếu biểu thức có dạng -(x),  nhưng sẽ bị lỗi nếu biểu thức đầu vào là: x-
                if (stack.peek().equals("p")){
                    temp2=-Math.PI;
                }
                else {
                    temp2=-Double.parseDouble(stack.peek());
                }
                stack.pop();
                stack.push(String.valueOf(temp2));

            }
            else if (stack.size()<2){
                return "error";
            }
            else{
                if (stack.peek().equals("p")){
                    temp1=Math.PI;
                }
                else if(stack.peek().equals("-p")){
                    temp1=-Math.PI;
                }
                else{
                    temp1=Double.parseDouble(stack.peek());
                }

                stack.pop();
                if (stack.peek().equals("p")){
                    temp2=Math.PI;
                }
                else if(stack.peek().equals("-p")){
                    temp2=-Math.PI;
                }
                else{
                    temp2=Double.parseDouble(stack.peek());
                }
                stack.pop();

                if(list.get(i).equals("+")){
                    temp2=temp2+temp1;
                }
                else if(list.get(i).equals("-")){
                    temp2=temp2-temp1;

                }
                else if(list.get(i).equals("*")){
                    temp2=temp2*temp1;
                }
                else if(list.get(i).equals("/")){
                    temp2=temp2/temp1;
                }
                else if(list.get(i).equals("^")){
                    temp2=Math.pow(temp2, temp1);
                }
                stack.push(String.valueOf(temp2));
            }


        }
        if (stack.peek().equals("p")){
            return String.valueOf(Math.PI);
        }
        else if (stack.peek().equals("-p")){
            return String.valueOf(-Math.PI);
        }
        else if (Double.parseDouble(stack.peek())%1==0){
            return String.valueOf((long) Double.parseDouble(stack.peek()));
        }
        return stack.peek();
    }
}

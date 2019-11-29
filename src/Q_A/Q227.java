package Q_A;

import java.util.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Q227 {
    /**
     * fault mind.it is not true.
     * @param s
     * @return
     */
    public int calculate_error(String s) {
        s = s.replaceAll(" ","");
        int result = 0;
        //1.将运算符和运算数分开
        List<Integer> integers = new ArrayList<Integer>();
        List<Character> characters = new ArrayList<Character>();

        int i;
        int j = 0;
        for ( i = 0; i <s.length() ;) {
            //寻找运算数
            while(i <s.length()&&(i+1)<s.length()&&!isOperation(s.charAt(i))&&!isOperation(s.charAt(i+1))) i++;

            if(i<s.length()&&j<=i){
                integers.add(new Integer(s.substring(j,i+1)));
                i++;
            }
            if(i<s.length()&&isOperation(s.charAt(i))){
                characters.add(s.charAt(i));
                j = i+1;
                i++;
            }
            if(i>=s.length()) break;
        }

        //根据逆波兰式求解
        //创建两个运算符栈和运算数栈
        Stack<Integer> integerStack = new Stack<Integer>();
        Stack<Character> charStack = new Stack<Character>();
        //运算符优先级
        HashMap<Character, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put('+',1);
        stringIntegerHashMap.put('-',1);
        stringIntegerHashMap.put('*',2);
        stringIntegerHashMap.put('/',2);


        for (int k = 0; k < integers.size()-1; k++) {
            if(k==0) {
                integerStack.push(integers.get(0));
                charStack.push(characters.get(0));
            }
            else{
                if(stringIntegerHashMap.get(characters.get(k))>stringIntegerHashMap.get(charStack.peek())){
                    charStack.push(characters.get(k));
                    integerStack.push(integers.get(k));
                }else{
                    int num1 = integerStack.pop();
                    int num2 = integerStack.pop();
                    integerStack.push(cal(num2,num1,charStack.pop()));
                    charStack.push(characters.get(k));
                }
            }
        }
        integerStack.push(integers.get(integers.size()-1));
        while(!charStack.empty()){
            int num1 = integerStack.pop();
            int num2 = integerStack.pop();
            integerStack.push(cal(num2,num1,charStack.pop()));
        }
        result = integerStack.pop();

        /*integers.forEach(System.out::println);
        characters.forEach(System.out::println);*/

        return result;
    }

    public static boolean isOperation(char ch){
        if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
            return true;
        return false;
    }

    public static int cal(Integer num1,Integer num2,char op){
        int result = 0;
        switch (op){
            case '+':result = num1+num2;break;
            case '-':result = num1-num2;break;
            case '*':result = num1*num2;break;
            case '/':result = num1/num2;break;
        }
        return result;
    }


    /**
     * js解决
     * @param s
     * @return
     */
    public  int calculate(String s){
        int result = 0;
        Object temp = null;
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        try {
            temp = nashorn.eval(s);
            if(temp instanceof  Integer){
                result  = (Integer)temp;
            }else{
                result = ((Double)temp).intValue();
            }

        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q227().calculate("12*(360/9+60)"));//1200
        System.out.println(new Q227().calculate("(347+34)/(75-72)"));//127
        System.out.println(new Q227().calculate("99/33-8*99/8+8/8"));//-95



    }
}

package Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Cal {
    public  static Object calculate(String s){
        Object object =  null;
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        try {
            object = nashorn.eval(s);
        } catch (ScriptException e) {
            object = "请输入正确表达式！！！ please input the correct formula!!!";
        }
        return object;
    }
    public static void main(String[] args) {
            System.out.println(calculate("(347+34.5)/(75-72)+34*3").toString());
    }

}

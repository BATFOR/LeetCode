package Q_A;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 李嘉豪, 1316374518@qq.com
 * @createTime 2020/1/9 17:23
 * @description
 **/
public class Q20 {
	public boolean isValid(String s) {
		String left = "({[";
		HashMap<Character, Character> left_right = new HashMap<>();
		left_right.put('(',')');
		left_right.put('{','}');
		left_right.put('[',']');
		Stack<Character> characters = new Stack<>();
		Character temp;

		for(int i = 0,len = s.length();i<len;++i){
			temp = s.charAt(i);
			if(left.indexOf(temp)!=-1){
				characters.push(temp);
			}else{
				if(!characters.empty()&&left_right.get(characters.pop()).equals(temp)){
					continue;
				}else{
					return false;
				}
			}
		}
		if(!characters.empty())
			return  false;
		return true;
	}
	public boolean isValid_B(String s) {
		while(s.contains("()")||s.contains("[]")||s.contains("{}")){
			s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}","");
		}
		if(s.equals(""))
			return true;
		return false;

	}


	public static void main(String[] args) {
		System.out.println(new Q20().isValid_B("([{}])"));
	}
}

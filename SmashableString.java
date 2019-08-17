import java.util.*;

public class SmashableString {

	public boolean isSmashableString(String str, Set<String> dict) {
		if(str == null || str.trim().isEmpty() || !dict.contains(str)) {
			return false;
		}
		return checkSmash(str, dict);
	}
	
	private boolean checkSmash(String str, Set<String> dict) {
		if(str.length() == 1) {
			return dict.contains(str);
		}
			
		for(int i=0;i<str.length();i++) {
			String ns = new StringBuilder(str).deleteCharAt(i).toString();
			if(dict.contains(ns)) {
				if(checkSmash(ns, dict)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		SmashableString smashableString = new SmashableString();
		Set<String> dict = new HashSet<>();
		dict.add("SPRINT");
		dict.add("PRINT");
		dict.add("PINT");
		dict.add("PIT");
		dict.add("IT");
		dict.add("I");
		boolean b = smashableString.isSmashableString("SPRINT", dict);
		System.out.println(b);
	}
}
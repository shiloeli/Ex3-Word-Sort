
public class Ex3 {

	// 1
	public static String[] sentence(String s) {
		if (s=="")
		{
			String[] str3 = new String[1];
		str3[0]="";
		return str3;
		}
		int count = 0;
		String str1 = "";
		String[] str3 = new String[s.length()];
		int j = 0;

		
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()) {
				if (s.charAt(i) != ' ' && s.charAt(i) != '.' && s.charAt(i) != ',') {
					if (s.charAt(i + 1) == ' ' || s.charAt(i + 1) == '.' || s.charAt(i + 1) == ',') {
						count++;
					}
				}
			}
		}
		if (s.charAt(s.length() - 1) != ' ' && s.charAt(s.length() - 1) != '.' && s.charAt(s.length() - 1) != ',') {
			count++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && s.charAt(i) != '.' && s.charAt(i) != ',') {
				str1 += s.charAt(i);
			}
			if (i + 1 < s.length()) {
				if (s.charAt(i) == ' ' || s.charAt(i) == '.' || s.charAt(i) == ',') {
					if (s.charAt(i + 1) != ' ' && s.charAt(i + 1) != '.' && s.charAt(i + 1) != ',' && str1 != "") {
						str3[j++] = str1;
						str1 = "";
					}
				}
			}
		}
		str3[j++] = str1;
		String[] str4 = new String[count];
		for (int i = 0; i < count; i++) {
			str4[i] = str3[i];
		}
		return str4;
	}

	// 2
	public static void Sorty(String[] st) {
		boolean flag = true;
		for (int i = 0; flag && i < st.length; i++) {
			flag = false;
			for (int k = 0; k < st.length - 1 - i; k++) {
				if (st[k].compareTo(st[k + 1]) > 0) {
					flag = true;
					String temp = st[k];
					st[k] = st[k + 1];
					st[k + 1] = temp;
				}
			}
		}
	}

	public static String[] dictionary(String s) {
		String[] str4 = sentence(s);
		int count = str4.length;
		for (int i = 0; i < str4.length; i++) {
			for (int k = 0; k < str4.length; k++) {
				if (str4[i].equals(str4[k]) && i != k && str4[i] != " ") {
					count--;
					str4[k] = " ";
				}
			}
		}
		String[] str5 = new String[count];
		int a = 0;
		for (int i = 0; i < str4.length; i++) {
			if (str4[i] != " ") {
				str5[a++] = str4[i];
			}
		}
		Sorty(str5);
		return str5;
	}

	// 3
	public static boolean sub(String s, String t) {
		if(t=="")return true;
		else if (s=="")return false;
		String[] a = dictionary(s);
		String[] b = dictionary(t);
		boolean flag = false;
		int count = b.length;
		if (b.length > a.length) {
			return false;
		}
		for (int k = 0; k < b.length; k++) {
			for (int i = 0; i < a.length; i++) {
				if (b[k].compareTo(a[i]) == 0) {
					count--;
				}
			}
		}
		if (count == 0) {
			flag = true;
		}
		return flag;
	}
}
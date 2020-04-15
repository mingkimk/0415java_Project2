package Server;

import java.util.ArrayList;

import DB.DAOCenter;

public class ServerCenter {
	private ArrayList<ServerChat> sList = new ArrayList<>();
	private DAOCenter dc = null;
	private String[] check = null;

	public void addServerChat(ServerChat s) {
		this.sList.add(s);
	}

	public void select(Object objectMember) {

		System.out.println(objectMember);

		check = (String[]) objectMember;
		System.out.println("����ȯ? : " + check);
		for (int i = 0; i < check.length; i++) {
			if (check[check.length - 1].equals("Login")) {
				System.out.println(check[i]);
				System.out.println("Ȯ��!!" + check[check.length - 1]);
			}
			dc=new DAOCenter();
			dc.Select(check);
			
		}
		String m = "member";
		// System.out.println(objectMember);

		dc.whichone(objectMember, m);

//			      Object Object_Array[] = new Object[100];
//
//			      String String_Array[] = Arrays.copyOf(Object_Array, Object_Array.length, String[].class);
//			      for (int i = 0; i < String_Array.length; i++) {
//			         String_Array[i] = Object_Array[i].toString();
//			         System.out.println(String_Array[i]);
//			      }
//			   }
	}

}
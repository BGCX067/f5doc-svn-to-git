package com.leadtone.gegw.f5Balance;

import java.util.Comparator;

public class UserComparator implements Comparator {
	
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Poolmember p1 = (Poolmember) o1;
		Poolmember p2 = (Poolmember) o2;
		int result = 0;

		if (p1.getUsers() == p2.getUsers()) {
			result = 0;
		}
		if (p1.getUsers() < p2.getUsers()) {
			result = -1;
		}
		if (p1.getUsers() > p2.getUsers()) {
			result = 1;
		}
		return result;
	}

}

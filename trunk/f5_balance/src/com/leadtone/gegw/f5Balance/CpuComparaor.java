package com.leadtone.gegw.f5Balance;

import java.util.Comparator;

public class CpuComparaor implements Comparator {


	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Poolmember p1 = (Poolmember) o1;
		Poolmember p2 = (Poolmember) o2;
		int result = 0;
		if (p1.getCpu_usage() == p2.getCpu_usage()) {
			result = 0;
		}
		else if (p1.getCpu_usage() < p2.getCpu_usage()) {
			result = -1;
		}
		else if (p1.getCpu_usage() > p2.getCpu_usage()) {
			result = 1;
		}
		return result;
	}

}

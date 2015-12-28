package com.leadtone.gegw.f5Balance;

import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Poolmember> poolMembers = new ArrayList<Poolmember>();
		
		poolMembers.add(new Poolmember(0,20,0.3f));
		poolMembers.add(new Poolmember(1,20,0.2f));
		poolMembers.add(new Poolmember(2,20,0.2f));
		poolMembers.add(new Poolmember(3,20,0.3f));
		
		Balancer balancer = new Balancer(poolMembers);
		balancer.balance();
	}

}

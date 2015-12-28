package com.leadtone.gegw.f5Balance;

import java.util.Collections;
import java.util.List;

public class Balancer {
	
	private List<Poolmember> members;
	
	private int total_users ;
	
	
	public Balancer(List<Poolmember> _members)
	{
		this.members = _members;
		for (Poolmember poolmember : _members) {
			total_users += poolmember.getUsers();
		}
		System.out.println("total users: "+total_users);
		System.out.println("total members: "+members.size());
	}
	
	private void balanceByusers()
	{
//		Collections.sort(this.members, new UserComparator());
//		int current_priority = 0;
//		for(int i = 0 ; i < this.members.size()-1;  i++)
//		{
//			if(members.get(i).getUsers()==members.get(i+1).getUsers())
//			{
//				members.get(i).setPriority(current_priority);
//				members.get(i+1).setPriority(current_priority);
//			}
//			else
//			{
//				members.get(i).setPriority(current_priority);
//				members.get(i+1).setPriority(++current_priority);
//			}
//		}
		
		for(int i = 0 ; i <  this.members.size() ; i++)
		{
			Poolmember member = members.get(i);
			double users = member.getUsers();
			System.out.println(users / total_users);
		}
		
		
	}
	
	private void balanceBycpu()
	{
		Collections.sort(this.members,new CpuComparaor());
		
		int current_priority = 0;
		for(int i = 0 ; i < this.members.size()-1;  i++)
		{
			if(members.get(i).getCpu_usage()==members.get(i+1).getCpu_usage())
			{
				members.get(i).setPriority(current_priority);
				members.get(i+1).setPriority(current_priority);
			}
			else
			{
				members.get(i).setPriority(current_priority);
				members.get(i+1).setPriority(++current_priority);
			}
		}
	}
	
	public List<Poolmember> balance()
	{
		boolean isCpuOverload = false;
		for (int i = 0; i < this.members.size(); i++) {
			Poolmember poolMember = (Poolmember) this.members.get(i);
			float cpu_usage = poolMember.getCpu_usage();
//			如果有通讯机的cpu利用率超过阀值
			if(cpu_usage > 0.4)
			{
				System.out.println("Cpu overload!!!");
				isCpuOverload = true;
				break;
			}
		}
		
		if(isCpuOverload)
			balanceBycpu();
		else
			balanceByusers();
		showByPriority();
		return this.members;
	}
	
	@SuppressWarnings("unchecked")
	public void showByPriority()
	{
		Collections.sort(this.members);
		for (@SuppressWarnings("unused")
		Poolmember poolmember : this.members) {
			System.out.println("--------------------------------");
			System.out.println("id: "+poolmember.getPoolId());
			System.out.println("users: "+poolmember.getUsers());
			System.out.println("cpu: "+poolmember.getCpu_usage());
			System.out.println("priority: "+poolmember.getPriority());
			
		}
	}

	public int getTotal_users() {
		return total_users;
	}

	public void setTotal_users(int total_users) {
		this.total_users = total_users;
	}
}

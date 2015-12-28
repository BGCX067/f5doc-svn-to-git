package com.leadtone.gegw.f5Balance;

public class Poolmember implements Comparable{
	int poolId;
	long priority;
	int users;
	float cpu_usage;
	
	public Poolmember(int id , int users , float cpu_usage)
	{
		this.poolId = id;
		this.users = users;
		this.cpu_usage = cpu_usage;
	}
	
	public int getPoolId() {
		return poolId;
	}
	public void setPoolId(int poolId) {
		this.poolId = poolId;
	}
	public long getPriority() {
		return priority;
	}
	public void setPriority(long priority) {
		this.priority = priority;
	}
	public int getUsers() {
		return users;
	}
	public void setUsers(int users) {
		this.users = users;
	}
	public float getCpu_usage() {
		return cpu_usage;
	}
	public void setCpu_usage(float cpu_usage) {
		this.cpu_usage = cpu_usage;
	}
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Poolmember compare_to = (Poolmember) o;
		int result = 0;
		
		if (this.getPriority() == compare_to.getPriority())
			result = 0;
		else if(this.getPriority() < compare_to.getPriority())
			result = -1;
		else if(this.getPriority() > compare_to.getPriority())
			result = 1;
		return result;
	}
}

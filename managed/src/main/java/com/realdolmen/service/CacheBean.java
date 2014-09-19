package com.realdolmen.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.transaction.UserTransaction;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class CacheBean {
	private List<Object> cache = new ArrayList<>();

	@Lock(LockType.READ)
	public Object get(int index) {
		return cache.get(index);
	}
	
	@Lock(LockType.WRITE)
	public void addEntry(Object o) {
		cache.add(o);
	}
	
	@Lock(LockType.WRITE)
	public void evict(Object o) {
		cache.remove(o);
	}
}

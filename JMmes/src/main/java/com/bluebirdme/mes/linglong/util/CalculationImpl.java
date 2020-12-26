package com.bluebirdme.mes.linglong.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CalculationImpl {
	public int add(int i,int j){
		int result=i+j;
		return result;
	}
	
	public int sub(int i,int j){
		int result = i-j;
		return result;
		
	}
}

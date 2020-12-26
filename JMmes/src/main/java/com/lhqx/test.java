package com.lhqx;

import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		 PIReturnObject pi;
		 WSImplement service = new WSImplement();
		System.out.println("test start");
		 WSInterface portType = service.getBasicHttpBindingWSInterface();
		 pi= portType.queryRealData("FCSA08L","CDT158","20191219111010","20191219112010");
		 ArrayOfanyType AA =pi.getRPidata();
		 List<Object> bb=  AA.getAnyType();
		 System.out.print(bb);
		 
	}

}

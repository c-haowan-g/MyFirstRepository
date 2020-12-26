package com.bluebirdme.mes.linglong.halfpart.entity;

public class Carinfo {

	public Carinfo(String batchno, String promachine, String proworker,
			String pronumber, String waittime, String materielname,
			Boolean isoverdue) {
		this.batchno = batchno;
		this.promachine = promachine;
		this.proworker = proworker;
		this.pronumber = pronumber;
		this.waittime = waittime;
		this.isoverdue = isoverdue;
		this.materielname = materielname;
	}

	String materielname = "";
	String batchno = "";
	String promachine = "";
	String proworker = "";
	String pronumber = "";
	String waittime = "";
	Boolean isoverdue = Boolean.valueOf(false);
}

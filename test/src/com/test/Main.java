package com.test;

import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		
		//20201225 ���� ͣ���շ���ϰ-02
		//��ʼʱ��
		Date fromdate = new Date();
		//����ʱ��
		Long todate = System.currentTimeMillis() + 254 * 60000;
		//ͣ��ʱ��
		long min = (todate - fromdate.getTime())/60000;
		//��Сʱ
		long z = min/60;
		//��������
		long l = min%60;
		System.out.println("ͣ��ʱ�䣺" + z + "Сʱ��" + l + "����");
		System.out.println("�Ʒѱ�׼��ÿСʱ10Ԫ�����ڵ���15���Ӱ�һСʱ�Ʒ�");
		if (l < 15) {
			System.out.println("ͣ�����ã�" + z*10 + "Ԫ");
		} else {
			System.out.println("ͣ�����ã�" + (z + 1)*10 + "Ԫ");
		}
	}

}

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;

public class MemberFileReader {
	Scanner sc = null;
	
	public MemberFileReader(File f) throws FileNotFoundException {
		sc = new Scanner(f);
	}
	public ArrayList<Member> readMember() {
		ArrayList<Member> retObj = new ArrayList<Member>();
		while(sc.hasNext()) {
			Member m = new Member();
			String strArr[] = sc.nextLine().split("\t");
			// fieldCount : tap + 1: member의 필드수
			// fieldCount : 입력받고자 했던 필드 수, strArr.length : 실제 입력된 필드 수
			int fieldCount = 4;
			String newStrArr[] = new String[fieldCount];
			if(fieldCount != strArr.length) {
				for(int i =0; i <strArr.length; i++)
					newStrArr[i] = strArr[i];
				for(int i = strArr.length; i<fieldCount; i++)
					newStrArr[i] = "";
			}
			m.setUid(strArr[0]);
			m.setUpw(strArr[1]);
			m.setUname(strArr[2]);
			m.setContect(strArr[3]);
			retObj.add(m);			
		}
		return retObj;
	}
}
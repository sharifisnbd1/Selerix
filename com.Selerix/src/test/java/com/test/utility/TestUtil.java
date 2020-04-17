package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]>myData=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader("C:\\Users\\shari\\eclipse-workspace\\com.Selerix\\src\\test\\java\\com\\testdata\\DelaneyData.xlsx");
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("Delaney"); rowNum++) {
			
			String userID=reader.getCellData("Delaney", "userID", rowNum);
			String password=reader.getCellData("Delaney", "password", rowNum);
			String basePremium=reader.getCellData("Delaney", "basePremium", rowNum);
			String yearStayed=reader.getCellData("Delaney", "yearStayed", rowNum);
			String stateOfBirth=reader.getCellData("Delaney", "stateOfBirth", rowNum);
			String countryOfBirth=reader.getCellData("Delaney", "countryOfBirth", rowNum);
			String pinForSign1=reader.getCellData("Delaney", "pinForSign1", rowNum);
			String pinForSign2=reader.getCellData("Delaney", "pinForSign2", rowNum);
			
			Object ob[]= {userID,password,basePremium,yearStayed,stateOfBirth,countryOfBirth,pinForSign1,pinForSign2};
			myData.add(ob);
			
		}
		return myData;
		
	}
		
		
		
		
	}
	
	
	
	



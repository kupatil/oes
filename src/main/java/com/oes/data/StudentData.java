package com.oes.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.oes.constants.FilePaths;
import com.oes.pojos.Student;

public class StudentData {

	XlsReader oesXlsReader;
	public StudentData() {
		oesXlsReader = new XlsReader(FilePaths.OES_XLS_FILE, "student");
	}

	public List<Student> getAllStudents() {
		Map<Integer, Map<Integer, String>> data = oesXlsReader.getAllData();
		Set<Integer> rows = data.keySet();
		List<Student> list = new ArrayList<Student>();
		for (Integer row : rows) {
			if(row == 0) continue;
			Map<Integer, String> rowData = data.get(row);
			Set<Integer> cols = rowData.keySet();
			Student student = new Student();
			for (Integer col : cols) {
				String value = rowData.get(col);
				switch (col) {
				case 0:
					student.setId((int)Double.parseDouble(value));
					break;
				case 1:
					student.setFirstName(value);
					break;
				case 2:
					student.setLastName(value);
					break;
				case 3:
					student.setQualification(value);
					break;
				case 4:
					student.setMobile(value);
					break;
				case 5:
					student.setEmail(value);
					break;
				case 6:
					student.setPassword(value);
					break;
				default:
					break;
				}
			}
			list.add(student);
			
		}
		return list;
	}



}

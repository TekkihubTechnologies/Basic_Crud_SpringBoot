package com.tekkihub.demoApp.apis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tekkihub.demoApp.model.DataFromUI;
import com.tekkihub.demoApp.model.FirstTable;
import com.tekkihub.demoApp.repository.FirstTableRepository;

@Service
@Component
public class ApiServiceImpl implements ApiService{

	@Autowired
	private FirstTableRepository firstTableRepositpry;
	
	@Override
	public Boolean createDatas(DataFromUI firstTable) {
		Boolean created = false;
		try {
			FirstTable firstTableObj = new FirstTable();
			firstTableObj.setComments(firstTable.getComments());
			firstTableObj.setStudentClass(firstTable.getStudentClass());
			firstTableObj.setStudentName(firstTable.getStudentName());
			firstTableRepositpry.save(firstTableObj);
			created = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return created;
	}

	@Override
	public List<FirstTable> getAllDatas() {
		return firstTableRepositpry.findAll();
	}

	@Override
	public Boolean deleteDatas(Long firstTableId) {
		Boolean deleted = false;
		try{
			firstTableRepositpry.deleteById(firstTableId);
			deleted = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	@Override
	public Boolean editDatas(FirstTable firstTable) {
		Boolean edited = false;
		try {
			FirstTable firstTablObj = firstTableRepositpry.getOne(firstTable.getId());
			firstTablObj.setComments(firstTable.getComments());
			firstTablObj.setStudentClass(firstTable.getStudentClass());
			firstTablObj.setStudentName(firstTable.getStudentName());
			firstTableRepositpry.save(firstTablObj);
			edited = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return edited;
	}

}

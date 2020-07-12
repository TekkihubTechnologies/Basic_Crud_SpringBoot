package com.tekkihub.demoApp.apis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tekkihub.demoApp.model.DataFromUI;
import com.tekkihub.demoApp.model.FirstTable;

@Service
public interface ApiService{
	Boolean createDatas(DataFromUI firstTable);
	Boolean editDatas(FirstTable firstTable);
	List<FirstTable> getAllDatas();
	Boolean deleteDatas(Long firstTableId);
}

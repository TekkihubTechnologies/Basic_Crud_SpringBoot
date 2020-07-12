package com.tekkihub.demoApp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekkihub.demoApp.apis.service.ApiService;
import com.tekkihub.demoApp.model.DataFromUI;
import com.tekkihub.demoApp.model.FirstTable;

@RestController
public class ApiServiceController {
	
	@Autowired
	private ApiService apiService;
	
	@PostMapping("/api/createDatas")
	ResponseEntity<Void> createDatas(@RequestBody DataFromUI firstTable){
		Boolean created = apiService.createDatas(firstTable);
		if(created) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@PutMapping("/api/editDatas")
	ResponseEntity<Void> editDatas(@RequestBody FirstTable firstTable){
		Boolean edited = apiService.editDatas(firstTable);
		if(edited) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@DeleteMapping("/api/deleteData/{firstTableId}")
	ResponseEntity<Void> createDatas(@PathVariable Long firstTableId){
		Boolean deleted = apiService.deleteDatas(firstTableId);
		if(deleted) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@GetMapping("/api/getAllDatas")
	ResponseEntity<List<FirstTable>> getAllDatas(){
			return new ResponseEntity<List<FirstTable>>(apiService.getAllDatas(), HttpStatus.OK);
	}
}

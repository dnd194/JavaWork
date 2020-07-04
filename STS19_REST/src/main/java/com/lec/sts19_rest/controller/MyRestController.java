package com.lec.sts19_rest.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.EmployeeListVO;
import com.lec.sts19_rest.board.beans.EmployeeVO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
@RequestMapping("/MyRest")
public class MyRestController {
	
	@RequestMapping("/")
	public String helloTEXT() {
		return "Hello Rest";
	}
	
	@GetMapping("/helloJSON")
	public BWriteDTO helloJSON() {
		BWriteDTO dto = 
				new BWriteDTO(100,"하위","REST", "JSON헤헷",
						123,new Timestamp(10000));
		
		return dto;
	}
	
	//json 데이터 <-- 자바 list<>
	@GetMapping("/listJSON")
	public List<BWriteDTO> listJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		return dao.select();
		
	}
	
	//json 데이터 <== 자바 배열
	@GetMapping("/arrJSON")
	public BWriteDTO[] arrJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		BWriteDTO[] arr = new BWriteDTO[list.size()];
		return list.toArray(arr);
		
	}
	
	//JSON 데이터 <== 자바 MAP <>
	@GetMapping("/mapJSON")
	public Map<Integer, BWriteDTO> mapJson(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		Map<Integer, BWriteDTO> map = new HashMap<Integer, BWriteDTO>();
		
		for(BWriteDTO dto : list) {
			map.put(dto.getUid(), dto);
		}
		
		return map;
		
	}
	
	//XML 데이터 <== 자바 객체
	@GetMapping("/helloXML")
	public EmployeeVO helloXML() {
		return new EmployeeVO(100,"갬자",200,new int[] {20,20,20},22.2);
		
	}
	
	@GetMapping("/listXML")
	public EmployeeListVO listXML() {
		EmployeeListVO employees = new EmployeeListVO();
		
		EmployeeVO emp1 = new EmployeeVO(1,"갬자갬자",27, new int[] {20,20,20},22.2 );
		EmployeeVO emp2 = new EmployeeVO(2,"갬자갬자",28, new int[] {30,30,30},22.2 );
		EmployeeVO emp3 = new EmployeeVO(3,"갬자갬자",29, new int[] {40,40,40},22.2 );
		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp2);
		employees.getEmployees().add(emp3);
		
		
		
		return employees;
	}
	
	@GetMapping("/read/{uid}")
	public ResponseEntity<BWriteDTO> read (@PathVariable("uid") int uid) {
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = (BWriteDTO)dao.selectByUid(uid).get(0);
		
		//실패
		if(dto == null) return new ResponseEntity<BWriteDTO>(HttpStatus.NOT_FOUND);//404
		
		//성공
		return new ResponseEntity<BWriteDTO>(dto, HttpStatus.OK); //200
		
	}
	
	
}



















package com.sy.ticketsMgrSysEmpProv_8002.controller;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.NewMethodTypeMunger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.ticketsMgrSysEmpProv_8002.service.EmpService;
import com.sy.ticketsMgrSysEmpProv_8002.util.GetEmpAccount;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;
import com.yueqian.ticketsMgr_domain_9000.domain.sysMgr.RolesVO;

@RestController
@RequestMapping("/emp")
public class EmpInfoController {
	@Resource
	private EmpService empservice;
	
	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public EmpVO login(@RequestBody EmpVO emp){
		EmpVO em = empservice.getEmpByAccount(emp.getAccount());
		int dutyFlag = 0;
		if(!emp.getAccount().equals("") && !emp.getPwd().equals("")) {
			if(em!=null && emp.getPwd().equals(em.getPwd())) {
				
				return em;
			}else {
				return null;
			}
		}
		return null;
	}
	/**
	 * 获取所有角色
	 */
	@RequestMapping("/getEmps")
	public List<EmpVO> getEmps() {
		return empservice.getEmps();
	}
	/**
	 * 获取指定的角色
	 */
	@RequestMapping("/getEmpsByDuty/{roleId}")
	public List<EmpVO> getEmpsByDuty(@PathVariable int roleId) {
		List<EmpVO> list = empservice.getEmpsByDuty(roleId);
		System.out.println(list);
		return list;
	}
	/**
	 * 获取所有的角色信息
	 */
	@RequestMapping("/getRoles")
	public List<RolesVO> getRoles() {
		return empservice.getRoles();
	} 
	/**
	 * 获取所有角色
	 */
//	@RequestMapping("/getEmpsByDuty")
//	public Map<String, List<EmpVO>> getEmpsByDuty() {
//		Map<String, List<EmpVO>> map = new HashMap<>();
//		List list = new ArrayList<>();
//		List<EmpVO> emps = empservice.getEmps();
//		for (EmpVO empVO : emps) {
//			
//				System.out.println(empVO.toString());
//				list.add(empVO);
//				//map.put(empVO.getDuty(), list);
//			
//		}
//		return map ;
//	}
	/**
	 * 获取指定角色
	 */
	@RequestMapping("/getEmpById/{empId}")
	public EmpVO getEmpById(@PathVariable int empId) {
		return empservice.getEmpById(empId);
	}
	/**
	 * 新增 
	 */
	@RequestMapping("/addEmp")
	public boolean addEmp(@RequestBody EmpVO emp) {
		GetEmpAccount account = new GetEmpAccount();
		account.getAccountRandom();
		return empservice.addEmp(emp);
	}
	/**
	 * 删除
	 */
	@RequestMapping("/removeEmpById/{empId}")
	public boolean removeEmpById(@PathVariable int empId) {
		EmpVO list = empservice.getEmpById(empId);
		System.out.println(list);
		return empservice.removeEmpById(empId);
	}
	/**
	 * 修改
	 */
	@RequestMapping("/modifyEmp")
	public boolean modifyEmp(@RequestBody EmpVO emp) {
		return empservice.modifyEmp(emp);
	}
	/**
	 * 修改密码
	 */
	@RequestMapping("/modifyPwd")
	public boolean modifyPwd(@RequestBody EmpVO emp) {
		return empservice.modifyPwd(emp);
	}
	/**
	 * 查询账号和密码
	 */
	@RequestMapping("/findEmpByAccountAndPwd")
	public boolean findEmpByAccountAndPwd(@RequestBody EmpVO emp) {
		return empservice.findEmpByAccountAndPwd(emp);
	}
	/**
	 * 检测电话是否存在
	 */
	@RequestMapping("/getTelephone/{telephone}")
	public boolean getTelephone(@PathVariable String telephone) {
		return empservice.getTelephone(telephone);
	}
	/**
	 * 检测身份证号是否重复
	 */
	@RequestMapping("/getIdCardNum/{idCardNum}")
	public boolean getIdCardNum(@PathVariable String idCardNum) {
		return empservice.getIdCardNum(idCardNum);
	}
	
	

}

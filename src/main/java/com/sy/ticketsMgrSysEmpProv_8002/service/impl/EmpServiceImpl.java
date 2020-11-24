package com.sy.ticketsMgrSysEmpProv_8002.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sy.ticketsMgrSysEmpProv_8002.mapper.EmpMapper;
import com.sy.ticketsMgrSysEmpProv_8002.service.EmpService;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.PageVO;
import com.yueqian.ticketsMgr_domain_9000.domain.sysMgr.RolesVO;

@Service("EmpService")
public class EmpServiceImpl implements EmpService {
	@Resource
	private EmpMapper empMapper;
	/**
	 * 登录
	 */
	@Override
	public boolean findEmpByAccountAndPwd(EmpVO emp) {
		EmpVO empAP = empMapper.findEmpByAccountAndPwd(emp);
		if(empAP.getAccount() != null && empAP.getPwd()!=null) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 获取所有角色
	 */
	@Override
	public List<RolesVO> getRoles() {
		List<RolesVO> list = empMapper.getRoles();
		return list;
	}
/**
 * 查询所有信息
 */
	@Override
	public List<EmpVO> getEmps() {
		List<EmpVO> list = empMapper.getEmps();
		return list;
	}
	/**
	 * 查询指定员工
	 */
	@Override
	public List<EmpVO> getEmpsByDuty(int roleName) {
		
		return empMapper.getEmpsByDuty(roleName);
	}

	@Override
	public PageVO<EmpVO> getEmps(String orderColName, String orderFlag, String condition, Integer nowPageNum,
			Integer pageCount) {
		return null;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public EmpVO getEmpById(int empId) {
		EmpVO list = empMapper.getEmpById(empId);
		return list;
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addEmp(EmpVO emp) {
		
		return empMapper.addEmp(emp)> 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean modifyEmp(EmpVO emp) {
		return empMapper.modifyEmp(emp)> 0 ? true : false;
	}
	/**
	 * 修改密码
	 */
	@Override
	public boolean modifyPwd(EmpVO emp) {
		return empMapper.modifyPwd(emp)> 0 ? true : false;
	};

	/**
	 * 删除
	 */
	@Override
	public boolean removeEmpById(int empId) {
		
		return empMapper.removeEmpById(empId)>0?true:false;
	}

	/**
	 * 检测账号是否存在
	 */
	@Override
	public boolean getAccount(String account) {
		
		return false;
	}
	@Override
	public EmpVO getEmpByAccount(String account) {
		
		return empMapper.getEmpByAccount(account);
	}
	/**
	 * 检测电话是否存在
	 */
	@Override
	public boolean getTelephone(String telephone) {
		return empMapper.getTelephone(telephone)>0?true:false;
	}
	/**
	 * 检测身份证号是否重复
	 */
	@Override
	public boolean getIdCardNum(String idCardNum) {
		// TODO Auto-generated method stub
		return empMapper.getIdCardNum(idCardNum)>0?true:false;
	}
	

	

}

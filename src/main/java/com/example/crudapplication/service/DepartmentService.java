package com.example.crudapplication.service;

import com.example.crudapplication.entity.Department;

import java.util.List;

public interface DepartmentService {

   Department saveDepartment(Department department);

   List<Department> fetchDepartmentList();

   Department fetchDeptById(Long deptId);

   void deleteDeptById(Long deptId);

   Department updateDept(Long deptId, Department department);

   Department fetchDeptByName(String department);
}

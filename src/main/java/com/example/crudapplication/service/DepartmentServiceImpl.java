package com.example.crudapplication.service;

import com.example.crudapplication.entity.Department;
import com.example.crudapplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDeptById(Long deptId) {
        return departmentRepository.findById(deptId).get();
    }

    @Override
    public void deleteDeptById(Long deptId) {
        departmentRepository.deleteById(deptId);
    }

    @Override
    public Department updateDept(Long deptId, Department department) {
        Department depDB=departmentRepository.findById(deptId).get();

        if(Objects.nonNull(department.getDeptName()) && !"".equalsIgnoreCase(department.getDeptName())){
            depDB.setDeptName(department.getDeptName());
        }
        if(Objects.nonNull(department.getDeptCode()) && !"".equalsIgnoreCase(department.getDeptCode())){
            depDB.setDeptCode(department.getDeptCode());
        }
        if(Objects.nonNull(department.getDeptAddress()) && !"".equalsIgnoreCase(department.getDeptAddress())){
            depDB.setDeptAddress(department.getDeptAddress());
        }
        return departmentRepository.save(depDB);

    }
    @Override
    public Department fetchDeptByName(String deptName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(deptName);
    }
}

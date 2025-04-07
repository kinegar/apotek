package com.egar.apotek.service.impl;

import com.egar.apotek.dto.EmployeeDTO;
import com.egar.apotek.entity.Employee;
import com.egar.apotek.mapper.EmployeeMapper;
import com.egar.apotek.repository.EmployeeRepository;
import com.egar.apotek.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.convertToEntity(employeeDTO);
        employeeRepository.save(employee);
        employeeDTO.setId(employee.getId());
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employees =employeeRepository.findAll();
        return employeeMapper.convertToDTOList(employees);
    }

    @Override
    public EmployeeDTO findById(BigInteger id) {
        Optional<Employee> employee =employeeRepository.findById(id);
        if(employee.isPresent()){
            return employeeMapper.convertToDTO(employee.get());
        }else{
            throw new RuntimeException("Employee not found with id - " + id);
        }
    }
}

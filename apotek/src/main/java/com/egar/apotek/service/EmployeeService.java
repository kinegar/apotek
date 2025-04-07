package com.egar.apotek.service;

import com.egar.apotek.dto.EmployeeDTO;

import java.math.BigInteger;
import java.util.List;

public interface EmployeeService {
    public EmployeeDTO save(EmployeeDTO employeeDTO);
    public List<EmployeeDTO> findAll();
    public EmployeeDTO findById(BigInteger id);
}

package com.egar.apotek.mapper;

import com.egar.apotek.dto.EmployeeDTO;
import com.egar.apotek.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Employee convertToEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO, Employee.class);
    }

    public EmployeeDTO convertToDTO(Employee employee){
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> convertToDTOList(List<Employee> employees){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee employee:employees){
            EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;
    }
}

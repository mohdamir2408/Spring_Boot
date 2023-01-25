package com.crud.EmployeeMgtBackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {


    private Integer pageNo;
    private Integer limit;
    private  String shortType;
    private String shortField;
    private  String searchItem;


}

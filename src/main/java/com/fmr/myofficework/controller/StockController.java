package com.fmr.myofficework.controller;

import com.fmr.myofficework.domain.CompanyDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stock-service/v1")
public class StockController {



    @GetMapping("/getAllCompanies")
    ResponseEntity<List<CompanyDetail>> fetchAllCompanies(){
        List<CompanyDetail> companyDetailList = new ArrayList<>();

        return new ResponseEntity<>(companyDetailList, HttpStatus.OK);
    }


//    @PostMapping("/addNewCompany")
//    ResponseEntity<String> addNewCompany(@RequestBody CompanyDetail companyDetail){
//
//    }




}

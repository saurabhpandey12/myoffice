package com.fmr.myofficework.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@Entity
public class CompanyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer companyId;
    private String industryCode;
    private String companyName;
    private String companyDescription;
    private String stockCode;
    private String industrySector;
    private String products;
    private BigDecimal revenue;
    private BigDecimal netProfit;
    private BigDecimal netLoss;
    private BigDecimal totalAssets;
    private String services;
    private BigDecimal netInvestment;
    private String companyAddress;
    private String companyType;
    private String startedDate;
    private String stockListedDate;
    private String ipoDate;
    private int numberOfEmployee;
    private String dreamProjectCompanyWorkingOn;
    private String officeInformation;
    private String prosAboutCompany;
    private String consAboutCompany;
    private String customerService;
    private String founder;
    private String subFounder;
    private String subsidiaries;
    private String parentOrganization;
    private String parentGroupCompany;
    private String keyPeople;
    private String website;
    private String problems;
    private String futureProject;
    @OneToMany
    private List<ShareHolder> shareHolders;
    private String references;


}

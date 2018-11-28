package com.dragon.utils;

public class IOWarehouseHistory {

    private Integer ID;
    private String registerTime;             //操作时间（登记时间）
    private String contractId;          //合同编号
    private String area;                // 区域
    private String busiDepartment;      //营业部
    private String customName;              //客户姓名
    private String borrowMoney;             //借款金额
    private String productType;             // 产品大类
    private String productName;             // 产品名称
    private String carNumber;               // 车牌号码
    private String carBrand;                //车辆品牌
    private String intoOverdueDays;         //入库逾期天数
    private String intoOverdueTerm;         //入库逾期期数
    private String intoOweCorpus;           //入库时贷款余额
    private String intoWarehouseTime;                //入库时间
    private String intoOperator;            //入库人
    private String intoOperatorId;          //入库人员编号
    private String tailTime;                //拖车时间
    private String outWarehouseTime;                 //出库时间
    private String outOperator;             //出库人
    private Integer isInWarehouse;           // 是否在库
    private String outWarehouseStatus;       //出入库情况

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBusiDepartment() {
        return busiDepartment;
    }

    public void setBusiDepartment(String busiDepartment) {
        this.busiDepartment = busiDepartment;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(String borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getIntoOverdueDays() {
        return intoOverdueDays;
    }

    public void setIntoOverdueDays(String intoOverdueDays) {
        this.intoOverdueDays = intoOverdueDays;
    }

    public String getIntoOverdueTerm() {
        return intoOverdueTerm;
    }

    public void setIntoOverdueTerm(String intoOverdueTerm) {
        this.intoOverdueTerm = intoOverdueTerm;
    }

    public String getIntoOweCorpus() {
        return intoOweCorpus;
    }

    public void setIntoOweCorpus(String intoOweCorpus) {
        this.intoOweCorpus = intoOweCorpus;
    }

    public String getIntoWarehouseTime() {
        return intoWarehouseTime;
    }

    public void setIntoWarehouseTime(String intoWarehouseTime) {
        this.intoWarehouseTime = intoWarehouseTime;
    }

    public String getIntoOperator() {
        return intoOperator;
    }

    public void setIntoOperator(String intoOperator) {
        this.intoOperator = intoOperator;
    }

    public String getIntoOperatorId() {
        return intoOperatorId;
    }

    public void setIntoOperatorId(String intoOperatorId) {
        this.intoOperatorId = intoOperatorId;
    }

    public String getTailTime() {
        return tailTime;
    }

    public void setTailTime(String tailTime) {
        this.tailTime = tailTime;
    }

    public String getOutWarehouseTime() {
        return outWarehouseTime;
    }

    public void setOutWarehouseTime(String outWarehouseTime) {
        this.outWarehouseTime = outWarehouseTime;
    }

    public String getOutOperator() {
        return outOperator;
    }

    public void setOutOperator(String outOperator) {
        this.outOperator = outOperator;
    }

    public Integer getIsInWarehouse() {
        return isInWarehouse;
    }

    public void setIsInWarehouse(Integer isInWarehouse) {
        this.isInWarehouse = isInWarehouse;
    }

    public String getOutWarehouseStatus() {
        return outWarehouseStatus;
    }

    public void setOutWarehouseStatus(String outWarehouseStatus) {
        this.outWarehouseStatus = outWarehouseStatus;
    }
}

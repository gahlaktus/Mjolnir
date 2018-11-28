package com.dragon.utils;

/**
 * Created by huangzhibo on 17/04/2017.
 */
public class DisposalApplyInfo extends BaseInfo{

    private String sourceId;
    private String speakTime;   //报告时间
    private String speaker;     //报告人
    private String isClientConnected;   //客户是否可联
    private String isFamiliesConnected; //家人/亲属是否可联
    private String isSalesdepartCo;     //营业部是否配合车辆处置
    private String idType;      //身份证
    private String driverLicense;   //机动车行驶证
    private String driverRegister;  //机动车登记证
    private String carKey;      //车辆钥匙
    private String supplyMaterials;     //借款协议及协议补充材料
    private String serverAgreement;     //借款咨询及管理服务协议
    private String exhibitionAgreement;     //展期协议
    private String telCollection;       //电催情况
    private String outsideVisit;        //外访情况
    private String reseasonOfSelling;   //申请车辆处置理由
    private String typeOfDisposal;      //处置方式
    private String visibilityOfCarframeId;  //车辆车架号是否涂抹
    private String kilometers;      //公里数
    private String appearanceOfCar;     //外观情况
    private String isOfficial;          //是否公务车
    private String visibilityOfEngineId;        //发动机号是否涂抹
    private String interiorOfCar;       //内饰情况
    private String isPledge;        //是否存在车辆抵押
    private String localEnquiry;         //当地询价（元）
    private String FirstRegisterDate;       //初登日期
    private String deadLineOfInusre;        //保险到期日期
    private String hasAccident;             //是否存在事故
    private String hasLotsOfPledge;         //是否存在多抵
    private String peddleryName;            //商贩姓名
    private String peccancy;                //违章情况
    private String hasInvoled;              //是否存在查封、涉案信息
    private String phoneOfPeddlery;         //商贩联系电话
    private String excessDesc;              //补充描述
    private String disposalStatus;          //订单处置状态

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSpeakTime() {return speakTime;}

    public void setSpeakTime(String speakTime) {
        this.speakTime = speakTime;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getIsClientConnected() {
        return isClientConnected;
    }

    public void setIsClientConnected(String isClientConnected) {
        this.isClientConnected = isClientConnected;
    }

    public String getIsFamiliesConnected() {
        return isFamiliesConnected;
    }

    public void setIsFamiliesConnected(String isFamiliesConnected) {
        this.isFamiliesConnected = isFamiliesConnected;
    }

    public String getIsSalesdepartCo() {
        return isSalesdepartCo;
    }

    public void setIsSalesdepartCo(String isSalesdepartCo) {
        this.isSalesdepartCo = isSalesdepartCo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDriverRegister() {
        return driverRegister;
    }

    public void setDriverRegister(String driverRegister) {
        this.driverRegister = driverRegister;
    }

    public String getCarKey() {
        return carKey;
    }

    public void setCarKey(String carKey) {
        this.carKey = carKey;
    }

    public String getSupplyMaterials() {
        return supplyMaterials;
    }

    public void setSupplyMaterials(String supplyMaterials) {
        this.supplyMaterials = supplyMaterials;
    }

    public String getServerAgreement() {
        return serverAgreement;
    }

    public void setServerAgreement(String serverAgreement) {
        this.serverAgreement = serverAgreement;
    }

    public String getExhibitionAgreement() {
        return exhibitionAgreement;
    }

    public void setExhibitionAgreement(String exhibitionAgreement) {
        this.exhibitionAgreement = exhibitionAgreement;
    }

    public String getTelCollection() {
        return telCollection;
    }

    public void setTelCollection(String telCollection) {
        this.telCollection = telCollection;
    }

    public String getOutsideVisit() {
        return outsideVisit;
    }

    public void setOutsideVisit(String outsideVisit) {
        this.outsideVisit = outsideVisit;
    }

    public String getReseasonOfSelling() {
        return reseasonOfSelling;
    }

    public void setReseasonOfSelling(String reseasonOfSelling) {
        this.reseasonOfSelling = reseasonOfSelling;
    }

    public String getTypeOfDisposal() {
        return typeOfDisposal;
    }

    public void setTypeOfDisposal(String typeOfDisposal) {
        this.typeOfDisposal = typeOfDisposal;
    }

    public String getVisibilityOfCarframeId() {
        return visibilityOfCarframeId;
    }

    public void setVisibilityOfCarframeId(String visibilityOfCarframeId) {this.visibilityOfCarframeId = visibilityOfCarframeId;}

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getAppearanceOfCar() {
        return appearanceOfCar;
    }

    public void setAppearanceOfCar(String appearanceOfCar) {
        this.appearanceOfCar = appearanceOfCar;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public String getVisibilityOfEngineId() {
        return visibilityOfEngineId;
    }

    public void setVisibilityOfEngineId(String visibilityOfEngineId) {this.visibilityOfEngineId = visibilityOfEngineId;}

    public String getInteriorOfCar() {
        return interiorOfCar;
    }

    public void setInteriorOfCar(String interiorOfCar) {
        this.interiorOfCar = interiorOfCar;
    }

    public String getIsPledge() {
        return isPledge;
    }

    public void setIsPledge(String isPledge) {
        this.isPledge = isPledge;
    }

    public String getLocalEnquiry() {
        return localEnquiry;
    }

    public void setLocalEnquiry(String localEnquiry) {
        this.localEnquiry = localEnquiry;
    }

    public String getFirstRegisterDate() {
        return FirstRegisterDate;
    }

    public void setFirstRegisterDate(String firstRegisterDate) {
        FirstRegisterDate = firstRegisterDate;
    }

    public String getDeadLineOfInusre() {
        return deadLineOfInusre;
    }

    public void setDeadLineOfInusre(String deadLineOfInusre) {
        this.deadLineOfInusre = deadLineOfInusre;
    }

    public String getHasAccident() {
        return hasAccident;
    }

    public void setHasAccident(String hasAccident) {
        this.hasAccident = hasAccident;
    }

    public String getHasLotsOfPledge() {
        return hasLotsOfPledge;
    }

    public void setHasLotsOfPledge(String hasLotsOfPledge) {
        this.hasLotsOfPledge = hasLotsOfPledge;
    }

    public String getPeddleryName() {
        return peddleryName;
    }

    public void setPeddleryName(String peddleryName) {
        this.peddleryName = peddleryName;
    }

    public String getPeccancy() {return peccancy;}
    public void setPeccancy(String peccancy) {this.peccancy = peccancy;}
    public String getHasInvoled() {return hasInvoled;}
    public void setHasInvoled(String hasInvoled) {this.hasInvoled = hasInvoled;}
    public String getPhoneOfPeddlery() {return phoneOfPeddlery;}
    public void setPhoneOfPeddlery(String phoneOfPeddlery) {this.phoneOfPeddlery = phoneOfPeddlery;}
    public String getExcessDesc() {return excessDesc;}
    public void setExcessDesc(String excessDesc) {this.excessDesc = excessDesc;}

    public String getDisposalStatus() {
        return disposalStatus;
    }

    public void setDisposalStatus(String disposalStatus) {
        this.disposalStatus = disposalStatus;
    }
}

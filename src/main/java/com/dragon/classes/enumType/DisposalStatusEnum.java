package com.dragon.classes.enumType;

import java.util.*;

/**
 * Created by huangzhibo on 21/04/2017.
 */
public enum DisposalStatusEnum {

    UN_SALE("030001","未卖车"){
        @Override
        public String nextDisposalStatus() {
            int index = this.ordinal();
            return DisposalStatusEnum.values()[index+1].getStatusCode();
        }
    },
    DIRECTOR_VET("030002","主管审批中"){
        @Override
        public String nextDisposalStatus() {
            return DisposalStatusEnum.getNextDisposalStatus(this.ordinal());
        }
    },
    CITY_MANAGER_VET("030003","经理审批中"){
        @Override
        public String nextDisposalStatus() {
            return DisposalStatusEnum.getNextDisposalStatus(this.ordinal());
        }
    },
    CAR_PRICINPAL_VET("030004","负责人审批中"){
        @Override
        public String nextDisposalStatus() {
            return DisposalStatusEnum.getNextDisposalStatus(this.ordinal());
        }
    },
    CAR_FIRST_VET("030005","车贷处置初审中"){
        @Override
        public String nextDisposalStatus() {
            return DisposalStatusEnum.getNextDisposalStatus(this.ordinal());
        }
    },
    CAR_LAST_VET("030006","车贷处置终审中"){
        @Override
        public String nextDisposalStatus() {
            return DisposalStatusEnum.getNextDisposalStatus(this.ordinal());
        }
    },
    CAR_BUSINESS_VET("030007","业务经理审批中"){
        @Override
        public String nextDisposalStatus() {
            return DisposalStatusEnum.getNextDisposalStatus(this.ordinal());
        }
    },
    MAJORDOMO_VET("030008","总监审批中"){
        @Override
        public String nextDisposalStatus() {
            return DisposalStatusEnum.getNextDisposalStatus(this.ordinal());
        }
    },
    DONE_VET("030009","审批完成"){
        @Override
        public String nextDisposalStatus() {
            return DONE_SALE.getStatusCode();
        }
    },
    REJECT_VET("030010","审批拒绝"){
        @Override
        public String nextDisposalStatus() {
            return UN_SALE.getStatusCode();
        }
    },
    suspend_vet("030011","中止卖车"){
        @Override
        public String nextDisposalStatus() {
            return null;
        }
    },
    DONE_SALE("030012","已完成"){
        @Override
        public String nextDisposalStatus() {
            return null;
        }
    };

    private String statusCode;
    private String statusName;
    DisposalStatusEnum(String code, String statusName){
        this.statusCode = code;
        this.statusName = statusName;
    }
    public abstract String nextDisposalStatus();
    private static String getNextDisposalStatus(int index){
        return DisposalStatusEnum.values()[index+1].getStatusCode();
    }


    public static String getStatusName(String statusCode){
        if (null == statusCode){
            return null;
        }
        for (DisposalStatusEnum disposalStatus : DisposalStatusEnum.values()){
            if (disposalStatus.getStatusCode().equals(statusCode)){
                return disposalStatus.getStatusName();
            }
        }
        return null;
    }

    public static DisposalStatusEnum findDisposalStatus(String statusCode){
        if (null == statusCode){
            return null;
        }
        for (DisposalStatusEnum disposalStatus : DisposalStatusEnum.values()){
            if (disposalStatus.getStatusCode().equals(statusCode)){
                return disposalStatus;
            }
        }
        return null;
    }

    public static List<String> getVetStatusList(){
        return Arrays.asList(
                UN_SALE.getStatusCode(), DIRECTOR_VET.getStatusCode(), CITY_MANAGER_VET.getStatusCode(),
                CAR_FIRST_VET.getStatusCode(),CAR_LAST_VET.getStatusCode(),CAR_PRICINPAL_VET.getStatusCode(),
                CAR_BUSINESS_VET.getStatusCode(),MAJORDOMO_VET.getStatusCode(),DONE_VET.getStatusCode()
        );
    }

    public static List<String> getVetStatusList1(){

        EnumSet<DisposalStatusEnum> enumSet = EnumSet.range(DisposalStatusEnum.UN_SALE, DisposalStatusEnum.DONE_VET);

        List<String> disposalStatusList = new ArrayList<>();

        for (DisposalStatusEnum disposalStatusEnum : enumSet){
            disposalStatusList.add(disposalStatusEnum.getStatusCode());
        }

        return disposalStatusList;
    }

    private static Map<DisposalStatusEnum, String> schema = new EnumMap<DisposalStatusEnum, String>(DisposalStatusEnum.class);

    static {
        for (DisposalStatusEnum disposalStatusEnum : DisposalStatusEnum.values()){
            schema.put(disposalStatusEnum, disposalStatusEnum.getStatusCode());
        }
    }

//    public static String getNextDisposalStatus(String preStatusCode){
//        schema.get()
//    }

    public static DisposalStatusEnum getNextVetNodeStatus(DisposalStatusEnum preStatusCode){
        switch (preStatusCode){
            case UN_SALE:
                return DIRECTOR_VET;
            case DIRECTOR_VET:
                return CITY_MANAGER_VET;
            case CITY_MANAGER_VET:
                return CAR_PRICINPAL_VET;
            case CAR_PRICINPAL_VET:
                return CAR_FIRST_VET;
            case CAR_FIRST_VET:
                return CAR_LAST_VET;
            case CAR_LAST_VET:
                return CAR_BUSINESS_VET;
            case CAR_BUSINESS_VET:
                return MAJORDOMO_VET;
            case MAJORDOMO_VET:
                return CAR_LAST_VET;
            default:
                break;

        }
        return null;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

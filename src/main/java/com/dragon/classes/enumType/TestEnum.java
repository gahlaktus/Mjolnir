package com.dragon.classes.enumType;

/**
 * Created by huangzhibo on 21/04/2017.
 */
public class TestEnum {
    public static void main(String[] args) {

        DisposalStatusEnum statusEnum1 = DisposalStatusEnum.findDisposalStatus("030001");
        DisposalStatusEnum statusEnum = DisposalStatusEnum.getNextVetNodeStatus(statusEnum1);
        //System.out.println(statusEnum.getStatusCode());


        for (String str : DisposalStatusEnum.getVetStatusList1()){
            System.out.println(str);
        }
        System.out.println("-----------------------");

        DisposalStatusEnum.getVetStatusList().forEach(
                s -> System.out.println(s)
        );
    }
}

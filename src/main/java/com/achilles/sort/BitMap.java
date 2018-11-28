package sort;

public class BitMap {
	public static void main(String[] args) {
		int [][] arr = {
				{ 1 , 2 , 3 , 5 , 3 , 5 , 56, 534 , 3 , 32 } ,
				{ 1 , 2 , 3 , 5 } ,
				{ 1 , 2 , 3 , 5 , 3 , 5 } ,
				{ 0 , 0 , 1 , 2 , 3 , 5 , 56, 534 , 78 , 32 } ,
				};
		for (int i = 0; i < arr.length; i++) {
			System.out.print("���飺 ");
			for (int temp : arr[i]) {
				System.out.print(temp + ",");
			}
			System.out.print( " �� " );
			System.out.print(hasDuplicatedItem(arr[i]) ? " ���� " : " ������ " );
			System.out.print( " �ظ�Ԫ��.\n ");
		}
	}
	/**
	 * �ж������������Ƿ����ظ����ݣ�ʱ�临�Ӷ�ΪO��n��
	 * @param arr
	 * @return
	 */
	private static boolean hasDuplicatedItem(int[] arr) {
		//���������ֵ
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > max){
				max = arr[i];
			}
		}
		//�����ֵ����һ���µ�����
		int[] bitArray = new int[max+1];
		//��ֵ�������������ֵ����valueΪ3��bitArray[3]=1
		for (int value : arr) {
			if(bitArray[value] != 0){
				// ���valueָ���λ���Ѿ������㣬˵��֮ǰ�Ѿ�����һ����1�ˣ���������true��ʾ�������ظ�
				return true;
			}else{
				// valueָ���λ������,����Ϊ1��ʾ��һλ�Ѿ�����������
				bitArray[value] = 1 ;
			}
		}
		return false;
	}
}

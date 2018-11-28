package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 15/03/2018
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowNum = matrix.length / 2;
        int k = matrix[0].length;
        int preRowNum = rowNum;
        int curMaxIndex =  matrix.length;
        while (rowNum <= curMaxIndex) {
            if (rowNum != 0 && matrix[rowNum][0] > target) {
                curMaxIndex = rowNum;
                rowNum = curMaxIndex / 2;
                if (rowNum == preRowNum){
                    return false;
                }
                preRowNum = rowNum;
            } else if (rowNum != 0 && matrix[rowNum][k - 1] < target) {
                rowNum = (rowNum + curMaxIndex) / 2;
                if (rowNum == preRowNum){
                    return false;
                }
                preRowNum = rowNum;
            } else {
                for (int i = 0; i < k; i++) {
                    if (matrix[rowNum][i] == target) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }


    public boolean searchMatrix1(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0){
            return false;
        }

        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0, end = row * column -1;

        while (start <= end){
            // todo why?
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            if (number == target){
                return true;
            }
            else if (number > target){
                end = mid -1;
            }
            else {
                start = mid -1;
            }

        }
        return false;

    }

    public boolean searchMatrix2(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0){
            return false;
        }

        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length-1;

        while (row < matrix.length && col >= 0){

            if (matrix[row][col] == target){
                return true;
            }
            else if (matrix[row][col] > target){
                col--;
            }
            else {
                row ++;
            }

        }


        return false;

    }

    public static void main(String[] args) {
        int[][] test = {
                {1, 5, 8, 12, 13, 15, 18, 20, 25, 26, 28, 33, 38, 40, 43, 49, 52, 53, 59},
                {84, 100, 110, 129, 141, 156, 177, 198, 220, 242, 254, 266, 284, 297, 316, 326, 343, 358, 373},
                {388, 398, 419, 439, 449, 460, 472, 495, 516, 539, 560, 582, 600, 610, 624, 643, 668, 691, 710},
                {720, 733, 751, 765, 787, 804, 814, 832, 856, 880, 905, 930, 950, 974, 999, 1012, 1022, 1039, 1061},
                {1081, 1091, 1102, 1126, 1151, 1175, 1194, 1219, 1239, 1253, 1263, 1274, 1287, 1298, 1308, 1318, 1337, 1361, 1382},
                {1404, 1417, 1437, 1452, 1466, 1487, 1503, 1518, 1537, 1555, 1578, 1590, 1601, 1613, 1636, 1659, 1669, 1688, 1712}
        };


        int[][] test1 = {
                {1,4,8,15,20,22,25,32,36,43,49,51,53,55,59,65,69,73,80},
                {102,114,132,157,181,192,211,233,244,254,266,285,305,328,340,360,375,395,410},
                {431,448,464,481,502,514,526,543,568,578,598,613,636,646,662,680,705,729,752},
                {775,793,818,833,845,866,879,893,904,923,947,959,979,1000,1016,1037,1052,1062,1080},
                {1090,1113,1130,1153,1178,1202,1221,1235,1255,1267,1282,1297,1315,1333,1354,1369,1383,1408,1432},
                {1450,1464,1477,1496,1513,1528,1546,1562,1583,1601,1625,1638,1658,1671,1681,1692,1709,1733,1756}
        };

        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix2(test1, 1));
    }

}

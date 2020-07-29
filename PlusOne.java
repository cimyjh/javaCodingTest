public class PlusOne {



    /*

        뒷자리에 9가 있는 지 확인
        반복
        int[] 배열의 크기가 증가될 수도 있어야 함


    */
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        int[] result = plusOne(digits);
        for(int i: result)
            System.out.println("val: " + i);
    }
    
        public static int[] plusOne(int[] digits){

            //for문 조작을 평소 i++에서 i--로 반대로 한다.
            for(int i = digits.length - 1; i >= 0; i--){

                //+1을 하면  break를 해서 for문을 탈출한다.
                if(digits[i] != 9){
                    digits[i]++;
                    break;
                }else{
                    digits[i] = 0;
                }
            }

            //첫번째 자리수가 0일때 1추가 조작
            if(digits[0] == 0){
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                return res;
            }

            return digits;
        }
    }




    

    
}
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 0, 8, 5};
        //cursor = currentIndex
        int currentIndex = 0;

        //반복문 안에 조건을 넣은 패턴.
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }

        //cursor인 currentIndex가 초기화 되지 않고 4의 값을 가지고 있다.
        while(currentIndex < nums.length){
            nums[currentIndex] = 0;
            currentIndex++;
        }

        //출력
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i] + ",");
        }
    }
}
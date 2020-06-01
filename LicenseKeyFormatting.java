public class LicenseKeyFormatting {

    //문자열 조작에 대한 문제
    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w-13-ks";
        int k = 4;
        System.out.println(licenseKeyFormatting(S, k));


    }

    public static String licenseKeyFormatting(String S, int K) {
        String S1 = S.replace("-", "");
        S1 = S1.toUpperCase();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< S1.length(); i++){
            sb.append(S1.charAt(i));
        }

        //4개의 자리마다 "-" 넣어주는 기능 파리미터 K를 사용한다.
        int len = sb.toString().length();
        for(int i = K; i < len; i = i + K){
            sb.insert(len - i, '-');
        }
        return sb.toString();
    }
    
}
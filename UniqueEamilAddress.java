import java.util.*;



//입력받은 email을 local, domain 두 부분으로 분할
//local에 대해서는 요구사항을 맞추기 위해 String조작
//local, domain을 다시 합친다.
public class UniqueEamilAddress {
	
	public static void main(String[] args) {
		String[] emails = {"test.email+alex@leetcode.com",
				           "test.e.mail+bob.cathy@leetcode.com",
				           "testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));
		System.out.println(numUniqueEmails_split(emails));
	}
	
	static int numUniqueEmails(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();
		for (String email : emails) {
			String localName = getLocalName(email);
			String domainName = getDomainName(email);
			uniqueEmails.add(localName + "@" + domainName);
		}
		return uniqueEmails.size();
	    }

	private static String getDomainName(String email) {
		return email.substring(email.indexOf('@')+1);
	}

	private static String getLocalName(String email) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < email.length(); i++) {
			if (email.charAt(i) == '.') {
				continue;
			}
			if (email.charAt(i) == '+') {
				break;
			}
			if (email.charAt(i) == '@') {
				break;
			}
			//한개의 char씩 append해서 합친다.
			String str = String.valueOf(email.charAt(i));
			sb.append(str);

		}
		return sb.toString();
	}
	
	
	public static int numUniqueEmails_split(String[] emails) {
        Set<String> sentEmails = new HashSet();
        if(emails == null) {
            return 0;
        }

        for(String email : emails) {
            String[] parts = email.split("\\@");
            String[] partsForPlus = parts[0].split("\\+");
            String[] partsForDot = partsForPlus[0].split("\\.");
            StringBuilder emailM = new StringBuilder();
            for(String part : partsForDot) {
                emailM.append(part);
            }
            emailM.append("@"+parts[1]); 
            sentEmails.add(emailM.toString());
        }
        return sentEmails.size();
    }



}

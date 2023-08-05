class Solution {
    public int lengthOfLongestSubstring(String s) {
        String usa;
        int maior = 1;
        if (s.length() == 0)
            return 0;
        for (int i = 0; i<s.length()-1; i++){
            
            usa = s.substring(i+1);

            if (usa.lastIndexOf(s.charAt(i)) == -1){
                for (int j = i; j<s.length(); j++) {

                    if (usa.lastIndexOf(s.charAt(j)) != -1) {
                        if (usa.lastIndexOf(s.charAt(j)) - usa.indexOf(s.charAt(j)) > maior)
                            maior = usa.lastIndexOf(s.charAt(j)) - usa.indexOf(s.charAt(j));
                    } else if (usa.length() - usa.indexOf(s.charAt(j)) > maior) {
                        int tem = 0;
                        for (int k = j; k < usa.length(); k++)
                            if (usa.lastIndexOf(usa.charAt(k)) != usa.indexOf(usa.charAt(k)))
                                tem++;
                        if (tem == 0)
                            maior = usa.length() - usa.indexOf(s.charAt(j));
                    }
                }
                break;
            }

            if (usa.indexOf(s.charAt(i)) > maior)
                maior = usa.indexOf(s.charAt(i));
        
        }

        return maior;
    }
}

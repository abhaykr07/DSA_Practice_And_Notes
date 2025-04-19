class 205. Isomorphic Strings {
    public boolean isIsomorphic(String s, String t) {
        int[] M1 = new int[256];
        int [] M2 = new int[256];

        if(s.length()!=t.length()) return false;

        for(int i = 0 ; i < s.length(); i++){

            if(M1[s.charAt(i)]!= M2[t.charAt(i)]){

                return false;
            }else{
                M1[s.charAt(i)] = i+1;
                M2[t.charAt(i)] = i+1;
            }
        }

        return true;
    }
}

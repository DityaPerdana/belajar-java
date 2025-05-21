public class Array2d {
    public static void main(String[] args) throws Exception {
        String[][] negara = new String[5][2];
        negara[0][0] = "Indonesia";
        negara[0][1] = "Jakarta";
        negara[1][0] = "Malaysia";
        negara[1][1] = "Kuala Lumpur";
        negara[2][0] = "Singapura";
        negara[2][1] = "Singapura";
        negara[3][0] = "Thailand";
        negara[3][1] = "Bangkok";
        negara[4][0] = "India";
        negara[4][1] = "New Delhi";
        String namaNegara;
        for(int baris=0; baris<negara.length; baris++) {
            namaNegara = negara[baris][0];
            if(namaNegara.charAt(0) == 'I') {
                System.out.println(negara[baris][0] + " - " + negara[baris][1]);
            }
        }
        
    }
        
}

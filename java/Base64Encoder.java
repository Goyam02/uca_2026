class Base64Encoder {

    static String BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789+/";

    static String encode(String input){
        if(input == null || input.length() == 0){
            return "";
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < input.length(); i += 3){

            int b1 = input.charAt(i);
            int b2 = (i + 1 < input.length()) ? input.charAt(i + 1): 0;
            int b3 = (i + 2 < input.length()) ? input.charAt(i + 2): 0;
            int first = b1 >> 2;
            int second = ((b1 & 3) << 4) | (b2 >> 4);
            int third = ((b2 & 15) << 2) | (b3 >> 6);
            int fourth = b3 & 63;
            result.append(BASE64.charAt(first));
            result.append(BASE64.charAt(second));

            if(i + 1 >= input.length()){
                result.append('=');
                result.append('=');
            }

            else if(i + 2 >= input.length()){
                result.append(BASE64.charAt(third));
                result.append('=');
            }

            else{
                result.append(BASE64.charAt(third));
                result.append(BASE64.charAt(fourth));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(encode("Cat"));
        System.out.println(encode("Hello World"));
        System.out.println(encode("A"));
        System.out.println(encode(""));
        System.out.println(encode("Man"));
        System.out.println(encode("Ma"));
    }
}
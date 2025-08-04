import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean inTag = false;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '<') { 
                sb.append(word.reverse());
                word.setLength(0);
                inTag = true;
                sb.append(c);
            } 
            else if (c == '>') { 
                inTag = false;
                sb.append(c);
            } 
            else if (inTag) {
                // < 이거 안
                sb.append(c);
            } 
            else { 
                // > 밖
                if (c == ' ') { 
                    sb.append(word.reverse());
                    word.setLength(0);
                    sb.append(' ');
                } else {
                    // 단어 계속 모으기
                    word.append(c);
                }
            }
        }

        sb.append(word.reverse());

        System.out.println(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb;
    public static boolean checkRestart() throws IOException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String str = br.readLine();
        if(str.equals("1")){
            return true;
        }
        if(str.equals("2")){
            return false;
        }
        return true;
    }
    }
}

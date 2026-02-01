import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        boolean isRunning = true;
        List<Integer> computerList = getRandomNumbers();
        while (isRunning) {
            boolean isCorrect = run(computerList);
            if(isCorrect){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
                isRunning = checkRestart();
            }
            if(isCorrect && isRunning){
                computerList = getRandomNumbers();
            }
        }
    }

    public static boolean run(List<Integer> correctNumber) throws IOException{
        List<Integer> inputNumberList = inputNumber();
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (correctNumber.get(i).equals(inputNumberList.get(i))) strike++;
        }
        System.out.println(getHint(correctNumber, inputNumberList));
        if(strike == 3){
            return true;
        }
        return false;
    }

    public static String getHint(List<Integer> correctNumber, List<Integer> userNumber){
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (correctNumber.get(i).equals(userNumber.get(i))) {
                strike++;
                continue;
            }
            if (correctNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        String result = "";
        if (strike > 0) result += strike + "스트라이크 ";
        if (ball > 0) result += ball + "볼";

        return result.trim();
    }

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

    public static List<Integer> inputNumber() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        String str = br.readLine();
        List<Integer> numbers = new ArrayList<>();
        for(char c : str.toCharArray()){
            numbers.add(c-'0');
        }
        return numbers;
    }

    public static List<Integer> getRandomNumbers(){
        Random random = new Random();
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

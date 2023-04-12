package javastudy.study.ch02;

import java.util.Scanner;

public class InputView {

    public String input(){
        System.out.print("수식을 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        return str;
    }
}

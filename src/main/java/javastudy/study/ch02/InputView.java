package javastudy.study.ch02;

import java.util.Scanner;

public class InputView {

    public String input(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        return str;
    }
}

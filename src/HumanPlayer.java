import java.util.Scanner;

public class HumanPlayer extends Player {

    public boolean toHit() {
        System.out.println("Type 1 for Hit, 2 for Stand");
        Scanner in= new Scanner(System.in);
        int decision= in.nextInt();
        if (decision == 1) {
            setState(PlayerState.HIT);
            return true;
        }
        setState(PlayerState.STAND);
        return false;
    }

}
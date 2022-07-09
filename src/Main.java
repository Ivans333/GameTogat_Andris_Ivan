import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declarating new objects
        Scanner input = new Scanner(System.in);
        Player computer = new Player();
        Player human = new Player();

        //Introduction
        System.out.println("Hello and Welcome to FightGame!");
        System.out.print("Enter your Fighter name: ");
        human.setName(input.nextLine());
///test
        String test = "test";
        // Starting game
        int turn = 0;
        while(human.getHp() > 0 && computer.getHp() > 0){
            turn++;
            //Displaying parameters before each turn
            System.out.println("****************Turn #" + turn + "**************************");
            System.out.println("Computer HP: " + computer.getHp() + ". Computer energy: " + computer.getEnergy());
            System.out.println(human.getName() + " HP: " + human.getHp() +". "+ human.getName()+" energy: " + human.getEnergy());
            System.out.println("******************************************");

            //Part for computer Attacks

            //Initializing random attack for computer
            int randomAttack = (int) (Math.random()*5)+1;
            //Checking if computers energy is enough to carry out attack, if not enough for any move, computer skips turn (random attack = 0)
            while(true){
                if (computer.getEnergy() < 40 && randomAttack == 3){
                    randomAttack = (int) (Math.random()*4)+1;
                } else if (computer.getEnergy() < 30 && randomAttack == 4){
                    randomAttack = (int) (Math.random()*4)+1;
                } else if(computer.getEnergy() < 20 && randomAttack == 2){
                    randomAttack = (int) (Math.random()*4)+1;
                } else if(computer.getEnergy() < 10 && randomAttack == 1){
                    randomAttack = 0;
                    break;
                } else break;
            }
            // Switch to choose what attack will be landed for any random number
                switch (randomAttack){
                case 1:
                    System.out.println("Computer attacks Low Kick");
                    computer.lowKick(human);
                    break;
                case 2:
                    System.out.println("Computer attacks Body Kick");
                    computer.bodyKick(human);
                    break;
                case 3:
                    System.out.println("Computer attacks High Kick");
                    computer.highKick(human);
                    break;
                case 4:
                    System.out.println("Computer uses Defence");
                    computer.defence();
                    break;
                default:
                    System.out.println("Skip turn.");
            }
            //if after computers attack health of human reduces to 0, game stops by break statement
            if(human.getHp() < 0){
                human.setHp(0);
                break;
            }


            //Part for Player
            System.out.println("Press \"1\" - Low Kick,\"2\" - Body Kick, \"3\" - High Kick, \"4\" - Defence, or any other key to skip turn");
            int playersAttack;
            //check for energy availability for chosen attack
            while(true){
                System.out.print("Please Choose your Attack: ");
                playersAttack = input.nextInt();
                if(playersAttack == 3 && human.getEnergy() < 40){
                    System.out.println("Not enough energy");
                } else if(playersAttack == 4 && human.getEnergy() < 30){
                    System.out.println("Not enough energy");
                }else if (playersAttack == 2 && human.getEnergy() < 20){
                    System.out.println("Not enough energy");
                }else if (playersAttack == 1 && human.getEnergy() < 10){
                    System.out.println("Not enough energy");
                }else break;
            }

            // applying attack according to players choice
            switch (playersAttack){
                case 1:
                    System.out.println(human.getName() + " attacks Low Kick");
                    human.lowKick(computer);
                    break;
                case 2:
                    System.out.println(human.getName() + " attacks Body Kick");
                    human.bodyKick(computer);
                    break;
                case 3:
                    System.out.println(human.getName() + " attacks High Kick");
                    human.highKick(computer);
                    break;
                case 4:
                    System.out.println(human.getName() + " uses Defence");
                    human.defence();
                    break;
                default:
                    System.out.println("Skip Turn.");
            }
            //checking if computers health reduced to 0 , finishing game with break statement
            if (computer.getHp() < 0){
                computer.setHp(0);
                break;
            }
            // increasing fighters energy after each round
            computer.increaseEnergy(15);
            human.increaseEnergy(15);
            System.out.println("15 Energy restored!");
        }

        // Final results
        System.out.println("Computer HP: " + computer.getHp() + ". Computer energy: " + computer.getEnergy());
        System.out.println(human.getName() + " HP: " + human.getHp() +". "+ human.getName()+" energy: " + human.getEnergy());
        // Choosing the winner
        if(computer.getHp() == 0){
            System.out.println(human.getName() + " WON! Congratulations");
        } else {
            System.out.println(human.getName() + " LOST! Good luck next Time!");
        }

    }
}
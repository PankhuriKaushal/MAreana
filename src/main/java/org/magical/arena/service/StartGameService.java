package org.magical.arena.service;

import org.magical.arena.model.Player;
import org.magical.arena.model.wrapper.PlayersList;
import org.magical.arena.service.impl.StartGameImpl;

import java.util.Scanner;

public class StartGameService implements StartGameImpl {
    Scanner scanner = new Scanner(System.in);

    public StartGameService(Scanner scanner) {
        this.scanner = scanner;
    }

    public StartGameService() {
    }

    PlayersList playersMap = new PlayersList();


    /**
     * The enterPlayersDetails function responsible to do detasetup for players and start the execution
     * This is the entry point if the program
     *
     * @return void
     * @version 1.0
     * @since 2023-12-27
     */
    public void enterPlayersDetails() {
        System.out.println("************************Welcome to Magical Arena************************");
        dataSetup();
        startExecution();
        System.out.println("************************Thanks for visiting Magical Arena************************");
    }

    /**
     * The startExecution function responsible to start the fight and stop the game
     * It is taking 2 player ame from user and find in the list.
     * Once found toss is happening and then which player have low health, that should attack first
     * This contain switch case in which-:
     * case 0: Enter 0 for STOP the Game
     * case 1: End 1 to start fight
     * default: Invalid Selection
     * we can make multiple fights in one game
     *
     * @return void
     * @version 1.0
     * @since 2023-12-27
     */
    public void startExecution() {
        System.out.println("************************Let's Began the Match************************");
        while (true) {
            System.out.println("Enter 0 for STOP the Game");
            System.out.println("Enter 1 to start fight");
            int caseValue = scanner.nextInt();
            switch (caseValue) {
                case 0: {
                    System.out.println("End Game");
                    return;
                }
                case 1: {
                    System.out.println("Please enter the name of first player");
                    String player_A_Name = scanner.next();
                    System.out.println("Please enter the name of second player");
                    String player_B_Name = scanner.next();

                    Player player_A = playersMap.getPlayerList().get(player_A_Name.toUpperCase());
                    Player player_B = playersMap.getPlayerList().get(player_B_Name.toUpperCase());
                    if (player_A != null && player_B != null) {
                        selectPlayerForFight(player_A, player_A_Name, player_B, player_B_Name);
                    } else {
                        System.err.println("Please give player name as per list");
                    }
                    break;
                }
                default:
                    System.out.println("Invalid Selection");
            }
        }
    }

    /**
     * The selectPlayerForFight function responsible to select any two of players from the list who can fight against each other
     * It is taking 2 player ame from user and find in the list.
     * Once found toss is happening and then which player have low health, that should attack first
     *
     * @return void
     * @version 1.0
     * @since 2023-12-27
     */
    public void selectPlayerForFight(Player player_A, String player_A_Name, Player player_B, String player_B_Name) {

        System.out.println("Player A -> Name : " + player_A_Name + " Health : " + player_A.getHealth() + " Strength : " + player_A.getStrength() + " Attack : " + player_A.getAttack());
        System.out.println("Player B -> Name : " + player_B_Name + " Health : " + player_B.getHealth() + " Strength : " + player_B.getStrength() + " Attack : " + player_B.getAttack());

        if (player_A.getHealth() > player_B.getHealth()) {
            System.out.println(player_B_Name + " won the toss");
            initiate(player_B, player_B_Name, player_A, player_A_Name);
        } else {
            System.out.println(player_A_Name + " won the toss");
            initiate(player_A, player_A_Name, player_B, player_B_Name);
        }
    }

    /**
     * The dataSetup function responsible to add the player, display the players and for starting game
     * This contain switch case in which-:
     * case 0: Enter 0 for start the Game
     * case 1: Enter 1 for adding the player
     * case 2: Enter 2 for Displaying the players
     * default: Invalid Selection
     *
     * @return void
     * @version 1.0
     * @since 2023-12-27
     */
    private void dataSetup() {
        int playerCount = 1;
        while (true) {
            System.out.println("Enter 0 for start the Game");
            System.out.println("Enter 1 for adding the player");
            System.out.println("Enter 2 for Displaying the players");
            int number = scanner.nextInt();
            switch (number) {
                case 0: {
                    if (playersMap.getPlayerList().size() > 1) {
                        return;
                    }
                    System.err.println("Please enter the details of atleast 2 players");
                    break;
                }
                case 1:
                    addPlayerData(scanner, playersMap, playerCount);
                    playerCount++;
                    break;

                case 2:
                    printPlayersData(playersMap);
                    break;

                default:
                    System.out.println("Invalid Selection");
                    break;

            }
        }
    }

    /**
     * The printPlayersData function responsible to print all the players stored in the list
     *
     * @param playersList (list contain all the player details)
     * @return void
     * @version 1.0
     * @since 2023-12-27
     */
    private void printPlayersData(PlayersList playersList) {
        for (String playerName : playersList.getPlayerList().keySet()) {
            Player player = playersList.getPlayerList().get(playerName);
            System.out.println("Player -> Name : " + playerName + " Health : " + player.getHealth() + " Strength : " + player.getStrength() + " Attack : " + player.getAttack());
        }
    }

    /**
     * The addPlayerData function responsible to take input as a player details and stored it in to the list
     *
     * @param scanner     (use to take input from user)
     * @param playersList (list contain all the player details)
     * @param playerCount (this represent no of players)
     * @return void
     * @version 1.0
     * @since 2023-12-27
     */
    private void addPlayerData(Scanner scanner, PlayersList playersList, int playerCount) {
        System.out.println("Enter Player health");
        int health = scanner.nextInt();
        System.out.println("Enter Player strength");
        int strength = scanner.nextInt();
        System.out.println("Enter Player attack");
        int attack = scanner.nextInt();
        String playerName = "Player" + playerCount;
        playersList.addPlayerList(playerName.toUpperCase(), new Player(health, strength, attack));
    }

    /**
     * The initiate function responsible for giving chance to both player one by one to attack unless health of one player become zero
     *
     * @param player_A      (the first player detail)
     * @param player_A_Name (the first player name)
     * @param player_B      (the second player detail)
     * @param player_B_Name the second player name)
     * @return void
     * @version 1.0
     * @since 2023-12-27
     */
    private void initiate(Player player_A, String player_A_Name, Player player_B, String player_B_Name) {
        int count = 1;
        while (true) {
            System.out.println("---------- ROUND " + count + " ----------");
            if (startGame(player_A, player_A_Name, player_B, player_B_Name)) break;
            if (startGame(player_B, player_B_Name, player_A, player_A_Name)) break;
            System.out.println("---------- ROUND " + count + " Completed----------\n\n");
            count++;
        }
    }

    /**
     * The startGame function responsible to execute the each round of transaction between 2 players
     *
     * @param attacker     (the player detail with attacker role)
     * @param attakerName
     * @param defender     (the player detail with defender role)
     * @param defenderName
     * @return boolean
     * @version 1.0
     * @since 2023-12-27
     */
    public boolean startGame(Player attacker, String attakerName, Player defender, String defenderName) {
        int healthCheck = fight(attacker, attakerName, defender, defenderName);
        if (healthCheck <= 0) {
            System.out.println(attakerName + " won the Match");
            return true;
        }
        return false;
    }

    public int roleDice() {
        return (int) (Math.random() * 6 + 1);
    }

    /**
     * the fight function is responsible for fight operation. Means attaker player need to attack and defending player need to defend.
     * The dice role define the attaker and defender power along with attack and strength
     * if the value of attack is more than defence, defendingPlayer loose the health
     * if the value of defence is more than attacker, defendingPlayer recover the health
     *
     * @param attackingPlayer (the player detail with attacker role)
     * @param attakerName     (the player name with attacker role)
     * @param defendingPlayer (the player detail with defender role)
     * @param defenderName    (the player name with defender role)
     * @return int
     * @version 1.0
     * @since 2023-12-27
     */
    public int fight(Player attackingPlayer, String attakerName, Player defendingPlayer, String defenderName) {
        // dice role for attack
        int attackDice = roleDice();
        int attack = attackingPlayer.getAttack() * attackDice;
        //dice role for defence
        int defendDice = roleDice();
        int defence = defendingPlayer.getStrength() * defendDice;

        System.out.println("Attacking Player : " + attakerName + " Attack with " + attack + " point");
        System.out.println("Defending Player : " + defenderName + " Strengthed with " + defence + " point");

        if (attack > defence) {
            // if attack is more than defence, player looses his/her health
            int finalHealth = attack - defence;
            System.out.println("Attacking Player : " + attakerName + " Damage with " + finalHealth + " point to " + defenderName);
            defendingPlayer.setHealth(defendingPlayer.getHealth() - finalHealth < 0 ? 0 : defendingPlayer.getHealth() - finalHealth);
        } else if (attack < defence) {
            // if defence is more than attack in this case player recover his/her health
            int finalStrength = defence - attack;
            int health = defendingPlayer.getHealth() + finalStrength;
            if (health < defendingPlayer.getFinalHealth()) {
                //after applying defence health is recovering
                System.out.println("Defending Player : " + defenderName + " recovered with " + finalStrength + " point");
                finalStrength = health;
            } else {
                // after applying defence health become full
                System.out.println("Defending Player : " + defenderName + " recovered fully with " + finalStrength + " point");
                finalStrength = defendingPlayer.getFinalHealth();
            }
            defendingPlayer.setHealth(finalStrength);
        }
        System.out.println("Defending Player : " + defenderName + " have health " + defendingPlayer.getHealth());
        System.out.println();
        return defendingPlayer.getHealth();
    }
}
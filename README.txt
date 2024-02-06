The game starts with enterPlayersDeatils() method. First of all we have statements there to check that do we have any
players to start the game or we have to enter player details.
then , The enterPlayersDetails function responsible to do detasetup for players and start the execution
The startExecution function responsible to start the fight and stop the game
     * It is taking 2 player ame from user and find in the list.
     * Once found toss is happening and then which player have low health, that should attack first
     * This contain switch case in which-:
     * case 0: Enter 0 for STOP the Game
     * case 1: End 1 to start fight
     * default: Invalid Selection
     * we can make multiple fights in one game
The selectPlayerForFight function responsible to select any two of players from the list who can fight against each other
          * It is taking 2 player ame from user and find in the list.
          * Once found toss is happening and then which player have low health, that should attack first.
The dataSetup function responsible to add the player, display the players and for starting game
        * This contain switch case in which-:
        * case 0: Enter 0 for start the Game
        * case 1: Enter 1 for adding the player
        * case 2: Enter 2 for Displaying the players
        * default: Invalid Selection
The printPlayersData function responsible to print all the players stored in the list
The addPlayerData function responsible to take input as a player details and stored it into the list
The initiate function responsible for giving chance to both player one by one to attack unless health of one player become zero
The startGame function responsible to execute the each round of transaction between 2 players
the fight function is responsible for fight operation. Means attaker player need to attack and defending player need to defend.
     * The dice role define the attaker and defender power along with attack and strength
     * if the value of attack is more than defence, defendingPlayer loose the health
     * if the value of defence is more than attacker, defendingPlayer recover the health

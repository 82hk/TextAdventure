package org.sherwoodhs.minigames;

//We will add this eventually - Landon

/* public class ShootGame {
        private String move;

        public void playGame() {
            Scanner input = new Scanner(System.in); //Change the input method
            Random r = new Random();
            int ammo = 0;
            int move = 0;
            int win = 0;
            int comMove = 0;
            int comAmmo = 0;
            int high = 3;
            int low = 1;

            while (win == 0)	{
                System.out.println("\n----------------\nAmmo: " + ammo);
                System.out.print("Choose your move: "); //change input method (idk how the buttons work)
                move = input.nextInt();
                System.out.println();


                if (move == 1)	{
                    System.out.println("You reload your gun");
                    ammo += 1;
                }	else if (move == 2)	{
                    if (ammo > 0)	{
                        System.out.println("You fire your gun");
                        ammo -= 1;
                    }	else	{
                        System.out.println("You have no ammo"); //make the button not even show up if the ammo is 0
                    }
                }	else if (move == 3) {
                    System.out.println("You hold up your shield");
                }

                if (comAmmo > 0)	{
                    comMove = r.nextInt(high - low + 1) + low;
                }	else {
                    comMove = r.nextInt(2 - 1 + 1) + 1;
                    if (comMove == 2)	{
                        comMove = 3;
                    }
                }

                if (comMove == 1)	{
                    System.out.println("The enemy reloads.");
                    comAmmo += 1;
                    if (move == 2)	{
                        System.out.println("You hit the enemy while they were reloading!");
                        win = 1;
                    }
                }	else if (comMove == 2)	{
                    System.out.println("The enemy fires at you.");
                    comAmmo -= 1;
                    if (move == 2) {
                        win = 3;
                    } else if (move == 3)	{
                        System.out.println("The shot bounces off your shield.");
                    } else {
                        win = 2;
                    }
                } else {
                    System.out.println("The enemy ducks behind their shield.");
                    if (move == 2) {
                        System.out.println("Your bullet bounces off their shield.");
                    }
                }
                System.out.println("\n----------------\nCOM move: " + comMove + "\nCOM Ammo: " + comAmmo);
            }

        }

}
*/
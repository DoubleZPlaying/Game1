import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static double version = 1.0;
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Monster> db = new ArrayList<Monster>();
        Player player1 = new Player(10, 1, 2, 5);
        Monster zombie = new Monster("Zombie", 10, 1, 3, 1, 1);
        db.add(zombie);
        Monster vampire = new Monster("Vampire", 15, 2, 5, 2, 1);
        db.add(vampire);
        Monster witch = new Monster("Witch", 15, 4, 5, 3, 2);
        db.add(witch);
        Monster troll = new Monster("Troll", 20, 4, 5, 4, 2);
        db.add(troll);
        Monster giant = new Monster("Giant", 30, 5, 7, 6, 3);
        db.add(giant);
        Monster sorcerer = new Monster("Sorcerer", 25, 7, 9, 5, 3); 
        db.add(sorcerer);

        player1.setHelmet(1);
        player1.setChestplate(1);
        player1.setPants(1);
        player1.setBoots(1);
        player1.setGauntlets(1);
        player1.setShield(1);
        player1.setTotalHP(player1.getHelmetNum(), player1.getChestplateNum(), player1.getPantsNum(), player1.getBootsNum(), player1.getShieldNum());

        String temp;
        String fight;
        boolean defend = false;
        int in;
        int run = 0;

        System.out.println("Welcome to DUNGEON CRAWLER 1, v" + version);
        System.out.println("");
        System.out.print("To open the how to play page press 1, to play press 2, to quit press 3: ");
        in = input.nextInt();
        temp = input.nextLine();
        System.out.println("");

        if(in == 1)
        {
            Main.help();
            System.out.println("");
            System.out.println("Press ENTER to begin exploring!");
            temp = input.nextLine();
        }

        else if(in == 2){}

        else
        {
            run = 1;
            System.out.println("You wake up in a small room in a vast dungeon. You have nothing but a set of leather armor and a stone club. There's one door out of the room. You push it open and step through . . .");
        }

        while(run == 0)
        {
            int m = -1;
            Battle.room();

            if(Battle.monster().equals("zombie"))
            {
                m = 0;
            }

            else if(Battle.monster().equals("vampire"))
            {
                m = 1;
            }

            else if(Battle.monster().equals("witch"))
            {
                m = 2;
            }

            else if(Battle.monster().equals("troll"))
            {
                m = 3;
            }

            else if(Battle.monster().equals("giant"))
            {
                m = 4;
            }

            else if(Battle.monster().equals("sorcerer"))
            {
                m = 5;
            }

            
            System.out.println("In the middle of the room stands a " + db.get(m).getName() + ", ready to fight.");
            
            while(true)
            {    
                System.out.println("Will you attack or protect yourself?");
                fight = input.nextLine();
                fight.toLowerCase();

                Monster monster1 = db.get(m);
            
                if(fight == "attack")
                {
                    int damage = player1.getAttack();
                    monster1.setHP(-(damage));
                    System.out.println(monster1.getName() + " sustained " + damage + " damage points, bringing it's health down to " + monster1.getHP());
                    defend = false;
                }

                else if(fight == "defend")
                {
                    defend = true;
                    System.out.println("You move into a defensive position and prepare to meet the " + monster1.getName() + "'s attack.");
                }

                if(monster1.getHP() <= 0)
                {
                    System.out.println("You killed the " + monster1.getName() + "!");
                    int money = monster1.getMoney();
                    String loot[] = monster1.getLoot();

                    player1.setBal(money);

                    if(loot[0].equals("Leather"))
                    {
                        if(loot[1].equals("Helmet"))
                        {
                            player1.setHelmet(1);
                        }

                        else if(loot[1].equals("Chestplate"))
                        {
                            player1.setChestplate(1);
                        }

                        else if(loot[1].equals("Pants"))
                        {
                            player1.setPants(1);
                        }

                        else if(loot[1].equals("Boots"))
                        {
                            player1.setBoots(1);
                        }
                    }

                    else if(loot[0].equals("Brigandine"))
                    {
                        if(loot[1].equals("Helmet"))
                        {
                            player1.setHelmet(2);
                        }

                        else if(loot[1].equals("Chestplate"))
                        {
                            player1.setChestplate(2);
                        }

                        else if(loot[1].equals("Pants"))
                        {
                            player1.setPants(2);
                        }

                        else if(loot[1].equals("Boots"))
                        {
                            player1.setBoots(2);
                        }
                    }

                    else if(loot[0].equals("Chainmail"))
                    {
                        if(loot[1].equals("Helmet"))
                        {
                            player1.setHelmet(3);
                        }

                        else if(loot[1].equals("Chestplate"))
                        {
                            player1.setChestplate(3);
                        }

                        else if(loot[1].equals("Pants"))
                        {
                            player1.setPants(3);
                        }

                        else if(loot[1].equals("Boots"))
                        {
                            player1.setBoots(3);
                        }
                    }

                    else if(loot[0].equals("Plate"))
                    {
                        if(loot[1].equals("Helmet"))
                        {
                            player1.setHelmet(4);
                        }

                        else if(loot[1].equals("Chestplate"))
                        {
                            player1.setChestplate(4);
                        }

                        else if(loot[1].equals("Pants"))
                        {
                            player1.setPants(4);
                        }

                        else if(loot[1].equals("Boots"))
                        {
                            player1.setBoots(4);
                        }
                    }

                    player1.setTotalHP(player1.getHelmetNum(), player1.getChestplateNum(), player1.getPantsNum(), player1.getBootsNum(), player1.getShieldNum());

                    if(loot[2].equals("Stone Club"))
                    {
                        player1.setAttack(1, 2);
                    }

                    else if(loot[2].equals("Steel Sword"))
                    {
                        player1.setAttack(2, 3);
                    }

                    else if(loot[2].equals("Mace"))
                    {
                        player1.setAttack(2, 3);
                    }

                    else if(loot[2].equals("Knightly Sword"))
                    {
                        player1.setAttack(3, 4);
                    }

                    else if(loot[2].equals("Gladius"))
                    {
                        player1.setAttack(3, 5);
                    }

                    else if(loot[2].equals("Ulfberht"))
                    {
                        player1.setAttack(4, 6);
                    }

                    else if(loot[2].equals("Scimitar"))
                    {
                        player1.setAttack(5, 7);
                    }

                    else if(loot[2].equals("LKatana"))
                    {
                        player1.setAttack(7, 8);
                    }

                    System.out.println("You got a " + loot[0] + " " + loot[1] + ", a " + loot[2] + ", and made $" + money + ".");
                    System.out.println("Your total HP is now " + player1.getTotalHP() + ", your balace is $" + player1.getBal() + ", you have a " + player1.getHelmet() + ", " + player1.getChestplate() + ", " + player1.getPants() + ", and " + player1.getBoots() + ", and " + player1.getGauntlets() + " and " + player1.getShield());
                    break;
                }

                //ADD ATTACK SPEED TIMER
                System.out.print("The " + monster1.getName() + " begins it's attack. You ");

                if(defend == false)
                {
                    int damage = monster1.getAttack();
                    player1.setHP(-(damage));
                    System.out.println("sustain " + damage + " damage points, bringing your HP to " + player1.getHP());
                }

                else if(defend == true)
                {
                    int damage = monster1.getAttack();
                    player1.setHP(-(damage) + 1);
                    System.out.println("defend yourself, and take " + (damage - 1) + " damage points, instead of " + damage + " damage points. Your HP is " + player1.getHP());
                }

                if(player1.getHP() <= 0)
                {
                    System.out.println("You died. You have lost everything except for your leather armor and stone club.");
                    player1.setHelmet(1);
                    player1.setChestplate(1);
                    player1.setPants(1);
                    player1.setBoots(1);
                    player1.setGauntlets(1);
                    player1.setShield(1);
                }

                else if(player1.getHP() > 0)
                {

                }
            }
        }

        if(run == 1)
        {
            System.out.println("We're sorry to see you go. Come again another time!");
        }

        else
        {
            System.out.println("Thanks for playing! Come play some other time!");
        }

        input.close();
    }

    public static void help()
    {
        System.out.println("HOW TO PLAY");
        System.out.println("Welcome to Dungeon Crawler 1, version " + version + ".");
        System.out.println("In this game, you, the player, are an explorer in a long-hidden in the dungeon. In this dungeon are monsters you will have to fight to gain loot and money.");
        System.out.println("Monster Stats:");
        System.out.println("- Zombie: 10 HP, 1-3 attack damage, 1/1 attack speed");
        System.out.println("- Vampire: 15 HP, 2-5 attack damage, 1/1 attack speed");
        System.out.println("- Witch: 15 HP, 4-5 attack damage, 1/2 attack speed");
        System.out.println("- Troll: 20 HP, 4-6 attack damage, 1/2 attack speed");
        System.out.println("- Giant: 30 HP, 5-7 attack damage, 1/3 attack speed");
        System.out.println("- Sorcerer: 25 HP, 7-9 attack damage, 1/3 attack speed");
        System.out.println("");
        System.out.println("From each monster you will be able to collect loot after killing, including money, armor, or weapons. The four types of armor, from least protection to greatest are as follows:");
        System.out.println("- Leather Armor, +1 protection per piece");
        System.out.println("- Brigandine Armor, +2 protection per piece");
        System.out.println("- Chainmail Armor, +3 protection per piece");
        System.out.println("- Plate Armor, +4 protection per piece");
        System.out.println("");
        System.out.println("All types of armor have a helmet, a chestplate, pants, and boots. In the armor category are shields and gauntlets as well. Shields add +2 protection, while gauntlets add +1 to attack damage. Shields and guantlets are only accessable through the shop. When you gain a higher tier armor-piece than the one currently equiped, the game will automaticall equip it for you.");
        System.out.println("In the game there are 8 different types of weapons. The following list is all in-game weapons and their attack damage:");
        System.out.println("- Stone Club, 1-2 attack damage");
        System.out.println("- Steel Sword, 2-3 attack damage");
        System.out.println("- Mace, 2-3 attack damage");
        System.out.println("- Knightly Sword, 3-4 attack damage");
        System.out.println("- Gladius, 3-5 attack damage");
        System.out.println("- Ulfberht (Viking Sword), 4-6 attack damage");
        System.out.println("- Scimitar, 5-7 attack damage");
        System.out.println("- Katana, 7-8 attack damage");
        System.out.println("");
        System.out.println("At the beginning of each session, you will spawn in with full leather armor and a stone club. As you kill more monsters, you'll be able to get better armor and weapons through their loot. However, if you die you'll lose everything, so be careful!");
        System.out.println("Now go off and explore your dungeon!");
    }
}
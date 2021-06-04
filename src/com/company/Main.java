package com.company;


import java.util.Random;

public class Main {

    public static int bossHealth = 800;
    public static int bossDamage = 70;
    public static int heroesMedik = 30;
    public static String bossDefenceType = " ";
    public static int[] heroesHealth = {250, 250, 250, 200};
    public static int[] heroesDamage = {20, 20, 20};
    public static String[] heroesAttackType = {"Physical", "Magical", "Mental"};

    public static void main(String[] args) {

        fightInfo();
        while (!isFinished()) {
            round();
        }

    }

    public static void round() {
        changeBossDefence();
        bossHit();
        heroesHit();
        fightInfo();
    }


    public static void changeBossDefence() {
        Random random1 = new Random();
        int randomIndex = random1.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];
    }

    public static boolean isFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("Boos won!");
            return true;
        }
        return false;
    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {

                    heroesHealth[i] = heroesHealth[i] + heroesMedik - bossDamage;
                }
            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (bossDefenceType.equals(heroesAttackType[i])) {
                    Random random2 = new Random();
                    int koeff = random2.nextInt(9) + 2;
                    if (bossHealth - heroesDamage[i] * koeff < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * koeff;
                    }
                    System.out.println(heroesAttackType[i] + " critical hit " + heroesDamage[i] * koeff);
                } else {
                    if (bossHealth - heroesDamage[i] < 0) {
                        bossHealth = 0;
                    } else {

                        bossHealth = bossHealth - heroesDamage[i] + heroesMedik;
                    }
                }
            }
        }
    }

    // Статистика боя
    public static void fightInfo() {
        System.out.println("_________________________");
        System.out.println("Boss health: " + bossHealth);
        System.out.println("Warrior health: " + heroesHealth[0]);
        System.out.println("Magic health: " + heroesHealth[1]);
        System.out.println("Kinetic health: " + heroesHealth[2]);
        System.out.println("Medik health: " + heroesHealth[3]);
        System.out.println("_________________________");
    }


}






















































//package com.company;
//
//import java.util.Random;
//
//public class Main {
//
//    public static int bossHealth = 700;
//    public static int bossDamage = 50;
//    public static String bossDefenceType = "";
//    public static int[] heroesHealth = {250, 250, 250};
//    public static int[] heroesDamage = {20, 20, 20};
//    public static String[] heroesAttackType = {"Physical", "Magical", "Mental"};
//
//
//    public static void main(String[] args) {
//
//        fightInfo();
//        while (!isFinished()) {
//            round();
//        }
//
//    }
//
//    public static void round() {
//        changeBossDefence();
//        bossHit();
//        heroesHit();
//        fightInfo();
//    }
//
//
//
//    public  static void changeBossDefence() {
//        Random random1 = new Random();
//        int randomIndex = random1.nextInt(heroesAttackType.length);
//        bossDefenceType = heroesAttackType[randomIndex];
//    }
//
//
//
//    public static boolean isFinished() {
//        if (bossHealth <= 0) {
//            System.out.println("Heroes won!");
//            return true;
//        }
//        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
//            System.out.println("Boss won!");
//            return true;
//        }
//        return false;
//    }
//
//
//
//    public static void bossHit() {
//        for (int i = 0; i < heroesHealth.length; i++) {
//            if (heroesHealth[i] > 0 && bossHealth > 0) {
//                if (heroesHealth[i] - bossDamage < 0) {
//                    heroesHealth[i] = 0;
//                } else {
//                    heroesHealth[i] = heroesHealth[i] - bossDamage;
//                }
//            }
//
//        }
//    }
//    public static void heroesHit() {
//        for (int i = 0; i < heroesDamage.length; i++) {
//            if (heroesHealth[i] > 0 && bossHealth > 0) {
//                if (bossDefenceType.equals(heroesAttackType[i])) {
//                    Random random2 = new Random();
//                    int koeff = random2.nextInt(9) + 2;
//                    if (bossHealth - heroesDamage[i] * koeff < 0) {
//                        bossHealth = 0;
//                    } else {
//                        bossHealth = bossHealth - heroesDamage[i] * koeff;
//                    }
//                    System.out.println(heroesAttackType[i] + " critical hit " + heroesDamage[i] * koeff);
//                } else {
//                    if (bossHealth - heroesDamage[i] < 0) {
//                        bossHealth = 0;
//                    } else {
//                        bossHealth = bossHealth - heroesDamage[i];
//                    }
//
//                }
//            }
//            }
//
//    }
//    public static void fightInfo() {
//        System.out.println("_____________________________");
//        System.out.println("Boss health " + bossHealth);
//        System.out.println("Warrior health " + heroesHealth[0]);
//        System.out.println("Magic health " + heroesHealth[1]);
//        System.out.println("Kinetic health " + heroesHealth[2]);
//        System.out.println("_____________________________");
//    }
//
//}
//




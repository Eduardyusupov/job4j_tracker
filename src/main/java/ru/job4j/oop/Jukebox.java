package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("Pust begut neugluze");
            case 2 -> System.out.println("Cpokoinoi nochi");
            default -> System.out.println("Pesna ne naidena");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
        jukebox.music(3);
    }
}

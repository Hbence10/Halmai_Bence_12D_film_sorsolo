package first_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class First_level {

    public static void main(String[] args) {
        ArrayList<String> schiFiMovies = new ArrayList<String>(Arrays.asList("Star Wars 1.", "Star Wars 2.", "Star Wars 3.", "Star Wars 4.", "Star Wars 5.", "Star Wars 6.", "Star Wars 7.", "Star Wars 8.", "Star Wars 9.", "Dune", "Dune: Part Two"));
        ArrayList<String> animatedMovies = new ArrayList<String>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
        ArrayList<String> horrorMovies = new ArrayList<String>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));

        ArrayList<String> categories = new ArrayList<String>(Arrays.asList("animation", "schi-fi", "horror"));

        Boolean isEnded = false;

        while (!isEnded) {
            System.out.println("Enter your wanted category:");
            Scanner userCategoryScanner = new Scanner(System.in);
            String userCategory = userCategoryScanner.nextLine();
            ArrayList<String> selectedList = new ArrayList<String>();

            while (!categories.contains(userCategory.trim().toLowerCase())) {
                System.err.println("Nincs ilyen kategoria! Kerem adjon meg egy ujat");
                userCategoryScanner = new Scanner(System.in);
                userCategory = userCategoryScanner.nextLine();
            }

            switch (userCategory) {
                case "animation":
                    selectedList = animatedMovies;
                    break;
                case "schi-fi":
                    selectedList = schiFiMovies;
                    break;
                case "horror":
                    selectedList = horrorMovies;
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println("Hany darab filmet szeretne?");

            Scanner movieAmountScanner = new Scanner(System.in);
            Integer movieAmount = movieAmountScanner.nextInt();

            Random random = new Random();
            while (movieAmount > selectedList.size()) {
                System.err.println("A kategória nem tartalmaz elegendő filmet. Kerem probalja meg ujbol");
                movieAmountScanner = new Scanner(System.in);
                movieAmount = movieAmountScanner.nextInt();
            }

            ArrayList<String> rolledMovies = new ArrayList<String>();
            while (rolledMovies.size() != movieAmount) {
                int selectedIndex = random.nextInt(0, selectedList.size());

                if (!rolledMovies.contains(selectedList.get(selectedIndex))) {
                    rolledMovies.add(selectedList.get(selectedIndex));
                }
            }

            System.out.println(rolledMovies);

            System.out.println("Szeretne ujra sorsolni? (1 = igen, 0 = nem)");
            Scanner decision = new Scanner(System.in);

            isEnded = decision.nextInt() == 0;
        }

//        System.out.println(userCategory);
    }

}

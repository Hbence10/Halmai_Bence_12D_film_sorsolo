package second_level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Second_level {

    public static void main(String[] args) {
        ArrayList<Movie> movieList = new ArrayList();
        ArrayList<String> availableCategory = new ArrayList();

        try {
            File txt = new File("src//movieList.txt");
            Scanner reader = new Scanner(txt);

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(";");
                movieList.add(new Movie(line[0], line[1].split(","), Integer.valueOf(line[2]), line[3], line[4], Integer.valueOf(line[5]), Float.valueOf(line[6])));
            }
        } catch (FileNotFoundException e) {
            System.err.println("ajjaj");
        }

        for (Movie i : movieList) {
            if (!availableCategory.contains(i.getCategory())) {
                availableCategory.add(i.getCategory());
            }
        }
        
        System.out.println("Udvozlom a film sorsolo alkalmazasba! Az alkalmazas hasznalata kozben figyeljen arra, hogy ekezeteket nem tamogatja az alkalmazas!");
        System.out.println("Az elerheto mufajok: " + availableCategory.toString().replace("[", "").replace("]", ""));

        Boolean isEnded = false;

        while (!isEnded) {
            System.out.println("\nKerem irja be, hogy milyen mufaju filmet/filmeket szeretne nezni:");
            Scanner userCategoryScanner = new Scanner(System.in);
            String userCategory = userCategoryScanner.nextLine().toLowerCase().trim();

            while (!availableCategory.contains(userCategory.trim().toLowerCase())) {
                System.err.println("Nincs ilyen kategoria! Kerem adjon meg egy ujat");
                userCategoryScanner = new Scanner(System.in);
                userCategory = userCategoryScanner.nextLine();
            }

            String wantedCategory = userCategory;
            List<Movie> selectedList = movieList.stream().filter(movie -> movie.getCategory().equals(wantedCategory)).toList();

            System.out.println("\nHany darab filmet szeretne nezni?");
            Scanner movieAmountScanner = new Scanner(System.in);
            Integer movieAmount = movieAmountScanner.nextInt();

            while (movieAmount > selectedList.size() && movieAmount > 0) {
                System.err.println("A kategoria nem tartalmaz elegendo filmet. Kerem probalja meg ujbol");
                movieAmountScanner = new Scanner(System.in);
                movieAmount = movieAmountScanner.nextInt();
            }

            Random random = new Random();

            ArrayList<Movie> rolledMovies = new ArrayList();

            while (rolledMovies.size() != movieAmount) {
                int selectedIndex = random.nextInt(0, selectedList.size());
                if (!rolledMovies.contains(selectedList.get(selectedIndex))) {
                    rolledMovies.add(selectedList.get(selectedIndex));
                }
            }

            rolledMovies = (ArrayList<Movie>) rolledMovies.stream().sorted((movie1, movie2) -> movie1.getImdbRating().compareTo(movie2.getImdbRating())).collect(Collectors.toList());

            System.out.println("\nA kisorsolt filmek listaja:");
            for (Movie i : rolledMovies) {
                System.out.println(i);
            }

            System.out.println("\nSzeretne ujra sorsolni? (1 = igen, 0 = nem)");
            Scanner decision = new Scanner(System.in);

            isEnded = decision.nextInt() == 0;
        }

        System.out.println("Koszonjuk, hogy a mi sorsolo alkalmazasunkat hasznaltuk!!!");
    }

}

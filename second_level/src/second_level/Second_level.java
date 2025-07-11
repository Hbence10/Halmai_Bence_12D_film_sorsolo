package second_level;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Second_level {

    public static void main(String[] args) {
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        ArrayList<String> availableCategory = new ArrayList<String>();

        System.out.println("Az elerheto mufajok: " + availableCategory.toString().replace("[", "").replace("]", ""));
        System.out.println("Udvozlom a film sorsolo alkalmazasba! Az alkalmazas hasznalata kozben figyeljen arra, hogy ekezeteket nem tamogatja az alkalmazas!");

        try {
            File txt = new File("src//movieList.txt");
            Scanner reader = new Scanner(txt);

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(";");
                movieList.add(new Movie(line[0], line[1].split(","), Integer.valueOf(line[2]), line[3], line[4], Integer.valueOf(line[5]), Float.valueOf(line[6])));
            }
        } catch (Exception e) {
            System.err.println("ajjaj");
        }

        for (Movie i : movieList) {
            if (!availableCategory.contains(i.getCategory())) {
                availableCategory.add(i.getCategory());
            }
        }

        Boolean isEnded = false;

        //Addig fog tartani a sorsolas mig az adott sorsolas vegen a felhasznalo be nem szeretne fejezni
        while (!isEnded) {
            //A felhasznalot megkerjuk, hogy adja meg, hogy milyen mufaju filmet/filmeket szeretne sorsoltatni
            System.out.println("Enter your wanted category:");
            Scanner userCategoryScanner = new Scanner(System.in);
            String userCategory = userCategoryScanner.nextLine();

            //Ha a felhasznalo nem letezo filmet add meg, akkor addig keri a felhasznalot a mufajert mig egy letezo mufajt add meg 
            while (!availableCategory.contains(userCategory.trim().toLowerCase())) {
                System.err.println("Nincs ilyen kategoria! Kerem adjon meg egy ujat");
                userCategoryScanner = new Scanner(System.in);
                userCategory = userCategoryScanner.nextLine();
            }

            String wantedCategory = userCategory;

            //A felhasznalo altal valasztott lista
            List<Movie> selectedList = movieList.stream().filter(movie -> movie.getCategory().equals(wantedCategory)).toList();

            //A kivant mennyiseg kerese a felhasznalotol
            System.out.println("Hany darab filmet szeretne?");
            Scanner movieAmountScanner = new Scanner(System.in);
            Integer movieAmount = movieAmountScanner.nextInt();

            //Ha a felhasznalo az elertnel tobb filmet szeretne kerni vagy negativ szamot ir be akkor addig fogja kerni a mennyiseget ameddig egy kivitelezheto mennyiseget nem fog kapni
            while (movieAmount > selectedList.size() && movieAmount > 0) {
                System.err.println("A kategória nem tartalmaz elegendő filmet. Kerem probalja meg ujbol");
                movieAmountScanner = new Scanner(System.in);
                movieAmount = movieAmountScanner.nextInt();
            }

            //A Random osztalyt peldanyositjuk
            Random random = new Random();

            //A sorsolt filmek:
            ArrayList<Movie> rolledMovies = new ArrayList();

            //Addig fog kigeneralni random szamokat ameddig a sorsolt filmeknek a mennyisege elegendo nem lesz 
            while (rolledMovies.size() != movieAmount) {
                //A Random osztaly altal kigeneralt szamok
                int selectedIndex = random.nextInt(0, selectedList.size());

                //Csak akkor fogja hozzaadni a listahoz ha az nem tartalmazza a sorsolt filmek listaja
                if (!rolledMovies.contains(selectedList.get(selectedIndex))) {
                    rolledMovies.add(selectedList.get(selectedIndex));
                }
            }

            rolledMovies = (ArrayList<Movie>) rolledMovies.stream().sorted((movie1, movie2) -> movie1.getImdbRating().compareTo(movie2.getImdbRating())).collect(Collectors.toList());

            //A kisorsolt filmek kiiratasa
            System.out.println("A kisorsolt filmek listaja (A filmeket az IMDB ertekeles alapjan novekvo sorrendben fogja latni):");
            for (Movie i : rolledMovies) {
                System.out.println(i.getTitle() + " | " + i.getImdbRating());
            }

            //Az ujrakezdesrol valo dontes
            System.out.println("Szeretne ujra sorsolni? (1 = igen, 0 = nem)");
            Scanner decision = new Scanner(System.in);

            //Gondolkodas: 1=ujrakezdes, 0=befejezes
            isEnded = decision.nextInt() == 0;
        }
    }

}

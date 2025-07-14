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
        ArrayList<Movie> movieList = new ArrayList();                                                                                                                                                                         //A filmeket tartalmazo lista

        //Fajl beolvasas || try --> hibakezeles, azert kell mert nem biztos, hogy letezik a megadott fajl, vagy lehet, hogy rossz eleresi utvonalat adunk meg 
        try {
            File txt = new File("src//movieList.txt");                                                                                                                                                                                  //A File class segitsegevel elerjuk a movieList.txt fajlt, ez a fajl tartalmazza a filmeket es azoknak az adatait
            Scanner reader = new Scanner(txt);                                                                                                                                                                                     //A txt-t egy Scanner segitsegeveel jarjuk be ||  a filmeknek az adatai egy ;-vel van elvalasztva

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(";");                                                                                                                                                                          //A szetsplitelt sorok a txt-bol --> split(): az adott stringre meghivva a parameternel megadott karakterenkent "szetszeleteli" az adott stringet. 
                movieList.add(new Movie(line[0], line[1].split(","), Integer.valueOf(line[2]), line[3], line[4], Integer.valueOf(line[5]), Float.valueOf(line[6])));                     //A kapott adatokkal letrehozzuk az adott Movie objectet
            }
        } catch (FileNotFoundException e) {                                                                                                                                                                                          //Amennyiben a program nem talalja meg a kivant fajlt akkor a kovetkezo uzenet fog megjelenni mint error a consolbam
            System.err.println("ajjaj");
        }

        List<String> availableCategory = movieList.stream().map(movie -> movie.getCategory()).distinct().toList();                                                                              //Az elerheto kategoriakat tartalmazza
        //stream() --> adatok feldolgozasara szokas hasznalni || map() --> atkasztalja a forras osszes elemet || distinct() --> csak a kulonbozo adatok maradnak meg a listaban

        System.out.println("Udvozlom a film sorsolo alkalmazasba! Az alkalmazas hasznalata kozben figyeljen arra, hogy ekezeteket nem tamogatja az alkalmazas!");
        System.out.println("Az elerheto mufajok: " + availableCategory.toString().replace("[", "").replace("]", ""));

        Boolean isEnded = false;                                                                                                                                                                                                            //Azt mutatja, hogy a sorsolas befejezodott-e

        while (!isEnded) {                                                                                                                                                                                                                       //Addig megy a program ameddig be nem fejezodik a sorsolas
            System.out.println("\nKerem irja be, hogy milyen mufaju filmet/filmeket szeretne nezni:");

            //A felhasznalotol bekerjuk a kivant mufajt
            Scanner userCategoryScanner = new Scanner(System.in);
            String userCategory = userCategoryScanner.nextLine().toLowerCase().trim();

            while (!availableCategory.contains(userCategory.trim().toLowerCase())) {                                                                                                                            //Addig fog menni a keres, ameddig a felhasznalo egy jelenlevo mufajt meg nem fog adni
                System.err.println("Nincs ilyen kategoria! Kerem adjon meg egy ujat");
                userCategoryScanner = new Scanner(System.in);
                userCategory = userCategoryScanner.nextLine();
            }

            String wantedCategory = userCategory;                                                                                                                                                                                 //Egy kulon valtozoba lementjuk az erteket || indok: ez a valtozo final igy lehet hasznalni egy lambda expressionben 
            List<Movie> selectedList = movieList.stream().filter(movie -> movie.getCategory().equals(wantedCategory)).toList();                                                          //Lambda expression: egy rovid kod reszleg amely egy parametert ker es egy erteket returnol

            //Bekerjuk a felhasznalotol a kivant mennyiseget
            System.out.println("\nHany darab filmet szeretne nezni?");
            Scanner movieAmountScanner = new Scanner(System.in);
            Integer movieAmount = movieAmountScanner.nextInt();

            while (movieAmount > selectedList.size() || movieAmount < 0) {                                                                                                                                              //Addig kerjuk be a szamokat ameddig nem megfelelo szamot adnak meg
                System.err.println(movieAmount < 0 ? "Negativ mennyiseget nem lehet megadni. Kerem probalja meg ujbol" : "A kategoria nem tartalmaz elegendo filmet. Kerem probalja meg ujbol"); //A hiba alapjan kiiratjuk az error uzenetet. 
                movieAmountScanner = new Scanner(System.in);
                movieAmount = movieAmountScanner.nextInt();
            }

            Random random = new Random();                                                                                                                                                                                           //Lehivjuk a Random class-t
            ArrayList<Movie> rolledMovies = new ArrayList();                                                                                                                                                                    //A kisorsolt filmeket tartalmazo lista

            while (rolledMovies.size() != movieAmount) {                                                                                                                                                                            //Addig fogja hozzaadni a filmeket a listahoz ameddig a lista merete egyenlo nem lesz a kivant mennyiseggel
                int selectedIndex = random.nextInt(0, selectedList.size());                                                                                                                                                   //A kisorsolt "film" || a random a 0 es a kivalasztott lista merete kozott fog adni random szamot 
                if (!rolledMovies.contains(selectedList.get(selectedIndex))) {                                                                                                                                               //Csak akkor fogja hozzaadni a filmet ha az meg nem tartalmazza a filmet
                    rolledMovies.add(selectedList.get(selectedIndex));
                }
            }

            //A kivalasztott filmek az IMDB ertekeles szerint sorba allitjuk
            rolledMovies = (ArrayList<Movie>) rolledMovies.stream().sorted((movie1, movie2) -> movie1.getImdbRating().compareTo(movie2.getImdbRating())).collect(Collectors.toList());

            //A kisorsolt filmek kiiratasa
            System.out.println("\nA kisorsolt filmek listaja:");
            for (Movie i : rolledMovies) {
                System.out.println(i);
            }

            System.out.println("\nSzeretne ujra sorsolni? (1 = igen, 0 = nem)");                                                                                                                                             //Az ujrakezdesrol valo dontes || ha 1-est nyom akkor ujra kezdodik, ha 0-ast nyom akkor befejezodik
            Scanner decision = new Scanner(System.in);

            while (decision.nextInt() != 0 || decision.nextInt() != 0) {                                                                                                                                                                 //Addig fogja kerni a felhasznalotol ameddig egy letezo valaszt nem fog adni
                System.err.println("Nem letezo dontest hozott!!! Kerem probalja ujra. (1 = igen, 0 = nem)");
                decision = new Scanner(System.in);
            }

            isEnded = decision.nextInt() == 0;                                                                                                                                                                                                   //Ha a felhasznalo befejezi akkor (0-at ir) az isEnded true lesz azaz a while-ban false-kent hivatkozunk ra || ha folytatni akkorja (1-et ir) akkor az isEnded false lesz azaz a whileban truekent hivatkozunk ra
        }

        System.out.println("Koszonjuk, hogy a mi sorsolo alkalmazasunkat hasznaltuk!!!");
    }

}

package first_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class First_level {

    public static void main(String[] args) {
        System.out.println("Udvozlom a film sorsolo alkalmazasba! Az alkalmazas hasznalata kozben figyeljen arra, hogy ekezeteket nem tamogatja az alkalmazas!");

        //Letrehozzuk a 3 kategorianak a 3 listajat, bennuk a 10-10-10 filmmel
        ArrayList<String> schiFiMovies = new ArrayList(Arrays.asList("Star Wars: A Baljos Arnyak.", "Star Wars: A Klonok tamadasa", "Star Wars: A Sithek bosszuja", "Star Wars: Az uj remeny", "Star Wars: A birodalom visszavag", "Star Wars: A jedi visszater", "Star Wars: Az ebredo ero", "Star Wars: Az utolso jedi", "Star Wars: A skywalker kora", "Dune", "Dune: Part Two"));
        ArrayList<String> horrorMovies = new ArrayList(Arrays.asList("Bunosok", "28 evvel kesobb", "Hozd vissza ot", "28 nappal", "M3GAN 2.0", "28 hettel kesobb", "Vegso allomas: Vervonalak", "A capa", "Maa", "Nosferatu"));
        ArrayList<String> animatedMovies = new ArrayList(Arrays.asList("K-pop demonvadaszok", "Elio", "Predator: gyilkosok gyilkosa", "Igy neveld a sarkanyodat", "A vad robot", "A hupikek torpikek", "Aradas", "Pokember: A Pokverzumon at", "Igy neveld a sarkanyodat 2.", "Chihiro szellemorszagban"));

        //Az elerheto kategoriakat tartalmazza, ennek a segitsegevel fogjuk meghatarozni, hogy a felhasznalo letezo mufajt adott meg 
        ArrayList<String> categories = new ArrayList(Arrays.asList("animation", "schi-fi", "horror"));
        System.out.println("Az elerheto mufajok: animation, schi-fi, horror");

        Boolean isEnded = false; //Azt mutatja, hogy a sorsolas befejezodott-e

        //Addig megy a program ameddig be nem fejezodik a sorsolas
        while (!isEnded) {
            //A felhasznalotol bekerjuk a kivant mufajt
            System.out.println("Enter your wanted category:");
            Scanner userCategoryScanner = new Scanner(System.in);
            String userCategory = userCategoryScanner.nextLine();

            //Addig fog menni a keres, ameddig a felhasznalo egy jelenlevo mufajt meg nem fog adni
            while (!categories.contains(userCategory.trim().toLowerCase())) {
                System.err.println("Nincs ilyen kategoria! Kerem adjon meg egy ujat");
                userCategoryScanner = new Scanner(System.in);
                userCategory = userCategoryScanner.nextLine();
            }

            ArrayList<String> selectedList = new ArrayList();  //A felhasznalo altal valasztott lista

            //A valasztott mufaj listajat lementi a selectedList valtozoba:
            switch (userCategory) {
                case "animation" ->
                    selectedList = animatedMovies;
                case "schi-fi" ->
                    selectedList = schiFiMovies;
                case "horror" ->
                    selectedList = horrorMovies;
                default ->
                    throw new AssertionError();
            }

            //Bekerjuk a felhasznalotol a kivant mennyiseget
            System.out.println("Hany darab filmet szeretne?");
            Scanner movieAmountScanner = new Scanner(System.in);
            Integer movieAmount = movieAmountScanner.nextInt();

            while (movieAmount > selectedList.size() || movieAmount < 0) {                                                                                                                                              //Addig kerjuk be a szamokat ameddig nem megfelelo szamot adnak meg
                System.err.println(movieAmount < 0 ? "Negativ mennyiseget nem lehet megadni. Kerem probalja meg ujbol" : "A kategoria nem tartalmaz elegendo filmet. Kerem probalja meg ujbol"); //A hiba alapjan kiiratjuk az error uzenetet. 
                movieAmountScanner = new Scanner(System.in);
                movieAmount = movieAmountScanner.nextInt();
            }

            Random random = new Random();        //Lehivjuk a Random class-t:
            ArrayList<String> rolledMovies = new ArrayList();  //A kisorsolt filmeket tartalmazo lista

            while (rolledMovies.size() != movieAmount) {  //Addig fogja hozzaadni a filmeket a listahoz ameddig a lista merete egyenlo nem lesz a kivant mennyiseggel
                int selectedIndex = random.nextInt(0, selectedList.size()); //A kisorsolt "film" || a random a 0 es a kivalasztott lista merete kozott fog adni random szamot 

                //Csak akkor fogja hozzaadni a listahoz ha az nem tartalmazza a sorsolt filmek listaja
                if (!rolledMovies.contains(selectedList.get(selectedIndex))) {  //Csak akkor fogja hozzaadni a filmet ha az meg nem tartalmazza a filmet
                    rolledMovies.add(selectedList.get(selectedIndex));
                }
            }

            System.out.println("A kisorsolt filmek listaja: " + rolledMovies.toString().replace("[", "").replace("]", ""));  //A kisorsolt filmek kiiratasa

            System.out.println("Szeretne ujra sorsolni? (1 = igen, 0 = nem)"); //Az ujrakezdesrol valo dontes || ha 1-est nyom akkor ujra kezdodik, ha 0-ast nyom akkor befejezodik
            Scanner decision = new Scanner(System.in);

            while (decision.nextInt() != 0 || decision.nextInt() != 0) {                                                                                                                                                                  //Addig fogja kerni a felhasznalotol ameddig egy letezo valaszt nem fog adni
                System.err.println("Nem letezo dontest hozott!!! Kerem probalja ujra. (1 = igen, 0 = nem)");
                decision = new Scanner(System.in);
            }

            isEnded = decision.nextInt() == 0;   //Ha a felhasznalo befejezi akkor (0-at ir) az isEnded true lesz azaz a while-ban false-kent hivatkozunk ra || ha folytatni akkorja (1-et ir) akkor az isEnded false lesz azaz a whileban truekent hivatkozunk ra
        }
    }

}

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
        
        //Azt mutatja, hogy a sorsolasnak vege van-e, vagy nem
        Boolean isEnded = false;

        //Addig fog tartani a sorsolas mig az adott sorsolas vegen a felhasznalo be nem szeretne fejezni
        while (!isEnded) {
            //A felhasznalot megkerjuk, hogy adja meg, hogy milyen mufaju filmet/filmeket szeretne sorsoltatni
            System.out.println("Enter your wanted category:");
            Scanner userCategoryScanner = new Scanner(System.in);
            String userCategory = userCategoryScanner.nextLine();

            //Ha a felhasznalo nem letezo filmet add meg, akkor addig keri a felhasznalot a mufajert mig egy letezo mufajt add meg 
            while (!categories.contains(userCategory.trim().toLowerCase())) {
                System.err.println("Nincs ilyen kategoria! Kerem adjon meg egy ujat");
                userCategoryScanner = new Scanner(System.in);
                userCategory = userCategoryScanner.nextLine();
            }

            //A felhasznalo altal valasztott lista
            ArrayList<String> selectedList = new ArrayList();

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
            ArrayList<String> rolledMovies = new ArrayList();

            //Addig fog kigeneralni random szamokat ameddig a sorsolt filmeknek a mennyisege elegendo nem lesz 
            while (rolledMovies.size() != movieAmount) {
                //A Random osztaly altal kigeneralt szamok
                int selectedIndex = random.nextInt(0, selectedList.size());

                //Csak akkor fogja hozzaadni a listahoz ha az nem tartalmazza a sorsolt filmek listaja
                if (!rolledMovies.contains(selectedList.get(selectedIndex))) {
                    rolledMovies.add(selectedList.get(selectedIndex));
                }
            }

            //A kisorsolt filmek kiiratasa
            System.out.println("A kisorsolt filmek listaja: " + rolledMovies.toString().replace("[", "").replace("]", ""));

            //Az ujrakezdesrol valo dontes
            System.out.println("Szeretne ujra sorsolni? (1 = igen, 0 = nem)");
            Scanner decision = new Scanner(System.in);

            //Gondolkodas: 1=ujrakezdes, 0=befejezes
            isEnded = decision.nextInt() == 0;
        }
    }

}

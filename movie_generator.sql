-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2025. Aug 01. 18:07
-- Kiszolgáló verziója: 10.4.32-MariaDB
-- PHP verzió: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `movie_generator`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'animated'),
(2, 'horror'),
(3, 'schi-fi'),
(4, 'action'),
(5, 'comedy');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `length_in_minute` int(3) NOT NULL,
  `rating` varchar(50) NOT NULL,
  `budget` int(10) NOT NULL,
  `description` longtext NOT NULL,
  `IMDB_rating` float NOT NULL,
  `IMDB_link` varchar(400) NOT NULL,
  `trailer_link` varchar(400) NOT NULL,
  `poster_path` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `movie`
--

INSERT INTO `movie` (`id`, `title`, `length_in_minute`, `rating`, `budget`, `description`, `IMDB_rating`, `IMDB_link`, `trailer_link`, `poster_path`) VALUES
(3, 'Star Wars: Episode I - The Phantom Menace', 136, '12', 115000000, 'When the Trade Federation organize a blockade around the planet Naboo, the Supreme Chancellor Valorum sends the Jedi Qui-Gon Jinn and Obi-Wan Kenobi to negotiate the end of the blockade. However the evil Viceroy Nute Gunray is ordered to kill the Jedi and invade Naboo. However the Jedi escape and Qui-Gon saves the life of the clumsy Gungan Jar Jar Binks. The outcast native takes the Jedi to his submerged city and the Gungan leader gives transportation to them. The Jedi head to the capital to warn Queen Amidala about the invasion. However she has been captured by the Federation droids but the Jedi rescue the queen and her court and they flee in a spacecraft that is damaged when they cross the blockade. They land on a desert planet and Qui-Gon Jinn goes to the town with Jar Jar, the droid R2-D2 and the queen\'s assistant Padmé to seek the necessary part for the spacecraft. When they find the component, they do not have money to buy it. But the slave boy Anakin Skywalker offers to dispute a race with his pod to raise the necessary money. Qui-Gon feels the Force in the boy and accepts his offer. Will the boy win the race? What will happen to Naboo? Will Queen Amidala be capable to convince the politicians to release her planet from the Trade Federation?', 6.5, 'https://www.imdb.com/title/tt0120915/?ref_=ls_t_22', 'https://www.youtube.com/watch?v=bD7bpG-zDJQ', NULL),
(4, 'Star Wars: Episode II - Attack of the Clones', 142, '12', 115000000, 'Ten years after the invasion of Naboo, the Galactic Republic is facing a Separatist movement and the former queen and now Senator Padmé Amidala travels to Coruscant to vote on a project to create an army to help the Jedi to protect the Republic. Upon arrival, she escapes from an attempt to kill her, and Obi-Wan Kenobi and his Padawan Anakin Skywalker are assigned to protect her. They chase the shape-shifter Zam Wessell but she is killed by a poisoned dart before revealing who hired her. The Jedi Council assigns Obi-Wan Kenobi to discover who has tried to kill Amidala and Anakin to protect her in Naboo. Obi-Wan discovers that the dart is from the planet Kamino, and he heads to the remote planet. He finds an army of clones that has been under production for years for the Republic and that the bounty hunter Jango Fett was the matrix for the clones. Meanwhile Anakin and Amidala fall in love with each other, and he has nightmarish visions of his mother. They travel to his home planet, Tatooine, to see his mother, and he discovers that she has been abducted by Tusken Raiders. Anakin finds his mother dying, and he kills all the Tusken tribe, including the women and children. Obi-Wan follows Jango Fett to the planet Geonosis where he discovers who is behind the Separatist movement. He transmits his discoveries to Anakin since he cannot reach the Jedi Council. Who is the leader of the Separatist movement? Will Anakin receive Obi-Wan\'s message? And will the secret love between Anakin and Amidala succeed?', 6.6, 'https://www.imdb.com/title/tt0121765/?ref_=ls_t_21', 'https://www.youtube.com/watch?v=gYbW1F_c9eM&t=11s', NULL),
(5, 'Star Wars: Episode III - Revenge of the Sith', 140, '12', 113000000, 'Nearly three years have passed since the beginning of the Clone Wars. The Republic, with the help of the Jedi, take on Count Dooku and the Separatists. With a new threat rising, the Jedi Council sends Obi-Wan Kenobi and Anakin Skywalker to aid the captured Chancellor. Anakin feels he is ready to be promoted to Jedi Master. Obi-Wan is hunting down the Separatist General, Grievous. When Anakin has future visions of pain and suffering coming Padmé\'s way, he sees Master Yoda for counsel. When Darth Sidious executes Order 66, it destroys most of all the Jedi have built. Experience the birth of Darth Vader. Feel the betrayal that leads to hatred between two brothers. And witness the power of hope.', 7.6, 'https://www.imdb.com/title/tt0121766/?ref_=ls_t_13', 'https://www.youtube.com/watch?v=5UnjrG_N8hU', NULL),
(6, 'Star Wars: Episode IV - A New Hope', 121, '12', 11000000, 'The Imperial Forces under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.', 8.7, 'https://www.imdb.com/title/tt0076759/?ref_=ls_t_2', '', NULL),
(7, 'Star Wars: Episode V - The Empire Strikes Back', 124, '12', 30500000, 'The legendary saga continues as the Rebel Alliance faces increasing challenges from the mighty Galactic Empire. Luke Skywalker, Han Solo, and Princess Leia Organa confront new trials that test their courage, friendships, and beliefs. The Rebel Alliance has established a hidden base on the icy planet of Hoth, where they hope to regroup and plan their next moves against the Empire. Luke Skywalker receives a message from a familiar source, prompting him to seek further guidance in understanding his connection to the Force. Han Solo and Princess Leia\'s journey takes them on a dangerous path as they navigate a galaxy under Imperial control. Their actions and decisions lead to unforeseen consequences that will impact the fate of the Rebellion. Meanwhile, the dark presence of Darth Vader looms as he relentlessly pursues the Rebels while dealing with inner conflicts of his own.', 8.6, 'https://www.imdb.com/title/tt0080684/?ref_=ls_t_1', '', NULL),
(8, 'Star Wars: Episode VI - Return of the Jedi', 131, '12', 32500000, 'Luke Skywalker (Mark Hamill) battles horrible Jabba the Hut and cruel Darth Vader to save his comrades in the Rebel Alliance and triumph over the Galactic Empire. Han Solo (Harrison Ford) and Princess Leia (Carrie Fisher) reaffirm their love and team with Chewbacca, Lando Calrissian (Billy Dee Williams), the Ewoks and the androids C-3PO and R2-D2 to aid in the disruption of the Dark Side and the defeat of the evil emperor.', 8.3, 'https://www.imdb.com/title/tt0086190/?ref_=ls_t_6', '', NULL),
(9, 'Star Wars: Episode VII - The Force Awakens', 138, '12', 533000000, '30 years after the defeat of Darth Vader and the Empire, Rey, a scavenger from the planet Jakku, finds a BB-8 droid that knows the whereabouts of the long lost Luke Skywalker. Rey, as well as a rogue stormtrooper and two smugglers, are thrown into the middle of a battle between the Resistance and the daunting legions of the First Order.', 7.7, 'https://www.imdb.com/title/tt2488496/?ref_=ls_t_9', '', NULL),
(10, 'Star Wars: Episode VIII - The Last Jedi', 152, '12', 300000000, 'Jedi Master-in-hiding Luke Skywalker unwillingly attempts to guide young hopeful Rey in the ways of the force, while Leia, former princess turned general, attempts to lead what is left of the Resistance away from the ruthless tyrannical grip of the First Order.', 6.9, 'https://www.imdb.com/title/tt2527336/?ref_=ls_t_19', '', NULL),
(11, 'Star Wars: Episode IX - The Rise of Skywalker', 141, '12', 416000000, 'While the First Order continues to ravage the galaxy, Rey finalizes her training as a Jedi. But danger suddenly rises from the ashes as the evil Emperor Palpatine mysteriously returns from the dead. While working with Finn and Poe Dameron to fulfill a new mission, Rey will not only face Kylo Ren once more, but she will also finally discover the truth about her parents as well as a deadly secret that could determine her future and the fate of the ultimate final showdown that is to come.', 6.4, 'https://www.imdb.com/title/tt2527338/?ref_=ls_t_23', '', NULL),
(12, 'Dune: Part One', 155, 'PG-13', 165000000, 'A mythic and emotionally charged hero\'s journey, \"Dune\" tells the story of Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, who must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet\'s exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity\'s greatest potential-only those who can conquer their fear will survive.', 8, 'https://www.imdb.com/title/tt1160419/?ref_=fn_all_ttl_3', '', NULL),
(13, 'Dune: Part Two', 166, '16', 190000000, 'Paul Atreides unites with Chani and the Fremen while on a warpath of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the known universe, he endeavors to prevent a terrible future only he can foresee', 8.5, 'https://www.imdb.com/title/tt15239678/?ref_=fn_all_ttl_1', '', NULL),
(14, 'The Silence of the Lambs', 118, '18', 0, 'F.B.I. trainee Clarice Starling (Jodie Foster) works hard to advance her career, while trying to hide or put behind her West Virginia roots, of which if some knew, would automatically classify her as being backward or white trash. After graduation, she aspires to work in the agency\'s Behavioral Science Unit under the leadership of Jack Crawford (Scott Glenn). While she is still a trainee, Crawford asks her to question Dr. Hannibal Lecter (Sir Anthony Hopkins), a psychiatrist imprisoned, thus far, for eight years in maximum security isolation for being a serial killer who cannibalized his victims. Clarice is able to figure out the assignment is to pick Lecter\'s brains to help them solve another serial murder case, that of someone coined by the media as \"Buffalo Bill\" (Ted Levine), who has so far killed five victims, all located in the eastern U.S., all young women, who are slightly overweight (especially around the hips), all who were drowned in natural bodies of water, and all who were stripped of large swaths of skin. She also figures that Crawford chose her, as a woman, to be able to trigger some emotional response from Lecter. After speaking to Lecter for the first time, she realizes that everything with him will be a psychological game, with her often having to read between the very cryptic lines he provides. She has to decide how much she will play along, as his request in return for talking to him is to expose herself emotionally to him. The case takes a more dire turn when a sixth victim is discovered, this one from who they are able to retrieve a key piece of evidence, if Lecter is being forthright as to its meaning. A potential seventh victim is high profile Catherine Martin (Brooke Smith), the daughter of Senator Ruth Martin (Diane Baker), which places greater scrutiny on the case as they search for a hopefully still alive Catherine. Who may factor into what happens is Dr. Frederick Chilton (Anthony Heald), the warden at the prison, an opportunist who sees the higher profile with Catherine, meaning a higher profile for himself if he can insert himself successfully into the proceedings', 8.6, 'https://www.imdb.com/title/tt0102926/?ref_=sr_t_1', '', NULL),
(15, 'The Shining', 146, '18', 0, 'After landing a job as an off-season caretaker, Jack Torrance, an aspiring author and recovering alcoholic, drags his wife Wendy and gifted son Danny to snow-covered Colorado\'s secluded Overlook Hotel. However, writer\'s block prevents Jack from pursuing a new writing career. Everything has its time, however. First, the manager must give Jack a grand tour. Then, Mr Hallorann, the facility\'s aging chef, chats with Danny about rare psychic gifts. The mysterious employee also warns the boy about the cavernous hotel\'s abandoned rooms. Room 237, especially, is off-limits. That\'s all very well, but Jack is gradually losing his mind. After all, strange occurrences and blood-chilling visions have trapped the family in a silent gargantuan prison hammered by endless snowstorms. And now, incessant voices inside Jack\'s head demand sacrifice. However, is Jack capable of murder?', 8.4, 'https://www.imdb.com/title/tt0081505/?ref_=sr_t_2', '', NULL),
(16, 'Alien', 117, '16', 0, 'In the distant future, the commercial spaceship \"Nostromo\" crew is on its way home when the crew picks up a distress call from a distant moon. The crew must investigate, and the spaceship descends on the small planetoid afterwards. After a rough landing, three crew members leave the spaceship to explore the area on the planetoid. At the same time, the ship\'s computer deciphers the message. When the crew realizes it is not alone on the spaceship, they must deal with the consequences', 8.5, 'https://www.imdb.com/title/tt0078748/?ref_=sr_t_3', '', NULL),
(17, 'I Am Legend', 101, '16', 0, 'Robert Neville (Will Smith) is a scientist who was unable to stop the spread of the terrible virus that was incurable and man-made in this post-apocalyptic action thriller. Immune, Neville is now the last human survivor in what is left of New York City and perhaps the world. For three years, Neville has faithfully sent out daily radio messages, desperate to find any other survivors who might be out there. But he is not alone. Mutant victims of the plague - the Infected - lurk in the shadows - watching Neville\'s every move - waiting for him to make a fatal mistake. Perhaps mankind\'s last, best hope, Neville is driven by only one remaining mission: to find a way to reverse the effects of the virus using his own immune blood. But he knows he is outnumbered - and quickly running out of time.', 7.2, 'https://www.imdb.com/title/tt0480249/?ref_=sr_t_4', '', NULL),
(18, 'Aliens', 137, '16', 0, '57 years after Ellen Ripley had a close encounter with the reptilian alien creature from the first movie, she is called back, this time, to help a group of highly trained colonial marines fight off against the sinister extraterrestrials. But this time, the aliens have taken over a space colony on the moon LV-426. When the colonial marines are called upon to search the deserted space colony, they later find out that they are up against more than what they bargained for. Using specially modified machine guns and enough firepower, it\'s either fight or die as the space marines battle against the aliens.', 8.4, 'https://www.imdb.com/title/tt0090605/?ref_=sr_t_5', '', NULL),
(19, 'American Psycho', 102, '18', 0, 'It\'s the late 1980s. Twenty-seven year old Wall Streeter Patrick Bateman travels among a closed network of the proverbial beautiful people, that closed network in only they able to allow others like themselves in in a feeling of superiority. Patrick has a routinized morning regimen to maintain his appearance of attractiveness and fitness. He, like those in his network, are vain, narcissistic, egomaniacal and competitive, always having to one up everyone else in that presentation of oneself, but he, unlike the others, realizes that, for himself, all of these are masks to hide what is truly underneath, someone/something inhuman in nature. In other words, he is comprised of a shell resembling a human that contains only greed and disgust, greed in wanting what others may have, and disgust for those who do not meet his expectations and for himself in not being the first or the best. That disgust ends up manifesting itself in wanting to rid the world of those people, he not seeing them as people but only of those characteristics he wants to rid.', 7.6, 'https://www.imdb.com/title/tt0144084/?ref_=sr_t_6', '', NULL),
(20, 'Get Out', 104, '16', 0, 'Chris and his girlfriend Rose go upstate to visit her parents for the weekend. At first, Chris reads the family\'s overly accommodating behavior as nervous attempts to deal with their daughter\'s interracial relationship, but as the weekend progresses, a series of increasingly disturbing discoveries lead him to a truth that he never could have imagined.', 7.8, 'https://www.imdb.com/title/tt5052448/?ref_=sr_t_7', '', NULL),
(21, 'World War Z', 114, '16', 0, 'Life for former United Nations investigator Gerry Lane and his family seems content. Suddenly, the world is plagued by a mysterious infection turning whole human populations into rampaging mindless zombies. After barely escaping the chaos, Lane is persuaded to go on a mission to investigate this disease. What follows is a perilous trek around the world where Lane must brave horrific dangers and long odds to find answers before human civilization falls.', 7, 'https://www.imdb.com/title/tt0816711/?ref_=sr_t_8', '', NULL),
(22, 'Psycho', 109, '18', 0, 'Phoenix office worker Marion Crane is fed up with the way life has treated her. She has to meet her lover Sam in lunch breaks, and they cannot get married because Sam has to give most of his money away in alimony. One Friday, Marion is trusted to bank forty thousand dollars by her employer. Seeing the opportunity to take the money and start a new life, Marion leaves town and heads towards Sam\'s California store. Tired after the long drive and caught in a storm, she gets off the main highway and pulls into the Bates Motel. The motel is managed by a quiet young man called Norman who seems to be dominated by his mother.', 8.5, 'https://www.imdb.com/title/tt0054215/?ref_=sr_t_9', '', NULL),
(23, 'Jaws', 124, '16', 0, 'It\'s a hot summer on Amity Island, a small community whose primary business is its beaches. When new Police Chief Martin Brody discovers the remains of a shark attack victim, his first inclination is to close the beaches to swimmers. It doesn\'t sit well with Mayor Larry Vaughn and several local business people. Brody backs down to his regret of that weekend. A predator kills a young boy. The dead boy\'s mother puts out a bounty on the shark, and Amity is soon swamped with amateur hunters and fishermen hoping to cash in on the reward. A local fisherman with much experience hunting sharks, Quint, offers to hunt down the creature for a hefty fee. Soon, Quint, Brody, and Matt Hooper from the Oceanographic Institute are hunting the Great White shark at sea. As Brody succinctly surmises after their first encounter with the creature, they will need a bigger boat.', 8.1, 'https://www.imdb.com/title/tt0073195/?ref_=sr_t_10', '', NULL),
(24, '', 0, '0', 70000000, '', 0, '', '', NULL),
(25, '', 0, '0', 200000000, '', 0, '', '', NULL),
(26, '', 0, '0', 65000000, '', 0, '', '', NULL),
(27, '', 0, '0', 150000000, '', 0, '', '', NULL),
(28, '', 0, '0', 78000000, '', 0, '', '', NULL),
(29, '', 0, '0', 110000000, '', 0, '', '', NULL),
(30, '', 0, '0', 3500000, '', 0, '', '', NULL),
(31, '', 0, '0', 150000000, '', 0, '', '', NULL),
(32, '', 0, '0', 145000000, '', 0, '', '', NULL),
(33, '', 0, '0', 19200000, '', 0, '', '', NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `movie_genre`
--

CREATE TABLE `movie_genre` (
  `id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `movie_genre`
--
ALTER TABLE `movie_genre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `movie` (`movie_id`),
  ADD KEY `genre` (`genre_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT a táblához `movie_genre`
--
ALTER TABLE `movie_genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `movie_genre`
--
ALTER TABLE `movie_genre`
  ADD CONSTRAINT `genre` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  ADD CONSTRAINT `movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

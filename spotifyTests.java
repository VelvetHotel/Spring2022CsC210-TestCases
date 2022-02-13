/*
 * 
 * AUTHOR: Jacobe Delany
 * Project: PA4 - Spotify 
 * Purpose:  test both formatting as well as the return
 * of certain methods for PA4 - Spotify. Note there might
 * be some errors with the test cases as i've updated them as I went
 * I checked before publishing, but I could have missed some specifics.
 * Tweaking may be required as  i have what could be redunent tests
 * on boolean return methods as i have to make sure my ternary statements
 * are done correctly. 
 * Last note in order to use this file in eclipse:
 * 1. hit ctrl + N and go to the Junit test file.
 * 2. Create a new Junit4 test file and import the Junit package.
 * 3. Lastly you can either replace the file you created or copy 
 * the contents onto it 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class spotifyTests {

	/*
	 * This  test the play() method the expected return is 20
	 */	
	@Test
	void songTestPlays_1() {
		System.out.println("--------------Play count Check-----------------");
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		System.out.println("-----------------------------------------------");

		for(int i = 0; i < 3; i++) {
			blackCoffee.play();
		}
		System.out.println("Black coffee  expected 3 plays, got, " + blackCoffee.GetTimesPlayed() + " Plays");
		assertEquals(3, blackCoffee.GetTimesPlayed());
	}
	
	/*
	 * This test makes sure that the toString() method  matches
	 * with the expected string that the method should create
	 * expected outcome is true (meaning the strings match)
	 */
	@Test
	void songTestPlays_2() {
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		for(int i = 0; i < 3; i++) {
			blackCoffee.play();
		}
		// boolean variable is used to make the test more explicit
		boolean matches = "Black Coffee by Kill Bill: The Rapper, 3 play(s)".equals(blackCoffee.toString());
		System.out.println("---------Song toString-----------");
		System.out.println(blackCoffee);
		System.out.println("----------------------------------");
		assertEquals(true , matches);
	}
	
	/*
	 * THis is to test the getSong method where there the
	 * song does exist in the library. The expected outcome 
	 * is the return of song's reference in memory.
	 */
	@Test
	void LibraryTest_1() {
		// songs are initialized as individuals for more explicit test cases
		// by nature of the  library add song also gets tested here
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Library libraryTest = new Library();
		libraryTest.addSong(worth);
		libraryTest.addSong(blackCoffee);
		libraryTest.addSong(loveDrug);
		libraryTest.addSong(snakeHouse);
		System.out.println("----------------Song exists in library----------------");
		if(libraryTest.getSong("Love Drug") == loveDrug) {
		System.out.println("Love Drug was found");
		}else {
			System.out.println(" Love Drug was Not Found");
		}
		System.out.println("-------------------------------------------------------");

		assertEquals(loveDrug, libraryTest.getSong("Love Drug"));
	}
	/*
	 * This is to test the getSong() method  on a song 
	 *  That does not exist in the library 
	 */
	@Test
	void LibraryTest_2() {
		// songs are initialized as individuals for more explicit test cases
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Library libraryTest = new Library();
		libraryTest.addSong(worth);
		libraryTest.addSong(blackCoffee);
		libraryTest.addSong(loveDrug);
		libraryTest.addSong(snakeHouse);
		System.out.println("----------------Song does not exist in library----------------");
		if(libraryTest.getSong("Lavender") == null) {
			System.out.println("Lavender was Not Found");
		}
		System.out.println("--------------------------------------------------------------");

		assertEquals(null, libraryTest.getSong("Lavender"));
	}
	
	/*
	 * This is to test the toString() Method. I did not want to go through the
	 * pain of creating the abomination of a string that is needed to print 
	 * out the library 
	 */
	@Test
	void LibraryTest_3() {
		// songs are initialized as individuals for more explicit test cases
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Library libraryTest = new Library();
		libraryTest.addSong(worth);
		libraryTest.addSong(blackCoffee);
		libraryTest.addSong(loveDrug);
		libraryTest.addSong(snakeHouse);
		System.out.println("-------------To String Test for Library--------------");
		System.out.print(libraryTest);
		System.out.println("-----------------------------------------------------");
	}
	/*
	 * This is to test removing a song that does not exist in the library.
	 * The  expected return is null.
	 */
	@Test
	void LibraryTest_4() {
		// songs are initialized as individuals for more explicit test cases
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Library libraryTest = new Library();
		libraryTest.addSong(worth);
		libraryTest.addSong(blackCoffee);
		libraryTest.addSong(loveDrug);
		libraryTest.addSong(snakeHouse);
		System.out.println("-----------Remove song test for library--------------");
		System.out.print(libraryTest);
		System.out.println("-----------------------------------------------------");
		libraryTest.removeSong(loveDrug);
		assertEquals(null, libraryTest.getSong("Love Drug"));
	}
	/*
	 * This is to test the full functionality of the playlist using 
	 * the  PLayList(String titleOfPlayList) constructor. 
	 * addSong and RemoveSong will be put to the test as well as play
	 * Finally (specific to my code) assumes that song play count
	 * gets incremented each time it is played in the playlist. 
	 */
	@Test
	void PlayList_test1() {
		// songs are initialized as individuals for more explicit test cases
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Song ugh = new Song("UGH","KawaiiSprite");
		Playlist beep = new Playlist("da good stuff");
		beep.addSong(worth);
		beep.addSong(blackCoffee);
		beep.addSong(loveDrug);
		beep.addSong(snakeHouse);
		beep.addSong(ugh);
		System.out.println("---------------constructor 1 playlist----------------");
		beep.play();
		System.out.println("-----------------------------------------------------");
		beep.removeSong(worth);
		System.out.println("---------------constructor 1 playlist----------------");
		beep.play();
		System.out.println("-----------------------------------------------------");
	}
	/*
	 * This is to test the full functionality of the playlist using 
	 * the  PLayList(String tile List<Songs> contents ) constructor. 
	 * addSong and RemoveSong will be put to the test as well as play
	 * Finally (specific to my code) assumes that song play count
	 * gets incremented each time it is played in the playlist. 
	 */
	@Test
	void PlayList_test2() {
		// songs are initialized as individuals for more explicit test cases
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Song ugh = new Song("UGH","KawaiiSprite");
		ArrayList<Song> boppinList = new ArrayList<Song>();
		boppinList.add(loveDrug);
		boppinList.add(snakeHouse);
		boppinList.add(worth);
		boppinList.add(ugh);
		boppinList.add(blackCoffee);
		Playlist beep = new Playlist("da good stuff",boppinList);
		System.out.println("---------------constructor 2 playlist----------------");
		beep.play();
		System.out.println("-----------------------------------------------------");
		beep.removeSong(worth);
		System.out.println("---------------constructor 2 playlist----------------");
		beep.play();
		System.out.println("-----------------------------------------------------");
	}
	/*
	 * This is a password failed attempt. The expected
	 *  outcome of this test is false.
	 */
	@Test
	void user_test1() {
		// songs are initialized as individuals for more explicit test cases
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Song ugh = new Song("UGH","KawaiiSprite");
		ArrayList<Song> boppinList = new ArrayList<Song>();
		boppinList.add(loveDrug);
		boppinList.add(snakeHouse);
		boppinList.add(worth);
		boppinList.add(ugh);
		boppinList.add(blackCoffee);
		Playlist beep = new Playlist("da good stuff",boppinList);
		User goblin = new User("Goblin", "Password1234");
		assertEquals(false, goblin.attemptLogin("e"));
	}
	/*
	 * This is a correct password check. The expected
	 * outcome is True 
	 */
	@Test
	void user_test2() {
		// songs are initialized as individuals for more explicit test cases
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Song ugh = new Song("UGH","KawaiiSprite");
		ArrayList<Song> boppinList = new ArrayList<Song>();
		boppinList.add(loveDrug);
		boppinList.add(snakeHouse);
		boppinList.add(worth);
		boppinList.add(ugh);
		boppinList.add(blackCoffee);
		Playlist beep = new Playlist("da good stuff",boppinList);
		User goblin = new User("Goblin", "Password1234");
		assertEquals(true, goblin.attemptLogin("Password1234"));
	}
	/*
	 *  This test is a printing format test for the user profile 
	 *  This also plays the songs needed as their format needs to be checked
	 *  as well
	 */
	@Test
	void ser_test3() {
		// songs are initialized as individuals for more explicit test cases
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Song ugh = new Song("UGH","KawaiiSprite");
		ArrayList<Song> boppinList = new ArrayList<Song>();
		boppinList.add(loveDrug);
		boppinList.add(snakeHouse);
		boppinList.add(worth);
		boppinList.add(ugh);
		boppinList.add(blackCoffee);
		Playlist beep = new Playlist("da good stuff",boppinList);
		User goblin = new User("Goblin", "Password1234");
		goblin.addPlaylist(beep);
		System.out.println("---------------User toString-----------------");
		System.out.println(goblin);
		System.out.println("----------------------------------------------");

		System.out.println("---------------play list select test-----------------");
		goblin.selectPlaylist("da good stuff");
		System.out.println("-----------------------------------------------------");
	}
	@Test
	/*
	 * This is to check if a user exists. The expected outcome for 
	 * this  test is true
	 */
	void userCollection_test1() {
		// songs are initialized as individuals for more explicit test cases
		UserCollection graveLord= new UserCollection();
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Song ugh = new Song("UGH","KawaiiSprite");
		ArrayList<Song> boppinList = new ArrayList<Song>();
		boppinList.add(loveDrug);
		boppinList.add(snakeHouse);
		boppinList.add(worth);
		boppinList.add(ugh);
		boppinList.add(blackCoffee);
		Playlist beep = new Playlist("da good stuff",boppinList);
		User goblin = new User("Goblin", "Password1234");
		goblin.addPlaylist(beep);
		graveLord.addUser(goblin);
		assertEquals(true,graveLord.userExists("Goblin"));
	}
	@Test
	/*
	 * This is to check if a user does not exist. The expected outcome for 
	 * this  test is null
	 */
	void userCollection_test2() {
		// songs are initialized as individuals for more explicit test cases
		UserCollection graveLord= new UserCollection();
		Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
		Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
		Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
		Song worth = new Song("Worth", "Kill Bill: The Rapper");
		Song ugh = new Song("UGH","KawaiiSprite");
		ArrayList<Song> boppinList = new ArrayList<Song>();
		boppinList.add(loveDrug);
		boppinList.add(snakeHouse);
		boppinList.add(worth);
		boppinList.add(ugh);
		boppinList.add(blackCoffee);
		Playlist beep = new Playlist("da good stuff",boppinList);
		User goblin = new User("Goblin", "Password1234");
		goblin.addPlaylist(beep);
		graveLord.addUser(goblin);
		assertEquals(false,graveLord.userExists("Gooblin"));
	}
	/* This test is to simulate a failed login attempt.
	 * The expected outcome is null
	 */
	@Test
	void userCollection_test3() {
	// songs are initialized as individuals for more explicit test cases
	UserCollection graveLord= new UserCollection();
	Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
	Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
	Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
	Song worth = new Song("Worth", "Kill Bill: The Rapper");
	Song ugh = new Song("UGH","KawaiiSprite");
	ArrayList<Song> boppinList = new ArrayList<Song>();
	boppinList.add(loveDrug);
	boppinList.add(snakeHouse);
	boppinList.add(worth);
	boppinList.add(ugh);
	boppinList.add(blackCoffee);
	Playlist beep = new Playlist("da good stuff",boppinList);
	User goblin = new User("Goblin", "Password1234");
	goblin.addPlaylist(beep);
	graveLord.addUser(goblin);
	assertEquals(null,graveLord.login("Goblin", "paass"));
	}
	/* This test is to simulate a successful login attempt.
	 * The expected outcome is the User refference
	 */
	@Test
	void userCollection_test4() {
	// songs are initialized as individuals for more explicit test cases
	UserCollection graveLord= new UserCollection();
	Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
	Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
	Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
	Song worth = new Song("Worth", "Kill Bill: The Rapper");
	Song ugh = new Song("UGH","KawaiiSprite");
	ArrayList<Song> boppinList = new ArrayList<Song>();
	boppinList.add(loveDrug);
	boppinList.add(snakeHouse);
	boppinList.add(worth);
	boppinList.add(ugh);
	boppinList.add(blackCoffee);
	Playlist beep = new Playlist("da good stuff",boppinList);
	User goblin = new User("Goblin", "Password1234");
	goblin.addPlaylist(beep);
	graveLord.addUser(goblin);
	assertEquals(goblin,graveLord.login("Goblin", "Password1234"));
	}
	/* This test is to simulate a a nonexisting user login attempt.
	 * The expected outcome is null
	 */
	@Test
	void userCollection_test5() {
	// songs are initialized as individuals for more explicit test cases
	UserCollection graveLord= new UserCollection();
	Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
	Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
	Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
	Song worth = new Song("Worth", "Kill Bill: The Rapper");
	Song ugh = new Song("UGH","KawaiiSprite");
	ArrayList<Song> boppinList = new ArrayList<Song>();
	boppinList.add(loveDrug);
	boppinList.add(snakeHouse);
	boppinList.add(worth);
	boppinList.add(ugh);
	boppinList.add(blackCoffee);
	Playlist beep = new Playlist("da good stuff",boppinList);
	User goblin = new User("Goblin", "Password1234");
	goblin.addPlaylist(beep);
	graveLord.addUser(goblin);
	assertEquals(null,graveLord.login("Gooblin", "Password1234"));
	}
	/* This test is to simulate a a nonexisting user login attempt.
	 * The expected outcome is null
	 */
	@Test
	void userCollection_test6() {
	// songs are initialized as individuals for more explicit test cases
	UserCollection graveLord= new UserCollection();
	Song blackCoffee = new Song("Black Coffee", "Kill Bill: The Rapper");
	Song snakeHouse = new Song("Snake House", "Kill Bill: The Rapper");
	Song loveDrug  = new Song("Love Drug", "Kill Bill: The Rapper");
	Song worth = new Song("Worth", "Kill Bill: The Rapper");
	Song ugh = new Song("UGH","KawaiiSprite");
	ArrayList<Song> boppinList = new ArrayList<Song>();
	boppinList.add(loveDrug);
	boppinList.add(snakeHouse);
	boppinList.add(worth);
	boppinList.add(ugh);
	boppinList.add(blackCoffee);
	Playlist beep = new Playlist("da good stuff",boppinList);
	User goblin = new User("Goblin", "Password1234");
	User egor = new User("Egor","Password12345");
	goblin.addPlaylist(beep);
	egor.addPlaylist(beep);
	Playlist bop = new Playlist("Cherry bomb");
	egor.addPlaylist(bop);
	graveLord.addUser(goblin);
	graveLord.addUser(egor);
	System.out.println("------------user collection------------");
	System.out.println(graveLord);
	System.out.println("---------------------------------------");
	}
}
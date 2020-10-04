/***************************************************************************************************************************************************************************************************************************/
/***************************************************************************************************************************************************************************************************************************/
//Author: Yazid Aram Escudero Arroyo
//CourseInformation: Lab CS1101 - corresponds with Lecture CS1301
//Semester Information and Date: Fall 2020, source code started on the 1st of October, 2020
//Instructor: Dr. Daniel Mejia
//The TAs and IAs:
	//TA Alireza P. Nouri
	//IA Paola Terrazas
	//IA Cynthia Sustaita
//Description:
	/*This program is Comprehensive Lab 1 of the semester, which is due on the 9th of October 2020 on UTEP's BlackBoard. This program executes a Spotify user interface that allows the user to "have an account" with
	  Spotify. This program will have a menu that pops up until the user chooses to quit. The user must first log in by inputting their username and the password "Password". After logging in, the menu prints and the user
	  has three options: 1) View their current plan, 2) Change their plan and 3) Exit the program.
	  
	  This program makes use of loops and if statements to accomplish the description found in the "Spotify Premium Plan_DM" PDF file found in the following directory:
	  C:\Users\escud\STORAGE\UTEP\Fall 2020\Intro to Computer Science Lab\Comprehensive Lab 1\Comprehensive Lab 1 Document Description
	  This program also has a "database" in the form of a text file with simple information that contains the user's account type and the username in a single line in the following directory:
	  C:\Users\escud\STORAGE\UTEP\Fall 2020\Intro to Computer Science Lab\Comprehensive Lab 1
	  This program's pseudocode can be found in the following directory:
	  C:\Users\escud\STORAGE\UTEP\Fall 2020\Intro to Computer Science Lab\Comprehensive Lab 1
	  
	  //The work log will have the following format for any time Yazid Aram Escudero enters the source code to complete/edit the source code:
	  //Month:IntegerDay:IntegerYear at XX:XX(here goes either AM/PM) - "description goes here"
	  
//Work Log:


	/*
	*October:01:2020 at 12:43AM - Created Scanner objects to read from file and console, created main program varaibles, and implemented the exception handling in the case that the spotify text database is not found.
								  If the databse is not found, then it will throw exception at the user and exit the program. The mechanism (in this case a while loop) that verifies the user's username and password
								  has been implemented.
								  Following the verification mechanism are an if statement (if user is verified) and else statement(if user is not verified). After the verification process, the ENTIRE remainder of the 
								  program will depend on which branch executes (1 of 2 possible outcomes). Program was compiled, in attempt to follow good practice of modular development.
								  The scanner "inFile" that reads from databaseFile is "reset" to the "beggining of the text document" every single iteration of the verification loop, since I did not find a direct way
								  send "inFile" to the beggining of the text file, other than simply recreating the scanner object again and again for every iteration
								  
								  Goals for next coding session:
								  **Add the basic functionality inside the if statement after the verification while loop mechanism. This is the same if statement that exectues ONLY if the userVerified == true
								  **Create the while loop inside the if statement mentioned in the previous line, which will serve as the "menu engine" that keeps iterating until user chooses to quit by pressing 3 and enter. 
								  **Create PrintMenu() method that returns void and simply prints out the options that the user can choose from, including the option to quit
								  
								  Program compilation towards end: Yes, unsuccessful, but after several bug and logic fixes, compilation was successful.
								  
								  Session terminated at October:01:2020 at 02:25AM
								  
	*October:01:2020 at 09:42PM - Created the "menu engine" which is a while loop that prints the menu and lets user choose an option over and over again until the user chooses to quit (hence, the name "menu engine". A feature to detect incorrect
								  menu options has been implemented, which returns an error to user if they do not enter a choice that is in the menu. This is done by using a boolean varaible "userChoiceValid" The program has the ability for the user
								  to choose when the "menu engine" quits after each iteration. The menu option 3, which is to quit the program, is fully intact and will function at the end of this session. The other options, option 1 and 2, are not 
								  yet developed and will simply print statements that state that the correct branch has executed successfully to verify that the basic functionality to determine which branch to take according to the user's input is 
								  there. An integer variable "meuChoice" has been added that stores the user's menu choice, and boolean variable "userQuits" has been added, and will be set to true if the 3rd menu option is taken. This boolean value 
								  will ensure that the loop's condition evaluates to false and the "menu engine" is exited.
								  Added two methods: "printNewLine() simply prints a newline character when called, and printMenu() simply prints out a formatted menu when called at the beggining of the "menu engine"
								  
								  Goals for next coding session:
								  **Add full functinality to the if branch that corresponds to the "view plan" menu option. By the end of next session, this if branch that executes if user makes menuChoice == 1 should be fully functioning.
								  
								  Program compilation towards end: Yes, unsuccessful, but after few bug and logic fixes, compilation was successful.
								  
								  Session terminated on October:01:2020 at 11:29PM
								  
	*October:03:2020 at 08:28PM - Added system output that prints out "Welcome, [username]" when login attempt(s) are successful. This occures in the branch inside the verification while loop, when the if statement checks if the entered userName is
								  matched exactly with a username in the spotify text database.
								  MAJOR: Once user is verified, and when the "menu engine" menu while loop executes, the menu choice "1. View Plan" along with the corresponding if branch that iterates is 100% functioning and fully completed.
								  The "View Plan" if branch has switch() statement that compares accountType variable with 'I', 'S', 'F', and executes the case that matches. I is for Individual, S is for Student, and F is for Family. Each case in the
								  switch statement prints out the information and monthly/yearly cost of its corresponding plan. The costs, when printed, use the method System.out.printf() in order to modify the floating point value to two decimal places.
								  It should also be noted that the monthly and yearly costs printed to screen already have the 8.025 tax included in the cost, as requested in the Spotify documentation.
								  Afterwards,in each case, the user is asked how much they want to pay for that month. if the user's value is "equal" (checks for "close enough") or "greater than" the monthly cost determined for that plan, then the user is given
								  a confirmation message saying the account will remain active. If the user does NOT input a value "equal" to or "greater than" the monthly cost determined for the plan, the user is told that their subscription will be put on
								  hold. 
								  New methods created. Three methods 1)printIndividualPlan 2)printFamilyPlan and 3)printStudentPlan are created to contain all the text information about their corresponding plans identified in the names of the methods.
								  This way, each case of the switch statement calls the corresponding method. Ex: case 'I' (individual) will call the printIndividualPlan() method to print out all the information corresponding to the individual plan.
								  Compiler gave a warning that, and I paraphrase, "variable accountType may have not been initialized". The logic in this program works out perfectly so that the variable is only used IF the verification step of the program
								  is successful. So there is NO chance that that accountType variable will be used even if the userVerification does NOT permit the rest of the program to continue. However, to solve the error message, I initialized
								  accountType = '\0' to a null character. This should have no consequences on the logic/execution of the program.
								  Fixed a few mispelling mistakes, added small and almost irrelevant output statements that are present in the Spotify documentation. Fixed spacing issues, and output formatting issues.
								  
								  Goals for next coding session:
								  **Add full functionality to the if-elseif-else branch that corresponds to "change plan" menu option. By the end of the next session, this branch that executes if user makes menuChoice == 2 should be fully functioning.
								  
								  Program compilation towards end: Yes, unsuccessful, but after fixing "variable may not be initialized" errors and basic logic errors, compilation was successful.
								  
								  Session terminated on October:03:2020 at 11:31PM
								  
	*/
//End of Work Log

//FIXMEs LOG:
	
//End of FIXMEs LOG
/***************************************************************************************************************************************************************************************************************************/
/***************************************************************************************************************************************************************************************************************************/


import java.util.Scanner;
import java.io.File;


public class CL_Main {
	
	
	//this method just moves the cursor to the next line
	//by printing a newline
	public static void printNewLine() {
		System.out.println();
	}
	
	//prints out the details and information about the Individual Premium Spotify Plan
	public static void printIndividualPlan() {
		System.out.println("Premium Individual Plan. You have access to 6 premium accounts, a playlist for your family, ad-free music, ");
		System.out.println("listen offline, on-demand playback, and the control to block explicit music!");
		printNewLine();
	}
	
	public static void printFamilyPlan() {
		System.out.println("Premium Family Plan. You have access to ad-supported Hulu, SHOWTIME, you can listen to music ad-free offline, ");
		System.out.println("and access to on-demand playback!");
		printNewLine();
	}
	
	public static void printStudentPlan() {
		System.out.println("Premium Student Plan. You have access to ad-free music, the ability to play anywhere (even offline), and access ");
		System.out.println("to on-demand playback!");
		printNewLine();
	}
	

	
	//this method prints out the menu inside main method's "menu engine" or simply put, menu while loop
	public static void printMenu() {
		
		printNewLine();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Main Menu:");
		System.out.println("\t1 - View Current Plan");
		System.out.println("\t2 - Change Plans");
		System.out.println("\t3 - Exit Program");
		printNewLine();
	
	}
	
	public static void main(String[] args) {
		
		try{
			//create the file object to use in Scanner "inFile" object
			File databaseFile = new File("C:/Users/escud/STORAGE/UTEP/Fall 2020/Intro to Computer Science Lab/Comprehensive Lab 1/spotifydatabase.txt");
			
			//create Scanner object to read from  the user input in console
			Scanner inUser = new Scanner(System.in);
			
			//create main program variables
			int loginAttempts = 0;				//keeps track of user attempts to log in
			int menuChoice;						//contains menu option corresponding integer tha user chooses. 1 - View Plan and 2 - Change Plans and 3 - Exit Program
			String userName;					//stores the user name from the user of the program
			String userPassword;				//stores the password entered by the program user
			String userPrompt = ">> ";			//simply acts as an indicator where user types in input
			String systemUserName;				//temporarily stores the user name being compared to what the user entered as his/her username before moving to next username in the database
			char accountType = '\0';					//stores the letter indicating the plan of the user found in the database
			boolean userVerified = false;		//stores true if sign in is successful, false if sign in was not successful. initially, we assume false!
			boolean userQuits = false;			//this variable will change to true inside the menu engine (while loop) when the user chooses to exit the program and quit
			
			
			//now we verify if the user exists in the Spotify database
			//we do this with a while loop that will permit three sign in attempts
			//loop coondition is true, ensuring the loop will run. we will use the break statement to exit when it is appropiate
			while (true) {
				
				//grab user's username and password
				System.out.print("Please enter your username\n" + userPrompt);
				userName = inUser.nextLine();
				printNewLine();
				System.out.print("Please enter your password\n" + userPrompt);
				userPassword = inUser.nextLine();
				printNewLine();
				
				//every time outer loop runs we recreate the Scanner because APPARENTLY the scanner cannot be reset.
				//Yazid is shaking his head very hard after long internet browsing
				Scanner inFile = new Scanner(databaseFile);
				
				//use a while loop to iterate through the usernames stored in databaseFile
				while (inFile.hasNextLine()) {
					//grab the next line of text in the file. then extract the first letter
					//that indicates the account type
					systemUserName = inFile.nextLine();
					accountType = systemUserName.charAt(0);
					//now get rid of the first letter indicator in systemUserName to have the pure user name for comparison
					systemUserName = systemUserName.substring(1, systemUserName.length());
					
					//now compare the user's userName and the systemUsername
					
					//if the userName entered matched with databaseFile username...
					if ((systemUserName.compareTo(userName) == 0) && (userPassword.compareTo("Password") == 0)) {
						//print out the welcome statement first since verification was successful!
						System.out.println("Welcome, " + userName + "!");
						userVerified = true;
						break;
					}
					//if not found then while loop will keep checking the databseFile
				}
				
				//if user was verified...
				if (userVerified) {
					break;
				}
				else {
					//increse loginAttempts by 1
					loginAttempts += 1;
					
					//IMPORTANT: IF USER REACHED THREE TRIES THEN EXIT THE PROGRAM BY EXITING THE WHILE LOOP
					if (loginAttempts == 3) {
						break;
					}
					//if the user has NOT reached the three times limit...
					else {
						System.out.println("You entered the wrong username or password. Please try again. Number of Attempts: " + loginAttempts + " out of 3 Attempts");
					}
				}
			}
			
			//after verification passed or failed, entire program is held inside the following if (if user was verified) and else (if user was not verified)...
			
			//if the user was verified...
			if (userVerified) {
				
				//if userVerified == true, then we can confidently assume that the String variable "userName" matched exactly with the
				//database stored user name. therefore, it is completely valid to use it when giving feedback to user
				
				//initiate while loop "menu engine" to iterate over and over again until the user chooses to quit
				//MENU ENGINE
				while (!userQuits) {
					printMenu();
					System.out.print("Please type in corresponding number and press ENTER\n" + userPrompt);
					menuChoice = inUser.nextInt();
					printNewLine();
					
					
					boolean userChoiceValid = (menuChoice == 1) || (menuChoice == 2) || (menuChoice == 3);
					
					//if the user entered a valid choice...
					if (userChoiceValid) {
						//this is the part of the program that handles the user's menu selection
						
						//if user wants to view current plan...
						if (menuChoice == 1) {
							//add functionality to choice to view plan
							//System.out.println("FIXME: I am the \"view plan\" branch!");
							//this line prints regardless of whatever plan the user has. Next, we define the if-elseif-else branches for the 
							//different plans, each with their own unique output statements depending on premium plan details
							System.out.print(userName + ", you currently have access to the ");
							
							//determine the plan using switch statement and char variable accountType
							switch (accountType) {
								case 'I':
									//declare Premimum Indivicual variables to hold monthly and yearly cost, tax included into calculation
									double monthlyIndividualCost = 9.99 * 1.0825;
									double yearlyIndividualCost = monthlyIndividualCost * 12;
									//declare variable that will hold the amount that the user chooses to pay. Will be used to compare
									double userIndividualAmount;
									
									//output Indivicual Plan Details...
									printIndividualPlan();
									System.out.println("Your Premium for Individual Receipt:");
									System.out.printf("Monthly Cost: %.2f\nYearly Cost: %.2f\n", monthlyIndividualCost, yearlyIndividualCost);
									printNewLine();
									
									//ask user for how much he will pay for the month
									System.out.print("How much would you like to spend on music this month?\n" + userPrompt);
									userIndividualAmount = inUser.nextDouble();
									printNewLine();
									
									//compare input with stored monthlyIndividualCost, and output corresponding message to user
									//CALL MATH CLASS TO USE abs METHOD 
									if ( (Math.abs((userIndividualAmount - monthlyIndividualCost)) < 0.0001) || (userIndividualAmount > monthlyIndividualCost) ) {
										System.out.println("Awesome! You can jam this month! Enjoy!");
									}
									else {
										System.out.println("Hm... seems like we will have to put your subscription on hold.");
									}
									break;
								case 'F':
									//declare Premium Family variables to hold monthly and yearly cost, tax included into calculation
									double monthlyFamilyCost = 14.99 * 1.0825;
									double yearlyFamilyCost = monthlyFamilyCost;
									//declare varaible that will hold the amount that the user chooses to pay. Will be used to compare
									double userFamilyAmount;
									
									//output Family Plan Details...
									printFamilyPlan();
									System.out.println("Your Premium for Family Receipt:");
									System.out.printf("Monthly Cost: %.2f\nYearly Cost: %.2f\n", monthlyFamilyCost, yearlyFamilyCost);
									printNewLine();
									
									//ask user for how much he will pay for the month
									System.out.print("How much would you like to spend on music this month?\n" + userPrompt);
									userFamilyAmount = inUser.nextDouble();
									printNewLine();
									
									//compare input with stored monthlyFamilyCost, and output corresponding message to user
									//CALL MATH CLASS TO USE abs METHOD
									if ( (Math.abs((userFamilyAmount - monthlyFamilyCost)) < 0.0001) || (userFamilyAmount > monthlyFamilyCost) ) {
										System.out.println("Awesome! You can jam this month! Enjoy!");
									}
									else {
										System.out.println("Hm... seems like we will have to put your subscription on hold.");
									}
									break;
								case 'S':
									//declare Premium Student variables to hold monthly and yearly cost, tax included into calculation
									double monthlyStudentCost = 4.99 * 1.0825;
									double yearlyStudentCost = monthlyStudentCost;
									//declare varaible that will hold the amount that the user chooses to pay. Will be used to compare
									double userStudentAmount;
									
									//output Student Plan Details...
									printStudentPlan();
									System.out.println("Your Premium for Student Receipt:");
									System.out.printf("Monthly Cost: %.2f\nYearly Cost: %.2f\n", monthlyStudentCost, yearlyStudentCost);
									printNewLine();
									
									//ask user for how much he will pay for the month
									System.out.print("How much would you like to spend on music this month?\n" + userPrompt);
									userStudentAmount = inUser.nextDouble();
									printNewLine();
									
									//compare input with stored monthlyStudentCost, and output corresponding message to user
									//CALL MATH CLASS TO USE abs METHOD
									if ( (Math.abs((userStudentAmount - monthlyStudentCost)) < 0.0001) || (userStudentAmount > monthlyStudentCost) ) {
										System.out.println("Awesome! You can jam this month! Enjoy!");
									}
									else {
										System.out.println("Hm... seems like we will have to put your subscription on hold.");
									}
									break;
								default:
									System.out.println("Error: Undetected database corruption error. This line should never print unless there is database storing system error");
									printNewLine();
									break;
							}
						}
						//if the user wants to change plans...
						else if (menuChoice == 2) {
							//add functionality to choice to change plan
							System.out.println("FIXME: I am the \"change plan\" branch!");
						}
						//if the user wants to quit...
						else if (menuChoice == 3) {
							//set userQuits to true so the loop condition will evaluate to false and exit the loop
							userQuits = true;
							System.out.println("Exiting Program. Come back again!");
						}
					}
					//if the user did not enter a valid choice
					else {
						System.out.println("Invalid choice. Please try again.");
					}
					
				}
			}
			//if the user was not verified in the loop...
			else {
				System.out.println("System unable to verify user. Three out of three attempts used. Terminating program....");
			}
			
		}catch(Exception e) {
			System.out.println("An error ocurred while reading the file");
		}
	}
}
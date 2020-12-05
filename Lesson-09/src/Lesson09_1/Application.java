/*
 * Java_Core. Lesson 09.
 */

package Lesson09_1;

import java.util.Scanner;

import Lesson09_2.MyException;

/**
 * 
 * @author VikinG
 * @since java 1.8
 * @version 05.12.20
 *
 */
public class Application {
	
	/* пори року далі [] masS */
	enum Seasons {
		Winter, Spring, Summer, Fall;

	}
	
	
	/* міясці  далі [] masM */
	enum Months {
		Junuary(Seasons.Winter, 31), February(Seasons.Winter, 28), March(Seasons.Spring, 31), April(Seasons.Spring, 30),
		May(Seasons.Spring, 31), June(Seasons.Summer, 30), July(Seasons.Summer, 31), August(Seasons.Summer, 31),
		September(Seasons.Fall, 30), October(Seasons.Fall, 31), November(Seasons.Fall, 30),
		Desember(Seasons.Winter, 31);

		Seasons seasons;
		int days;

		private Months(Seasons seasons, int days) {
			this.seasons = seasons;
			this.days = days;

		}

		public Seasons getSeasons() {
			return seasons;
		}

		public void setSeasons(Seasons seasons) {
			this.seasons = seasons;
		}

		public int getDays() {
			return days;
		}

		public void setDays(int days) {
			this.days = days;
		}

	}
	
	/* Консоль меню */
	static void menu() {
		System.out.println("Натисніть 1, щоб перевірити чи такий місяць існує");
		System.out.println("Натисніть 2, щоб Вивести всі місяці з такою ж порою року");
		System.out.println("Натисніть 3, щоб Вивести всі місяці які мають таку саму кількість днів");
		System.out.println("Натисніть 4, щоб Вивести місяць з найменьшою кількістю днів");
		System.out.println("Натисніть 5, щоб Вивести місяць з найбільшою кількістю днів");
		System.out.println("Натисніть 6, щоб Вивести наступну пору року");
		System.out.println("Натисніть 7, щоб Вивести попередню пору року");
		System.out.println("Натисніть 8, щоб Вивести місяці в яких парна кількість днів");
		System.out.println("Натисніть 9, щоб Вивести місяці в яких непарна кількість днів");
		System.out.println("Натисніть 0, щоб перевірити чи в місяці парна кількість днів");

	}

	public static void main(String[] args) throws WrongInputConsoleParametersException {
		Months[] masM = Months.values();
		Seasons[] masS = Seasons.values();
		Scanner sc = new Scanner(System.in);

		/* сканер для метода меню */
		while (true) {
			menu();
			

 			switch (sc.next()) {
			case "1": {
				System.out.println("Введіть місяць");

				sc = new Scanner(System.in);
				String Months = sc.next().toUpperCase();

				boolean flag = false;

				for (Months m : masM) {
					if (m.name().equalsIgnoreCase(Months)) {
						System.out.println("Є такий місяць");
						flag = true;
					}

				}
				if (!flag) {
					String message = "Такого місяця немає!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}
			case "2": {
				System.out.println("Введіть пору року");

				sc = new Scanner(System.in);
				String seasons = sc.next().toUpperCase();

				boolean flag1 = false;

				for (Months m : masM) {
					if (m.getSeasons().name().equalsIgnoreCase(seasons)) {
						System.out.println("Місяці цієї пори року: " + m);
						flag1 = true;
					}

				}
				if (!flag1) {
					
					String message = "Такогї пори року не існує!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}
			case "3": {
				System.out.println("Введіть кількість днів (28, 30 чи 31)");

				sc = new Scanner(System.in);
				int mont = sc.nextInt();

				boolean flag2 = false;

				for (Months m : masM) {
					if (m.getDays() == mont) {
						System.out.println("Місяць з такою кількістю днів: " + m);
						flag2 = true;
					}

				}
				if (!flag2) {
					String message = "Такого місяця немає!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}
			case "4": {

				sc = new Scanner(System.in);
				

				for (Months m : masM) {
					if (m.getDays() < 30) {


						System.out.println("Місяць найменьшою кількістю днів: " + m);

					}

				}

				break;
			}
			case "5": {

				sc = new Scanner(System.in);
			

				for (Months m : masM) {
					if (m.getDays() > 30) {
						

						System.out.println("Місяць найменьшою кількістю днів: " + m);

					}

				}

				break;
			}
			case "6": {
				System.out.println("Введість пору року : ");
				sc = new Scanner(System.in);
				String nextSeason = sc.next().toUpperCase();

				boolean flag = false;

				for (Seasons s : masS) {
					if (s.name().equalsIgnoreCase(nextSeason)) {

						flag = true;
					}
				}
				if (flag) {
					Seasons season2 = Seasons.valueOf(nextSeason);
					int i = season2.ordinal();

					if (i == masS.length - 1) {
						i = 0;
						System.out.println(masS[i]);
					} else {
						System.out.println(masS[i + 1]);
					}
				}

				if (!flag) {
					String message = "Такогї пори року не існує!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;

			}
			case "7": {
				System.out.println("Введість пору року : ");
				sc = new Scanner(System.in);
				String LSeason = sc.next().toUpperCase();

				boolean flag = false;

				for (Seasons s : masS) {
					if (s.name().equalsIgnoreCase(LSeason)) {

						flag = true;
					}
				}
				if (flag) {
					Seasons season2 = Seasons.valueOf(LSeason);
					int i = season2.ordinal();

					if (i == masS.length - 1) {
						i = 0;
						System.out.println(masS[i]);
					} else {
						System.out.println(masS[i - 1]);
					}
				}

				if (!flag) {
					String message = "Такогї пори року не існує!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;

			}

			case "8": {

				for (Months m : masM) {
					if (m.getDays() % 2 == 0) {
						System.out.println("Місяці з парною кількістю днів: " + m);

					}

				}

				break;
			}
			case "9": {

				for (Months m : masM) {
					if (m.getDays() % 2 != 0) {
						System.out.println("Місяці з непарною кількістю днів: " + m);

					}

				}

				break;
			}
			case "0": {

				System.out.println("Введіть назву місяця: ");
				sc = new Scanner(System.in);
				String season0 = sc.next().toUpperCase();

				boolean flag = false;

				for (Months m : masM) {
					if (m.name().equalsIgnoreCase(season0)) {
						if (m.getDays() % 2 == 0) {
							System.out.println("Місяць має парну кількість днів : " + m);
							flag = true;
						} else {
							System.out.println("Місяць має непарну кількість днів : " + m);
						}
					}
				}
				if (!flag) {
					String message = "Такого місяця немає!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;

			}

			}

		}

	}
}
import java.awt.desktop.SystemEventListener;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();


        User admin = new User("admin", "111", 1);
        users.add(admin);
        User user1 = new User("user1", "000", 0);
        users.add(user1);

        Cinema cinema1 = new Cinema(0, "cinema1"); // создаем кинотеатр
        cinema1.initHall(0, 2, 2); // добавляем в кинотеатр залы
        cinema1.initHall(1, 2, 2);
        cinema1.initHall(2, 3, 3);

        cinema1.addSession(0, 0, "Serpico", 100, // создаем сеансы кино
                17, 3, 2025, 15, 30, 130);
        cinema1.addSession(2, 1, "Serpico", 110,
                18, 3, 2025, 14, 30, 130);
        cinema1.addSession(0, 2, "Shrek 2", 1000,
                15, 3, 2025, 22, 30, 100);
        cinema1.addSession(1, 3, "Shrek 2", 1500,
                11, 3, 2025, 23, 30, 100);


        System.out.println("Введите логин:");
        Scanner in = new Scanner(System.in);
        String log = in.next();
        System.out.println("Введите пароль:");
        String pas = in.next();
        User temp=new User("def_login","def_pas",1);


        for (User i : users) { //авторизация
            if (log.equals(i.getlogin()) && pas.equals(i.getPassword())) {
                System.out.println("Успешная авторизация!");
                temp = i;
                break;
            }
            else if(log.equals(i.getlogin()) && pas!=i.getPassword())
            {System.out.println("Неправильный пароль");
            System.exit(1);}
        }
        if (temp.status == 1) { //работа с админом
            System.out.println("Добро пожаловать Мистер Админ! Чтобы добавить новый сеанс, введите new.\n" +
                    " Чтобы посмотреть текущие сеансы, введите current.\n Чтобы удалить сеанс, введите remove.\n" +
                    " Чтобы выйти, введите exit.");
            //Scanner in = new Scanner(System.in);
            String cha = in.next();
            String chaaa=cha;

            while (true) {
                if(chaaa.equals("exit")||chaaa.equals("remove")||chaaa.equals("current")||chaaa.equals("new") )
                {switch(chaaa) {
                    case "exit": {
                        System.exit(0);
                        break;
                    }
                    case "current": {
                        cinema1.displayAllSessions();
                        System.out.println("Выберите номер из списка, чтобы узнать наличие свободных мест (1 значит занято)");
                        int numm = in.nextInt();
                        if (cinema1.displayAllSessionSeats(numm)==1000)
                        {System.exit(1);};
                        System.out.println("Чтобы добавить новый сеанс, введите new.\n" +
                                " Чтобы посмотреть текущие сеансы, введите current.\n Чтобы удалить сеанс, введите remove.\n" +
                                " Чтобы выйти, введите exit.");
                        chaaa = in.next();
                        break;

                    } case "new": {
                        System.out.println("Введите параметры в формате {ID_зала ID_сеанса " +
                                "цена_билета\n номер_дня_в_месяце номер_месяца год час_начала минута_начала " +
                                "длительность_в_минутах название_фильма} и нажмите Enter");
                        Scanner input = new Scanner(System.in);
                        int x1 = input.nextInt();//id зала
                        int x2 = input.nextInt();//id сеанса

                        int x4 = input.nextInt();//цена
                        int x5 = input.nextInt();//день
                        int x6 = input.nextInt();//месяц
                        int x7 = input.nextInt();//год
                        int x8 = input.nextInt();//час
                        int x9 = input.nextInt();//минута
                        int x10 = input.nextInt();//длительность
                        String x3 = input.nextLine();
                        cinema1.addSession(x1, x2, x3, x4,
                                x5, x6, x7, x8, x9, x10);
                        System.out.println("Сессия успешно добавлена!");

                        cinema1.displayAllSessions();

                        System.out.println("Чтобы добавить новый сеанс, введите new.\n" +
                                " Чтобы посмотреть текущие сеансы, введите current.\n Чтобы удалить сеанс, введите remove.\n" +
                                " Чтобы выйти, введите exit.");
                        chaaa = in.next();
                        break;

                    } case "remove": {
                        cinema1.displayAllSessions();
                        System.out.println("Введите id сеанса и нажмите Enter");
                        Scanner input = new Scanner(System.in);
                        int rem_id = input.nextInt();//id зала
                        cinema1.removeSession(rem_id);
                        System.out.println("Сессия успешно удалена!");
                        cinema1.displayAllSessions();

                        System.out.println("Чтобы добавить новый сеанс, введите new.\n" +
                                " Чтобы посмотреть текущие сеансы, введите current.\n Чтобы удалить сеанс, введите remove.\n" +
                                " Чтобы выйти, введите exit.");
                        chaaa = in.next();
                        break;
                    }

                }}
                else{System.out.println("Неправильная команда");

                    System.out.println("Чтобы добавить новый сеанс, введите new.\n" +
                            " Чтобы посмотреть текущие сеансы, введите current.\n Чтобы удалить сеанс, введите remove.\n" +
                            " Чтобы выйти, введите exit.");
                    chaaa = in.next();
                    break;}
            }

        } else {//работа с обычным пользователем
            System.out.printf("Добро пожаловать пользователь %s!\n",temp.getlogin());
            System.out.println("Какой фильм вас интересует?");

            String cha2 = in.next();
            cinema1.displaySessions(cha2);
            System.out.println("Выберите номер сеанса, чтобы узнать наличие свободных мест (1 значит занято)");
            int numm = in.nextInt();
            int current_id=cinema1.displaySessionSeats(numm, cha2);

            System.out.println("Введите номер ряда и номер кресла в формате {номер_ряда номер_кресла}");
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            cinema1.takeSeat(current_id, num1, num2);
            System.out.println("Билет забронирован!");
        }

    }}

 class User { //класс для пользователя
    private String login;
    private String password;

    public int status;

    public User(String arg_login, String arg_password, int status){
        this.login = arg_login;
        this.password=arg_password;
        this.status=status;
    }

    String getlogin(){
        return this.login;
    }

    String getPassword(){
        return this.password;
    }

}


class Session{ //класс для сеанса кино
    private int session_id;
    int[] date = {0,0,0};
    String film;
    int[] starting_time={0,0};
    int duration;
    int price;
    int[][] seats;

    int rows_of_seats;
    int chairs_in_row;

    private Session(){}
    public Session(int arg_id, String arg_film, int arg_price, int[][] seats_array){
        this.session_id=arg_id;
        this.film=arg_film;
        this.price=arg_price;
        this.seats=seats_array;
    }

    public Session(Session ses){
        this.session_id=ses.session_id;
        this.film=ses.film;
        this.price=ses.price;
        this.seats=ses.seats;
        this.starting_time= ses.starting_time;
        this.chairs_in_row=ses.chairs_in_row;
        this.rows_of_seats=ses.rows_of_seats;
        this.date=ses.date;
        this.duration=ses.duration;
    }

    void setDate(int day, int month, int year){
        this.date[0]=day;
        this.date[1]=month;
        this.date[2]=year;
    }

    void setStarting_time(int hour, int minutes){
        this.starting_time[0]=hour;
        this.starting_time[1]=minutes;
    }

    void setDuration(int length_of_film){
        this.duration=length_of_film;
    }

    int getID(){
        return this.session_id;
    }

    void manageSeats(int row_number, int seat_number){
        this.seats[row_number][seat_number]=1; //место занято
    }

    void displaySeats(){
        for(int i=0; i<rows_of_seats; i++)
        {
            for(int j=0; j<chairs_in_row; j++)
            {
                System.out.print(" "+this.seats[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    void initSeats(){
        for(int i=0; i<this.rows_of_seats; i++)
        {
            for(int j=0; j<this.chairs_in_row; j++)
            {
                this.seats[i][j]=0;
            }
        }
    }
    void displayInfo(){
        System.out.printf("Film: %s, Date: %d.%d.%d, Time: %d:%d, Duration:%d, \n Price:%d \n", this.film,
                this.date[0], this.date[1], this.date[2], this.starting_time[0], this.starting_time[1],
                this.duration, this.price);
    }
}

class Hall{ //класс для зала в кинотеатре
    int hall_id;
    ArrayList<Session> sessions;
    int[][] seats;
    int rows_of_seats;
    int chairs_in_row;

    private Hall(){}
    public Hall(int arg_id, int arg_rows, int arg_chairs_in_row){
        this.hall_id=arg_id;
        this.rows_of_seats=arg_rows;
        this.chairs_in_row=arg_chairs_in_row;
        this.seats=new int[rows_of_seats][chairs_in_row];
        this.sessions=new ArrayList<Session>();

    }

    int getHallID(){
        return this.hall_id;
    }

    void changeArrayOfSeats(int rows, int seats){
        this.rows_of_seats=rows;
        this.chairs_in_row=seats;
        this.seats=new int[rows_of_seats][chairs_in_row];
    }

    void addSession(int id, String film, int price, int day, int month, int year, int hour, int minutes,
                    int duration)
    {
        Session sesh = new Session(id, film, price, this.seats);
        sesh.setDate(day, month, year);
        sesh.setStarting_time(hour, minutes);
        sesh.setDuration(duration);
        sesh.rows_of_seats=this.rows_of_seats;
        sesh.chairs_in_row=this.chairs_in_row;
        sesh.initSeats();
        this.sessions.add(sesh);

    }
}

class Cinema{ //кинотеатровое
    int cinema_id;
    String name;
    ArrayList<Hall> halls;

    public Cinema(int arg_id, String arg_name){
        this.cinema_id=arg_id;
        this.name=arg_name;
        this.halls = new ArrayList<Hall>();

    }

    void removeSession(int id){
        for(Hall i:halls)
        {
            for(Session j: i.sessions)
            {
                if (j.getID()==id)
                {
                    i.sessions.remove(j);
                }
            }
        }

    }

    void lookatSessions(String filmname_arg){
        boolean flag=false;
        for(Hall i:halls)
        {
            for(Session j: i.sessions)
            {
                if (filmname_arg==j.film)
                {
                   flag=true;
                   break;
                }
            }
        }
        if(flag==false)
        {
            System.out.println("Такого фильма нет!");
        }

    }

    void initHall(int id, int rows, int chairs_in_row)
    {
        this.halls.add(new Hall(id, rows, chairs_in_row)); //создаём новый зал в кинотеатре
    }

    void takeSeat(int id, int row, int chair)
    {
        for(Hall i:halls)
        {
            for(Session j: i.sessions)
            {
                if (j.getID()==id)
                {
                    j.manageSeats(row, chair);
                }
            }
        }
    }

    void addSession(int hall_id, int session_id, String film_name, int price,
                    int day, int month, int year,
                    int hour, int minutes, int length)
    {
        this.halls.get(hall_id).addSession(session_id,film_name,price,
                day, month, year, hour, minutes, length);
    }

    void displaySessions(String filmname)
    {
        int k=0;
        int id_needed=1000;

        for(Hall i: halls)
        {
            for(Session j: i.sessions)
            {
                if(j.film.equals(filmname))
                {
                    k+=1;
                    System.out.printf("%d.", k);
                    System.out.printf(" Кинотеатр: %s,", this.name);
                    System.out.printf(" ID зала: %d\n",i.getHallID());
                    j.displayInfo();
                }
            }
        }
    }

    void displayAllSessions()
    {
        int k=0;
        int id_needed=1000;
        for(Hall i: halls)
        {
            for(Session j: i.sessions)
            {
                    k+=1;
                    System.out.printf("%d.", k);
                    System.out.printf(" Кинотеатр: %s,", this.name);
                    System.out.printf(" ID зала: %d\n ",i.getHallID());
                    System.out.printf(" ID сессии: %d\n ",j.getID());
                    j.displayInfo();
            }
        }
    }

    int displaySessionSeats(int num, String filmname){
        int kk=0;
        Session helper;
        for(Hall i: halls)
        {
            for(Session j: i.sessions)
            {
                if(j.film.equals(filmname))
                {
                    kk+=1;
                    if(kk==num)
                    {
                        helper = j;
                        helper.manageSeats(1,1);
                        helper.displaySeats();
                        return j.getID();
                    }

                }
            }
        }
        System.out.println("Такой номер не найден.");
       return 1000;
    }

int displayAllSessionSeats(int num){
    int kk=0;
    Session helper;
    for(Hall i: halls)
    {
        for(Session j: i.sessions)
        {
                kk+=1;
                if(kk==num)
                {
                    helper = j;
                    helper.manageSeats(1,1);
                    helper.displaySeats();
                    return j.getID();
                }
        }
    }
    System.out.println("Такой номер не найден.");
   return 1000;
}
}

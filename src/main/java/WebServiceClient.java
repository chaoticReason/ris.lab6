// нужно, чтобы получить wsdl описание и через него
// дотянуться до самого веб-сервиса

import service.MyWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");

        QName qname = new QName("http://service/", "WebServiceImplService");
        QName qport = new QName("http://service/", "WebServiceImplPort");

        Service service = Service.create(url, qname);
        MyWebService hello = service.getPort(qport, MyWebService.class);

        boolean doNextRound = true;

        while(doNextRound){
            System.out.println(
                    "[1] - Вывести список курортов по стоимости\n" +
                            "[2] - Узнать цену курорта\n" +
                            "[3] - Выйти\n");
            Scanner in = new Scanner(System.in);
            int choose = in.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Введите максимальную стоимость: ");
                    in = new Scanner(System.in);
                    final ArrayList<String> resorts = hello.getResorts(Integer.parseInt( in.nextLine() ));
                    if (resorts.isEmpty())
                        System.out.println("Ничего не найдено! Попробуйте ввести стоимость выше");
                    else
                        System.out.println(resorts);
                    break;

                case 2:
                    System.out.println("Введите название курорта: ");
                    in = new Scanner(System.in);
                    final Integer price = hello.getPrice(in.nextLine());
                    if (price == null)
                        System.out.println("Ничего не найдено! Введите другой курорт");
                    else
                        System.out.println(price + "$");
                    break;

                case 3:
                    doNextRound = false;
                    break;

                default:
                    System.out.println("Такого пункта меню не найдено! Введите 1, 2 или 3 ");
            }
        }

    }
}
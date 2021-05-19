package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface MyWebService {

    @WebMethod
    Integer getPrice(String resort);

    @WebMethod
    ArrayList<String> getResorts(int price);

}
package SOAP.Servlets;

import SOAP.Models.Payment;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Remco on 24-9-2015.
 */
@WebService
public interface PaymentService {

    @WebMethod
    public Payment cashPayment(double amount);
    @WebMethod
    public Payment bankCardPayment(double amount);
    @WebMethod
    public Payment chequePayment(double amount);
    @WebMethod
    public Payment creditCardPayment(double amount);
    @WebMethod
    public Payment ewalletPayment(double amount);
}

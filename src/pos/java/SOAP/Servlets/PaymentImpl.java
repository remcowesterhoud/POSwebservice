package SOAP.Servlets;

import SOAP.Models.Payment;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Remco on 24-9-2015.
 */
@WebService(endpointInterface = "SOAP.Servlets.PaymentService")
public class PaymentImpl implements PaymentService {

    @WebMethod
    public Payment cashPayment(double amount) {
        return null;
    }

    public Payment bankCardPayment(double amount) {
        return 0;
    }

    public Payment chequePayment(double amount) {
        return 0;
    }

    public Payment creditCardPayment(double amount) {
        return 0;
    }

    public Payment ewalletPayment(double amount) {
        return 0;
    }
}

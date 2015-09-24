package SOAP.Servlets;

import javax.xml.ws.Endpoint;

/**
 * Created by Remco on 24-9-2015.
 */
public class POSPublisher {
    public static void main(String[] args) {
        final String url = "http://localhost:8888/";
        System.out.println("Publishing Rand.RandService at endpoint " + url);
        Endpoint.publish(url, new PaymentImpl());
    }
}

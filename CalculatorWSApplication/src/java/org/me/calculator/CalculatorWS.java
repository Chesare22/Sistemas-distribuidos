/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author rafa_
 */
@WebService(serviceName = "CalculatorWS")
@Stateless()
public class CalculatorWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i + j; 
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "subtraction")
    public int subtraction(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i - j;
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplication")
    public int multiplication(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i * j;
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "division")
    public double division(@WebParam(name = "i") double i, @WebParam(name = "j") double j) {
        try {
            double k = i / j;
            return k;
        } catch (Exception e) {
            return 0;
        }
    }
}

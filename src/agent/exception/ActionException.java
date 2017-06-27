/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent.exception;

/**
 *
 * @author kuri
 */
public class ActionException extends Exception{
    public ActionException(){
        super();
    }
    
    public ActionException(String message){
        super(message);
    }
    
    public ActionException(Throwable cause){
        super(cause);
    }
    
    public ActionException(String message, Throwable cause){
        super(message, cause);
    }
}

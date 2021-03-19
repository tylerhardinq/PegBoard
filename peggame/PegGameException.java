package peggame;


public class PegGameException extends java.lang.Exception{
    public PegGameException(String message){
       throw new Exception(String message);   
    }
}

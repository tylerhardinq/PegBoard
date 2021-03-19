package peggame;


public class PegGameException extends java.lang.Exception{
    public PegGameException(String message) throws Exception{        
       throw new Exception(message);
    }
}

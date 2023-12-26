package com.project.MyRh.Exceptions.Exception;

public class OperationFailed extends RuntimeException{
    public OperationFailed(String message){
        super(message);
    }
}

package com.company;

/*

0915 Catch selective exceptions
1. Understand which exceptions the BEAN.methodThrowExceptions method throws.

2. The processExceptions method should call the BEAN.methodThrowExceptions method and handle exceptions:

2.1. if a FileSystemException exception occurs, then log it (call the BEAN.log method) and forward it

2.2. if a CharConversionException or any other IOException has occurred, only log it (call the BEAN.log method)

3. Add an exception class to the processExceptions declaration that you throw in section 2.1.

4. In the main method, handle the remaining exception - log it. Use try..catch

Hint:
If you caught a MyException exception that you didn’t want to catch, you can throw it further with a code of the form:
catch (MyException e) {
 throw e;
}

Requirements:
1. The processExceptions method should call the BEAN.methodThrowExceptions method.
2. The processExceptions method should log a FileSystemException exception (call the BEAN.log method), and then throw it further.
3. The processExceptions method should only log (call the BEAN.log method) the CharConversionException exception.
4. The processExceptions method should only log any IOException.
5. Add a FileSystemException exception class to the processExceptions method declaration.
6. The main method should use try..catch.

 */

import java.io.*;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.*;


public class Main {
    public static StatelessBean BEAN = new StatelessBean();

    public static void main(String[] args) {
        try {
            processExceptions();
        } catch (FileSystemException e) {
            BEAN.log(e);
        }
    }

    public static void processExceptions() throws FileSystemException {
        try {
            BEAN.methodThrowExceptions();
        } catch (FileSystemException e) {
            BEAN.log(e);
            throw e;
        } catch (CharConversionException e) {
            BEAN.log(e);
        } catch (IOException e) {
            BEAN.log(e);
        }
    }

    public static class StatelessBean {
        public void log(Exception exception) {
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void methodThrowExceptions() throws CharConversionException, FileSystemException, IOException {
            int i = (int) (Math.random() * 3);
            if (i == 0)
                throw new CharConversionException();
            if (i == 1)
                throw new FileSystemException("");
            if (i == 2)
                throw new IOException();
        }
    }
}


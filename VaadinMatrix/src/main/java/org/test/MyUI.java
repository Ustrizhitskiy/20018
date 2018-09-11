package org.test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();

        TextField massField = new TextField("Размер массива m x m:");
        TextArea outMyArrayField = new TextArea("Введенный массив:");
        TextField resField = new TextField("Диагональ:");

        Button resButton = new Button("Вывести диагональ");

        resButton.addClickListener(e -> {
            createArray(Integer.parseInt(massField.getValue()));
            outMyArrayField.setValue(outMyArray(myArray));
            resField.setValue(outDiag(myArray));
        });

        layout.addComponents(massField, outMyArrayField, resButton, resField);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    private int[][] myArray;

    int[][] createArray (int m) {
        myArray = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                myArray[i][j] = (int) (Math.random() * 100);
            }
        }
        return myArray;
    }

    String outMyArray(int[][] myArray) {
        String value = "";
        for (int[] aMyArray : myArray) {
            for (int n = 0; n < myArray.length; n++) {
                value += String.valueOf(aMyArray[n]);
                value += "  ";
                if (n == myArray.length - 1) {
                    value += "\n";
                }
            }
        }
        return value;
    }

    String outDiag(int[][] myArray) {
        String diag = "";
        for (int m = 0; m < myArray.length; m++) {
            for (int n = 0; n < myArray.length; n++) {
                if (m == n) diag += String.valueOf(myArray[m][n]);
                diag += " ";
            }
        }
        return diag;
    }
}

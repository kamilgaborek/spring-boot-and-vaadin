package pl.kamil.springbootdb1;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

@Route
public class RectangleGui extends VerticalLayout {


    private RectangleRepo rectangleRepo;

    private TextField textFieldHeight;
    private TextField textFieldWidth;
    private Button button;

    @Autowired
    public RectangleGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo=rectangleRepo;

        textFieldHeight=new TextField("Podaj wysokosc:");
        textFieldWidth=new TextField("Podaj szerokoś:");
        button=new Button("Dodaj!");

        button.addAttachListener(clickEvent->addRectangle());
        add(textFieldHeight);
        add(textFieldWidth);
        add(button);
    }

    public void addRectangle( ){
        Rectangle rectangle=new Rectangle();
        try {
            rectangle.setHeight(Integer.parseInt(textFieldHeight.getValue()));
            rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));
        }catch(NumberFormatException e){
            System.out.printf("Blad parswana int");

        }

        rectangleRepo.save(rectangle);
    }
}

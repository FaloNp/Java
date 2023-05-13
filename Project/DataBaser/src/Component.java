import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Component {

    java.util.List<Label> LeftLabelInfo = new ArrayList<Label>();
    List<Button> LeftButtonInfo = new ArrayList<Button>();

    Component(){


    }
}
/*
///////////////////////////////////////////////////////////////////////////////////////////////////
Klasa panel
///////////////////////////////////////////////////////////////////////////////////////////////////
*/
class Panel extends JPanel {

    int PanelSizeX;
    int PanelSizeY;
    int DistanceFromStart;
    int VerticalDistance;
    String ColorPanel;

    Panel(int distanceFromStart, int verticalDistance, int panelSizeX, int panelSizeY, String color) {
        this.PanelSizeX = panelSizeX;
        this.PanelSizeY = panelSizeY;
        this.DistanceFromStart = distanceFromStart;
        this.VerticalDistance=verticalDistance;
        this.ColorPanel=color;
        this.setLayout(null);
        this.setBackground(Color.decode(ColorPanel));
        this.setBounds(DistanceFromStart,VerticalDistance,PanelSizeX,PanelSizeY);
        this.setOpaque(true);
    }

}
class PanelScrollable extends ScrollPane {

    int PanelSizeX;
    int PanelSizeY;
    int DistanceFromStart;
    int VerticalDistance;
    String ColorPanel;

    PanelScrollable(int distanceFromStart, int verticalDistance, int panelSizeX, int panelSizeY, String color) {
        this.PanelSizeX = panelSizeX;
        this.PanelSizeY = panelSizeY;
        this.DistanceFromStart = distanceFromStart;
        this.VerticalDistance=verticalDistance;
        this.ColorPanel=color;
        this.setBackground(Color.decode(ColorPanel));
        this.setPreferredSize(new Dimension(PanelSizeX, PanelSizeY));

    }

}
/*
///////////////////////////////////////////////////////////////////////////////////////////////////
Klasa button
///////////////////////////////////////////////////////////////////////////////////////////////////
*/
class Button extends JButton {
    int ButtonWidth;
    int ButtonHeight;
    String ButtonText;
    //Tworzy przycisk o standardowych wymiarach
    Button(String buttonText){
        this.ButtonText=buttonText;
        this.setLayout(null);
        this.setBounds(0,0,100,100);
        this.setText(ButtonText);
    }
    //Tworzy przycisk o niestandardowych wymiarach
    Button(String buttonText,int buttonWidth, int buttonHeight){
        this.ButtonWidth=buttonWidth;
        this.ButtonHeight=buttonHeight;
        this.ButtonText=buttonText;
        this.setLayout(null);
        this.setBounds(20,170,ButtonWidth,ButtonHeight);
        this.setText(ButtonText);
    }
}
/*
///////////////////////////////////////////////////////////////////////////////////////////////////
Klasa Label
///////////////////////////////////////////////////////////////////////////////////////////////////
*/
class Label extends JLabel {

    int PanelSizeX;
    int PanelSizeY;
    int DistanceFromStart;
    int VerticalDistance;
    String LabelText;

    //Tworzy pole z wybranym napisem
    Label(int distanceFromStart, int verticalDistance, int panelSizeX, int panelSizeY, String labelText) {
        this.PanelSizeX = panelSizeX;
        this.PanelSizeY = panelSizeY;
        this.setLayout(null);
        this.DistanceFromStart = distanceFromStart;
        this.VerticalDistance = verticalDistance;
        this.LabelText = labelText;
        this.setText(LabelText);
        this.setBounds(DistanceFromStart, VerticalDistance, PanelSizeX, PanelSizeY);
        this.setForeground(Color.BLACK);
    }
}
class TextField extends JTextField{
    int PanelSizeX;
    int PanelSizeY;
    int DistanceFromStart;
    int VerticalDistance;
    TextField(int distanceFromStart, int verticalDistance, int panelSizeX, int panelSizeY){
        this.PanelSizeX = panelSizeX;
        this.PanelSizeY = panelSizeY;
        this.setLayout(null);
        this.DistanceFromStart = distanceFromStart;
        this.VerticalDistance=verticalDistance;
       // this.setPreferredSize(new Dimension(PanelSizeX,PanelSizeY));
        this.setBounds(DistanceFromStart,VerticalDistance,PanelSizeX,PanelSizeY);
    }

}
class CheckBox extends JCheckBox{
    CheckBox(){

    }
}


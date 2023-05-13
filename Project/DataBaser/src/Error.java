import javax.swing.*;
import java.awt.*;
public class Error {

    JFrame ErrorFrame = new JFrame("Error");
    String ErrorValue;

    Error(String errorValue){
        ErrorValue=errorValue;
        Label label = new Label(40,0,400,230,ErrorValue);
        Panel panel = new Panel(0,0,400,340,"#00000");
        Button returnButton=new Button("Wroc",352,50);
        ErrorFrame.dispose();
        ErrorFrame.setBackground(Color.black);
        ErrorFrame.setLayout(null);
        ErrorFrame.setDefaultCloseOperation(ErrorFrame.EXIT_ON_CLOSE);
        ErrorFrame.setPreferredSize(new Dimension(410,350));
        ErrorFrame.setVisible(true);
        ErrorFrame.setResizable(false);
        ErrorFrame.toFront();
        ErrorFrame.requestFocus();
        ErrorFrame.setAlwaysOnTop(true);
        ErrorFrame.add(panel);
        panel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLUE));
        panel.setLayout(null);
        panel.add(label);
        panel.add(returnButton);
        label.setForeground(Color.BLUE);
        returnButton.addActionListener(e->ExitWindow());
        ErrorFrame.pack();


    }
    void ExitWindow(){
        ErrorFrame.dispose();
    }
}

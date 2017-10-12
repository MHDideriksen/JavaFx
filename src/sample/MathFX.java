package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class MathFX extends Application {

    TextField txtnum1, txtnum2;
    Button btnadd, btnsub, btndiv, btnmul, btnclear;
    Label lblanswer;

    @Override
    public void start(Stage primaryStage) {
        //Laver knapperne
        txtnum1=new TextField();
        txtnum2=new TextField();
        btnadd=new Button("+");
        btnsub=new Button("-");
        btnmul=new Button("x");
        btndiv=new Button("/");
        btnclear=new Button("Clear");
        lblanswer=new Label("Label");
        //Forstår jeg ikke
        lblanswer.setAlignment(Pos.CENTER);
        //Forstår jeg ikke
        lblanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");

        //laver en "container" til appen
        GridPane root = new GridPane();
        //Sætter containeren i midten af scenen
        root.setAlignment(Pos.CENTER);
        //Laver plads mellem knapperne
        root.setHgap(10);
        root.setVgap(10);
        //opsætter de forskellige knapper
        root.add(btnadd,0,0);
        root.add(btnsub,1,0);
        root.add(btnmul,0,1);
        root.add(btndiv,1,1);
        root.add(txtnum1, 0,2);
        root.add(txtnum2,1,2);
        //De sidste to rækker er over to kolloner
        //col, rol, colspan, rowspan
        root.add(lblanswer,0,3,2,1);
        root.add(btnclear,0,4,2,1);
        //set widths of all controls in separate method
        setWidths();
        //sætter kode til knapper
        attachCode();
        //De anmindelige ting
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mathtastic 1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void setWidths(){
        //sæt bredte af knapperne
        txtnum1.setPrefWidth(70);
        txtnum2.setPrefWidth(70);
        btnadd.setPrefWidth(70);
        btnsub.setPrefWidth(70);
        btnmul.setPrefWidth(70);
        btndiv.setPrefWidth(70);
        btnclear.setPrefWidth(150);
        lblanswer.setPrefWidth(150);
    }

    public void attachCode()
    {
        //alle knapper skal køre btnkode
        btnadd.setOnAction(e -> btncode(e));
        btnsub.setOnAction(e -> btncode(e));
        btnmul.setOnAction(e -> btncode(e));
        btndiv.setOnAction(e -> btncode(e));
        btnclear.setOnAction(e -> btncode(e));
    }

    public void btncode(ActionEvent e)
    {
        int num1, num2, answer;
        char symbol;
        //e fortæller hvilken knap der er blevet trykket
        if(e.getSource()==btnclear)
        {
            txtnum1.setText("");
            txtnum2.setText("");
            lblanswer.setText("?");
            txtnum1.requestFocus();
            return;
        }
        //læser numre fra textfields
        num1=Integer.parseInt(txtnum1.getText());
        num2=Integer.parseInt(txtnum2.getText());
        if(e.getSource()==btnadd)
        {
            symbol='+';
            answer=num1+num2;
        }
        else if(e.getSource()==btnsub)
        {
            symbol='-';
            answer=num1-num2;
        }
        else if(e.getSource()==btnmul)
        {
            symbol='x';
            answer=num1*num2;
        }
        else
        {
            symbol='/';
            answer=num1/num2;
        }
        //Viser svar
        lblanswer.setText("" + num1 + symbol + num2 + "=" + answer);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
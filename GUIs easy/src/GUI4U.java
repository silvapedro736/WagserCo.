import java.awt.*;

public class GUI4U extends Frame

{

    private Label label;
    private TextField text;
    private Button button;

    public GUI4U()

    {

        setLayout(new FlowLayout());

        label = new Label("A LABEL");
        add(label);

        text = new TextField("153", 10);
        text.setEditable(true);
        add(text);

        button = new Button("BUTTON");

        setTitle("GUI TITLE");
        setSize(250,100);

        setVisible(true);

    }

    public static void main(String[] args)

    {

        GUI4U gui = new GUI4U();

    }

}
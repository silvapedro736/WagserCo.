import javax.swing.*;
import java.awt.*;

/**
 * Created by pedrosilva on 4/24/16.
 */
public class new_file {

    public static new_file run = new new_file();

    public static void main(String[] args){

        run.init_new_file();

    }

    public void init_new_file(){

        JFrame main = new JFrame("New File");
        
        main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //------------------------------------------------------------------------------



        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(600, 300);

        main.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        main.setResizable(false);
        main.setMinimumSize(frameSize);
        main.setVisible(true);
        main.pack();

    }

}

import javax.swing.*;
import java.awt.*;

public class Loading {
    JPanel panel;
    Loading() {
        panel = new JPanel();
        panel.setBackground(new Color(0,0,0));
        panel.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(this.getClass().getResource("loading.gif"));
        JLabel label = new JLabel(icon);
        panel.add(label, BorderLayout.CENTER);

    }

   JPanel getLoadingpanel(){
        return panel;
    }
}

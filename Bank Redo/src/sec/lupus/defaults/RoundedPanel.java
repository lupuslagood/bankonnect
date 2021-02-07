package sec.lupus.defaults;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private static final Color shadowColor = Color.black;
    private static final Dimension arcs = new Dimension(40, 40); // radius of arcs

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        //Distance between shadow border and opaque panel border
        int shadowGap = 5;
        //transparency value ( 0-255 )
        int shadowAlpha = 150;
        Color shadowColorB = Color.darkGray;
        Graphics2D graphics2D = (Graphics2D) g;
        boolean highQuality = true;
        if (highQuality) {
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        // sets if it drops shadow
        boolean shady = true;
        if (shady) {
            graphics2D.setColor(shadowColorB);
            int strokeSize = 1;
            int shadowOffset = 4;
            graphics2D.fillRoundRect(shadowOffset, shadowOffset, width - strokeSize - shadowOffset, height - strokeSize - shadowOffset, arcs.width, arcs.height);
        } else {
            shadowGap = 1;
        }
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        Color color1 = new Color(0,10, 50);
        Color color2 = Color.blue;
        GradientPaint gradientPaint = new GradientPaint(0,0,color1,0,height , color2);
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRoundRect(0,0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
        graphics2D.setStroke(new BasicStroke());
    }

    public RoundedPanel() {
        super();
        setLayout(null);
        setOpaque(false);
        setBounds(200,130,600,400);
    }

}

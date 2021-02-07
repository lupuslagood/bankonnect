package sec.lupus.defaults;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButtons extends JButton {
    private Shape shape;

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth() - getInsets().left - getInsets().right;
        int height = getHeight() - getInsets().top - getInsets().bottom;
        g.setColor(getBackground());
        g.fillRoundRect(getInsets().left, getInsets().right, width, height, 40, 40);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0,getWidth()-1, getHeight()-1, 40, 40);
        super.paintBorder(g);
    }
    @Override
    public boolean contains(int x, int y) {
        if (shape == null || shape.getBounds() == getBounds()) {
            shape = new RoundRectangle2D.Float(0,0, (float) getWidth() - 1, (float) getHeight() - 1, 40, 40);
        }
        return super.contains(x, y);
    }

    public RoundedButtons() {
        super();
        setOpaque(false);
        setFocusable(false);
        Font font = new Font("Comic Sans", Font.BOLD, 18);
        setFont(font);
        setForeground(Color.cyan);
        setBackground(new Color(0,10,50));
        setBorder(BorderFactory.createEmptyBorder(3,5,3,5));
    }
}

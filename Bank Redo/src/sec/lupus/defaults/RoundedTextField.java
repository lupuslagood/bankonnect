package sec.lupus.defaults;

import javax.swing.*;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class RoundedTextField extends JTextField {
    private Shape shape;

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth() - getInsets().left - getInsets().right;
        int height = getHeight() - getInsets().top - getInsets().bottom;
        g.setColor(getBackground());
        g.fillRoundRect(getInsets().left, getInsets().top, width, height, 20, 20);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRoundRect(0,0,getWidth() - 1, getHeight() - 1, 20, 20);
        super.paintBorder(g);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || shape.getBounds() == getBounds()) {
            shape = new RoundRectangle2D.Float(0,0, (float) getWidth() - 1, (float) getHeight() - 1, 20, 20);
        }
        return super.contains(x, y);
    }

    public RoundedTextField() {
        super();
        setOpaque(false);
        Font font = new Font("Comc Sans", Font.BOLD, 22);
        setFont(font);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createEmptyBorder(3,5,3,5));
    }
}

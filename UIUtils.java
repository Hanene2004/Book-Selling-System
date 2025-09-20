package Textbook_selling_system;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIUtils {

    // Apply a modern interactive style to a JButton
    public static void styleButton(JButton b, Color base) {
        b.setBackground(base);
        b.setForeground(getTextColorFor(base));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setOpaque(true);

        // Lightweight hover / press feedback
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setBackground(brighten(base, 0.06f));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setBackground(base);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                b.setBackground(darken(base, 0.08f));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b.setBackground(base);
            }
        });
    }

    private static Color getTextColorFor(Color c) {
        // Compute a simple luminance to pick a readable foreground color
        double r = c.getRed() / 255.0;
        double g = c.getGreen() / 255.0;
        double b = c.getBlue() / 255.0;
        double luminance = 0.299 * r + 0.587 * g + 0.114 * b;
        return luminance > 0.6 ? Color.black : Color.white;
    }

    private static Color brighten(Color c, float factor) {
        int r = (int) Math.min(255, c.getRed() + 255 * factor);
        int g = (int) Math.min(255, c.getGreen() + 255 * factor);
        int b = (int) Math.min(255, c.getBlue() + 255 * factor);
        return new Color(r, g, b);
    }

    private static Color darken(Color c, float factor) {
        int r = (int) Math.max(0, c.getRed() - 255 * factor);
        int g = (int) Math.max(0, c.getGreen() - 255 * factor);
        int b = (int) Math.max(0, c.getBlue() - 255 * factor);
        return new Color(r, g, b);
    }
}

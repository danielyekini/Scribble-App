import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.util.ArrayList;

class Line {
    ArrayList<Point2D> points = new ArrayList<>();
}

class DrawComponent extends JComponent {
    final ArrayList<Line> lines = new ArrayList<>();
    // pointSpan defines how many points back in the list to draw the line
    int pointSpan = 10;

    public DrawComponent() {
        /**
         * Use anonymous inner classes to simplify event handling code by defining 
         * event handling methods directly within the addMouseListener and addMouseMotionListener calls.
         */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Line line = new Line();
                line.points.add(e.getPoint());
                lines.add(line);
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Line currentLine = lines.get(lines.size() - 1);
                currentLine.points.add(e.getPoint());
                repaint();
            }
        });

        setBackground(Color.WHITE);
    }

    public void reset() {
        lines.clear();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Line line : lines) {
            for (int i = 1; i < line.points.size(); i++) {
                Point2D p1 = line.points.get(i - 1);
                Point2D p2 = line.points.get(i);
                g2.draw(new java.awt.geom.Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY()));

            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }
}

class ScribblePanel extends JPanel {
    private final DrawComponent drawComponent = new DrawComponent();

    public ScribblePanel() {
        setLayout(new BorderLayout());

        // Create a button to reset the drawing
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> drawComponent.reset());

        // Add the reset button to a panel and place it in the SOUTH of the border layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add the drawing component to the CENTER of the border layout
        add(drawComponent, BorderLayout.CENTER);
    }
}

public class ScribbleApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scribble App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ScribblePanel());
        frame.pack();
        frame.setVisible(true);
    }
}

package views;

import models.Node;
import models.Tree;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {

    private Tree tree;

    public TreePanel(Tree tree) {
        initProperties();
        initComponents(tree);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        paintTree(g2);
    }

    private void paintTree (Graphics2D g2) {
        double width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        double diameter = width/Math.pow(2,tree.countLevels()-1);
        double radius = diameter/2;
        belowPaintTree(g2, tree.getHeadNode(), (int)radius, 0, (int)width, 10 );
        g2.setColor(Color.red);
        g2.drawLine((int)width/2,0,(int)width/2,(int)height);
        g2.drawString("Levels: " + tree.countLevels(),200,600);
    }


    private void belowPaintTree(Graphics2D g2, Node node, int radius, int leftLimit, int rightLimit, int y) {
        if(node != null) {

            int x = (rightLimit-leftLimit)/2 + leftLimit;
            g2.drawString(node.getValue()+"", x,y + radius);
            g2.drawOval(x - radius, y, radius * 2, radius * 2);


            belowPaintTree(g2, node.getLeftNode(), radius, leftLimit, x, y + radius*3);
            belowPaintTree(g2, node.getRightNode(), radius, x, rightLimit, y + radius*3);
        }
    }

    private void initComponents(Tree tree) {
        this.tree = tree;
    }

    private void initProperties() {
        setBackground(Color.white);
    }
}

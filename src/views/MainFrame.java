package views;

import models.Tree;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TreePanel treePanel;

    public MainFrame(Tree tree) {
        initProperties();
        initComponents(tree);
    }

    private void initComponents(Tree tree) {
        treePanel = new TreePanel(tree);
        add(treePanel);
    }

    private void initProperties() {
        int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setSize(width, height);
        setVisible(true);
        setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

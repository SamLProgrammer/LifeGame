package controller;

import models.Tree;
import views.MainFrame;

public class Controller {

    private Tree tree;
    private MainFrame mainFrame;

    public Controller() {
        initComponents();
    }

    private void initComponents() {
        tree = new Tree();
        mainFrame = new MainFrame(tree);
    }
}

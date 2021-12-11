import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * @author: Dominic Henley
 *
 * A simple application to keep track of finances made
 */

public class main {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JMenuItem menuItem;
    private static JMenuBar menuBar;
    private static JMenu menu;
    private static JTable table;

    public static void main(String[] args){
        Purchase p = new Purchase("test", 20,"test comment");
        CSVManager.getInstance();

        System.out.println(initFile());
        initFrame();
    }

    private static void initFrame(){
        frame = new JFrame("Finances app");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);

        initMenuBar();
        initTable();

        frame.setVisible(true);
    }

    private static void initTable(){
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Purchases", TitledBorder.CENTER, TitledBorder.TOP));
        table = new JTable(CSVManager.getData(), CSVManager.getHeaders());
        mainPanel.add(new JScrollPane(table));
        frame.add(mainPanel);
    }

    private static void initMenuBar(){
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menu = new JMenu("Purchases");
        menuBar.add(menu);

        menuItem = new JMenuItem("Add purchase");
        menu.add(menuItem);
    }

    private static String initFile(){
        try{
            File file = new File("res/Purchases.csv");
            if(!file.createNewFile()){
                return "File already exists";
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return "Successfully created file";
    }
}

package edu.ict.swing;

import com.deameamo.swingx.DefaultMainFrame;
import com.deameamo.swingx.ResizableBox;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainFrame extends DefaultMainFrame {
    private JEditorPane jEditorPane = new JEditorPane();

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            MainFrame mainFrame = new MainFrame();
            mainFrame.load();
            mainFrame.setVisible(true);
        });
    }

    public void load() {
        setSize(600, 500);
        ResizableBox mainBox = mainBox();
        mainBox.addItem(new JScrollPane(jEditorPane));
        jEditorPane.setContentType("text/html");
        jEditorPane.setEditable(false);

        Document doc = getHtmlDocument();
        jEditorPane.setText(doc.body().toString());
        jEditorPane.setCaretPosition(0);
    }

    public Document getHtmlDocument() {
        Document doc = null;
        try {
            doc = Jsoup.parse(new File("test1.html"), "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}

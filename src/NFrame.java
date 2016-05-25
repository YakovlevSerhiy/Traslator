import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class NFrame extends JFrame{
    JTextArea textArea;
    JPanel label;
    File file;
    Analysis analysis;
    java.util.List<Word> listWords;
    JTable table;
    JScrollPane scrollPane;


    public NFrame() {
        super("Переводчик");

        this.setLayout(new BorderLayout());
        //label = new JPanel();
        //label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        //textArea = new JTextArea();
        //textArea.setLineWrap(true);
        //textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        //JScrollPane scrollPane=new JScrollPane(textArea);



        JButton button = new JButton("Укажите файл для перевода");
        button.setAlignmentX(CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Выбрать файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    file = fileopen.getSelectedFile();
                    //label.setText(file.getName());

                    /*try {
                        analysis = new Analysis(file);
                    } catch (IOException exp) {
                        exp.printStackTrace();
                    }

                    listWords = analysis.getList();

                    textArea.append("Всего слов: - " + listWords.size() + "\n");

                    for (Word currentWord:listWords)
                    {

                        textArea.append(currentWord.toString() + "\n");
                    }*/


                }
            }
        });

        JButton buttonTranslate = new JButton("Translate");
        buttonTranslate.setAlignmentX(CENTER_ALIGNMENT);
        buttonTranslate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            try {
                analysis = new Analysis(file);
            } catch (IOException exp) {
                exp.printStackTrace();
            }

            listWords = analysis.getList();
            String[] columnNames = {"eng", "ru", "count"};
            /*String[][] tableStr = new String[listWords.size()][3];

                for (int i = 0; i < tableStr.length; i++) {
                    tableStr[i][0] = listWords.get(i).getEngWord();
                    tableStr[i][1] = listWords.get(i).getRuWord();
                    tableStr[i][2] = "" + listWords.get(i).getCount();
                }*/
                String[][] tableStr = {
                        {"addins", "02.11.2006 19:15", "Folder"},
                        {"AppPatch", "03.10.2006 14:10", "Folder"},
                        {"assembly", "02.11.2006 14:20", "Folder"},};

                table = new JTable(tableStr, columnNames);
                table.setFillsViewportHeight(true);
                scrollPane = new JScrollPane(table);
                add(scrollPane, BorderLayout.CENTER);
            //textArea.append("Всего слов: - " + listWords.size() + "\n");

            /*for (Word currentWord:listWords)
            {

                textArea.append(currentWord.toString() + "\n");
            }*/

            }});

        Box boxWeight = Box.createVerticalBox();
        boxWeight.add(button);
        boxWeight.add(buttonTranslate);


        //table.setFillsViewportHeight(true);
        /*String[] columnNames = {"eng", "ru", "count"};
        String[][] tableStr = {
                {"addins", "02.11.2006 19:15", "Folder"},
                {"AppPatch", "03.10.2006 14:10", "Folder"},
                {"assembly", "02.11.2006 14:20", "Folder"},};

        table = new JTable(tableStr, columnNames);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);*/
        //this.add(scrollPane, BorderLayout.CENTER);

        this.add(boxWeight,BorderLayout.NORTH);
        //this.add(scrollPane, BorderLayout.CENTER);
        //this.add(button,BorderLayout.NORTH);
        //this.add(buttonTranslate,BorderLayout.NORTH);

    }

}

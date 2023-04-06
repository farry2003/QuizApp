import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizApp extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel questionLabel;
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JRadioButton option4;
    private JButton prevButton;
    private JButton showButton;
    private JButton nextButton;
    private ButtonGroup optionsGroup;
    private String[][] questions = {
        {"What is the capital of Australia?", "Canberra", "Sydney", "Melbourne", "Brisbane"},
        {"What is the tallest mountain in the world?", "Mount Everest", "K2", "Kangchenjunga", "Lhotse"},
        {"What is the largest country in the world by area?", "Russia", "Canada", "China", "USA"},
        {"What is the currency of Japan?", "Yen", "Dollar", "Euro", "Pound"},
        {"Who painted the Mona Lisa?", "Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Salvador Dali"}
    };
    private int currentQuestion = 0;

    public QuizApp() {
        super("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(7, 1));
        
        questionLabel = new JLabel(questions[currentQuestion][0]);
        add(questionLabel);
        
        option1 = new JRadioButton(questions[currentQuestion][1]);
        option2 = new JRadioButton(questions[currentQuestion][2]);
        option3 = new JRadioButton(questions[currentQuestion][3]);
        option4 = new JRadioButton(questions[currentQuestion][4]);
        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);
        add(option1);
        add(option2);
        add(option3);
        add(option4);
        
        prevButton = new JButton("PREV");
        showButton = new JButton("SHOW");
        nextButton = new JButton("NEXT");
        prevButton.addActionListener(this);
        showButton.addActionListener(this);
        nextButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(prevButton);
        buttonPanel.add(showButton);
        buttonPanel.add(nextButton);
        add(buttonPanel);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            if (currentQuestion > 0) {
                currentQuestion--;
                questionLabel.setText(questions[currentQuestion][0]);
                option1.setText(questions[currentQuestion][1]);
                option2.setText(questions[currentQuestion][2]);
                option3.setText(questions[currentQuestion][3]);
                option4.setText(questions[currentQuestion][4]);
            }
        } else if (e.getSource() == showButton) {
            String answer = questions[currentQuestion][1];
            JOptionPane.showMessageDialog(this, answer);
        } else if (e.getSource() == nextButton) {
            if (currentQuestion < questions.length - 1) {
                currentQuestion++;
                questionLabel.setText(questions[currentQuestion][0]);
                option1.setText(questions[currentQuestion][1]);
                option2.setText(questions[currentQuestion][2]);
                option3.setText(questions[currentQuestion][3]);
                option4.setText(questions[currentQuestion][4]);
            }
        }
    }

    public static void main(String[] args) {
        QuizApp app = new QuizApp();
    }
}

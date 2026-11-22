package tutorial7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QuizBattleGUI extends JFrame implements ActionListener {
    private Questions question;
    private JLabel lblQuestion;
    private JLabel lblResult;
    private JButton btn1;
    private JButton btn2;

    public QuizBattleGUI() {
        question = new Questions();

        setTitle("Programming Quiz Battle");
        setSize(420, 260);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblQuestion = new JLabel(question.getQuestion());
        lblQuestion.setBounds(50, 30, 320, 30);

        btn1 = new JButton(question.getOption1());
        btn1.setBounds(60, 80, 120, 40);
        btn1.addActionListener(this);

        btn2 = new JButton(question.getOption2());
        btn2.setBounds(210, 80, 120, 40);
        btn2.addActionListener(this);

        lblResult = new JLabel("Answer the question!");
        lblResult.setBounds(60, 145, 300, 30);

        add(lblQuestion);
        add(btn1);
        add(btn2);
        add(lblResult);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (question.isCorrect(button.getText())) {
            lblResult.setText("Correct! You defeated the Code Boss!");
        } else {
            lblResult.setText("Wrong! Try Again!");
        }
    }

    public static void main(String[] args) {
        new QuizBattleGUI();
    }
}

import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

class StackImplementation extends Frame implements ActionListener {
    private TextField tf;
    private Button pushB, popB;
    private TextArea ta;
    private Label tl;
    private Stack<String> stack;

    public StackImplementation() {
        setTitle("Stack Implementation");
        setSize(500, 500);
        setLayout(new FlowLayout());

        tf = new TextField(10);
        tf.setBounds(30, 50, 200, 50);

        pushB = new Button("Push");
        pushB.setBounds(30, 120, 100, 50);

        popB = new Button("Pop");
        popB.setBounds(150, 120, 100, 50);

        ta = new TextArea(10, 10);
        ta.setBounds(30, 280, 100, 100);

        tl = new Label();
        tl.setBounds(30, 210, 100, 50);

        add(tf);
        add(pushB);
        add(popB);
        add(tl);
        add(ta);

        pushB.addActionListener(this);
        popB.addActionListener(this);

        stack = new Stack<>();
    }

    public void actionPerformed(ActionEvent e) {

        String value = tf.getText();
        if (e.getSource() == pushB) {
            try {
                // value = Integer.parseInt(str);
                stack.push(value);
                ta.insert("\n" + value, 0);
            } catch (NumberFormatException ex) {
                ta.append("Invalid input\n");
            }
        } else if (e.getSource() == popB) {
            if (!stack.isEmpty()) {
                String epop = stack.pop();
                ta.setText("");
                // tl.setText("poped element: " + epop);
                // textArea.append("remaining element");
                for (String i : stack) {
                    ta.insert(i + "\n", 0);
                }

            } else {
                ta.append("Stack is empty\n");
            }
        }
    }

    public static void main(String[] args) {
        StackImplementation stackImpl = new StackImplementation();
        stackImpl.setVisible(true);
    }
}
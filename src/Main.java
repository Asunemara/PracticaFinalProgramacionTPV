import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aquí va el programa :3");
        JFrame frame = new JFrame("Instrumentos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PanelInstrumentos panel = new PanelInstrumentos();
        frame.add(panel.getPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

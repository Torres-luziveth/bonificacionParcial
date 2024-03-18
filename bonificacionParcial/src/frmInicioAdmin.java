import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class frmInicioAdmin extends JFrame implements ActionListener {

    static JLabel lblSaludo, lblImgSal;
    static ImageIcon imgSaludo;
    static JButton btnRegresar;


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmLogin.ventana.setVisible(true);
            this.setVisible(false);
        }
    }

    public frmInicioAdmin(){
        //Fondo
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo1 = new ImageIcon(".\\img\\fondo.png");
                g.drawImage(fondo1.getImage(), 0, 0, getWidth(), getHeight(), this);

            }
        };
        contentPane.setLayout(null);

        //img
        imgSaludo = new ImageIcon(".\\img\\hola.png");

        //Jlabels
        lblSaludo = new JLabel();
        lblImgSal = new JLabel(imgSaludo);

        // Establecer fuente más grande
        Font fuente = new Font("Arial", Font.BOLD, 25);
        lblSaludo.setFont(fuente);

        //butons
        btnRegresar = new JButton("Regresar");

        //Set bound
        btnRegresar.setBounds(110, 150, 100, 25);

        //action listen
        btnRegresar.addActionListener(this);

        //Adicionar
        contentPane.add(lblSaludo);
        contentPane.add(lblImgSal);
        contentPane.add(btnRegresar);

        //configuracion de la ventana
        setContentPane(contentPane);
        setLayout(null);
        setSize(350, 350);
        setTitle("Saludar");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }
    static void saludar(String usuario){
        // mensaje
        lblSaludo.setText("Hola admin " + usuario);

        //setBounts
        lblSaludo.setBounds(30, 100, 300, 25);
        lblImgSal.setBounds(250, 70, 70, 70);

        String ingreso = LocalDate.now()+"-"+LocalTime.now()+"-"+usuario;
        EscribirTxt.escribir(ingreso);
    }
}
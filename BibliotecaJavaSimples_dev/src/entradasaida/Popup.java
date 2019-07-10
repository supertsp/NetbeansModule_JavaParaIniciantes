package entradasaida;

// <editor-fold defaultstate="collapsed" desc="imports...">
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 8 de jul de 2019, 22:13:12
 */// </editor-fold>
public class Popup {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //    <editor-fold defaultstate="collapsed" desc="main attributes...">
    //    </editor-fold>
    //    <editor-fold defaultstate="collapsed" desc="constants attributes...">
    //    </editor-fold>
    //    <editor-fold defaultstate="collapsed" desc="static attributes...">
    //    </editor-fold>
    //    <editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    //    </editor-fold>
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="methods...">
    //    <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    //    </editor-fold>
    //    <editor-fold defaultstate="collapsed" desc="override methods...">
    //    </editor-fold>    
    //    <editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    //    </editor-fold>
    //    <editor-fold defaultstate="collapsed" desc="static methods...">
    
    
    public static String showInputDialog(
            ) {
//    public static String showInputDialog(
//            Component parentComponent,
//            Object message,
//            String title,
//            int messageType) {

//        JOptionPane pane = new JOptionPane(
//                message, messageType,
//                JOptionPane.OK_CANCEL_OPTION, 
//                null, //icon,
//                null, 
//                null
//        );
//
//        pane.setWantsInput(true);
//        pane.setSelectionValues(null);
//        pane.setInitialSelectionValue(null);
//        pane.setComponentOrientation(((parentComponent == null)
//                ? getRootFrame() : parentComponent).getComponentOrientation());
//
//        int style = styleFromMessageType(messageType);
//        JDialog dialog = pane.createDialog(parentComponent, title, style);
//
//        pane.selectInitialValue();
//        dialog.show();
//        dialog.dispose();
//
//        Object value = pane.getInputValue();
//
//        if (value == UNINITIALIZED_VALUE) {
//            return null;
//        }
//        return value;
//        
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}
        
        JOptionPane jop = new JOptionPane();
//        jop.setBackground(Color.red);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDialog dialog = jop.createDialog("File not found");
                
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        System.exit(0);
                    }
                });
                
                
                
                
                BorderLayout borderLayout = new BorderLayout();
                dialog.setLayout(borderLayout);
                
//                JPanel panel = new JPanel();
//                dialog.add(panel);
//                
        
                JLabel im = new JLabel("Java Technology Dive Log", new ImageIcon("C:/Users/tiago/source/NetbeansProjects/NetbeansModule_JavaParaIniciantes/BibliotecaJavaSimples_PRD/test/testes/girl.png"), JLabel.CENTER);
//                JLabel im = new JLabel("Java Technology Dive Log", JLabel.CENTER);
//                im.setBackground(Color.yellow);
                dialog.add(im, BorderLayout.NORTH);
                
                
                dialog.setVisible(true);
                
            }//run
        });
        
        
        
        
        
        

        return "";
    }
    //    </editor-fold>

    //    <editor-fold defaultstate="collapsed" desc="main methods...">
    //    </editor-fold>
    
    public static void main(String[] args) {
        Popup.showInputDialog();
        System.out.println("dddd");
    }
    
//</editor-fold>
    
}//class

package javaapplication5.GUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javaapplication5.Classes.Employee;
import javaapplication5.Connection.ClientConnection;
import javax.swing.Renderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;

public class OperationStatistics extends javax.swing.JFrame {

    public OperationStatistics() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 765, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 427, Short.MAX_VALUE));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OperationStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperationStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperationStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperationStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new OperationStatistics().setVisible(true);
            }
        });
    }

    public DefaultPieDataset getDataset() {
        connection.sendMessage("get operation statistics");
        DefaultPieDataset dataset = (DefaultPieDataset) connection.readObject();
        return dataset;
    }

    ClientConnection connection;

    Employee employee;

    public OperationStatistics(ClientConnection connection, Employee employee) {
        this.connection = connection;
        this.employee = employee;
        initComponents();
        JFreeChart chart1 = ChartFactory.createPieChart("PieChart", getDataset(), true, true, false);
        chart1.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        chart1.setBorderVisible(true);
        BasicStroke s = new BasicStroke(2.0f);
        chart1.setBorderStroke(s);
        chart1.setBorderPaint(Color.red);
        chart1.setPadding(new RectangleInsets(1, 2, 3, 4));
        chart1.setTitle("Расходы");
        chart1.addSubtitle(new TextTitle("Статистика расхода за последний год"));
        DecimalFormat df = new DecimalFormat("0.00");
        NumberFormat nf = NumberFormat.getNumberInstance();
        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0} год   {1} $", nf, df);
        PiePlot piePlot = (PiePlot) chart1.getPlot();
        piePlot.setLabelGenerator(sp1);
        piePlot.setNoDataMessage("no data");
        piePlot.setLabelGap(0.02D);
        piePlot.setIgnoreNullValues(true);
        piePlot.setIgnoreZeroValues(true);
        ChartPanel chartPanel = new ChartPanel(chart1);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();
    }

    JFreeChart freeChart;

    public void setUp() {
        freeChart = ChartFactory.createPieChart("Pie chart", getDataset(), true, true, true);
    }

    private javax.swing.JPanel jPanel1;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.main;

import br.com.inovatec.grid.entidades.*;
import br.com.inovatec.grid.services.*;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.impl.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zrobe
 */
public class AulaJFrame extends javax.swing.JFrame {

    private EscolaService escolaService = new EscolaServiceImpl();
    private DiaAulaService diaAulaService = new DiaAulaServiceImpl();
    private ProfessorService professorService = new ProfessorServiceImpl();
    private DisciplinaService disciplinaService = new DisciplinaServiceImpl(); // Nao usada diretamente
    private SalaService salaService = new SalaServiceImpl();
    private TurmaService turmaService = new TurmaServiceImpl();
    private DisciplinaTurmaService disciplinaTurmaService = new DisciplinaTurmaServiceImpl();
    private AulaService aulaService = new AulaServiceImpl();
    private GradeService gradeService = new GradeServiceImpl();
    
    /**
     * Creates new form AulaJFrame
     */
    public AulaJFrame() {
        initComponents();
        
        try {
            
            // Resgatar todos os dados necessários
            Escola escola = this.escolaService.get();
            List<DiaAula> diasDeAula = this.diaAulaService.findAll();
            List<Professor> professores = this.professorService.findAll();
            List<DisciplinaTurma> disciplinasTurmas = this.disciplinaTurmaService.findAll();
            List<Sala> salas = this.salaService.findAll();
            List<Turma> turmas = this.turmaService.findAll();
            
            // Listas a serem geradas
            List<Aula> aulas = new ArrayList<>();
            
        } catch (ServiceException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        turmasJComboBox = new javax.swing.JComboBox<>();
        disciplinasTurmasJComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(turmasJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(disciplinasTurmasJComboBox, 0, 580, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turmasJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disciplinasTurmasJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AulaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AulaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AulaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AulaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AulaJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> disciplinasTurmasJComboBox;
    private javax.swing.JComboBox<String> turmasJComboBox;
    // End of variables declaration//GEN-END:variables
}
import javax.swing.text.TabableView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angel
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        tabla = (javax.swing.table.DefaultTableModel) jspToken.getModel();
        a = new ArbolBinarioString();
        jspArbol.add(aGrafico = new ArbolExpresionGrafico(a));
        jspArbol.setViewportView(aGrafico);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jspEditor = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        tblTokens = new javax.swing.JScrollPane();
        jspToken = new javax.swing.JTable();
        jspArbol = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mnuAnalisis = new javax.swing.JMenu();
        mnuLexico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(470, 491));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jspEditor.setMinimumSize(new java.awt.Dimension(0, 0));
        jspEditor.setPreferredSize(new java.awt.Dimension(0, 0));

        txtEditor.setColumns(20);
        txtEditor.setRows(5);
        txtEditor.setText("TOT=PRECIO+PRECIO*0.16-Cant/.34+AB-32*35;");
        txtEditor.setMinimumSize(new java.awt.Dimension(0, 0));
        jspEditor.setViewportView(txtEditor);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jspEditor, gridBagConstraints);

        tblTokens.setMinimumSize(new java.awt.Dimension(0, 0));
        tblTokens.setPreferredSize(new java.awt.Dimension(0, 0));

        jspToken.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

        }, new String[] { "TOKEN", "TIPO" }));
        tblTokens.setViewportView(jspToken);
        if (jspToken.getColumnModel().getColumnCount() > 0) {
            jspToken.getColumnModel().getColumn(1).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(tblTokens, gridBagConstraints);

        jspArbol.setMinimumSize(new java.awt.Dimension(0, 0));
        jspArbol.setPreferredSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jspArbol, gridBagConstraints);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        mnuAnalisis.setText("Análisis");

        mnuLexico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L,
                java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuLexico.setText("Léxico");
        mnuLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLexicoActionPerformed(evt);
            }
        });
        mnuAnalisis.add(mnuLexico);

        jMenuBar1.add(mnuAnalisis);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int esOP(String op) {
        String oP[] = { "=", "*", "/", "+", "-", ";" };
        for (int i = 0; i < oP.length; i++) {
            if (op.equals(oP[i]))
                return i;
        }
        return -1;
    }

    public int esPR(String pal) {
        String pR[] = { "inicio", "fin", "leer", "mostrar", "si", "sino", "mientras", "desde", "hasta" };
        for (int i = 0; i < pR.length; i++) {
            if (pal.equals(pR[i]))
                return i;
        }
        return -1;
    }

    private void mnuLexicoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mnuLexicoActionPerformed
        tabla.setRowCount(0);
        String cad = txtEditor.getText();
        String L[] = cad.split("\n");
        for (int i = 0; i < L.length; i++) {
            System.out.println(L[i]);
            getToken(L[i]);
        }
        construirArbol();
    }// GEN-LAST:event_mnuLexicoActionPerformed

    public void construirArbol() {
        try {
            a.clear();
            if (tabla.getValueAt(0, 1).toString().equals("Identificador")
                    && tabla.getValueAt(1, 0).toString().equals("=")
                    && tabla.getValueAt(tabla.getRowCount() - 1, 0).toString().equals(";")) {
                Nodo xd;
                a.agregar(tabla.getValueAt(0, 0).toString(),
                        xd = a.agregar(tabla.getValueAt(1, 0).toString(), null, true), true); // Agrega el identificador
                                                                                              // y el signo de igual
                int i;
                if ((i = buscarOperador()) != -1)
                    agregarNodo(xd, i, false,2,tabla.getRowCount()-2);
                else
                    a.agregar(tabla.getValueAt(2, 0).toString(), xd, false);
            }
        } catch (Exception e) {
        }
        super.repaint();
        // if (index + 2 < tabla.getRowCount())
        // if (tabla.getValueAt(index + 2, 0).toString().contains("1")
        // || tabla.getValueAt(index + 2, 0).toString().contains("2"))
        // a.agregar(tabla.getValueAt(index - 2, 0).toString(),
        // a.agregar(tabla.getValueAt(index, 0).toString(), null, true), true);
    }

    private void agregarNodo(Nodo xd, int i, boolean dir, int izq, int der) {
        int i2;
        Nodo nodo;
        xd = a.agregar(tabla.getValueAt(i, 0).toString(), xd, dir);
        if (i - 2 >= izq) {
            if ((i2 = detrasHayExpresión(i)) != -1) {
                nodo = a.agregar(tabla.getValueAt(i2, 0).toString(), xd, true);
                a.agregar(tabla.getValueAt(i2 + 1, 0).toString(), nodo, false);
                agregarNodo(nodo, i2 - 1, true, izq, i2 - 2);
            } else if ((i2 = detrasHayValor(i)) != -1) {
                nodo = a.agregar(tabla.getValueAt(i2, 0).toString(), xd, true);
                agregarNodo(nodo, i2 - 1, true, izq, i2 - 2);
            } else {
                agregarNodo(xd, i - 1, true, izq, i - 2);
            }
        } else if (i-1 >= izq){
            a.agregar(tabla.getValueAt(i - 1, 0).toString(), xd, true);
        }

        if (i + 2 <= der) {
            if ((i2 = delanteHayExpresion(i)) != -1) {
                nodo = a.agregar(tabla.getValueAt(i2, 0).toString(), xd, false);
                a.agregar(tabla.getValueAt(i2 - 1, 0).toString(), nodo, true);
                if (i2+2 <= der && (delanteHayExpresion(i2))!=-1)
                    agregarNodo(nodo, i2+2, false, i2+1, der);
                else
                    agregarNodo(nodo, i2 + 1, false, i2 + 2, der);
            } else if ((i2 = delanteHayValor(i)) != -1) {
                nodo = a.agregar(tabla.getValueAt(i2, 0).toString(), xd, false);
                agregarNodo(nodo, i2 + 1, false, i2 + 2, der);
            } else {
                agregarNodo(xd, i + 1, false, i + 2, der);
            }
        } else if (i + 1 <= der) {
            a.agregar(tabla.getValueAt(i + 1, 0).toString(), xd, false);
        }
    }

    public int delanteHayValor(int index) {
        int iA = index + 2;
        String token = tabla.getValueAt(iA, 1).toString();
        if (token.endsWith("3") || token.endsWith("4"))
            return iA - 1;
        return -1;
    }

    public int delanteHayExpresion(int index) {
        int iA = index + 2;
        String token = tabla.getValueAt(iA, 1).toString();
        if (token.endsWith("1") || token.endsWith("2"))
            return iA;
        return -1;
    }

    public int detrasHayValor(int index) {
        int iA = index - 2;
        String token = tabla.getValueAt(iA, 1).toString();
        if (token.endsWith("3") || token.endsWith("4"))
            return iA + 1;
        return -1;
    }

    public int detrasHayExpresión(int index) {
        int iA = index - 2;
        String token = tabla.getValueAt(iA, 1).toString();
        if (token.endsWith("1") || token.endsWith("2"))
            return iA;
        return -1;
    }

    public int buscarOperador() {
        for (int t = 1; t < 5; t += 2) {
            for (int index = 2; index < tabla.getRowCount() - 1; index++) {
                String v = tabla.getValueAt(index, 1).toString();
                if (!v.contains("Operador")) {
                    continue;
                }
                if ((v.endsWith("" + t) || v.endsWith("" + (t + 1)))) {
                    return index;
                }
            }
        }
        return -1;
    }

    // public void construirArbol() {
    // a.clear();
    // Nodo n = a.agregar(tabla.getValueAt(1, 0).toString(), null, true);
    // a.agregar(tabla.getValueAt(0, 0).toString(), n, true);
    // construirSubArbol(n, 0, tabla.getRowCount() - 2, false);
    // super.repaint();
    // }

    private void construirSubArbol(Nodo n, int izq, int der, boolean dir) {
        if (izq > der)
            return;
        if (n.getInfo().equalsIgnoreCase("="))
            for (int t = 1; t < 5; t += 2) {// For de las prioridades
                for (int index = izq; index <= der; index++) {// For del arreglo
                    String v = tabla.getValueAt(index, 1).toString();// Valor del token de la iteración (tipo)
                    if (!v.contains("Operador")) {// Pregunta si es un operador para continuar
                        continue;
                    }
                    if ((v.endsWith("" + t) || v.endsWith("" + (t + 1)))) {// Si el operador encontrado es de la
                                                                           // jerarquía
                        Nodo xd = a.agregar(tabla.getValueAt(index, 0).toString(), n, dir);// Agregamos el nodo y
                                                                                           // obtenemos su dirección
                        boolean hayIzq = !(index - 1 < izq), hayDer = !(index + 1 > der);
                        if (hayIzq) {// Si hay acceso a la izquierda
                            boolean detrasHayValor = !tabla.getValueAt(index - 2, 1).toString().endsWith("" + 1)
                                    && !tabla.getValueAt(index - 2, 1).toString().endsWith("" + 2);// Valor o expresión
                            if (detrasHayValor) {// Agrega el valor por la izquierda y agrega a la izquierda del mismo
                                                 // el signo que corresponde
                                Nodo xd3 = a.agregar(tabla.getValueAt(index - 1, 0).toString(), xd, true);
                                if (!(index - 2 < izq))
                                    construirSubArbol(a.agregar(tabla.getValueAt(index - 2, 0).toString(), xd3, true),
                                            izq, index - 3, true);
                            } else {// Agrega el operador y posteriormente los datos adyacentes
                                Nodo xd2 = a.agregar(tabla.getValueAt(index - 2, 0).toString(), xd, true);
                                construirSubArbol(xd2, izq, index - 3, true);
                                construirSubArbol(xd2, index - 1, index - 1, false);
                            }
                        }
                        if (hayDer) {
                            boolean delanteHayValor = !tabla.getValueAt(index + 2, 1).toString().endsWith("" + 1)
                                    && !tabla.getValueAt(index + 2, 1).toString().endsWith("" + 2);
                            if (delanteHayValor) {
                                Nodo xd3 = a.agregar(tabla.getValueAt(index + 1, 0).toString(), xd, false);
                                construirSubArbol(a.agregar(tabla.getValueAt(index + 2, 0).toString(), xd3, false),
                                        index + 3, der, false);
                            } else {
                                Nodo xd2 = a.agregar(tabla.getValueAt(index + 2, 0).toString(), xd, false);
                                construirSubArbol(xd2, index + 1, index + 1, true);
                                construirSubArbol(xd2, index + 3, der, false);
                            }
                        }
                        return;
                    }
                }
            }
        else
            for (int index = izq; index <= der; index++) {// For del arreglo
                String v = tabla.getValueAt(index, 1).toString();// Valor del token de la iteración (tipo)
                if (!v.contains("Operador")) {// Pregunta si es un operador para continuar
                    continue;
                }
                if (!v.endsWith("0") && !v.endsWith("5")) {// Si el operador encontrado es de la
                                                           // jerarquía
                    Nodo xd = a.agregar(tabla.getValueAt(index, 0).toString(), n, dir);// Agregamos el nodo y
                                                                                       // obtenemos su dirección
                    boolean hayIzq = !(index - 1 < izq), hayDer = !(index + 1 > der);
                    if (hayIzq) {// Si hay acceso a la izquierda
                        boolean detrasHayValor = !tabla.getValueAt(index - 2, 1).toString().endsWith("" + 1)
                                && !tabla.getValueAt(index - 2, 1).toString().endsWith("" + 2);// Valor o expresión
                        if (detrasHayValor) {// Agrega el valor por la izquierda y agrega a la izquierda del mismo
                                             // el signo que corresponde
                            Nodo xd3 = a.agregar(tabla.getValueAt(index - 1, 0).toString(), xd, true);
                            if (!(index - 2 < izq))
                                construirSubArbol(a.agregar(tabla.getValueAt(index - 2, 0).toString(), xd3, true), izq,
                                        index - 3, true);
                        } else {// Agrega el operador y posteriormente los datos adyacentes
                            Nodo xd2 = a.agregar(tabla.getValueAt(index - 2, 0).toString(), xd, true);
                            construirSubArbol(xd2, izq, index - 3, true);
                            construirSubArbol(xd2, index - 1, index - 1, false);
                        }
                    }
                    if (hayDer) {
                        boolean delanteHayValor = !tabla.getValueAt(index + 2, 1).toString().endsWith("" + 1)
                                && !tabla.getValueAt(index + 2, 1).toString().endsWith("" + 2);
                        if (delanteHayValor) {
                            Nodo xd3 = a.agregar(tabla.getValueAt(index + 1, 0).toString(), xd, false);
                            construirSubArbol(a.agregar(tabla.getValueAt(index + 2, 0).toString(), xd3, false),
                                    index + 3, der, false);
                        } else {
                            Nodo xd2 = a.agregar(tabla.getValueAt(index + 2, 0).toString(), xd, false);
                            construirSubArbol(xd2, index + 1, index + 1, true);
                            construirSubArbol(xd2, index + 3, der, false);
                        }
                    }
                    return;
                }
            }
        if (dir)
            a.agregar(tabla.getValueAt(der, 0).toString(), n, dir);
        else
            a.agregar(tabla.getValueAt(izq, 0).toString(), n, dir);
    }

    public void getToken(String cad) {// TOT=PRECIO+PRECIO*0.16;
        int op;
        if (cad.equals(""))
            return;
        for (int i = 0; i < cad.length(); i++) {
            if ((op = esOP(cad.charAt(i) + "")) != -1 || cad.charAt(i) == 32 || cad.charAt(i) == 10
                    || cad.charAt(i) == 13 || cad.charAt(i) == 9) {
                getToken(cad.substring(0, i));
                if (op != -1) {
                    tabla.addRow(new String[] { cad.charAt(i) + "", "Operador " + op });
                }
                try {
                    getToken(cad.substring(i + 1, cad.length()));
                } catch (Exception e) {
                }
                return;
            }
        }
        if (Grafos.esEntero(cad)) {
            tabla.addRow(new String[] { cad, "Entero" });
        } else if (Grafos.esFlotante(cad)) {
            tabla.addRow(new String[] { cad, "Flotante" });
        } else if (esPR(cad) != -1) {
            tabla.addRow(new String[] { cad, "Palabra Reservada" });
        } else if (Grafos.esIdentificador(cad)) {
            tabla.addRow(new String[] { cad, "Identificador" });
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    ArbolExpresionGrafico aGrafico;
    ArbolBinarioString a;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jspArbol;
    private javax.swing.JScrollPane jspEditor;
    private javax.swing.JTable jspToken;
    private javax.swing.JMenu mnuAnalisis;
    private javax.swing.JMenuItem mnuLexico;
    private javax.swing.JScrollPane tblTokens;
    private javax.swing.JTextArea txtEditor;
    // End of variables declaration//GEN-END:variables
    private javax.swing.table.DefaultTableModel tabla;
}

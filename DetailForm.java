
package Project3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 */
@SuppressWarnings("serial")
public class DetailForm extends javax.swing.JFrame {

    long id;
    /**
     * Creates new form DetailForm
     */
    public DetailForm() {
        initComponents();
    }
    
     private String scrap_data(String path) {
        StringBuffer response = new StringBuffer();
        try {
            //Search item
            String url = path;
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            @SuppressWarnings("unused")
			int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return response.toString();
    }
     
    public DetailForm(long id) {
        initComponents();
        
        this.id = id;
        String url = "http://search.3taps.com?auth_token=9f119f346c1825c7d2ce11e0a2703ac5&retvals=id,external_url,heading,timestamp,location,price,body,currency&id="+id;
        JSONObject jsonObj = new JSONObject(scrap_data(url));

        //Show result
        JSONArray msg = (JSONArray) jsonObj.get("postings");       
            
        JSONObject item = msg.getJSONObject(0);
        lbl_id.setText("Posting id: " + item.getLong("id"));
        lbl_title.setText(item.getString("heading"));
        
        JSONObject addr = item.getJSONObject("location");
        if (!addr.isNull("formatted_address")) 
            lbl_location.setText( "Location: " + addr.getString("formatted_address"));

        if(!item.isNull("price") && !item.isNull("currency"))
            lbl_price.setText("Price: " + item.getInt("price") + item.getString("currency"));
        
        lbl_date.setText("Time posted: " + (new Date(item.getLong("timestamp")*1000).toString()));
        
        txt_body.setText(item.getString("body"));
       
        /*
       JSONArray images = item.getJSONArray("images");       
       try{
            if(!images.isNull(0)){
                String key = images.getJSONObject(0).keySet().toArray()[0].toString();
                thumb_image.setIcon(new ImageIcon(images.getJSONObject(0).getString(key)));                      

                thumb_image.setOpaque(true);
                for(int i = 1; i < images.length(); i++){
                    key = images.getJSONObject(i).keySet().toArray()[0].toString();;
                    thumb_image.setIcon(new ImageIcon(images.getJSONObject(i).getString(key)));               
                }             
                
            }
            else{
                thumb_image.setText("No Image");
            }

         } catch(Exception e){}*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_id = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbl_location = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbl_title = new javax.swing.JTextArea();
        lbl_price = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_body = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("David");

        lbl_id.setText(" ");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl_location.setText("Location: ");

        lbl_title.setEditable(false);
        lbl_title.setBackground(new java.awt.Color(240, 240, 240));
        lbl_title.setColumns(20);
        lbl_title.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_title.setLineWrap(true);
        lbl_title.setRows(3);
        lbl_title.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportView(lbl_title);

        lbl_price.setText("Price: ");

        lbl_date.setText("Date Posted: ");

        txt_body.setColumns(50);
        txt_body.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_body.setLineWrap(true);
        txt_body.setRows(10);
        txt_body.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_location, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_location)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_price)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailForm().setVisible(true);
            }
        });
    }

    // Variables declaration 
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_location;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JTextArea lbl_title;
    private javax.swing.JTextArea txt_body;
    // End of variables declaration
}


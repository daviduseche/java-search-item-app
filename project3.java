

package Project3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;


public class Project3  extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObj;
    private String _url;

    
    public Project3() {
        initComponents();
        tbResult.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
                //Check you double click
                if (e.getClickCount() == 2) {
                    // Get row number and column number from table
                    int row = tbResult.rowAtPoint(e.getPoint());
                    int col = tbResult.columnAtPoint(e.getPoint());
                    
                    if (col == 3) { //check if you double-clicked on URL field
                        //Open web browser and redirect to the URL on the (row, col) of table
                        if (java.awt.Desktop.isDesktopSupported()) {
                            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                                try {
                                    desktop.browse(new java.net.URI(tbResult.getValueAt(row, col).toString()));
                                } catch (java.io.IOException | java.net.URISyntaxException exception) {
                                    exception.printStackTrace();
                                }
                            }
                        }
                    }
                    else if(col == 0){ //check if you double-clicked on Item_ID field
                        //Show Details Form
                        if(tbResult.getValueAt(row, col) != null )
                            new DetailForm(Long.parseLong(tbResult.getValueAt(row, col).toString())).setVisible(true);                       
                    }
                }
            }            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
   
    @SuppressWarnings("rawtypes")
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_item = new javax.swing.JLabel();
        txt_Item = new javax.swing.JTextField();
        lbl_zipcode = new javax.swing.JLabel();
        txt_Zipcode = new javax.swing.JTextField();
        lbl_radial_distance = new javax.swing.JLabel();
        txt_radial_distance = new javax.swing.JTextField();
        lb_milse = new javax.swing.JLabel();
        btn_Search = new javax.swing.JButton();
        lbl_error = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_zipcode1 = new javax.swing.JTextField();
        txt_zipcode2 = new javax.swing.JTextField();
        btn_get_distance = new javax.swing.JButton();
        txt_distance = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbResult = new javax.swing.JTable();
        pageCtrl = new javax.swing.JComboBox();
        lbl_page_Combo = new javax.swing.JLabel();
        btn_Go = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        lbl_Page = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("David");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_item.setText("Item");

        lbl_zipcode.setText("Zipcode");

        txt_Zipcode.setToolTipText("");

        lbl_radial_distance.setText("Radial Distance");

        lb_milse.setText("miles");

        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        lbl_error.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_item)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(lbl_zipcode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Search)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_Zipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(lbl_radial_distance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_radial_distance, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_milse))
                    .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_item, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_zipcode)
                        .addComponent(txt_Zipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_radial_distance)
                        .addComponent(txt_radial_distance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_milse)))
                .addGap(18, 18, 18)
                .addComponent(btn_Search)
                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setText("Zipcode 1");

        jLabel2.setText("Zipcode2");

        btn_get_distance.setText("Get Distance");
        btn_get_distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_get_distanceActionPerformed(evt);
            }
        });

        txt_distance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_distance.setText("Approx. Distance in mile");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_zipcode2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_zipcode1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_get_distance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_distance, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_zipcode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_get_distance))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_zipcode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_distance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setDoubleBuffered(true);

        tbResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item_ID", "Title", "Address", "URL", "Price", "Date"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            @SuppressWarnings({ "unchecked" })
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResult.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbResult.setRowHeight(24);
        jScrollPane2.setViewportView(tbResult);

        pageCtrl.setAutoscrolls(true);

        lbl_page_Combo.setText("page");
        lbl_page_Combo.setAutoscrolls(true);

        btn_Go.setText("Go");
        btn_Go.setAutoscrolls(true);
        btn_Go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GoActionPerformed(evt);
            }
        });

        lblResult.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblResult.setText(" ");

        lbl_Page.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("1. Double clicking on Item_ID will get you details page.                2. Double clicking on URL will bring you webpage.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lbl_page_Combo)
                        .addGap(18, 18, 18)
                        .addComponent(pageCtrl, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Go)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_Page, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Page, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pageCtrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Go)
                        .addComponent(lbl_page_Combo)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        pack();
    }

    private void btn_GoActionPerformed(java.awt.event.ActionEvent evt) {
        //   handling code here:
        if (jsonObj != null) {
            //Add page value to the url to fetch data of specified page number from craigslist.org
            String url = _url + "&page=" + ((Integer) pageCtrl.getSelectedItem() - 1);
            
            //Get the result and parse as JSON Object to manipulate result easily.
            jsonObj = new JSONObject(scrap_data(url));
            //Put the result on the table.
            show_result(jsonObj);
            lbl_Page.setText("Page " + pageCtrl.getSelectedItem());
        }
    }
    
    private String scrap_data(String path) { // Extract data from specified url
        StringBuffer response = new StringBuffer();
        try {
            //Search item
            String url = path;
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();  // Create connection with the server
            
            con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));  // Create reader to get data from server
            String inputLine;
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);  // read data line by line and append it to result
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return response.toString();
    }
    
  
    
    private void show_result(JSONObject jsonObj) {  //With JSON Object shows result on table
        
        JSONArray msg = (JSONArray) jsonObj.get("postings");  //search results are stored in "postings" parameter, so get the value of "postings" parameter
        
        int cnt = msg.length();
        for (int i = 0; i < cnt; i++) {
            
            JSONObject item = msg.getJSONObject(i);
            tbResult.setValueAt(item.getLong("id"), i, 0);           //get unique id that stored at craigslist.org
            tbResult.setValueAt(item.getString("heading"), i, 1);    //get the title of webpage that has item you are searching

            JSONObject addr = item.getJSONObject("location");    //get the address of webpage that has item you are searching
            if (!addr.isNull("formatted_address")) {           
                tbResult.setValueAt(addr.getString("formatted_address"), i, 2);
            }
            tbResult.setValueAt(item.getString("external_url"), i, 3);   //get the url address of webpage
            
            if(!item.isNull("price") && !item.isNull("currency"))  //get the price and currency
                tbResult.setValueAt(item.getInt("price") + item.getString("currency"), i, 4);
            
            tbResult.setValueAt(new Date(item.getLong("timestamp")*1000).toString(), i, 5); //get the posted date of the webpage
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
	private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed

        //Check input zipcode is incorrect or not
        Connection conn = null;
        Statement stmt = null;
        int correct_flag = 1;
        double latitude = 40.922326;
        double longitude = -72.637078;
        String state = "USA-NY|USA-NJ";  //state codes for New York and New Jersey
        
        lbl_error.setText(""); 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs370","dau","mypass");  //Connect MySql database

            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * from tb_location where zip_code='" + txt_Zipcode.getText() + "'";  //search zipcodes, longitudes and latitudes
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            if (rs.next()) {
                rs.getInt("zip_code");
                latitude = rs.getDouble("latitude");
                longitude = rs.getDouble("longitude");
                state = rs.getString("state");
                //Display values              
                correct_flag = 2;
            } else {
                correct_flag = 0;
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        if(correct_flag == 0)  //if there are is no zipcode
            if(!txt_Zipcode.getText().isEmpty())
                lbl_error.setText("Incorrect Zipcode.");        
        
        //basic url
        _url = "http://search.3taps.com?auth_token=9f119f346c1825c7d2ce11e0a2703ac5&source=CRAIG&retvals=id,external_url,heading,timestamp,location,price,currency&category_group=SSSS&rpp=50&heading=" + txt_Item.getText();

        //If no Radial Distance
        int radius = 0;
        if (!txt_radial_distance.getText().isEmpty()) {
            radius = Integer.valueOf(txt_radial_distance.getText());
        }
        
        if (radius == 0) { //if you do not enter radius distance, it will search items within New york and New jersy
            _url = "http://search.3taps.com?auth_token=9f119f346c1825c7d2ce11e0a2703ac5&source=CRAIG&retvals=id,external_url,heading,timestamp,location,price,currency&location.state=USA-" + state + "&category_group=SSSS&rpp=50&heading=" + txt_Item.getText();
        } else if (correct_flag == 2) { //if you enter radius distance, it will search items within the range you specified
            _url = "http://search.3taps.com?auth_token=9f119f346c1825c7d2ce11e0a2703ac5source=CRAIG&retvals=id,external_url,heading,timestamp,location,price,currency&lat=" + latitude + "&long=" + longitude + "&radius=" + radius + "mi&category_group=SSSS&rpp=50&heading=" + txt_Item.getText();
        }

        //Search item
        String url = _url;

        //Parsing result to java Object
        jsonObj = new JSONObject(scrap_data(url));
        //Show result
        show_result(jsonObj);

        //Show Total numbers of postings
        int total = jsonObj.getInt("num_matches");
        lblResult.setText("Search result: " + String.valueOf(total) + " found");
        
        //Page Navigation
        pageCtrl.removeAllItems();
        for (int i = 0; i < Math.ceil(total / 50); i++) {
            pageCtrl.addItem(i + 1);
        }
        
        lbl_Page.setText("Page 1");
    }

    private void btn_get_distanceActionPerformed(java.awt.event.ActionEvent evt) {
        int zipcode1 = 10001, zipcode2 = 10001;        
        double latitude1, longitude1, latitude2, longitude2;
        
        //Get two zipcodes from textbox you entered
        if (!txt_zipcode1.getText().isEmpty()) {
            zipcode1 = Integer.parseInt(txt_zipcode1.getText());
        }
        if (!txt_zipcode2.getText().isEmpty()) {
            zipcode2 = Integer.parseInt(txt_zipcode2.getText());
        }
        
        //Using google map api, get latitudes and longitudes for two zipcodes.
        String link = "http://maps.googleapis.com/maps/api/geocode/json?components=postal_code:" + zipcode1 + "&sensor=false";
        String data = scrap_data(link);
        JSONObject json = new JSONObject(data);
        JSONObject obj = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
        
        latitude1 = obj.getDouble("lat");
        longitude1 = obj.getDouble("lng");
        
        link = "http://maps.googleapis.com/maps/api/geocode/json?components=postal_code:" + zipcode2 + "&sensor=false";
        data = scrap_data(link);
        json = new JSONObject(data);
        obj = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
        
        latitude2 = obj.getDouble("lat");
        longitude2 = obj.getDouble("lng");        
        
        //calculate distance using haversine formula
        double distance = 7926.3352 * Math.asin(Math.sqrt(haversin(latitude2 - latitude1) + Math.cos(latitude1 * 3.141597 / 180) * Math.cos(latitude2 * 3.141597 / 180) * haversin(longitude2 - longitude1)));
        txt_distance.setText(String.valueOf(distance));
    }//GEN-LAST:event_btn_get_distanceActionPerformed
    
    private double haversin(double alpha) {
        return (1 - Math.cos(alpha * 3.141597 / 180)) / 2;
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
            java.util.logging.Logger.getLogger(Project3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Project3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Project3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Project3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project3().setVisible(true);
                
            }
        });
    }

    // Variables declaration 
    private javax.swing.JButton btn_Go;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_get_distance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_milse;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lbl_Page;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_item;
    private javax.swing.JLabel lbl_page_Combo;
    private javax.swing.JLabel lbl_radial_distance;
    private javax.swing.JLabel lbl_zipcode;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox pageCtrl;
    private javax.swing.JTable tbResult;
    private javax.swing.JTextField txt_Item;
    private javax.swing.JTextField txt_Zipcode;
    private javax.swing.JTextField txt_distance;
    private javax.swing.JTextField txt_radial_distance;
    private javax.swing.JTextField txt_zipcode1;
    private javax.swing.JTextField txt_zipcode2;
    // End of variables declaration
}

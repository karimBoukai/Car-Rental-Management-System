package carrentalmanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Label username;

    @FXML
    private Button home_btn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button availableCars_btn;

    @FXML
    private Button rentCar_btn;

    @FXML
    private Button dashboard_refreshBtn;

    @FXML
    private Button dashboard_resetBtn;

    @FXML
    private Label home_availableCars;

    @FXML
    private Label home_totalIncome;

    @FXML
    private Label home_totalCustomers;

    @FXML
    private BarChart<?, ?> home_incomeChart;

    @FXML
    private LineChart<?, ?> home_customerChart;

    @FXML
    private AnchorPane availableCars_form;

    @FXML
    private TextField availableCars_carId;

    @FXML
    private TextField availableCars_brand;

    @FXML
    private TextField availableCars_model;

    @FXML
    private ComboBox<?> availableCars_status;

    @FXML
    private ImageView availableCars_imageView;

    @FXML
    private Button availableCars_importBtn;

    @FXML
    private Button availableCars_insertBtn;

    @FXML
    private Button availableCars_updateBtn;

    @FXML
    private Button availableCars_deleteBtn;

    @FXML
    private Button availableCars_clearBtn;

    @FXML
    private TextField availableCars_price;

    @FXML
    private TableView<carData> availableCars_tableView;

    @FXML
    private TableColumn<carData, String> availableCars_col_carId;

    @FXML
    private TableColumn<carData, String> availableCars_col_brand;

    @FXML
    private TableColumn<carData, String> availableCars_col_model;

    @FXML
    private TableColumn<carData, String> availableCars_col_price;

    @FXML
    private TableColumn<carData, String> availableCars_col_status;

    @FXML
    private TextField availableCars_search;

    @FXML
    private Button availableCars_refreshBtn;

    @FXML
    private Button availableCars_exportBtn;

    @FXML
    private AnchorPane rent_form;

    @FXML
    private ComboBox<?> rent_carId;

    @FXML
    private ComboBox<?> rent_brand;

    @FXML
    private ComboBox<?> rent_model;

    @FXML
    private TextField rent_firstName;

    @FXML
    private TextField rent_lastName;

    @FXML
    private ComboBox<?> rent_gender;

    @FXML
    private DatePicker rent_dateRented;

    @FXML
    private DatePicker rent_dateReturn;

    @FXML
    private Button rentBtn;

    @FXML
    private Button rent_clearBtn;

    @FXML
    private Button rent_refreshBtn;

    @FXML
    private Label rent_total;

    @FXML
    private TextField rent_amount;

    @FXML
    private Label rent_balance;

    @FXML
    private AnchorPane home_form;

    @FXML
    private TableView<carData> rent_tableView;

    @FXML
    private TableColumn<carData, String> rent_col_carId;

    @FXML
    private TableColumn<carData, String> rent_col_brand;

    @FXML
    private TableColumn<carData, String> rent_col_model;

    @FXML
    private TableColumn<carData, String> rent_col_price;

    @FXML
    private TableColumn<carData, String> rent_col_status;

//    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private Image image;

    public void homeAvailableCars(){
        
        String sql = "SELECT COUNT(id) FROM car WHERE status = 'Available'";
        
        connect = database.connectDb();
        int countAC = 0;
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countAC = result.getInt("COUNT(id)");
            }
            
            home_availableCars.setText(String.valueOf(countAC));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void homeTotalIncome(){
        String sql = "SELECT SUM(total) FROM customer";
        
        double sumIncome = 0;
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                sumIncome = result.getDouble("SUM(total)");
            }
            home_totalIncome.setText("$" + String.valueOf(sumIncome));
        }catch(Exception e){e.printStackTrace();}
    }
    
    
    public void homeTotalCustomers(){
        
        String sql = "SELECT COUNT(id) FROM customer";
        
        int countTC = 0;
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countTC = result.getInt("COUNT(id)");
            }
            home_totalCustomers.setText(String.valueOf(countTC));
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void homeIncomeChart(){
        
        home_incomeChart.getData().clear();
        
        ensureCustomerRentedByColumn();

        String sql = "SELECT id, date_rented, total, rented_by FROM ("
                + "SELECT id, date_rented, total, COALESCE(rented_by, 'admin') AS rented_by "
                + "FROM customer ORDER BY id DESC LIMIT 8"
                + ") recent_sales ORDER BY id ASC";
        
        connect = database.connectDb();
        
        try{
            XYChart.Series chart = new XYChart.Series();
            chart.setName("Recent Sales");
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                String label = result.getString("date_rented") + " #" + result.getInt("id");
                XYChart.Data data = new XYChart.Data(label, result.getDouble("total"));
                data.setExtraValue(result.getString("rented_by"));
                chart.getData().add(data);
            }
            
            home_incomeChart.getData().add(chart);
            applyIncomeChartColor();
            
        }catch(Exception e){e.printStackTrace();}
    }
//    }THAT IS IT FOR THIS VIDEO, THANKS FOR WATCHING! 
//     DONT FORGET TO SUBSCRIBE OUR CHANNEL FOR MORE UNIQUE TUTORIALS : ) 
//     THANKS FOR THE SUPPORT GUYS!
    
    
    public void homeCustomerChart(){
        home_customerChart.getData().clear();
        
        String sql = "SELECT date_rented, COUNT(id) FROM customer GROUP BY date_rented ORDER BY TIMESTAMP(date_rented) ASC LIMIT 4";
        
        connect = database.connectDb();
        
        try{
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            home_customerChart.getData().add(chart);
            applyCustomerChartColor();
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void availableCarAdd() {

        String sql = "INSERT INTO car (car_id, brand, model, price, status, image, date) "
                + "VALUES(?,?,?,?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (availableCars_carId.getText().isEmpty()
                    || availableCars_brand.getText().isEmpty()
                    || availableCars_model.getText().isEmpty()
                    || availableCars_status.getSelectionModel().getSelectedItem() == null
                    || availableCars_price.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, availableCars_carId.getText());
                prepare.setString(2, availableCars_brand.getText());
                prepare.setString(3, availableCars_model.getText());
                prepare.setString(4, availableCars_price.getText());
                prepare.setString(5, (String) availableCars_status.getSelectionModel().getSelectedItem());

                String uri = getData.path;
                uri = uri.replace("\\", "\\\\");

                prepare.setString(6, uri);

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                prepare.setString(7, String.valueOf(sqlDate));

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                availableCarShowListData();
                availableCarClear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCarUpdate() {

        String uri = getData.path == null ? "" : getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE car SET brand = '" + availableCars_brand.getText() + "', model = '"
                + availableCars_model.getText() + "', status ='"
                + availableCars_status.getSelectionModel().getSelectedItem() + "', price = '"
                + availableCars_price.getText() + "', image = '" + uri
                + "' WHERE car_id = '" + availableCars_carId.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (availableCars_carId.getText().isEmpty()
                    || availableCars_brand.getText().isEmpty()
                    || availableCars_model.getText().isEmpty()
                    || availableCars_status.getSelectionModel().getSelectedItem() == null
                    || availableCars_price.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Car ID: " + availableCars_carId.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    availableCarShowListData();
                    availableCarClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCarDelete() {

        String sql = "DELETE FROM car WHERE car_id = '" + availableCars_carId.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (availableCars_carId.getText().isEmpty()
                    || availableCars_brand.getText().isEmpty()
                    || availableCars_model.getText().isEmpty()
                    || availableCars_status.getSelectionModel().getSelectedItem() == null
                    || availableCars_price.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Car ID: " + availableCars_carId.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    availableCarShowListData();
                    availableCarClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCarClear() {
        availableCars_carId.setText("");
        availableCars_brand.setText("");
        availableCars_model.setText("");
        availableCars_status.getSelectionModel().clearSelection();
        availableCars_price.setText("");

        getData.path = "";

        availableCars_imageView.setImage(null);

    }

    private String[] listStatus = {"Available", "Not Available"};

    public void availableCarStatusList() {

        List<String> listS = new ArrayList<>();

        for (String data : listStatus) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        availableCars_status.setItems(listData);
    }

    public void availableCarImportImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*.jpg", "*.jpeg", "*.png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            getData.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 116, 153, false, true);
            availableCars_imageView.setImage(image);

        }

    }

    public ObservableList<carData> availableCarListData() {

        ObservableList<carData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM car";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            carData carD;

            while (result.next()) {
                carD = new carData(result.getInt("car_id"),
                         result.getString("brand"),
                         result.getString("model"),
                         result.getDouble("price"),
                         result.getString("status"),
                         result.getString("image"),
                         result.getDate("date"));

                listData.add(carD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<carData> availableCarList;

    public void availableCarShowListData() {
        availableCarList = availableCarListData();

        availableCars_col_carId.setCellValueFactory(new PropertyValueFactory<>("carId"));
        availableCars_col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        availableCars_col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        availableCars_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        availableCars_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        availableCars_tableView.setItems(availableCarList);
    }

    public void availableCarRefresh() {
        availableCarShowListData();
        availableCarStatusList();
        availableCarSearch();
        homeAvailableCars();
    }

    public void availableCarExport() {
        if (availableCars_tableView.getItems() == null || availableCars_tableView.getItems().isEmpty()) {
            showAlert(AlertType.ERROR, "No cars are available to export.");
            return;
        }

        FileChooser save = new FileChooser();
        save.setTitle("Export Car List");
        save.setInitialFileName("cars.csv");
        save.getExtensionFilters().add(new ExtensionFilter("CSV File", "*.csv"));

        File file = save.showSaveDialog(main_form.getScene().getWindow());
        if (file == null) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("Car ID,Brand,Model,Price,Status");
            for (carData car : availableCars_tableView.getItems()) {
                writer.printf("%s,%s,%s,%s,%s%n",
                        csv(car.getCarId()),
                        csv(car.getBrand()),
                        csv(car.getModel()),
                        csv(car.getPrice()),
                        csv(car.getStatus()));
            }
            showAlert(AlertType.INFORMATION, "Car list exported successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Unable to export the car list.");
        }
    }

    public void availableCarSearch() {

        FilteredList<carData> filter = new FilteredList<>(availableCarList, e -> true);

        availableCars_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateCarData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCarData.getCarId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getBrand().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getModel().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<carData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(availableCars_tableView.comparatorProperty());
        availableCars_tableView.setItems(sortList);

    }

    public void availableCarSelect() {
        carData carD = availableCars_tableView.getSelectionModel().getSelectedItem();
        int num = availableCars_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < - 1) {
            return;
        }

        availableCars_carId.setText(String.valueOf(carD.getCarId()));
        availableCars_brand.setText(carD.getBrand());
        availableCars_model.setText(carD.getModel());
        availableCars_price.setText(String.valueOf(carD.getPrice()));
        availableCars_status.getSelectionModel().select(listSIndex(carD.getStatus()));

        getData.path = carD.getImage();

        String uri = "file:" + carD.getImage();

        image = new Image(uri, 116, 153, false, true);
        availableCars_imageView.setImage(image);

    }
    
    public void rentPay(){
        rentCustomerId();
        ensureCustomerRentedByColumn();
        
        String sql = "INSERT INTO customer "
                + "(customer_id, firstName, lastName, gender, car_id, brand"
                + ", model, total, date_rented, date_return, rented_by) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        connect = database.connectDb();
        
        try{
            Alert alert;
            
            if(rent_firstName.getText().isEmpty()
                    || rent_lastName.getText().isEmpty()
                    || rent_gender.getSelectionModel().getSelectedItem() == null
                    || rent_carId.getSelectionModel().getSelectedItem() == null
                    || rent_brand.getSelectionModel().getSelectedItem() == null
                    || rent_model.getSelectionModel().getSelectedItem() == null
                    || totalP == 0 || rent_amount.getText().isEmpty()
                    || !updateRentBalance(true)){
                showAlert(AlertType.ERROR, "Please complete customer, car, date, total, and payment details.");
            }else{
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(customerId));
                    prepare.setString(2, rent_firstName.getText());
                    prepare.setString(3, rent_lastName.getText());
                    prepare.setString(4, (String)rent_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(5, (String)rent_carId.getSelectionModel().getSelectedItem());
                    prepare.setString(6, (String)rent_brand.getSelectionModel().getSelectedItem());
                    prepare.setString(7, (String)rent_model.getSelectionModel().getSelectedItem());
                    prepare.setString(8, String.valueOf(totalP));
                    prepare.setString(9, String.valueOf(rent_dateRented.getValue()));
                    prepare.setString(10, String.valueOf(rent_dateReturn.getValue()));
                    prepare.setString(11, getData.username);

                    prepare.executeUpdate();
                    
                    // SET THE  STATUS OF CAR TO NOT AVAILABLE 
                    String updateCar = "UPDATE car SET status = 'Not Available' WHERE car_id = '"
                            +rent_carId.getSelectionModel().getSelectedItem()+"'";
                    
                    statement = connect.createStatement();
                    statement.executeUpdate(updateCar);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Rental completed successfully.");
                    alert.showAndWait();
                    
                    rentCarShowListData();
                    homeAvailableCars();
                    homeTotalIncome();
                    homeTotalCustomers();
                    
                    rentClear();
                } // NOW LETS PROCEED TO DASHBOARD FORM : ) 
            }
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void rentClear(){
        totalP = 0;
        rent_firstName.setText("");
        rent_lastName.setText("");
        rent_gender.getSelectionModel().clearSelection();
        amount = 0;
        balance = 0;
        rent_balance.setText("$0.0");
        rent_total.setText("$0.0");
        rent_amount.setText("");
        rent_carId.getSelectionModel().clearSelection();
        rent_brand.getSelectionModel().clearSelection();
        rent_model.getSelectionModel().clearSelection();
        rent_dateRented.setValue(null);
        rent_dateReturn.setValue(null);
    }
    
    private int customerId;
    public void rentCustomerId(){
        String sql = "SELECT id FROM customer";
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                // GET THE LAST id and add + 1
                customerId = result.getInt("id") + 1;
            }
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    private double amount;
    private double balance;
    public void rentAmount(){
        updateRentBalance(true);
    }

    private boolean updateRentBalance(boolean showErrors) {
        if(totalP == 0 || rent_amount.getText().isEmpty()){
            amount = 0;
            balance = 0;
            rent_balance.setText("$0.0");
            if (showErrors) {
                showAlert(AlertType.ERROR, "Calculate the rental total and enter the amount paid.");
            }
            return false;
        }

        try {
            amount = Double.parseDouble(rent_amount.getText());
        } catch (NumberFormatException e) {
            amount = 0;
            balance = 0;
            rent_balance.setText("$0.0");
            if (showErrors) {
                showAlert(AlertType.ERROR, "Amount must be a valid number.");
            }
            return false;
        }

        if(amount >= totalP){
            balance = (amount - totalP);
            rent_balance.setText("$" + String.valueOf(balance));
            return true;
        } else {
            balance = 0;
            rent_balance.setText("$0.0");
            if (showErrors) {
                showAlert(AlertType.ERROR, "Amount paid must be greater than or equal to the total.");
            }
            return false;
        }
    }

    public ObservableList<carData> rentCarListData() {

        ObservableList<carData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM car";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            carData carD;

            while (result.next()) {
                carD = new carData(result.getInt("car_id"), result.getString("brand"),
                         result.getString("model"), result.getDouble("price"),
                         result.getString("status"),
                         result.getString("image"),
                         result.getDate("date"));

                listData.add(carD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    private int countDate;
    public void rentDate(){
        Alert alert;
        if(rent_carId.getSelectionModel().getSelectedItem() == null
                || rent_brand.getSelectionModel().getSelectedItem() == null
                || rent_model.getSelectionModel().getSelectedItem() == null){
            showAlert(AlertType.ERROR, "Choose a car before selecting rental dates.");
            
            rent_dateRented.setValue(null);
            rent_dateReturn.setValue(null);
            
        } else if (rent_dateRented.getValue() == null || rent_dateReturn.getValue() == null) {
            showAlert(AlertType.ERROR, "Choose both rented and return dates.");
        }else{
            
            if(rent_dateReturn.getValue().isAfter(rent_dateRented.getValue())){
                // COUNT THE DAY
                countDate = rent_dateReturn.getValue().compareTo(rent_dateRented.getValue());
            }else{
                showAlert(AlertType.ERROR, "Return date must be after rented date.");
                // INCREASE OF 1 DAY ONCE THE USER CLICKED THE SAME DAY 
                rent_dateReturn.setValue(rent_dateRented.getValue().plusDays(1));
                
            }
        }
    }
    
    private double totalP;
    public void rentDisplayTotal(){
        rentDate();
        if (rent_dateRented.getValue() == null || rent_dateReturn.getValue() == null) {
            return;
        }
        double price = 0;
        String sql = "SELECT price, model FROM car WHERE model = '"
                +rent_model.getSelectionModel().getSelectedItem()+"'";
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()){
                price = result.getDouble("price");
            }
            // price * the count day you want to use the car
            totalP = (price * countDate);
            // DISPLAY TOTAL
            rent_total.setText("$" + String.valueOf(totalP));
            updateRentBalance(false);
            
        }catch(Exception e){e.printStackTrace();}
        
    }

    public void rentQuickDates() {
        LocalDate today = LocalDate.now();
        rent_dateRented.setValue(today);
        rent_dateReturn.setValue(today.plusDays(1));
        if (rent_model.getSelectionModel().getSelectedItem() != null) {
            rentDisplayTotal();
        }
    }

    public void rentRefresh() {
        rentCarShowListData();
        rentCarCarId();
        rentCarBrand();
        rentCarModel();
        rentCarGender();
    }

    private String[] genderList = {"Male", "Female", "Others"};

    public void rentCarGender() {

        List<String> listG = new ArrayList<>();

        for (String data : genderList) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);

        rent_gender.setItems(listData);

    }

    public void rentCarCarId() {

        String sql = "SELECT * FROM car WHERE status = 'Available'";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("car_id"));
            }

            rent_carId.setItems(listData);

            rentCarBrand();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void rentCarBrand() {

        String sql = "SELECT * FROM car WHERE car_id = '"
                + rent_carId.getSelectionModel().getSelectedItem() + "'";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("brand"));
            }

            rent_brand.setItems(listData);

            rentCarModel();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void rentCarModel() {

        String sql = "SELECT * FROM car WHERE brand = '"
                + rent_brand.getSelectionModel().getSelectedItem() + "'";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("model"));
            }

            rent_model.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ObservableList<carData> rentCarList;

    public void rentCarShowListData() {
        rentCarList = rentCarListData();

        rent_col_carId.setCellValueFactory(new PropertyValueFactory<>("carId"));
        rent_col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        rent_col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        rent_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        rent_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        rent_tableView.setItems(rentCarList);
    }

    public void displayUsername() {
        String user = getData.username;
        // TO SET THE FIRST LETTER TO BIG LETTER
        username.setText(user.substring(0, 1).toUpperCase() + user.substring(1));

    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {
                // HIDE YOUR DASHBOARD FORM
                logoutBtn.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            availableCars_form.setVisible(false);
            rent_form.setVisible(false);

            setActiveNav(home_btn);

            homeAvailableCars();
            homeTotalIncome();
            homeTotalCustomers();
            homeIncomeChart();
            homeCustomerChart();
            
        } else if (event.getSource() == availableCars_btn) {
            home_form.setVisible(false);
            availableCars_form.setVisible(true);
            rent_form.setVisible(false);

            setActiveNav(availableCars_btn);

            // TO UPDATE YOUR TABLEVIEW ONCE YOU CLICK THE AVAILABLE CAR NAV BUTTON
            availableCarShowListData();
            availableCarStatusList();
            availableCarSearch();

        } else if (event.getSource() == rentCar_btn) {
            home_form.setVisible(false);
            availableCars_form.setVisible(false);
            rent_form.setVisible(true);

            setActiveNav(rentCar_btn);

            rentCarShowListData();
            rentCarCarId();
            rentCarBrand();
            rentCarModel();
            rentCarGender();

        }

    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void dashboardRefresh() {
        homeAvailableCars();
        homeTotalIncome();
        homeTotalCustomers();
        homeIncomeChart();
        homeCustomerChart();
        availableCarShowListData();
        rentCarShowListData();
        showAlert(AlertType.INFORMATION, "Dashboard data refreshed.");
    }

    public void dashboardReset() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Reset Dashboard");
        alert.setHeaderText(null);
        alert.setContentText("This will remove all rental/customer sales data and set all cars back to Available. Continue?");
        Optional<ButtonType> option = alert.showAndWait();

        if (!option.isPresent() || !option.get().equals(ButtonType.OK)) {
            return;
        }

        connect = database.connectDb();

        try {
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM customer");
            statement.executeUpdate("UPDATE car SET status = 'Available'");

            rentClear();
            dashboardRefreshWithoutAlert();
            rentCarCarId();
            availableCarShowListData();
            rentCarShowListData();

            showAlert(AlertType.INFORMATION, "Dashboard overview has been reset to zero.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Unable to reset the dashboard overview.");
        }
    }

    private void dashboardRefreshWithoutAlert() {
        homeAvailableCars();
        homeTotalIncome();
        homeTotalCustomers();
        homeIncomeChart();
        homeCustomerChart();
    }

    private void setActiveNav(Button activeButton) {
        Button[] buttons = {home_btn, availableCars_btn, rentCar_btn};
        for (Button button : buttons) {
            button.getStyleClass().remove("nav-btn-active");
            if (!button.getStyleClass().contains("nav-btn")) {
                button.getStyleClass().add("nav-btn");
            }
        }
        if (!activeButton.getStyleClass().contains("nav-btn-active")) {
            activeButton.getStyleClass().add("nav-btn-active");
        }
    }

    private void showAlert(AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void applyIncomeChartColor() {
        Platform.runLater(() -> {
            for (Object seriesObj : home_incomeChart.getData()) {
                XYChart.Series series = (XYChart.Series) seriesObj;
                for (Object dataObj : series.getData()) {
                    XYChart.Data data = (XYChart.Data) dataObj;
                    Node bar = data.getNode();
                    if (bar != null) {
                        String owner = String.valueOf(data.getExtraValue());
                        String saleLabel = String.valueOf(data.getXValue());
                        String saleTotal = String.valueOf(data.getYValue());
                        bar.setStyle("-fx-bar-fill: " + userIncomeColor(owner) + ";");
                        Tooltip.install(bar, new Tooltip("Click to view sale details"));
                        bar.setOnMouseClicked(event -> showAlert(AlertType.INFORMATION,
                                "Date/Sale: " + saleLabel
                                + "\nUser: " + displaySaleOwner(owner)
                                + "\nTotal: $" + saleTotal));
                    }
                }
            }
        });
    }

    private void applyCustomerChartColor() {
        Platform.runLater(() -> {
            for (Node line : home_customerChart.lookupAll(".chart-series-line")) {
                line.setStyle("-fx-stroke: #111827; -fx-stroke-width: 3px;");
            }
            for (Node symbol : home_customerChart.lookupAll(".chart-line-symbol")) {
                symbol.setStyle("-fx-background-color: #111827, #111827;");
            }
        });
    }

    private String userIncomeColor(String username) {
        String user = username == null ? "" : username.trim().toLowerCase();

        if ("admin".equals(user)) {
            return "#f97316";
        } else if ("superadmin".equals(user)) {
            return "#2563eb";
        } else if ("manager".equals(user) || "maniger".equals(user)) {
            return "#16a34a";
        }

        return "#0f766e";
    }

    private String displaySaleOwner(String username) {
        String user = username == null ? "" : username.trim().toLowerCase();

        if ("admin".equals(user)) {
            return "Admin";
        } else if ("superadmin".equals(user)) {
            return "Super Admin";
        } else if ("manager".equals(user) || "maniger".equals(user)) {
            return "Manager";
        }

        return username == null || username.trim().isEmpty() ? "Unknown" : username;
    }

    private void ensureCustomerRentedByColumn() {
        connect = database.connectDb();

        try {
            String checkSql = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS "
                    + "WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'customer' AND COLUMN_NAME = 'rented_by'";
            prepare = connect.prepareStatement(checkSql);
            result = prepare.executeQuery();

            if (result.next() && result.getInt(1) == 0) {
                statement = connect.createStatement();
                statement.executeUpdate("ALTER TABLE customer ADD COLUMN rented_by VARCHAR(50) DEFAULT 'admin'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String csv(Object value) {
        String text = value == null ? "" : String.valueOf(value);
        return "\"" + text.replace("\"", "\"\"") + "\"";
    }

    private int listSIndex(String value) {
        for (int i = 0; i < listStatus.length; i++) {
            if (listStatus[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();

        homeAvailableCars();
        homeTotalIncome();
        homeTotalCustomers();
        homeIncomeChart();
        homeCustomerChart();
        
        
        // TO DISPLAY THE DATA ON THE TABLEVIEW
        availableCarShowListData();
        availableCarStatusList();
        availableCarSearch();

        rentCarShowListData();
        rentCarCarId();
        rentCarBrand();
        rentCarModel();
        rentCarGender();
        rent_amount.textProperty().addListener((observable, oldValue, newValue) -> updateRentBalance(false));
        setActiveNav(home_btn);

    }

}

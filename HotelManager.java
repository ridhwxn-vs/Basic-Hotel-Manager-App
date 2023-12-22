import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.control.*;
import javafx.scene.text.Font.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*; 
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.scene.control.Alert.*;
import javafx.scene.input.MouseEvent;
class Hotel
{
    static String Name;
    static String OperatorName;
    static int Rooms;
    static int CurrentOccupancy;
    Hotel()
    {
        Name=null;
        OperatorName=null;
        Rooms=0;
    }
    Hotel(String N,String O,int R)
    {
        Name=N;
        OperatorName=O;
        Rooms=R;
        CurrentOccupancy=0;
    }
}
class Room extends Hotel
{
    int RoomNumber;
    String RoomType;
    boolean Occupancy;
    String GuestName;
    //int RoomIndex;
    public Room(int i)
    {
        RoomNumber=i+1;
        RoomType="Not Specified";
        Occupancy=false;
        GuestName="";
    }
    String getOccupancy()
    {
        if (Occupancy)
            return("Occupied.");
        return("Unoccupied.");
    }
}
public class HotelManager extends Application
{
    public static void main(String args[])
    {
        launch(args);
    }
    public void start(Stage mainStage) throws FileNotFoundException 
    {
        Hotel H=new Hotel();
        Room R[]=new Room[100];
        for (int i=0;i<100;i++)
        {
            R[i]=new Room(i);
        }
        List<String> BookedList = new ArrayList<>();
        List<String> ReqsList = new ArrayList<>();    
        mainStage.setTitle("Hotel Manager");
        GridPane rootNode=new GridPane();
        rootNode.setVgap(10); 
        rootNode.setHgap(0);
        rootNode.setAlignment(Pos.CENTER);
        Label Welcome=new Label();
        Label Hname=new Label();
        Scene mainScene=new Scene(rootNode,615,624);
        mainStage.setScene(mainScene);
        Label Occupied=new Label();
        TextField OccuTF=new TextField();
        Label nl1=new Label("\n\n");
        Label UnOccupied=new Label();
        TextField UnOccuTF=new TextField();
        ListView<String> RequestListMain = new ListView<String>();
        ObservableList<String> reqs =FXCollections.observableArrayList (ReqsList);
        RequestListMain.setItems(reqs);
        RequestListMain.setMinWidth(167);
        RequestListMain.setMaxHeight(120);
        Button ManageBT=new Button("Manage\nBookings");
        Button RequestBT=new Button("Manage\nRequests");
        Button SettingsBT=new Button("Settings");
        Button NewBooking=new Button("NEW BOOKING");
        Occupied.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,18));
        nl1.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,5));
        Welcome.setFont(Font.font("Calibri",FontWeight.BOLD,15));
        Welcome.setText("WELCOME !");
        Hname.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,18));
        Hname.setText("PLEASE REGISTER\nHOTEL FROM SETTINGS");
        Welcome.setTextAlignment(TextAlignment.CENTER);
        Hname.setTextAlignment(TextAlignment.CENTER);
        Occupied.setTextAlignment(TextAlignment.CENTER);
        UnOccupied.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,18));
        UnOccupied.setTextAlignment(TextAlignment.CENTER);
        ManageBT.setPrefWidth(100);
        RequestBT.setPrefWidth(100);
        SettingsBT.setPrefWidth(100);
        ManageBT.setPrefHeight(60);
        RequestBT.setPrefHeight(60);
        SettingsBT.setPrefHeight(60);
        ManageBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        RequestBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        SettingsBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        NewBooking.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        NewBooking.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,12));
        Image image6 = new Image(new FileInputStream("Graphics/Footer Left Main.png"));
        Image image7 = new Image(new FileInputStream("Graphics/Footer Right Main.png"));
        Image image8 = new Image(new FileInputStream("Graphics/Footer Mid Main.png"));
        Image image1 = new Image(new FileInputStream("Graphics/Footer Left.png"));
        ImageView FooterLeftMain = new ImageView(image6);
        Image image2 = new Image(new FileInputStream("Graphics/Footer Mid.png"));
        ImageView FooterMidMain = new ImageView(image8);
        Image image3 = new Image(new FileInputStream("Graphics/Footer Right.png"));
        ImageView FooterRightMain = new ImageView(image7);
        Image title = new Image(new FileInputStream("Graphics/Title Main.png"));
        ImageView TitleMain = new ImageView(title);
        Image image4 = new Image(new FileInputStream("Graphics/Header Right.png"));
        ImageView HeaderRightMain = new ImageView(image4);
        Image image5 = new Image(new FileInputStream("Graphics/Header Left.png"));
        ImageView HeaderLeftMain = new ImageView(image5);
        Image Editbtn = new Image(new FileInputStream("Graphics/Edit BTN.png"));
        Image OccuImg = new Image(new FileInputStream("Graphics/Occupied.png"));
        Image UnoccuImg = new Image(new FileInputStream("Graphics/Unoccupied.png"));
        ImageView OccupiedImage = new ImageView(OccuImg);
        ImageView UnOccupiedImage = new ImageView(UnoccuImg);
        Image PendingImg = new Image(new FileInputStream("Graphics/Pending Request.png"));
        ImageView PendingImage = new ImageView(PendingImg);
        Occupied.setText(Integer.toString(H.CurrentOccupancy));
        UnOccupied.setText(Integer.toString(H.Rooms-H.CurrentOccupancy));
        rootNode.add(TitleMain, 1,0); 
        rootNode.add(HeaderRightMain, 2,0);
        rootNode.add(HeaderLeftMain, 0,0);
        rootNode.add(Welcome, 1,1);
        rootNode.add(Hname, 1,2);
        //rootNode.add(nl1, 1,3);
        rootNode.add(OccupiedImage, 0,4); 
        rootNode.add(Occupied, 0,5);  
        rootNode.add(NewBooking, 1,4);
        rootNode.add(UnOccupiedImage, 2,4); 
        rootNode.add(UnOccupied, 2,5);
        rootNode.add(PendingImage, 1,7);
        rootNode.add(RequestListMain, 1,8);
        rootNode.add(ManageBT, 0,9);
        rootNode.add(RequestBT, 1,9);
        rootNode.add(SettingsBT, 2,9);
        rootNode.add(FooterLeftMain,0,10);
        rootNode.add(FooterMidMain,1,10);
        rootNode.add(FooterRightMain,2,10);
        rootNode.setHalignment(TitleMain, HPos.CENTER);
        rootNode.setHalignment(OccupiedImage, HPos.CENTER);
        rootNode.setHalignment(Welcome, HPos.CENTER);
        rootNode.setHalignment(Hname, HPos.CENTER);
        rootNode.setHalignment(UnOccupiedImage, HPos.CENTER);
        rootNode.setHalignment(Occupied, HPos.CENTER);
        rootNode.setHalignment(UnOccupied, HPos.CENTER);
        rootNode.setHalignment(PendingImage, HPos.CENTER);
        rootNode.setHalignment(ManageBT, HPos.CENTER);
        rootNode.setHalignment(RequestBT, HPos.CENTER);
        rootNode.setHalignment(SettingsBT, HPos.CENTER);
        rootNode.setHalignment(NewBooking, HPos.CENTER);
        rootNode.setHalignment(HeaderRightMain, HPos.RIGHT);
        rootNode.setStyle("-fx-background-color: #e7decd;");
        mainStage.show();
        //ManageButton Clicked
        Stage ManageStage = new Stage();
        ManageStage.setTitle("Manage Bookings (Hotel Manager)");
        GridPane ManageNode=new GridPane();
        ManageNode.setVgap(10); 
        ManageNode.setHgap(0);
        ManageNode.setAlignment(Pos.CENTER);
        Scene ManageScene=new Scene(ManageNode,501,550);
        ManageStage.setScene(ManageScene);
        Label Managetitle=new Label("MANAGE\nBOOKINGS");
        Managetitle.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,19));
        Label CurrentOcc=new Label("Currently Occupied Rooms :");
        CurrentOcc.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        Button NewBookingManage=new Button("NEW BOOKING");
        NewBookingManage.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        NewBookingManage.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,12));
        Managetitle.setTextAlignment(TextAlignment.CENTER);
        ListView<String> OccupiedList = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList (BookedList);
        OccupiedList.setItems(items);
        OccupiedList.setMinWidth(167);
        OccupiedList.setMinHeight(200);
        Button CheckOutBT=new Button("CHECK OUT");
        CheckOutBT.setStyle("fx-background-color: #cf4530;-fx-border-color: #a62916; -fx-border-width: 5px;-fx-font-weight: bold;");
        Button ManageClearBT=new Button("Clear Selection");
        ManageClearBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        Button ManageExitBT=new Button("Main Menu");
        ManageExitBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        CheckOutBT.setVisible(false);
        Alert Checkout = new Alert(AlertType.INFORMATION);
        Checkout.setContentText("Guest Checked Out Successfully.");
        ManageClearBT.setVisible(false);
        ImageView FooterLeftManage = new ImageView(image1);
        ImageView FooterMidManage = new ImageView(image2);
        ImageView FooterRightManage = new ImageView(image3);
        ImageView HeaderRightManage = new ImageView(image4);
        ImageView HeaderLeftManage = new ImageView(image5);
        ManageNode.add(HeaderRightManage, 2,0);
        ManageNode.add(HeaderLeftManage, 0,0);
        ManageNode.add(Managetitle, 1,0);
        ManageNode.add(NewBookingManage, 1,2);
        ManageNode.add(CurrentOcc, 1,3);
        ManageNode.add(OccupiedList, 1,4);
        ManageNode.add(CheckOutBT, 1,5);
        ManageNode.add(ManageClearBT, 2,5);
        ManageNode.add(ManageExitBT, 0,5);
        ManageNode.add(FooterLeftManage,0,9);
        ManageNode.add(FooterMidManage,1,9);
        ManageNode.add(FooterRightManage,2,9);
        ManageNode.setHalignment(NewBookingManage, HPos.CENTER);
        ManageNode.setHalignment(Managetitle, HPos.CENTER);
        ManageNode.setHalignment(OccupiedList, HPos.CENTER);
        ManageNode.setHalignment(CheckOutBT, HPos.CENTER);
        ManageNode.setHalignment(ManageClearBT, HPos.CENTER);
        ManageNode.setHalignment(ManageExitBT, HPos.CENTER);
        ManageNode.setStyle("-fx-background-color: #e7decd;");
        ManageBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {    
                ManageStage.show();
                mainStage.close();
            }
        });
        ManageClearBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {    
                CheckOutBT.setVisible(false);
                ManageClearBT.setVisible(false);
            }
        });
        ManageExitBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {    
                mainStage.show();
                Occupied.setText(Integer.toString(H.CurrentOccupancy));
                UnOccupied.setText(Integer.toString(H.Rooms-H.CurrentOccupancy));
                ManageStage.close();
            }
        });
        OccupiedList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) 
            {
                ManageClearBT.setVisible(true);
                CheckOutBT.setVisible(true);
            }
        });
        CheckOutBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {    
                CheckOutBT.setVisible(false);
                String S =OccupiedList.getSelectionModel().getSelectedItem();
                BookedList.remove(S);
                int ind1=S.indexOf(":");
                int RnoCO=Integer.parseInt(S.substring(5,ind1-1));
                int ind=0;
                for(int i=0;i<H.Rooms;i++)
                {
                    if(R[i].RoomNumber==RnoCO)
                    {
                        ind=i;
                        break;
                    }
                }
                R[ind].GuestName="";
                R[ind].Occupancy=false; 
                H.CurrentOccupancy-=1;
                Checkout.show();
                final ObservableList<String> items =FXCollections.observableArrayList (BookedList);
                OccupiedList.setItems(items);
            }
        });
        //RequestButton Clicked
        Stage RequestStage = new Stage();
        RequestStage.setTitle("Manage Requests (Hotel Manager)");
        GridPane RequestNode=new GridPane();
        RequestNode.setVgap(10); 
        RequestNode.setHgap(0);
        RequestNode.setAlignment(Pos.CENTER);
        Scene RequestScene=new Scene(RequestNode,501,450);
        RequestStage.setScene(RequestScene);
        Label Requesttitle=new Label("MANAGE\nREQUESTS");
        Requesttitle.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,18));
        Requesttitle.setTextAlignment(TextAlignment.CENTER);
        Label NewReqL=new Label("New Service Requests :");
        NewReqL.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        Button NewRequest=new Button("ADD NEW REQUEST");
        NewRequest.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        NewRequest.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,12));
        Requesttitle.setTextAlignment(TextAlignment.CENTER);
        ListView<String> RequestList = new ListView<String>();
        //ObservableList<String> reqs =FXCollections.observableArrayList ("Room 107 - Room Cleaning","Room 204 - Dinner Request","Room 111 - Faulty Switch");
        RequestList.setItems(reqs);
        RequestList.setMinWidth(167);
        RequestList.setMinHeight(167);
        Button MarkDoneBT=new Button("MARK AS\nDONE");
        MarkDoneBT.setStyle("fx-background-color: #cf4530;-fx-border-color: #2f994c; -fx-border-width: 5px;-fx-font-weight: bold;");
        Button RequestClearBT=new Button("Clear Selection");
        RequestClearBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        Button RequestExitBT=new Button("Main Menu");
        RequestExitBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        Alert Done = new Alert(AlertType.INFORMATION);
        Done.setContentText("Request Marked as Done.");
        ImageView FooterLeftRequest = new ImageView(image1);
        ImageView FooterMidRequest = new ImageView(image2);
        ImageView FooterRightRequest = new ImageView(image3);
        ImageView HeaderRightRequest = new ImageView(image4);
        ImageView HeaderLeftRequest = new ImageView(image5);
        MarkDoneBT.setVisible(false);
        RequestClearBT.setVisible(false);
        RequestNode.add(HeaderRightRequest, 2,0);
        RequestNode.add(HeaderLeftRequest, 0,0);
        RequestNode.add(Requesttitle, 1,0);
        RequestNode.add(NewReqL, 1,1);
        RequestNode.add(RequestList, 1,3);
        RequestNode.add(MarkDoneBT, 2,3);
        RequestNode.add(NewRequest, 1,4);
        RequestNode.add(RequestClearBT, 2,4);
        RequestNode.add(RequestExitBT, 0,4);
        RequestNode.add(FooterLeftRequest,0,6);
        RequestNode.add(FooterMidRequest,1,6);
        RequestNode.add(FooterRightRequest,2,6);
        RequestNode.setHalignment(Requesttitle, HPos.CENTER);
        RequestNode.setHalignment(RequestList, HPos.CENTER);
        RequestNode.setHalignment(MarkDoneBT, HPos.CENTER);
        RequestNode.setHalignment(NewReqL, HPos.CENTER);
        RequestNode.setHalignment(NewRequest, HPos.CENTER);
        RequestNode.setHalignment(RequestClearBT, HPos.CENTER);
        RequestNode.setHalignment(RequestExitBT, HPos.CENTER);
        RequestNode.setStyle("-fx-background-color: #e7decd;");
        RequestBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            { 
                RequestStage.show();
                mainStage.close();
            }
        });
        RequestList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) 
            {
                MarkDoneBT.setVisible(true);
                RequestClearBT.setVisible(true);
            }
        });
        RequestClearBT.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) 
            {
                MarkDoneBT.setVisible(false);
                RequestClearBT.setVisible(false);
            }
        });
        MarkDoneBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {    
                MarkDoneBT.setVisible(false);
                RequestClearBT.setVisible(false);
                String S =RequestList.getSelectionModel().getSelectedItem();
                ReqsList.remove(S);
                Done.show();
                final ObservableList<String> reqs =FXCollections.observableArrayList (ReqsList);
                RequestList.setItems(reqs);
            }
        });
        RequestExitBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {    
                mainStage.show();
                Occupied.setText(Integer.toString(H.CurrentOccupancy));
                UnOccupied.setText(Integer.toString(H.Rooms-H.CurrentOccupancy));
                final ObservableList<String> reqs =FXCollections.observableArrayList (ReqsList);
                RequestListMain.setItems(reqs);
                RequestStage.close();
            }
        });
        //Settings Clicked
        Stage SettingsStage = new Stage();
        SettingsStage.setTitle("Settings (Hotel Manager)");
        GridPane SettingsNode=new GridPane();
        SettingsNode.setVgap(10); 
        SettingsNode.setHgap(0);
        SettingsNode.setAlignment(Pos.CENTER);
        Scene SettingsScene=new Scene(SettingsNode,501,450);
        SettingsStage.setScene(SettingsScene);
        Label Settingstitle=new Label("SETTINGS");
        Label HotelDetails=new Label("HOTEL DETAILS");
        Settingstitle.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,20));
        HotelDetails.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,17));
        Label HotelName=new Label("Hotel Name : ");
        TextField HotelNameTf=new TextField();
        HotelNameTf.setPromptText("Press Edit Button to Register or Update");
        Label OpName=new Label("Hotel Manager Name : ");
        TextField OpNameTf=new TextField();
        OpNameTf.setPromptText("Press Edit Button to Register or Update");
        Label RoomNo=new Label("Total Rooms : ");
        TextField RoomNoTf=new TextField();
        RoomNoTf.setPromptText("Press Edit Button to Register or Update");
        HotelName.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        OpName.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        RoomNo.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        Settingstitle.setTextAlignment(TextAlignment.CENTER);
        ImageView FooterLeftSettings = new ImageView(image1);
        ImageView FooterMidSettings = new ImageView(image2);
        ImageView FooterRightSettings = new ImageView(image3);
        ImageView HeaderRightSettings = new ImageView(image4);
        ImageView HeaderLeftSettings = new ImageView(image5);
        ImageView Editbtnview1 = new ImageView(Editbtn);
        Editbtnview1.setPreserveRatio(true);
        Button EditBT1=new Button();
        EditBT1.setMaxHeight(40);
        EditBT1.setMaxWidth(40);
        EditBT1.setGraphic(Editbtnview1);
        EditBT1.setStyle("-fx-background-color: #e7decd");
        HotelNameTf.setEditable(false);
        OpNameTf.setEditable(false);
        RoomNoTf.setEditable(false);
        Button EditCfmBT=new Button("CONFIRM CHANGES");
        EditCfmBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        EditCfmBT.setVisible(false);
        Button RoomsDetailsBT=new Button("VIEW/UPDATE ROOMS");
        RoomsDetailsBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        Button SettingsExitBT=new Button("Main Menu");
        SettingsExitBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        SettingsNode.add(HeaderRightSettings, 2,0);
        SettingsNode.add(HeaderLeftSettings, 0,0);
        SettingsNode.add(Settingstitle,1,0);
        SettingsNode.add(HotelDetails,1,2);
        SettingsNode.add(HotelName,0,3);
        SettingsNode.add(HotelNameTf,1,3);
        SettingsNode.add(EditBT1,2,3);
        SettingsNode.add(OpName,0,4);
        SettingsNode.add(OpNameTf,1,4);
        SettingsNode.add(RoomNo,0,5);
        SettingsNode.add(RoomNoTf,1,5);
        SettingsNode.add(EditCfmBT,2,5);
        SettingsNode.add(RoomsDetailsBT,1,6);
        SettingsNode.add(SettingsExitBT,1,7);
        SettingsNode.add(FooterLeftSettings,0,9);
        SettingsNode.add(FooterMidSettings,1,9);
        SettingsNode.add(FooterRightSettings,2,9);
        SettingsNode.setHalignment(Settingstitle, HPos.CENTER);
        SettingsNode.setHalignment(HotelDetails, HPos.CENTER);
        SettingsNode.setHalignment(HotelName, HPos.CENTER);
        SettingsNode.setHalignment(RoomNo, HPos.CENTER);
        SettingsNode.setHalignment(OpName, HPos.CENTER);
        SettingsNode.setHalignment(SettingsExitBT, HPos.CENTER);
        SettingsNode.setHalignment(RoomsDetailsBT, HPos.CENTER);
        SettingsNode.setHalignment(EditCfmBT, HPos.CENTER);
        SettingsNode.setStyle("-fx-background-color: #e7decd;");
        SettingsBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                SettingsStage.show();
                if (H.Name!=null)
                {
                    HotelNameTf.setText(H.Name);
                    OpNameTf.setText(H.OperatorName);
                    RoomNoTf.setText(Integer.toString(H.Rooms));
                }
                mainStage.close();
            }
        });
        SettingsExitBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                mainStage.show();
                Occupied.setText(Integer.toString(H.CurrentOccupancy));
                UnOccupied.setText(Integer.toString(H.Rooms-H.CurrentOccupancy));
                SettingsStage.close();
            }
        });
        EditBT1.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                HotelNameTf.setPromptText("Enter Hotel Name here");
                OpNameTf.setPromptText("Enter Manager's Name");
                RoomNoTf.setPromptText("Enter Total Number of Rooms");
                HotelNameTf.setEditable(true);
                OpNameTf.setEditable(true);
                RoomNoTf.setEditable(true);
                EditCfmBT.setVisible(true);
            }
        });
        EditCfmBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                final String Hn;
                final String Mn;
                final int rn;
                Hn=HotelNameTf.getText();
                Mn=OpNameTf.getText(); 
                rn=Integer.parseInt(RoomNoTf.getText());
                final Hotel H =new Hotel(Hn,Mn,rn);
                EditCfmBT.setVisible(false);
                HotelNameTf.setEditable(false);
                OpNameTf.setEditable(false);
                RoomNoTf.setEditable(false);
                int i=H.OperatorName.indexOf(" ");
                if (i>1)
                    Welcome.setText("WELCOME "+H.OperatorName.substring(0,i).toUpperCase());
                else
                    Welcome.setText("WELCOME "+H.OperatorName.toUpperCase());
                if (H.Name.toUpperCase().indexOf("HOTEL")>0)
                    Hname.setText(H.Name.toUpperCase());
                else
                    Hname.setText("HOTEL "+H.Name.toUpperCase());
            }
        });
        
        //NewBooking Clicked
        Stage NewBookStage = new Stage();
        NewBookStage.setTitle("Register New Booking (Hotel Manager)");
        GridPane NewBookNode=new GridPane();
        NewBookNode.setVgap(10); 
        NewBookNode.setHgap(0);
        NewBookNode.setAlignment(Pos.CENTER);
        Scene NewBookScene=new Scene(NewBookNode,490,220);
        NewBookStage.setScene(NewBookScene);
        Label NewBooktitle=new Label("NEW\nBOOKING");
        Label GetRoom=new Label("Enter Room Number : ");
        TextField GetRoomTf=new TextField();
        GetRoomTf.setPromptText("Booked Room Number");
        Label GetGName=new Label("Enter Guest Name : ");
        TextField GetGNameTf=new TextField();
        Button NewBookBT=new Button("REGISTER BOOKING");
        NewBookBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        Button NewBookClearBT=new Button("Clear Entries");
        NewBookClearBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        Button NewBookExitBT=new Button("Cancel Entry");
        NewBookExitBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        GetGNameTf.setPromptText("Booked Guest Name");
        Alert Booked = new Alert(AlertType.INFORMATION);
        Booked.setContentText("Booking Registered Successfully.");
        GetRoom.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        GetGName.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        NewBooktitle.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,16));
        NewBooktitle.setTextAlignment(TextAlignment.CENTER);
        ImageView HeaderRightNewBook = new ImageView(image4);
        ImageView HeaderLeftNewBook = new ImageView(image5);
        NewBookNode.add(NewBooktitle, 1,0); 
        NewBookNode.add(HeaderRightNewBook, 2,0);
        NewBookNode.add(HeaderLeftNewBook, 0,0);
        NewBookNode.add(GetRoom, 0,1);
        NewBookNode.add(GetRoomTf, 1,1);
        NewBookNode.add(GetGName, 0,2);
        NewBookNode.add(GetGNameTf, 1,2);
        NewBookNode.add(NewBookBT, 1,3);
        NewBookNode.add(NewBookClearBT, 0,3);
        NewBookNode.add(NewBookExitBT, 2,3);
        NewBookNode.setHalignment(NewBooktitle, HPos.CENTER);
        NewBookNode.setHalignment(GetRoom, HPos.CENTER);
        NewBookNode.setHalignment(GetGName, HPos.CENTER);
        NewBookNode.setHalignment(NewBookBT, HPos.CENTER);
        NewBookNode.setHalignment(NewBookClearBT, HPos.CENTER);
        NewBookNode.setHalignment(NewBookExitBT, HPos.CENTER);
        NewBookNode.setStyle("-fx-background-color: #e7decd;");
        NewBooking.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                NewBookStage.show();
                mainStage.close();
            }
        });
        NewBookingManage.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                NewBookStage.show();
                ManageStage.close();
            }
        });
        NewBookBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                String BookDetails="Room "+GetRoomTf.getText()+" : "+GetGNameTf.getText();
                BookedList.add(BookDetails);
                int ind=0;
                for(int i=0;i<H.Rooms;i++)
                {
                    if(R[i].RoomNumber==Integer.parseInt(GetRoomTf.getText()))
                    {
                        ind=i;
                        break;
                    }
                }
                R[ind].GuestName=GetGNameTf.getText();
                R[ind].Occupancy=true; 
                H.CurrentOccupancy+=1;
                NewBookStage.close();
                ManageStage.show();
                Booked.show();
                GetRoomTf.setText("");
                GetGNameTf.setText("");
                final ObservableList<String> items =FXCollections.observableArrayList (BookedList);
                OccupiedList.setItems(items);
            }
        });
        NewBookExitBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                GetRoomTf.setText("");
                GetGNameTf.setText("");
                NewBookStage.close();
                ManageStage.show();
            }
        });
        NewBookClearBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                GetRoomTf.setText("");
                GetGNameTf.setText("");
            }
        });
        //ViewRooms Clicked
        Stage ViewRoomStage = new Stage();
        ViewRoomStage.setTitle("View/Update Rooms (Hotel Manager)");
        GridPane ViewRoomNode=new GridPane();
        ViewRoomNode.setVgap(10); 
        ViewRoomNode.setHgap(0);
        ViewRoomNode.setAlignment(Pos.CENTER);
        Scene ViewRoomScene=new Scene(ViewRoomNode,490,450);
        ViewRoomStage.setScene(ViewRoomScene);
        Label ViewRoomtitle=new Label("ROOM DETAILS");
        Label ViewRoomsubtitle=new Label("DETAILS");
        Label GetRoomVR=new Label("Enter Room Number : ");
        TextField GetRoomTfVR=new TextField();
        GetRoomTfVR.setPromptText("Room Number to View/Update");
        Button ViewRoomBT=new Button("SEARCH");
        ViewRoomBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        Label RoomNoVR=new Label("Room No : ");
        TextField RoomNoVRTf=new TextField();
        Label RoomTypeVR=new Label("Room Type : ");
        TextField RoomTypeVRTf=new TextField();
        Label RoomOccuVR=new Label("Occupancy Status : ");
        TextField RoomOccuVRTf=new TextField();
        Label GNameVR=new Label("GuestName : ");
        TextField GNameVRTf=new TextField();
        GNameVR.setVisible(false);
        GNameVRTf.setVisible(false);
        Button ViewRoomExitBT=new Button("Go Back");
        RoomOccuVRTf.setEditable(false);
        ViewRoomExitBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        GetRoomVR.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        RoomNoVR.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        GNameVR.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        RoomTypeVR.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        RoomOccuVR.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        ViewRoomtitle.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,16));
        ViewRoomtitle.setTextAlignment(TextAlignment.CENTER);
        ViewRoomsubtitle.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,14));
        ViewRoomsubtitle.setTextAlignment(TextAlignment.CENTER);
        ImageView Editbtnview3 = new ImageView(Editbtn);
        Editbtnview3.setPreserveRatio(true);
        ImageView Editbtnview4 = new ImageView(Editbtn);
        Editbtnview4.setPreserveRatio(true);
        Button EditBT3=new Button();
        EditBT3.setMaxHeight(40);
        EditBT3.setMaxWidth(40);
        EditBT3.setGraphic(Editbtnview1);
        EditBT3.setStyle("-fx-background-color: #e7decd");
        Button EditCfmBTVR=new Button("CONFIRM CHANGES");
        EditCfmBTVR.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        EditCfmBTVR.setVisible(false);
        ImageView HeaderRightViewRoom = new ImageView(image4);
        ImageView HeaderLeftViewRoom = new ImageView(image5);
        ViewRoomNode.add(ViewRoomtitle, 1,0); 
        ViewRoomNode.add(HeaderRightViewRoom, 2,0);
        ViewRoomNode.add(HeaderLeftViewRoom, 0,0);
        ViewRoomNode.add(ViewRoomsubtitle, 1,2);
        ViewRoomNode.add(GetRoomVR, 0,1);
        ViewRoomNode.add(GetRoomTfVR, 1,1);
        ViewRoomNode.add(ViewRoomBT, 2,1);
        ViewRoomNode.add(RoomNoVR, 0,4);
        ViewRoomNode.add(RoomNoVRTf, 1,4);
        ViewRoomNode.add(EditBT3, 2,4);
        ViewRoomNode.add(RoomTypeVR, 0,5);
        ViewRoomNode.add(RoomTypeVRTf, 1,5);
        ViewRoomNode.add(RoomOccuVR, 0,6);
        ViewRoomNode.add(RoomOccuVRTf, 1,6);
        ViewRoomNode.add(GNameVR, 0,7);
        ViewRoomNode.add(GNameVRTf, 1,7);
        ViewRoomNode.add(EditCfmBTVR, 2,7);
        ViewRoomNode.add(ViewRoomExitBT, 1,8);
        ViewRoomNode.setHalignment(ViewRoomtitle, HPos.CENTER);
        ViewRoomNode.setHalignment(ViewRoomsubtitle, HPos.CENTER);
        ViewRoomNode.setHalignment(GetRoomVR, HPos.CENTER);
        ViewRoomNode.setHalignment(ViewRoomBT, HPos.CENTER);
        ViewRoomNode.setHalignment(RoomNoVR, HPos.CENTER);
        ViewRoomNode.setHalignment(GNameVR, HPos.CENTER);
        ViewRoomNode.setHalignment(RoomTypeVR, HPos.CENTER);
        ViewRoomNode.setHalignment(RoomOccuVR, HPos.CENTER);
        ViewRoomNode.setHalignment(EditCfmBTVR, HPos.CENTER);
        ViewRoomNode.setHalignment(ViewRoomExitBT, HPos.CENTER);
        ViewRoomNode.setStyle("-fx-background-color: #e7decd;");
        RoomsDetailsBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                ViewRoomStage.show();
                SettingsStage.close();
            }
        });
        ViewRoomExitBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                SettingsStage.show();
                ViewRoomStage.close();
            }
        });
        EditBT3.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                EditCfmBTVR.setVisible(true);
            }
        });
        ViewRoomBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {
                for(int i=0;i<H.Rooms;i++)
                {
                    if(R[i].RoomNumber==Integer.parseInt(GetRoomTfVR.getText()))
                    {
                        RoomNoVRTf.setText(Integer.toString(R[i].RoomNumber));
                        RoomTypeVRTf.setText(R[i].RoomType);
                        RoomOccuVRTf.setText(R[i].getOccupancy());
                        if (R[i].getOccupancy().equals("Occupied."))
                        {
                            GNameVR.setVisible(true);
                            GNameVRTf.setVisible(true);
                            GNameVRTf.setText(R[i].GuestName);
                        }
                        else
                        {
                            GNameVR.setVisible(false);
                            GNameVRTf.setVisible(false);
                        }
                    }
                    else
                        continue;
                }
            }
        });
        EditCfmBTVR.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                EditCfmBTVR.setVisible(false);
                int ind=0;
                for(int i=0;i<H.Rooms;i++)
                {
                    if(R[i].RoomNumber==Integer.parseInt(GetRoomTfVR.getText()))
                    {
                        ind=i;
                        break;
                    }
                }
                R[ind].RoomNumber=Integer.parseInt(RoomNoVRTf.getText());
                R[ind].RoomType=RoomTypeVRTf.getText();        
            }
        });
        //New Request Stage Design
        Stage NewReqStage = new Stage();
        NewReqStage.setTitle("Add New Request (Hotel Manager)");
        GridPane NewReqNode=new GridPane();
        NewReqNode.setVgap(10); 
        NewReqNode.setHgap(0);
        NewReqNode.setAlignment(Pos.CENTER);
        Scene NewReqScene=new Scene(NewReqNode,490,220);
        NewReqStage.setScene(NewReqScene);
        Label NewReqtitle=new Label("NEW\nREQUEST");
        Label GetReqRoom=new Label("Enter Room Number : ");
        TextField GetRoomReqTf=new TextField();
        GetRoomReqTf.setPromptText("Requested Room Number");
        Label GetReq=new Label("Enter Request : ");
        TextField GetReqTf=new TextField();
        Button NewReqBT=new Button("Add Request");
        NewReqBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 5px;-fx-font-weight: bold;");
        Button NewReqClearBT=new Button("Clear Entries");
        NewReqClearBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        Button NewReqExitBT=new Button("Cancel Entry");
        NewReqExitBT.setStyle("fx-background-color: #bfa783;-fx-border-color: #bfa783; -fx-border-width: 3px;-fx-font-weight: bold;");
        GetReqTf.setPromptText("Enter Request");
        Alert ReqAdd = new Alert(AlertType.INFORMATION);
        ReqAdd.setContentText("Request Added Successfully.");
        GetReqRoom.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        GetReq.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,14));
        NewReqtitle.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,16));
        NewReqtitle.setTextAlignment(TextAlignment.CENTER);
        ImageView HeaderRightNewReq = new ImageView(image4);
        ImageView HeaderLeftNewReq = new ImageView(image5);
        NewReqNode.add(NewReqtitle, 1,0); 
        NewReqNode.add(HeaderRightNewReq, 2,0);
        NewReqNode.add(HeaderLeftNewReq, 0,0);
        NewReqNode.add(GetReqRoom, 0,1);
        NewReqNode.add(GetRoomReqTf, 1,1);
        NewReqNode.add(GetReq, 0,2);
        NewReqNode.add(GetReqTf, 1,2);
        NewReqNode.add(NewReqBT, 1,3);
        NewReqNode.add(NewReqClearBT, 0,3);
        NewReqNode.add(NewReqExitBT, 2,3);
        NewReqNode.setHalignment(NewReqtitle, HPos.CENTER);
        NewReqNode.setHalignment(GetReqRoom, HPos.CENTER);
        NewReqNode.setHalignment(GetReq, HPos.CENTER);
        NewReqNode.setHalignment(NewReqBT, HPos.CENTER);
        NewReqNode.setHalignment(NewReqClearBT, HPos.CENTER);
        NewReqNode.setHalignment(NewReqExitBT, HPos.CENTER);
        NewReqNode.setStyle("-fx-background-color: #e7decd;");
        NewRequest.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {
                NewReqStage.show();
                RequestStage.close();
            }
        });
        NewReqBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                String ReqDetails="Room "+GetRoomReqTf.getText()+" : "+GetReqTf.getText();
                ReqsList.add(ReqDetails);
                GetRoomReqTf.setText("");
                GetReqTf.setText("");
                final ObservableList<String> reqs =FXCollections.observableArrayList (ReqsList);
                RequestList.setItems(reqs);
                RequestListMain.setItems(reqs);
                NewReqStage.close();
                RequestStage.show();
                ReqAdd.show();
            }
        });
        NewReqClearBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                GetRoomReqTf.setText("");
                GetReqTf.setText("");
            }
        });
        NewReqExitBT.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {    
                GetRoomReqTf.setText("");
                GetReqTf.setText("");
                NewReqStage.close();
                RequestStage.show();
            }
        });
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package core.views;

import core.controllers.flightController.AddPassengerToFlightController;
import core.controllers.flightController.ChargeIdsFlightsController;
import util.DataLoader;
import core.controllers.flightController.ValidFlightIdFormatController;
import core.controllers.locationController.ValidAirportIdFormatLocationController;
import core.controllers.PassengerControler;
import core.controllers.PlaneController;
import core.controllers.flightController.CreateFlightController;
import core.controllers.flightController.DelayFlightController;
import core.controllers.flightController.GetAllFlightsController;
import core.controllers.locationController.ChargeIdsLocationController;
import core.controllers.locationController.CreateLocationController;
import core.controllers.locationController.GetAllLocationsController;
import core.controllers.utils.Response;
import core.models.Flight;
import core.models.Location;
import core.models.Passenger;
import core.models.Plane;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edangulo
 */
public class AirportFrame extends javax.swing.JFrame {

    /**
     * Creates new form AirportFrame
     */
    private int x, y;
//    private ArrayList<Passenger> passengers;
//    private ArrayList<Plane> planes;
//    private ArrayList<Location> locations;
//    private ArrayList<Flight> flights;

    public AirportFrame() {
        initComponents();

//        this.passengers = new ArrayList<>();
//        this.planes = new ArrayList<>();
//        this.locations = new ArrayList<>();
//        this.flights = new ArrayList<>();
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        // se cargan los ids del json

        this.generateMonths();
        this.generateDays();
        this.generateHours();
        this.generateMinutes();
        this.blockPanels();

        DataLoader.loadInitialData();
        PassengerControler.ControllerChargeIds(this);
        ChargeIdsFlightsController.ControllerChargeIds(this);
        PlaneController.ControllerChargeIds(this);
        ChargeIdsLocationController.ControllerChargeIds(this);
    }

    public void chargePassengerIds(List<String> ids) {
        System.out.println("ids a cargar:");
        for (String id : ids) {
            JComboBoxUserSelect.addItem(id);
            System.out.println(id);
        }
    }

    public void chargePlaneIds(List<String> ids) {
        System.out.println("ids de planes a cargar:");
        for (String id : ids) {
            this.jComboBoxPlaneFlightRegister.addItem(id);
            System.out.println(id);
        }
    }

    public void chargeFlightIds(List<String> ids) {
        System.out.println("ids de vuelos a cargar:");
        for (String id : ids) {
            this.jComboBoxFlight.addItem(id);
            this.jComboBoxIDDelayFlight.addItem(id);
            System.out.println(id);
        }
    }

    public void chargeLocationIds(List<String> ids) {
        System.out.println("ids de locations a cargar:");
        for (String id : ids) {
            this.jComboBoxDepartureLocationFlightRegister.addItem(id);
            this.jComboBoxArrivalLocationFlightRegister.addItem(id);
            this.jComboBoxScaleLocationFlightRegister.addItem(id);
            System.out.println(id);
        }
    }

    private void blockPanels() {
        //9, 11
        for (int i = 1; i < jTabbedPane.getTabCount(); i++) {
            if (i != 9 && i != 11) {
                jTabbedPane.setEnabledAt(i, false);
            }
        }
    }

    private void generateMonths() {
        for (int i = 1; i < 13; i++) {
            JComboBoxMonthUserRegister.addItem("" + i);
            JComboBoxDepartureMonth.addItem("" + i);
            JComboBoxMonth.addItem("" + i);
        }
    }

    private void generateDays() {
        for (int i = 1; i < 32; i++) {
            JComboBoxDayUserRegister.addItem("" + i);
            JComboBoxDepartureDay.addItem("" + i);
            JComboBoxDay.addItem("" + i);
        }
    }

    private void generateHours() {
        for (int i = 0; i < 24; i++) {
            JComboBoxDepartureHour.addItem("" + i);
            JComboBoxHourArrival.addItem("" + i);
            JComboBoxHourScale.addItem("" + i);
            jComboBoxHour.addItem("" + i);
        }
    }

    private void generateMinutes() {
        for (int i = 0; i < 60; i++) {
            JComboBoxDepartureMinute.addItem("" + i);
            JComboBoxMinuteArrival.addItem("" + i);
            JComboBoxMinuteScale.addItem("" + i);
            jComboBoxMinute.addItem("" + i);
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

        panelRoundMiddle = new core.views.PanelRound();
        panelRoundUp = new core.views.PanelRound();
        jButtonClose = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelAdministration = new javax.swing.JPanel();
        JRadioButtonUser = new javax.swing.JRadioButton();
        JRadioButtonAdministrator = new javax.swing.JRadioButton();
        JComboBoxUserSelect = new javax.swing.JComboBox<>();
        jPanelPassengerRegistration = new javax.swing.JPanel();
        jLabelCountryPassengerRegistration = new javax.swing.JLabel();
        jLabelIDPassengerRegistration = new javax.swing.JLabel();
        jLabelFirstNamePassengerRegistration = new javax.swing.JLabel();
        jLabelLastNamePassengerRegistration = new javax.swing.JLabel();
        jLabelBirthdatePassengerRegistration = new javax.swing.JLabel();
        jLabelPlusPassengerRegistration = new javax.swing.JLabel();
        jTextFieldPrefixUserRegister = new javax.swing.JTextField();
        jTextFieldIDUserRegister = new javax.swing.JTextField();
        jTextFieldYearRegister = new javax.swing.JTextField();
        jTextFieldCountryUserRegister = new javax.swing.JTextField();
        jTextFieldPhoneUserRegister = new javax.swing.JTextField();
        jLabelPhonePassengerRegistration = new javax.swing.JLabel();
        jLabelMinusBirthdate1PassengerRegistration = new javax.swing.JLabel();
        jTextFieldLastNameUserRegister = new javax.swing.JTextField();
        jLabelMinusPhonePassengerRegistration = new javax.swing.JLabel();
        JComboBoxMonthUserRegister = new javax.swing.JComboBox<>();
        jTextFieldFirstNameUserRegister = new javax.swing.JTextField();
        jLabelMinusBirthdate2PassengerRegistration = new javax.swing.JLabel();
        JComboBoxDayUserRegister = new javax.swing.JComboBox<>();
        jButtonRegisterPassenger = new javax.swing.JButton();
        jPanelAirplaneRegistration = new javax.swing.JPanel();
        jLabelIDAirplaneRegistration = new javax.swing.JLabel();
        jTextFieldIDAirPlaneRegister = new javax.swing.JTextField();
        jLabelBrandAirplaneRegistration = new javax.swing.JLabel();
        jTextFieldBrandAirPlaneRegister = new javax.swing.JTextField();
        jTextFieldModelAirPlaneRegister = new javax.swing.JTextField();
        jLabelModelAirplaneRegistration = new javax.swing.JLabel();
        jTextFieldMaxCapacityAirPlaneRegister = new javax.swing.JTextField();
        jLabelMaxCapacityAirplaneRegistration = new javax.swing.JLabel();
        jTextFieldAirlineAirPlaneRegister = new javax.swing.JTextField();
        jLabelAirlineAirplaneRegistration = new javax.swing.JLabel();
        jButtonCreateAirPlane = new javax.swing.JButton();
        jPanelLocationRegistration = new javax.swing.JPanel();
        jLabelAirportID = new javax.swing.JLabel();
        jTextFieldAirportID = new javax.swing.JTextField();
        jLabelAirportName = new javax.swing.JLabel();
        jTextFieldAirportName = new javax.swing.JTextField();
        jTextFieldAirportCity = new javax.swing.JTextField();
        jLabelAirportCity = new javax.swing.JLabel();
        jLabelAirportCountry = new javax.swing.JLabel();
        jTextFieldAirportCountry = new javax.swing.JTextField();
        jTextFieldAirportLatitude = new javax.swing.JTextField();
        jLabelAirportLatitude = new javax.swing.JLabel();
        jLabelAirportLongitude = new javax.swing.JLabel();
        jTextFieldAirportLongitude = new javax.swing.JTextField();
        jButtonCreateLocation = new javax.swing.JButton();
        JPanelFlightRegistration = new javax.swing.JPanel();
        jLabelIDFlightRegistration = new javax.swing.JLabel();
        jTextFieldIDFlightRegister = new javax.swing.JTextField();
        jLabelPlaneFlightRegistration = new javax.swing.JLabel();
        jComboBoxPlaneFlightRegister = new javax.swing.JComboBox<>();
        jComboBoxDepartureLocationFlightRegister = new javax.swing.JComboBox<>();
        jLabelDepartureLocationFlightRegistration = new javax.swing.JLabel();
        jComboBoxArrivalLocationFlightRegister = new javax.swing.JComboBox<>();
        jLabelArrivalLocationFlightRegistration = new javax.swing.JLabel();
        jLabelScaleLocationFlightRegistration = new javax.swing.JLabel();
        jComboBoxScaleLocationFlightRegister = new javax.swing.JComboBox<>();
        jLabelScaleDurationFlightRegistration = new javax.swing.JLabel();
        jLabelArrivalDurationFlightRegistration = new javax.swing.JLabel();
        jLabelDepartureDateFlightRegistration = new javax.swing.JLabel();
        jTextFieldDepartureYear = new javax.swing.JTextField();
        jLabelMinus1DepartureFlightRegistration = new javax.swing.JLabel();
        JComboBoxDepartureMonth = new javax.swing.JComboBox<>();
        jLabelMinus2DepartureFlightRegistration = new javax.swing.JLabel();
        JComboBoxDepartureDay = new javax.swing.JComboBox<>();
        jLabelMinus3DepartureFlightRegistration = new javax.swing.JLabel();
        JComboBoxDepartureHour = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        JComboBoxDepartureMinute = new javax.swing.JComboBox<>();
        JComboBoxHourArrival = new javax.swing.JComboBox<>();
        jLabelMinusArrivalFlightRegistration = new javax.swing.JLabel();
        JComboBoxMinuteArrival = new javax.swing.JComboBox<>();
        jLabelMinusScaleFlightRegistration = new javax.swing.JLabel();
        JComboBoxHourScale = new javax.swing.JComboBox<>();
        JComboBoxMinuteScale = new javax.swing.JComboBox<>();
        jButtonCreateFlight = new javax.swing.JButton();
        jPanelUpdateInfo = new javax.swing.JPanel();
        jLabelIDUpdateInfo = new javax.swing.JLabel();
        jTextFieldIDUser = new javax.swing.JTextField();
        jLabelFirstNameUpdateInfo = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jLabelLastNameUpdateInfo = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabelBirthdateUpdateInfo = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        JComboBoxMonth = new javax.swing.JComboBox<>();
        JComboBoxDay = new javax.swing.JComboBox<>();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabelMinusUpdateInfo = new javax.swing.JLabel();
        jTextFieldPrefix = new javax.swing.JTextField();
        jLabelPlusUpdateInfo = new javax.swing.JLabel();
        jLabelPhoneUpdateInfo = new javax.swing.JLabel();
        jLabelCountryUpdateInfo = new javax.swing.JLabel();
        jTextFieldCountry = new javax.swing.JTextField();
        jButtonUpdateUser = new javax.swing.JButton();
        jPanelAddToFlight = new javax.swing.JPanel();
        jTextFieldIDAddFlight = new javax.swing.JTextField();
        jLabelIDAddToFlight = new javax.swing.JLabel();
        jLabelFlightAddToFlight = new javax.swing.JLabel();
        jComboBoxFlight = new javax.swing.JComboBox<>();
        jButtonAddFlight = new javax.swing.JButton();
        jPanelShowMyFlights = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUserFlights = new javax.swing.JTable();
        jButtonRefreshMyFlights = new javax.swing.JButton();
        jPanelShowAllPassengers = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePassengers = new javax.swing.JTable();
        jButtonRefreshPassengers = new javax.swing.JButton();
        jPanelShowAllFlights = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAllFlights = new javax.swing.JTable();
        jButtonRefreshAllFlights = new javax.swing.JButton();
        jPanelShowAllPlanes = new javax.swing.JPanel();
        jButtonRefreshAllPlanes = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAllPlanes = new javax.swing.JTable();
        jPanelShowAllLocations = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableAllLocations = new javax.swing.JTable();
        jButtonRefreshAllLocations = new javax.swing.JButton();
        jPanelDelayFlight = new javax.swing.JPanel();
        jComboBoxHour = new javax.swing.JComboBox<>();
        jLabelHoursDelayFlight = new javax.swing.JLabel();
        jLabelIDDelayFlight = new javax.swing.JLabel();
        jComboBoxIDDelayFlight = new javax.swing.JComboBox<>();
        jLabelMinutesDelayFlight = new javax.swing.JLabel();
        jComboBoxMinute = new javax.swing.JComboBox<>();
        jButtonDelay = new javax.swing.JButton();
        panelRoundDown = new core.views.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRoundMiddle.setRadius(40);
        panelRoundMiddle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRoundUp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelRoundUpMouseDragged(evt);
            }
        });
        panelRoundUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRoundUpMousePressed(evt);
            }
        });

        jButtonClose.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonClose.setText("X");
        jButtonClose.setBorderPainted(false);
        jButtonClose.setContentAreaFilled(false);
        jButtonClose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundUpLayout = new javax.swing.GroupLayout(panelRoundUp);
        panelRoundUp.setLayout(panelRoundUpLayout);
        panelRoundUpLayout.setHorizontalGroup(
            panelRoundUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundUpLayout.createSequentialGroup()
                .addContainerGap(1083, Short.MAX_VALUE)
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRoundUpLayout.setVerticalGroup(
            panelRoundUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundUpLayout.createSequentialGroup()
                .addComponent(jButtonClose)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        panelRoundMiddle.add(panelRoundUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

        jTabbedPane.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jPanelAdministration.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JRadioButtonUser.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JRadioButtonUser.setText("User");
        JRadioButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRadioButtonUserActionPerformed(evt);
            }
        });
        jPanelAdministration.add(JRadioButtonUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        JRadioButtonAdministrator.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JRadioButtonAdministrator.setText("Administrator");
        JRadioButtonAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRadioButtonAdministratorActionPerformed(evt);
            }
        });
        jPanelAdministration.add(JRadioButtonAdministrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 164, -1, -1));

        JComboBoxUserSelect.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxUserSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User" }));
        JComboBoxUserSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxUserSelectActionPerformed(evt);
            }
        });
        jPanelAdministration.add(JComboBoxUserSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 130, -1));

        jTabbedPane.addTab("Administration", jPanelAdministration);

        jPanelPassengerRegistration.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCountryPassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelCountryPassengerRegistration.setText("Country:");
        jPanelPassengerRegistration.add(jLabelCountryPassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabelIDPassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelIDPassengerRegistration.setText("ID:");
        jPanelPassengerRegistration.add(jLabelIDPassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabelFirstNamePassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelFirstNamePassengerRegistration.setText("First Name:");
        jPanelPassengerRegistration.add(jLabelFirstNamePassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabelLastNamePassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelLastNamePassengerRegistration.setText("Last Name:");
        jPanelPassengerRegistration.add(jLabelLastNamePassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabelBirthdatePassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelBirthdatePassengerRegistration.setText("Birthdate:");
        jPanelPassengerRegistration.add(jLabelBirthdatePassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabelPlusPassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelPlusPassengerRegistration.setText("+");
        jPanelPassengerRegistration.add(jLabelPlusPassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 20, -1));

        jTextFieldPrefixUserRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelPassengerRegistration.add(jTextFieldPrefixUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 50, -1));

        jTextFieldIDUserRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelPassengerRegistration.add(jTextFieldIDUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, -1));

        jTextFieldYearRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelPassengerRegistration.add(jTextFieldYearRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 90, -1));

        jTextFieldCountryUserRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelPassengerRegistration.add(jTextFieldCountryUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 130, -1));

        jTextFieldPhoneUserRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelPassengerRegistration.add(jTextFieldPhoneUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 130, -1));

        jLabelPhonePassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelPhonePassengerRegistration.setText("Phone:");
        jPanelPassengerRegistration.add(jLabelPhonePassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabelMinusBirthdate1PassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinusBirthdate1PassengerRegistration.setText("-");
        jPanelPassengerRegistration.add(jLabelMinusBirthdate1PassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 30, -1));

        jTextFieldLastNameUserRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelPassengerRegistration.add(jTextFieldLastNameUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 130, -1));

        jLabelMinusPhonePassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinusPhonePassengerRegistration.setText("-");
        jPanelPassengerRegistration.add(jLabelMinusPhonePassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 30, -1));

        JComboBoxMonthUserRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxMonthUserRegister.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));
        jPanelPassengerRegistration.add(JComboBoxMonthUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        jTextFieldFirstNameUserRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelPassengerRegistration.add(jTextFieldFirstNameUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 130, -1));

        jLabelMinusBirthdate2PassengerRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinusBirthdate2PassengerRegistration.setText("-");
        jPanelPassengerRegistration.add(jLabelMinusBirthdate2PassengerRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 30, -1));

        JComboBoxDayUserRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxDayUserRegister.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));
        jPanelPassengerRegistration.add(JComboBoxDayUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        jButtonRegisterPassenger.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonRegisterPassenger.setText("Register");
        jButtonRegisterPassenger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterPassengerPassengerActionPerformed(evt);
            }
        });
        jPanelPassengerRegistration.add(jButtonRegisterPassenger, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        jTabbedPane.addTab("Passenger registration", jPanelPassengerRegistration);

        jPanelAirplaneRegistration.setLayout(null);

        jLabelIDAirplaneRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelIDAirplaneRegistration.setText("ID:");
        jPanelAirplaneRegistration.add(jLabelIDAirplaneRegistration);
        jLabelIDAirplaneRegistration.setBounds(53, 96, 22, 25);

        jTextFieldIDAirPlaneRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelAirplaneRegistration.add(jTextFieldIDAirPlaneRegister);
        jTextFieldIDAirPlaneRegister.setBounds(180, 93, 130, 29);

        jLabelBrandAirplaneRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelBrandAirplaneRegistration.setText("Brand:");
        jPanelAirplaneRegistration.add(jLabelBrandAirplaneRegistration);
        jLabelBrandAirplaneRegistration.setBounds(53, 157, 50, 25);

        jTextFieldBrandAirPlaneRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelAirplaneRegistration.add(jTextFieldBrandAirPlaneRegister);
        jTextFieldBrandAirPlaneRegister.setBounds(180, 154, 130, 29);

        jTextFieldModelAirPlaneRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelAirplaneRegistration.add(jTextFieldModelAirPlaneRegister);
        jTextFieldModelAirPlaneRegister.setBounds(180, 213, 130, 29);

        jLabelModelAirplaneRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelModelAirplaneRegistration.setText("Model:");
        jPanelAirplaneRegistration.add(jLabelModelAirplaneRegistration);
        jLabelModelAirplaneRegistration.setBounds(53, 216, 55, 25);

        jTextFieldMaxCapacityAirPlaneRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelAirplaneRegistration.add(jTextFieldMaxCapacityAirPlaneRegister);
        jTextFieldMaxCapacityAirPlaneRegister.setBounds(180, 273, 130, 29);

        jLabelMaxCapacityAirplaneRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMaxCapacityAirplaneRegistration.setText("Max Capacity:");
        jPanelAirplaneRegistration.add(jLabelMaxCapacityAirplaneRegistration);
        jLabelMaxCapacityAirplaneRegistration.setBounds(53, 276, 109, 25);

        jTextFieldAirlineAirPlaneRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanelAirplaneRegistration.add(jTextFieldAirlineAirPlaneRegister);
        jTextFieldAirlineAirPlaneRegister.setBounds(180, 333, 130, 29);

        jLabelAirlineAirplaneRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelAirlineAirplaneRegistration.setText("Airline:");
        jPanelAirplaneRegistration.add(jLabelAirlineAirplaneRegistration);
        jLabelAirlineAirplaneRegistration.setBounds(53, 336, 70, 25);

        jButtonCreateAirPlane.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonCreateAirPlane.setText("Create");
        jButtonCreateAirPlane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateAirPlaneActionPerformed(evt);
            }
        });
        jPanelAirplaneRegistration.add(jButtonCreateAirPlane);
        jButtonCreateAirPlane.setBounds(490, 480, 120, 40);

        jTabbedPane.addTab("Airplane registration", jPanelAirplaneRegistration);

        jLabelAirportID.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelAirportID.setText("Airport ID:");

        jTextFieldAirportID.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelAirportName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelAirportName.setText("Airport name:");

        jTextFieldAirportName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jTextFieldAirportCity.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelAirportCity.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelAirportCity.setText("Airport city:");

        jLabelAirportCountry.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelAirportCountry.setText("Airport country:");

        jTextFieldAirportCountry.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jTextFieldAirportLatitude.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelAirportLatitude.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelAirportLatitude.setText("Airport latitude:");

        jLabelAirportLongitude.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelAirportLongitude.setText("Airport longitude:");

        jTextFieldAirportLongitude.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jButtonCreateLocation.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonCreateLocation.setText("Create");
        jButtonCreateLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLocationRegistrationLayout = new javax.swing.GroupLayout(jPanelLocationRegistration);
        jPanelLocationRegistration.setLayout(jPanelLocationRegistrationLayout);
        jPanelLocationRegistrationLayout.setHorizontalGroup(
            jPanelLocationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLocationRegistrationLayout.createSequentialGroup()
                .addGroup(jPanelLocationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLocationRegistrationLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanelLocationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAirportID)
                            .addComponent(jLabelAirportName)
                            .addComponent(jLabelAirportCity)
                            .addComponent(jLabelAirportCountry)
                            .addComponent(jLabelAirportLatitude)
                            .addComponent(jLabelAirportLongitude))
                        .addGap(80, 80, 80)
                        .addGroup(jPanelLocationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAirportLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAirportID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAirportName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAirportCity, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAirportCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAirportLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLocationRegistrationLayout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(jButtonCreateLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(494, 494, 494))
        );
        jPanelLocationRegistrationLayout.setVerticalGroup(
            jPanelLocationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLocationRegistrationLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanelLocationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLocationRegistrationLayout.createSequentialGroup()
                        .addComponent(jLabelAirportID)
                        .addGap(36, 36, 36)
                        .addComponent(jLabelAirportName)
                        .addGap(34, 34, 34)
                        .addComponent(jLabelAirportCity)
                        .addGap(35, 35, 35)
                        .addComponent(jLabelAirportCountry)
                        .addGap(35, 35, 35)
                        .addComponent(jLabelAirportLatitude))
                    .addGroup(jPanelLocationRegistrationLayout.createSequentialGroup()
                        .addComponent(jTextFieldAirportID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jTextFieldAirportName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jTextFieldAirportCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextFieldAirportCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextFieldAirportLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanelLocationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAirportLongitude)
                    .addComponent(jTextFieldAirportLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButtonCreateLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jTabbedPane.addTab("Location registration", jPanelLocationRegistration);

        jLabelIDFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelIDFlightRegistration.setText("ID:");

        jTextFieldIDFlightRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelPlaneFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelPlaneFlightRegistration.setText("Plane:");

        jComboBoxPlaneFlightRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxPlaneFlightRegister.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plane" }));

        jComboBoxDepartureLocationFlightRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxDepartureLocationFlightRegister.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        jLabelDepartureLocationFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelDepartureLocationFlightRegistration.setText("Departure location:");

        jComboBoxArrivalLocationFlightRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxArrivalLocationFlightRegister.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        jLabelArrivalLocationFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelArrivalLocationFlightRegistration.setText("Arrival location:");

        jLabelScaleLocationFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelScaleLocationFlightRegistration.setText("Scale location:");

        jComboBoxScaleLocationFlightRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxScaleLocationFlightRegister.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        jLabelScaleDurationFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelScaleDurationFlightRegistration.setText("Duration:");

        jLabelArrivalDurationFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelArrivalDurationFlightRegistration.setText("Duration:");

        jLabelDepartureDateFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelDepartureDateFlightRegistration.setText("Departure date:");

        jTextFieldDepartureYear.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelMinus1DepartureFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinus1DepartureFlightRegistration.setText("-");

        JComboBoxDepartureMonth.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxDepartureMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

        jLabelMinus2DepartureFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinus2DepartureFlightRegistration.setText("-");

        JComboBoxDepartureDay.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxDepartureDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        jLabelMinus3DepartureFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinus3DepartureFlightRegistration.setText("-");

        JComboBoxDepartureHour.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxDepartureHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel33.setText("-");

        JComboBoxDepartureMinute.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxDepartureMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        JComboBoxHourArrival.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxHourArrival.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabelMinusArrivalFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinusArrivalFlightRegistration.setText("-");

        JComboBoxMinuteArrival.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxMinuteArrival.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        jLabelMinusScaleFlightRegistration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinusScaleFlightRegistration.setText("-");

        JComboBoxHourScale.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxHourScale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        JComboBoxMinuteScale.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxMinuteScale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        jButtonCreateFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonCreateFlight.setText("Create");
        jButtonCreateFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateFlightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelFlightRegistrationLayout = new javax.swing.GroupLayout(JPanelFlightRegistration);
        JPanelFlightRegistration.setLayout(JPanelFlightRegistrationLayout);
        JPanelFlightRegistrationLayout.setHorizontalGroup(
            JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                        .addComponent(jLabelScaleLocationFlightRegistration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxScaleLocationFlightRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelFlightRegistrationLayout.createSequentialGroup()
                        .addComponent(jLabelArrivalLocationFlightRegistration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxArrivalLocationFlightRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                        .addComponent(jLabelDepartureLocationFlightRegistration)
                        .addGap(46, 46, 46)
                        .addComponent(jComboBoxDepartureLocationFlightRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIDFlightRegistration)
                            .addComponent(jLabelPlaneFlightRegistration))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIDFlightRegister)
                            .addComponent(jComboBoxPlaneFlightRegister, 0, 130, Short.MAX_VALUE))))
                .addGap(45, 45, 45)
                .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelScaleDurationFlightRegistration)
                    .addComponent(jLabelArrivalDurationFlightRegistration)
                    .addComponent(jLabelDepartureDateFlightRegistration))
                .addGap(18, 18, 18)
                .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                        .addComponent(jTextFieldDepartureYear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(JComboBoxDepartureMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelMinus1DepartureFlightRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMinus2DepartureFlightRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(JComboBoxDepartureDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(JComboBoxDepartureHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelMinus3DepartureFlightRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(JComboBoxDepartureMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                                .addComponent(JComboBoxHourArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMinusArrivalFlightRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(JComboBoxMinuteArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                                .addComponent(JComboBoxHourScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMinusScaleFlightRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(JComboBoxMinuteScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelFlightRegistrationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCreateFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(530, 530, 530))
        );
        JPanelFlightRegistrationLayout.setVerticalGroup(
            JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelIDFlightRegistration))
                    .addComponent(jTextFieldIDFlightRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlaneFlightRegistration)
                    .addComponent(jComboBoxPlaneFlightRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JComboBoxDepartureHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMinus3DepartureFlightRegistration)
                    .addComponent(jLabel33)
                    .addComponent(JComboBoxDepartureMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPanelFlightRegistrationLayout.createSequentialGroup()
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDepartureLocationFlightRegistration)
                                .addComponent(jComboBoxDepartureLocationFlightRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelDepartureDateFlightRegistration))
                            .addComponent(jTextFieldDepartureYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JComboBoxDepartureMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMinus1DepartureFlightRegistration)
                            .addComponent(jLabelMinus2DepartureFlightRegistration)
                            .addComponent(JComboBoxDepartureDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelArrivalLocationFlightRegistration)
                                .addComponent(jComboBoxArrivalLocationFlightRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelArrivalDurationFlightRegistration))
                            .addComponent(JComboBoxHourArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMinusArrivalFlightRegistration)
                            .addComponent(JComboBoxMinuteArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JComboBoxHourScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMinusScaleFlightRegistration)
                            .addComponent(JComboBoxMinuteScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanelFlightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelScaleLocationFlightRegistration)
                                .addComponent(jComboBoxScaleLocationFlightRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelScaleDurationFlightRegistration)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButtonCreateFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jTabbedPane.addTab("Flight registration", JPanelFlightRegistration);

        jLabelIDUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelIDUpdateInfo.setText("ID:");

        jTextFieldIDUser.setEditable(false);
        jTextFieldIDUser.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jTextFieldIDUser.setEnabled(false);

        jLabelFirstNameUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelFirstNameUpdateInfo.setText("First Name:");

        jTextFieldFirstName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelLastNameUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelLastNameUpdateInfo.setText("Last Name:");

        jTextFieldLastName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelBirthdateUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelBirthdateUpdateInfo.setText("Birthdate:");

        jTextFieldDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        JComboBoxMonth.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

        JComboBoxDay.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        JComboBoxDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        jTextFieldPhone.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelMinusUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinusUpdateInfo.setText("-");

        jTextFieldPrefix.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabelPlusUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelPlusUpdateInfo.setText("+");

        jLabelPhoneUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelPhoneUpdateInfo.setText("Phone:");

        jLabelCountryUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelCountryUpdateInfo.setText("Country:");

        jTextFieldCountry.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jButtonUpdateUser.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonUpdateUser.setText("Update");
        jButtonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUpdateInfoLayout = new javax.swing.GroupLayout(jPanelUpdateInfo);
        jPanelUpdateInfo.setLayout(jPanelUpdateInfoLayout);
        jPanelUpdateInfoLayout.setHorizontalGroup(
            jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                .addGroup(jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                                .addComponent(jLabelIDUpdateInfo)
                                .addGap(108, 108, 108)
                                .addComponent(jTextFieldIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                                .addComponent(jLabelFirstNameUpdateInfo)
                                .addGap(41, 41, 41)
                                .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                                .addComponent(jLabelLastNameUpdateInfo)
                                .addGap(43, 43, 43)
                                .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                                .addComponent(jLabelBirthdateUpdateInfo)
                                .addGap(55, 55, 55)
                                .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(JComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(JComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                                .addComponent(jLabelPhoneUpdateInfo)
                                .addGap(56, 56, 56)
                                .addComponent(jLabelPlusUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jTextFieldPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabelMinusUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                                .addComponent(jLabelCountryUpdateInfo)
                                .addGap(63, 63, 63)
                                .addComponent(jTextFieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jButtonUpdateUser)))
                .addContainerGap(546, Short.MAX_VALUE))
        );
        jPanelUpdateInfoLayout.setVerticalGroup(
            jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateInfoLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIDUpdateInfo)
                    .addComponent(jTextFieldIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFirstNameUpdateInfo)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLastNameUpdateInfo)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBirthdateUpdateInfo)
                    .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPhoneUpdateInfo)
                    .addComponent(jLabelPlusUpdateInfo)
                    .addComponent(jTextFieldPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMinusUpdateInfo)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCountryUpdateInfo)
                    .addComponent(jTextFieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButtonUpdateUser)
                .addGap(113, 113, 113))
        );

        jTabbedPane.addTab("Update info", jPanelUpdateInfo);

        jTextFieldIDAddFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jTextFieldIDAddFlight.setEnabled(false);

        jLabelIDAddToFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelIDAddToFlight.setText("ID:");

        jLabelFlightAddToFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelFlightAddToFlight.setText("Flight:");

        jComboBoxFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flight" }));

        jButtonAddFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonAddFlight.setText("Add");
        jButtonAddFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFlightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAddToFlightLayout = new javax.swing.GroupLayout(jPanelAddToFlight);
        jPanelAddToFlight.setLayout(jPanelAddToFlightLayout);
        jPanelAddToFlightLayout.setHorizontalGroup(
            jPanelAddToFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddToFlightLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanelAddToFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIDAddToFlight)
                    .addComponent(jLabelFlightAddToFlight))
                .addGap(79, 79, 79)
                .addGroup(jPanelAddToFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIDAddFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(829, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddToFlightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(509, 509, 509))
        );
        jPanelAddToFlightLayout.setVerticalGroup(
            jPanelAddToFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddToFlightLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelAddToFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddToFlightLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelIDAddToFlight))
                    .addComponent(jTextFieldIDAddFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanelAddToFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFlightAddToFlight)
                    .addComponent(jComboBoxFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(jButtonAddFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        jTabbedPane.addTab("Add to flight", jPanelAddToFlight);

        jTableUserFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jTableUserFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Departure Date", "Arrival Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableUserFlights);

        jButtonRefreshMyFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonRefreshMyFlights.setText("Refresh");
        jButtonRefreshMyFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshMyFlightsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelShowMyFlightsLayout = new javax.swing.GroupLayout(jPanelShowMyFlights);
        jPanelShowMyFlights.setLayout(jPanelShowMyFlightsLayout);
        jPanelShowMyFlightsLayout.setHorizontalGroup(
            jPanelShowMyFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowMyFlightsLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelShowMyFlightsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRefreshMyFlights)
                .addGap(527, 527, 527))
        );
        jPanelShowMyFlightsLayout.setVerticalGroup(
            jPanelShowMyFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowMyFlightsLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonRefreshMyFlights)
                .addContainerGap())
        );

        jTabbedPane.addTab("Show my flights", jPanelShowMyFlights);

        jTablePassengers.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jTablePassengers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Birthdate", "Age", "Phone", "Country", "Num Flight"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablePassengers);

        jButtonRefreshPassengers.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonRefreshPassengers.setText("Refresh");
        jButtonRefreshPassengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshPassengersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelShowAllPassengersLayout = new javax.swing.GroupLayout(jPanelShowAllPassengers);
        jPanelShowAllPassengers.setLayout(jPanelShowAllPassengersLayout);
        jPanelShowAllPassengersLayout.setHorizontalGroup(
            jPanelShowAllPassengersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowAllPassengersLayout.createSequentialGroup()
                .addGroup(jPanelShowAllPassengersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelShowAllPassengersLayout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(jButtonRefreshPassengers))
                    .addGroup(jPanelShowAllPassengersLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelShowAllPassengersLayout.setVerticalGroup(
            jPanelShowAllPassengersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelShowAllPassengersLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRefreshPassengers)
                .addContainerGap())
        );

        jTabbedPane.addTab("Show all passengers", jPanelShowAllPassengers);

        jTableAllFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jTableAllFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Departure Airport ID", "Arrival Airport ID", "Scale Airport ID", "Departure Date", "Arrival Date", "Plane ID", "Number Passengers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableAllFlights);

        jButtonRefreshAllFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonRefreshAllFlights.setText("Refresh");
        jButtonRefreshAllFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshAllFlightsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelShowAllFlightsLayout = new javax.swing.GroupLayout(jPanelShowAllFlights);
        jPanelShowAllFlights.setLayout(jPanelShowAllFlightsLayout);
        jPanelShowAllFlightsLayout.setHorizontalGroup(
            jPanelShowAllFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowAllFlightsLayout.createSequentialGroup()
                .addGroup(jPanelShowAllFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelShowAllFlightsLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelShowAllFlightsLayout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(jButtonRefreshAllFlights)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelShowAllFlightsLayout.setVerticalGroup(
            jPanelShowAllFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowAllFlightsLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRefreshAllFlights)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Show all flights", jPanelShowAllFlights);

        jButtonRefreshAllPlanes.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonRefreshAllPlanes.setText("Refresh");
        jButtonRefreshAllPlanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshAllPlanesActionPerformed(evt);
            }
        });

        jTableAllPlanes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand", "Model", "Max Capacity", "Airline", "Number Flights"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableAllPlanes);

        javax.swing.GroupLayout jPanelShowAllPlanesLayout = new javax.swing.GroupLayout(jPanelShowAllPlanes);
        jPanelShowAllPlanes.setLayout(jPanelShowAllPlanesLayout);
        jPanelShowAllPlanesLayout.setHorizontalGroup(
            jPanelShowAllPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowAllPlanesLayout.createSequentialGroup()
                .addGroup(jPanelShowAllPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelShowAllPlanesLayout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(jButtonRefreshAllPlanes))
                    .addGroup(jPanelShowAllPlanesLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanelShowAllPlanesLayout.setVerticalGroup(
            jPanelShowAllPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelShowAllPlanesLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonRefreshAllPlanes)
                .addGap(17, 17, 17))
        );

        jTabbedPane.addTab("Show all planes", jPanelShowAllPlanes);

        jTableAllLocations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airport ID", "Airport Name", "City", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableAllLocations);

        jButtonRefreshAllLocations.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonRefreshAllLocations.setText("Refresh");
        jButtonRefreshAllLocations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshAllLocationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelShowAllLocationsLayout = new javax.swing.GroupLayout(jPanelShowAllLocations);
        jPanelShowAllLocations.setLayout(jPanelShowAllLocationsLayout);
        jPanelShowAllLocationsLayout.setHorizontalGroup(
            jPanelShowAllLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowAllLocationsLayout.createSequentialGroup()
                .addGroup(jPanelShowAllLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelShowAllLocationsLayout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(jButtonRefreshAllLocations))
                    .addGroup(jPanelShowAllLocationsLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        jPanelShowAllLocationsLayout.setVerticalGroup(
            jPanelShowAllLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelShowAllLocationsLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonRefreshAllLocations)
                .addGap(17, 17, 17))
        );

        jTabbedPane.addTab("Show all locations", jPanelShowAllLocations);

        jComboBoxHour.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabelHoursDelayFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelHoursDelayFlight.setText("Hours:");

        jLabelIDDelayFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelIDDelayFlight.setText("ID:");

        jComboBoxIDDelayFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxIDDelayFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID" }));

        jLabelMinutesDelayFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabelMinutesDelayFlight.setText("Minutes:");

        jComboBoxMinute.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jComboBoxMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        jButtonDelay.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButtonDelay.setText("Delay");
        jButtonDelay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDelayFlightLayout = new javax.swing.GroupLayout(jPanelDelayFlight);
        jPanelDelayFlight.setLayout(jPanelDelayFlightLayout);
        jPanelDelayFlightLayout.setHorizontalGroup(
            jPanelDelayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDelayFlightLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanelDelayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDelayFlightLayout.createSequentialGroup()
                        .addComponent(jLabelMinutesDelayFlight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDelayFlightLayout.createSequentialGroup()
                        .addGroup(jPanelDelayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIDDelayFlight)
                            .addComponent(jLabelHoursDelayFlight))
                        .addGap(79, 79, 79)
                        .addGroup(jPanelDelayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxHour, 0, 105, Short.MAX_VALUE)
                            .addComponent(jComboBoxIDDelayFlight, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(820, 820, 820))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDelayFlightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDelay)
                .addGap(531, 531, 531))
        );
        jPanelDelayFlightLayout.setVerticalGroup(
            jPanelDelayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDelayFlightLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelDelayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDDelayFlight)
                    .addComponent(jComboBoxIDDelayFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanelDelayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoursDelayFlight)
                    .addComponent(jComboBoxHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanelDelayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMinutesDelayFlight)
                    .addComponent(jComboBoxMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(jButtonDelay)
                .addGap(33, 33, 33))
        );

        jTabbedPane.addTab("Delay flight", jPanelDelayFlight);

        panelRoundMiddle.add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 1150, 620));

        javax.swing.GroupLayout panelRoundDownLayout = new javax.swing.GroupLayout(panelRoundDown);
        panelRoundDown.setLayout(panelRoundDownLayout);
        panelRoundDownLayout.setHorizontalGroup(
            panelRoundDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        panelRoundDownLayout.setVerticalGroup(
            panelRoundDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelRoundMiddle.add(panelRoundDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 660, 1150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundMiddle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundMiddle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void panelRoundUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRoundUpMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panelRoundUpMousePressed

    private void panelRoundUpMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRoundUpMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_panelRoundUpMouseDragged

    private void JRadioButtonAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRadioButtonAdministratorActionPerformed
        if (JRadioButtonUser.isSelected()) {
            JRadioButtonUser.setSelected(false);
            JComboBoxUserSelect.setSelectedIndex(0);

        }
        for (int i = 1; i < jTabbedPane.getTabCount(); i++) {
            jTabbedPane.setEnabledAt(i, true);
        }
        jTabbedPane.setEnabledAt(5, false);
        jTabbedPane.setEnabledAt(6, false);
    }//GEN-LAST:event_JRadioButtonAdministratorActionPerformed

    private void JRadioButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRadioButtonUserActionPerformed
        if (JRadioButtonAdministrator.isSelected()) {
            JRadioButtonAdministrator.setSelected(false);
        }
        for (int i = 1; i < jTabbedPane.getTabCount(); i++) {

            jTabbedPane.setEnabledAt(i, false);

        }
        jTabbedPane.setEnabledAt(9, true);
        jTabbedPane.setEnabledAt(5, true);
        jTabbedPane.setEnabledAt(6, true);
        jTabbedPane.setEnabledAt(7, true);
        jTabbedPane.setEnabledAt(11, true);
    }//GEN-LAST:event_JRadioButtonUserActionPerformed

    private void jButtonRegisterPassengerPassengerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterPassengerPassengerActionPerformed
        // TODO add your handling code here:
        String id = jTextFieldIDUserRegister.getText();
        String firstname = jTextFieldFirstNameUserRegister.getText();
        String lastname = jTextFieldLastNameUserRegister.getText();
        String year = jTextFieldYearRegister.getText();
        String month = JComboBoxMonthUserRegister.getItemAt(JComboBoxMonthUserRegister.getSelectedIndex());
        String day = JComboBoxDayUserRegister.getItemAt(JComboBoxDayUserRegister.getSelectedIndex());
        String phoneCode = jTextFieldPrefixUserRegister.getText();
        String phone = jTextFieldPhoneUserRegister.getText();
        String country = jTextFieldCountryUserRegister.getText();

        Response response = PassengerControler.createPassenger(id, firstname, lastname, year, month, day, phoneCode, phone, country);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            jTextFieldIDUserRegister.setText("");
            jTextFieldFirstNameUserRegister.setText("");
            jTextFieldLastNameUserRegister.setText("");
            jTextFieldYearRegister.setText("");
            JComboBoxMonthUserRegister.setSelectedItem("Month");
            JComboBoxDayUserRegister.setSelectedItem("Day");
            jTextFieldPrefixUserRegister.setText("");
            jTextFieldPhoneUserRegister.setText("");
            jTextFieldCountryUserRegister.setText("");

            this.JComboBoxUserSelect.addItem("" + id);
        }

        //LocalDate birthDate = LocalDate.of(year, month, day);
        //this.passengers.add(new Passenger(id, firstname, lastname, birthDate, phoneCode, phone, country));

    }//GEN-LAST:event_jButtonRegisterPassengerPassengerActionPerformed

    private void jButtonCreateAirPlaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateAirPlaneActionPerformed
        // TODO add your handling code here:
        String id = jTextFieldIDAirPlaneRegister.getText();
        String brand = jTextFieldBrandAirPlaneRegister.getText();
        String model = jTextFieldModelAirPlaneRegister.getText();
        String maxCapacity = jTextFieldMaxCapacityAirPlaneRegister.getText();
        String airline = jTextFieldAirlineAirPlaneRegister.getText();

//        this.planes.add(new Plane(id, brand, model, maxCapacity, airline));
        Response response = PlaneController.createPlane(id, brand, model, maxCapacity, airline);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            jTextFieldIDAirPlaneRegister.setText("");
            jTextFieldBrandAirPlaneRegister.setText("");
            jTextFieldModelAirPlaneRegister.setText("");
            jTextFieldMaxCapacityAirPlaneRegister.setText("");
            jTextFieldAirlineAirPlaneRegister.setText("");

            this.jComboBoxPlaneFlightRegister.addItem(id);
        }
    }//GEN-LAST:event_jButtonCreateAirPlaneActionPerformed

    private void jButtonCreateLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateLocationActionPerformed
        // TODO add your handling code here:
        String id = jTextFieldAirportID.getText();
        String name = jTextFieldAirportName.getText();
        String city = jTextFieldAirportCity.getText();
        String country = jTextFieldAirportCountry.getText();
        String latitude = jTextFieldAirportLatitude.getText();
        String longitude = jTextFieldAirportLongitude.getText();

        //  this.locations.add(new Location(id, name, city, country, latitude, longitude));
        Response response = CreateLocationController.createLocation(id, name, city, country, latitude, longitude);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            jTextFieldAirportID.setText("");
            jTextFieldAirportName.setText("");
            jTextFieldAirportCity.setText("");
            jTextFieldAirportCountry.setText("");
            jTextFieldAirportLatitude.setText("");
            jTextFieldAirportLongitude.setText("");

            this.jComboBoxDepartureLocationFlightRegister.addItem(id);
            this.jComboBoxArrivalLocationFlightRegister.addItem(id);
            this.jComboBoxScaleLocationFlightRegister.addItem(id);
        }
    }//GEN-LAST:event_jButtonCreateLocationActionPerformed

    private void jButtonCreateFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateFlightActionPerformed
        // TODO add your handling code here:
        String id = jTextFieldIDFlightRegister.getText();
        String planeId = jComboBoxPlaneFlightRegister.getItemAt(jComboBoxPlaneFlightRegister.getSelectedIndex());
        String departureLocationId = jComboBoxDepartureLocationFlightRegister.getItemAt(jComboBoxDepartureLocationFlightRegister.getSelectedIndex());
        String arrivalLocationId = jComboBoxArrivalLocationFlightRegister.getItemAt(jComboBoxArrivalLocationFlightRegister.getSelectedIndex());
        String scaleLocationId = jComboBoxScaleLocationFlightRegister.getItemAt(jComboBoxScaleLocationFlightRegister.getSelectedIndex());
        String year = jTextFieldDepartureYear.getText();
        String month = JComboBoxDepartureMonth.getItemAt(JComboBoxDepartureMonth.getSelectedIndex());
        String day = JComboBoxDepartureDay.getItemAt(JComboBoxDepartureDay.getSelectedIndex());
        String hour = JComboBoxDepartureHour.getItemAt(JComboBoxDepartureHour.getSelectedIndex());
        String minutes = JComboBoxDepartureMinute.getItemAt(JComboBoxDepartureMinute.getSelectedIndex());
        String hoursDurationsArrival = JComboBoxHourArrival.getItemAt(JComboBoxHourArrival.getSelectedIndex());
        String minutesDurationsArrival = JComboBoxMinuteArrival.getItemAt(JComboBoxMinuteArrival.getSelectedIndex());
        String hoursDurationsScale = JComboBoxHourScale.getItemAt(JComboBoxHourScale.getSelectedIndex());
        String minutesDurationsScale = JComboBoxMinuteScale.getItemAt(JComboBoxMinuteScale.getSelectedIndex());

        Response response = CreateFlightController.createFlight(id, planeId, departureLocationId, arrivalLocationId,
                scaleLocationId, year, month, day, hour, minutes, hoursDurationsArrival,
                minutesDurationsArrival, hoursDurationsScale,
                minutesDurationsScale);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            jTextFieldIDFlightRegister.setText("");
            jComboBoxPlaneFlightRegister.setSelectedItem("Plane");
            jComboBoxDepartureLocationFlightRegister.setSelectedItem("Location");
            jComboBoxArrivalLocationFlightRegister.setSelectedItem("Location");
            jComboBoxDepartureLocationFlightRegister.setSelectedItem("Location");
            jTextFieldDepartureYear.setText("");
            JComboBoxDepartureMonth.setSelectedItem("Month");
            JComboBoxDepartureDay.setSelectedItem("Day");
            JComboBoxDepartureHour.setSelectedItem("Hour");
            JComboBoxDepartureMinute.setSelectedItem("Minute");
            JComboBoxHourArrival.setSelectedItem("Hour");
            JComboBoxMinuteArrival.setSelectedItem("Minute");
            JComboBoxHourScale.setSelectedItem("Hour");
            JComboBoxMinuteScale.setSelectedItem("Minute");

            this.jComboBoxFlight.addItem(id);
            this.jComboBoxIDDelayFlight.addItem(id);
        }

//        LocalDateTime departureDate = LocalDateTime.of(year, month, day, hour, minutes);
//
//        Plane plane = null;
//        for (Plane p : this.planes) {
//            if (planeId.equals(p.getId())) {
//                plane = p;
//            }
//        }
//
//        Location departure = null;
//        Location arrival = null;
//        Location scale = null;
//        for (Location location : this.locations) {
//            if (departureLocationId.equals(location.getAirportId())) {
//                departure = location;
//            }
//            if (arrivalLocationId.equals(location.getAirportId())) {
//                arrival = location;
//            }
//            if (scaleLocationId.equals(location.getAirportId())) {
//                scale = location;
//            }
//        }
//
//        if (scale == null) {
//            this.flights.add(new Flight(id, plane, departure, arrival, departureDate, hoursDurationsArrival, minutesDurationsArrival));
//        } else {
//            this.flights.add(new Flight(id, plane, departure, scale, arrival, departureDate, hoursDurationsArrival, minutesDurationsArrival, hoursDurationsScale, minutesDurationsScale));
//        }
    }//GEN-LAST:event_jButtonCreateFlightActionPerformed

    private void jButtonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateUserActionPerformed
        // TODO add your handling code here:
        String id = jTextFieldIDUser.getText();
        String firstname = jTextFieldFirstName.getText();
        String lastname = jTextFieldLastName.getText();
        String year = jTextFieldDate.getText();
        String month = JComboBoxMonthUserRegister.getItemAt(JComboBoxMonth.getSelectedIndex());
        String day = JComboBoxDayUserRegister.getItemAt(JComboBoxDay.getSelectedIndex());
        String phoneCode = jTextFieldPrefix.getText();
        String phone = jTextFieldPhone.getText();
        String country = jTextFieldCountry.getText();

        Response response = PassengerControler.updatePassenger(id, firstname, lastname, year, month, day, phoneCode, phone, country);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            jTextFieldIDUser.setText("");
            jTextFieldFirstName.setText("");
            jTextFieldLastName.setText("");
            jTextFieldDate.setText("");
            JComboBoxMonth.setSelectedItem("Month");
            JComboBoxDay.setSelectedItem("Day");
            jTextFieldPrefix.setText("");
            jTextFieldPhone.setText("");
            jTextFieldCountry.setText("");
        }

//        LocalDate birthDate = LocalDate.of(year, month, day);
//
//        Passenger passenger = null;
//        for (Passenger p : this.passengers) {
//            if (p.getId() == id) {
//                passenger = p;
//            }
//        }
//
//        passenger.setFirstname(firstname);
//        passenger.setLastname(lastname);
//        passenger.setBirthDate(birthDate);
//        passenger.setCountryPhoneCode(phoneCode);
//        passenger.setPhone(phone);
//        passenger.setCountry(country);
    }//GEN-LAST:event_jButtonUpdateUserActionPerformed

    private void jButtonAddFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFlightActionPerformed
        // TODO add your handling code here:
        String passengerId = jTextFieldIDAddFlight.getText();
        String flightId = jComboBoxFlight.getItemAt(jComboBoxFlight.getSelectedIndex());

        Response response = AddPassengerToFlightController.addPassengerToFlight(flightId, passengerId);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldIDAddFlight.setText("");
            jComboBoxFlight.setSelectedItem("Flight");
        }

//        for (Passenger p : this.passengers) {
//            if (p.getId() == passengerId) {
//                passenger = p;
//            }
//        }
//
//        for (Flight f : this.flights) {
//            if (flightId.equals(f.getId())) {
//                flight = f;
//            }
//        }
//
//        passenger.addFlight(flight);
//        flight.addPassenger(passenger);
    }//GEN-LAST:event_jButtonAddFlightActionPerformed

    private void jButtonDelayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelayActionPerformed
        // TODO add your handling code here:
        String flightId = jComboBoxIDDelayFlight.getItemAt(jComboBoxIDDelayFlight.getSelectedIndex());
        String hours = jComboBoxHour.getItemAt(jComboBoxHour.getSelectedIndex());
        String minutes = jComboBoxMinute.getItemAt(jComboBoxMinute.getSelectedIndex());

        Response response = DelayFlightController.delayFlight(flightId, hours, minutes);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            jComboBoxIDDelayFlight.setSelectedItem("ID");
            jComboBoxHour.setSelectedItem("Hour");
            jComboBoxMinute.setSelectedItem("Minute");
        }
//        Flight flight = null;
//        for (Flight f : this.flights) {
//            if (flightId.equals(f.getId())) {
//                flight = f;
//            }
//        }
//
//        flight.delay(hours, minutes);
    }//GEN-LAST:event_jButtonDelayActionPerformed

    private void jButtonRefreshMyFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshMyFlightsActionPerformed
        // TODO add your handling code here:
        String passengerId = JComboBoxUserSelect.getItemAt(JComboBoxUserSelect.getSelectedIndex());

//        Passenger passenger = null;
//        for (Passenger p : this.passengers) {
//            if (p.getId() == passengerId) {
//                passenger = p;
//            }
//        }
        Response response = PassengerControler.getPassengerFlights(passengerId);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            List<Flight> flights = (List<Flight>) response.getObject();

            DefaultTableModel model = (DefaultTableModel) jTableUserFlights.getModel();
            model.setRowCount(0);
            for (Flight flight : flights) {
                model.addRow(new Object[]{flight.getId(), flight.getDepartureDate(), flight.calculateArrivalDate()});
            }
        }
    }//GEN-LAST:event_jButtonRefreshMyFlightsActionPerformed

    private void jButtonRefreshPassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshPassengersActionPerformed
        // TODO add your handling code here:
        Response response = PassengerControler.getAllPassengers();

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            DefaultTableModel model = (DefaultTableModel) jTablePassengers.getModel();
            model.setRowCount(0);
            List<Passenger> passengers = (List<Passenger>) response.getObject();
            for (Passenger passenger : passengers) {
                model.addRow(new Object[]{passenger.getId(), passenger.getFullname(), passenger.getBirthDate(), passenger.calculateAge(), passenger.generateFullPhone(), passenger.getCountry(), passenger.getNumFlights()});
            }
        }


    }//GEN-LAST:event_jButtonRefreshPassengersActionPerformed

    private void jButtonRefreshAllFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshAllFlightsActionPerformed
        // TODO add your handling code here:
        Response response = GetAllFlightsController.getAllFlights();

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            DefaultTableModel model = (DefaultTableModel) jTableAllFlights.getModel();
            model.setRowCount(0);
            List<Flight> flights = (List<Flight>) response.getObject();
            for (Flight flight : flights) {
                model.addRow(new Object[]{flight.getId(), flight.getDepartureLocation().getAirportId(), flight.getArrivalLocation().getAirportId(), (flight.getScaleLocation() == null ? "-" : flight.getScaleLocation().getAirportId()), flight.getDepartureDate(), flight.calculateArrivalDate(), flight.getPlane().getId(), flight.getNumPassengers()});
            }
        }
    }//GEN-LAST:event_jButtonRefreshAllFlightsActionPerformed

    private void jButtonRefreshAllPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshAllPlanesActionPerformed
        // TODO add your handling code here:

        Response response = PlaneController.getAllPlanes();

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            DefaultTableModel model = (DefaultTableModel) jTableAllPlanes.getModel();
            model.setRowCount(0);
            List<Plane> planes = (List<Plane>) response.getObject();
            for (Plane plane : planes) {
                model.addRow(new Object[]{plane.getId(), plane.getBrand(), plane.getModel(), plane.getMaxCapacity(), plane.getAirline(), plane.getNumFlights()});
            }
        }


    }//GEN-LAST:event_jButtonRefreshAllPlanesActionPerformed

    private void jButtonRefreshAllLocationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshAllLocationsActionPerformed
        // TODO add your handling code here:
        Response response = GetAllLocationsController.getAllLocations();

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

            DefaultTableModel model = (DefaultTableModel) jTableAllLocations.getModel();
            model.setRowCount(0);
            List<Location> locations = (List<Location>) response.getObject();
            for (Location location : locations) {
                model.addRow(new Object[]{location.getAirportId(), location.getAirportName(), location.getAirportCity(), location.getAirportCountry()});
            }
        }


    }//GEN-LAST:event_jButtonRefreshAllLocationsActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void JComboBoxUserSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxUserSelectActionPerformed
        try {
            String id = JComboBoxUserSelect.getSelectedItem().toString();
            if (!id.equals(JComboBoxUserSelect.getItemAt(0))) {
                jTextFieldIDUser.setText(id);
                jTextFieldIDAddFlight.setText(id);
            } else {
                jTextFieldIDUser.setText("");
                jTextFieldIDAddFlight.setText("");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_JComboBoxUserSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBoxDay;
    private javax.swing.JComboBox<String> JComboBoxDayUserRegister;
    private javax.swing.JComboBox<String> JComboBoxDepartureDay;
    private javax.swing.JComboBox<String> JComboBoxDepartureHour;
    private javax.swing.JComboBox<String> JComboBoxDepartureMinute;
    private javax.swing.JComboBox<String> JComboBoxDepartureMonth;
    private javax.swing.JComboBox<String> JComboBoxHourArrival;
    private javax.swing.JComboBox<String> JComboBoxHourScale;
    private javax.swing.JComboBox<String> JComboBoxMinuteArrival;
    private javax.swing.JComboBox<String> JComboBoxMinuteScale;
    private javax.swing.JComboBox<String> JComboBoxMonth;
    private javax.swing.JComboBox<String> JComboBoxMonthUserRegister;
    private javax.swing.JComboBox<String> JComboBoxUserSelect;
    private javax.swing.JPanel JPanelFlightRegistration;
    private javax.swing.JRadioButton JRadioButtonAdministrator;
    private javax.swing.JRadioButton JRadioButtonUser;
    private javax.swing.JButton jButtonAddFlight;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonCreateAirPlane;
    private javax.swing.JButton jButtonCreateFlight;
    private javax.swing.JButton jButtonCreateLocation;
    private javax.swing.JButton jButtonDelay;
    private javax.swing.JButton jButtonRefreshAllFlights;
    private javax.swing.JButton jButtonRefreshAllLocations;
    private javax.swing.JButton jButtonRefreshAllPlanes;
    private javax.swing.JButton jButtonRefreshMyFlights;
    private javax.swing.JButton jButtonRefreshPassengers;
    private javax.swing.JButton jButtonRegisterPassenger;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JComboBox<String> jComboBoxArrivalLocationFlightRegister;
    private javax.swing.JComboBox<String> jComboBoxDepartureLocationFlightRegister;
    private javax.swing.JComboBox<String> jComboBoxFlight;
    private javax.swing.JComboBox<String> jComboBoxHour;
    private javax.swing.JComboBox<String> jComboBoxIDDelayFlight;
    private javax.swing.JComboBox<String> jComboBoxMinute;
    private javax.swing.JComboBox<String> jComboBoxPlaneFlightRegister;
    private javax.swing.JComboBox<String> jComboBoxScaleLocationFlightRegister;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabelAirlineAirplaneRegistration;
    private javax.swing.JLabel jLabelAirportCity;
    private javax.swing.JLabel jLabelAirportCountry;
    private javax.swing.JLabel jLabelAirportID;
    private javax.swing.JLabel jLabelAirportLatitude;
    private javax.swing.JLabel jLabelAirportLongitude;
    private javax.swing.JLabel jLabelAirportName;
    private javax.swing.JLabel jLabelArrivalDurationFlightRegistration;
    private javax.swing.JLabel jLabelArrivalLocationFlightRegistration;
    private javax.swing.JLabel jLabelBirthdatePassengerRegistration;
    private javax.swing.JLabel jLabelBirthdateUpdateInfo;
    private javax.swing.JLabel jLabelBrandAirplaneRegistration;
    private javax.swing.JLabel jLabelCountryPassengerRegistration;
    private javax.swing.JLabel jLabelCountryUpdateInfo;
    private javax.swing.JLabel jLabelDepartureDateFlightRegistration;
    private javax.swing.JLabel jLabelDepartureLocationFlightRegistration;
    private javax.swing.JLabel jLabelFirstNamePassengerRegistration;
    private javax.swing.JLabel jLabelFirstNameUpdateInfo;
    private javax.swing.JLabel jLabelFlightAddToFlight;
    private javax.swing.JLabel jLabelHoursDelayFlight;
    private javax.swing.JLabel jLabelIDAddToFlight;
    private javax.swing.JLabel jLabelIDAirplaneRegistration;
    private javax.swing.JLabel jLabelIDDelayFlight;
    private javax.swing.JLabel jLabelIDFlightRegistration;
    private javax.swing.JLabel jLabelIDPassengerRegistration;
    private javax.swing.JLabel jLabelIDUpdateInfo;
    private javax.swing.JLabel jLabelLastNamePassengerRegistration;
    private javax.swing.JLabel jLabelLastNameUpdateInfo;
    private javax.swing.JLabel jLabelMaxCapacityAirplaneRegistration;
    private javax.swing.JLabel jLabelMinus1DepartureFlightRegistration;
    private javax.swing.JLabel jLabelMinus2DepartureFlightRegistration;
    private javax.swing.JLabel jLabelMinus3DepartureFlightRegistration;
    private javax.swing.JLabel jLabelMinusArrivalFlightRegistration;
    private javax.swing.JLabel jLabelMinusBirthdate1PassengerRegistration;
    private javax.swing.JLabel jLabelMinusBirthdate2PassengerRegistration;
    private javax.swing.JLabel jLabelMinusPhonePassengerRegistration;
    private javax.swing.JLabel jLabelMinusScaleFlightRegistration;
    private javax.swing.JLabel jLabelMinusUpdateInfo;
    private javax.swing.JLabel jLabelMinutesDelayFlight;
    private javax.swing.JLabel jLabelModelAirplaneRegistration;
    private javax.swing.JLabel jLabelPhonePassengerRegistration;
    private javax.swing.JLabel jLabelPhoneUpdateInfo;
    private javax.swing.JLabel jLabelPlaneFlightRegistration;
    private javax.swing.JLabel jLabelPlusPassengerRegistration;
    private javax.swing.JLabel jLabelPlusUpdateInfo;
    private javax.swing.JLabel jLabelScaleDurationFlightRegistration;
    private javax.swing.JLabel jLabelScaleLocationFlightRegistration;
    private javax.swing.JPanel jPanelAddToFlight;
    private javax.swing.JPanel jPanelAdministration;
    private javax.swing.JPanel jPanelAirplaneRegistration;
    private javax.swing.JPanel jPanelDelayFlight;
    private javax.swing.JPanel jPanelLocationRegistration;
    private javax.swing.JPanel jPanelPassengerRegistration;
    private javax.swing.JPanel jPanelShowAllFlights;
    private javax.swing.JPanel jPanelShowAllLocations;
    private javax.swing.JPanel jPanelShowAllPassengers;
    private javax.swing.JPanel jPanelShowAllPlanes;
    private javax.swing.JPanel jPanelShowMyFlights;
    private javax.swing.JPanel jPanelUpdateInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableAllFlights;
    private javax.swing.JTable jTableAllLocations;
    private javax.swing.JTable jTableAllPlanes;
    private javax.swing.JTable jTablePassengers;
    private javax.swing.JTable jTableUserFlights;
    private javax.swing.JTextField jTextFieldAirlineAirPlaneRegister;
    private javax.swing.JTextField jTextFieldAirportCity;
    private javax.swing.JTextField jTextFieldAirportCountry;
    private javax.swing.JTextField jTextFieldAirportID;
    private javax.swing.JTextField jTextFieldAirportLatitude;
    private javax.swing.JTextField jTextFieldAirportLongitude;
    private javax.swing.JTextField jTextFieldAirportName;
    private javax.swing.JTextField jTextFieldBrandAirPlaneRegister;
    private javax.swing.JTextField jTextFieldCountry;
    private javax.swing.JTextField jTextFieldCountryUserRegister;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldDepartureYear;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldFirstNameUserRegister;
    private javax.swing.JTextField jTextFieldIDAddFlight;
    private javax.swing.JTextField jTextFieldIDAirPlaneRegister;
    private javax.swing.JTextField jTextFieldIDFlightRegister;
    private javax.swing.JTextField jTextFieldIDUser;
    private javax.swing.JTextField jTextFieldIDUserRegister;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldLastNameUserRegister;
    private javax.swing.JTextField jTextFieldMaxCapacityAirPlaneRegister;
    private javax.swing.JTextField jTextFieldModelAirPlaneRegister;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldPhoneUserRegister;
    private javax.swing.JTextField jTextFieldPrefix;
    private javax.swing.JTextField jTextFieldPrefixUserRegister;
    private javax.swing.JTextField jTextFieldYearRegister;
    private core.views.PanelRound panelRoundDown;
    private core.views.PanelRound panelRoundMiddle;
    private core.views.PanelRound panelRoundUp;
    // End of variables declaration//GEN-END:variables
}

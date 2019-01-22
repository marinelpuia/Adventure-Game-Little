package com.marinelp;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame window;
    Container container;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName,monsterHpLabel, monsterHpNumberLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
    Font buttonFont = new Font("Times New Roman", Font.BOLD, 30);
    Font generalTextFont = new Font("Times New Roman", Font.PLAIN, 17);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHp, monsterHp, silverRing;
    String weaponName, position;

    TitleScreenHandler titleScreenHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();


    public static void main(String[] args) {
        new Game();
    }

    /**
     * Method to create the main window and his panels.
     */

    public Game() {

        // CREATE THE MAIN WINDOW
        window = new JFrame("ADVENTURE MINI GAME");
        window.setSize(1200, 600);
        window.setLocationRelativeTo(null); // DISPLAY THE WINDOW ON THE MIDDLE OF THE SCREEN
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.WHITE);
        window.setLayout(null); // disable the default layout to use custom one.
        window.setVisible(true); // to show the window on the screen.

        container = window.getContentPane();
        window.revalidate();

        // TITLE NAME PANEL
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 1000, 150);
        titleNamePanel.setBackground(Color.WHITE);
        container.add(titleNamePanel);

        // TITLE NAME LABEL
        titleNameLabel = new JLabel("KILL THE GOBLIN");
        titleNameLabel.setForeground(Color.BLACK);
        titleNameLabel.setFont(titleFont);

        // ADD THE COMPONENTS TO THE APPROPRIATE PANELS
        titleNamePanel.add(titleNameLabel); // add the label text in the title name panel.
        titleNameLabel.revalidate();
        titleNamePanel.repaint();

        // START BUTTON PANEL
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500, 400, 200, 50);
        startButtonPanel.setBackground(Color.WHITE);
        container.add(startButtonPanel);

        // INITIAL START BUTTON
        startButton = new JButton("START");
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);
        startButton.setFont(buttonFont);
        startButton.setFocusPainted(false);
        startButton.setFocusable(false);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(true);
        startButton.setBorder(new LineBorder(Color.BLACK));
        startButton.addActionListener(titleScreenHandler); // GO TO THE NEXT WINDOW
        startButtonPanel.add(startButton);
        startButton.revalidate();
        startButton.repaint();
    }

    /**
     * Method to create the main text area and different panels
     */

    public void createGameScreen() {

        // DISABLE THE 2 PANELS FROM THE FIRST WINDOW TO update the panels from the button action
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // PANEL FOR TEXT AREA
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(300, 100, 600, 150);
        mainTextPanel.setBackground(Color.WHITE);

        container.add(mainTextPanel);

        // INITIAL TEXT AREA
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(300, 100, 600, 150);
        mainTextArea.setBackground(Color.WHITE);
        mainTextArea.setForeground(Color.BLACK);
        mainTextArea.setFont(generalTextFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // CHOICE BUTTON PANEL
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(500, 350, 200, 150);
        choiceButtonPanel.setBackground(Color.WHITE);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        container.add(choiceButtonPanel);

        // INITIAL CHOICE BUTTONS
        choice1 = new JButton("CHOICE 1 ");
        choice1.setBackground(Color.DARK_GRAY);
        choice1.setForeground(Color.WHITE);
        choice1.setFocusPainted(false);
        choice1.setFocusable(false);
        choice1.setContentAreaFilled(true);
        choice1.setBorder(new LineBorder(Color.WHITE));
        choice1.setFont(generalTextFont);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("btn_choice_1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("CHOICE 2 ");
        choice2.setBackground(Color.DARK_GRAY);
        choice2.setForeground(Color.WHITE);
        choice2.setFocusPainted(false);
        choice2.setFocusable(false);
        choice2.setContentAreaFilled(true);
        choice2.setBorder(new LineBorder(Color.WHITE));
        choice2.setFont(generalTextFont);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("btn_choice_2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("CHOICE 3 ");
        choice3.setBackground(Color.DARK_GRAY);
        choice3.setForeground(Color.WHITE);
        choice3.setFocusPainted(false);
        choice3.setFocusable(false);
        choice3.setContentAreaFilled(true);
        choice3.setBorder(new LineBorder(Color.WHITE));
        choice3.setFont(generalTextFont);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("btn_choice_3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("CHOICE 4 ");
        choice4.setBackground(Color.DARK_GRAY);
        choice4.setForeground(Color.WHITE);
        choice4.setFocusPainted(false);
        choice4.setFocusable(false);
        choice4.setContentAreaFilled(true);
        choice4.setBorder(new LineBorder(Color.WHITE));
        choice4.setFont(generalTextFont);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("btn_choice_4");
        choiceButtonPanel.add(choice4);

        // PLAYER PANEL
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 1000, 50);
        playerPanel.setBackground(Color.DARK_GRAY);
        playerPanel.setLayout(new GridLayout(1, 6));
        container.add(playerPanel);

        // COMPONENTS OF THE PLAYER PANEL
        hpLabel = new JLabel("PLAYER HP:");
        hpLabel.setFont(generalTextFont);
        hpLabel.setForeground(Color.WHITE);
        hpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hpLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(generalTextFont);
        hpLabelNumber.setForeground(Color.WHITE);
        hpLabelNumber.setHorizontalAlignment(SwingConstants.CENTER);
        hpLabelNumber.setVerticalAlignment(SwingConstants.CENTER);
        playerPanel.add(hpLabelNumber);

        monsterHpLabel = new JLabel("MONSTER HP:");
        monsterHpLabel.setFont(generalTextFont);
        monsterHpLabel.setForeground(Color.WHITE);
        monsterHpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        monsterHpLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerPanel.add(monsterHpLabel);

        monsterHpNumberLabel = new JLabel();
        monsterHpNumberLabel.setFont(generalTextFont);
        monsterHpNumberLabel.setForeground(Color.WHITE);
        monsterHpNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        monsterHpNumberLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerPanel.add(monsterHpNumberLabel);

        weaponLabel = new JLabel("PLAYER WEAPON:");
        weaponLabel.setFont(generalTextFont);
        weaponLabel.setForeground(Color.WHITE);
        weaponLabel.setHorizontalAlignment(SwingConstants.CENTER);
        weaponLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel("KNIFE");
        weaponLabelName.setFont(generalTextFont);
        weaponLabelName.setForeground(Color.WHITE);
        weaponLabelName.setHorizontalAlignment(SwingConstants.CENTER); // SET TEXT ON THE MIDDLE OF LABEL
        weaponLabelName.setVerticalAlignment(SwingConstants.CENTER);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }


    /**
     * Method for player setup.
     */

    public void playerSetup() {
        playerHp = 100;
        monsterHp = 100;
        weaponName = "KNIFE";
        hpLabelNumber.setText("" + playerHp + " %");
        monsterHpNumberLabel.setText("" + monsterHp + " %");
        weaponLabelName.setText(weaponName);
        townGate(); // use this method to go next step
    }

    /**
     * Method for town gate.
     */

    public void townGate() {

        position = "townGate"; // THE PROGRAM KNOW WERE THE USER POSITION AND CALL THE APPROPRIATE BUTTON CHOICE
        mainTextArea.setText("—  YOR ARE AT THE GATE OF THE TOWN. \n—  A GUARD IS STANDING IN FRONT OF YOU.\n\n—  WHAT DO YOU DO ?");

        choice1.setText("TALK TO THE GUARD");
        choice2.setText("ATTACK THE GUARD");
        choice3.setText("LEAVE");
        choice4.setText("");
    }

    /**
     * Method for guard talking.
     */

    public void guardTalk() {

        position = "guardTalk";
        mainTextArea.setText("# GUARD: \n—  HELLO STRANGER. \n—  I HAVE NEVER SEEN YOUR FACE. \n—  SORRY BUT WE CAN NOT" +
                " LET A STRANGER ENTER OUR TOWN.\n—  YOU WILL NEED TO KILL THE GOBLIN TO GET ACCESS IN THE TOWN.");
        choice1.setText("CONTINUE");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    /**
     * Method to attack the guard.
     */

    public void attackTheGuard() {
        position = "attackTheGuard";
        mainTextArea.setText("# GUARD: \n—  HEY DON'T BE STUPID ...\n—  THE GUARD FOUGHT BACK AND HIT " +
                "YOU HARD.\n\n # SYSTEM:\n—  ( YOU RECEIVED [ 7 ] DAMAGE !!! )");
        playerHp = playerHp - 7;
        hpLabelNumber.setText("" + playerHp + " %");
        choice1.setText("CONTINUE");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    /**
     * Method to go at the cross road
     */

    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("—  YOU ARE AT THE CROSSROAD.\n—  IF YOU GO TO THE SOUTH , YOU WILL GO BACK TO THE TOWN.");
        choice1.setText("GO NORTH");
        choice2.setText("GO EAST");
        choice3.setText("GO SOUTH");
        choice4.setText("GO WEST");
    }

    /**
     * Method for north direction.
     */

    public void north() {
        position = "north";
        mainTextArea.setText("# TIPS: \n—  YOU ARRIVED AT THE RIVER.\n—  IF YOU DRINK WATER AND YOU REST A FEW MINUTES BY THE\n  " +
                "    RIVERSIDE SOMETHING GOD IT'S GONNA HAPPEN TO YOU.\n\n— ( YOUR HP IS RECOVERED BY [ 5 ] POINTS !!! )");
        playerHp = playerHp + 5;
        if (playerHp > 100) {
            playerHp = 100;
        }
        hpLabelNumber.setText("" + playerHp + " %");
        choice1.setText("GO SOUTH");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    /**
     * Method for east direction.
     */

    public void east() {
        position = "east";
        mainTextArea.setText("— YOU WALKED IN TO THE BIG FOREST AND YOU HAVE\n      FOUNDED A LONG SWORD.\n—  YOU HAVE NOW A NEW WEAPON !!!\n\n" +
                "—  ( NEW WEAPON : LONG SWORD. )");
        weaponName = "LONG SWORD";
        weaponLabelName.setText(weaponName);
        choice1.setText("GO WEST");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    /**
     * Method for west direction.
     */

    public void west() {
        position = "west";
        mainTextArea.setText("—  YOU ENCOUNTERED THE GOBLIN !!!\n—  IF YOU HAVE COURAGE FIGHT THE GOBLIN.\n—  OR YOU CAN RUN AS A SNEAKY.");
        choice1.setText("FIGHT");
        choice2.setText("RUN");
        choice3.setText("");
        choice4.setText("");
    }

    /**
     * Method to fight the goblin.
     */

    public void fight() {
        position = "fight";
        monsterHpNumberLabel.setText("" + monsterHp + " %");
        mainTextArea.setText("# MONSTER HP: " + "[ " + monsterHp + " % ] . ATTACK HIM AND MAYBE YOU WILL WIN." + "\n\n—  WHAT IT'S YOUR ACTION ?");
        if (monsterHp < 100 && monsterHp >= 50) {
            mainTextArea.setText("# MONSTER HP: " + "[ " + monsterHp + " % ] . KEEP ATTACKING HIM AND MAYBE YOU WILL WIN." + "\n\n—  WHAT IT'S " +
                    "YOUR ACTION ?");
        } else if (monsterHp < 50 && monsterHp >= 20 ) {
            mainTextArea.setText("# MONSTER HP: " + "[ " + monsterHp + " % ] . THE GOBLIN IT'S VERY BAD INJURED KEEP\n ATTACKING HIM AND MAYBE " +
                    "YOU WILL WIN." + "\n\n—  WHAT IT'S YOUR ACTION ?");
        } else if (monsterHp < 20 && monsterHp >= 1) {
            mainTextArea.setText("# MONSTER HP: " + "[ " + monsterHp + " % ] . THE GOBLIN IT'S ALL MOST DEAD\n ATTACKING HIM AND MAYBE YOU WILL " +
                    "WIN." + "\n\n—  WHAT IT'S YOUR ACTION ?");
        }
        choice1.setText("ATTACK");
        choice2.setText("RUN");
        choice3.setText("");
        choice4.setText("");
    }

    /**
     * Method to attack the goblin.
     */

    public void playerAttackGoblin() {
        position = "playerAttackGoblin";
        int playerDamage = 0;

        if (weaponName.equals("KNIFE")) {
            playerDamage = new java.util.Random().nextInt(10);
        } else if (weaponName.equals("LONG SWORD")) {
            playerDamage = new java.util.Random().nextInt(15);
        }

        mainTextArea.setText("—  YOU ATTACKED THE GOBLIN AND INJURED HIM BY:  " + "[ " + playerDamage + " % ]" + " DAMAGE.");
        monsterHp = monsterHp - playerDamage;

        choice1.setText("CONTINUE");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    /**
     * Method to attack the player.
     */

    public void goblinAttackPlayer() {
        position = "goblinAttackPlayer";
        int goblinDamage = 0;

        goblinDamage = new java.util.Random().nextInt(13);

        mainTextArea.setText("—  THE MONSTER ATTACKED YOU AND INJURED YOU BY: " + "[ " + goblinDamage + " % ]" + " DAMAGE.");
        playerHp = playerHp - goblinDamage;
        hpLabelNumber.setText("" + playerHp + " %");

        choice1.setText("CONTINUE");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    /**
     * Method for win situation
     */

    public void win() {
        position = "win";

        mainTextArea.setText("# SYSTEM:\n— YOU DEFEATED THE GOBLIN.\n—  THE GOBLIN DROPPED A RING.\n—  YOU NEED TO HAVE A CHAT WHIT" +
                " THE GUARD AGAIN.\n\n—  ( YOU OBTAINED A SILVER RING. )");

        silverRing = 1;

        choice1.setText("GO SOUTH");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    /**
     * Method for lose situation
     */

    public void lose() {
        position = "lose";

        mainTextArea.setText("# SYSTEM:\n—  YOU ARE DEAD.\n\n—  < GAME IS OVER >");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        choice1.setBorder(new LineBorder(Color.WHITE));
        choice2.setBorder(new LineBorder(Color.WHITE));
        choice3.setBorder(new LineBorder(Color.WHITE));
        choice4.setBorder(new LineBorder(Color.WHITE));

    }

    /**
     * Method for ending game after you got the silver ring
     */

    public void endingGame() {
        position = "endingGame";

        mainTextArea.setText("# SYSTEM:\n—  YOU KILLED THE GOBLIN !!!\n—  THANK YOU VERY MUCH.\n—  YOU ARE TRUE HERO.\n—  WELCOME TO OUR TOWN.\n\n—  THE END.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        choice1.setBorder(new LineBorder(Color.WHITE));
        choice2.setBorder(new LineBorder(Color.WHITE));
        choice3.setBorder(new LineBorder(Color.WHITE));
        choice4.setBorder(new LineBorder(Color.WHITE));
    }


    /**
     * Method to handler the start button.
     */

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    /**
     * Method to handler the choice buttons.
     */

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String userChoice = event.getActionCommand();

            switch (position) {
                case "townGate":
                    switch (userChoice) {
                        case "btn_choice_1":
                            if (silverRing == 1) {
                                endingGame();
                            } else {
                                guardTalk();
                            }
                            break;
                        case "btn_choice_2":
                            attackTheGuard();
                            break;
                        case "btn_choice_3":
                            crossRoad();
                            break;

                    }
                    break;
                case "guardTalk":
                    switch (userChoice) {
                        case "btn_choice_1":
                            townGate();
                            break;
                    }
                    break;
                case "attackTheGuard":
                    switch (userChoice) {
                        case "btn_choice_1":
                            townGate();
                            break;
                    }
                    break;
                case "crossRoad":
                    switch (userChoice) {
                        case "btn_choice_1":
                            north();
                            break;
                        case "btn_choice_2":
                            east();
                            break;
                        case "btn_choice_3":
                            townGate();
                            break;
                        case "btn_choice_4":
                            west();
                            break;
                    }
                    break;
                case "north":
                    switch (userChoice) {
                        case "btn_choice_1":
                            crossRoad();
                            break;
                    }
                    break;
                case "east":
                    switch (userChoice) {
                        case "btn_choice_1":
                            crossRoad();
                            break;
                    }
                    break;
                case "west":
                    switch (userChoice) {
                        case "btn_choice_1":
                            fight();
                            break;
                        case "btn_choice_2":
                            crossRoad();
                            break;
                    }
                    break;
                case "fight":
                    switch (userChoice) {
                        case "btn_choice_1":
                            playerAttackGoblin();
                            break;
                        case "btn_choice_2":
                            crossRoad();
                            break;
                    }
                    break;
                case "playerAttackGoblin":
                    switch (userChoice) {
                        case "btn_choice_1":
                            if (monsterHp < 1) {
                                win();
                            } else {
                                goblinAttackPlayer();
                            }
                            break;
                    }
                    break;
                case "goblinAttackPlayer":
                    switch (userChoice) {
                        case "btn_choice_1":
                            if (playerHp < 1) {
                                lose();
                            } else {
                                fight();
                            }
                            break;
                    }
                    break;
                case "win":
                    switch (userChoice) {
                        case "btn_choice_1":
                            crossRoad();
                            break;
                    }
            }
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame {
    private boolean playerColour;
    private boolean gameOver;
    private int amountOfUnusedWhiteStones;
    private int amountOfUnusedBlackStones;
    private boolean aMillWasCreatedInThePreviousAction;
    private List<Feld> whiteStonesOnBoard;
    private List<Feld> blackStonesOnBoard;
    private List<Feld> whiteStonesOutOfGame;
    private List<Feld> blackStonesOutOfGame;
    private Feld[][] fields = new Feld[3][8];
    private JLabel blackMoveLabel;
    private JLabel whiteMoveLabel;
    private JLabel blackTakeStoneLabel;
    private JLabel whiteTakeStoneLabel;
    private JLabel countLabel;
    private JLabel blackWins;
    private JLabel whiteWins;
    private JPanel panel;
    private JLabel displayBlackPlayer;
    private JLabel displayWhitePlayer;
    private boolean stoneIsSelected;
    private Feld selectedStone;
    private Action action;
    private JPanel displayPlayerColour;
    private int indexSendingTo;



    private JPanel largeHorizontalLine1 ;
    private JPanel largeHorizontalLine2;
    private JPanel largeHorizontalLine3;
    private JPanel largeHorizontalLine4;

    private JPanel mediumHorizontalLine1;
    private JPanel mediumHorizontalLine2;
    private JPanel mediumHorizontalLine3;
    private JPanel mediumHorizontalLine4;

    private JPanel smallHorizontalLine1;
    private JPanel smallHorizontalLine2;
    private JPanel smallHorizontalLine3;
    private JPanel smallHorizontalLine4;

    private JPanel largeVerticalLine1;
    private JPanel largeVerticalLine2;
    private JPanel largeVerticalLine3;
    private JPanel largeVerticalLine4;

    private JPanel mediumVerticalLine1;
    private JPanel mediumVerticalLine2;
    private JPanel mediumVerticalLine3;
    private JPanel mediumVerticalLine4;

    private JPanel smallVerticalLine1;
    private JPanel smallVerticalLine2;
    private JPanel smallVerticalLine3;
    private JPanel smallVerticalLine4;

    private JPanel verticalCrossingLine1;
    private JPanel verticalCrossingLine2;
    private JPanel verticalCrossingLine3;
    private JPanel verticalCrossingLine4;

    private JPanel horizontalCrossingLine1;
    private JPanel horizontalCrossingLine2;
    private JPanel horizontalCrossingLine3;
    private JPanel horizontalCrossingLine4;

    private MyMouseListener myMouseListener1;
    private MyMouseListener myMouseListener2;
    private MyMouseListener myMouseListener3;
    private MyMouseListener myMouseListener4;
    private MyMouseListener myMouseListener5;
    private MyMouseListener myMouseListener6;
    private MyMouseListener myMouseListener7;
    private MyMouseListener myMouseListener8;
    private MyMouseListener myMouseListener9;
    private MyMouseListener myMouseListener10;
    private MyMouseListener myMouseListener11;
    private MyMouseListener myMouseListener12;
    private MyMouseListener myMouseListener13;
    private MyMouseListener myMouseListener14;
    private MyMouseListener myMouseListener15;
    private MyMouseListener myMouseListener16;
    private MyMouseListener myMouseListener17;
    private MyMouseListener myMouseListener18;
    private MyMouseListener myMouseListener19;
    private MyMouseListener myMouseListener20;
    private MyMouseListener myMouseListener21;
    private MyMouseListener myMouseListener22;
    private MyMouseListener myMouseListener23;
    private MyMouseListener myMouseListener24;


    public Frame(boolean colour, int indexSendingTo){
        this.setTitle("Mühle");
        this.setLayout(null);
        this.setSize(800,875);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.indexSendingTo = indexSendingTo;
        playerColour = true;
        gameOver = false;
        amountOfUnusedWhiteStones = 9;
        amountOfUnusedBlackStones = 9;
        aMillWasCreatedInThePreviousAction = false;
        stoneIsSelected = false;
        selectedStone = null;
        whiteStonesOnBoard = new ArrayList<>();
        blackStonesOnBoard = new ArrayList<>();
        whiteStonesOutOfGame = new ArrayList<>();
        blackStonesOutOfGame = new ArrayList<>();

        blackMoveLabel = new JLabel("black moves");
        blackMoveLabel.setVerticalAlignment(JLabel.CENTER);
        blackMoveLabel.setHorizontalAlignment(JLabel.CENTER);
        blackMoveLabel.setForeground(Color.white);

        whiteMoveLabel = new JLabel("white moves");
        whiteMoveLabel.setVerticalAlignment(JLabel.CENTER);
        whiteMoveLabel.setHorizontalAlignment(JLabel.CENTER);

        displayBlackPlayer = new JLabel("You are player black.");
        displayBlackPlayer.setVerticalAlignment(JLabel.CENTER);
        displayBlackPlayer.setHorizontalAlignment(JLabel.CENTER);
        displayBlackPlayer.setForeground(Color.white);

        displayWhitePlayer = new JLabel("You are player white.");
        displayWhitePlayer.setVerticalAlignment(JLabel.CENTER);
        displayWhitePlayer.setHorizontalAlignment(JLabel.CENTER);

        countLabel = new JLabel(String.valueOf(amountOfUnusedBlackStones));
        countLabel.setVerticalAlignment(JLabel.TOP);
        countLabel.setHorizontalAlignment(JLabel.CENTER);

        panel = new JPanel();
        panel.setBackground(new Color(245,245,220,255));
        panel.setBounds(325,325,150,150);
        panel.setLayout(new BorderLayout());
        panel.add(whiteMoveLabel,BorderLayout.CENTER);
        panel.add(countLabel,BorderLayout.NORTH);
        this.add(panel);


        displayPlayerColour = new JPanel();
        if(colour) {
            displayPlayerColour.setBackground(new Color(245,245,220,255));
            displayPlayerColour.setBounds(300,775,200,50);
            displayPlayerColour.setLayout(new BorderLayout());
            displayPlayerColour.add(displayWhitePlayer,BorderLayout.CENTER);
        }
        else {
            displayPlayerColour.setBackground(Color.black);
            displayPlayerColour.setBounds(300,775,200,50);
            displayPlayerColour.setLayout(new BorderLayout());
            displayPlayerColour.add(displayBlackPlayer,BorderLayout.CENTER);
        }
        this.add(displayPlayerColour);



        largeHorizontalLine1 = new JPanel();
        largeHorizontalLine1.setBackground(Color.black);
        largeHorizontalLine1.setBounds(100,70,275,10);
        this.add(largeHorizontalLine1);

        largeHorizontalLine2 = new JPanel();
        largeHorizontalLine2.setBackground(Color.black);
        largeHorizontalLine2.setBounds(425,70,275,10);
        this.add(largeHorizontalLine2);

        largeHorizontalLine3 = new JPanel();
        largeHorizontalLine3.setBackground(Color.black);
        largeHorizontalLine3.setBounds(100,720,275,10);
        this.add(largeHorizontalLine3);

        largeHorizontalLine4 = new JPanel();
        largeHorizontalLine4.setBackground(Color.black);
        largeHorizontalLine4.setBounds(425,720,275,10);
        this.add(largeHorizontalLine4);

        mediumHorizontalLine1 = new JPanel();
        mediumHorizontalLine1.setBackground(Color.black);
        mediumHorizontalLine1.setBounds(200,170,175,10);
        this.add(mediumHorizontalLine1);

        mediumHorizontalLine2 = new JPanel();
        mediumHorizontalLine2.setBackground(Color.black);
        mediumHorizontalLine2.setBounds(425,170,175,10);
        this.add(mediumHorizontalLine2);

        mediumHorizontalLine3 = new JPanel();
        mediumHorizontalLine3.setBackground(Color.black);
        mediumHorizontalLine3.setBounds(200,620,175,10);
        this.add(mediumHorizontalLine3);

        mediumHorizontalLine4 = new JPanel();
        mediumHorizontalLine4.setBackground(Color.black);
        mediumHorizontalLine4.setBounds(425,620,175,10);
        this.add(mediumHorizontalLine4);

        smallHorizontalLine1 = new JPanel();
        smallHorizontalLine1.setBackground(Color.black);
        smallHorizontalLine1.setBounds(300,270,75,10);
        this.add(smallHorizontalLine1);

        smallHorizontalLine2 = new JPanel();
        smallHorizontalLine2.setBackground(Color.black);
        smallHorizontalLine2.setBounds(425,270,75,10);
        this.add(smallHorizontalLine2);

        smallHorizontalLine3 = new JPanel();
        smallHorizontalLine3.setBackground(Color.black);
        smallHorizontalLine3.setBounds(300,520,75,10);
        this.add(smallHorizontalLine3);

        smallHorizontalLine4 = new JPanel();
        smallHorizontalLine4.setBackground(Color.black);
        smallHorizontalLine4.setBounds(425,520,75,10);
        this.add(smallHorizontalLine4);

        largeVerticalLine1 = new JPanel();
        largeVerticalLine1.setBackground(Color.black);
        largeVerticalLine1.setBounds(70,100,10,275);
        this.add(largeVerticalLine1);

        largeVerticalLine2 = new JPanel();
        largeVerticalLine2.setBackground(Color.black);
        largeVerticalLine2.setBounds(720,100,10,275);
        this.add(largeVerticalLine2);

        largeVerticalLine3 = new JPanel();
        largeVerticalLine3.setBackground(Color.black);
        largeVerticalLine3.setBounds(720,425,10,275);
        this.add(largeVerticalLine3);

        largeVerticalLine4 = new JPanel();
        largeVerticalLine4.setBackground(Color.black);
        largeVerticalLine4.setBounds(70,425,10,275);
        this.add(largeVerticalLine4);

        mediumVerticalLine1 = new JPanel();
        mediumVerticalLine1.setBackground(Color.black);
        mediumVerticalLine1.setBounds(170,200,10,175);
        this.add(mediumVerticalLine1);

        mediumVerticalLine2 = new JPanel();
        mediumVerticalLine2.setBackground(Color.black);
        mediumVerticalLine2.setBounds(620,200,10,175);
        this.add(mediumVerticalLine2);

        mediumVerticalLine3 = new JPanel();
        mediumVerticalLine3.setBackground(Color.black);
        mediumVerticalLine3.setBounds(620,425,10,175);
        this.add(mediumVerticalLine3);

        mediumVerticalLine4 = new JPanel();
        mediumVerticalLine4.setBackground(Color.black);
        mediumVerticalLine4.setBounds(170,425,10,175);
        this.add(mediumVerticalLine4);

        smallVerticalLine1 = new JPanel();
        smallVerticalLine1.setBackground(Color.black);
        smallVerticalLine1.setBounds(270,300,10,75);
        this.add(smallVerticalLine1);

        smallVerticalLine2 = new JPanel();
        smallVerticalLine2.setBackground(Color.black);
        smallVerticalLine2.setBounds(520,300,10,75);
        this.add(smallVerticalLine2);

        smallVerticalLine3 = new JPanel();
        smallVerticalLine3.setBackground(Color.black);
        smallVerticalLine3.setBounds(270,425,10,75);
        this.add(smallVerticalLine3);

        smallVerticalLine4 = new JPanel();
        smallVerticalLine4.setBackground(Color.black);
        smallVerticalLine4.setBounds(520,425,10,75);
        this.add(smallVerticalLine4);

        verticalCrossingLine1 = new JPanel();
        verticalCrossingLine1.setBackground(Color.black);
        verticalCrossingLine1.setBounds(395,100,10,50);
        this.add(verticalCrossingLine1);

        verticalCrossingLine2 = new JPanel();
        verticalCrossingLine2.setBackground(Color.black);
        verticalCrossingLine2.setBounds(395,200,10,50);
        this.add(verticalCrossingLine2);

        verticalCrossingLine3 = new JPanel();
        verticalCrossingLine3.setBackground(Color.black);
        verticalCrossingLine3.setBounds(395,550,10,50);
        this.add(verticalCrossingLine3);

        verticalCrossingLine4 = new JPanel();
        verticalCrossingLine4.setBackground(Color.black);
        verticalCrossingLine4.setBounds(395,650,10,50);
        this.add(verticalCrossingLine4);

        horizontalCrossingLine1 = new JPanel();
        horizontalCrossingLine1.setBackground(Color.black);
        horizontalCrossingLine1.setBounds(100,395,50,10);
        this.add(horizontalCrossingLine1);

        horizontalCrossingLine2 = new JPanel();
        horizontalCrossingLine2.setBackground(Color.black);
        horizontalCrossingLine2.setBounds(200,395,50,10);
        this.add(horizontalCrossingLine2);

        horizontalCrossingLine3 = new JPanel();
        horizontalCrossingLine3.setBackground(Color.black);
        horizontalCrossingLine3.setBounds(550,395,50,10);
        this.add(horizontalCrossingLine3);

        horizontalCrossingLine4 = new JPanel();
        horizontalCrossingLine4.setBackground(Color.black);
        horizontalCrossingLine4.setBounds(650,395,50,10);
        this.add(horizontalCrossingLine4);


        Feld field1 = new Feld((byte)1,(byte)1);
        myMouseListener1 = new MyMouseListener(this,field1);
        field1.addMouseListener(myMouseListener1);
        field1.setBounds(50,50,50,50);
        fields[0][0] = field1;
        this.add(field1);


        Feld field2 = new Feld((byte)1,(byte)2);
        myMouseListener2 = new MyMouseListener(this,field2);
        field2.addMouseListener(myMouseListener2);
        field2.setBounds(375,50,50,50);
        fields[0][1] = field2;
        this.add(field2);

        Feld field3 = new Feld((byte)1,(byte)3);
        myMouseListener3 = new MyMouseListener(this,field3);
        field3.addMouseListener(myMouseListener3);
        field3.setBounds(700,50,50,50);
        fields[0][2] = field3;
        this.add(field3);

        Feld field4 = new Feld((byte)1,(byte)4);
        myMouseListener4 = new MyMouseListener(this,field4);
        field4.addMouseListener(myMouseListener4);
        field4.setBounds(700,375,50,50);
        fields[0][3] = field4;
        this.add(field4);

        Feld field5 = new Feld((byte)1,(byte)5);
        myMouseListener5 = new MyMouseListener(this,field5);
        field5.addMouseListener(myMouseListener5);;
        field5.setBounds(700,700,50,50);
        fields[0][4] = field5;
        this.add(field5);

        Feld field6 = new Feld((byte)1,(byte)6);
        myMouseListener6 = new MyMouseListener(this,field6);
        field6.addMouseListener(myMouseListener6);
        field6.setBounds(375,700,50,50);
        fields[0][5] = field6;
        this.add(field6);

        Feld field7 = new Feld((byte)1,(byte)7);
        myMouseListener7 = new MyMouseListener(this,field7);
        field7.addMouseListener(myMouseListener7);
        field7.setBounds(50,700,50,50);
        fields[0][6] = field7;
        this.add(field7);

        Feld field8 = new Feld((byte)1,(byte)8);
        myMouseListener8 = new MyMouseListener(this,field8);
        field8.addMouseListener(myMouseListener8);
        field8.setBounds(50,375,50,50);
        fields[0][7] = field8;
        this.add(field8);

        Feld field9 = new Feld((byte)2,(byte)1);
        myMouseListener9 = new MyMouseListener(this,field9);
        field9.addMouseListener(myMouseListener9);
        field9.setBounds(150,150,50,50);
        fields[1][0] = field9;
        this.add(field9);

        Feld field10 = new Feld((byte)2,(byte)2);
        myMouseListener10 = new MyMouseListener(this,field10);
        field10.addMouseListener(myMouseListener10);
        field10.setBounds(375,150,50,50);
        fields[1][1] = field10;
        this.add(field10);

        Feld field11 = new Feld((byte)2,(byte)3);
        myMouseListener11 = new MyMouseListener(this,field11);
        field11.addMouseListener(myMouseListener11);
        field11.setBounds(600,150,50,50);
        fields[1][2] = field11;
        this.add(field11);

        Feld field12 = new Feld((byte)2,(byte)4);
        myMouseListener12 = new MyMouseListener(this,field12);
        field12.addMouseListener(myMouseListener12);
        field12.setBounds(600,375,50,50);
        fields[1][3] = field12;
        this.add(field12);

        Feld field13 = new Feld((byte)2,(byte)5);
        myMouseListener13 = new MyMouseListener(this,field13);
        field13.addMouseListener(myMouseListener13);
        field13.setBounds(600,600,50,50);
        fields[1][4] = field13;
        this.add(field13);

        Feld field14 = new Feld((byte)2,(byte)6);
        myMouseListener14 = new MyMouseListener(this,field14);
        field14.addMouseListener(myMouseListener14);
        field14.setBounds(375,600,50,50);
        fields[1][5] = field14;
        this.add(field14);

        Feld field15 = new Feld((byte)2,(byte)7);
        myMouseListener15 = new MyMouseListener(this,field15);
        field15.addMouseListener(myMouseListener15);
        field15.setBounds(150,600,50,50);
        fields[1][6] = field15;
        this.add(field15);

        Feld field16 = new Feld((byte)2,(byte)8);
        myMouseListener16 = new MyMouseListener(this,field16);
        field16.addMouseListener(myMouseListener16);
        field16.setBounds(150,375,50,50);
        fields[1][7] = field16;
        this.add(field16);

        Feld field17 = new Feld((byte)3,(byte)1);
        myMouseListener17 = new MyMouseListener(this,field17);
        field17.addMouseListener(myMouseListener17);
        field17.setBounds(250,250,50,50);
        fields[2][0] = field17;
        this.add(field17);

        Feld field18 = new Feld((byte)3,(byte)2);
        myMouseListener18 = new MyMouseListener(this,field18);
        field18.addMouseListener(myMouseListener18);
        field18.setBounds(375,250,50,50);
        fields[2][1] = field18;
        this.add(field18);

        Feld field19 = new Feld((byte)3,(byte)3);
        myMouseListener19 = new MyMouseListener(this,field19);
        field19.addMouseListener(myMouseListener19);
        field19.setBounds(500,250,50,50);
        fields[2][2] = field19;
        this.add(field19);

        Feld field20 = new Feld((byte)3,(byte)4);
        myMouseListener20 = new MyMouseListener(this,field20);
        field20.addMouseListener(myMouseListener20);
        field20.setBounds(500,375,50,50);
        fields[2][3] = field20;
        this.add(field20);

        Feld field21 = new Feld((byte)3,(byte)5);
        myMouseListener21 = new MyMouseListener(this,field21);
        field21.addMouseListener(myMouseListener21);
        field21.setBounds(500,500,50,50);
        fields[2][4] = field21;
        this.add(field21);

        Feld field22 = new Feld((byte)3,(byte)6);
        myMouseListener22 = new MyMouseListener(this,field22);
        field22.addMouseListener(myMouseListener22);
        field22.setBounds(375,500,50,50);
        fields[2][5] = field22;
        this.add(field22);

        Feld field23 = new Feld((byte)3,(byte)7);
        myMouseListener23 = new MyMouseListener(this,field23);
        field23.addMouseListener(myMouseListener23);
        field23.setBounds(250,500,50,50);
        fields[2][6] = field23;
        this.add(field23);

        Feld field24 = new Feld((byte)3,(byte)8);
        myMouseListener24 = new MyMouseListener(this,field24);
        field24.addMouseListener(myMouseListener24);
        field24.setBounds(250,375,50,50);
        fields[2][7] = field24;
        this.add(field24);

        this.setVisible(true);
    }

    public void NotYourTurn(){
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 8; j++) {
                fields[i][j].setEnabled(false);
            }
        }
    }
    public void YourTurn(){
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 8; j++) {
                fields[i][j].setEnabled(true);
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Action getAction() {
        return action;
    }

    public boolean isaMillWasCreatedInThePreviousAction() {
        return aMillWasCreatedInThePreviousAction;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isPlayerColour() {
        return playerColour;
    }

    public void setaMillWasCreatedInThePreviousAction(boolean aMillWasCreatedInThePreviousAction) {
        this.aMillWasCreatedInThePreviousAction = aMillWasCreatedInThePreviousAction;
    }

    public int getAmountOfUnusedWhiteStones() {
        return amountOfUnusedWhiteStones;
    }

    public int getAmountOfUnusedBlackStones() {
        return amountOfUnusedBlackStones;
    }

    public int getAmountOfUnusedStones(boolean playerColour){
        if (playerColour){return getAmountOfUnusedWhiteStones();}
        else {return getAmountOfUnusedBlackStones();}
    }

    public void addFieldBehaviour (Feld field){
        field.addActionListener(e -> {
            if (!gameOver) {
                if (aMillWasCreatedInThePreviousAction) {
                    removeStone(field);
                    if (allStonesAreBlocked() || Frame.this.lessThanThreeStonesOnBoard(playerColour)) {
                        gameOver = true;
                        displayWinner(playerColour);
                    }
                } else {
                    if (getAmountOfUnusedStones(playerColour) > 0) {
                        firstPhaseMove(field);
                    } else if (getAmountOfStonesOutOfGame(playerColour) < 6) {
                        secondPhaseMove(field);
                    } else {
                        thirdPhaseMove(field);
                    }
                }
            }

        });
    }
    public void firstPhaseMove(Feld field){
        //action.setActionWasPerformed(false);
        if (field.isEmpty()){
            firstPhaseSetStone(field);
            if (stoneIsInMill(field)){
                addRequestToDeleteStone();
                setaMillWasCreatedInThePreviousAction(true);
            }
            else {
                adaptDisplayOfCurrentPlayer();

                Server.getGames().get(1).getFrame().firstPhaseSetStone(field);
            }
        }
    }
    public void firstPhaseSetStone(Feld field){
        if (playerColour){
            field.setIcon(new ImageIcon("WeisserStein.png"));
            whiteStonesOnBoard.add(field);
            amountOfUnusedWhiteStones --;
        }
        else {
            field.setIcon(new ImageIcon("SchwarzerStein.png"));
            blackStonesOnBoard.add(field);
            amountOfUnusedBlackStones --;
        }
        field.setEmpty(false);
        field.setColourOfStone(playerColour);
        playerColour = !playerColour;
    }
    public void secondPhaseMove(Feld field){
        if (!playerColour){
            panel.remove(countLabel);
        }
        if (stoneIsSelected){
            if (fieldsAreNeighbours(selectedStone,field) && field.isEmpty()){
                secondPhaseSetStone(field);
                if (stoneIsInMill(field)){
                    addRequestToDeleteStone();
                    setaMillWasCreatedInThePreviousAction(true);
                }
                else {
                    adaptDisplayOfCurrentPlayer();
                }
            }
            else {
                selectAStoneYouWantToMoveInPhaseTwo(field);
            }
        }
        else {
            if (allStonesAreBlocked()){
                gameOver = true;
            }
            else {
                selectAStoneYouWantToMoveInPhaseTwo(field);
            }
        }
    }
    public void secondPhaseSetStone(Feld field){
        field.setEmpty(false);
        selectedStone.setEmpty(true);
        selectedStone.setBackground(Color.white);
        selectedStone.setIcon(null);
        stoneIsSelected = false;
        if (playerColour){
            field.setColourOfStone(true);
            field.setIcon(new ImageIcon("WeisserStein.png"));
        }
        else {
            field.setColourOfStone(false);
            field.setIcon(new ImageIcon("SchwarzerStein.png"));
        }
        playerColour = !playerColour;
    }
    public void selectAStoneYouWantToMoveInPhaseTwo(Feld field){
        if (!field.isEmpty() && field.isColourOfStone() == playerColour){
            if (!stoneIsBlocked(field)){
                if (stoneIsSelected){
                    selectedStone.setBackground(Color.white);
                }
                field.setBackground(Color.green);
                selectedStone = field;
                stoneIsSelected = true;
            }
            else {
                if (stoneIsSelected){
                    selectedStone.setBackground(Color.white);
                }
                field.setBackground(Color.red);
                selectedStone = field;
                stoneIsSelected = true;
            }
        }
        else {

        }
    }
    public void selectAStoneYouWantToMoveInPhaseThree(Feld field){
        if (!field.isEmpty() && field.isColourOfStone() == playerColour){
            if (stoneIsSelected){
                selectedStone.setBackground(Color.white);
            }
            field.setBackground(Color.green);
            selectedStone = field;
            stoneIsSelected = true;
        }
    }
    public void thirdPhaseMove(Feld field){
        if (stoneIsSelected){
            if (field.isEmpty()){
                secondPhaseSetStone(field);
                if (stoneIsInMill(field)){
                    addRequestToDeleteStone();
                    aMillWasCreatedInThePreviousAction = true;
                }
                else {
                    adaptDisplayOfCurrentPlayer();
                }
            }
            else {
                selectAStoneYouWantToMoveInPhaseThree(field);
            }
        }
        else {
            selectAStoneYouWantToMoveInPhaseThree(field);
        }
    }
    public boolean fieldsAreNeighbours(Feld selectedStone, Feld field){
        boolean returnValue = false;
        if (selectedStone.getCircle() == (byte)1){
            switch (selectedStone.getPositionOnCircle()) {
                case 1 -> {
                    if (field.getCircle() == 1 && (field.getPositionOnCircle() == 8 || field.getPositionOnCircle() == 2)) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if ((field.getCircle() == 1 && Math.abs(field.getPositionOnCircle() - selectedStone.getPositionOnCircle()) == 1) || (field.getPositionOnCircle() == selectedStone.getPositionOnCircle() && field.getCircle() == 2)) {returnValue = true;}
                    break;
                }
                case 3,5,7 -> {
                    if (field.getCircle() == 1 && Math.abs(field.getPositionOnCircle() - selectedStone.getPositionOnCircle()) == 1) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if ((field.getCircle() == 1 && (field.getPositionOnCircle() == 1 || field.getPositionOnCircle() == 7)) || (field.getPositionOnCircle() == 8 && field.getCircle() == 2)) {returnValue = true;}
                    break;
                }
            }
        }
        else if (selectedStone.getCircle() == (byte)2){
            switch (selectedStone.getPositionOnCircle()) {
                case 1 -> {
                    if (field.getCircle() == 2 && (field.getPositionOnCircle() == 8 || field.getPositionOnCircle() == 2)) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if ((field.getCircle() == 2 && Math.abs(field.getPositionOnCircle() - selectedStone.getPositionOnCircle()) == 1) || (field.getPositionOnCircle() == selectedStone.getPositionOnCircle() && (field.getCircle() == 1 || field.getCircle() == 3))) {returnValue = true;}
                    break;
                }
                case 3,5,7 -> {
                    if (field.getCircle() == 2 && Math.abs(field.getPositionOnCircle() - selectedStone.getPositionOnCircle()) == 1) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if ((field.getCircle() == 2 && (field.getPositionOnCircle() == 1 || field.getPositionOnCircle() == 7)) || (field.getPositionOnCircle() == 8 && (field.getCircle() == 1 || field.getCircle() == 3))) {returnValue = true;}
                    break;
                }
            }
        }
        else {
            switch (selectedStone.getPositionOnCircle()) {
                case 1 -> {
                    if (field.getCircle() == 3 && (field.getPositionOnCircle() == 8 || field.getPositionOnCircle() == 2)) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if ((field.getCircle() == 3 && Math.abs(field.getPositionOnCircle() - selectedStone.getPositionOnCircle()) == 1) || (field.getPositionOnCircle() == selectedStone.getPositionOnCircle() && field.getCircle() == 2)) {returnValue = true;}
                    break;
                }
                case 3,5,7 -> {
                    if (field.getCircle() == 3 && Math.abs(field.getPositionOnCircle() - selectedStone.getPositionOnCircle()) == 1) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if ((field.getCircle() == 3 && (field.getPositionOnCircle() == 1 || field.getPositionOnCircle() == 7)) || (field.getPositionOnCircle() == 8 && field.getCircle() == 2)) {returnValue = true;}
                    break;
                }
            }
        }
        return returnValue;
    }
    public boolean checkLineOnCircleForMill (Feld field, int circle, int positionOnCircle1, int positionOnCircle2){
        if (!(fields[(circle - 1)][(positionOnCircle1 - 1)].isEmpty() || fields[(circle - 1)][(positionOnCircle2 - 1)].isEmpty()) && ((fields[(circle - 1)][(positionOnCircle1 - 1)].isColourOfStone() == field.isColourOfStone()) && (field.isColourOfStone() == fields[(circle - 1)][(positionOnCircle2 - 1)].isColourOfStone()))){
            return true;
        }
        return false;
    }
    public boolean checkLineBetweenCirclesForMill (Feld field, int positionOnCircle,int circle1,int circle2){
        if (!(fields[(circle1 - 1)][(positionOnCircle - 1)].isEmpty() || fields[(circle2 - 1)][(positionOnCircle - 1)].isEmpty()) && ((fields[(circle1 - 1)][(positionOnCircle - 1)].isColourOfStone() == field.isColourOfStone()) && (field.isColourOfStone() == fields[(circle2 - 1)][(positionOnCircle - 1)].isColourOfStone()))){
            return true;
        }
        return false;
    }
    public boolean stoneIsInMill(Feld field){
        boolean returnValue = false;
        if (field.getCircle() == (byte)1){
            switch (field.getPositionOnCircle()) {
                case 1 -> {
                    if (checkLineOnCircleForMill(field, 1, 2, 3)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 1, 7, 8)) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if (checkLineOnCircleForMill(field, 1, field.getPositionOnCircle() - 1, field.getPositionOnCircle() + 1)) {returnValue = true;}
                    else if (checkLineBetweenCirclesForMill(field, field.getPositionOnCircle(), 2, 3)) {returnValue = true;}
                    break;
                }
                case 3,5 -> {
                    if (checkLineOnCircleForMill(field, 1, field.getPositionOnCircle()-2, field.getPositionOnCircle()-1)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 1, field.getPositionOnCircle()+1, field.getPositionOnCircle()+2)) {returnValue = true;}
                    break;
                }
                case 7 -> {
                    if (checkLineOnCircleForMill(field, 1, 5, 6)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 1, 8, 1)) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if (checkLineOnCircleForMill(field, 1, 1, 7)) {returnValue = true;}
                    else if (checkLineBetweenCirclesForMill(field, 8, 2, 3)) {returnValue = true;}
                    break;
                }
            }
        }
        else if (field.getCircle() == (byte)2){
            switch (field.getPositionOnCircle()) {
                case 1 -> {
                    if (checkLineOnCircleForMill(field, 2, 2, 3)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 2, 7, 8)) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if (checkLineOnCircleForMill(field, 2, field.getPositionOnCircle() - 1, field.getPositionOnCircle() + 1)) {returnValue = true;}
                    else if (checkLineBetweenCirclesForMill(field, field.getPositionOnCircle(), 1, 3)) {returnValue = true;}
                    break;
                }
                case 3,5 -> {
                    if (checkLineOnCircleForMill(field, 2, field.getPositionOnCircle()-2, field.getPositionOnCircle()-1)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 2, field.getPositionOnCircle()+1, field.getPositionOnCircle()+2)) {returnValue = true;}
                }
                case 7 -> {
                    if (checkLineOnCircleForMill(field, 2, 5, 6)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 2, 8, 1)) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if (checkLineOnCircleForMill(field, 2, 1, 7)) {returnValue = true;}
                    else if (checkLineBetweenCirclesForMill(field, 8, 1, 3)) {returnValue = true;}
                    break;
                }
            }
        }
        else {
            switch (field.getPositionOnCircle()) {
                case 1 -> {
                    if (checkLineOnCircleForMill(field, 3, 2, 3)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 3, 7, 8)) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if (checkLineOnCircleForMill(field, 3, field.getPositionOnCircle() - 1, field.getPositionOnCircle() + 1)) {returnValue = true;}
                    else if (checkLineBetweenCirclesForMill(field, field.getPositionOnCircle(), 1, 2)) {returnValue = true;}
                    break;
                }
                case 3,5 -> {
                    if (checkLineOnCircleForMill(field, 3, field.getPositionOnCircle()-2, field.getPositionOnCircle()-1)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 3, field.getPositionOnCircle()+1, field.getPositionOnCircle()+2)) {returnValue = true;}
                }
                case 7 -> {
                    if (checkLineOnCircleForMill(field, 3, 5, 6)) {returnValue = true;}
                    else if (checkLineOnCircleForMill(field, 3, 8, 1)) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if (checkLineOnCircleForMill(field, 3, 1, 7)) {returnValue = true;}
                    else if (checkLineBetweenCirclesForMill(field, 8, 1, 2)) {returnValue = true;}
                    break;
                }
            }
        }
        return returnValue;
    }
    public boolean stoneIsBlocked(Feld field){
        boolean returnValue = false;
        if (field.getCircle() == (byte)1){
            switch (field.getPositionOnCircle()) {
                case 1 -> {
                    if (!fields[0][7].isEmpty() && !fields[0][1].isEmpty()) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if (!fields[0][field.getPositionOnCircle() - 2].isEmpty() && !fields[0][field.getPositionOnCircle()].isEmpty() && !fields[1][field.getPositionOnCircle() - 1].isEmpty()) {returnValue = true;}
                    break;
                }
                case 3,5,7 -> {
                    if (!fields[0][field.getPositionOnCircle() - 2].isEmpty() && !fields[0][field.getPositionOnCircle()].isEmpty()) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if (!fields[0][6].isEmpty() && !fields[0][0].isEmpty() && !fields[1][7].isEmpty()) {returnValue = true;}
                    break;
                }
            }
        }
        else if (field.getCircle() == (byte)2){
            switch (field.getPositionOnCircle()) {
                case 1 -> {
                    if (!fields[1][7].isEmpty() && !fields[1][1].isEmpty()) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if (!fields[1][field.getPositionOnCircle() - 2].isEmpty() && !fields[1][field.getPositionOnCircle()].isEmpty() && !fields[0][field.getPositionOnCircle() - 1].isEmpty() && !fields[2][field.getPositionOnCircle() - 1].isEmpty()) {returnValue = true;}
                    break;
                }
                case 3,5,7 -> {
                    if (!fields[1][field.getPositionOnCircle() - 2].isEmpty() && !fields[1][field.getPositionOnCircle()].isEmpty()) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if (!fields[1][6].isEmpty() && !fields[1][0].isEmpty() && !fields[0][7].isEmpty() && !fields[2][7].isEmpty()) {returnValue = true;}
                    break;
                }
            }
        }
        else {
            switch (field.getPositionOnCircle()) {
                case 1 -> {
                    if (!fields[2][7].isEmpty() && !fields[2][1].isEmpty()) {returnValue = true;}
                    break;
                }
                case 2,4,6 -> {
                    if (!fields[2][field.getPositionOnCircle() - 2].isEmpty() && !fields[2][field.getPositionOnCircle()].isEmpty() && !fields[1][field.getPositionOnCircle() - 1].isEmpty()) {returnValue = true;}
                    break;
                }
                case 3,5,7 -> {
                    if (!fields[2][field.getPositionOnCircle() - 2].isEmpty() && !fields[2][field.getPositionOnCircle()].isEmpty()) {returnValue = true;}
                    break;
                }
                case 8 -> {
                    if (!fields[2][6].isEmpty() && !fields[2][0].isEmpty() && !fields[1][7].isEmpty()) {returnValue = true;}
                    break;
                }
            }
        }
        return returnValue;
    }
    public boolean allStonesAreBlocked(){
        boolean returnValue = false;
        if (playerColour){
            int i = 0;
            while (i < whiteStonesOnBoard.size() && stoneIsBlocked(whiteStonesOnBoard.get(i))) {
                i++;
            }
            if (i == whiteStonesOnBoard.size()){
                i = 0;
                while (i < whiteStonesOnBoard.size()) {
                    whiteStonesOnBoard.get(i).setBackground(Color.red);
                    i++;
                }
                returnValue = true;
            }
        }
        else {
            int i = 0;
            while (i < blackStonesOnBoard.size() && stoneIsBlocked(blackStonesOnBoard.get(i))) {
                i++;
            }
            if (i == blackStonesOnBoard.size()){
                i = 0;
                while (i < blackStonesOnBoard.size()) {
                    blackStonesOnBoard.get(i).setBackground(Color.red);
                    i++;
                }
                returnValue = true;
            }
        }
        return returnValue;
    }
    public void removeStone(Feld field){
        if (!field.isEmpty() && field.isColourOfStone() == playerColour){
            if (notAllStonesAreInMill()){
                if (!(stoneIsInMill(field))){
                    if (playerColour){
                        whiteStonesOnBoard.remove(field);
                        whiteStonesOutOfGame.add(field);
                    }
                    else {
                        blackStonesOnBoard.remove(field);
                        blackStonesOutOfGame.add(field);
                    }
                    field.setIcon(null);
                    removeRequestToDeleteStone();
                    adaptDisplayOfCurrentPlayer();
                    field.setEmpty(true);
                    setaMillWasCreatedInThePreviousAction(false);
                }
            }
            else {
                if (playerColour){
                    whiteStonesOnBoard.remove(field);
                    whiteStonesOutOfGame.add(field);
                }
                else {
                    blackStonesOnBoard.remove(field);
                    blackStonesOutOfGame.add(field);
                }
                field.setIcon(null);
                removeRequestToDeleteStone();
                adaptDisplayOfCurrentPlayer();
                field.setEmpty(true);
                setaMillWasCreatedInThePreviousAction(false);
            }
        }

    }
    public boolean notAllStonesAreInMill(){
        boolean returnValue = true;
        if (playerColour){
            int i = 0;
            while (i < whiteStonesOnBoard.size() && stoneIsInMill(whiteStonesOnBoard.get(i))) {
                i++;
            }
            if (i >= whiteStonesOnBoard.size()){
                returnValue = false;
            }
        }
        else{
            int i = 0;
            while (i < blackStonesOnBoard.size() && stoneIsInMill(blackStonesOnBoard.get(i))) {
                i++;
            }
            if (i >= blackStonesOnBoard.size()){
                returnValue = false;
            }
        }
        return returnValue;
    }
    public void adaptDisplayOfCurrentPlayer(){
        if (playerColour){
            panel.remove(blackMoveLabel);
            panel.setBackground(new Color(245,245,220,255));
            blackMoveLabel.setForeground(Color.black);
            countLabel.setForeground(Color.black);
            countLabel.setText(String.valueOf(amountOfUnusedBlackStones));
            panel.add(whiteMoveLabel);
        }
        else {
            panel.remove(whiteMoveLabel);
            panel.setBackground(Color.black);
            blackMoveLabel.setForeground(Color.white);
            countLabel.setForeground(Color.white);
            panel.add(blackMoveLabel);
        }
    }
    public void addRequestToDeleteStone(){
        if(playerColour){
            blackTakeStoneLabel = new JLabel("take white stone");
            blackTakeStoneLabel.setVerticalAlignment(JLabel.BOTTOM);
            blackTakeStoneLabel.setHorizontalAlignment(JLabel.CENTER);
            blackTakeStoneLabel.setForeground(Color.white);
            panel.add(blackTakeStoneLabel);
        }
        else {
            whiteTakeStoneLabel = new JLabel("take black stone");
            whiteTakeStoneLabel.setVerticalAlignment(JLabel.BOTTOM);
            whiteTakeStoneLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(whiteTakeStoneLabel);
        }
    }
    public void removeRequestToDeleteStone(){
        if(playerColour){
            panel.remove(blackTakeStoneLabel);
        }
        else {
            panel.remove(whiteTakeStoneLabel);
        }
    }
    public void displayWinner(Boolean playerColour){
        if (playerColour){
            panel.remove(whiteMoveLabel);
            panel.setBackground(Color.white);
            blackWins = new JLabel("Black Wins");
            blackWins.setVerticalAlignment(JLabel.CENTER);
            blackWins.setHorizontalAlignment(JLabel.CENTER);
            panel.add(blackWins);
        }
        else {
            panel.remove(blackMoveLabel);
            panel.setBackground(Color.white);
            whiteWins = new JLabel("White Wins");
            whiteWins.setVerticalAlignment(JLabel.CENTER);
            whiteWins.setHorizontalAlignment(JLabel.CENTER);
            panel.add(whiteWins);
        }
    }
    public boolean lessThanThreeStonesOnBoard(Boolean playerColour){
        if (playerColour){
            if (whiteStonesOutOfGame.size() > 6){
                return true;
            }
        }
        else {
            if (blackStonesOutOfGame.size() > 6){
                return true;
            }
        }
        return false;
    }
    public int getAmountOfStonesOnBoard (boolean playerColour){
        if(playerColour){
            return whiteStonesOnBoard.size();
        }
        else {
            return blackStonesOnBoard.size();
        }
    }
    public int getAmountOfStonesOutOfGame (boolean playerColour){
        if(playerColour){
            return whiteStonesOutOfGame.size();
        }
        else {
            return blackStonesOutOfGame.size();
        }
    }
}

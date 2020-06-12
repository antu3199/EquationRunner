/*
 * EquationDefenceView.java
 *
 * Anthony Tu
 * May 6, 2014
 * ICS3U
 * Equation Runner Final Project!
 * Play as a Pikachu, running to catch those theives who stole your apple!
 */

package equationdefence;
import java.awt.Color;
   import java.text.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * The application's main frame.
 */
public class EquationDefenceView extends FrameView {


    //MAINMENU SIGN
    ImageIcon SignIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/WoodSign.png")));
    ImageIcon EquationIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/EquationRunner.png")));

    //SHOP Images
     ImageIcon SHeartIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/BHeart.png")));
     ImageIcon SHeartIcon2 = (new javax.swing.ImageIcon(getClass().getResource("resources/BDHeart.png")));
        ImageIcon PlusIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Plus.png")));
        ImageIcon MinusIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Minus.png")));
        ImageIcon SpeedIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Speed.png")));

        //Score Buttons
          ImageIcon HighScoreButtonIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/HighScoreButton.png")));
           ImageIcon SubmitButtonIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Submit.png")));
               ImageIcon HSBackIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/HSBack.png")));
                 ImageIcon HSPictureIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/ApplePoster.png")));
  ImageIcon SaveButtonIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/SaveButton.png")));
          ImageIcon LoadButtonIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/LoadButton.png")));
       ImageIcon ClearButtonIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/ClearButton.png")));

       //Solve Icons
        ImageIcon SolveBackIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Desktop.jpg")));
             ImageIcon HelpIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Help.png")));
              ImageIcon BackIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Back.png")));
              //Instruction Icons
 ImageIcon Screen0 = (new javax.swing.ImageIcon(getClass().getResource("resources/s0.png")));
 ImageIcon Screen1 = (new javax.swing.ImageIcon(getClass().getResource("resources/s1.png")));
  ImageIcon Screen2 = (new javax.swing.ImageIcon(getClass().getResource("resources/s2.png")));
   ImageIcon Screen3 = (new javax.swing.ImageIcon(getClass().getResource("resources/s3.png")));
    ImageIcon Screen4 = (new javax.swing.ImageIcon(getClass().getResource("resources/s4.png")));
  ImageIcon Screen5 = (new javax.swing.ImageIcon(getClass().getResource("resources/HowToSolve.png")));
   ImageIcon Screen6 = (new javax.swing.ImageIcon(getClass().getResource("resources/s6.png")));
 


    //CScene Icons
         ImageIcon PikaSleepImage = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaSleep.png")));
            ImageIcon AppleIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Apple.png")));
             ImageIcon BubbleIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Zzz.png")));
                ImageIcon AngerBubbleIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Anger.png")));
               ImageIcon ExBubbleIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/ExBubble.png")));
               //GameStartIcon
               //User Icons
    ImageIcon UserWalk1 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk1.png")));
     ImageIcon UserWalk2 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk2.png")));
      ImageIcon UserWalk3 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk3.png")));
         ImageIcon UserJumpImage = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaJump.png")));
             ImageIcon HeartIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Heart.png")));
                      ImageIcon DarkHeartIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/DarkHeart.png")));
  
           ImageIcon PlatformIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/wood.jpg")));
             ImageIcon SpringIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Spring1.png")));
                 ImageIcon BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Lightning.png")));

                 //Enemy Icons
                  ImageIcon Enemy1Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/Charmander.png")));
                  ImageIcon Enemy1BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/FireBall.png")));
                    ImageIcon Enemy2Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/BeeDrill.png")));
                      ImageIcon Enemy3Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/Golem.png")));
                        ImageIcon Enemy4Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/Pidgey.png")));
                        ImageIcon Enemy4BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Tornado.png")));
                        //Boss Icons
                          ImageIcon MewtwoIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/MewtwoStand.png")));
                             ImageIcon MewtwoA1Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/MewtwoA1.png")));
                                 ImageIcon MewtwoA2Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/MewtwoA2.png")));
                              ImageIcon MewtwoA3Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/MewtwoA3.png")));
                            ImageIcon MewtwoOrbIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/DarkOrb.png")));
                          ImageIcon MewtwoGOrbIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/GDarkOrb.png")));
                           ImageIcon DeoxysIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/NDeoxys.png")));
                             ImageIcon ADeoxysIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/ADeoxys.png")));
                               ImageIcon SDeoxysIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/SDeoxys.png")));
                                ImageIcon SDeoxys2Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/SDeoxys2.png")));
                                 ImageIcon DDeoxysIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/DDeoxys.png")));
                            ImageIcon DeoxysBeam1Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/DeoxysBeam1.png")));
                             ImageIcon DeoxysShieldIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/DShield.png")));
                             ImageIcon ArceusIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Arceus.png")));
                                  ImageIcon ArceusA2Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/ArceusA2.png")));
                                    ImageIcon ArceusA3Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/ArceusA3.png")));
                              ImageIcon ArceusLBallIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/ArceusLBall1.png")));
                              ImageIcon ArceusLBall2Icon = (new javax.swing.ImageIcon(getClass().getResource("resources/ArceusLBall2.png")));
                                  ImageIcon ArceusHLIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/White.jpg")));

                                       //CLIPS - these are for sound and music
                                  InputStream StarCoreIn;
                                  InputStream ThinkingIn;
                                  InputStream HappyIn;
                                  InputStream WinningIn;
                                  //Background Musics
                                   private Clip MusicClip;
                                    private Clip StarCoreClip;
                                     private Clip ThinkingClip;
                                       private Clip WrongClip;
                                        private Clip CorrectClip;
                                   //User sound effects
                                   private Clip jumpclip;
                                   private Clip shootclip;
                                     private Clip hitclip;
                                     //Boss Effects
                                       private Clip MewtwoA1Clip;
                                        private Clip MewtwoA2Clip;
                                          private Clip MewtwoA3Clip;
                                            private Clip MewtwoA3Clip2;

                                               private Clip DeoxysA1Clip;
                                        private Clip DeoxysA2Clip;
                                          private Clip DeoxysA3Clip;


                                               private Clip ArceusA1Clip;
                                        private Clip ArceusA1Clip2;
                                          private Clip ArceusA2Clip;
                                            private Clip ArceusA3Clip;
                                              private Clip ArceusA3Clip2;


                                  //JLABELS OF ALL IMAGES AND TEXT

                                                //Screen variables - these determine what phase the game is in
                                           Boolean CScene = true;
                                    Boolean Menu = false;
                               Boolean Shop = false;
                              Boolean Solve = false;
                                           Boolean GameStart = false;
                              Boolean Instructions = false;
                                     Boolean Winning = false;
                             Boolean HSScreen = false;

                                  //Main Menu
                             JLabel MyName = new JLabel();
                                  JLabel WoodSign = new JLabel();
                                   JLabel EquationSign = new JLabel();
                                   JLabel TextSign = new JLabel();
                                     int MenuDelay = 0;
                                     Boolean GoBackToShop = false;

                                   //Shop
                                   JLabel SSHeart = new JLabel();
                                   JLabel HeartPlus = new JLabel();
                                   JLabel HeartText = new JLabel();
                                   JLabel SSHeart2 = new JLabel();
                                   JLabel HeartPlus2 = new JLabel();
                                   JLabel HeartText2 = new JLabel();
                                   JLabel SpeedUP = new JLabel();
                                   JLabel SpeedPlus = new JLabel();
                                  JLabel SpeedMinus = new JLabel();
                                   JLabel SpeedText = new JLabel();

                                   //Solving Screen Labels
                                   JLabel SolveBack = new JLabel();
                                   JLabel SolveEquation = new JLabel();
                                    JLabel SolveText = new JLabel();
                                    JLabel HelpButton = new JLabel();
                                  JLabel DisplayAnswer = new JLabel();
                                  JLabel TipGuy = new JLabel();
                                  JLabel TipGuyText = new JLabel();

                                   //High Score Screen Labels and variables
                                    JLabel JHighScore = new JLabel();
                                    ArrayList<items> ScoreList = new ArrayList<items>();
                                     BufferedReader Reader ;
                                     Boolean SubmitAble = true;
                                     Boolean ClearQuestion = false;
                                     JLabel HSBack = new JLabel();
                                    JLabel HSPicture = new JLabel();

                                     //Shop Variables
                                    int HeartCost = 500;
                                      int HeartCost2 = 500;

                                       //CutScene variables
                                           int CSceneAct = 0;
                                          int CSceneDelay = 0;

                                        //Variables for the winning screen
                                           int WinningAct = 0;
                                             String tempScore = null;
                                             int EventTimer = 0;
                                             JLabel WinningText = new JLabel();
                                         JLabel Congratulations = new JLabel();

                                     //HighScore Screen
                                     JLabel HighScoreButton = new JLabel();
                                     JLabel HighScoreText = new JLabel();
                                    JLabel HighScoreTitle = new JLabel();
                                     JLabel SubmitButton = new JLabel();
                                    JLabel SubmitText = new JLabel();
                                    JLabel ErrorText = new JLabel();
                                    //SaveLoad Variables
                                    JLabel SaveButton = new JLabel();
                                    JLabel LoadButton = new JLabel();
                                     JLabel ClearButton = new JLabel();
                                    JLabel SaveLoadText = new JLabel();

                                     //Instructions Variables
                                    JLabel Screenshot = new JLabel();
                                    JLabel ScreenshotTitle = new JLabel();
                                    JLabel IInstructions = new JLabel();
                                    int ScreenValue = 0;
                                    //Calculator variables
                                    //Value holders
                                      int Num = 0;
                                    int Num2 = 0;
                                    int Answer = 0;
                                    int Answer2 = 0;

                                     String SNum = "";
                                       String SNum2;
                                      String SAnswer;

                                     //Operators
                                   Boolean AddMode = false;
                                     Boolean MinusMode = false;
                                     Boolean MultiplyMode = false;
                                     Boolean DivideMode = false;
                                         Boolean EqualsMode = false;

                                    //User Variables
                                   JLabel User = new JLabel();
                                   JLabel Apple = new JLabel();
                                    JLabel Bubble = new JLabel();
                                   JLabel[] HealthHearts = new JLabel[21];
                                       int UserInvincibility = 0;
                                     int UserInvincibilityTime = 50;
                                     Boolean UserLose = false;
                                         int UserHealth = 3;
                                          int MaxHealth = 3;
                                         Boolean ULEFT = false, URIGHT = false;
                                                 int UserSpeed = 10;
                                                    int UserVelocity = 25, UserAcceleration = 2;
                                                int TempVelocity = 0;
                                                int SpriteNumber = 3;
                                                 Boolean UserJump = false, UserDoubleJump = false, UserAirBorne = false;
                                             Boolean UserDoubleJumpAble = false;
                                            //Music Timer - Restarts music
                                             int MusicTimer = 0;
                                           
                                            //Floor
                                            JLabel[] Floor = new JLabel[7];
                                                BufferedImage FloorImage = null;
                                             ImageIcon FloorIcon;
                                             int FloorNumber = 0;
                                            //Platform
                                            JLabel[] Platform = new JLabel[7];
                                              Boolean[] OnPlatform = new Boolean[7];
                                            //Spring
                                            JLabel[] Spring = new JLabel[7];
                                            //Background
                                             private JLabel Background = new JLabel();
                                              private JLabel Background2 = new JLabel();
           
                                                  
                                              //Money and score
                                                  int Score = 0;
                                                 int HighScore = 0;
                                                  int CashMoney = 500;

                                                  //Event Timer variables - advance the game
                                                       int EventTimerPlatform = 0;
                                                    int PlatformNumber = 0;
                                                     int EventTimerFloor = 0;
                                                
                                                   int BackSpeed = 5;
                                                   int BackSpeedSlowDown = 0;
                                                 int BackSpeedIncreaseTimer = 0;
                                                  int BackSpeedIncreaseCounter = 0;

                                                 int RandPlatformX = (int)Math.floor(Math.random() * (20 - BackSpeedIncreaseCounter - 10 - BackSpeedIncreaseCounter + 1) + 10);
                                                int RandPlatformY = (int)Math.floor(Math.random() * (400 - 100 + 1) + 100);

                                                  int RandFloorX = (int)Math.floor(Math.random() * (75  - 15  + 1) + 15);
                                                  int RandFloorSize = 1390;
                                                 int SpawnEnemy1 = 0;


                                             //ENEMY VARIABLES
                                                     int RandomEnemy = 0;
                                                  //Enemy 1 Variables - Charmander
                                         Boolean DeadEnemy1 = true;
                                         int DeathDelay = 0;
                                          Boolean BulletActive = false;
                                          JLabel[] Bullet = new JLabel[7];
                                          JLabel Enemy1 = new JLabel();
                                          JLabel Enemy1Bullet = new JLabel();

                                                  int Enemy1BulletTimer = 0;
                                             Boolean Enemy1BulletAct = false;
                                                 int EventTimerBoss = 0;
                                          
         
            //Enemy 2 Variables - Beedrill
             JLabel Enemy2 = new JLabel();
             int Enemy2Act = 0;
             int Enemy2Delay = 0;
             int Enemy2LockX = 0;
             int Enemy2LockY = 0;
             int Enemy2Velocity = 0, Enemy2Acceleration = 0;
             Boolean DeadEnemy2 = true;

             //Enemy 3 Variables - Golem
             JLabel Enemy3 = new JLabel();
             Boolean DeadEnemy3 = true;
             int SpawnEnemy3 = 0;
             int Enemy3Health = 3;

             //Enemy 4 Variables - Pidgeotto
             JLabel Enemy4 = new JLabel();
             Boolean DeadEnemy4 = true;
             int SpawnEnemy4 = 0;
           int Enemy4Act = 0, Enemy4Delay = 0;
             JLabel Enemy4Bullet = new JLabel();
              Boolean Enemy4BulletAct = false;

              //BOSS ENEMY Variables
              //Mewtwo Boss Variables
            JLabel Mewtwo = new JLabel();
             int MewtwoAct = 0;
             Boolean DeadM = false;
             int MewtwoA1Act = 0;
             int MewtwoA2Act = 0;
             int MewtwoA3Act = 0;
             int MewtwoDelay = 0;
             JLabel MewtwoOrb1 = new JLabel();
             int MO1Acceleration = 0, MO1Velocity = 0;
              int MO2Acceleration = 0, MO2Velocity = 0;
             JLabel MewtwoOrb2 = new JLabel();
             JLabel MewtwoOrb3 = new JLabel();
             int MewtwoA2Acceleration = 0, MewtwoA2Velocity = 0;
              int MewtwoAttack = 0;
              Boolean DeadMewtwo = false;
              int MewtwoHealth = 28;

              //Deoxys Boss Variables
              JLabel Deoxys = new JLabel();
              int DeoxysHealth = 25;
               JLabel DeoxysBeam1 = new JLabel();
                JLabel DeoxysBeam2 = new JLabel();
             int DeoxysAct = 0;
             int DeoxysA1Act = 0;
             BufferedImage BeamImage = null;
    ImageIcon BeamIcon;
             int DeoxysBeam2Length = 1;
             int DeoxysA2Act = 0;
             int DeoxysA3Act = 0;
             int DeoxysDelay = 0;
             int DeoxysAttack = 0;
            Boolean DeadDeoxys = false;

            int DeoxysA2Velocity = 0;
            int DeoxysA2Acceleration = 0;
            JLabel DeoxysShield = new JLabel();
            Boolean ReflectedBullet = false;

            //Arceus Boss Variables
               JLabel Arceus = new JLabel();
               JLabel ArceusLight1 = new JLabel();
                JLabel ArceusLight2 = new JLabel();
                 JLabel ArceusLight3 = new JLabel();
                 JLabel ArceusHLight = new JLabel();
               int ArceusAttack = 0;
               int ArceusAct = 0;
                int ArceusDelay = 0;
              int ArceusHealth = 30;
              Boolean DeadArceus = false;
               int ArceusA1Act = 0;
               int ArceusA2Act = 0;
             int ArceusA3Act = 0;
             int ArceusA1VelocityX = 0;
              int ArceusA1AccelerationX = 0;
               int ArceusA1VelocityY = 0;
              int ArceusA1AccelerationY = 0;
              int ArceusA3HLSize = 1;

              int RandomBoss = 0;

    public EquationDefenceView(SingleFrameApplication app) {
        super(app);

        initComponents();

        //Disallow resizing of Frame
    getFrame().setResizable(false);





        //Initialize the labels that go on top (Calculator labels must be placed first)



        //Make all of them not visible
      DisplayAnswer.setVisible(false);
        btn0.setVisible(false);
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);
        btn4.setVisible(false);
        btn5.setVisible(false);
        btn6.setVisible(false);
        btn7.setVisible(false);
        btn8.setVisible(false);
        btn9.setVisible(false);
        btnClear.setVisible(false);
        btnPlus.setVisible(false);
        btnMinus.setVisible(false);
        btnMultiply.setVisible(false);
         btnDivide.setVisible(false);
           txtDisplay.setVisible(false);
         txtAnswer.setVisible(false);
         SolveBack.setVisible(false);
          SolveText.setVisible(false);
           btnEnter.setVisible(false);
           btnEquals.setVisible(false);
           JHighScore.setVisible(false);
      
      
        //Set the text of all the calculator buttons (Because the designer is unreliable)
  btnEnter.setText ("Enter");
btn0.setText ("0");
btn1.setText ("1");
btn2.setText ("2");
btn3.setText ("3");
btn4.setText ("4");
btn5.setText ("5");
btn6.setText ("6");
btn7.setText ("7");
btn8.setText ("8");
btn9.setText ("9");
btnClear.setText ("C");
btnPlus.setText ("+");
btnMinus.setText ("-");
btnDivide.setText ("/");
btnMultiply.setText ("x");
btnEquals.setText ("=");
// INITIALIZE ALL USER INTERFACE JLABELS - TITLES, PICTURES,INSTRUCTIONS, Note: They may be in a strange order because Netbeans gives priority to the first one added

         //My Name
          MyName.setSize (200,100);
        MyName.setLocation ( 1100, 580);
           MyName.setText("Programmed by: Anthony Tu");
            MyName.setFont (new Font ("Serif", Font.BOLD, 12));
              MyName.setForeground(Color.yellow);
    mainPanel.add (MyName);
    MyName.setVisible(false);

                //HelpButton on Solve SCreen
                    HelpButton.setSize (150,100);
        HelpButton.setLocation (1125,525);
   HelpButton.setIcon(HelpIcon);
                mainPanel.add (HelpButton);
                HelpButton.setVisible(false);
                //HelpButton Mouse Clicked Event
  HelpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HelpButtonMouseClicked(evt);
            }


        });
        //Instructions Title Label
   IInstructions.setSize (1300,50);
         IInstructions.setLocation (0,580);
           IInstructions.setText("Press Z to go to next page, X for Previous page, C to go back to Menu");
            IInstructions.setFont (new Font ("Serif", Font.BOLD, 30));
             IInstructions.setForeground(Color.yellow);
       mainPanel.add(IInstructions);
IInstructions.setVisible(false);

        //ScreenshotJLabels
              Screenshot.setSize (1100,550);
        Screenshot.setLocation (100,50);
            Screenshot.setIcon(Screen0);
        mainPanel.add (Screenshot);
        Screenshot.setVisible(false);

        //ScreenShot Title
         ScreenshotTitle.setSize (1300,50);
        ScreenshotTitle.setLocation (0,0);
          ScreenshotTitle.setText("The Story so Far");
            ScreenshotTitle.setFont (new Font ("Serif", Font.BOLD, 40));
            ScreenshotTitle.setHorizontalAlignment(SwingConstants.CENTER);

        mainPanel.add (ScreenshotTitle);
        ScreenshotTitle.setVisible(false);

//Initialize all the JLabels in the solving screen

//Solvetext = Instructions while on the Solve screen
            SolveText.setSize (1400,100);
        SolveText.setLocation (100,0);
          SolveText.setText("Solve for x to obtain your score (and get money for upgrades)");
            SolveText.setFont (new Font ("Serif", Font.BOLD, 40));
              SolveText.setForeground(Color.yellow);
        mainPanel.add (SolveText);

        //Equation JLAbel
    SolveEquation.setSize (700,100);
        SolveEquation.setLocation (900,-25);
          SolveEquation.setText("Score: 6x + 2309.00 = 0; x =");
            SolveEquation.setFont (new Font ("Serif", Font.BOLD, 25));
             SolveEquation.setForeground(Color.yellow);
                mainPanel.add (SolveEquation);


                //High Score JLabel
                 JHighScore.setSize (700,100);
        JHighScore.setLocation (800,-25);
          JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);
            JHighScore.setFont (new Font ("Serif", Font.BOLD, 25));
             JHighScore.setForeground(Color.yellow);
   mainPanel.add (JHighScore);
     
        //JLabel that shows "CORRECT" or "WRONG" on Solve Screen
         DisplayAnswer.setSize (700,100);
        DisplayAnswer.setLocation (1000,300);
          DisplayAnswer.setText("");
            DisplayAnswer.setFont (new Font ("Serif", Font.BOLD, 50));
            DisplayAnswer.setForeground(Color.black);
        mainPanel.add (DisplayAnswer);

          //TipGuy on The Solving Screen
     TipGuy.setSize (50,50);
        TipGuy.setLocation (75,500);
            TipGuy.setIcon(UserWalk1);
        mainPanel.add (TipGuy);
TipGuy.setVisible(false);

//TipGuy's Text
         TipGuyText.setSize (300,300);
        TipGuyText.setLocation (25,300);
         TipGuyText.setText("<html>I need to solve this <br> math equation to recover<br>my energy. </html>");
           TipGuyText.setFont (new Font ("Serif", Font.BOLD, 20));
           TipGuyText.setForeground(Color.yellow);
        mainPanel.add (TipGuyText);
TipGuyText.setVisible(false);

    
//HighScore Screen
 HighScoreText.setSize (1300,690);
        HighScoreText.setLocation (0,0);
        HighScoreText.setText("<html>1. Appledf: 398593 <br> 2. sdjk: 394812<br> 3. ssdjk: 394812<br>4. ghjsdjk: 3924812 <br> 5. sdjvk: 394812<br> 6. sdjvk: 394812<br> 7. sdjvk: 394812<br> 8. sdjvk: 394812<br> 9. sdjvk: 394812 </html>");
  HighScoreText.setHorizontalAlignment(SwingConstants.CENTER);
           HighScoreText.setFont (new Font ("Serif", Font.BOLD, 40));
          HighScoreText.setForeground(Color.yellow);
        mainPanel.add (HighScoreText);
        HighScoreText.setVisible(false);

        //Title on High score screen
         HighScoreTitle.setSize (1300,50);
        HighScoreTitle.setLocation (0,0);
        HighScoreTitle.setText("High Scores");
   HighScoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
           HighScoreTitle.setFont (new Font ("Serif", Font.BOLD, 40));
          HighScoreTitle.setForeground(Color.yellow);
        mainPanel.add (HighScoreTitle);
        HighScoreTitle.setVisible(false);
        //Submit Button on High score screen
         SubmitButton.setSize (102,50);
        SubmitButton.setLocation (1050,200);
            SubmitButton.setIcon(SubmitButtonIcon);
        mainPanel.add (SubmitButton);
SubmitButton.setVisible(false);
//SubmitButton MouseClicked Event
        SubmitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitButtonMouseClicked(evt);
            }


        });
        //High Score Picture - MISSING APPLES
      HSPicture.setSize (350,400);
         HSPicture.setLocation (50,100);
            HSPicture.setIcon( HSPictureIcon);
        mainPanel.add ( HSPicture);
            HSPicture.setVisible(false);
//High SCore back Button
              HSBack.setSize (102,50);
       HSBack.setLocation (1150,550);
           HSBack.setIcon(HSBackIcon);
        mainPanel.add (HSBack);
HSBack.setVisible(false);
//Back Button Mouse Clicked
        HSBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HSBackMouseClicked(evt);
            }


        });

        //Submit Text instructions in High score screen
         SubmitText.setSize (200,50);
        SubmitText.setLocation (1025,70);
        SubmitText.setText("Enter your name:");

           SubmitText.setFont (new Font ("Serif", Font.BOLD, 20));
          SubmitText.setForeground(Color.yellow);
        mainPanel.add (SubmitText);
       SubmitText.setVisible(false);

       //Error Text when invalid name in High score screen
       ErrorText.setSize (500,100);
        ErrorText.setLocation (950,270);
        ErrorText.setText("<html>Invalid input - Name must be between <br> 1 and 9 characters and have no spaces<html");

           ErrorText.setFont (new Font ("Serif", Font.BOLD, 20));
          ErrorText.setForeground(Color.yellow);
        mainPanel.add (ErrorText);
        ErrorText.setVisible(false);

///Solve Back - Wooden background in solving screen and Highscore screen
        SolveBack.setSize (1400,700);
        SolveBack.setLocation (0,0);
            SolveBack.setIcon(SolveBackIcon);
        mainPanel.add (SolveBack);

    

        //MAIN MENU'

        //Score Buttons in shop to go to high score screen
         HighScoreButton.setSize (112,50);
        HighScoreButton.setLocation (390,60);
           HighScoreButton.setIcon(HighScoreButtonIcon);
        mainPanel.add (HighScoreButton);
        HighScoreButton.setVisible(false);
//High score button mouse clicked evenet
            HighScoreButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HighScoreButtonMouseClicked(evt);
            }


        });
        //Save Button in shop
         SaveButton.setSize (64,44);
       SaveButton.setLocation (HighScoreButton.getX()+HighScoreButton.getWidth()+50,HighScoreButton.getY());
          SaveButton.setIcon(SaveButtonIcon);
        mainPanel.add (SaveButton);
SaveButton.setVisible(false);
//Save Button Mouse clicked event
 SaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButtonMouseClicked(evt);
            }


        });

        //Load Button in shop
       LoadButton.setSize (67,47);
        LoadButton.setLocation (SaveButton.getX()+SaveButton.getWidth()+50,HighScoreButton.getY());
          LoadButton.setIcon(LoadButtonIcon);
        mainPanel.add (LoadButton);
LoadButton.setVisible(false);
//Load Button mouse clicked event
    LoadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoadButtonMouseClicked(evt);
            }


        });

//Clear Button in shop
         ClearButton.setSize (121,48);
        ClearButton.setLocation (LoadButton.getX()+LoadButton.getWidth()+50,HighScoreButton.getY());
         ClearButton.setIcon(ClearButtonIcon);
        mainPanel.add (ClearButton);

ClearButton.setVisible(false);
//Clear Button mouse clicked event
   ClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearButtonMouseClicked(evt);
            }


        });


        //SaveLoadText in shop to verify that you have saved/load
                SaveLoadText.setSize (300,200);
      SaveLoadText.setLocation (700,200);
       SaveLoadText.setText("");
          SaveLoadText.setFont (new Font ("Serif", Font.BOLD, 12));
           SaveLoadText.setHorizontalAlignment(SwingConstants.CENTER);
                     SaveLoadText.setForeground(Color.yellow);
                       mainPanel.add(SaveLoadText);
SaveLoadText.setVisible(false);

        //Shop labels
        //The Heart picture
        SSHeart.setSize (100,82);
        SSHeart.setLocation (2000,100);
            SSHeart.setIcon(SHeartIcon);
        mainPanel.add (SSHeart);

        //The plus sign
         HeartPlus.setSize (50,50);
        HeartPlus.setLocation ((SSHeart.getX() + (SSHeart.getWidth()/2)) - 25,SSHeart.getY() + SSHeart.getHeight());
            HeartPlus.setIcon(PlusIcon);
        mainPanel.add (HeartPlus);

        //Make HeartPlus into a clickable button
          HeartPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeartPlusMouseClicked(evt);
            }


        });

        //Description about the heart upgrade
         HeartText.setSize (300,100);
        HeartText.setLocation (SSHeart.getX() + SSHeart.getWidth() + 10,(SSHeart.getY() + (SSHeart.getHeight()/2))-25);
            HeartText.setText("<html>Health Hearts <br> Health = " + MaxHealth + " <br> Cost to upgrade: $" + HeartCost + " </html>");
            HeartText.setFont (new Font ("Serif", Font.BOLD, 12));
    mainPanel.add (HeartText);

        //Black heart (Invincibility) upgrade
        //Black Heart picture
                SSHeart2.setSize (100,82);
        SSHeart2.setLocation (2000,100);
            SSHeart2.setIcon(SHeartIcon2);
        mainPanel.add (SSHeart2);

        //Black heart plus sign
         HeartPlus2.setSize (50,50);
        HeartPlus2.setLocation ((SSHeart2.getX() + (SSHeart2.getWidth()/2)) - 25,SSHeart2.getY() + SSHeart2.getHeight());
            HeartPlus2.setIcon(PlusIcon);
        mainPanel.add (HeartPlus2);

           mainPanel.add (HeartPlus2);
           //Make plus sign clickable
          HeartPlus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeartPlus2MouseClicked(evt);
            }


        });
        //Description of the black heart
         HeartText2.setSize (300,100);
        HeartText2.setLocation (SSHeart2.getX() + SSHeart2.getWidth() + 10,(SSHeart2.getY() + (SSHeart2.getHeight()/2))-25);
                HeartText2.setText("<html>Invincibility time (when hit) <br> Invincibility when hit = " + UserInvincibilityTime * 20 + " ms <br> Cost to upgrade: $" + HeartCost2 + " </html>");
            HeartText2.setFont (new Font ("Serif", Font.BOLD, 12));
            mainPanel.add (HeartText2);

            //Speed up image
   SpeedUP.setSize (46,50);
         SpeedUP.setLocation (2000,130);
            SpeedUP.setIcon(UserWalk1);
        mainPanel.add ( SpeedUP);

        //Speed up plus sign
         SpeedPlus.setSize (50,50);
       SpeedPlus.setLocation ( SpeedUP.getX() -25, SpeedUP.getY() +  SpeedUP.getHeight());
            SpeedPlus.setIcon(PlusIcon);
        mainPanel.add (SpeedPlus);

        //Make Plus sign clickable
         SpeedPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SpeedPlusMouseClicked(evt);
            }
        });
        //Speed up minus sign
          SpeedMinus.setSize (50,50);
       SpeedMinus.setLocation ( SpeedUP.getX() +25, SpeedUP.getY() +  SpeedUP.getHeight());
            SpeedMinus.setIcon(MinusIcon);
        mainPanel.add (SpeedMinus);

        //Make Minus sign clickable
        SpeedMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SpeedMinusMouseClicked(evt);
            }
        });
        //Speed Up description
         SpeedText.setSize (300,100);
        SpeedText.setLocation ( SpeedUP.getX() +  SpeedUP.getWidth() + 10, SpeedUP.getY()-35);
           SpeedText.setText("<html>Speed (More of a preference) <br> Speed = " + UserSpeed + "<br> Cost to change: 500 </html>");
            SpeedText.setFont (new Font ("Serif", Font.BOLD, 12));
    mainPanel.add (SpeedText);



//Main MENU Jlabel initializations

    //Word "Equation Runner"
        EquationSign.setSize (700,200);
         EquationSign.setLocation (350,-425);
            EquationSign.setIcon(EquationIcon);
        mainPanel.add (EquationSign)  ;
        EquationSign.setVisible(false);

    


        //Winning text - text on winning screen
                 WinningText.setSize (950,200);
        WinningText.setLocation (175,65);
           WinningText.setHorizontalAlignment(SwingConstants.CENTER);
        WinningText.setText("<html>" + tempScore + "<br>Health Bonus: " + (2000 * UserHealth) + "<br>Total " + SolveEquation.getText() + "<br>Press Z to Continue</html>");
           WinningText.setFont (new Font ("Serif", Font.BOLD, 40));
           WinningText.setVisible(false);
         
                       WinningText.setForeground(Color.yellow);
                       mainPanel.add(WinningText);

                       //Congratualions text on winning screen
                              Congratulations.setSize (1300,200);
        Congratulations.setLocation (0,275);
          Congratulations.setHorizontalAlignment(SwingConstants.CENTER);
         Congratulations.setText("Congratulations! You beat the game and took back your apple!");
           Congratulations.setFont (new Font ("Serif", Font.BOLD, 40));
          Congratulations.setVisible(false);

                       Congratulations.setForeground(Color.yellow);
                       mainPanel.add(Congratulations);


        // Wood sign that goes under the Equation Runner
        WoodSign.setSize (1000,500);
    
        WoodSign.setLocation (200,-575);
            WoodSign.setIcon(SignIcon);
        mainPanel.add (WoodSign);
         WoodSign.setVisible(false);


          SolveEquation.setVisible(false);

          //Instructions Text on the main menu
                TextSign.setSize (1300,200);
        TextSign.setLocation (0, 300);
           TextSign.setText("<html>Press Z to Continue <br> X to view Instructions </html>");
            TextSign.setFont (new Font ("Serif", Font.BOLD, 50));
                TextSign.setForeground(Color.yellow);
                   TextSign.setHorizontalAlignment(SwingConstants.CENTER);
                   TextSign.setVisible(false);

    mainPanel.add (TextSign);


        //Initalize all array Jlaberls to use
for ( int i = 0; i < 6; i++){
    Platform[i] = new JLabel();
Spring[i] = new JLabel();
Floor[i] = new JLabel();
Bullet[i] = new JLabel();



}

          //Change frame size to (1300,690)
 this.getFrame().validate();
  this.getFrame().setSize(1300,690);


//SIZE OF FRAME IS (1390, 775)



  //RESIZAEABLE OBJECTS
  //Resize Floor on command
  for (int i = 0; i < 6;i++)
  {
      //Gets a random size of the floor
        Floor[i].setSize(RandFloorSize,690);
     
        Floor[i].setLocation (0,555);
        OnPlatform[i] = false;

  //Resize pictures
        //Resize the StoneGround Picture for the floor
  
        try {
            FloorImage = ImageIO.read(this.getClass().getResource("resources/StoneGround.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(EquationDefenceView.class.getName()).log(Level.SEVERE, null, ex);
        }

       FloorIcon = new ImageIcon (ScaledImage( FloorImage, RandFloorSize,690));
 
//Set icon to the resized image
   Floor[i].setIcon(FloorIcon);

        }

        //Resizable Beam image
        try {
            BeamImage = ImageIO.read(this.getClass().getResource("resources/DeoxysBeam2.png"));

        } catch (IOException ex) {
            Logger.getLogger(EquationDefenceView.class.getName()).log(Level.SEVERE, null, ex);
        }
  //get the Icon of the new beam image

       BeamIcon = new ImageIcon (ScaledImage(BeamImage, DeoxysBeam2Length,80));

  //BACKGROUND -----
//Set the size and Location of the background
        Background.setSize(1400,775);
        Background.setLocation (0,0);
//Resize the Background image to fit
   BufferedImage BackgroundImage = null;
        try {
            BackgroundImage = ImageIO.read(this.getClass().getResource("resources/background.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(EquationDefenceView.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon BackgroundIcon = new ImageIcon (ScaledImage( BackgroundImage, getBackground().getWidth(), getBackground().getHeight()));

        //Set the Background
   Background.setIcon(BackgroundIcon);
//Resize Background2 image (to make background look continuous
   //Set Size and location of background
    Background2.setSize(1400,775);

        Background2.setLocation (1390,0);
//Resize Image
   BufferedImage BackgroundImage2 = null;
        try {
                BackgroundImage2 = ImageIO.read(this.getClass().getResource("resources/background.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(EquationDefenceView.class.getName()).log(Level.SEVERE, null, ex);
        }

   //Set get icon
        ImageIcon BackgroundIcon2 = new ImageIcon (ScaledImage( BackgroundImage2, getBackground().getWidth(), getBackground().getHeight()));
//Set Background2
   Background2.setIcon(BackgroundIcon2);
 //END BACKGROUND ---
       //To set the size of the form properly
         getFrame().addWindowListener(new WindowAdapter() {

                @Override
                public void windowOpened(WindowEvent e) {

                    super.windowOpened(e);
//Dimensions of the frame (1300,690)
                    e.getWindow().setSize(1300, 690);

                    Dimension screenDims = e.getWindow().getToolkit().getScreenSize();
                    Rectangle frameDims = e.getWindow().getBounds();

                    e.getWindow().setLocation(
                            (screenDims.width - frameDims.width) / 2,
                            (screenDims.height - frameDims.height) / 2);
                }
        });

        //Set inital locations of all platforms
         for (int i = 0; i < 6;i++)
  {
              Platform[i].setLocation (1400,300);
              Platform[i].setSize(225,60);
         }
       
           
         
     
   //Resize Platform image
   BufferedImage PlatformImage = null;
        try {
            PlatformImage = ImageIO.read(this.getClass().getResource("resources/wood.jpg"));
            
        } catch (IOException ex) {
            Logger.getLogger(EquationDefenceView.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon PlatformIcon = new ImageIcon (ScaledImage(PlatformImage, 225,60));
          //set Platform image

              for (int i = 0; i < 6;i++)
  {
                   Platform[i].setIcon(PlatformIcon);

              }

   
    //END PLATFORM

          
UserHealth = MaxHealth;
//Reset hearts
for ( int i = 1; i < 11; i++){
    HealthHearts[i] = new JLabel();
HealthHearts[i].setSize (50,50);
HealthHearts[i].setLocation (i * 60 - 55,10);
HealthHearts[i].setIcon(HeartIcon);
mainPanel.add(HealthHearts[i]);
HealthHearts[i].setVisible(false);
}
        for ( int i = 1; i < 11; i++){
    HealthHearts[i+10] = new JLabel();
HealthHearts[i+10].setSize (50,50);
HealthHearts[i+10].setLocation (i * 60 - 55,60);
HealthHearts[i+10].setIcon(HeartIcon);
mainPanel.add(HealthHearts[i]);
HealthHearts[i].setVisible(false);
}

        CheckHealth();





         

         //Initialize Arceus picture
                   Arceus.setSize (100,150);
         Arceus.setLocation (1650,50);
             Arceus.setIcon(ArceusIcon);
         mainPanel.add(Arceus);



  ArceusLight1.setSize (80,80);
         ArceusLight1.setLocation (1390,200);
             ArceusLight1.setIcon(ArceusLBallIcon);

         mainPanel.add(ArceusLight1);

           ArceusLight2.setSize (200,200);
         ArceusLight2.setLocation (950,-200);
             ArceusLight2.setIcon(ArceusLBall2Icon);

         mainPanel.add(ArceusLight2);

           ArceusLight3.setSize (200,200);

         ArceusLight3.setLocation (400,-200);
             ArceusLight3.setIcon(ArceusLBall2Icon);

         mainPanel.add(ArceusLight3);

          ArceusHLight.setSize (400,1);
         ArceusHLight.setLocation (1390,0);
             ArceusHLight.setIcon(ArceusHLIcon);

         mainPanel.add(ArceusHLight);


           //Initialize Mewtwo picture
         Mewtwo.setSize (83,100);
         Mewtwo.setLocation (Arceus.getX()-150,200);
             Mewtwo.setIcon(MewtwoIcon);
         mainPanel.add(Mewtwo);


                  MewtwoOrb1.setSize (80,80);
         MewtwoOrb1.setLocation (1390,200);
             MewtwoOrb1.setIcon(MewtwoOrbIcon);
             mainPanel.add(MewtwoOrb1);

         MewtwoOrb2.setSize (80,80);
         MewtwoOrb2.setLocation (1390,200);
             MewtwoOrb2.setIcon(MewtwoOrbIcon);
               MewtwoOrb2.setSize (80,80);
                mainPanel.add(MewtwoOrb2);

         MewtwoOrb3.setLocation (1390,200);
             MewtwoOrb3.setIcon(MewtwoOrbIcon);
             MewtwoOrb3.setSize (80,80);
               mainPanel.add(MewtwoOrb3);






         //Initialize Deoxys picture
 Deoxys.setLocation (Arceus.getX()+150,200);
                    Deoxys.setSize (84,100);

             Deoxys.setIcon(DeoxysIcon);
         mainPanel.add(Deoxys);

          //Add Deoxys Icons
      DeoxysShield.setSize (200,200);
         DeoxysShield.setLocation (1390,200);
             DeoxysShield.setIcon(DeoxysShieldIcon);

         mainPanel.add(DeoxysShield);

            DeoxysBeam1.setSize (107,80);
         DeoxysBeam1.setLocation (1390,200);
             DeoxysBeam1.setIcon(DeoxysBeam1Icon);

         mainPanel.add(DeoxysBeam1);

            DeoxysBeam2.setSize (0,80);
         DeoxysBeam2.setLocation (1390,200);
   
         mainPanel.add(DeoxysBeam2);





        //Initialize User starting location

        User.setIcon(PikaSleepImage);
        User.setSize(50,50);

         User.setLocation (150,505);

    mainPanel.add(User);

    Bullet[0].setSize(20,20);
Bullet[0].setIcon(BulletIcon);
Bullet[0].setLocation (1400,0);
mainPanel.add(Bullet[0]);


    //Initialize Apple for cutscene
           Apple.setIcon(AppleIcon);
       Apple.setSize(50,50);
        Apple.setLocation (User.getX()+User.getWidth()+10,505);
         mainPanel.add(Apple);

         //Heart emoticon
            Bubble.setIcon(BubbleIcon);
             Bubble.setSize(75,75);
        Bubble.setLocation (User.getX()+20,450);
         mainPanel.add(Bubble);
    
     //Enemy 1
       Enemy1.setLocation (1390,505);
Enemy1.setSize(50,50);
Enemy1.setIcon(Enemy1Icon);
  mainPanel.add(Enemy1);

     //Enemy 1
       Enemy1Bullet.setLocation (1390,505);
Enemy1Bullet.setSize(50,50);
Enemy1Bullet.setIcon(Enemy1BulletIcon);
  mainPanel.add(Enemy1Bullet);

     //Add Enemy2 (Beedrill) Icons
        Enemy2.setSize(80,80);
        Enemy2.setLocation(1390,350);
        Enemy2.setIcon(Enemy2Icon);
        mainPanel.add (Enemy2 );

               //Add Enemy3 (Golem) Icons
         Enemy3.setSize(80,80);
        Enemy3.setLocation(1390,475);
        Enemy3.setIcon(Enemy3Icon);
        mainPanel.add(Enemy3);

              //Add Enemy4 (Pidgeotto Icons
        Enemy4.setSize(80,60);
        Enemy4.setLocation(1390,100);
        Enemy4.setIcon(Enemy4Icon);

         mainPanel.add(Enemy4);
            Enemy4Bullet.setSize(40,36);
        Enemy4Bullet.setLocation(1400,100);
        Enemy4Bullet.setIcon(Enemy4BulletIcon);
      
         mainPanel.add(Enemy4Bullet);

             //Set the spring location
             Spring[0].setLocation (1400,500);
             Spring[0].setSize(50,60);
             Spring[0].setIcon(SpringIcon);
             mainPanel.add(Spring[0]);


//Set focus to mainPanel to allow keystrokes to be read (IMPORTANT)
mainPanel.setFocusable(true);
txtDisplay.setFocusable(false);

  //Reset Floor Locations and sizes
        RandFloorSize = 1400;
        FloorNumber = 0;


          for (int i = 0; i < 6;i++)
  {
        Floor[i].setSize(RandFloorSize,690);

        Floor[i].setLocation (1400,1000);
        OnPlatform[i] = false;
         mainPanel.add(Floor[i]);
         mainPanel.add(Platform[i]);


                 }
 //Initialize Floor Locations
         Floor[0].setLocation(0,555);
        Floor[0].setSize(1390,690);
        Floor[1].setLocation(1390,555);
        Floor[1].setSize(1390,690);

            for (int i = 1; i < 6;i++)
  {
                   Platform[i].setLocation (1400,-500);
            }


 //Set location of the first platform (it is special)
             Platform[0].setLocation (1400,300);
             Platform[0].setSize(225,60);

//Background images add
        mainPanel.add(Background);
        mainPanel.add(Background2);

        



//SIZE OF FRAME IS (1390, 775)
  
   


        //END INITIALIZATION OF VARIABLES-------------------------------------
//UserMove Timer (and jump, shoot, run, enemies, Events, etc)
  //TIMERSS!!!!!!!!!! ---------------------------------------------------------------------------
//MAIN TIMER FOR MOST EVENTS
   int delay = 20; //milliseconds
  ActionListener UserMovePerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

          if (GameStart == false)
          {
              //Menudelay is to add a delay between every keypress, so it is not pressed 5 times for every keystroke
              MenuDelay += 1;
          }
          //CutSceneCoDe!
          if (CScene == true)
          {
          //Part 0 of Cutscene: Happy times
          if (CSceneAct == 0 )
          {
              //Delay to advance to next action
                 CSceneDelay += 1;
              //After it has reached the delay, appear the legendary math Lords!
                if (CSceneDelay >= 200)
           {
                    //Move the Legendaries left on to the screen
                        Arceus.setLocation (Arceus.getX() - 20, Arceus.getY());
                        Mewtwo.setLocation (Mewtwo.getX() - 20, Mewtwo.getY());
                        Deoxys.setLocation (Deoxys.getX() - 20, Deoxys.getY());
                        //When they're in the right position, advance to next scene
                    if (Mewtwo.getX() <= 600)
                     {
                        //Advance to next scene
                      
                        CSceneDelay = 0;
                        CSceneAct = 1;
                        //Stop super happy music
                        try{
                            HappyIn.close();
                        }
                        catch (Exception e)
                        {

                        }
                        BackgroundMusic();
                 }
                }

          }
          //Part 1 of Cutscene: The robbery
          if (CSceneAct == 1)
          {
              //Delay to advance to next action
            CSceneDelay += 1;
            //After the delay, move the apple with psychic powers!
            if (CSceneDelay >= 75)
            {
                Apple.setLocation(Apple.getX(),Apple.getY()-10);
            }
            //Play sound effect
             if (CSceneDelay == 75)
            {
                 MewtwoA2Effect();
                  Bubble.setVisible (false);
             }
             //Wake up the Pikachu
             if (CSceneDelay == 90)
            {
                 SpriteNumber = 1;
                 Bubble.setIcon(ExBubbleIcon);
              Bubble.setVisible (true);
              User.setIcon(UserWalk1);
            }
            //When the apple is at the highest point, next scene
            if (Apple.getY() <= 170)
            {
                CSceneAct = 2;
                  MewtwoA2Effect();
            }

          }
          //Part 2 of Cutscene: The horizontal apple movement
            if (CSceneAct == 2)
          {
                //Move the apple towards the legendaries
             Apple.setLocation(Apple.getX()+10,Apple.getY());
             //When the apple is at the right point, advance scene
             if (Apple.getX() >= (Arceus.getX() + (Arceus.getWidth()/2))-40)
             {
                 CSceneAct = 3;
                 CSceneDelay = 0;
             }
            }
          //Part 3 of Cutscene: The random delay
           if (CSceneAct == 3)
          {
               //Delay to advance to next action
               CSceneDelay += 1;
               //Advance to next scene
                if (CSceneDelay >= 50)
            {
                    //Queue inspiring boss music
                    StarCoreMusic();
                 Bubble.setIcon (AngerBubbleIcon);
                 
                    CSceneAct = 4;
                    CSceneDelay = 0;
                }
           }
           //Part 4 of Cutscene: The move away
          if (CSceneAct == 4)
          {
          //Move all three charaters away along with the apple
              if (Mewtwo.getX() <= 1400)
              {
                Apple.setLocation(Apple.getX()+20,Apple.getY());
                Arceus.setLocation (Arceus.getX() + 20, Arceus.getY());
                Mewtwo.setLocation (Mewtwo.getX() +20, Mewtwo.getY());
                 Deoxys.setLocation (Deoxys.getX() + 20, Deoxys.getY());
              }
              //Start moving the background
               Background.setLocation (Background.getX() - 5,Background.getY());
          Background2.setLocation (Background2.getX() - 5,Background2.getY());
          //If one background is less than 0, move it back to the starting location for a continuous effect
        if (Background.getX() + 1390 < 0)
          {
             Background.setLocation (1390,0);
          }
           if (Background2.getX() + 1390 < 0)
          {
             Background2.setLocation (1390,0);
          }
          //Start moving Floor
           Floor[0].setLocation ( Floor[0].getX() - 5, Floor[0].getY());
           Floor[1].setLocation ( Floor[1].getX() - 5, Floor[1].getY());
            //If one Floor is less than 0, move it back to the starting location for a continuous effect
             if (Floor[0].getX() + Floor[0].getWidth() < 0)
          {
            Floor[0].setLocation (1300,555);
          }
           if (Floor[1].getX() + Floor[1].getWidth() < 0)
          {
             Floor[1].setLocation (1300,555);
          }
          //Delay till next action
        CSceneDelay +=1;
        //After a while, show the menu signs
    if (CSceneDelay == 75)
        {
        EquationSign.setVisible(true);
        MyName.setVisible(true);
          WoodSign.setVisible(true);
        }

    if (CSceneDelay >= 75)
    {
//Slowly lower the signs to the correct position
    EquationSign.setLocation(EquationSign.getX(),EquationSign.getY()+5);
     WoodSign.setLocation( WoodSign.getX(), WoodSign.getY()+5);
     //After they are in the correct position,
     if (WoodSign.getY() >= -75)
        {
            Bubble.setVisible(false);
         //Change Cutscenemode to Menumode and continue the game
        CSceneAct = 5;
        CScene = false;
        Menu = true;
        TextSign.setVisible(true);
        }
    }
          }
}
//MENU CODE ----------------------------------------------------------------------------------------------------------------------------------------------
if (Menu == true && GameStart == false ||Shop == true && GameStart == false )
{
    //After one round is complete, initalize back some variables
    if (GoBackToShop == true && MenuDelay >= 75)
    {
        //Focus the main panel again
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        //Change shop to true and restart all variables
        GoBackToShop = false;
        GameStart = false;
        Solve = false;
        Shop = true;
        MenuDelay = 0;
        //Play epic background music again
        try{
              ThinkingIn.close();
        }
    catch (Exception e)
            {

        }
          StarCoreMusic();
   HelpButton.setVisible(false);
     TextSign.setText("<html>Press Z to Start Game <br> X to go back to Main Menu </html>");
     TextSign.setVisible(true);
     
        txtDisplay.setText("");
        DisplayAnswer.setText("");
            JHighScore.setVisible(true);
        //Set all of the solve stuff to not visible
            TipGuy.setVisible(false);
            TipGuyText.setVisible(false);
        SolveEquation.setVisible(false);
         DisplayAnswer.setVisible(false);

         MusicTimer = 0;
        btn0.setVisible(false);
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);
        btn4.setVisible(false);
        btn5.setVisible(false);
        btn6.setVisible(false);
        btn7.setVisible(false);
        btn8.setVisible(false);
        btn9.setVisible(false);
        btnClear.setVisible(false);
        btnPlus.setVisible(false);
        btnMinus.setVisible(false);
        btnMultiply.setVisible(false);
         btnDivide.setVisible(false);
           txtDisplay.setVisible(false);
         txtAnswer.setVisible(false);

         SolveBack.setVisible(false);
         SolveEquation.setVisible(false);
          SolveText.setVisible(false);
           btnEnter.setVisible(false);
           btnEquals.setVisible(false);

           SaveButton.setVisible(true);
           LoadButton.setVisible(true);
           ClearButton.setVisible(true);
           HighScoreButton.setVisible(true);
           SaveLoadText.setVisible(true);

           //Set Health Hearts not visible
            for ( int i = 1; i < 21; i ++)
          {
             HealthHearts[i].setVisible(false);
          }

           //Reset the Floor Sizes and Locations
           RandFloorSize = 1400;
               for (int i = 0; i < 6;i++)
  {
        Floor[i].setSize(RandFloorSize,690);
          FloorIcon = new ImageIcon (ScaledImage( FloorImage, RandFloorSize,690));
Floor[i].setIcon(FloorIcon);
        Floor[i].setLocation (1400,555);
        OnPlatform[i] = false;

  
                 }




             Spring[0].setLocation (1400,505);
//Readd the floors
             Floor[0].setLocation(0,555);
             Floor[0].setSize(1390,690);
            Floor[1].setLocation(1390,555);
            Floor[1].setSize(1390,690);





Enemy3.setLocation(1400,0);

//Make the Shop variables visible
 WoodSign.setVisible(true);
SSHeart.setVisible (true);
HeartPlus.setVisible (true);
HeartText.setVisible (true);
SSHeart2.setVisible (true);
HeartPlus2.setVisible (true);
HeartText2.setVisible (true);
SpeedUP.setVisible (true);
SpeedPlus.setVisible (true);
SpeedMinus.setVisible (true);
SpeedText.setVisible (true);
    }

    //Move the screen in the backgerond
           Background.setLocation (Background.getX() - 5,Background.getY());
          Background2.setLocation (Background2.getX() - 5,Background2.getY());
  if (Background.getX() + 1390 < 0)
          {
             Background.setLocation (1390,0);
          }
           if (Background2.getX() + 1390 < 0)
          {
             Background2.setLocation (1390,0);
          }

          //Floor moving
           Floor[0].setLocation ( Floor[0].getX() - 5, Floor[0].getY());
           Floor[1].setLocation ( Floor[1].getX() - 5, Floor[1].getY());
           //When floor it off the screen, make it go again
             if (Floor[0].getX() + Floor[0].getWidth() < 0)
          {
            Floor[0].setLocation (1300,555);
          }
           if (Floor[1].getX() + Floor[1].getWidth() < 0)
          {
             Floor[1].setLocation (1300,555);
          }
          }
          //Shop Menu End -------
            //GAMESTART CODE (these are constantly being excecuted during gameplay) -----------------------
          if (GameStart == true)
          {
         //Moves the background for a moving effect
          if (UserLose == false)
          {
          Background.setLocation (Background.getX() - 5,Background.getY());
          Background2.setLocation (Background2.getX() - 5,Background2.getY());
          }
          //When background is off the screen, make it go again
          if (Background.getX() + 1390 < 0)
          {
             Background.setLocation (1390,0);
          }
           if (Background2.getX() + 1390 < 0)
          {
             Background2.setLocation (1390,0);
          }

          //When User gets hit
          if (UserInvincibility >= 1)
          {
               CheckHealth();
               //User gets invincibility for a short period of time
          UserInvincibility += 1;

          //Change Health hearts to dark hearts
      for (int i =  1; i < 21; i ++)
      {
        HealthHearts[i].setIcon (DarkHeartIcon);
      }

      //After a delay, end userInvincibilty
          if (UserInvincibility >= UserInvincibilityTime)
          {
              UserInvincibility = 0;
              //Reset the DarkHearts to Normal hearts
                  for (int i =  1; i < 21; i ++)
            {
        HealthHearts[i].setIcon (HeartIcon);
      }

          }

          }

          //If the user falls of the screen normally
          if (User.getY() > 775 )
          {
              //Instant lose
              UserLose = true;
              //Remove all hearts
            UserHealth = 0;
            CheckHealth();
      
          }
          //WHEN THE USER LOSES (either by fall off screen or lose all hearts)
          if (UserLose == true)
          {
                if (DeathDelay == 1)
                {
                    //Change to sound to death sound
                        //MusicClip.stop();
                         BackgroundMusic();
               try{
              StarCoreIn.close();
             
        }
    catch (Exception e)
            {

        }
                         //Before death, change equuation once more to avoid bugs
             int DecideEquation = 0;
             DecideEquation = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
             if (DecideEquation == 1)
                     {
                         SolveEquation.setText("Score: " + ScoreConverter1(Score));

                      }
               else if (DecideEquation == 2){

                 SolveEquation.setText("Score: " + ScoreConverter2(Score));
                      }
                else if (DecideEquation == 3){
                  SolveEquation.setText("Score: " + ScoreConverter3(Score));
                          }


            //Stops all legendary actions
                  MewtwoA1Act = 0;
                 MewtwoAct = 0;
                 MewtwoA2Act = 0;
                 MewtwoA3Act = 0;
                 MewtwoDelay = 0;

                 DeadDeoxys = false;
                 DeoxysHealth = 30;
                 DeoxysAct = 0;
                 DeoxysA1Act = 0;
                 DeoxysA2Act = 0;
                 DeoxysA3Act = 0;
                 DeoxysDelay = 0;

                    DeadArceus = false;
                     ArceusHealth = 35;
                    ArceusAct = 0;
                 ArceusA1Act = 0;
                 ArceusA2Act = 0;
                 ArceusA3Act = 0;
                    ArceusDelay = 0;
                }
                //Slowly fall down
              UserAcceleration = 2;
              //Delay to coninue
          DeathDelay += 1;
          //Stop enemy4 and 2 actions
          Enemy2Act = 0;
          Enemy4Act = 0;
          Enemy4BulletAct = false;
          //Remove all hearts
        UserHealth = 0;
        CheckHealth();

          //After a delay, jump for a Mario effect
          if (DeathDelay == 40)
          {
              UserVelocity = 50;

          }
          //Jump mario effect
           if (DeathDelay > 40 && DeathDelay <= 200)
          {
               User.setLocation (User.getX(), User.getY() - UserVelocity);
                  UserVelocity -= UserAcceleration;
           }
          //After Delay = 200, Restart everything and puill up the equation screen
          if (DeathDelay == 200)
          {
              //Restart death delay for a later time
              DeathDelay = 0;
           //Gamestart = false
              GameStart = false;
              //Solve screen = true
              Solve = true;
       
              ThinkingMusic();
            //Resteart Userlose for a later time
            UserLose = false;
              MenuDelay = 0;
              //Change SolveEquation into a larger state
                 SolveEquation.setSize (2000,100);
MusicTimer = 0;
        SolveEquation.setLocation (50,100);
            SolveEquation.setFont (new Font ("Serif", Font.BOLD, 60));

            //Set all calculator and solve screen variables to true
            txtAnswer.setText("");
            txtDisplay.setText("");
             HelpButton.setVisible(true);
              DisplayAnswer.setVisible(true);
              TipGuy.setVisible(true);
              TipGuyText.setVisible(true);
                btn0.setVisible(true);
                btn1.setVisible(true);
                btn2.setVisible(true);
                btn3.setVisible(true);
             btn4.setVisible(true);
             btn5.setVisible(true);
             btn6.setVisible(true);
             btn7.setVisible(true);
             btn8.setVisible(true);
                 btn9.setVisible(true);
             btnClear.setVisible(true);
             btnPlus.setVisible(true);
             btnMinus.setVisible(true);
             btnMultiply.setVisible(true);
              btnDivide.setVisible(true);
                  txtDisplay.setVisible(true);
                 txtAnswer.setVisible(true);
                 SolveBack.setVisible(true);
                 SolveEquation.setVisible(true);
                 JHighScore.setVisible(false);
                  SolveText.setVisible(true);
                 btnEnter.setVisible(true);
                 btnEquals.setVisible(true);

               RestartVar();

               //Change back to Pikachu if activated secret
                  UserWalk1 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk1.png")));
                      UserWalk2 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk2.png")));
              UserWalk3 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk3.png")));
            BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Lightning.png")));
        User.setIcon(UserWalk1);
           User.setSize(46,50);
            Bullet[0].setIcon(BulletIcon);

               //Restart Boss Variables
                 EventTimerBoss = 0;
        MewtwoHealth = 28;
        DeadMewtwo = false;
        MewtwoA1Act = 0;
        MewtwoAct = 0;
        MewtwoA2Act = 0;
        MewtwoA3Act = 0;
        MewtwoDelay = 0;

        DeadDeoxys = false;
        DeoxysHealth = 25;
        DeoxysAct = 0;
        DeoxysA1Act = 0;
        DeoxysA2Act = 0;
        DeoxysA3Act = 0;
        DeoxysDelay = 0;

        DeadArceus = false;
        ArceusHealth = 30;
           ArceusAct = 0;
       ArceusA1Act = 0;
        ArceusA2Act = 0;
        ArceusA3Act = 0;
        ArceusDelay = 0;

      
         //Mewtwo ICons
         Mewtwo.setSize (83,100);
         Mewtwo.setLocation (1390,-200);
             Mewtwo.setIcon(MewtwoIcon);


                  MewtwoOrb1.setSize (80,80);
         MewtwoOrb1.setLocation (1390,200);
             MewtwoOrb1.setIcon(MewtwoOrbIcon);


         MewtwoOrb2.setSize (80,80);
         MewtwoOrb2.setLocation (1390,200);
             MewtwoOrb2.setIcon(MewtwoOrbIcon);
               MewtwoOrb2.setSize (80,80);

         MewtwoOrb3.setLocation (1390,200);
             MewtwoOrb3.setIcon(MewtwoOrbIcon);
             MewtwoOrb3.setSize (80,80);

     

      //Deoxys Icons
      DeoxysShield.setSize (200,200);
         DeoxysShield.setLocation (1390,200);
             DeoxysShield.setIcon(DeoxysShieldIcon);


 Deoxys.setLocation (1390,-200);
                    Deoxys.setSize (84,100);

             Deoxys.setIcon(DeoxysIcon);


            DeoxysBeam1.setSize (107,80);
         DeoxysBeam1.setLocation (1390,200);
             DeoxysBeam1.setIcon(DeoxysBeam1Icon);


            DeoxysBeam2.setSize (0,80);
         DeoxysBeam2.setLocation (1390,200);

         //Arceus
          Arceus.setSize (100,100);
         Arceus.setLocation (1390,-200);
             Arceus.setIcon(ArceusIcon);


  ArceusLight1.setSize (80,80);
         ArceusLight1.setLocation (1390,200);
             ArceusLight1.setIcon(ArceusLBallIcon);


           ArceusLight2.setSize (200,200);
         ArceusLight2.setLocation (950,-200);
             ArceusLight2.setIcon(ArceusLBall2Icon);

           ArceusLight3.setSize (200,200);

         ArceusLight3.setLocation (400,-200);
             ArceusLight3.setIcon(ArceusLBall2Icon);


          ArceusHLight.setSize (400,1);
         ArceusHLight.setLocation (1390,0);
             ArceusHLight.setIcon(ArceusHLIcon);

          }
          }

          //USER MOVEMENT -------------------------------------------
          //Move right
          if (URIGHT == true && UserLose == false && User.getX() + 10 < 1250)
          {
           User.setLocation (User.getX() + UserSpeed, User.getY());

          }
          //Move left
            if (ULEFT == true && UserLose == false && User.getX() - 10 >  -20 )
          {
           User.setLocation (User.getX() - UserSpeed, User.getY());
          }
          //Bullet
          if (BulletActive == true && UserLose == false)
          {
          //Move the bullet across the screen
              Bullet[0].setLocation(Bullet[0].getX()+20,Bullet[0].getY());
              //If off the screen, refresh bullet
            if (Bullet[0].getX() >= 1450)
            {
                BulletActive = false;

                 Bullet[0].setVisible(false);
                 Bullet[0].setLocation(1400,0);
            }

              //Bullet To Enemy1 Collision
               if (DeadEnemy1 == false && Bullet[0].getX()+Bullet[0].getWidth() >= Enemy1.getX() && Bullet[0].getX() <= Enemy1.getX()+Enemy1.getWidth() && Bullet[0].getY() + Bullet[0].getHeight() >= Enemy1.getY() && Bullet[0].getY() <= Enemy1.getY() + Enemy1.getHeight())
                    {
                    //Bullet Sound effect
                   HitSoundEffect();
                   //Reset Bullet
                         BulletActive = false;
                         Bullet[0].setVisible(false);
                          Bullet[0].setLocation(1400,0);
                          //Remove Enemy
                         DeadEnemy1 = true;
                         Enemy1.setLocation(1400,0);
                       
                         //Increase score
                         Score += 75;
                    }
                //Bullet To Enemy2 Collision
               if (DeadEnemy2 == false && Bullet[0].getX()+Bullet[0].getWidth() >= Enemy2.getX() && Bullet[0].getX() <= Enemy2.getX()+Enemy2.getWidth() && Bullet[0].getY() + Bullet[0].getHeight() >= Enemy2.getY() && Bullet[0].getY() <= Enemy2.getY() + Enemy2.getHeight())
                    {
                    //Bullet Sound effect
                     HitSoundEffect();
                     //Reset Bullet
                         BulletActive = false;
                         Bullet[0].setVisible(false);
                          Bullet[0].setLocation(1400,0);
                           //Remove Enemy
                           Enemy2.setLocation (1400,0);
                         DeadEnemy2 = true;
                         Enemy2Act = 0;
                         Enemy2Delay = 0;
                          //Increase score
                         Score += 150;
                    }
               //Bullet To Enemy3 Collision
               if (DeadEnemy3 == false && Bullet[0].getX()+Bullet[0].getWidth() >= Enemy3.getX() && Bullet[0].getX() <= Enemy3.getX()+Enemy3.getWidth() && Bullet[0].getY() + Bullet[0].getHeight() >= Enemy3.getY() && Bullet[0].getY() <= Enemy3.getY() + Enemy3.getHeight())
                    {
                    //Bullet Sound effect
                     HitSoundEffect();
                   Enemy3Health -= 1;
                   //Reset Bullet
                         BulletActive = false;
                          Bullet[0].setVisible(false);
                           Bullet[0].setLocation(1400,0);
                            //Remove Enemy
                         if (Enemy3Health <= 0)
                         {
                           Enemy3.setLocation (1400,0);
                         DeadEnemy3 = true;
                      
                          //Increase score
                           Score += 150;
                        }
                    }
              //Bullet To Enemy 4 Collision
                  if (DeadEnemy4 == false && Bullet[0].getX()+Bullet[0].getWidth() >= Enemy4.getX() && Bullet[0].getX() <= Enemy4.getX()+Enemy3.getWidth() && Bullet[0].getY() + Bullet[0].getHeight() >= Enemy4.getY() && Bullet[0].getY() <= Enemy4.getY() + Enemy4.getHeight())
                    {
                      //Bullet Sound effect
               HitSoundEffect();
               //Reset Bullet
                         BulletActive = false;
                         Bullet[0].setVisible(false);
                          Bullet[0].setLocation(1400,0);
                     
                      Enemy4Delay = 0;
                      Enemy4Act = 0;
                      DeadEnemy4 = true;

                      Enemy4.setLocation (1400,100);
                       //Increase score
                      Score += 200;
                    }

                          //MEWTWO BULLET HIT
               if (DeadMewtwo == false && Bullet[0].getX()+Bullet[0].getWidth() >= Mewtwo.getX() && Bullet[0].getX() <= Mewtwo.getX()+Mewtwo.getWidth() && Bullet[0].getY() + Bullet[0].getHeight() >= Mewtwo.getY() && Bullet[0].getY() <= Mewtwo.getY() + Mewtwo.getHeight())
                    {
                   //Bullet Sound effect
                     HitSoundEffect();
                     //Damage and restart bullet
                   MewtwoHealth -= 1;
                         BulletActive = false;
                         Bullet[0].setVisible(false);
                          Bullet[0].setLocation(1400,0);
                          //If the bullet causes a kill
                         if (MewtwoHealth <= 0)
                         {
                             //Remove mewtwo

                               //Stops all legendary actions
                  MewtwoA1Act = 0;
                 MewtwoAct = 0;
                 MewtwoA2Act = 0;
                 MewtwoA3Act = 0;
                 MewtwoDelay = 0;
                 MewtwoOrb1.setLocation(1400,0);
                  MewtwoOrb2.setLocation(1400,0);
                    MewtwoOrb3.setLocation(1400,0);

                           Mewtwo.setLocation (1400,0);
                           
                  Mewtwo.setSize (83,100);
                 Mewtwo.setIcon(MewtwoIcon);
                         DeadMewtwo = true;
                         Mewtwo.setLocation(1400,0);

          

                   

                         //Increase score
                           Score += 5000;

                           //Get Another Boss 2 = Deoxys 3 = Arceus
                            RandomBoss = (int)Math.floor(Math.random() * (3 - 2 + 1) + 2);
                            if (RandomBoss == 2 && DeadDeoxys == false || DeadArceus == true && DeadDeoxys == false)
                            {
                                DeoxysAct = 1;
                                Deoxys.setLocation (1390,200);
                            }
                        else if (RandomBoss == 3 && DeadArceus == false || DeadDeoxys == true && DeadArceus == false)
                                     {
                                    ArceusAct = 1;
                                    Arceus.setLocation (1390,200);
                             }
                else //If all three bosses defeated
                            {
                                //Activate winning scene
                                GameStart = false;
                                Winning = true;
                                //Restart variables
                                 RestartVar();
                                 //No hearts
                                    for ( int i = 1; i < 21; i ++)
                          {
                            HealthHearts[i].setVisible(false);
                          }
                            //Set user off screen
                               User.setLocation(-50,User.getY());
                                WinningAct = 0;
                            //Bug fixes
                                     Spring[0].setLocation(1400,0);
                                 Floor[0].setLocation(0,555);
                                 Floor[0].setSize(1400,500);
                               
                          
                                   //Decide the final equation
                                 int DecideEquation = 0;
                                 DecideEquation = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
                                if (DecideEquation == 1)
          {  
               SolveEquation.setText("Score: " + ScoreConverter1(Score));

          }
   else if (DecideEquation == 2){

        SolveEquation.setText("Score: " + ScoreConverter2(Score));
            }
 else if (DecideEquation == 3){
      SolveEquation.setText("Score: " + ScoreConverter3(Score));
 }

                               }



                        }



                    }
                //DEOXYS BULLET HIT
                            if (DeadDeoxys == false && DeoxysA3Act != 3 && Bullet[0].getX()+Bullet[0].getWidth() >= Deoxys.getX() && Bullet[0].getX() <= Deoxys.getX()+Deoxys.getWidth() && Bullet[0].getY() + Bullet[0].getHeight() >= Deoxys.getY() && Bullet[0].getY() <= Deoxys.getY() + Deoxys.getHeight())
                    {
                                  //Bullet Sound effect
                                  HitSoundEffect();
                                  //Damage
                   DeoxysHealth -= 1;
                   //Remove bullet
                         BulletActive = false;
                         Bullet[0].setVisible(false);
                          Bullet[0].setLocation(1400,0);
                          //If damage results in death
                         if (DeoxysHealth <= 0)
                         {
                             //Remove deoxys
                           Deoxys.setLocation (1400,0);

                           //Restart Deoxys varaibles
                 Deoxys.setSize (84,100);
                 Deoxys.setIcon(DeoxysIcon);
                         DeadDeoxys = true;
                         DeoxysAct = 0;
                         DeoxysA1Act= 0;
                         DeoxysA2Act= 0;
                         DeoxysA3Act= 0;

                               DeoxysBeam2Length = 1;
         DeoxysBeam2.setLocation(1400,0);
         DeoxysBeam1.setLocation(1400,0);

           DeoxysDelay = 0;


                   //Increase score
                           Score += 5000;
                           //Decide next boss 1 = Mewtwo, 2 = Aceus
                            RandomBoss = (int)Math.floor(Math.random() * (2 - 1 + 1) + 1);
                            if (RandomBoss == 1 && DeadMewtwo == false || DeadArceus == true && DeadMewtwo == false)
                            {
                                MewtwoAct = 1;
                                Mewtwo.setLocation (1390,200);
                            }
                        else if (RandomBoss == 2 && DeadArceus == false || DeadMewtwo == true && DeadArceus == false)
                                     {
                                    ArceusAct = 1;
                                    Arceus.setLocation (1390,200);
                             }
                else //If all  3 bosses defeated
                            {
                                //Go to winning screen
                                       GameStart = false;
                                Winning = true;
                                //Restart Variables
                                 RestartVar();
                                 //Don't show hearts
                                  for ( int i = 1; i < 21; i ++)
                          {
                            HealthHearts[i].setVisible(false);
                          }
                                  WinningAct = 0;
                                  //Move user off screen
                                   User.setLocation(-50,User.getY());
                                   //Bug fixes
                                     Spring[0].setLocation(1400,0);
                                 Floor[0].setLocation(0,555);
                                 Floor[0].setSize(1400,500);
                                
                  
                                //Decide final Equations
                                 int DecideEquation = 0;
                                 DecideEquation = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
                                 DecideEquation = 3;
                            if (DecideEquation == 1)
                            {
                            SolveEquation.setText("Score: " + ScoreConverter1(Score));
                                   }
                            else if (DecideEquation == 2){
                                 SolveEquation.setText("Score: " + ScoreConverter2(Score));
                                      }
                            else if (DecideEquation == 3){

                             SolveEquation.setText("Score: " + ScoreConverter3(Score));
                                      }

                               }
                        }



                    }

              //ARCEUS BULLET HIT
               if (DeadArceus == false && ArceusA3Act != 4 && ArceusA3Act != 5 && Bullet[0].getX()+Bullet[0].getWidth() >= Arceus.getX() && Bullet[0].getX() <= Arceus.getX()+Arceus.getWidth() && Bullet[0].getY() + Bullet[0].getHeight() >= Arceus.getY() && Bullet[0].getY() <= Arceus.getY() + Arceus.getHeight())
                    {
                     //Bullet Sound effect
                     HitSoundEffect();
                     //Arceus Damage
                   ArceusHealth -= 1;
                   //Remove Bullet
                         BulletActive = false;
                         Bullet[0].setVisible(false);
                          Bullet[0].setLocation(1400,0);
                          //If hit results in death
                         if (ArceusHealth <= 0)
                         {
                             //Remove Arceus
                           Arceus.setLocation (1400,0);

                          Arceus.setSize (71,100);
                          Arceus.setIcon(ArceusIcon);
                         DeadArceus = true;
                         ArceusAct = 0;
                         ArceusA1Act= 0;
                        ArceusA2Act= 0;
                         ArceusA3Act= 0;
                         ArceusLight1.setLocation (1400,0);
                         ArceusLight2.setLocation (1400,0);
                         ArceusLight3.setLocation (1400,0);
                               ArceusA3HLSize = 1;

                          ArceusDelay = 0;

                        //Gain Score
                           Score += 5000;

                           //Spawn another boss - 1 = Mewtwo, 2 = Deoxys
                            RandomBoss = (int)Math.floor(Math.random() * (2 - 1 + 1) + 1);
                            if (RandomBoss == 1 && DeadMewtwo == false || DeadDeoxys == true && DeadMewtwo == false)
                            {
                                MewtwoAct = 1;
                                Mewtwo.setLocation (1390,200);
                            }
                        else if (RandomBoss == 2 && DeadDeoxys == false || DeadMewtwo == true && DeadDeoxys == false)
                                     {
                                    DeoxysAct = 1;
                                    Deoxys.setLocation (1390,200);
                             }
                else //If all 3 bosses defeated
                            {
                                //Go to winning Screen
                                       GameStart = false;
                                Winning = true;
                                //Restart variables
                                 RestartVar();
                                 //Hide hearts
                                    for ( int i = 1; i < 21; i ++)
                          {
                            HealthHearts[i].setVisible(false);
                          }
                                 WinningAct = 0;
                                 //Move user off screen
                                   User.setLocation(-50,User.getY());
                                   //Bug fixes
                                 Spring[0].setLocation(1400,0);
                                 Floor[0].setLocation(0,555);
                                 Floor[0].setSize(1400,500);
                                   
                        
                                //Decide Final Equation
                                int DecideEquation = 0;
                                 DecideEquation = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
                             if (DecideEquation == 1)
                                      {
                                       SolveEquation.setText("Score: " + ScoreConverter1(Score));
                                  }
                                    else if (DecideEquation == 2){
                                     SolveEquation.setText("Score: " + ScoreConverter2(Score));
                                          }
                                    else if (DecideEquation == 3){

                                       SolveEquation.setText("Score: " + ScoreConverter3(Score));
                                    }
                                

                               }

                        }
                    }
          }

         //FLOOR COLLISION When User walks off of the floor
          for (int i = 0; i < 6; i++)
          {
          if (User.getY() == 505 && UserJump == false && User.getX()+50 <= Floor[i].getX() || User.getY() == 505 && UserJump == false &&  User.getX() >= Floor[i].getX() + Floor[i].getWidth())
          {
              //Airborne
           UserVelocity = -5;
          UserJump = true;
          UserAirBorne = true;
          OnPlatform[i] = false;
             
          }
          }

          //USER JUMP - UP Button -----------------------------------------------------------
            if (UserJump == true && UserLose == false )
          {
               //Set Air borne to true
                UserAirBorne = true;
                //Grade 11 Physics
                  User.setLocation (User.getX(), User.getY() - UserVelocity);
                  UserVelocity -= UserAcceleration;
                  TempVelocity = UserVelocity;
                  //Floor COLLISION -----------------------
                         for (int i = 0; i < 6; i++)
                     {
                       OnPlatform[i] = false;
                   
                  if (User.getY() <= 600 && User.getY()+ 50 >= Floor[i].getY() && User.getX()+50 >= Floor[i].getX() && User.getX() < Floor[i].getX() + Floor[i].getWidth())
                  {
                      //Stop airborne and other things when colides with floor
                    UserAirBorne = false;
                    UserJump = false;
                    UserVelocity = 25;
                    UserDoubleJump = false;
                    UserDoubleJumpAble = false;

                   User.setLocation(User.getX(),Floor[i].getY()-50);
                  }
                  //Platform COLLISION -------------------------
                   if (User.getY()+50 - UserVelocity >= Platform[i].getY()&& User.getY() <= Platform[i].getY()+Platform[i].getHeight() && User.getX()+50 >= Platform[i].getX() && User.getX() <= Platform[i].getX()+ Platform[i].getWidth())
                    {
                       //Jump on top of platform
                       if ( User.getY()+50 - UserVelocity >= Platform[i].getY()&& User.getY()+50 <= Platform[i].getY()+(Platform[i].getHeight()/2))
                        {
                           //Stop Airborne and other things when colides with platform
                             UserJump = false;
                        
                           OnPlatform[i] = true;
                           User.setLocation(User.getX(),Platform[i].getY()-50);
                       UserAirBorne = false;
                  
                    UserVelocity = 25;
                    UserDoubleJump = false;
                    UserDoubleJumpAble = false;
                       }

                       //Hit on bottom of platform
                        if (User.getY() <= Platform[i].getY()+Platform[i].getWidth()&& User.getY() >= Platform[i].getY()+(Platform[i].getHeight()/2) && UserVelocity > 0)
                        {
                            //Reverse Velocity
                     UserVelocity = -UserVelocity;
                     User.setLocation (User.getX(),Platform[i].getY() + Platform[i].getHeight());
                        }

                    } 

    }
                      }
          //IF user WALKS OFF OF PLATFORM (not jump)
            for (int i = 0; i < 6; i++)
          {
            if (OnPlatform[i] == true &&  User.getY()+50 >= Platform[i].getY()&& User.getY()+50 <= Platform[i].getY()+(Platform[0].getHeight()/2) && User.getX()+50 <= Platform[i].getX() || OnPlatform[i] == true &&  User.getY()+50 >= Platform[i].getY()&& User.getY()+50 <= Platform[i].getY()+(Platform[i].getHeight()/2) && User.getX()+50 >= Platform[i].getX()+Platform[i].getWidth() )

                       {
                //Enable airborne
                  UserVelocity = -5;
                 UserJump = true;
                 UserDoubleJumpAble = true;
                 UserAirBorne = true;
                  OnPlatform[i] = false;
            }
          }
 
          //Spring COLLISION

           if ( User.getY()+50  >= Spring[0].getY()&& User.getY() <= Spring[0].getY()+Spring[0].getHeight() && User.getX()+50 >= Spring[0].getX()+10 && User.getX() <= Spring[0].getX()+ Spring[0].getWidth())
               {
               //Jump on spring!
               
        UserVelocity = 35;
          UserJump = true;
          UserAirBorne = true;
          OnPlatform[0] = false;
           UserDoubleJump = false;
           UserDoubleJumpAble = true;
               
           }
          //Normal ENEMYs ----------------------------------------------------
          //Enemy 1 - Charmander
          //Bullet Timer increase
         if (Enemy1BulletAct == false && DeadEnemy1 == false && UserLose == false)
         {
            Enemy1BulletTimer += 1;
               
          }
          //When BulletTimer is equal to 60, shoot the bullet
          if (Enemy1BulletTimer >= 60 && Enemy1.getX() <= 1500)
          {
              //Reset BulletTimer
            Enemy1BulletTimer = 0;
            //Activate Bullet
          Enemy1BulletAct = true;
          //Set bullet Location
             Enemy1Bullet.setLocation(Enemy1.getX(),Enemy1.getY()+15);

      
     


             //Add all of the icons
  
    
     


          }
       
          //User Collision with Enemy
          if (DeadEnemy1 == false && UserLose == false)
          {
               Enemy1.setLocation(Enemy1.getX()-BackSpeed,Enemy1.getY());

              //If collides with enemy normally
                     if( UserInvincibility == 0 && User.getX()+User.getWidth()-10 >= Enemy1.getX() && User.getX()+10 <= Enemy1.getX()+Enemy1.getWidth() && User.getY() + User.getHeight() >= Enemy1.getY()+ (Enemy1.getHeight() / 2) && User.getY() <= Enemy1.getY() + Enemy1.getHeight())
                    {
                     //Lose a life!
                       UserHealth -= 1;
                       if (UserHealth <= 0 )
                       {

                          CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }

                    }
                     //Or if jump on top of enemy
                else if (UserJump == true && User.getX() + User.getWidth() >= Enemy1.getX() && User.getX() <= Enemy1.getX() + Enemy1.getWidth() && User.getY() + User.getHeight() - UserVelocity >= Enemy1.getY() && User.getY() <= Enemy1.getY() + (Enemy1.getHeight() / 2))
                    {
                    JumpSoundEffect();
                    //Remove the enemy and get an extra jump
                 UserVelocity = 25;
                 UserDoubleJump = false;
                 UserDoubleJumpAble = true;

                         DeadEnemy1 = true;
                     Enemy1.setLocation (1400,0);
                         Score += 100;
                    }
   
          }
          //Enemy bullet movement
          if (Enemy1BulletAct == true && UserLose == false )
          {
              //Move bullet left
              Enemy1Bullet.setLocation (Enemy1Bullet.getX()- 5 - BackSpeed, Enemy1Bullet.getY());

              //If bullet is off the screen, reload
              if (Enemy1Bullet.getX() <= -100)
              {
                  Enemy1BulletTimer = 0;
                  Enemy1BulletAct = false;
                  Enemy1Bullet.setLocation (1400,0);
                

              }
              //If bullet hits the user
              if ( UserInvincibility == 0 && Enemy1Bullet.getX() <= User.getX()+User.getWidth() && User.getX() <=  Enemy1Bullet.getX()+Enemy1Bullet.getWidth() && Enemy1Bullet.getY() <= User.getY()+User.getHeight() && Enemy1Bullet.getY() +  Enemy1Bullet.getHeight() >= User.getY() )
              {
                  //reload
                   Enemy1BulletTimer = 0;
                  Enemy1BulletAct = false;
                
                  Enemy1Bullet.setLocation (-100,0);
                  //User Lose

                    UserHealth -= 1;
                     if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
                       
              }
          }
    
//Enemy 1 End-------------------
          //Enemy 2 (Beedrill) -------------------
          //Enemy Phase 1 - Get to Position
          if (Enemy2Act == 1 )
          {
          Enemy2.setLocation(Enemy2.getX()-3,350);
          if (Enemy2.getX() <= 1200)
              {
              Enemy2Act = 2;
          }


          }
          //Enemy Phase 2 - Delay
          if (Enemy2Act == 2 )
          {
              Enemy2Delay += 1;
            
               if (Enemy2Delay >= 75)
               {
                   Enemy2Act = 3;
             //Grade 11 Physics
                        Enemy2Velocity = 42;
                        Enemy2Acceleration = 1;
               }

          }
          //Enemy Phase 3 - Charge
          if (Enemy2Act == 3)
          {

              Enemy2.setLocation(Enemy2.getX() - Enemy2Velocity, Enemy2.getY() + 5);
              //Slowly lower until goes back
              Enemy2Velocity -= Enemy2Acceleration;
            //  User to Enemy2 attack Collision
               if (UserInvincibility == 0 && Enemy2.getX() + 10 <= User.getX()+User.getWidth() && User.getX() <=  Enemy2.getX()+Enemy2.getWidth() - 5  && Enemy2.getY() + 5 <= User.getY()+User.getHeight() && Enemy2.getY() +  Enemy2.getHeight() - 20 >= User.getY() )
              {
              //lose a life
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {
                          
                      UserInvincibility = 1;
                          }
              }

              //After it is going left again, restart variables and go off of screen
              if (Enemy2.getX() >= 1000 && Enemy2Velocity < 0)
              {
                  Enemy2Act = 0;
                    DeadEnemy2 = true;
                    Enemy2.setLocation (1400,0);
                  
                         Enemy2Delay = 0;
              }
          }

          //Enemy 2 END----------
          //Enemy 3 Code ------------ GOLEM
          if (DeadEnemy3 == false && UserLose == false)
          {
              //Move along with background
              Enemy3.setLocation (Enemy3.getX() - BackSpeed, 475);

               //If collides with User
                     if( UserInvincibility == 0 && User.getX()+User.getWidth()-10 >= Enemy3.getX() && User.getX()+10 <= Enemy3.getX()+Enemy3.getWidth() && User.getY() + User.getHeight() >= Enemy3.getY()+ (Enemy3.getHeight() / 2) && User.getY() <= Enemy3.getY() + Enemy3.getHeight())
                    {
                    //Lose a life
                       UserHealth -= 1;
                       if (UserHealth <= 0 )
                       {

                          CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }

                    }
                     //Or if jump on top of enemy
                else if (UserJump == true && User.getX() + User.getWidth() >= Enemy3.getX() && User.getX() <= Enemy3.getX() + Enemy3.getWidth() && User.getY() + User.getHeight() - UserVelocity >= Enemy3.getY() && User.getY() <= Enemy3.getY() + (Enemy3.getHeight() / 2))
                    {
                    JumpSoundEffect();
                    //Remove the enemy and get an extra jump
                 UserVelocity = 25;
                 UserDoubleJump = false;
                 UserDoubleJumpAble = true;
                         DeadEnemy3 = true;
                         Enemy3Health = 0;
                         Enemy3.setLocation (1400,0);
                         //Increase score
                         Score += 200;


                    }

          }

          //ENEMY 3 END-----------
          //ENEMY 4 CODE (Pidgeotto-------------------------------

          //Phase 1 - Get to position
 if (Enemy4Act == 1 )
          {
          Enemy4.setLocation(Enemy4.getX()-3,100);
          if (Enemy4.getX() <= 1200)
              {
              Enemy4Act = 2;
          }


          }
          //Phase 2 - Delay and shoot whirlwind
          if (Enemy4Act == 2 && DeadEnemy4 == false)
          {
              Enemy4Delay += 1;

               if (Enemy4Delay >= 75 && DeadEnemy4 == false)
               {
                   Enemy4Act = 3;
                   Enemy4Bullet.setLocation(Enemy4.getX()-50, Enemy4.getY() + (Enemy4.getHeight() / 2) - 20);
                   Enemy4BulletAct = true;
                   Enemy4Delay = 0;


                    
               }
            
          }
          //Phase 3 - Charge!
           if (Enemy4Act == 3 )
          {
               if (Enemy4Delay < 80)
               {
               Enemy4Delay += 1;
              }
               if (Enemy4Delay >= 80)
               {
                   Enemy4.setLocation (Enemy4.getX()-20 - BackSpeed, Enemy4.getY());

                      if (UserInvincibility == 0 && Enemy4.getX() + 10 <= User.getX()+User.getWidth() && User.getX() <=  Enemy4.getX()+Enemy4.getWidth() - 5  && Enemy4.getY() + 5 <= User.getY()+User.getHeight() && Enemy4.getY() +  Enemy4.getHeight() - 20 >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }

//Restart Enemy variables if off of the screen
                   if( Enemy4.getX() <= -200)
                  {
                   
                      Enemy4Delay = 0;
                      Enemy4Act = 0;
                      DeadEnemy4 = true;

                      Enemy4.setLocation (1400,100);

                      
                  }
               }
           }

          //Bullet move - if Whirlwind is active
            if (Enemy4BulletAct == true)
              {
                //Move WhirlWind left
                  Enemy4Bullet.setLocation ( Enemy4Bullet.getX()- 10 - BackSpeed, Enemy4Bullet.getY());
                    //If WhirlWind hits User
                      if (UserInvincibility == 0 && Enemy4Bullet.getX() <= User.getX()+User.getWidth() && User.getX() <=  Enemy4Bullet.getX()+Enemy4Bullet.getWidth()  && Enemy4Bullet.getY() + 5 <= User.getY()+User.getHeight() && Enemy4Bullet.getY() +  Enemy4Bullet.getHeight() >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }

              //Restart bullet if off of the screen
                  if( Enemy4Bullet.getX() <= -200)
                  {
                      //Restart whirlwind
                  
                      Enemy4BulletAct = false;
                      Enemy4Bullet.setLocation (1400,100);

                  }

              }

          //Enemy 4 EnD---
          //BOSS BATTLES -----------------------------------------------------------------------------------------------------------
          //MEWTWO BOSS ------------------------------------------------------------------------
          //If you touch the boss, you lose a life
           if (DeadMewtwo == false && UserInvincibility == 0 && Mewtwo.getX() <= User.getX()+User.getWidth() && User.getX() <=  Mewtwo.getX()+Mewtwo.getWidth() - 5  && Mewtwo.getY() + 5 <= User.getY()+User.getHeight() && Mewtwo.getY() +  Mewtwo.getHeight() - 20 >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }

          //Get Mewtwo into position
           if (MewtwoAct == 1 &&DeadMewtwo == false)
          {
           if (Mewtwo.getX() < 1150)
          {
              MewtwoAct = 2;
            
          }
            else{
          Mewtwo.setLocation(Mewtwo.getX()-5,200);
              }
         
          }
          //Add a delay before the attack is selected
          if (MewtwoAct == 2)
          {
              MewtwoDelay += 1;
              if (MewtwoDelay == 75 && DeadMewtwo == false)
              {
                   MewtwoDelay = 0;
                  MewtwoAct = 0;
                  //DECIDE ATTACK
                  MewtwoAttack = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
                
                  if (MewtwoAttack == 1)
                  {
                 MewtwoA1Act = 1;
                  }
                   else if (MewtwoAttack == 2)
                  {
                  MewtwoA2Act = 1;
                  }
                   else if (MewtwoAttack == 3)
                  {
                  MewtwoA3Act = 1;
                  }
              }
          }
          //MEWTWO ATTACK 1 - TRIPLE SHADOW BALL ------------------
          if (MewtwoA1Act == 1 && DeadMewtwo == false)
          {
              //Phase 1:
             //Initialize all variables to make sure they're in the right position
              MewtwoOrb1.setLocation (Mewtwo.getX() - 80, Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40);
                MewtwoOrb2.setLocation (Mewtwo.getX() - 80, Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40);
                MewtwoOrb3.setLocation (1400, Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40);
           MO1Acceleration = 1;
           MO2Acceleration = -1;
           MO1Velocity = -22;
           MO2Velocity = 22;
           MewtwoDelay = 0;
             Mewtwo.setSize (87,100);
             Mewtwo.setIcon (MewtwoA1Icon);
            
             MewtwoOrb3.setIcon(MewtwoOrbIcon);
             MewtwoOrb3.setSize (80,80);
            
                MewtwoA1Act = 2;
                //PLay sound effect
                MewtwoA1Effect();
                
          }
          //Phase 2: Dual Orbs - Only horizontally
          if (MewtwoA1Act == 2 )
          {
                 MewtwoOrb1.setLocation (MewtwoOrb1.getX() - 1 - BackSpeed, MewtwoOrb1.getY()  );
                   MewtwoOrb2.setLocation (MewtwoOrb2.getX() - 1 - BackSpeed, MewtwoOrb2.getY());

                   if (MewtwoOrb1.getX() <= 1000)
                   {
                       MewtwoA1Act = 3;
                   }

          
          }
          // Phase 3: Duel Orbs - with Funky movement
          if (MewtwoA1Act == 3)
          {
          //Physics
             MO1Velocity += MO1Acceleration;
               MO2Velocity += MO2Acceleration;

               if (MO1Acceleration == 1 && MewtwoOrb1.getY() > Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40)
                {
               MO1Acceleration = -1;
               }
         else if ( MO1Acceleration == -1 && MewtwoOrb1.getY() < Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40)
              {
            MO1Acceleration = 1;
                }
                 if (MO2Acceleration == 1 && MewtwoOrb2.getY() > Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40)
                {
               MO2Acceleration = -1;
               }
         else if ( MO2Acceleration == -1 && MewtwoOrb2.getY() < Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40)
              {
            MO2Acceleration = 1;
                }

               //Move the orbs
          MewtwoOrb1.setLocation (MewtwoOrb1.getX() - 3 - BackSpeed, MewtwoOrb1.getY() + MO1Velocity  );
           MewtwoOrb2.setLocation (MewtwoOrb2.getX() - 3 - BackSpeed, MewtwoOrb2.getY() + MO2Velocity  );

           //After a delay shoot third orb
              if (MewtwoDelay <= 50)
              {
                  MewtwoDelay += 1;
              }
               if (MewtwoDelay == 50)
               {
                 MewtwoOrb3.setLocation (Mewtwo.getX() - 80, Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40);
               }
              if (MewtwoOrb3.getX() <= Mewtwo.getX() - 80)
              {
                  MewtwoOrb3.setLocation (MewtwoOrb3.getX() - 15 - BackSpeed, Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 40 );
              }

           //Orb1 to User collision
              if (UserInvincibility == 0 && MewtwoOrb1.getX() <= User.getX()+User.getWidth() && User.getX() <=  MewtwoOrb1.getX()+MewtwoOrb1.getWidth() - 5  && MewtwoOrb1.getY() + 5 <= User.getY()+User.getHeight() && MewtwoOrb1.getY() +  MewtwoOrb1.getHeight() - 20 >= User.getY() )
              {
                  //Lose a life
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
            //Orb2 to User collision
                if (UserInvincibility == 0 && MewtwoOrb2.getX() <= User.getX()+User.getWidth() && User.getX() <=  MewtwoOrb2.getX()+MewtwoOrb2.getWidth() - 5  && MewtwoOrb2.getY() + 5 <= User.getY()+User.getHeight() && MewtwoOrb2.getY() +  MewtwoOrb2.getHeight() - 20 >= User.getY() )
              {
                    //Lose a life
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
           //Orb3 to User collision
            if (UserInvincibility == 0 && MewtwoOrb3.getX() <= User.getX()+User.getWidth() && User.getX() <=  MewtwoOrb3.getX()+MewtwoOrb3.getWidth() - 5  && MewtwoOrb3.getY() + 5 <= User.getY()+User.getHeight() && MewtwoOrb3.getY() +  MewtwoOrb3.getHeight() - 20 >= User.getY() )
              {
                //Lose a life
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
              //Restart orbs after they are off the screen
           if (MewtwoOrb3.getX() <= -300 && MewtwoOrb2.getX() <= -200 && MewtwoOrb1.getX() <= -200)
           {
               //Restart variables
               MewtwoDelay = 0;
               MewtwoA1Act = 0;
              //Restart movement
               MewtwoAct = 1;
                 Mewtwo.setSize (83,100);
                 Mewtwo.setIcon(MewtwoIcon);
                MewtwoA1Clip.stop();



           }

          }

          //MEWTWO ATTACK 2 - EXTREME SPEED --------------------------------
          //Phase 1: Move Mewtwo right off of screen
            if (MewtwoA2Act == 1)
              {
                Mewtwo.setLocation(Mewtwo.getX()+ 15, Mewtwo.getY());
                //After off the screen advance
                if (Mewtwo.getX() >= 1450)
                {
                    //Inintialize variables
                    MewtwoA2Act = 2;
                    Mewtwo.setLocation (User.getX()-75, 800);
                    MewtwoA2Velocity = 55;
                    MewtwoA2Acceleration = 2;
                    Mewtwo.setSize (113,100);
                 Mewtwo.setIcon(MewtwoA2Icon);
                 //Play sound effect
              MewtwoA2Effect();
                }
            }
          //Phase 2: Mewtwo Jumps up!
          if (MewtwoA2Act == 2)
          {
              //Physics
              MewtwoA2Velocity -= MewtwoA2Acceleration;

          Mewtwo.setLocation (Mewtwo.getX()+5,Mewtwo.getY() - MewtwoA2Velocity);
          //After a while, start to slow down
          if (MewtwoA2Velocity <= 20)
          {
              MewtwoA2Acceleration = 1;
          }
          if (MewtwoA2Velocity <= 0)
          {
              MewtwoA2Acceleration = 5;
          }
          //When Mewtwo is off the screen, restart
          if (Mewtwo.getY() >= 790 && MewtwoA2Velocity <= 0)
          {
              //Restart
              MewtwoAct = 1;
              MewtwoA2Act = 0;
              MewtwoDelay = 0;
                  MewtwoA2Clip.stop();


            if (DeadMewtwo == false)
            {
                Mewtwo.setLocation(1390,200);

              }
                 Mewtwo.setSize (83,100);
                 Mewtwo.setIcon(MewtwoIcon);
          }
      

          }
              ///MEWTWO ATTACK 3 - MEGA SHADOW BALL ----------------------------------------------------
          //Phase 1: Slowly move into position
          if (MewtwoA3Act == 1)
          {
              //Move left
              Mewtwo.setLocation ( Mewtwo.getX() -15, Mewtwo.getY());
              //If in right position, advance
              if (Mewtwo.getX() <= 800)
              {
                  if (DeadMewtwo == false)
                  {
                  MewtwoA3Act = 2;
                  }

                  MewtwoDelay = 0;
                  Mewtwo.setIcon (MewtwoA3Icon);
                  Mewtwo.setSize (113,100);

                     MewtwoOrb3.setSize(200,200);
                     MewtwoOrb3.setIcon (MewtwoGOrbIcon);
              }
              
          }

          //PHase 2: Delay
          if (MewtwoA3Act == 2 && DeadMewtwo == false)
          {
              MewtwoDelay += 1;
              if (MewtwoDelay >= 60 && DeadMewtwo == false)
              {
                  MewtwoA3Act = 3;
                  //Play sound effect
                  MewtwoA3Effect();
              }

          }
          //Phase 3: Move back!
           if (MewtwoA3Act ==  3 && DeadMewtwo == false)
          {
               //Mewtwo moves back
               Mewtwo.setLocation (Mewtwo.getX() + 50,Mewtwo.getY());
               if (Mewtwo.getX() >= 750)
               {
                   MewtwoA3Act = 4;
                     MewtwoOrb3.setLocation (Mewtwo.getX() - 200, Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 100);
               }
          }
          //Phase 4: Shoot the shadow ball that destroys everything
          if (MewtwoA3Act == 4)
          {
              //Move back
                 Mewtwo.setLocation (Mewtwo.getX() + 50,Mewtwo.getY());
                 //Shadow ball moves forward
                 MewtwoOrb3.setLocation (MewtwoOrb3.getX()- 40 - BackSpeed, Mewtwo.getY() + (Mewtwo.getHeight() / 2) - 100);
                 if (MewtwoOrb3.getX() <= -500)
                 {
                     //Restart variables
                     MewtwoDelay = 0;
                     MewtwoA3Act = 0;
                     MewtwoAct = 1;
                       Mewtwo.setLocation(1390,200);
                        Mewtwo.setSize (83,100);
                 Mewtwo.setIcon(MewtwoIcon);
                  //MewtwoA3Clip.stop();
                     
                 }

          }
          //Collision with User
          if (MewtwoA3Act == 3 || MewtwoA3Act == 4)
          {
              //If the orb collides with use, do damage
               if (UserInvincibility == 0 && MewtwoOrb3.getX() <= User.getX()+User.getWidth() && User.getX() <=  MewtwoOrb3.getX()+MewtwoOrb3.getWidth() && MewtwoOrb3.getY() + 5 <= User.getY()+User.getHeight() && MewtwoOrb3.getY() +  MewtwoOrb3.getHeight() - 20 >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }

          }
         //DEOXYS BOSS ----------------------------------------------------------------------------------------------------------------------------

          //If touch Deoxys, Lose a life
 if (DeadDeoxys == false && UserInvincibility == 0 && Deoxys.getX() <= User.getX()+User.getWidth() && User.getX() <=  Deoxys.getX()+Deoxys.getWidth() - 5  && Deoxys.getY() + 5 <= User.getY()+User.getHeight() && Deoxys.getY() +  Deoxys.getHeight() - 20 >= User.getY() )
              {
     //Lose a life
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
//Get into position
 if (DeoxysAct == 1)
          {
           if (Deoxys.getX() < 1150)
          {
              DeoxysAct = 2;
              Deoxys.setSize (84,100);
             Deoxys.setIcon(DeoxysIcon);
          }
 else
           {

          Deoxys.setLocation(Deoxys.getX()-3,200);
              }

          }
          //Delay before decide move
          if (DeoxysAct == 2)
          {
             DeoxysDelay += 1;
              if (DeoxysDelay == 100 && DeadDeoxys == false)
              {
                   DeoxysDelay = 0;
                  DeoxysAct = 0;
                  //DECIDE ATTACK
                 DeoxysAttack = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
          //  DeoxysAttack = 1;
                  if (DeoxysAttack == 1)
                  {
                 DeoxysA1Act = 1;
                 Deoxys.setSize (70,100);
             Deoxys.setIcon(ADeoxysIcon);
                  }
                   else if (DeoxysAttack == 2)
                  {
                  DeoxysA2Act = 1;
                  Deoxys.setSize (100,98);
             Deoxys.setIcon(SDeoxysIcon);
                  }
                   else if (DeoxysAttack == 3)
                  {
                  DeoxysA3Act = 1;
                  Deoxys.setSize (78,100);
             Deoxys.setIcon(DDeoxysIcon);
                  }


              }
          }
          //DEOXYS A1 ATTACK - HYPER BEAM ------------------------------
          //Phase 1: Delay
            if (DeoxysA1Act== 1)
            {
  DeoxysDelay += 1;
   if (DeoxysDelay == 50 && DeadDeoxys == false)
              {
//Initialize variables
        DeoxysDelay = 0;
                 DeoxysA1Act = 2;
                DeoxysBeam1.setLocation (Deoxys.getX() - 80, Deoxys.getY() + (Deoxys.getHeight() / 2) - 40);
                DeoxysBeam2.setLocation (DeoxysBeam1.getX(), Deoxys.getY() + (Deoxys.getHeight() / 2) - 40);
                 DeoxysBeam2Length= 1;
                   DeoxysBeam2.setSize (0,80);
                   DeoxysA1Effect();

   }
            }
          //Phase 2: Shoot laser
if (DeoxysA1Act== 2)
            {
    //Increase laser length
    DeoxysBeam2Length+= 30;
    DeoxysBeam2.setLocation(DeoxysBeam2.getX()-30,DeoxysBeam2.getY());
    DeoxysBeam2.setSize(DeoxysBeam2Length,80);
  
   //Constantly resize beam
 BeamIcon = new ImageIcon (ScaledImage( BeamImage, DeoxysBeam2Length,80));
             DeoxysBeam2.setIcon(BeamIcon);

             //After a while, end laser
if  (DeoxysBeam2.getX() <= -750)
{
    //advance
    DeoxysA1Act = 3;
    DeoxysBeam1.setLocation(1400,0);
    
}

}
          //Phase 3: End Laser
          if (DeoxysA1Act == 3)
            {
              //Laser moves left
                DeoxysBeam2.setLocation(DeoxysBeam2.getX()-30,DeoxysBeam2.getY());

                //Restart variables when laser is off the screen
                   if  (DeoxysBeam2.getX()+DeoxysBeam2.getWidth() <= -500)
            {
         DeoxysBeam2Length = 1;
         DeoxysBeam2.setLocation(1400,0);
         DeoxysBeam1.setLocation(1400,0);
         DeoxysA1Act = 0;
         DeoxysAct = 1;
            Deoxys.setSize (84,100);
             Deoxys.setIcon(DeoxysIcon);
              DeoxysA1Clip.stop();


                    }
          }
          //Laser to User Collision
          if (DeoxysA1Act == 2 || DeoxysA1Act == 3)
          {
                if (UserInvincibility == 0 && DeoxysBeam1.getX() <= User.getX()+User.getWidth() && User.getX() <=  DeoxysBeam1.getX()+DeoxysBeam1.getWidth()  && DeoxysBeam1.getY()  <= User.getY()+User.getHeight() && DeoxysBeam1.getY() +  DeoxysBeam1.getHeight()  >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
                 if (UserInvincibility == 0 && DeoxysBeam2.getX() <= User.getX()+User.getWidth() && User.getX() <=  DeoxysBeam2.getX()+DeoxysBeam2.getWidth()  && DeoxysBeam1.getY()  <= User.getY()+User.getHeight() && DeoxysBeam2.getY() +  DeoxysBeam2.getHeight()  >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
          }

          //DEOXYS ATTACK 2 - SPEED FORM, EXTREME SPEED -----------------------
          //Phase 1: Delay
          if (DeoxysA2Act == 1)
          {

                DeoxysDelay += 1;
   if (DeoxysDelay == 50 && DeadDeoxys == false)
              {
       DeoxysDelay = 0;
       DeoxysA2Act = 2;
       DeoxysA2Velocity = 20;
       DeoxysA2Acceleration = -1;
       //Sound effect
      MewtwoA2Effect();

            }

          }
          //Phase 2: Move left
           if (DeoxysA2Act == 2)
          {
               DeoxysA2Velocity += DeoxysA2Acceleration;
               
               Deoxys.setLocation (Deoxys.getX()-30,Deoxys.getY() + DeoxysA2Velocity);
               if (Deoxys.getX() <= 20)
               {
                   DeoxysA2Act = 3;
                       Deoxys.setSize (100,98);
             Deoxys.setIcon(SDeoxys2Icon);
                    DeoxysA2Velocity = 20;
                     DeoxysA2Acceleration = -1;
               }
           }
          //Phase 3: Move right
           if (DeoxysA2Act == 3)
          {
                DeoxysA2Velocity += DeoxysA2Acceleration;

               Deoxys.setLocation (Deoxys.getX()+30,Deoxys.getY() + DeoxysA2Velocity);
               //After Deoxys is back in starting position, restart variables
               if  (Deoxys.getX() >= 1150)
                 {
                   DeoxysA2Act = 4;
                    DeoxysAct = 1;
                    DeoxysDelay = 0;
                      Deoxys.setSize (84,100);
             Deoxys.setIcon(DeoxysIcon);
                MewtwoA2Clip.stop();

               }
           }
          //Phase 4: Makes sure the Y value is correct
             if (DeoxysA2Act == 4)
          {
                 if (Deoxys.getY() > 200)
                 {
                     Deoxys.setLocation (Deoxys.getX(),Deoxys.getY() - 2);
                 }
 else
                 {
                     DeoxysA2Act = 0;
                }
             }

          //DEOXYS ATTACK 3 - PROTECT

          //Phase 1: Delay
          if (DeoxysA3Act == 1)
          {
              DeoxysDelay += 1;
                if (DeoxysDelay == 50 && DeadDeoxys == false)
              {
          DeoxysDelay = 0;
          DeoxysA3Act = 2;
          ReflectedBullet = false;
          //Sound effect
          DeoxysA3Effect();
              }
          }
          //Phase 2: Initialize Bubble
          if (DeoxysA3Act == 2)
          {
              DeoxysShield.setLocation ( (Deoxys.getX() + (Deoxys.getWidth()/2)) - 100, (Deoxys.getY() + (Deoxys.getHeight()/2)) - 100);
              DeoxysA3Act = 3;

          }
          //Phase 3: Bubble PROTECTION!
           if (DeoxysA3Act == 3)
          {
               //Delay to determine end
               DeoxysDelay += 1;
               //Reflect Bullet if hit shield
                 if ( Bullet[0].getX()+Bullet[0].getWidth() >= DeoxysShield.getX() && Bullet[0].getX() <= DeoxysShield.getX()+DeoxysShield.getWidth() && Bullet[0].getY() + Bullet[0].getHeight() >= DeoxysShield.getY() && Bullet[0].getY() <= DeoxysShield.getY() + DeoxysShield.getHeight())
                    {
                         ReflectedBullet = true;
                    }
               //After a delay,
                      if (DeoxysDelay >= 200)
                      {
                          //Restart all variables
                          DeoxysA3Act = 0;
                          DeoxysDelay = 0 ;
                          DeoxysAct = 1;
                          DeoxysShield.setLocation(1400,0);
                            Deoxys.setSize (84,100);
             Deoxys.setIcon(DeoxysIcon);

              DeoxysA3Clip.stop();
                          
                      }


           }
          //WHEN the bullet is reflected
          if (ReflectedBullet == true)
          {
              //Move LEFT as opposed to RIGHT
               Bullet[0].setLocation(Bullet[0].getX()-40-BackSpeed,Bullet[0].getY());
               //Restart if off of the screen
                 if (Bullet[0].getX() <= -200)
            {
                BulletActive = false;
                Bullet[0].setVisible(false);
                 Bullet[0].setLocation(1400,0);
                 ReflectedBullet = false;
            }
               //User gets hit by own bullet....
               if (UserInvincibility == 0 && Bullet[0].getX() <= User.getX()+User.getWidth() && User.getX() <=  Bullet[0].getX()+Bullet[0].getWidth()   && Bullet[0].getY() <= User.getY()+User.getHeight() && Bullet[0].getY() +  Bullet[0].getHeight() >= User.getY() )
              {
                   HitSoundEffect();

                    BulletActive = false;
                     Bullet[0].setVisible(false);
                      Bullet[0].setLocation(1400,0);
                      ReflectedBullet = false;
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
          }

          //ARCEUS BOSS -----------------------------------------------------------------------------------------------------------------------------

          //If touch Arceus, lose a life
                if (DeadArceus == false && UserInvincibility == 0 && Arceus.getX() <= User.getX()+User.getWidth() && User.getX() <=  Arceus.getX()+Arceus.getWidth()  && Arceus.getY()  <= User.getY()+User.getHeight() && Arceus.getY() +  Arceus.getHeight() >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
              //Get into position
           if (ArceusAct == 1)
          {
           if (Arceus.getX() < 1150)
          {
              ArceusAct = 2;
          }
 else
           {

          Arceus.setLocation(Arceus.getX()-3,200);
              }

          }
          //Delay before decide attack
          if (ArceusAct == 2)
          {
             ArceusDelay += 1;
              if (ArceusDelay == 100 && DeadArceus == false)
              {
                   ArceusDelay = 0;
                  ArceusAct = 0;
                  //DECIDE ATTACK
                 ArceusAttack = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
         
                  if (ArceusAttack == 1)
                  {
                ArceusA1Act = 1;
                  }
                   else if (ArceusAttack == 2)
                  {
                  ArceusA2Act = 1;
                Arceus.setSize (71,107);
           Arceus.setIcon(ArceusA2Icon);
                  }
                   else if (ArceusAttack == 3)
                  {
                  ArceusA3Act = 1;
                  }
              }
          }
          //ARCEUS ATTACK 1 - Spinning Punishment -----------------------------------------
          if (ArceusA1Act == 1)
          {
              //Initialize variables
              ArceusA1Act = 2;
              ArceusA1Effect();
          ArceusLight1.setLocation (Arceus.getX() - 80, (Arceus.getY() + (Arceus.getHeight()/2)) - 40);
          ArceusA1VelocityX = 30;
              ArceusA1AccelerationX = -2;
                ArceusA1VelocityY = 0;
              ArceusA1AccelerationY = 2;
          }

//Phase 2: Shoot the light
            if (ArceusA1Act == 2)
          {
                 ArceusLight1.setLocation (ArceusLight1.getX() - 20, ArceusLight1.getY());
               
                 if (ArceusLight1.getX() <= 600)
                 {
                     ArceusA1Act = 3;
                     ArceusA2Effect();
                      
                 }
            }
          //Phase 3: Light moves up
          if (ArceusA1Act == 3)
          {
              ArceusA1VelocityX += ArceusA1AccelerationX;
              ArceusA1VelocityY += ArceusA1AccelerationY;

              ArceusLight1.setLocation (ArceusLight1.getX() - ArceusA1VelocityX, ArceusLight1.getY()- ArceusA1VelocityY);
 
 if (ArceusLight1.getY() <= 50 )
 {
     ArceusA1Act = 4;
      ArceusA1AccelerationX = -1;
 }
          }
          //Phase 4: Light move back down while moving right
 if (ArceusA1Act == 4)
          {
    
         ArceusA1VelocityX += ArceusA1AccelerationX;
          ArceusA1VelocityY -= ArceusA1AccelerationY;
          ArceusLight1.setLocation (ArceusLight1.getX() - ArceusA1VelocityX , ArceusLight1.getY()- ArceusA1VelocityY);
          if (ArceusLight1.getY()+ (ArceusLight1.getHeight()/2) >= 250)
          {
              ArceusA1Act = 5;
              ArceusA1AccelerationY = 2;
          }
 }
          //Phase 5: Light moves left while going down
           if (ArceusA1Act == 5)
          {
             
               ArceusA1VelocityX -= ArceusA1AccelerationX;
                ArceusA1VelocityY += ArceusA1AccelerationY;
                 ArceusLight1.setLocation (ArceusLight1.getX()-ArceusA1VelocityX , ArceusLight1.getY());
                   if (Arceus.getX() <= 1250)
                 {
                     Arceus.setLocation (Arceus.getX() - ArceusA1VelocityX, Arceus.getY());
                 }
        else           {
                     ArceusA1Act = 6;
                     }
                

           }
//Phase 6 Light Only moves left to fire!
             if (ArceusA1Act == 6)
          {
                 ArceusA1VelocityX -= ArceusA1AccelerationX;
                      ArceusA1VelocityY += ArceusA1AccelerationY;
                 ArceusLight1.setLocation (ArceusLight1.getX()-ArceusA1VelocityX , ArceusLight1.getY());
                 if (ArceusLight1.getX() + ArceusLight1.getWidth() < Arceus.getX() && ArceusA1VelocityX > 0 )
                 {
                        ArceusLight1.setLocation (ArceusLight1.getX()-30 - BackSpeed , ArceusLight1.getY());
                 }
                  if (Arceus.getX() > 1150 && ArceusA1VelocityX > 0 )
          {
                     Arceus.setLocation (Arceus.getX()-ArceusA1VelocityX , Arceus.getY());

                 }
           //After it is off the screen, Restart variables
                 if (ArceusLight1.getX() <= -4000)
                 {
                     ArceusLight1.setLocation (1400,0);
                     ArceusA1Act = 0;
                     ArceusAct = 1;
                         ArceusA1Clip.stop();


                 }
             }
          //User Collision with Light
          if (ArceusA1Act == 2 || ArceusA1Act == 3|| ArceusA1Act == 4|| ArceusA1Act == 5|| ArceusA1Act == 6)
          {
               if (DeadArceus == false && UserInvincibility == 0 && ArceusLight1.getX() <= User.getX()+User.getWidth() && User.getX() <=  ArceusLight1.getX()+ArceusLight1.getWidth() - 5  && ArceusLight1.getY() + 5 <= User.getY()+User.getHeight() && ArceusLight1.getY() +  ArceusLight1.getHeight() - 20 >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
          }

          //ARCEUS ATTACK 2 - COSMIC POWER ---------------
          if (ArceusA2Act == 1)

          {
              //Initialize Variables
                  ArceusLight2.setLocation (950,-200);
         ArceusLight3.setLocation (400,-200);
         ArceusA2Act = 2;
         ArceusDelay = 0;
          }
          //Phase 2: Delay
          if (ArceusA2Act == 2)
          {
              ArceusDelay += 1;
          if (ArceusDelay >= 75)
          {
              ArceusA2Act = 3;
              //Play sound effect
              ArceusA2Effect();
          }
         
          }
          //Phase 3: Shoot Light1
           if (ArceusA2Act == 3)
          {
              ArceusLight2.setLocation (ArceusLight2.getX()-10,ArceusLight2.getY() + 20);
              //After it is a certain height
              if (ArceusLight2.getY() >= 800)
              {
                  ArceusA2Act = 4;
                  //Play sound effect
                      ArceusA2Effect();
              }
           }
          //Phase 4: Shoot other meteor light
           if (ArceusA2Act == 4)
          {
                 ArceusLight3.setLocation (ArceusLight3.getX()-10,ArceusLight3.getY() + 20);
                 //After a certain height, restart all variables
                if (ArceusLight3.getY() >= 700)
              {
                  ArceusA2Act = 0;
                  ArceusDelay = 0;
                  ArceusAct = 1;
                    ArceusLight2.setLocation (950,-200);
         ArceusLight3.setLocation (400,-200);
           Arceus.setSize (71,100);
           Arceus.setIcon(ArceusIcon);
              ArceusA2Clip.stop();


              }
           }
          //Meteor lights to User Collision
          if (ArceusA2Act == 3 || ArceusA2Act == 4)
          {
              //Light1 hit User
              if (ArceusLight2.getY()+ArceusLight2.getHeight() > 0 && DeadArceus == false && UserInvincibility == 0 && ArceusLight2.getX()+20 <= User.getX()+User.getWidth() && User.getX() <=  ArceusLight2.getX()+ArceusLight2.getWidth() - 20  && ArceusLight2.getY() + 20 <= User.getY()+User.getHeight() && ArceusLight2.getY() +  ArceusLight2.getHeight() - 20 >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
              //Light2 hits user
              if (ArceusLight3.getY()+ArceusLight3.getHeight() > 0 && DeadArceus == false && UserInvincibility == 0 && ArceusLight3.getX()+20 <= User.getX()+User.getWidth() && User.getX() <=  ArceusLight3.getX()+ArceusLight3.getWidth() - 20  && ArceusLight3.getY() + 20 <= User.getY()+User.getHeight() && ArceusLight3.getY() +  ArceusLight3.getHeight() - 20 >= User.getY() )
              {
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
          }

          //ARCEUS ATTACK 3 - JUDGEMENT --------------------------------------------------------------
          //Phase 1: Initialize varaibles
          if (ArceusA3Act == 1)
          {
              ArceusDelay = 0;
              ArceusA3HLSize = 1;
              ArceusHLight.setLocation(1390,0);
              ArceusHLight.setSize(400,1);
          
              ArceusA3Act = 2;
             //Charge up
             ArceusA3Effect2();
          }
          //Phase 2: Move left
            if (ArceusA3Act == 2)
          {
                Arceus.setLocation (Arceus.getX() - 20,Arceus.getY());
                if (Arceus.getX() <= 700)
                {
                    //Advance
                    ArceusA3Act = 3;
                    Arceus.setIcon(ArceusA3Icon);
                    Arceus.setSize(83,100);
                 
                }
            }

          //Phase 3: Prepare for an epic attack
  if (ArceusA3Act == 3)
          {
      ArceusDelay += 1;
      if (ArceusDelay >= 30)
      {
          //Advance after time
           ArceusA3Effect();
          ArceusA3Act = 4;
          ArceusHLight.setLocation ((Arceus.getX() + (Arceus.getWidth())/2)-200, 0);
      }
  }
          //Phase 4: Shoot down awesome light from the sky
           if (ArceusA3Act == 4)
          {
               //Increase Light size over time
               if (ArceusA3HLSize <= 3537)
                        {
               ArceusA3HLSize += 50;
              }
 else
               {
                   ArceusHLight.setLocation (ArceusHLight.getX(),ArceusHLight.getY() + 50);
                }
          //Set size to icon
               ArceusHLight.setSize(400,ArceusA3HLSize);

               //After light is greater than 1000, advance
               if (ArceusHLight.getY() >= 1000)
               {
                   ArceusA3Act = 5;
               }

           }
          //Phase 6: Move back
          if (ArceusA3Act == 5)
          {
              //Move back to position
                if (Arceus.getX() < 1150)
          {
                    Arceus.setLocation (Arceus.getX() + 20,Arceus.getY());
                }
 else {
                    //After in position, Restart variables
                    ArceusA3HLSize = 0;
                    ArceusA3Act = 0;
                    ArceusAct = 1;
                     Arceus.setSize (71,100);
           Arceus.setIcon(ArceusIcon);

             ArceusA3Clip.stop();
                    
 }
          }
          //User to Judgement Collision
          if (ArceusA3Act == 4 || ArceusA3Act == 5)
          {

                if (DeadArceus == false && UserInvincibility == 0 && ArceusHLight.getX() <= User.getX()+User.getWidth() && User.getX() <=  ArceusHLight.getX()+ArceusHLight.getWidth()  && ArceusHLight.getY()  <= User.getY()+User.getHeight() && ArceusHLight.getY() +  ArceusHLight.getHeight() >= User.getY() )
              {
                    //Lose a health
             UserHealth -= 1;
                  //User Lose
                   if (UserHealth <= 0 )
                       {
                           CheckHealth();
                       }
                    else {

                      UserInvincibility = 1;
                          }
              }
                if (DeadArceus == false  && ArceusHLight.getX() <= Bullet[0].getX()+Bullet[0].getWidth() && Bullet[0].getX() <=  ArceusHLight.getX()+ArceusHLight.getWidth()  && ArceusHLight.getY()  <= Bullet[0].getY()+Bullet[0].getHeight() && ArceusHLight.getY() +  ArceusHLight.getHeight() >= Bullet[0].getY() )
              {
           BulletActive = false;
                 Bullet[0].setVisible(false);
                  Bullet[0].setLocation(1400,0);
              }


          }
          }

          //Music Timers - Restarts background music over time
   if (CScene == false && UserLose == false)
          {
              MusicTimer += 1;
         
              //Dark Star cost restart
              if (Menu == true || Shop == true || Instructions == true || HSScreen == true || GameStart == true || Winning == true)
              {
               if (MusicTimer >= 12500 )
               {
                     try{
                           StarCoreIn.close();
                        }
                        catch (Exception e)
                        {

                        }
                     StarCoreMusic();
                   MusicTimer = 0;
               }
              }
              //Solve Music restart
              if (Solve == true)
              {
                    if (MusicTimer >= 11000 && MusicClip.isRunning()  == false)
               {
                   try{
                           ThinkingIn.close();
                        }
                        catch (Exception e)
                        {

                        }
                     ThinkingMusic();
                   MusicTimer = 0;
               }
              }

          }
          //WINNING CUTSCENE -------------------------------------------------------
          if (Winning == true)
{
   //Scene 0: Initialize stuff
    if ( WinningAct == 0)
    {

        //Text
           Congratulations.setText("Congratulations! You beat the game and took back your apple!");
           //Remove bugs
        SolveEquation.setVisible(false);

tempScore = SolveEquation.getText();
//Set the score teexts
Score = Score + (2000 * UserHealth);
   SolveEquation.setText("Score: " + ScoreConverter1(Score));

  WinningText.setText("<html>" + tempScore + "<br>Health Bonus: " + (2000 * UserHealth) + "<br>Total " + SolveEquation.getText() + "</html>");
  WinningAct = 1;

  ///Put apple in right place
  Apple.setLocation(600,505);
  Apple.setVisible(true);
    }
    //Scene 1: Move user right
     if ( WinningAct == 1)
    {
            User.setLocation(User.getX()+5,505);
            //After the user is in the right location, Diisplay congratulations
        if (User.getX() >= 550)
        {
            //Set Texts visible
            Congratulations.setVisible(true);
               WoodSign.setVisible(true);
WinningText.setVisible(true);
//Play winning background music
        try{
            StarCoreIn.close();
        }
        catch (Exception e)
        {

        }
           WinningMusic();
            WinningAct = 2;
             MenuDelay = 0;
                    User.setIcon(UserWalk1);

        }
     }
    //Scene 2: Enjoy the Apple... for now
       if ( WinningAct == 2)
    {

           MenuDelay += 1;
           if (MenuDelay >= 500)
           {
               //After a delay, advance
                WinningAct = 3;
                 MewtwoA2Effect();
                  Bubble.setLocation (User.getX()+20,450);
                  Bubble.setVisible(true);
                  Bubble.setIcon(ExBubbleIcon);



           }
       }
    //Scene 3: Apple... It ran AWAY?
     if ( WinningAct == 3)
    {
         //Move apple right
            Apple.setLocation(Apple.getX()+10,Apple.getY());
            //After apple has ran away, advance
            if (Apple.getX() > 1300)
            {

                try
                {
                    WinningIn.close();
                }
                catch (Exception e)
                {

                }
                StarCoreMusic();
                Apple.setVisible(false);
                WinningAct = 4;
                //Change text
                   Congratulations.setText("<html>Congratulations! You beat the game and took back your apple<br>...BUT IT RAN AWAY AGAIN! GO TAKE IT BACK!!!<html>");
            }
     }
    //Scene 4: Run, catch it!
     if ( WinningAct == 4)
    {
         //Run right
              User.setLocation(User.getX()+5,505);
              //Exclaimation
               Bubble.setLocation (User.getX()+20,450);
               //After user is off the screen, allow user to advance by pressing Z
               if (User.getX() > 1600)
               {
                   WinningAct = 5;
                     WinningText.setText("<html>" + tempScore + "<br>Health Bonus: " + (2000 * UserHealth) + "<br>Total " + SolveEquation.getText() + "<br>Press Z to Continue</html>");
               }

     }
}


      }
       };
  new Timer(delay, UserMovePerformer).start();
//END MAIN TIMER --------------------------------------------------------------------------------------------------


//SPRITE TIMER - Used mostly for animation of movement --------------------
   int spritedelay = 250; //milliseconds
  ActionListener SpritePerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          //Do the walking animation EXCEPT FOR SPECIFIC PARTS IN CUTSCENES
          
 if (CScene == false && Winning == false || CSceneAct == 4|| Winning == true && WinningAct != 2 && WinningAct != 3)
 {

     //Sprite number indicates which image to display
     //When SpriteNumer is 1, input image 1
      if (SpriteNumber == 1 ){
          SpriteNumber = 2;

             User.setIcon (UserWalk2);
      }
      //Sprite 2
    else if (SpriteNumber == 2 && UserJump == false)
        {

    SpriteNumber = 3;
     User.setIcon (UserWalk1);
        }
      //Sprite 3
      else if (SpriteNumber == 3 )
        {

    SpriteNumber = 4;
        User.setIcon (UserWalk3);
        }
      //Repeat back to 1
      else if (SpriteNumber == 4 && UserJump == false)
        {

    SpriteNumber = 1;

          User.setIcon (UserWalk1);
        }

      }
 else 
 {
     //Sleeping Pikachu Animation
     if (CSceneAct == 0 || CSceneAct == 1 && CSceneDelay < 90)
   
     {
         SpriteNumber += 1;
         //Change to Sleep 2
     if (SpriteNumber == 1)
     {
        
          PikaSleepImage = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaSleep2.png")));
          User.setIcon (PikaSleepImage);

     }
         //Change to sleep 1
 else if (SpriteNumber == 4)
     {
      PikaSleepImage = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaSleep.png")));
      User.setIcon (PikaSleepImage);
   
 }
         //Reset to sprite 0;
          else if (SpriteNumber == 9)
     {
              SpriteNumber  = 0;
          }
     }
 }
      }
       };
  new Timer(spritedelay, SpritePerformer).start();
// END SPRITE TIMER ---------------------------------------------------------------------------------------
  //Platform Timer (This is to move most platforms, the floor and anything else coming at you) ---------------------------------------------------
   int Platdelay = 20; //milliseconds
  ActionListener PlatformPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          //Only happen if Gamestart
          if (GameStart == true)
          {
              //And if you're still alive
               if (UserLose == false)
       {
                   if (Spring[0].getX() > -200)
                   {
                   //Moves the spring at the start
                Spring[0].setLocation (Spring[0].getX()-BackSpeed,Spring[0].getY());
           }
                for (int i = 0; i < 6;i++)
                     {
                       //Moves all floors
                       
                         if (Floor[i].getX() + Floor[i].getWidth() >= -100)
                         {
                           Floor[i].setLocation (Floor[i].getX()-BackSpeed,Floor[i].getY());
                         }
                         //Moves all platforms
                          if (Platform[i].getX() +  Platform[i].getWidth() >= -100)
                         {
                         Platform[i].setLocation (Platform[i].getX()-BackSpeed,Platform[i].getY());
                         }
                         //Moves user if on platform
                          if (OnPlatform[i] == true && User.getX() - BackSpeed >  -20){
                       User.setLocation(User.getX()-BackSpeed,User.getY());

                          }
                        
                     }

                   

       }
          }
                 }
       };
  new Timer(Platdelay, PlatformPerformer).start();
// END Platorm Timer --------------------------------------------------------------------------------------------------------------------
//Event Timer - This is to: Make screen faster over time and some enemies
  int Eventdelay = 100; //milliseconds
  ActionListener EventPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
//Only work if game started
          if (GameStart == true)
          {
             int DecideEquation = 0;
             EventTimer += 1;
        
            
//After 50 counts of BackspeedIncreaseTimer, Increase the speed of everything in the background
              //Increase the counter
        BackSpeedIncreaseTimer += 1;
    
        //When it is equal to 50,
    if (BackSpeedIncreaseTimer == (50 + BackSpeedSlowDown))
    {
        //Increase speed and restart
    BackSpeedIncreaseTimer = 0 ;
    if (BackSpeed < 15)
    {
    BackSpeed += 1;
        BackSpeedSlowDown += 10;
    if(BackSpeed >= 7)
    {
        //Increases the time required for a speed increase
        BackSpeedSlowDown += 10;
    }
        //Time increased, increases over time
           if(BackSpeed >= 10)
    {
        BackSpeedSlowDown += 15;
    }
            if(BackSpeed >= 12)
    {
        BackSpeedSlowDown += 20;
    }
        //Spawn slightly more platforms over time
    if (BackSpeedIncreaseCounter < 9)
         {
    BackSpeedIncreaseCounter+=1 ;
        }
      }
    }


   
     if (UserLose == false){
             //Decide Equation
         DecideEquation = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
         //Score increases over time
         Score += 1;
         //Spawns Platform or Floor after timer has reached a certain point
            EventTimerPlatform += 1;
              EventTimerFloor += 1;
     }
       
             //Platform spawner
   if (EventTimerPlatform == RandPlatformX)
   {
       if (User.getY() >= 480 || OnPlatform[0] == false && OnPlatform[1] == false && OnPlatform[2] == false && OnPlatform[3] == false && OnPlatform[4] == false && OnPlatform[5] == false && User.getY() >= 250 )
       {
           //Gets a random Y value for platform
       RandPlatformY = (int)Math.floor(Math.random() * (430 - 200 + 1) + 200);
       }
 else
       {
             RandPlatformY = (int)Math.floor(Math.random() * (400 - 70 + 1) + 70);
 }

       //Gets a random X value for platform
        RandPlatformX = (int)Math.floor(Math.random() * (20 - BackSpeedIncreaseCounter - 10 - BackSpeedIncreaseCounter + 1) + 15);
        //Specifies which platform to spawn
       PlatformNumber += 1;
       //Maximum of only 5 platforms on the screen
       if (PlatformNumber > 5)
       {
           PlatformNumber = 0;
       }
     //Spawn the platform at a random Y value
          Platform[PlatformNumber].setLocation (1400,RandPlatformY);

         
       


         //Add the platforms

          
        
    
     

        //Restart platform Timer
        EventTimerPlatform = 0;



   }

        //Decide Equation - Each Score converter makes a different type
  if (DecideEquation == 1)
          {
               SolveEquation.setText("Score: " + ScoreConverter1(Score));
              
          }
   else if (DecideEquation == 2){

        SolveEquation.setText("Score: " + ScoreConverter2(Score));
            }
 else if (DecideEquation == 3){

      SolveEquation.setText("Score: " + ScoreConverter3(Score));
 }


        //Spawns random Floors
if (EventTimerFloor >= RandFloorX && Floor[FloorNumber].getX() + Floor[FloorNumber].getWidth() <= 1200)
{
    //Indicates which floor to spawn
    FloorNumber += 1;

    //Only maximum of 5 floors at a time
 if (FloorNumber > 5)
       {
           FloorNumber = 0;
       }

       //Get a random floor X value
          RandFloorX = (int)Math.floor(Math.random() * (75 - 15 + 1) + 15);
          //Get a random Floor size
      RandFloorSize = (int)Math.floor(Math.random() * (3000  - 500  + 1) + 1000);
      //Set the Floor icon according to the floor size
           FloorIcon = new ImageIcon (ScaledImage( FloorImage, RandFloorSize,690));

        //Display floor
            Floor[FloorNumber].setLocation (1390,555);
      Floor[FloorNumber].setSize(RandFloorSize,690);
         Floor[FloorNumber].setIcon(FloorIcon);
     


     //Spawn Enemy 1 (Charmander) Note: it is here because Charmander must always spawn with the floor
      SpawnEnemy1 = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);

      //If valid to spawn
           if (DeadEnemy1 == true && SpawnEnemy1 == 3 || Enemy1.getX() < -100 && SpawnEnemy1 == 3)
         {
               //Spawn the Charmander
                   DeadEnemy1 = false;
                  Enemy1.setLocation(Floor[FloorNumber].getX() + Floor[FloorNumber].getWidth() - (int)Math.floor(Math.random() * (450 - 75 + 1) + 75), 505);
               
                  
         }

      //Spawn Enemy 3 (Golem) Note: It is here because Golem must spawn on the floor
       SpawnEnemy3 = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
      
       //If it is valid to spawn
  if ( DeadEnemy3 == true && SpawnEnemy3 == 3  && Score >= 50|| Enemy3.getX() < -100 && SpawnEnemy3 == 3)
         {
      //Spawn the Golem
        DeadEnemy3 = false;
        Enemy3.setLocation(Floor[FloorNumber].getX() + (Floor[FloorNumber].getWidth()/2) , 475);
        Enemy3Health = 3;

    }



EventTimerFloor = 0;


}

//Spawn the actuall floor
if (EventTimerFloor == 10)
{

 
      
       //Spawns Enemy1 (Charmander) with the floor
       if (DeadEnemy1 == false)
       {
       //  Enemy1.setLocation(1400,505);

    }
           

     

}

 //First time BOSS SPAWNING ---------------------------------------------------------------------------
          if (EventTimerBoss <= 250)

              {
              //Increase the Timer for boss
              EventTimerBoss +=1 ;
              //After it is at a certain poimt, spawn the boss
               if (EventTimerBoss == 250 && MewtwoAct == 0 && DeoxysAct== 0 && ArceusAct == 0)
          {
             RandomBoss = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);

             //If RandomBoss is 1, Spawn Mewtwo
             if (RandomBoss == 1)
             {
                 MewtwoAct = 1;
                 Mewtwo.setLocation (1390,200);
             }
              //If RandomBoss is 2, Spawn Deoxys
    else if (RandomBoss == 2)
             {
                 DeoxysAct = 1;
                 Deoxys.setLocation (1390,200);
             }
              //If RandomBoss is 3, Spawn Arceus
              else if (RandomBoss == 3)
             {
                 ArceusAct = 1;
                 Arceus.setLocation (1390,200);
             }
          }

          }

          }





      }

       };
  new Timer(Eventdelay, EventPerformer).start();
//END EVENT TIMER --------------------------------------------------------
//Spawner for Enemy 2 (Beedrill) and Enemy 4 (Pidegeotto) Note: They can be spawned at anytime which is why they are here ------
     int spawnerdelay = 3000; //milliseconds
  ActionListener SpawnerPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          //Only spawn if Game start
          if (GameStart == true)
          {
              //And if User didn't lose
          if (UserLose == false)
          {
              //Random Enemy gets a random Enemy
           RandomEnemy =  (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
           //If Random Enemy is 1, Spawn Enemy 2 (Beedrill)
           if (RandomEnemy == 1 && DeadEnemy2 == true)
           {
               //Spawn it
               Enemy2Act = 1;
               DeadEnemy2 = false;

        Enemy2.setSize(80,80);
        Enemy2.setLocation(1390,350);

               
           }
           //If Random Enemy is 2, Spawn Enemy 4 (Pidgeotto)
 else if (RandomEnemy == 2 && DeadEnemy4 == true || RandomEnemy == 2 && Enemy4.getX() <= -100 && Enemy4Act == 0)
           {
     //Spawn it
      Enemy4Act = 1;
            DeadEnemy4 = false;

        Enemy4.setSize(80,60);
        Enemy4.setLocation(1390,100);
       Enemy4Bullet.setLocation (1400,100);

            }
          }
      }
      }
       };
  new Timer(spawnerdelay, SpawnerPerformer).start();
//END Spawner Timers -----------------------------
  //END OF ALL TIMERS ------------------------------------------------------------------------------------------------------------------

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
              
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
      

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                     
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                   
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                  
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                   
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                   
                }

            }




        });

        HappyMusic();
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = EquationDefenceApp.getApplication().getMainFrame();
            aboutBox = new EquationDefenceAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);

}
        EquationDefenceApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnMultiply = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        btnDivide = new javax.swing.JButton();
        btnMinus = new javax.swing.JButton();
        btnEquals = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        txtDisplay = new java.awt.TextField();
        txtAnswer = new java.awt.TextField();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setFocusCycleRoot(true);
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mainPanelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mainPanelKeyReleased(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(equationdefence.EquationDefenceApp.class).getContext().getResourceMap(EquationDefenceView.class);
        btn1.setText(resourceMap.getString("btn1.text")); // NOI18N
        btn1.setName("btn1"); // NOI18N
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });

        btn2.setText(resourceMap.getString("btn2.text")); // NOI18N
        btn2.setName("btn2"); // NOI18N
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });

        btn3.setText(resourceMap.getString("btn3.text")); // NOI18N
        btn3.setName("btn3"); // NOI18N
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
        });

        btn4.setText(resourceMap.getString("btn4.text")); // NOI18N
        btn4.setName("btn4"); // NOI18N
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
        });

        btn6.setText(resourceMap.getString("btn6.text")); // NOI18N
        btn6.setName("btn6"); // NOI18N
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn6MouseClicked(evt);
            }
        });

        btn5.setText(resourceMap.getString("btn5.text")); // NOI18N
        btn5.setName("btn5"); // NOI18N
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });

        btn7.setText(resourceMap.getString("btn7.text")); // NOI18N
        btn7.setName("btn7"); // NOI18N
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn7MouseClicked(evt);
            }
        });

        btn8.setText(resourceMap.getString("btn8.text")); // NOI18N
        btn8.setName("btn8"); // NOI18N
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
        });

        btn9.setText(resourceMap.getString("btn9.text")); // NOI18N
        btn9.setName("btn9"); // NOI18N
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn9MouseClicked(evt);
            }
        });

        btn0.setText(resourceMap.getString("btn0.text")); // NOI18N
        btn0.setName("btn0"); // NOI18N
        btn0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn0MouseClicked(evt);
            }
        });

        btnMultiply.setText(resourceMap.getString("btnMultiply.text")); // NOI18N
        btnMultiply.setName("btnMultiply"); // NOI18N
        btnMultiply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMultiplyMouseClicked(evt);
            }
        });

        btnPlus.setText(resourceMap.getString("btnPlus.text")); // NOI18N
        btnPlus.setName("btnPlus"); // NOI18N
        btnPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlusMouseClicked(evt);
            }
        });

        btnDivide.setText(resourceMap.getString("btnDivide.text")); // NOI18N
        btnDivide.setName("btnDivide"); // NOI18N
        btnDivide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDivideMouseClicked(evt);
            }
        });

        btnMinus.setText(resourceMap.getString("btnMinus.text")); // NOI18N
        btnMinus.setName("btnMinus"); // NOI18N
        btnMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinusMouseClicked(evt);
            }
        });

        btnEquals.setText(resourceMap.getString("btnEquals.text")); // NOI18N
        btnEquals.setName("btnEquals"); // NOI18N
        btnEquals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEqualsMouseClicked(evt);
            }
        });

        btnClear.setText(resourceMap.getString("btnClear.text")); // NOI18N
        btnClear.setName("btnClear"); // NOI18N
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        btnEnter.setText(resourceMap.getString("btnEnter.text")); // NOI18N
        btnEnter.setName("btnEnter"); // NOI18N
        btnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnterMouseClicked(evt);
            }
        });

        txtDisplay.setName("txtDisplay"); // NOI18N
        txtDisplay.setText(resourceMap.getString("txtDisplay.text")); // NOI18N

        txtAnswer.setName("txtAnswer"); // NOI18N
        txtAnswer.setText(resourceMap.getString("txtAnswer.text")); // NOI18N
        txtAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(39, 39, 39)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(460, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(1058, Short.MAX_VALUE)
                .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(635, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(equationdefence.EquationDefenceApp.class).getContext().getActionMap(EquationDefenceView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    //Resize all images
        private Image ScaledImage (Image img, int w, int h) {
       BufferedImage resizedImage = new BufferedImage (w, h, BufferedImage.TYPE_INT_RGB);
       Graphics2D g2 = resizedImage.createGraphics();
       g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       g2.drawImage((Image) img, 0, 0, w, h, null);

       return resizedImage;
    }

        //Score Converters
        //X + value = Value
        public static String ScoreConverter1 (double Score){
  
     DecimalFormat x = new DecimalFormat("#.00");
          //Random number: Math.floor(Math.random() *( highNum – lowNum + 1) + lowNum
       int RandNumber = (int)Math.floor(Math.random() * (100 - 1 + 1) + 1);
        int RandNumber2 = (int)Math.floor(Math.random() * (100 - 1 + 1) + 1);
   double Term = Score*RandNumber + RandNumber2;

     return RandNumber + "x + " + RandNumber2 + " = " + x.format(Term);
        }
// X + -Value = 0
          public static String ScoreConverter2 (double Score){

     DecimalFormat x = new DecimalFormat("#.00");
          //Random number: Math.floor(Math.random() *( highNum – lowNum + 1) + lowNum
       int RandNumber = (int)Math.floor(Math.random() * (100 - 1 + 1) + 1);
  
    double Term = Score*RandNumber;

     return RandNumber + "x + (" + -Term + ") =  0" ;
        }
          //-X + value = 0
              public static String ScoreConverter3 (double Score){

     DecimalFormat x = new DecimalFormat("#.00");
          //Random number: Math.floor(Math.random() *( highNum – lowNum + 1) + lowNum
       int RandNumber = (int)Math.floor(Math.random() * (100 - 1 + 1) + 1);

      double Term = Score*RandNumber;

     return "-" + RandNumber + "x + " + Term + " =  0" ;
        }

              //Checks the health each time you are hit
              private void CheckHealth ()
             {
                  //If Userhealth is 0, Lose the game
                  if (UserHealth <= 0)
                  {
                      UserLose = true;
                      //Remove all hearts
                  for (int i = 1; i < 21; i++)
                      {
                      HealthHearts[i].setVisible(false);
                           
                      }
                     Enemy2Act = 0;

                  }

                  //Removes the appropriate Health Hearts according to your health
              if (UserHealth == 1)
              {
                              for (int i = 2; i < 21; i++)
                      {
                               HealthHearts[i].setVisible(false);
                         
                      }
              }
                else if (UserHealth == 2)
                {
                      
                            for (int i = 3; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
               else if (UserHealth == 3)
                {
                      
                           for (int i = 4; i < 21; i++)
                      {
                           HealthHearts[i].setVisible(false);
                      }
                }
               else if (UserHealth == 4)
                {
                       
                           for (int i = 5; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
               else if (UserHealth == 5)
                {
                        
                           for (int i = 6; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
                  else if (UserHealth == 6)
                {
                       
                          for (int i = 7; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
                  else if (UserHealth == 7)
                {
                         
                         for (int i = 8; i < 21; i++)
                      {
                           HealthHearts[i].setVisible(false);
                      }
                }
                  else if (UserHealth == 8)
                {
                      for (int i = 9; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }

                       
                }
                  else if (UserHealth == 9)
                {
                              for (int i = 10; i < 21; i++)
                      {
                            HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 10)
                {
                              for (int i = 11; i < 21; i++)
                      {
                           HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 11)
                {
                              for (int i = 12; i < 21; i++)
                      {
                            HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 12)
                {
                              for (int i = 13; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 13)
                {
                              for (int i = 14; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 14)
                {
                              for (int i = 15; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 15)
                {
                              for (int i = 16; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 16)
                {
                              for (int i = 17; i < 21; i++)
                      {
                              HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 17)
                {
                              for (int i = 18; i < 21; i++)
                      {
                              HealthHearts[i].setVisible(false);
                      }
                }
                   else if (UserHealth == 18)
                {
                              for (int i = 19; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }
                     else if (UserHealth == 19)
                {
                              for (int i = 20; i < 21; i++)
                      {
                             HealthHearts[i].setVisible(false);
                      }
                }


              }
//KEY PRESSED ALL KEY EVENTS -------------------------------------------------------------------------------------------------------------------------------------------
    private void mainPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainPanelKeyPressed
  if (evt.getKeyCode() == KeyEvent.VK_S && MenuDelay >= 30)
             {
      JumpSoundEffect();
  }
        //Cutscene Skipped if press any buton
                  if (CScene == true && MenuDelay > 20 && CSceneAct <= 2)
        {
                      //If pressed any button, skip to main menu and initialze its variables
                      MenuDelay = 0;
                      CSceneAct = 6;
                      Apple.setLocation (1400,0);
                      Mewtwo.setLocation (1400,0);
                      Deoxys.setLocation (1400,0);
                     Arceus.setLocation (1400,0);
                      Apple.setVisible(false);
                    Bubble.setVisible(false);
                     EquationSign.setLocation (350,75);
                             EquationSign.setVisible(true);
                             MyName.setVisible(true);
                             SpriteNumber = 1;
        WoodSign.setLocation (200,-75);
         WoodSign.setVisible(true);
         User.setIcon(UserWalk1);
         CScene = false;
         Menu = true;
            TextSign.setVisible(true);
       try {
           HappyIn.close();
       }
       catch (Exception e)
       {

       }
            StarCoreMusic();

                  }

                  //Key commands in Menu screen
        if (Menu == true && GameStart == false )
        {
            //Z Key - Continue to Shop
              if (evt.getKeyCode() == KeyEvent.VK_Z && MenuDelay >= 30)
             {
                  //Menu Delay to avoid multiply jumps
           MenuDelay = 0;
//Set display the appropriate pictures
WoodSign.setVisible(true);
EquationSign.setVisible(false);
MyName.setVisible(false);
Shop = true;
   JHighScore.setVisible(true);
Menu = false;
TextSign.setText("<html>Press Z to Start Game <br> X to go back to Main Menu </html>");
//Set save/load/HS buttons
    HighScoreButton.setVisible(true);
SaveButton.setVisible(true);
LoadButton.setVisible(true);
ClearButton.setVisible(true);
SaveLoadText.setVisible(true);

//Set Locations of the shop pictures
   SSHeart.setLocation (300,125);
    HeartPlus.setLocation ((SSHeart.getX() + (SSHeart.getWidth()/2)) - 25,SSHeart.getY() + SSHeart.getHeight());
  HeartText.setLocation (SSHeart.getX() + SSHeart.getWidth() + 10,(SSHeart.getY() + (SSHeart.getHeight()/2))-25);

       SSHeart2.setLocation (525,125);
  HeartPlus2.setLocation ((SSHeart2.getX() + (SSHeart2.getWidth()/2)) - 25,SSHeart2.getY() + SSHeart2.getHeight());
    HeartText2.setLocation (SSHeart2.getX() + SSHeart2.getWidth() + 10,(SSHeart2.getY() + (SSHeart2.getHeight()/2))-25);

    SpeedUP.setLocation (850,155);
      SpeedPlus.setLocation ( SpeedUP.getX() -25, SpeedUP.getY() +  SpeedUP.getHeight());
          SpeedMinus.setLocation ( SpeedUP.getX() +25, SpeedUP.getY() +  SpeedUP.getHeight());
            SpeedText.setLocation ( SpeedUP.getX() +  SpeedUP.getWidth() + 10, SpeedUP.getY()-35);

             }

              //Press X Key to go to instructions from Menu
               if (evt.getKeyCode() == KeyEvent.VK_X && MenuDelay >= 30)
             {
                   //Display all of the Instructions pictures
                   Screenshot.setLocation (100,50);
              MenuDelay = 0;
              //Changes Menu to false and instructions to true
             Menu = false;
             MyName.setVisible(false);
            Instructions = true;
            SolveBack.setVisible(true);
            Screenshot.setVisible(true);
            IInstructions.setVisible(true);
            ScreenshotTitle.setVisible(true);
            ScreenValue = 0;
                ScreenshotTitle.setText("The Story so Far");
                IInstructions.setText("Press Z to go to next page, X for Previous page, C to go back to Menu                                 Page: " + (ScreenValue + 1) + "/7");
                 Screenshot.setIcon(Screen0);
               }

        }
                  //Instructions Key commands
                if (Instructions == true)
                {
                    //If Pressed Z in instructions
                      if (evt.getKeyCode() == KeyEvent.VK_Z && MenuDelay >= 30 && ScreenValue < 6)
                         {
                          //Advance page
                          ScreenValue += 1;
                          MenuDelay = 0;
                            IInstructions.setText("Press Z to go to next page, X for Previous page, C to go back to Menu                                 Page: " + (ScreenValue + 1) + "/7");
                        //Page 1
                            if (ScreenValue == 1)
                          {
                              Screenshot.setIcon(Screen1);
                                ScreenshotTitle.setText("Controls");
                          }
                            //Page 2
                            else if (ScreenValue == 2)
                          {
                              Screenshot.setIcon(Screen2);
                                ScreenshotTitle.setText("Controls");
                          }
                            //Page 3
                              else if (ScreenValue == 3)
                          {
                              Screenshot.setIcon(Screen3);
                                ScreenshotTitle.setText("Gameplay");
                          }
                            //Page 4
                              else if (ScreenValue == 4)
                          {
                              Screenshot.setIcon(Screen4);
                                ScreenshotTitle.setText("Gameplay");
                          }
                            //Page 5
                           else if (ScreenValue == 5)
                          {
                              Screenshot.setIcon(Screen5);
                                ScreenshotTitle.setText("Solving Equations");
                          }
                            //Page 6
                           else if (ScreenValue == 6)
                          {
                              Screenshot.setIcon(Screen6);
                                ScreenshotTitle.setText("To Win the Game");
                          }


                      }
                      //Go back a page if pressed X
                          if (evt.getKeyCode() == KeyEvent.VK_X && MenuDelay >= 30 && ScreenValue > 0)
                         {
                          ScreenValue -= 1;
                          MenuDelay = 0;
                   IInstructions.setText("Press Z to go to next page, X for Previous page, C to go back to Menu                                 Page: " + (ScreenValue + 1) + "/7");
                          //Page 0
                   if (ScreenValue == 0)
                          {
                                ScreenshotTitle.setText("The Story so Far");
                 Screenshot.setIcon(Screen0);
                          }
                   //Page 1
                              else if (ScreenValue == 1)
                          {
                              Screenshot.setIcon(Screen1);
                                ScreenshotTitle.setText("Controls");
                          }
                   //Page 2
                             else if (ScreenValue == 2)
                          {
                              Screenshot.setIcon(Screen2);
                                ScreenshotTitle.setText("Controls");
                          }
                     //Page 3
                              else if (ScreenValue == 3)
                          {
                              Screenshot.setIcon(Screen3);
                                ScreenshotTitle.setText("Gameplay");
                          }
                   //Page 4
                              else if (ScreenValue == 4)
                          {
                              Screenshot.setIcon(Screen4);
                                ScreenshotTitle.setText("Gameplay");
                          }
                   //Page 5
                           else if (ScreenValue == 5)
                          {
                              Screenshot.setIcon(Screen5);
                                ScreenshotTitle.setText("Solving Equations");
                          }
                   //Page 6
                           else if (ScreenValue == 6)
                          {
                              Screenshot.setIcon(Screen6);
                                ScreenshotTitle.setText("To Win the Game");
                          }

                      }
                      //If Pressed C in instructions, Go back
                      if (evt.getKeyCode() == KeyEvent.VK_C && MenuDelay >= 30)
                         {
                          //Restart Everything
                          MyName.setVisible(true);
                          MenuDelay = 0;
                          ScreenValue = 0;
                             ScreenshotTitle.setText("The Story so Far");
                 Screenshot.setIcon(Screen0);
                 //Set instructions to false and Menu to true
                 Instructions = false;
                 Menu = true;

            SolveBack.setVisible(false);
            Screenshot.setVisible(false);
            IInstructions.setVisible(false);
            ScreenshotTitle.setVisible(false);

                      }


                }
//SHOP Key Commands --------------------------------------------------
         if (Shop == true && GameStart == false )
        {
             //If Pressed Clear Save file :(
 if (evt.getKeyCode() == KeyEvent.VK_Y && MenuDelay >= 30 && ClearQuestion == true)
             {
     //Clear the save file if Y
ClearQuestion = false;
              SaveLoadText.setText("");
MenuDelay = 0;
ClearButtonCode();
 }
  if (evt.getKeyCode() == KeyEvent.VK_N && MenuDelay >= 30 && ClearQuestion == true)
             {
      //Return if N
ClearQuestion = false;
              SaveLoadText.setText("");
 }

            //If Pressed X in shop, return to Main Menu
              if (evt.getKeyCode() == KeyEvent.VK_X && MenuDelay >= 30)
             {
//Display all menu stuff
                        MenuDelay = 0;
WoodSign.setVisible(true);
EquationSign.setVisible(true);
MyName.setVisible(true);
Shop = false;
   JHighScore.setVisible(false);
Menu = true;
//Hide all shop stuff
    HighScoreButton.setVisible(false);
SaveButton.setVisible(false);
LoadButton.setVisible(false);
ClearButton.setVisible(false);
SaveLoadText.setVisible(false);


   TextSign.setText("<html>Press Z to Continue <br> X to view Instructions </html>");

   SSHeart.setLocation (1400,0);
    HeartPlus.setLocation (1400,0);
  HeartText.setLocation (1400,0);

       SSHeart2.setLocation (1400,0);
  HeartPlus2.setLocation (1400,0);
    HeartText2.setLocation (1400,0);

    SpeedUP.setLocation (1400,0);
      SpeedPlus.setLocation (1400,0);
          SpeedMinus.setLocation (1400,0);
            SpeedText.setLocation (1400,0);
              }

 //If Pressed Z shop, START THE GAME!!!!! ----------------------------------------------------------------------------------------------------------------
              if (evt.getKeyCode() == KeyEvent.VK_Z && MenuDelay >= 30)
             {
                  //START THE GAME
                 GameStart = true;
                Shop = false;
     //Hide ALL Shop labels
                TextSign.setVisible(false);

WoodSign.setVisible(false);
EquationSign.setVisible(false);
MyName.setVisible(false);
SSHeart.setVisible (false);
HeartPlus.setVisible (false);
HeartText.setVisible (false);
SSHeart2.setVisible (false);
HeartPlus2.setVisible (false);
HeartText2.setVisible (false);
SpeedUP.setVisible (false);
SpeedPlus.setVisible (false);
SpeedMinus.setVisible (false);
SpeedText.setVisible (false);

    HighScoreButton.setVisible(false);
SaveButton.setVisible(false);
LoadButton.setVisible(false);
ClearButton.setVisible(false);
SaveLoadText.setVisible(false);

//Reset all Event Timers
    EventTimer = 0;
  EventTimerBoss = 0;
 SolveEquation.setVisible(true);
 JHighScore.setVisible(false);

  tempScore = null;

  //RESET ALL IMPORTANT VARIABLES (For playback after a round -------------------------
               //Set solve equation
                MenuDelay = 0;
                SolveEquation.setSize (700,100);
                SolveEquation.setLocation (900,-25);
                SolveEquation.setText("Score: 6x + 2309.00 = 0; x =");
                SolveEquation.setFont (new Font ("Serif", Font.BOLD, 25));
                SolveEquation.setForeground(Color.yellow);
  //Reset The platform Locations
         for (int i = 0; i < 6;i++)
  {
              Platform[i].setLocation (1400,300);
              Platform[i].setSize(225,60);
         }
             Platform[0].setLocation (1400,300);

             Platform[0].setSize(225,60);

   //Reset Health Hearts

for ( int i = 1; i < 11; i++){
HealthHearts[i].setIcon(HeartIcon);
HealthHearts[i].setVisible(true);
}
             //Reset HealthHearts next row
        for ( int i = 1; i < 11; i++){
HealthHearts[i+10].setIcon(HeartIcon);
HealthHearts[i].setVisible(true);
}
             //Set all HealthHearts to true
             UserHealth = MaxHealth;
         

             //Check Health
        CheckHealth();

        //Reset Floor Locations and sizes
        RandFloorSize = 1400;
        FloorNumber = 0;
          for (int i = 0; i < 6;i++)
  {
        Floor[i].setSize(RandFloorSize,690);

        Floor[i].setLocation (1400,1000);
        OnPlatform[i] = false;
      
     
                 }
   
        //Set locations of starting floors
 Floor[0].setSize(1400,690);
  Floor[0].setLocation(0,555);
  Floor[1].setSize(1400,690);
    Floor[1].setLocation (1400,1000);

    //Reset Platform Number
        PlatformNumber = 0;
        FloorNumber = 0;
       //Reset ALL Boss variables
        //Reset Mewtwo variables
          EventTimerBoss = 0;
        MewtwoHealth = 28;
        DeadMewtwo = false;
        MewtwoA1Act = 0;
        MewtwoAct = 0;
        MewtwoA2Act = 0;
        MewtwoA3Act = 0;
        MewtwoDelay = 0;
 //Reset Deoxys variables
        DeadDeoxys = false;
        DeoxysHealth = 25;
        DeoxysAct = 0;
        DeoxysA1Act = 0;
        DeoxysA2Act = 0;
        DeoxysA3Act = 0;
        DeoxysDelay = 0;
         //Reset Arceus variables
        DeadArceus = false;
        ArceusHealth = 30;
           ArceusAct = 0;
       ArceusA1Act = 0;
        ArceusA2Act = 0;
        ArceusA3Act = 0;
        ArceusDelay = 0;

         // Add Mewtwo ICons
         Mewtwo.setSize (83,100);
         Mewtwo.setLocation (1390,-200);
             Mewtwo.setIcon(MewtwoIcon);
     


                  MewtwoOrb1.setSize (80,80);
         MewtwoOrb1.setLocation (1390,200);
             MewtwoOrb1.setIcon(MewtwoOrbIcon);


         MewtwoOrb2.setSize (80,80);
         MewtwoOrb2.setLocation (1390,200);
             MewtwoOrb2.setIcon(MewtwoOrbIcon);
               MewtwoOrb2.setSize (80,80);

         MewtwoOrb3.setLocation (1390,200);
             MewtwoOrb3.setIcon(MewtwoOrbIcon);
             MewtwoOrb3.setSize (80,80);
                 
                
      //Add Deoxys Icons
      DeoxysShield.setSize (200,200);
         DeoxysShield.setLocation (1390,200);
             DeoxysShield.setIcon(DeoxysShieldIcon);
   

 Deoxys.setLocation (1390,-200);
                    Deoxys.setSize (84,100);

             Deoxys.setIcon(DeoxysIcon);


            DeoxysBeam1.setSize (107,80);
         DeoxysBeam1.setLocation (1390,200);
             DeoxysBeam1.setIcon(DeoxysBeam1Icon);
         
       
            DeoxysBeam2.setSize (0,80);
         DeoxysBeam2.setLocation (1390,200);
        

         //Add Arceus
          Arceus.setSize (100,100);
         Arceus.setLocation (1390,-200);
             Arceus.setIcon(ArceusIcon);


  ArceusLight1.setSize (80,80);
         ArceusLight1.setLocation (1390,200);
             ArceusLight1.setIcon(ArceusLBallIcon);
           
        
           ArceusLight2.setSize (200,200);
         ArceusLight2.setLocation (950,-200);
             ArceusLight2.setIcon(ArceusLBall2Icon);
      
        
           ArceusLight3.setSize (200,200);

         ArceusLight3.setLocation (400,-200);
             ArceusLight3.setIcon(ArceusLBall2Icon);
          
    

          ArceusHLight.setSize (400,1);
         ArceusHLight.setLocation (1390,0);
             ArceusHLight.setIcon(ArceusHLIcon);
         


         //Add Enemy3 (Golem) Icons
        Enemy3.setLocation(1390,475);
   

        //Add Enemy2 (Beedrill) Icons
        Enemy2.setLocation(1390,350);

        //Add Enemy4 (Pidgeotto Icons
      
        Enemy4.setLocation(1390,100);
      
        Enemy4Bullet.setLocation(1400,100);
    


//Add Bullet Icons
 Bullet[0].setLocation(1400,0);
 //Add Everything Else!!! ------
     
       Enemy1.setLocation (1390,505);
        Enemy1.setSize(50,50);
        Enemy1.setIcon(Enemy1Icon);


       
         Enemy1Bullet.setSize(20,20);
  Enemy1Bullet.setIcon(Enemy1BulletIcon);


    Background.setLocation (0,0);
        Background2.setLocation (1390,0);
  Spring[0].setLocation (1150,500);
              }
        }

                //SECRETS - Changes character at 1, 2 ,3 , 4 ,5, 6
        if (Menu == true || Shop == true || GameStart == true)
        {
            //Change character to Pikachu!
            if (evt.getKeyCode() == KeyEvent.VK_1)
             {
                 UserWalk1 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk1.png")));
                      UserWalk2 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk2.png")));
     UserWalk3 = (new javax.swing.ImageIcon(getClass().getResource("resources/PikaWalk3.png")));
BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Lightning.png")));
User.setIcon(UserWalk1);
     User.setSize(46,50);
Bullet[0].setIcon(BulletIcon);
            }
            //Change character to Mudkip!
              if (evt.getKeyCode() == KeyEvent.VK_2)
             {
                  UserWalk1 = (new javax.swing.ImageIcon(getClass().getResource("resources/MudWalk1.png")));
                      UserWalk2 = (new javax.swing.ImageIcon(getClass().getResource("resources/MudWalk2.png")));
     UserWalk3 = (new javax.swing.ImageIcon(getClass().getResource("resources/MudWalk3.png")));
     User.setIcon(UserWalk1);
          User.setSize(50,53);
BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Water.png")));

Bullet[0].setIcon(BulletIcon);
              }
            //Change character to Piplup!
 else if (evt.getKeyCode() == KeyEvent.VK_3)
             {
                  UserWalk1 = (new javax.swing.ImageIcon(getClass().getResource("resources/PiplupWalk1.png")));
                      UserWalk2 = (new javax.swing.ImageIcon(getClass().getResource("resources/PiplupWalk2.png")));
     UserWalk3 = (new javax.swing.ImageIcon(getClass().getResource("resources/PiplupWalk3.png")));
     User.setIcon(UserWalk1);
          User.setSize(44,50);
BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Water.png")));
Bullet[0].setIcon(BulletIcon);
              }
            //Change character to Treecko!
             else if (evt.getKeyCode() == KeyEvent.VK_4)
             {
                  UserWalk1 = (new javax.swing.ImageIcon(getClass().getResource("resources/TreeckoWalk1.png")));
                      UserWalk2 = (new javax.swing.ImageIcon(getClass().getResource("resources/TreeckoWalk2.png")));
     UserWalk3 = (new javax.swing.ImageIcon(getClass().getResource("resources/TreeckoWalk3.png")));
     User.setIcon(UserWalk1);
     User.setSize(63,50);
BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Leaf.png")));
Bullet[0].setIcon(BulletIcon);
              }
            //Change character to Flareon!
                 else if (evt.getKeyCode() == KeyEvent.VK_5)
             {
                  UserWalk1 = (new javax.swing.ImageIcon(getClass().getResource("resources/FlareWalk1.png")));
                      UserWalk2 = (new javax.swing.ImageIcon(getClass().getResource("resources/FlareWalk2.png")));
     UserWalk3 = (new javax.swing.ImageIcon(getClass().getResource("resources/FlareWalk3.png")));
     User.setIcon(UserWalk1);
     User.setSize(59,50);
BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/FireBall.png")));
Bullet[0].setIcon(BulletIcon);
              }
             //Change character to Magikarp!
                 else if (evt.getKeyCode() == KeyEvent.VK_6)
             {
                  UserWalk1 = (new javax.swing.ImageIcon(getClass().getResource("resources/MagiWalk1.png")));
                      UserWalk2 = (new javax.swing.ImageIcon(getClass().getResource("resources/MagiWalk2.png")));
     UserWalk3 = (new javax.swing.ImageIcon(getClass().getResource("resources/MagiWalk3.png")));
     User.setIcon(UserWalk1);
     User.setSize(71,50);
BulletIcon = (new javax.swing.ImageIcon(getClass().getResource("resources/Water.png")));
Bullet[0].setIcon(BulletIcon);
              }
        }

                  //GAME START KEY COMMANDS (MOVEMENT AND BULLETS) ------------------------------------------------------------------------------------------
        if (GameStart == true)
        {
            //UP DOWN LEFT RIGHT
            //Left
         if (evt.getKeyCode() == KeyEvent.VK_LEFT && UserLose == false)
             {
             ULEFT = true;
              
             }
        //RIGHT
             if (evt.getKeyCode() == KeyEvent.VK_RIGHT && UserLose == false )
             {
                     URIGHT = true;
             }
             //UP (Jump)
                if (evt.getKeyCode() == KeyEvent.VK_UP && UserAirBorne == false && UserLose == false)
             {
                 JumpSoundEffect();
                    UserJump = true;
                    UserDoubleJumpAble = false;
  

             }
             //Double Jump
            if (evt.getKeyCode() == KeyEvent.VK_UP && UserAirBorne == true  && UserDoubleJump == false && UserLose == false && UserDoubleJumpAble == true)
             {
                      JumpSoundEffect();
                    UserDoubleJump = true;
                    UserVelocity = 25;
             }
         //DOwn
          if (evt.getKeyCode() == KeyEvent.VK_DOWN && UserLose == false)
             {
                  UserAcceleration = 7;
             }
         //Bullet Shoot on Z
           if (evt.getKeyCode() == KeyEvent.VK_Z && BulletActive == false && UserLose == false)
             {
        //Shoot the bullet
                ShootSoundEffect();
                  BulletActive = true;
                  Bullet[0].setLocation(User.getX()+50,User.getY()+15);

                    Bullet[0].setVisible(true);

             }
        }
                  //WINNING CUTSCENE ADVANCE
           if (WinningAct == 5)
           {
               //If pressed Z, Restart to solving screen
                if (evt.getKeyCode() == KeyEvent.VK_Z)
             {
                    //Go to solving screen
                         Winning = false;
             MenuDelay = 0;
             UserLose = true;
             DeathDelay = 199;
            GameStart = true;
            WinningText.setVisible(false);
            Congratulations.setVisible(false);
            WoodSign.setVisible(false);
            WinningAct = 0;
            try
            {
                StarCoreIn.close();
            }
            catch (Exception e)
            {

            }
                }
           }
        
    }//GEN-LAST:event_mainPanelKeyPressed

    private void mainPanelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainPanelKeyReleased
        //Key released to stop movement
        //Stop UPDOWNLEFTRIGHT
          if (evt.getKeyCode() == KeyEvent.VK_RIGHT )
             {
                     URIGHT = false;
             }
            if (evt.getKeyCode() == KeyEvent.VK_LEFT)
             {
                     ULEFT = false;
             }
        //Allow for double jump
            if (evt.getKeyCode() == KeyEvent.VK_UP)
             {
                   
                     UserDoubleJumpAble = true;
             }
          //Lower acceleration from down
            if (evt.getKeyCode() == KeyEvent.VK_DOWN)
             {
                    
                     UserAcceleration = 2;
             }


    }//GEN-LAST:event_mainPanelKeyReleased

//CALCULATOR BUTTONS ----------------------------------------------------------------------------------------------------
    //Button 1
    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
      if (EqualsMode == false)
      {
          //Set Num to 1
       Num = 1;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
        }
 else
     //Prevent error
      {
          txtDisplay.setText (SNum + " Please select an operator!");
 }
    

    }//GEN-LAST:event_btn1MouseClicked
//Button 0
    private void btn0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn0MouseClicked
       if (EqualsMode == false)
      {
           //Set Num to 0
        Num = 0;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
        }
    else
      {
          txtDisplay.setText (Answer + " Please select an operator!");
 }
    }//GEN-LAST:event_btn0MouseClicked

    //Button 2
    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        if (EqualsMode == false)
      {
            //Set Num to 2
        Num = 2;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
       }
    else
      {
            //Prevents Errors
          txtDisplay.setText (Answer + " Please select an operator!");

 }
    }//GEN-LAST:event_btn2MouseClicked
//Button 3
    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
         if (EqualsMode == false)
      {
             //Set num to 3
        Num = 3;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
     }
    else
      {
             //Prevents Errors
          txtDisplay.setText (Answer + " Please select an operator!");

 }
    }//GEN-LAST:event_btn3MouseClicked
//Button 4
    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
           if (EqualsMode == false)
      {
               //Set Num to 4
        Num = 4;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
      }
    else
      {
               //Prevents Errors
          txtDisplay.setText (Answer + " Please select an operator!");

 }
    }//GEN-LAST:event_btn4MouseClicked

    //Button 5
    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
         if (EqualsMode == false)
      {
             //Set Num to 5
        Num = 5;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
        }
    else
      {
             //Prevents Errors
          txtDisplay.setText (Answer + " Please select an operator!");

 }
    }//GEN-LAST:event_btn5MouseClicked
    //Button 6
    private void btn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn6MouseClicked
        if (EqualsMode == false)
      {
            //Set num to 6
        Num = 6;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
     }
    else
      {
            //Prevents Errors
          txtDisplay.setText (Answer + " Please select an operator!");

 }
    }//GEN-LAST:event_btn6MouseClicked
//Button 7
    private void btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseClicked
        if (EqualsMode == false)
      {
            //Set num to 7
        Num = 7;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
     }
    else
      {
           //Prevent Error
          txtDisplay.setText (Answer + " Please select an operator!");

 }
    }//GEN-LAST:event_btn7MouseClicked

    //Button 8
    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
           if (EqualsMode == false)
      {
               //Set Num to 8
        Num = 8;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
       }
    else
      {
               //Prevents Errors
          txtDisplay.setText (Answer + " Please select an operator!");

 }
    }//GEN-LAST:event_btn8MouseClicked

    //Button 9
    private void btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseClicked
      if (EqualsMode == false)
      {
          //Set num to 9
        Num = 9;
        SNum = SNum + String.valueOf(Num);
    txtDisplay.setText (String.valueOf (SNum));
    }
    else
        //Prevents errors
      {
          txtDisplay.setText (Answer + " Please select an operator!");

 }
    }//GEN-LAST:event_btn9MouseClicked

    //Plus Button
    private void btnPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlusMouseClicked
        // Sets calculate to addmode
         if (AddMode == false && MinusMode == false && MultiplyMode == false && DivideMode == false)
        {
       
        AddMode = true;
           Answer = Integer.parseInt(SNum);
         EqualsMode = false;
      
        SNum = "";
          txtDisplay.setText (Answer + " Plus Sign Pressed!");
        }
 else
     //Prevents Errors
         {
              txtDisplay.setText (Answer + " Invalid Command!");
 }
    }//GEN-LAST:event_btnPlusMouseClicked

    //Multiply button
    private void btnMultiplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMultiplyMouseClicked
        if (MultiplyMode == false && AddMode == false && MinusMode == false && DivideMode == false)
        {

            //Sets calculator to multiply mode
        MultiplyMode = true;
           Answer = Integer.parseInt(SNum);
         EqualsMode = false;
        SNum = "";
          txtDisplay.setText (Answer + " Multiply Sign Pressed!");
        }
         else
         {
            //Prevents Errors
              txtDisplay.setText (Answer + " Invalid Command!");
 }
    }//GEN-LAST:event_btnMultiplyMouseClicked
//Sets calculator to Divide Mode
    private void btnDivideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDivideMouseClicked
        if (DivideMode == false && AddMode == false && MinusMode == false && MultiplyMode == false )
        {
            //Set calculator to divide mode
        DivideMode = true;
           Answer = Integer.parseInt(SNum);
         EqualsMode = false;

        SNum = "";
 txtDisplay.setText (Answer + " Divide Sign Pressed!");
        }
          else
         {
            //Prevents errors
              txtDisplay.setText (Answer + " Invalid Command!");
 }
    }//GEN-LAST:event_btnDivideMouseClicked

    //Minus Button
    private void btnMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusMouseClicked
        //Sets calculator to Minus mode
        if (MinusMode == false  && AddMode == false  && MultiplyMode == false && DivideMode == false)
        {
       
        MinusMode = true;
           Answer = Integer.parseInt(SNum);
         EqualsMode = false;
        SNum = "";
 txtDisplay.setText (Answer + " Minus Sign Pressed!");
        }
          else
         {
            //Prevents errors
              txtDisplay.setText (Answer + " Invalid Command!");
 }
    }//GEN-LAST:event_btnMinusMouseClicked
//Equals button
    private void btnEqualsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEqualsMouseClicked
       //Try to prevent errors
        try
        {
         if (EqualsMode == false)
        {
             //Addmode
        if (AddMode == true)
        {
            //Adds the two numbers
            txtDisplay.setText("");
            Answer += Integer.parseInt(SNum);
           
            txtDisplay.setText (String.valueOf (Answer));

       SNum = String.valueOf(Answer);
           EqualsMode = true;
           AddMode = false;
        }
        //Minus Mode
 else if (MinusMode == true)
        {
     //Subtracts one number by the other
            txtDisplay.setText("");
            Answer -= Integer.parseInt(SNum);
            
            txtDisplay.setText (String.valueOf (Answer));

         
           SNum = String.valueOf(Answer);
           EqualsMode = true;
           MinusMode = false;
        }
        //Multiply mode
         else if (MultiplyMode == true)
        {
             //Multiplies one number by another
            txtDisplay.setText("");
            Answer *= Integer.parseInt(SNum);
          
            txtDisplay.setText (String.valueOf (Answer));

        SNum = String.valueOf(Answer);
           EqualsMode = true;
           MultiplyMode = false;
        }
        //Divide mode
         else if (DivideMode == true)
        {
             //Divides one answer by another
            txtDisplay.setText("");
            Answer /= Integer.parseInt(SNum);
            
            txtDisplay.setText (String.valueOf (Answer));
        SNum = String.valueOf(Answer);
         
           EqualsMode = true;
           DivideMode = false;
        }
 else {
            //Prevents errors
             txtDisplay.setText (Answer + " (Please select an operator!)");
 }
        }
        }
        catch (Exception e)
        {
            //Prevents errors
      txtDisplay.setText (Answer + " Invalid Command!");
        }
    }//GEN-LAST:event_btnEqualsMouseClicked

    //Clear calculator button
    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
       //Restart all variables
        Num = 0;
        SNum = "";
        Answer = 0;
        txtDisplay.setText ("Cleared!");
        AddMode = false;
        MinusMode = false;
        MultiplyMode = false;
        DivideMode = false;
        EqualsMode = false;
    }//GEN-LAST:event_btnClearMouseClicked

 //Enter Button
    private void btnEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseClicked
     
//Trim data to prevent errors
String data= txtAnswer.getText().trim();
  if(!data.equals("")){

      try {
          //Compare entered to Score
          //If correct,
  if (Score == Integer.parseInt(txtAnswer.getText()))
                {
      CorrectEffect();
      //Tests if highscore
if (Score > HighScore)
{
    HighScore = Score;
  
}
//Add cashmoney
CashMoney += Score;
 JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);
Score = 0;

//Display answer
              DisplayAnswer.setText("CORRECT!");
  DisplayAnswer.setForeground(Color.green);
  MenuDelay = 0;
  //Go back to shop
  GoBackToShop = true;

  Shop = true;
CScene = false;
//Reset calculator variables
     Num = 0;
        SNum = "";
        Answer = 0;
        txtDisplay.setText ("Cleared!");
        AddMode = false;
        MinusMode = false;
        MultiplyMode = false;
        DivideMode = false;
        EqualsMode = false;
        txtAnswer.setText("");
        


       }
 else //If wrong
       {
      //Display WRONG
            DisplayAnswer.setText("WRONG!");
              DisplayAnswer.setForeground(Color.red);
             WrongEffect();

        }
      }
      catch (Exception e)
      {
          
      }
    }
    }//GEN-LAST:event_btnEnterMouseClicked

    private void txtAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswerActionPerformed
    
    }//GEN-LAST:event_txtAnswerActionPerformed

    //SHOP MOUSE CLICKED EVENTS -------------------------------------------------------
    //Increase life count
       private void HeartPlusMouseClicked (java.awt.event.MouseEvent evt){
                ClearQuestion = false;
              SaveLoadText.setText("");
              //If you have enough money
       if ( CashMoney >= HeartCost && MaxHealth < 20)
       {
           //Increase your max health and increase heart cost
            CashMoney -= HeartCost;
            HeartCost *= 1.2;
           MaxHealth += 1;
           UserHealth = MaxHealth;
           HeartText.setText("<html>Health Hearts <br> Health = " + MaxHealth + " <br> Cost to upgrade: $" + HeartCost + " </html>");
            JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);
           }
              //Max life
       if (MaxHealth == 20)
       {
            HeartText.setText("<html>Health Hearts <br> Health = " + MaxHealth + " <br> Cost to upgrade: Maxed </html> ");
       }

    }
    //Increase invincibility count
          private void HeartPlus2MouseClicked (java.awt.event.MouseEvent evt){

                   ClearQuestion = false;
              SaveLoadText.setText("");
              //If you have enough money
       if (CashMoney >= HeartCost2 && UserInvincibilityTime < 100)
       {
           //Increase invincibility time
            CashMoney -= HeartCost2;
            HeartCost2 *= 1.2;
          UserInvincibilityTime+= 5;

              HeartText2.setText("<html>Invincibility time (when hit) <br> Invincibility when hit = " + UserInvincibilityTime * 20 + " ms <br> Cost to upgrade: $" + HeartCost2 + " </html>");
            JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);
           }
              //Max invincibility
       if (UserInvincibilityTime == 100)
       {
              HeartText2.setText("<html>Invincibility time (when hit) <br> Invincibility when hit = " + UserInvincibilityTime * 20 + " ms <br> Cost to upgrade: Maxed </html>");
       }
    }
          //Speed upgrade button clicked
             private void SpeedPlusMouseClicked (java.awt.event.MouseEvent evt){
                      ClearQuestion = false;
              SaveLoadText.setText("");
              //If have enough money
       if (CashMoney >= 500 && UserSpeed < 30)
       {

           //Increase speed
            CashMoney -= 500;
              UserSpeed += 1;
                SpeedText.setText("<html>Speed (More of a preference) <br> Speed = " + UserSpeed + "<br> Cost to change: 500 </html>");
            JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);
           }
    }
             //Speed Minus button
                private void SpeedMinusMouseClicked (java.awt.event.MouseEvent evt){
                         ClearQuestion = false;
              SaveLoadText.setText("");
              //If have enough money
            if (CashMoney >= 500 && UserSpeed > 1)
       {
           //Decreae speed
            CashMoney -= 500;
              UserSpeed -= 1;
                SpeedText.setText("<html>Speed (More of a preference) <br> Speed = " + UserSpeed + "<br> Cost to change: 500 </html>");
            JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);
           }

    }

                //ON SOLVING SCREEN HELP BUTTON -------------------------------------------------------
                 private void HelpButtonMouseClicked (java.awt.event.MouseEvent evt){
                 //Display the screen shot
                     if (Screenshot.getY() == 50)
                     {

                     Screenshot.setLocation (100,0);
                     Screenshot.setVisible(true);
                     Screenshot.setIcon(Screen5);
                     HelpButton.setIcon(BackIcon);

                       //Set all of the solve stuff to not visible
                     SolveEquation.setVisible(false);
                     SolveText.setVisible(false);
                     TipGuy.setVisible(false);
                     TipGuyText.setVisible(false);
                     //Hide everything else
        btn0.setVisible(false);
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);
        btn4.setVisible(false);
        btn5.setVisible(false);
        btn6.setVisible(false);
        btn7.setVisible(false);
        btn8.setVisible(false);
        btn9.setVisible(false);
        btnClear.setVisible(false);
        btnPlus.setVisible(false);
        btnMinus.setVisible(false);
        btnMultiply.setVisible(false);
         btnDivide.setVisible(false);
           txtDisplay.setVisible(false);
         txtAnswer.setVisible(false);
         btnEquals.setVisible(false);
         btnEnter.setVisible(false);

                     }
                     //If pressed again,
             else if (Screenshot.getY() == 0)
                     {
                 //Close screen shot
                     Screenshot.setLocation (100,50);
                     Screenshot.setVisible(false);
                     Screenshot.setIcon(Screen0);
                     HelpButton.setIcon(HelpIcon);

                     //Show everything
                     SolveEquation.setVisible(true);
                     SolveText.setVisible(true);
                       btn0.setVisible(true);
                        TipGuy.setVisible(true);
                     TipGuyText.setVisible(true);
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        btn4.setVisible(true);
        btn5.setVisible(true);
        btn6.setVisible(true);
        btn7.setVisible(true);
        btn8.setVisible(true);
        btn9.setVisible(true);
        btnClear.setVisible(true);
        btnPlus.setVisible(true);
        btnMinus.setVisible(true);
        btnMultiply.setVisible(true);
         btnDivide.setVisible(true);
           txtDisplay.setVisible(true);
         txtAnswer.setVisible(true);
            btnEquals.setVisible(true);
         btnEnter.setVisible(true);
                     }
                 }
                 //RESTART VARIABLES This is to restart all variables for another playthrough -------------------------
private void RestartVar ()
    {

tempScore = null;
      //Make userJump false and User lose
             UserJump = false;
        UserLose = false;
        //Restart bullet
       BulletActive = false;
        Bullet[0].setVisible(false);
                          Bullet[0].setLocation(1400,0);

                 //Change Backspeed back to initial speed
             BackSpeed = 5;
            BackSpeedSlowDown = 0;
             BackSpeedIncreaseTimer = 0;
           BackSpeedIncreaseCounter = 0;

           //Restart spawn Enemies
           SpawnEnemy1 = 0;
           SpawnEnemy3 = 0;
           SpawnEnemy4 = 0;

           //Restart floor speed
        EventTimerFloor = 0;
 
        //RestartFloorNumber
        FloorNumber = 0;
       //RestartPlatformNumber
PlatformNumber = 0;

//PlatformTimer restart
          EventTimerPlatform = 0;
          //FloorTimer restaert
              EventTimerFloor = 0;       

              //Make Enemies all dead
        DeadEnemy1 = true;
        DeadEnemy2 = true;
        DeadEnemy3 = true;
        DeadEnemy4 = true;

        //Remove Enemy1Bullet
          Enemy1BulletTimer = 0;
           Enemy1BulletAct = false;
        

        //Change RandFloorSize back
        RandFloorSize = 1400;
       FloorNumber = 0;
        //Set size and Locations
   for (int i = 0; i < 6;i++)
  {
        Floor[i].setSize(RandFloorSize,690);

        Floor[i].setLocation (1390,555);
        OnPlatform[i] = false;
                 }
//Set Size and locations of the first two floors
 Floor[0].setLocation(0,555);
 Floor[0].setSize(1390,690);
Floor[1].setLocation(1390,555);
 Floor[1].setSize(1390,690);


//Set Enemy3 location


//Reset User location
             User.setIcon(UserWalk1);
        User.setSize(50,50);
        User.setLocation (150,505);

        //Reset lives
        if (Winning == false)
        {


UserHealth = MaxHealth;
//Reset hearts
for ( int i = 1; i < 11; i++){
HealthHearts[i].setSize (50,50);
HealthHearts[i].setLocation (i * 60 - 55,10);
HealthHearts[i].setIcon(HeartIcon);

}
        for ( int i = 1; i < 11; i++){
HealthHearts[i+10].setSize (50,50);
HealthHearts[i+10].setLocation (i * 60 - 55,60);
HealthHearts[i+10].setIcon(HeartIcon);

}
 
        CheckHealth();
  }
  //Reset platforms
          for (int i = 0; i < 6;i++)
  {
              Platform[i].setLocation (1400,400);
        OnPlatform[i] = false;
                 }

                for (int i = 0; i < 6;i++)
  {
              Platform[i].setLocation (1400,300);
              Platform[i].setSize(225,60);
         }
             Platform[0].setLocation (1400,300);

             Platform[0].setSize(225,60);


      

//Restart Enemies
             //Enemy 3 (Golem)
         Enemy3.setSize(80,80);
       Enemy3.setLocation(1400,0);
        Enemy3.setIcon(Enemy3Icon);

        //Enemy 2 (Beedrill)
        Enemy2.setSize(80,80);
        Enemy2.setLocation(1390,350);
        Enemy2.setIcon(Enemy2Icon);

        //Enemy 4 (Pidgeotto
        Enemy4.setSize(80,60);
        Enemy4.setLocation(1390,100);
        Enemy4.setIcon(Enemy4Icon);
            Enemy4Bullet.setSize(40,36);
        Enemy4Bullet.setLocation(1400,100);
        Enemy4Bullet.setIcon(Enemy4BulletIcon);


//Reset User varaiables
      
     
 Bullet[0].setLocation(1400,0);
  
     
        //Enemy 1
       Enemy1.setLocation (1390,505);
Enemy1.setSize(50,50);
Enemy1.setIcon(Enemy1Icon);

Enemy1Bullet.setLocation(1400,20);
         Enemy1Bullet.setSize(20,20);
  Enemy1Bullet.setIcon(Enemy1BulletIcon);
//Background
    Background.setLocation (0,0);
        Background2.setLocation (1390,0);
}

//BACKGROUND MUSICCCCCC!!!!!!!!!!!! -----------------------------------------------------------------------------------------------------------
private void StarCoreMusic ()
    {
       try
    {
        // open the sound file as a Java input stream
    String gongFile = "src/equationdefence/resources/DarkStarCore.wav";
   StarCoreIn = new FileInputStream(gongFile);
    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(StarCoreIn);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);

        }
    catch (Exception e)
    {

    }
}
private void ThinkingMusic ()
    {
       try
    {
        // open the sound file as a Java input stream
    String gongFile = "src/equationdefence/resources/ThinkingMusic.wav";
   ThinkingIn = new FileInputStream(gongFile);
    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(ThinkingIn);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);

        }
    catch (Exception e)
    {

    }
}

private void HappyMusic ()
    {
       try
    {
        // open the sound file as a Java input stream
    String gongFile = "src/equationdefence/resources/HappySong.wav";
   HappyIn = new FileInputStream(gongFile);
    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(HappyIn);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);

        }
    catch (Exception e)
    {

    }
}
private void WinningMusic ()
    {
       try
    {
        // open the sound file as a Java input stream
    String gongFile = "src/equationdefence/resources/WinningM.wav";
  WinningIn = new FileInputStream(gongFile);
    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(WinningIn);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);

        }
    catch (Exception e)
    {

    }
}

private void BackgroundMusic ()
    {

       try{
MusicClip = AudioSystem.getClip();
MusicClip.close();
      AudioInputStream audioInputStream = null ;
   
      //Exclaimation Sound
         if (CScene == true && CSceneAct == 1 )
     {
         
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/Exclaimation.wav"));

 }
      //Game over sound
 else if (UserLose == true && GameStart == true)
     {
       
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/GameOver.wav"));

 }
       
//Start Clip!
     MusicClip.open(audioInputStream);

     MusicClip.start( );
       

    }

   catch(Exception ex)
   {  }
}
//User Jump sound effect
   private void JumpSoundEffect ()
         {
       try{


jumpclip = AudioSystem.getClip();
jumpclip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/Jump.wav"));
     jumpclip.open(audioInputStream);

    jumpclip.start( );
    }

   catch(Exception ex)
   {
   }

       }

//User Shoot sound effect
  private void ShootSoundEffect ()
         {
       try{
shootclip = AudioSystem.getClip();
shootclip.close();
      AudioInputStream audioInputStream = null ;
    
        
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/shoot.wav"));
  
          
     shootclip.open(audioInputStream);

     shootclip.start( );
       

    }

   catch(Exception ex)
   {  }
   
       }
  //User bullet hit sound effect
    private void HitSoundEffect ()
         {
       try{
hitclip = AudioSystem.getClip();
hitclip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/hit.wav"));
     hitclip.open(audioInputStream);

     hitclip.start( );
    }

   catch(Exception ex)
   {
   }

       }
    //MewtwoAttack1 Sound effect
    private void MewtwoA1Effect ()
         {
       try{
MewtwoA1Clip = AudioSystem.getClip();
MewtwoA1Clip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/MewtwoA1OrbEffect.wav"));
     MewtwoA1Clip.open(audioInputStream);

     MewtwoA1Clip.start( );
    }

   catch(Exception ex)
   {
   }

       }

      private void WrongEffect ()
         {
       try{
WrongClip = AudioSystem.getClip();
WrongClip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/Wrong.wav"));
   WrongClip.open(audioInputStream);

WrongClip.stop();
     WrongClip.start( );
    }

   catch(Exception ex)
   {
   }

       }

       private void CorrectEffect ()
         {
       try{
CorrectClip = AudioSystem.getClip();
 CorrectClip.close();
      AudioInputStream audioInputStream = null ;

   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/Correct.wav"));
   CorrectClip.open(audioInputStream);

CorrectClip.stop();
     CorrectClip.start( );
    }

   catch(Exception ex)
   {
   }

       }


    //Mewtwo Attack 2 Sound effect
    private void MewtwoA2Effect ()
         {
       try{
MewtwoA2Clip = AudioSystem.getClip();
MewtwoA2Clip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/MewtwoA2AttackEffect.wav"));
    MewtwoA2Clip.open(audioInputStream);

     MewtwoA2Clip.start( );
    }

   catch(Exception ex)
   {
   }

       }
    //Mewtwo ATtack 3 Sound effect
    private void MewtwoA3Effect ()
         {
       try{
MewtwoA3Clip = AudioSystem.getClip();
MewtwoA3Clip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/MewtwoA3ChargeEffect.wav"));
    MewtwoA3Clip.open(audioInputStream);

     MewtwoA3Clip.start( );
    }

   catch(Exception ex)
   {
   }

       }
//Deoxys Attack 1 sound effect
    private void DeoxysA1Effect ()
         {
       try{
DeoxysA1Clip = AudioSystem.getClip();
DeoxysA1Clip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/DeoxysA1LaserEffect.wav"));
   DeoxysA1Clip.open(audioInputStream);

     DeoxysA1Clip.start( );
    }

   catch(Exception ex)
   {
   }

       }

    //Deoxys Attack 3 sound effect
    private void DeoxysA3Effect ()
         {
       try{
DeoxysA3Clip = AudioSystem.getClip();
DeoxysA3Clip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/DeoxysA3ShieldEffect.wav"));
     DeoxysA3Clip.open(audioInputStream);

   DeoxysA3Clip.start( );
    }

   catch(Exception ex)
   {
   }

       }
    //Arceus Attack 1 Sound effect
    private void ArceusA1Effect ()
         {
       try{
ArceusA1Clip = AudioSystem.getClip();
ArceusA1Clip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/ArceusA1OrbEffect.wav"));
    ArceusA1Clip.open(audioInputStream);

     ArceusA1Clip.start( );
    }

   catch(Exception ex)
   {
   }

       }
    //Arceus Attack 1 Sound effect 2
    private void ArceusA1Effect2 ()
         {
       try{
ArceusA1Clip2 = AudioSystem.getClip();
ArceusA1Clip2.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/ArceusA1OrbEffect2.wav"));
     ArceusA1Clip2.open(audioInputStream);

    ArceusA1Clip2.start( );
    }

   catch(Exception ex)
   {
   }

       }
    //Arceus Attack 2 sound effect
    private void ArceusA2Effect ()
         {
       try{
ArceusA2Clip = AudioSystem.getClip();
ArceusA2Clip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/ArceusA2MeteorEffect.wav"));
     ArceusA2Clip.open(audioInputStream);

    ArceusA2Clip.start( );
    }

   catch(Exception ex)
   {
   }

       }
    //Arceus Attack 3 Sound effect
    private void ArceusA3Effect ()
         {
       try{
ArceusA3Clip = AudioSystem.getClip();
ArceusA3Clip.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/ArceusA3Effect.wav"));
    ArceusA3Clip.open(audioInputStream);

    ArceusA3Clip.start( );
    }

   catch(Exception ex)
   {
   }

       }
    //ARceus Attack 3 sound effect 2
    private void ArceusA3Effect2 ()
         {
       try{
ArceusA3Clip2 = AudioSystem.getClip();
ArceusA3Clip2.close();
      AudioInputStream audioInputStream = null ;
   audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("resources/ArceusA3Effect2.wav"));
    ArceusA3Clip2.open(audioInputStream);

     ArceusA3Clip2.start( );
    }

   catch(Exception ex)
   {
   }

       }
//IN SHOP HIGH SCORE BUTTON PRESSED -------------------------------------------------------------------
    //Go to High score scrreen
      private void HighScoreButtonMouseClicked (java.awt.event.MouseEvent evt){
   
    //Set the layout for the Highscore screen
               ClearQuestion = false;
              SaveLoadText.setText("");
          Shop = false;
          HSScreen = true;
           HighScoreText.setVisible(true);
            HighScoreTitle.setVisible(true);
            SubmitButton.setVisible(true);
            HSBack.setVisible(true);
            HSPicture.setVisible(true);
          SolveBack.setVisible(true);
          JHighScore.setVisible(true);
             JHighScore.setText("                                    High Score: " + HighScore);
          txtAnswer.setVisible(true);
          SubmitText.setVisible(true);

           HighScoreText.setText("");
           //READ THE HIGHSCORES TEXT FILE
           try {
           
                  Reader = new BufferedReader(new FileReader("HighScores.txt"));

                  //Read a maximum of 90 lines
                   try {
              for (int i = 0; i < 90; i++)
              {
                  String EntireLine = Reader.readLine();
                  int ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                  String StringOnly = String.valueOf(EntireLine.substring(0,EntireLine.indexOf(" ",0)));

                  items oneitem = new items(StringOnly, ValueOnly);
                   ScoreList.add(oneitem);
                    }
               }
                   catch (Exception e)
                   {

                   }

                   Collections.sort(ScoreList, new Comparator<items>(){
                         public int compare(items o1, items o2)
                          {
                            //  return Integer.compare (o2.returnItemInt(),o1.returnItemInt());
                              return Integer.valueOf(o2.returnItemInt()).compareTo (o1.returnItemInt());
                        }
                  });
                  //Write the read High scores
   String WrittenText = ScoreList.get(0).returnItemStr() + " " + ScoreList.get(0).returnItemInt();
  HighScoreText.setText("<html>" + HighScoreText.getText()  + "1. " + WrittenText + "<br><html>");

     for(int i =0; i < 9; i++){
         WrittenText = ScoreList.get(i).returnItemStr() + " " + ScoreList.get(i).returnItemInt();
    HighScoreText.setText("<html>" + HighScoreText.getText() +(i + 1) + ". " + WrittenText + "<br><html>");
     }


           }
           catch (Exception e)
           {

           }

      }
      //HIGH SCORE BACK BUTTON PRESSED --------------------------------------------
       private void HSBackMouseClicked (java.awt.event.MouseEvent evt){
//GO back to shop
          Shop = true;
          HSScreen = false;
          //Hide all highscorescreen stuff
           HighScoreText.setVisible(false);
            HighScoreTitle.setVisible(false);
            SubmitButton.setVisible(false);
            SubmitAble = true;
            HSBack.setVisible(false);
            HSPicture.setVisible(false);
          SolveBack.setVisible(false);
          ErrorText.setVisible(false);
txtAnswer.setEnabled(true);
           //Focus the main panel again
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        
           JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);
         

          ScoreList.clear();
          txtAnswer.setVisible(false);
          SubmitText.setVisible(false);

           HighScoreText.setText("");
       }
       //SUBMIT BUTTON IN HIGH SCORE SCREEN -----------------------------------------------------
       private void SubmitButtonMouseClicked (java.awt.event.MouseEvent evt){
         if (SubmitAble == true)
         {
             String TestValid = txtAnswer.getText();
             //Makes sure name is valid
             if (TestValid.length() > 0 && TestValid.length() < 10 && TestValid.contains(" ") ==  false)
             {
 HighScoreText.setText("");

        //Create a writer for Highscores.txt
           try {
                 ErrorText.setVisible(false);
               SubmitAble = false;
                 BufferedWriter Writer = new BufferedWriter(new FileWriter("HighScores.txt",false));
 //for(int i =0; i < NamesandNumbers.size(); i++){

    try {
        //Write Your name and score
       for(int i =0; i < 90; i++){

      Writer.write(ScoreList.get(i).returnItemStr() + " " + ScoreList.get(i).returnItemInt() );
      Writer.newLine();

 }
               }
    catch (Exception e)
    {

    }
                 Writer.write(txtAnswer.getText() + ": " + HighScore );

Writer.close(); // finalize
System.out.println("Written");


//Read the high sscores again
HighScoreText.setText ("");
ScoreList.clear();
Reader = null;
Reader = new BufferedReader(new FileReader("HighScores.txt"));
                   try {
                       //Reads all of the lines
              for (int i = 0; i < 90; i++)
              {
                  String EntireLine = Reader.readLine();
                  int ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                  String StringOnly = String.valueOf(EntireLine.substring(0,EntireLine.indexOf(" ",0)));

                  items oneitem = new items(StringOnly, ValueOnly);
                   ScoreList.add(oneitem);
                    }
               }
                   catch (Exception e)
                   {

                   }
                   //Sort
                       Collections.sort(ScoreList, new Comparator<items>(){
                         public int compare(items o1, items o2)
                          {
                              return Integer.valueOf(o2.returnItemInt()).compareTo (o1.returnItemInt());
                        }
                  });
                  //Display sorted list onto screen
   String WrittenText = ScoreList.get(0).returnItemStr() + " " + ScoreList.get(0).returnItemInt();
  HighScoreText.setText("<html>" + HighScoreText.getText()  + "1. " + WrittenText + "<br><html>");

     for(int i =0; i < 9; i++){
         WrittenText = ScoreList.get(i).returnItemStr() + " " + ScoreList.get(i).returnItemInt();
    HighScoreText.setText("<html>" + HighScoreText.getText() +(i + 1) + ". " + WrittenText + "<br><html>");
     }
  txtAnswer.setEnabled(false);

           }
           catch (Exception e)
           {
           }
             }
 else
             {
                 //Prevents Illegal names
                    ErrorText.setVisible(true);
 }
           }
       }
       //SAVE LOAD CLEAR BUTTONS --------------------------------------------------------------------------
       //Save button Pressed
  private void SaveButtonMouseClicked (java.awt.event.MouseEvent evt){
           ClearQuestion = false;
              SaveLoadText.setText("");
       try {
                //Save high score
                 BufferedWriter SaveWriter = new BufferedWriter(new FileWriter("SaveFile.txt",false));
                 SaveWriter.write("HighScore " + HighScore);
                 SaveWriter.newLine();

                  //Save Cashmoney
                 SaveWriter.write ("Cashmoney " + CashMoney);
                 SaveWriter.newLine();

                  //Save Health
                 SaveWriter.write("MaxHealth " + MaxHealth);
                 SaveWriter.newLine();

                  //Save Heart cost
                 SaveWriter.write("HeartCost " + HeartCost);
                 SaveWriter.newLine();

                  //Save Invincibility TIme
                 SaveWriter.write("InvincibilityTime " + UserInvincibilityTime);
                 SaveWriter.newLine();

                  //Save Invincibility cost
                 SaveWriter.write("HeartCost2 " + HeartCost2);
                 SaveWriter.newLine();

                 //Save Speed
                 SaveWriter.write ("Speed " + UserSpeed);

                 //Write Successfully saved
                 SaveLoadText.setText("Successfully Saved!");
                 SaveWriter.close();
      }
       catch (Exception e)
       {

       }


  }
  //LOAD BUTTON! -------------------------------------------------
        private void LoadButtonMouseClicked (java.awt.event.MouseEvent evt){
          
             ClearQuestion = false;
              SaveLoadText.setText("");

             
           try {
               //Display Successfully loaded!
                SaveLoadText.setText("Successfully Loaded!");
                 BufferedReader LoadReader = new BufferedReader(new FileReader("SaveFile.txt"));

                 //Load High score
                   String EntireLine = LoadReader.readLine();
                  int ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 HighScore = ValueOnly;

                 //Load Cash
                 EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 CashMoney = ValueOnly;
                 
                  JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);

                  //Load Health
                   EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 MaxHealth = ValueOnly;
                 UserHealth = ValueOnly;

                 //Load Health cost
                 EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 HeartCost = ValueOnly;

                  HeartText.setText("<html>Health Hearts <br> Health = " + MaxHealth + " <br> Cost to upgrade: $" + HeartCost + " </html>");

                  //Load Invincibility TIme
                    EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 UserInvincibilityTime = ValueOnly;

                 //Load HeartCost2
                  EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 HeartCost2 = ValueOnly;

                  HeartText2.setText("<html>Invincibility time (when hit) <br> Invincibility when hit = " + UserInvincibilityTime * 20 + " ms <br> Cost to upgrade: $" + HeartCost2 + " </html>");

                  //Load Speed
                 EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 UserSpeed = ValueOnly;
                  SpeedText.setText("<html>Speed (More of a preference) <br> Speed = " + UserSpeed + "<br> Cost to change: 500 </html>");
                  

            }
           catch (Exception e)
           {

           }


        }

        //Clear Button in shop to clear save file completely
  private void ClearButtonMouseClicked (java.awt.event.MouseEvent evt){
//Ask if you are sure
      ClearQuestion = true;
      SaveLoadText.setText("This will clear your save file. Are you sure? (Y/N)");

  }
 private void ClearButtonCode (){
          //Inital Values on first playthrough
       //     HighScore 0
        //Cashmoney 500
        //MaxHealth 3
        //HeartCost 500
        //InvincibilityTime 50
        //HeartCost2 500
        //Speed 10
     try
     {
       BufferedWriter SaveWriter = new BufferedWriter(new FileWriter("SaveFile.txt",false));
                //Set Highscore to 0;
                 SaveWriter.write("HighScore " + 0);
                 SaveWriter.newLine();

                 //Set Cashmoney to 500
                 SaveWriter.write ("Cashmoney " + 500);
                 SaveWriter.newLine();

                 //Set Maxhealth to 3
                 SaveWriter.write("MaxHealth " + 3);
                 SaveWriter.newLine();

                 //Set HeartCost to 500
                 SaveWriter.write("HeartCost " + 500);
                 SaveWriter.newLine();

                 //Set Invincibility Time to 50
                 SaveWriter.write("InvincibilityTime " + 50);
                 SaveWriter.newLine();

                 //Set Heartcost2 to 500
                 SaveWriter.write("HeartCost2 " + 500);
                 SaveWriter.newLine();

                 //Set Speed to 10
                 SaveWriter.write ("Speed " + 10);


                 SaveWriter.close();

                 /// Load After cleared

                   BufferedReader LoadReader = new BufferedReader(new FileReader("SaveFile.txt"));
                   String EntireLine = LoadReader.readLine();
                  int ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 HighScore = ValueOnly;


                 EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 CashMoney = ValueOnly;

                  JHighScore.setText("Cash: $" + CashMoney + "     High Score: " + HighScore);

                   EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 MaxHealth = ValueOnly;
                 UserHealth = ValueOnly;

                 EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 HeartCost = ValueOnly;

                  HeartText.setText("<html>Health Hearts <br> Health = " + MaxHealth + " <br> Cost to upgrade: $" + HeartCost + " </html>");

                    EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 UserInvincibilityTime = ValueOnly;

                  EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 HeartCost2 = ValueOnly;

                  HeartText2.setText("<html>Invincibility time (when hit) <br> Invincibility when hit = " + UserInvincibilityTime * 20 + " ms <br> Cost to upgrade: $" + HeartCost2 + " </html>");

                 EntireLine = LoadReader.readLine();
                 ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ",0)+1))));
                 UserSpeed = ValueOnly;

                  SpeedText.setText("<html>Speed (More of a preference) <br> Speed = " + UserSpeed + "<br> Cost to change: 500 </html>");
                    SaveLoadText.setText("Sucessfully Cleared!");


     }
     catch (Exception e)
     {

     }

    }



    /**
     * @return the Background
     */
    public JLabel getBackground() {
        return Background;
    }

    /**
     * @param Background the Background to set
     */
    public void setBackground(JLabel Background) {
        this.Background = Background;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDivide;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnEquals;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnMultiply;
    private javax.swing.JButton btnPlus;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private java.awt.TextField txtAnswer;
    private java.awt.TextField txtDisplay;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}

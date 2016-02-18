package edu.ucsb.cs56.projects.games.dealer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.lang.*;

/** GamesDealerPanel GUI for games-dealer project

    @author Tristan Starck and Kelly Bielaski
    @version CS56, Winter 2016, UCSB

*/


public class GamesDealerPanel extends JPanel{
    DealerPanelHelper helper;
    JTextField playerInput;
    String shuffledAns;
    static JScrollPane cardDisplay;
    static JScrollPane scroller;
    JPanel cardOutputPanel;
    static JTextArea outputText;
    JPanel playerPrompt;
    JPanel display;
    Deck deck;
    JPanel playerPromptsPanel;
    JPanel playerInputsPanel;
    JTextField[] playerInputArray;
    int[] playerInputArrayInts;
    Hand[] hands;
    JButton continueButton;
    
    public GamesDealerPanel(){
	super(new BorderLayout());
	JPanel playerInputPanelLayout = new JPanel(new BorderLayout());
	JPanel playerInputPanelnumHands = new JPanel(new FlowLayout());
	JPanel cardOutputPanel = new JPanel(new BorderLayout());
	display = new JPanel();
	 
	add(playerInputPanelLayout, BorderLayout.NORTH);
	add(cardOutputPanel, BorderLayout.CENTER);

	//set up the command line prompt(label) and text field for input
	playerInput=new JTextField(5);
	String prompt="How many hands do you want? (Enter an integer greater than 0 and less than 11)";
	JLabel promptLabel=new JLabel(prompt);
	promptLabel.setLabelFor(playerInput);
	playerInputPanelnumHands.add(promptLabel);

	//playerInput= new JTextField(5);
	JPanel inputPanel = new JPanel(new FlowLayout());
	inputPanel.add(playerInput);
	playerInputPanelnumHands.add(inputPanel);
	playerInputPanelLayout.add(playerInputPanelnumHands, BorderLayout.NORTH);

	JPanel playerInputPanelShuffle=new JPanel(new FlowLayout());
	JComboBox shuffleBox;
	String shuffleOptions[] = {"don't shuffle", "shuffle once before dealing","shuffle after every set of cards is dealt"};
	shuffleBox = new JComboBox(shuffleOptions);
	 
	JLabel shuffleLabel = new JLabel("Shuffle?",JLabel.RIGHT);
	shuffleLabel.setLabelFor(shuffleBox);
	playerInputPanelShuffle.add(shuffleLabel);
	 
	JPanel shuffleBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	shuffleBoxPanel.add(shuffleBox);
	playerInputPanelShuffle.add(shuffleBoxPanel);
	playerInputPanelLayout.add(playerInputPanelShuffle, BorderLayout.SOUTH);
	//set up the pane for displaying the cards dealt
	//for displaying the images of the cards, I think we want the JScrollPane https://da2i.univ-lille1.fr/doc/tutorial-java/uiswing/components/scrollpane.html

	/*	 cardDisplay= new JScrollPane();

		 outputText= new JTextArea(1,1);
		 outputText.setLineWrap(true);
	 
		 scroller = new JScrollPane(outputText);
		 scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		 scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 
		 cardDisplay.add(scroller);
	*/
	deck=new Deck();

	JButton displayCardsButton = new JButton("Display Cards");
	displayCardsButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    shuffledAns = (String) shuffleBox.getSelectedItem();
		    playerInputArrayInts= new int[playerInputArray.length];
		    //put all the numbers read in from the playerInputArray into playerInputArrayInts
		    for(int i=0; i<playerInputArray.length;i++){
			if(playerInputArrayInts!=null){
			    try
				{
				    if(playerInputArray[i].getText()==("")){                  //if the user leaves the text field empty set the default value as 0
					playerInputArrayInts[i]=0;
				    }
				    else{
					playerInputArrayInts[i] = Integer.parseInt(playerInputArray[i].getText());
					if(playerInputArrayInts[i] < 0)
					    playerInputArrayInts[i] = 0;                       //set the default if the player asks for a negative number of cards is 0
				    }
				}
			    catch (NumberFormatException nfe)
				{
	
				    playerInputArrayInts[i] = 0;
				
				}
			}
		    }
		    cardOutputPanel.removeAll();
		    if(hands==null){
			hands= new Hand[playerInputArray.length];
		    }
		    helper=new DealerPanelHelper(playerInputArray.length, playerInputArrayInts, shuffledAns, deck, hands);
		    deck=helper.getDeck();
		    hands=helper.getHands();
		    String cards = helper.playerCardString();                              //call the helper dealer class... input is the numHands and the array of numbers that playerInputArray which is a JTextField reads in

		    JTextArea cardsTextArea = new JTextArea(cards);
		    cardsTextArea.setLineWrap(true);
		    
		    
		    JPanel cardDisplayPanel = new JPanel(new BorderLayout());
		    cardOutputPanel.add(cardDisplayPanel, BorderLayout.CENTER);
		    
		    scroller = new JScrollPane(cardsTextArea);
		    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    cardDisplayPanel.add(scroller);
		    cardOutputPanel.add(cardDisplayPanel);
		    shuffleBoxPanel.add(continueButton);
		    cardOutputPanel.revalidate();
		    cardOutputPanel.repaint();

		}
	    });
	
	JButton submit = new JButton("Submit/Reset");
	submit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    cardOutputPanel.removeAll();
		    deck=new Deck();
		    hands=null;
		    // outputText.setText(null);
		    int numHands;

		    try
			{
			    numHands = Integer.parseInt(playerInput.getText());
			    if(numHands < 1)
				numHands = 1;
			    if(numHands > 10)
				numHands = 10;
			    System.out.println(numHands);

			}
		    catch (NumberFormatException nfe)
			{
			    numHands = 1;

			}
		    System.out.println(shuffledAns);
		    playerInputArray = new JTextField[numHands];

		    GridLayout grid = new GridLayout(numHands,1,1,1);
		    playerPromptsPanel = new JPanel(grid);
      

		    //playerInputsPanel = new JPanel(new GridLayout(numHands, 1));
		
		    cardOutputPanel.add(playerPromptsPanel, BorderLayout.CENTER);
		    //cardOutputPanel.add(playerInputsPanel, BorderLayout.EAST);
	
		    for(int i=1; i<numHands+1;i++){
		   
			JTextField playerCardInput=new JTextField(5);
			playerInputArray[i-1]=playerCardInput;
			String question="Player " +i+"/"+numHands+": How many cards do you want?";
			JLabel playerPromptLabel=new JLabel(question, JLabel.RIGHT);
			playerPromptLabel.setLabelFor(playerCardInput);
			JPanel playerPromptLabelPanel = new JPanel(new BorderLayout());
			playerPromptLabelPanel.add(playerPromptLabel,BorderLayout.NORTH);
			playerPromptsPanel.add(playerPromptLabelPanel);

			//playerInput= new JTextField(5);
			JPanel playerTextFieldPanel  = new JPanel(new FlowLayout());
			playerTextFieldPanel.add(playerCardInput);
			playerPromptsPanel.add(playerTextFieldPanel);
		    }
		    cardOutputPanel.add(displayCardsButton, BorderLayout.SOUTH);
	        
		    //	outputText.append(BACMessage.GuiMessage(BAC) + "\n");
		    cardOutputPanel.revalidate();
		    cardOutputPanel.repaint();
		}
	    });
	playerInputPanelnumHands.add(submit);


	continueButton= new JButton("Continue Drawing Cards");
	continueButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    cardOutputPanel.removeAll();
		    shuffleBoxPanel.remove(continueButton);
     		    // outputText.setText(null);
		    int numHands;
		    shuffledAns = (String) shuffleBox.getSelectedItem();
		    try
			{
			    numHands = Integer.parseInt(playerInput.getText());
			    if(numHands < 1)
				numHands = 1;
			    if(numHands > 10)
				numHands = 10;
			    System.out.println(numHands);

			}
		    catch (NumberFormatException nfe)
			{
			    numHands = 1;

			}
		    System.out.println(shuffledAns);
		    playerInputArray = new JTextField[numHands];

		    GridLayout grid = new GridLayout(numHands,1,1,1);
		    playerPromptsPanel = new JPanel(grid);
      

		    //playerInputsPanel = new JPanel(new GridLayout(numHands, 1));
		
		    cardOutputPanel.add(playerPromptsPanel, BorderLayout.CENTER);
		    //cardOutputPanel.add(playerInputsPanel, BorderLayout.EAST);
	
		    for(int i=1; i<numHands+1;i++){
		   
			JTextField playerCardInput=new JTextField(5);
			playerInputArray[i-1]=playerCardInput;
			String question="Player " +i+"/"+numHands+": How many cards do you want?";
			JLabel playerPromptLabel=new JLabel(question, JLabel.RIGHT);
			playerPromptLabel.setLabelFor(playerCardInput);
			JPanel playerPromptLabelPanel = new JPanel(new BorderLayout());
			playerPromptLabelPanel.add(playerPromptLabel,BorderLayout.NORTH);
			playerPromptsPanel.add(playerPromptLabelPanel);

			//playerInput= new JTextField(5);
			JPanel playerTextFieldPanel  = new JPanel(new FlowLayout());
			playerTextFieldPanel.add(playerCardInput);
			playerPromptsPanel.add(playerTextFieldPanel);
		    }
		    cardOutputPanel.add(displayCardsButton, BorderLayout.SOUTH);
	        
		    //	outputText.append(BACMessage.GuiMessage(BAC) + "\n");
		    cardOutputPanel.revalidate();
		    cardOutputPanel.repaint();
		}
	    });
 
	//cardOutputPanel.add(submit);

	 
	 
	/*
	//create a lbs/kgs combo box
	String weightArray[] = {"Pounds", "Kilograms"};

	weightUnits = new JComboBox(weightArray);
	 
	JLabel weightUnitsLabel = new JLabel("Units",JLabel.RIGHT);
	weightUnitsLabel.setLabelFor(weightUnits);
	labelPanel.add(weightUnitsLabel);
	 
	JPanel weightUnitsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	weightUnitsPanel.add(weightUnits);
	fieldPanel.add(weightUnitsPanel);

	//create a hours text field and panel
	hoursField = new JTextField();
	hoursField.setColumns(10);	 

	JLabel hoursLabel = new JLabel("Hours Drinking",JLabel.RIGHT);
	hoursLabel.setLabelFor(hoursField);

	labelPanel.add(hoursLabel);
	 
	JPanel hoursPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	hoursPanel.add(hoursField);
	fieldPanel.add(hoursPanel); 

	//create a male/female combo box
	String genderArray[] = {"Male", "Female"};

	gender = new JComboBox(genderArray);
	 
	JLabel genderLabel = new JLabel("Gender",JLabel.RIGHT);
	genderLabel.setLabelFor(gender);
	labelPanel.add(genderLabel);
	 
	JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	genderPanel.add(gender);
	fieldPanel.add(genderPanel); 

	//create a beer label
	String number[]  = {"0","1","2","3","4","5","6","7","8","9",
	"10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};

	beer = new JComboBox(number);
	 
	JLabel beerLabel = new JLabel("# of Beers",JLabel.RIGHT);
	beerLabel.setLabelFor(beer);
	labelPanel.add(beerLabel);
	 
	JPanel beerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	beerPanel.add(beer);
	fieldPanel.add(beerPanel); 

	//create a wine label
	wine = new JComboBox(number);
	 
	JLabel wineLabel = new JLabel("Glasses of Wine",JLabel.RIGHT);
	beerLabel.setLabelFor(wine);
	labelPanel.add(wineLabel);
	 
	JPanel winePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	winePanel.add(wine);
	fieldPanel.add(winePanel); 

	//create a Hard Liquor label
	hardLiquor = new JComboBox(number);
	 
	JLabel hardLiquorLabel = new JLabel("Hard Liquor Shots",JLabel.RIGHT);
	beerLabel.setLabelFor(hardLiquor);
	labelPanel.add(hardLiquorLabel);
	 
	JPanel liquorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	liquorPanel.add(hardLiquor);
	fieldPanel.add(liquorPanel); 

	BACArea = new JTextArea(10, 20);
	BACArea.setLineWrap(true);
	BACArea.setRows(15);

	scroller = new JScrollPane(BACArea);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	display.add(scroller);

	JButton submit = new JButton("Calculate BAC");
	
	submit.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	BACArea.setText(null);
	boolean isMale;
	String gender1 = (String) gender.getSelectedItem();
	int hours;
	int weight;
	try
	{
	hours = Integer.parseInt(hoursField.getText());
	weight = Integer.parseInt(weightField.getText());

	}
	catch (NumberFormatException nfe)
	{
	hours = -1;
	weight = -1;

	}
		


	boolean isKilograms = false;
	String lbsOrKg = (String) weightUnits.getSelectedItem();
	int beer1 = Integer.parseInt( (String) beer.getSelectedItem());
	int wine1 = Integer.parseInt( (String) wine.getSelectedItem());
	int hardLiquor1 = Integer.parseInt( (String) hardLiquor.getSelectedItem());
	isMale = gender1.equals("Male") ? true : false ;
	isKilograms = lbsOrKg.equals("Kilograms") ? true : false ;
	
	double BAC = Calc.BAC(isMale, hours, weight, isKilograms, beer1, wine1, hardLiquor1);


	BACArea.append(BACMessage.GuiMessage(BAC) + "\n");
		
	}
	});
	*/
	// display.add(submit);
	  
	
    }

}

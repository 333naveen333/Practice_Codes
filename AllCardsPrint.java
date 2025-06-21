package Codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Card{
    private String cardFace;
    private String cardValue;
	public String getCardFace() {
		return cardFace;
	}
	public void setCardFace(String cardFace) {
		this.cardFace = cardFace;
	}
	public String getCardValue() {
		return cardValue;
	}
	public void setCardValue(String cardValue) {
		this.cardValue = cardValue;
	}
	@Override
	public String toString() {
		return "Card [cardFace=" + cardFace + ", cardValue=" + cardValue + "]";
	}
	
    
//    public void setCardFace(String cardFace)
//    {
//        this.cardFace=cardFace;
//    }
//    public void setcardValue(String cardValue)
//    {
//        this.cardValue=cardValue;
//    }
    
    // spades,clubs,hearts,diamonds
    // 13 -> A 2 -10 king  jack
    
}



public class AllCardsPrint
{
	public static void main(String[] args) {
	//	System.out.println("Hello World");
	//List<Card> cards=new ArrayList<>();
	List<String> cardValues=Arrays.asList("A","jack","King","Queen");//

	List<String> cardFaces=Arrays.asList("spades","clubs","hearts","diamonds");//
	//cardFaces=[];
	
	for(int j=0;j<cardFaces.size();j++)
	{
	    for(int i=1;i<=13;i++)
	    {
	    	//System.out.println(i);
	    Card c=new Card();
	    if(i==1)
	    {
	        c.setCardValue(cardValues.get(0));
	        c.setCardFace(cardFaces.get(j));
	    }
	    else if(i==11)
	    {
	         c.setCardValue(cardValues.get(1));
	        c.setCardFace(cardFaces.get(j));
	    }
	    else if(i==12)
	    {
	         c.setCardValue(cardValues.get(2));
	        c.setCardFace(cardFaces.get(j));
	    }
	    else if(i==13)
	    {
	         c.setCardValue(cardValues.get(3));
	        c.setCardFace(cardFaces.get(j));
	    }
	    else{
	    c.setCardValue(Integer.toString(i));
	    c.setCardFace(cardFaces.get(j));
	    }
	    System.out.println(c);
	}
	    
	}
	
	
}
}

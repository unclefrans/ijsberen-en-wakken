public class calculateAnswer{
	int amount_Eyes;
	
	public calculateAnswer(int Eyes){
		amount_Eyes = Eyes;
	}
	
	public int getAmountHoles(){
        return amount_Eyes % 2;
    }
	
	public int getAmountPinguins(){ 
		if(getAmountHoles() == 1)
			return 7 - amount_Eyes;
		else
			return 0;
	}
	
	public int getAmountPolarBears(){
		if(getAmountHoles() == 1)
			return amount_Eyes - 1;
		else
			return 0;
	}	
}

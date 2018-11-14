package com.example.user.romero_lotto;

public class LottoComputation {
    public int[] lottery = new int[6];
    private int[] lottoifwin = new int[6];
    private int checkMatch;
    private  String price = "";


    public LottoComputation(){

    }

    public LottoComputation(int lottoinput1,int lottoinput2,int lottoinput3,int lottoinput4,int lottoinput5,int lottoinput6){

        this.lottoifwin[0] = lottoinput1;
        this.lottoifwin[1] = lottoinput2;
        this.lottoifwin[2] = lottoinput3;
        this.lottoifwin[3] = lottoinput4;
        this.lottoifwin[4]= lottoinput5;
        this.lottoifwin[5] = lottoinput6;
    }

    public boolean checkInput(){
        boolean checkInput = false;
        for(int i = 0; i < 6 ; i++){
            for (int x = i+1; x < 6; x++ ){
                if( x!=i && lottoifwin[i] == lottoifwin[x]){
                    checkInput = true;
                }
            }
        }
        return  checkInput;
    }

    public boolean checkGreater49(){
        boolean checkInput = false;
        for(int i = 0; i < 6 ; i++){
            if(lottoifwin[i] > 49){
                checkInput = true;
            }
            else if(lottoifwin[i] < 1){
                checkInput = true;
            }
        }
        return  checkInput;
    }

    public void randomnumber() {
        int randomNum = 0;
        for (int i = 0; i < 6; i++) {
            randomNum = (int) (Math.random() * 49) + 1;
            for (int x = 0; x < i; x++) {
                if (lottery[x] == randomNum)
                {
                    randomNum = (int) (Math.random() * 49) + 1;
                    x = -1;
                }

            }
            lottery[i] = randomNum;
        }
    }



    public String checkIfWin(){
        for(int i = 0 ; i < 6 ; i++){
            for(int x = 0; x < 6; x++) {
                if (lottoifwin[i] == lottery[x]) {
                    checkMatch++;
                }
            }
        }
        if(checkMatch < 3){
            price = "No match! Please bet again!";
        }
        if(checkMatch == 3){
            price = "Congratulations you won 5,000.00!!";
        }
        else if(checkMatch == 4){
            price = "Congratulations you won 20,000.00!!";
        }
        else if(checkMatch == 5){
            price = "Congratulations you won 50,000.00!!";
        }
        else if(checkMatch == 6){
            price = "Congratulations you won Jackpot (10,000,000.00)";
        }


        checkMatch = 0;
        return price;

    }

    public int[] getLottery() {
        return lottery;
    }

    public void setLottery(int[] lottery) {
        this.lottery = lottery;
    }
}



public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        int index = 0;
		int roundScore=0;
	    int[][] score = new int[11][2];

		for (int i = 0; i < 11; i++) {
			score[i][0] = 0;
			score[i][1] = 0;
		    }
   
		
			String[] scr = bowlingCode.split("\\|"); // |要加转义字符才可以
    ////////////////////////////////////////
		   // 保存分数
	
				for (int index = 0; index < 10; index++) {
					if (scr[index].equals("X")) // X设为10
					{
						score[index][0] = 10;
					} else if (scr[index].indexOf('/') != -1) // 包括/
					{
						score[index][0] = Integer.parseInt(scr[index].substring(0, 1));
						score[index][1] = 10 - score[index][0];
					} else if(scr[index].indexOf('-') != -1){
						int a=scr[index].indexOf('-');
						if(a==0){score[index][0] = 0;
						score[index][1] = Integer.parseInt(scr[index].substring(1, 2));}
						else{
							score[index][1] = 0;
							score[index][0] = Integer.parseInt(scr[index].substring(0, 1));
						}
						
					}
					else{
						score[index][0] = Integer.parseInt(scr[index].substring(0, 1));
						score[index][1] = Integer.parseInt(scr[index].substring(1, 2));
					}
				}
			if(scr.length>10)
			{
				String  str=scr[11];
				if (str.equals("X")) // X设为10
				{
					score[10][0] = 10;
				} 
				else if(str.equals("XX"))
				{
					score[10][0] = 10;
					score[10][1] = 10;
				}else if (str.indexOf('/') != -1) // 包括/
				{
				score[10][0] = Integer.parseInt(str.substring(0, 1));
				score[10][1] = 10 - score[10][0];
				} else if(str.indexOf('-') != -1){
					int a=str.indexOf('-');
					if(a==0){score[10][0] = 0;
					score[10][1] = Integer.parseInt(str.substring(1, 2));}
					else{
						score[10][1] = 0;
						score[10][0] = Integer.parseInt(str.substring(0, 1));
						}
					
				}
				else{
				if(str.length()==2){
					score[10][0] = Integer.parseInt(str.substring(0, 1));
					score[10][1] = Integer.parseInt(str.substring(1, 2));
					}else{
					score[10][0] = Integer.parseInt(str.substring(0, 1));
					}
				}
		
		
			}
	////////////////////////////////////////////

	
	
			 for (int round = 0; round <= 9; round++) {		
			 int eachRoundScore = 0;
			// 本局全中
			if(round<9){
				if (scr[round].indexOf('X') != -1) {
				// 下局全中
				if (scr[round + 1].indexOf('X') != -1) {
				eachRoundScore = 10 + 10 + score[round + 2][0];
				} else {
					eachRoundScore = 10 + score[round + 1][0] + score[round + 1][1];
					}
				} else if (scr[round].indexOf('/') != -1) // 本局补中
					{
				eachRoundScore=10+score[round + 1][0];
				}else {
				eachRoundScore=score[round][0]+score[round][1];
				}
			}else
			{
				if(scr.length==10){
				eachRoundScore=score[round][0]+score[round][1];
				}
				else{
					if (scr[round].indexOf('X') != -1) {
						// 下局全中
							if (scr[round+1].indexOf('X') != -1) {
							eachRoundScore = 10 + 10 + score[round + 2][0];
							} else {
							eachRoundScore = 10 + score[round + 1][0] + score[round + 1][1];
							}
					} else if (scr[round].indexOf('/') != -1) // 本局补中
					{
						eachRoundScore=10+score[round + 1][0];
					}else {
							eachRoundScore=score[round][0]+score[round][1];
					}
				}
			}
	
			 roundScore += eachRoundScore;
		}
			  return roundScore;
    }

}

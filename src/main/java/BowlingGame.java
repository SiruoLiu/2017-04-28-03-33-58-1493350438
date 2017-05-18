public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        int index = 0;
	    int[][] score = new int[11][2];

		for (int i = 0; i < 11; i++) {
			score[i][0] = 0;
			score[i][1] = 0;
		    }
   
		
			String[] scr = bowlingCode.split("\\|"); // |要加转义字符才可以
            score=g.saveScore(scr);
			 for (int i = 0; i <= 9; i++) {
			 roundScore += g.getEachRoundScore(i,scr,score);
			 }
			  return roundScore;
    }
	// 保存分数
	public int[][] saveScore(String[] goalScore) {
		
				for (int index = 0; index < 10; index++) {
					if (goalScore[index].equals("X")) // X设为10
					{
						score[index][0] = 10;
					} else if (goalScore[index].indexOf('/') != -1) // 包括/
					{
						score[index][0] = Integer.parseInt(goalScore[index].substring(0, 1));
						score[index][1] = 10 - score[index][0];
					} else if(goalScore[index].indexOf('-') != -1){
						int a=goalScore[index].indexOf('-');
						if(a==0){score[index][0] = 0;
						score[index][1] = Integer.parseInt(goalScore[index].substring(1, 2));}
						else{
							score[index][1] = 0;
							score[index][0] = Integer.parseInt(goalScore[index].substring(0, 1));
						}
						
					}
					else{
						score[index][0] = Integer.parseInt(goalScore[index].substring(0, 1));
						score[index][1] = Integer.parseInt(goalScore[index].substring(1, 2));
					}
				}
			if(goalScore.length>10)
		{
			String  str=goalScore[11];
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
		return score;
	}

	// 计算每轮得分
	public int getEachRoundScore(int round, String[] goalScore, int[][] score) {// )
		int eachRoundScore = 0;
	
		// 本局全中
		if(round==10){
			eachRoundScore=score[round + 1][0] + score[round + 1][1]+score[round][0] + score[round][1];
		}
		else if(round<9){
				if (strike(goalScore[round])) {
			// 下局全中
			if (strike(goalScore[round + 1])) {
				eachRoundScore = 10 + 10 + score[round + 2][0];
			} else {
				eachRoundScore = 10 + score[round + 1][0] + score[round + 1][1];
			}
		} else if (spare(goalScore[round])) // 本局补中
		{
			eachRoundScore=10+score[round + 1][0];
		}else {
			eachRoundScore=score[round][0]+score[round][1];
		}
		}else
		{
			if(goalScore.length==10){
				eachRoundScore=score[round][0]+score[round][1];
			}
			else{
			if (strike(goalScore[round])) {
				// 下局全中
				if (strike(goalScore[round + 1])) {
					eachRoundScore = 10 + 10 + score[round + 2][0];
				} else {
					eachRoundScore = 10 + score[round + 1][0] + score[round + 1][1];
				}
			} else if (spare(goalScore[round])) // 本局补中
			{
				eachRoundScore=10+score[round + 1][0];
			}else {
				eachRoundScore=score[round][0]+score[round][1];
			}
			}
		}
		
		
		return eachRoundScore;
	}

	// 判断是否全中
	public boolean strike(String str) {
		if (str.indexOf('X') == -1)
			return false;
		else
			return true;
	}

	// 判断是否补中
	 public boolean spare(String str) {
		if (str.indexOf('/') == -1)
			return false;
		else
			return true;
	}
      
}

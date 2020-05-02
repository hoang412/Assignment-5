package application;

public class HolidayBonus extends java.lang.Object{
	
	public HolidayBonus() {
		
	}
	
	public static double[] 	calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double [data.length];
		int maxCol = 0;
		
		for (int i = 0; i < data.length;i++) {
			if (maxCol < data[i].length) {
				maxCol = data[i].length;
			}
		}
		
		for (int j = 0; j < maxCol; j++) {
			int highBonusIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
			int lowBonusIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
			
			
			// sales must be positive to get high bonus
		      if (TwoDimRaggedArrayUtility.getHighestInColumn(data, j) > 0) {  
		        bonus[highBonusIndex] += high;
		      }
		      
		      // sales must be positive and different from high to get low bonus
		      if (TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0 && highBonusIndex!=lowBonusIndex ) {
		        bonus[lowBonusIndex] += low;
		      }
		      
		      // add OTHER bonus to the other stores unless not category available if sales are positive 
		      for (int i = 0;i < data.length;i++) {
		        if (j >= data[i].length || i==highBonusIndex || i==lowBonusIndex || data[i][j] <= 0) {
		          continue;
		        } else {
		          bonus[i] += other;
		        } 
		        System.out.println();
		      }
		    }   
		    return bonus;
		  }

		  /**
		   * Calculates the total holiday bonuses
		   * 
		   * @param data the two dimensional array of store sales
		   * @param high bonus for the highest store in a category
		   * @param low bonus for the lowest store in a category
		   * @param other bonus for all other stores in a category
		   * @return the total of all holiday bonuses
		   */
		  public static double calculateTotalHolidayBonus(double[][] data, double high, double low,
		      double other) {
		    
		    double[] bonusArray = calculateHolidayBonus(data, high, low, other);
		    double total = 0;
		    
		    for (double bonus:bonusArray) {
		      total+=bonus;
		    }
		    return total;
		  }
		
		
		}
 	


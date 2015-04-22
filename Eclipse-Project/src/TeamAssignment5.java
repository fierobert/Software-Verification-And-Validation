import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TeamAssignment5{
    public static void main(String args[]) { 
    	Formulas_Version_3 formulas = new Formulas_Version_3();
        TeamAssignment5 test = new TeamAssignment5();
        String str1 = null, L = null, P = null, Q = null, R = null;
        
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
        	int input = 1;
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
            	System.out.println(line);
            	if (input == 1)
            		L = formulas.getLTL(line);
            	else if (input == 2)
            		P = formulas.getLTL(line);
            	else if (input == 3)
            		Q = formulas.getLTL(line);
            	else if (input == 4){
            		R = formulas.getLTL(line);
            		if (L != null && P != null && Q != null && R != null){
            			str1 = test.replaceFormula(test.generateFormula(L, P, Q, R));
            			sb.append(str1);
            			sb.append(System.lineSeparator());
            			System.out.println(str1);
            			
            			line = br.readLine(); //Skip one line for separation
            		}
            		input = 0;
            	}
                if (line != null)
                	line = br.readLine();
                input++;
            }
            saveResultsToFile(sb.toString());
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void saveResultsToFile(String results){
    	 try {
             FileWriter writer = new FileWriter("output.txt", true);
             writer.write(results);
             writer.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    public String not(String str1){
        str1 = "!(" + str1 + ")";
		return str1;
    }
	public String Global(String str1){
        str1 = "G (" + str1 + ")";
		return str1;
    }
	public String generateFormula(String L_LTL, String P_LTL, String Q_LTL, String R_LTL){

		String formula, A_LTL, B_LTL;
		B_LTL = not(andR(Q_LTL, not(R_LTL))) + "U(" + R_LTL + ")";
		A_LTL = not(not(R_LTL) + "U(" + andL(andR(P_LTL,not(R_LTL)),B_LTL)) + ")";
		/*-((-R_LTL)U((P_LTL ANDR -R_LTL) ANDL ((-(Q_LTL ANDR -R_LTL))UR_LTL)))*/
		formula = Global(andL(L_LTL, not(R_LTL)) + " -> "  + andL(L_LTL, A_LTL));
		formula = formula.replaceAll("\\.", "");
		
		return formula;
	}
	
	public String replaceFormula(String formula){

		formula = formula.replaceAll("l1", "a");
		formula = formula.replaceAll("l2", "b");
		formula = formula.replaceAll("l3", "c");
		formula = formula.replaceAll("p1", "d");
		formula = formula.replaceAll("p2", "e");
		formula = formula.replaceAll("p3", "y");
		formula = formula.replaceAll("q1", "z");
		formula = formula.replaceAll("q2", "h");
		formula = formula.replaceAll("q3", "i");
		formula = formula.replaceAll("r1", "j");
		formula = formula.replaceAll("r2", "k");
		formula = formula.replaceAll("r3", "l");
		formula = formula.replaceAll("<>", "F");

	
		return formula;
	}
    /**
     * Compute the &_r operation between two strings. String str1 is assumed to have a dot (".") for each state that
     * requires an AND with str2.
     * 
     * @param   str1    String that represents the LTL formula on the left side
     * @param   str2    String that represents the LTL formula that will be &r'd with str1
     * 
     * @return          Returns the andR combination of LTL formula 1 and 2 (represented by str1 and str2)
     * 
     * @author Roberto Camacho B.
     */
    public String andR(String str1,String str2){
        String toReplace = ".&(";
        str2 = str2.replaceAll("\\.", "");
        str2 = toReplace + str2 + ")";
        
        str1 = "(" + str1 + ")";
        str1 = str1.replaceAll("\\.", str2);
        
        return str1;
    }
    
    /**
     * Compute the &_l operation between two strings. String str1 is assumed to have a dot (".") for each state.
     * In this case, only the last dot will be ANDed with str2. 
     * 
     * @param   str1    String that represents the LTL formula on the left side
     * @param   str2    String that represents the LTL formula that will be &r'd with str1
     * 
     * @return          Returns the andL combination of LTL formula 1 and 2 (represented by str1 and str2)
     * 
     * @author Roberto Camacho B.
     */
    public String andL(String str1,String str2){
        String toReplace = ".&(";
        str2 = str2.replaceAll("\\.", "");
        str2 = toReplace + str2 + ")";
        
        str1 = "(" + str1 + ")";
        str1 = replaceLastDot(str1, str2);
        
        return str1;
    }
    
    /**
     * Replaces the last dot (".") in String str1 with replaceWith.
     * 
     * @param   str1            String that contains the token to be replaced
     * @param   replaceWith     String that represents the token that will replace the last dot.
     * 
     * @return  Returns str1 with the last dot replaced by replaceWith
     * 
     * @author Roberto Camacho B.
     */
    public String replaceLastDot(String str1, String replaceWith) {
        int lastIndex = str1.lastIndexOf(".");
        if (lastIndex < 0) return str1;
        String str2 = str1.substring(lastIndex).replaceFirst("\\.", replaceWith);
        return str1.substring(0, lastIndex) + str2;
    }
}
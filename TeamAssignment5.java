public class TeamAssignment5{
    public static void main(String args[]) {         
        TeamAssignment5 test = new TeamAssignment5();
        String str1, str2, str3, str4, L, P, Q, R;
        /*str1 = test.andR(L_EventualC, R_EventualC);
        str2 = test.andL(L_EventualC, R_EventualC);
		str3 = test.not(R_EventualC);
		str4 = test.andL(L_EventualC, test.not(R_EventualC));
        System.out.println(str1);
        System.out.println(str2);
		System.out.println(str3);
		System.out.println();
		System.out.println(str4);*/
		L = L_EventualC;
		P = P_EventualC;
		Q = Q_EventualC;
		R = R_EventualC;
		
		str1 = test.generateFormula(L,P,Q,R);
		System.out.println(str1);
		System.out.println();
		System.out.println();
		str2 = test.replaceFormula(str1);
		System.out.println(str2);
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
	B_LTL = not(andR(Q_LTL, not(R_LTL))) + "U " + R_LTL;
	A_LTL = not(not(R_LTL) + "U " + andL(andR(P_LTL,not(R_LTL)),B_LTL));
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
    private String replaceLastDot(String str1, String replaceWith) {
        int lastIndex = str1.lastIndexOf(".");
        if (lastIndex < 0) return str1;
        String str2 = str1.substring(lastIndex).replaceFirst("\\.", replaceWith);
        return str1.substring(0, lastIndex) + str2;
    }
    
    public static final String L_EventualC = "(l1 . & X (!l2 . U (l2 . & X (!l3 . U (l3 .)))))";//(l1^X(¬l2 U (l2 ^ X (¬l2 U (¬l3 U l3))))) 
    public static final String P_EventualC = "(p1 . & X (!p2 . U (p2 . & X (!p3 . U (p3 .)))))";//(p1^X(¬p2 U (p2 ^ X (¬p2 U (¬p3 U p3)))))
    public static final String Q_EventualC = "(q1 . & X (!q2 . U (q2 . & X (!q3 . U (q3 .)))))";//(q1^X(¬q2 U (q2 ^ X (¬q2 U (¬q3 U q3)))))
    public static final String R_EventualC = "(r1 . & X (!r2 . U (r2 . & X (!r3 . U (r3 .)))))";//(r1^X(¬r2 U (r2 ^ X (¬r2 U (¬r3 U r3))))) 
}
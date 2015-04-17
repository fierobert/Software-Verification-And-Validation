
 
public class PropositionalANDs{
    public static void main(String args[]) {         
        PropositionalANDs test = new PropositionalANDs();
        String str1, str2;
        str1 = test.andR(L_EventualC, R_EventualC);
        str2 = test.andL(L_EventualC, R_EventualC);
        System.out.println(str1);
        System.out.println(str2);
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
    
    public static final String L_EventualC = "(l1.&X(!l2.U(l2.&X(!l2.U(!l3.U(l3.))))))";//(l1^X(¬l2 U (l2 ^ X (¬l2 U (¬l3 U l3))))) 
    public static final String P_EventualC = "(p1.&X(!p2.U(p2.&X(!p2.U(!p3.U(p3.))))))";//(p1^X(¬p2 U (p2 ^ X (¬p2 U (¬p3 U p3)))))
    public static final String Q_EventualC = "(q1.&X(!q2.U(q2.&X(!q2.U(!q3.U(q3.))))))";//(q1^X(¬q2 U (q2 ^ X (¬q2 U (¬q3 U q3)))))
    public static final String R_EventualC = "(r1.&X(!r2.U(r2.&X(!r2.U(!r3.U(r3.))))))";//(r1^X(¬r2 U (r2 ^ X (¬r2 U (¬r3 U r3))))) 
}
